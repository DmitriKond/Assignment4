public class Blitzle extends ElectricType {

    private static final int BLITZLE_MAX_HP = 90;
    private static final int BLITZLE_STARTING_AP = 26;
    private static final int BLITZLE_MAX_AP = 35;
    private static final int ZEBSTRIKA_MAX_HP = 100;
    private static final int ZEBSTRIKA_MAX_AP = 50;

    private static final int FLOP_MIN_DAMAGE = 25;
    private static final int FLOP_MAX_DAMAGE = 30;
    private static final int FLOP_COST = 15;
    private static final int ZAP_ATTACK_MIN_DAMAGE = 25;
    private static final int ZAP_ATTACK_MAX_DAMAGE = 30;
    private static final int ZAP_ATTACK_COST = 15;

    public Blitzle () {
        setName("Blitzle");
        setHealthPoints(BLITZLE_MAX_HP);
        setMaxHealth(BLITZLE_MAX_HP);
        setAttackPoints(BLITZLE_STARTING_AP);
        setMaxAttackPoints(BLITZLE_MAX_AP);
        Attack startingAttack = new Attack("Flop", FLOP_MIN_DAMAGE, FLOP_MAX_DAMAGE, FLOP_COST);
        addAttack(startingAttack);
    }

    public boolean evolve() {
        boolean result = false;
        if (getLevel() == STARTING_LEVEL) {
            if (canEvolve()) {
                setName("Zebstrika");
                setMaxHealth(ZEBSTRIKA_MAX_HP);
                setMaxAttackPoints(ZEBSTRIKA_MAX_AP);
                Attack newAttack = new Attack("Zap Attack", ZAP_ATTACK_MIN_DAMAGE, ZAP_ATTACK_MAX_DAMAGE, ZAP_ATTACK_COST);
                addAttack(newAttack);
                result = true;
            }
        }
        return result;
    }
}
