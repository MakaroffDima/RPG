

public abstract class Character implements Fighter {
    private String name;
    private int dexterity;
    private int health;
    private int gold;
    private int strength;
    private int exp;
    private boolean isAlive = true;

    public Character(String name, int dexterity, int health, int gold, int strength, int exp) {
        this.name = name;
        this.dexterity = dexterity;
        this.health = health;
        this.gold = gold;
        this.strength = strength;
        this.exp = exp;
    }

    @Override
    public void attack(Character character) {
        if (dexterity * 3 > getRandomValue()) {
            character.getPunchInTheFace(strength);
        }
    }

    @Override
    public void getPunchInTheFace(int damage) {
        health -= damage;
        if (health <= 0) {
            isAlive = false;
        }
        System.out.println(name + " получил урон " + damage + ",осталось здоровья " + health);
    }

    // получаем число от 0 до 100 и, если наша ловкость, умноженная на 3, больше, чем случайное значение, то мы атакуем в размере
    // нашей силы, если нет, то возвращаем 0, что приравнивается к промаху.
    private int getRandomValue() {
        return (int) (Math.random() * 100);
    }


    //Выводим в консоль имя и очки здоровья
    @Override
    public String toString() {

        return String.format("%s здоровье:%d", name, health);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}