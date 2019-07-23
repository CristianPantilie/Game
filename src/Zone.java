public class Zone
{
    private int numberOfWaves = 5; //TODO: random
    private String name;
    private String description;

    PlayerGroup targetGroup;

    public Zone(PlayerGroup targetGroup)
    {
        this.targetGroup = targetGroup;

        int groupAvg = targetGroup.averageLevel();
    }

    private void generateWave(){
        int random
    }
}
