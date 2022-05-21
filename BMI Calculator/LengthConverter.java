public class LengthConverter {

    private final static double METERS_PER_YARD =  0.9144;
    private final static double METERS_PER_INCH =  0.0254;
    private final static double INCHES_PER_YARD =  36;

    public double metersToYards(double d){ return d/METERS_PER_YARD; }

    public double metersToInches(double d){ return d/METERS_PER_INCH; }

    public double inchesToMeters(double d){ return d*METERS_PER_INCH; }

    public double yardsToMeters(double d){ return d*METERS_PER_YARD; }
    
    public double inchesToYards(double d){ return d/INCHES_PER_YARD; }

}