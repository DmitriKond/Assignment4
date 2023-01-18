public abstract class FireType extends Pokemon {

    public FireType() {
        setType(FIRE_TYPE);
    }

    public boolean useAttack (int index, Pokemon target) {
        boolean valid = false;
        index--;
        if (getAttacks()[index].getCost() > getAttackPoints()) {
            System.out.println("Not enough Attack Points!");
        } else {
            int damage = getAttacks()[index].calculateDamage();
            if (checkStandbyAttackBuff()) {
                useStandbyAttackBuff(damage);
            }
            System.out.println(getName() + " used " + getAttacks()[index].getName() + " and dealt " + damage + " damage to the enemy " + target.getName() + "!");
            target.takeDamage(damage);
            setAttackPoints(getAttackPoints() - getAttacks()[index].getCost());
        }
        return valid;
    }

    public void useSpecialMove (Pokemon target) {
        useRandomAttack(target);
    }

    public String printSpecialMove () {
        return "Use 2 random attacks at the cost of losing half your current HP and ALL of your Attack Points.";
    }
}
