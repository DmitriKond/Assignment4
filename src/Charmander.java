public class Charmander extends FireType {

    private static final int CHARMANDER_MAX_HP = 80;
    private static final int CHARMANDER_STARTING_AP = 30;
    private static final int CHARMANDER_MAX_AP = 40;
    private static final int CHARMELEON_MAX_HP = 90;
    private static final int CHARMELEON_MAX_AP = 60;
    private static final int CHARIZARD_MAX_HP = 130;
    private static final int CHARIZARD_MAX_AP = 80;

    private static final int SCRATCH_MIN_DAMAGE = 25;
    private static final int SCRATCH_MAX_DAMAGE = 30;
    private static final int SCRATCH_COST = 15;
    private static final int FLAME_TAIL_MIN_DAMAGE = 30;
    private static final int FLAME_TAIL_MAX_DAMAGE = 50;
    private static final int FLAME_TAIL_COST = 40;
    private static final int FIERY_BLAST_MIN_DAMAGE = 50;
    private static final int FIERY_BLAST_MAX_DAMAGE = 50;
    private static final int FIERY_BLAST_COST = 50;

    public Charmander() {
        setName("Charmander");
        setHealthPoints(CHARMANDER_MAX_HP);
        setMaxHealth(CHARMANDER_MAX_HP);
        setAttackPoints(CHARMANDER_STARTING_AP);
        setMaxAttackPoints(CHARMANDER_MAX_AP);
        Attack startingAttack = new Attack("Scratch", SCRATCH_MIN_DAMAGE, SCRATCH_MAX_DAMAGE, SCRATCH_COST);
        addAttack(startingAttack);
    }

    public boolean evolve () {
        boolean result = false;
        if (getLevel() == STARTING_LEVEL) {
            if (canEvolve()) {
                setName("Charmeleon");
                setMaxHealth(CHARMELEON_MAX_HP);
                setMaxAttackPoints(CHARMELEON_MAX_AP);
                Attack newAttack = new Attack("Fiery Blast", FIERY_BLAST_MIN_DAMAGE, FIERY_BLAST_MAX_DAMAGE, FIERY_BLAST_COST);
                addAttack(newAttack);
                increaseLevel();
                result = true;
            }
        } else if (getLevel() < MAX_LEVEL) {
            if (canEvolve()) {
                setName("Charizard");
                setMaxHealth(CHARIZARD_MAX_HP);
                setMaxAttackPoints(CHARIZARD_MAX_AP);
                Attack newAttack = new Attack("Flame Tail", FLAME_TAIL_MIN_DAMAGE, FLAME_TAIL_MAX_DAMAGE, FLAME_TAIL_COST);
                addAttack(newAttack);
                increaseLevel();
                result = true;
            }
        }
        return result;
    }
}
