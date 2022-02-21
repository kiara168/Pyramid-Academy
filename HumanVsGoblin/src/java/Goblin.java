/**
 * a goblin is an entity and has 50 HP
 * is has the UTF char 'G'
 */

public class Goblin extends Entity{

        private float health;

        public Goblin(int x, int y) {
                super(x, y, 'G');
                health = 50.0f;
        }

        public float getHealth() {
                return health;
        }

        public void setHealth(float value) {
                this.health = value;
        }
}

