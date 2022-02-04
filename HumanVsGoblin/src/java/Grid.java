public class Grid {
        public int width;
        public int height;
        public int area;
        public GridPoint[][] points;
        public String winner;

        public Grid(int width, int height){
            this.width = width;
            this.height = height;
            this.area = width*height;

            this.points = new GridPoint[this.width][this.height];
        }

        public boolean addCreature(int x, int y, Creature creature){
            if (this.points[x][y] == null){
                this.points[x][y] = new GridPoint(creature);
                return true;
            } else {
                return false;
            }
        }

        public String getSizeString(){
            String size;
            size = Integer.toString(this.width)+'x'+Integer.toString(this.height);
            return size;
        }

        public boolean haveWinner(){
            boolean hasHuman=false, hasZombie=false;
            for(int y=0;y<this.height;y++){
                for(int x=0;x<this.width;x++){
                    if (this.hasCreature(x,y)){
                        Creature creature = this.points[x][y].getContent();
                        if (creature.getStatus()>0){
                            if (creature.getType()=="human") hasHuman = true;
                            if (creature.getType()=="zombie") hasZombie = true;
                        }
                    }
                }
            }

            if (!hasHuman && hasZombie){
                this.winner = "Zombies";
                return true;
            } else if (!hasZombie && hasHuman){
                this.winner = "Humans";
                return true;
            } else {
                return false;
            }

        }

        public String getWinner(){
            return this.winner;
        }

        public int getWidth(){
            return this.width;
        }

        public int getHeight(){
            return this.height;
        }

        public int getArea(){
            return this.area;
        }

        public boolean hasCreature(int x, int y){
            if (this.points[x][y] != null){
                return true;
            } else {
                return false;
            }
        }

        public void proccessCreature(int posX, int posY){
            Creature creature = this.points[posX][posY].getContent();
            Creature oponent;
            // We need to check all points/fields around this creature
            for(int x=posX-1;x<=posX+1;x++){
                if (x<0 || x>this.width-1)
                    continue;  // dont go out of boundaries

                for(int y=posY-1;y<=posY+1;y++){
                    if (y<0 || y>this.height-1)
                        continue;  // dont go out of boundaries

                    if (this.points[x][y] != null){
                        // We have found oponent
                        oponent = this.points[x][y].getContent();
                        if (creature.getType() != oponent.getType() && oponent.getStatus() >0){
                            if (creature.getStrength() > oponent.getStrength()){
                                oponent.setStatus(0);
                                if (oponent.getType() == "human") oponent.setType("zombie");
                                this.points[x][y].setContent(oponent);
                                //System.out.println(creature.getType()+" just killed "+oponent.getType()+"!");
                            } else if (creature.getStrength() < oponent.getStrength() && oponent.getStatus() >0){
                                creature.setStatus(0);
                                if (creature.getType() == "human") creature.setType("zombie");
                                this.points[posX][posY].setContent(creature);
                                //System.out.println(oponent.getType()+" just killed "+creature.getType()+"!");
                            } else if (creature.getStrength() == oponent.getStrength()){
                                oponent.setStatus(0);
                                this.points[x][y].setContent(oponent);
                                oponent.setStatus(0);
                                this.points[x][y].setContent(oponent);
                                //System.out.println(creature.getType()+" and "+oponent.getType()+" just killed each other!");
                            }
                        }
                    }
                }
            }

        }

        public void moveCreature(int posX, int posY){
            int x,y,count = 1;
            boolean moved = false;
            Creature creature = this.points[posX][posY].getContent();

            do {
                x = Helpers.randomNum(posX-1,posX+1);
                y = Helpers.randomNum(posY-1,posY+1);

                if (x<0 || x>this.width-1 || y<0 || y>this.height-1)
                    continue; // Dont let him out of boundaries

                // Check if there already is creature
                if (!this.hasCreature(x,y)){
                    this.points[x][y] = new GridPoint(creature);
                    this.points[posX][posY] = null;
                    moved = true;
                }

                count++;
            } while(!moved && count<10);

        }

        public void printOut(){
            String line = "";
            for(int i=0;i<((this.width)*4)+1;i++){
                line = line+"-";
            }

            System.out.print("      ");
            for(int x=0;x<this.width;x++){
                System.out.print(" "+x+"  ");
            }
            System.out.println();

            System.out.println("     "+line);

            for(int y=0;y<this.height;y++){
                System.out.print("   "+y+" |");

                for(int x=0;x<this.width;x++){
                    if(this.points[x][y] != null){
                        Creature creature = this.points[x][y].getContent();
                        if (creature.getStatus() > 0){
                            String type = creature.getType();
                            System.out.print(" "+type.charAt(0)+" |");
                        } else {
                            System.out.print("   |");
                        }
                    } else {
                        System.out.print("   |");
                    }
                }

                System.out.println();
                System.out.println("     "+line);
            }
        }
    }

    class GridPoint{
        public Creature content;

        public GridPoint(Creature creature){
            this.content = creature;
        }

        public Creature getContent(){
            return this.content;
        }

        public void setContent(Creature creature){
            this.content = creature;
        }
    }

