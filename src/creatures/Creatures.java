package creatures;

public class Creatures {
    protected String name;
    protected int attack;
    protected int armor;
    protected int health;
    protected int maxHealth;
    protected boolean isDead;
    protected boolean canBeHealed;
    protected int healing;
    protected int[] damage;
    protected int healingPercentage;

    public Creatures(String name, int attack, int armor, int health, int maxDamage) {
        this.name = name;
        this.attack = attack;
        this.armor = armor;
        this.damage = this.damageRange(maxDamage);
        this.isDead = false;
        this.canBeHealed = true;
        this.health = health;
        this.maxHealth = health;
        this.healing = 0;
        this.healingPercentage = 30;
    }


    protected int[] damageRange(int maxDamage) {
        int[] damage = new int[maxDamage];
        for (int i = 0; i < damage.length; i++) {
            damage[i] = i + 1;
        }
        return damage;
    }

    public int getAttack(){
        return this.attack;
    }

    public int getDamage() {
        return this.damage[(int) (Math.random() * this.damage.length - 1)];
    }

    public int getArmor() {
        return this.armor;
    }
    public int getHealth(){
        return this.health;
    }
    public String getName(){
        return this.name;
    }

    public void damageReceived(Creatures creatures) {
        StringBuilder sb = new StringBuilder();
        int receiveDamage = creatures.getDamage();
        this.health -= receiveDamage;
        sb.append(System.out.format("<%s>: I receive damage: %d%n", this.name, receiveDamage));
        if (this.health <= 0) {
            this.isDead = true;
            sb.append("\nI'm is dead...");
        }
        System.out.println(sb.toString());
    }

    public void dealingDamage(Creatures creatures) {
        creatures.damageReceived(this);
    }

    public void medicine() {
        if (this.healing <= 4) {
            int lastHealth = this.health;
            int health = this.maxHealth * this.healingPercentage / 100;
            int tempHealth = this.health += health;
            this.health = (tempHealth < this.maxHealth) ? this.health + tempHealth : this.maxHealth;
            this.healing++;
            System.out.println(System.out.format("%s +%d%nhp", this.name, this.maxHealth - lastHealth));
        } else {
            System.out.println("Treatment not available");
        }
    }

}
