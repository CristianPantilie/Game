package test.Units;

abstract public class Hero {

    private final int BASE_HP = 10;
    //attributes
    private int hitPoints;
    private int level;

    Hero(int level){
        this.level = level;
        hitPoints = BASE_HP * level;
    }

    Hero cloneHero(){
        //TODO: get all the attributes of this hero and clone them into the new one
        if(this instanceof Fighter){
            return new Fighter(this.level);
        }
        else if(this instanceof Mage){
            return new Mage(this.level);
        }
        else{
            return new Ranger(this.level);
        }
    }


    int getHP(){
        return  hitPoints;
    }

    void setHP(int amount){
        hitPoints = amount;
    }
}
