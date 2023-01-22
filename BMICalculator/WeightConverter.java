public class WeightConverter {

    private final static double KG_PER_STONE = 6.35029;
    private final static double KG_PER_POUND = 0.453592;
    private final static double STONE_PER_POUND = 0.0714286;

    public double kilogramsToStones(double d){ return d/KG_PER_STONE; }

    public double kilogramsToPounds(double d){ return d/KG_PER_POUND; }

    public double poundsToKilogram(double d){ return d*KG_PER_POUND; }

    public double stonesToKilogram(double d){ return d*KG_PER_STONE; }
    
    public double poundsToStones(double d){ return d*STONE_PER_POUND; }

}