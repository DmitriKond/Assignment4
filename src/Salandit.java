public class Salandit extends FireType {

    private static final int SALANDIT_MAX_HP = 100;
    private static final int SALANDIT_STARTING_AP = 45;
    private static final int SALANDIT_MAX_AP = 60;
    private static final int SALAZZLE_MAX_HP = 160;
    private static final int SALAZZLE_MAX_AP = 80;

    private static final int LIVE_COAL_MIN_DAMAGE = 0;
    private static final int LIVE_COAL_MAX_DAMAGE = 25;
    private static final int LIVE_COAL_COST = 10;
    private static final int FIRE_CLAWS_MIN_DAMAGE = 0;
    private static final int FIRE_CLAWS_MAX_DAMAGE = 50;
    private static final int FIRE_CLAWS_COST = 25;

    public Salandit() {
        setName("Salandit");
        setHealthPoints(SALANDIT_MAX_HP);
        setMaxHealth(SALANDIT_MAX_HP);
        setAttackPoints(SALANDIT_STARTING_AP);
        setMaxAttackPoints(SALANDIT_MAX_AP);
        Attack startingAttack = new Attack("Live Coal", LIVE_COAL_MIN_DAMAGE, LIVE_COAL_MAX_DAMAGE, LIVE_COAL_COST);
        addAttack(startingAttack);
    }

    public boolean evolve() {
        boolean result = false;
        if (getLevel() == STARTING_LEVEL) {
            if (canEvolve()) {
                setName("Salazzle");
                setMaxHealth(SALAZZLE_MAX_HP);
                setMaxAttackPoints(SALAZZLE_MAX_AP);
                Attack newAttack = new Attack("Fire Claws", FIRE_CLAWS_MIN_DAMAGE, FIRE_CLAWS_MAX_DAMAGE, FIRE_CLAWS_COST);
                addAttack(newAttack);
                increaseLevel();
                result = true;
            }
        }
        return result;
    }
}
