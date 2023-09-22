

public abstract class Monster extends Character {
    private Attack att;
    private final int sides = 10;
    public int level;

    public Monster(String name, int life, int level) {
        super(name, life);
        att = new Attack(level, sides);
        this.level = level;
    }

    public Attack getAttack() {
        return att;
    }

}
