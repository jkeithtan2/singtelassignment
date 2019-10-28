package assignment.behaviour.growth;

public class ButterflyGrowthBehaviour implements GrowthBehaviour {
    @Override
    public String morphFrom() {
        return "caterpillar";
    }

    @Override
    public String morphTo() {
        return null;
    }
}
