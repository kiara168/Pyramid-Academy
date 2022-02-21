import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Random;

/**
 * Game stores every relevant information about the world and the player
 * it updates the game and every goblin on it and moves to the next wave if
 * a wave is cleared
 */

public class Game {
    /**
     * constant width and height of the world map
     */
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;

    /**
     * random instance to generate random positions
     */
    private static Random random = new Random();

    /**
     * list of every entity in the world
     */
    private ArrayList<Entity> world;
    private Human player;
    private int wave;

    public Game() {
        //initiate a new world array and set the player position randomly
        world = new ArrayList<>();
        player = new Human(random.nextInt(WIDTH), random.nextInt(HEIGHT));
        //add the player to the world
        world.add(player);
        wave = 0;
        //generate the first wave
        nextWave();
    }

    /**
     * returns the entity of the world at position x and y
     * @param x the position of the world map
     * @param y the position of the world map
     * @return the entity at that position, if there is no entity null
     */
    public Entity getEntity(int x, int y) {
        Optional<Entity> entity = world.stream().filter(e -> e.getX() == x && e.getY() == y).findAny();
        if (entity.isEmpty())
            return null;
        return entity.get();
    }

    /**
     * moves every goblin in the world to the player and initiates combat if player and goblin collide
     */
    public void update() {
        //move every single goblin to the player
        world.stream().filter(x -> x instanceof Goblin).forEach(x -> findPath(x.getX(), x.getY(), player, x, new HashMap<>(), 0));

        //if a goblin and the player are on the same position they should initiate combat
        Optional<Entity> enemy = world.stream().filter(x -> x != player && x instanceof Goblin && x.getX() == player.getX() && x.getY() == player.getY()).findAny();
        if (!enemy.isEmpty()) {
            System.out.println("Combat is initiated");
            Goblin goblin = (Goblin) enemy.get();
            //the player always hits first
            goblin.setHealth(goblin.getHealth() - (float)Math.random() * 75.0f);
            System.out.println("You hit the goblin, he now has " + goblin.getHealth() + " HP left.");
            //if the player killed a goblin we remove it from the world
            if (goblin.getHealth() < 0) {
                System.out.println("You killed the goblin!");
                world.remove(goblin);

                //if there are no goblins left the player wins the current wave
                if (hasWon()) {
                    System.out.println("Congrats! You killed every goblin!");
                    //generate new wave
                    nextWave();
                }
                return;
            }

            //attack the player
            player.setHealth(player.getHealth() - (float)Math.random() * 50.0f);
            System.out.println("The goblin hit you! You now have " + player.getHealth() + " HP left.");
        }
    }

    /**
     * the game is running until the player dies
     * @return if its running
     */
    public boolean isRunning() {
        return player.getHealth() > 0;
    }

    /**
     * the wave is won if there are no goblins left to kill
     * @return if the wave is cleared
     */
    public boolean hasWon() {
        return world.stream().filter(x -> x instanceof Goblin).findAny().isEmpty();
    }

    /**
     * @return the amount of waves
     */
    public int getWaves() {
        return this.wave;
    }

    /**
     * generates a new map and goblins
     */
    public void nextWave() {
        //clear every obstacle of the previous wave
        world.clear();
        world.add(player);
        wave++;
        //generate a new goblin per wave
        for (int i = 0; i < wave; i++) {
            Goblin g = new Goblin(random.nextInt(WIDTH), random.nextInt(HEIGHT));
            //the goblin should not start on the player or in a wall
            //generate new on till he is in a free spot
            while (getEntity(g.getX(), g.getY()) != null)
                g = new Goblin(random.nextInt(WIDTH), random.nextInt(HEIGHT));
            world.add(g);
        }

        //generate 10 walls per world
        for (int i = 0; i < 10; i++) {
            Land g = new Land(random.nextInt(WIDTH), random.nextInt(HEIGHT));
            while (getEntity(g.getX(), g.getY()) != null)
                g = new Land(random.nextInt(WIDTH), random.nextInt(HEIGHT));
            world.add(g);
        }
    }

    public Human getPlayer() {
        return this.player;
    }

    /**
     * finds the shortest path to the target entity from the starting position of x, y
     * and moves the Entity entity one element along that path
     * recursive function that goes through every possible path and finds the shortest one
     * @param x starting position of the entity
     * @param y starting position of the entity
     * @param target the target where we want to move too
     * @param entity entity we want to move
     * @param path hashmap with every path and there distance to compare them and find the shortest one
     * @param distance the current path distance
     * @return the distance of the path
     */
    public int findPath(int x, int y, Entity target, Entity entity, HashMap<Integer, Integer> path, int distance) {

        //if the current position was already part of a path
        if (path.containsKey(y * WIDTH + x)) {
            //if the other path is shorter than this one we don't need to search any further
            if (path.get(y * WIDTH + x) < distance)
                return -1;
            //the current path is shorter, therefore we replace the old one
            path.remove(y * WIDTH + x);
        }
        //put the current path into the hashmap
        path.put(y * WIDTH + x, distance);

        //if we are at the target entity we can stop searching
        if (getEntity(x, y) == target)
            return distance;

        //if we are out of bounds the path is invalid
        if (x < 0 || y < 0 || x == WIDTH || y == HEIGHT)
            return -1;

        //if there is an entity on the path, the path is invalid
        if (getEntity(x, y) != null && getEntity(x, y) != entity)
            return -1;

        //because we didn't find the target we go in every direction recursively
        // and return the shortest path if any of the paths lead to the target
        int lowest = -1;
        int current_length;
        if ((current_length = findPath(x + 1, y, target, entity, path, distance + 1)) != -1) {
            //set the entity to the next position of the path
            //because we call recursively the entity ends up at the next element of the shortest path
            entity.setX(x + 1);
            entity.setY(y);
            lowest = current_length;
        }

        if ((current_length = findPath(x - 1, y, target, entity, path, distance + 1)) != -1 && distance < current_length) {
            //set the entity to the next position of the path
            //because we call recursively the entity ends up at the next element of the shortest path
            entity.setX(x - 1);
            entity.setY(y);
            lowest = current_length;
        }

        if ((current_length = findPath(x, y + 1, target, entity, path, distance + 1)) != -1 && distance < current_length) {
            //set the entity to the next position of the path
            //because we call recursively the entity ends up at the next element of the shortest path
            entity.setX(x);
            entity.setY(y + 1);
            lowest = current_length;
        }

        if ((current_length = findPath(x, y - 1, target, entity, path, distance + 1)) != -1 && distance < current_length) {
            //set the entity to the next position of the path
            //because we call recursively the entity ends up at the next element of the shortest path
            entity.setX(x);
            entity.setY(y - 1);
            lowest = current_length;
        }

        return lowest;
    }

    /**
     * converts the world and every entity on it to a string
     * @return the world as a string
     */
    @Override
    public String toString() {
        String output = "";
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                //if there is on entity on the position we place '\2022'
                if (getEntity(x, y) == null) {
                    output += "\u2022 ";
                    continue;
                }
                output += getEntity(x, y).toString() + " ";
            }
            output += "\n";
        }
        return output;
    }
}
