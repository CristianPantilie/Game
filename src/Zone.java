public class Zone
{
    private final int numberOfWaves;

    PlayerGroup targetGroup;

    public Zone(PlayerGroup targetGroup)
    {
        this.targetGroup = targetGroup;
        this.numberOfWaves ;

        int groupAvg = targetGroup.averageLevel();
    }
}
