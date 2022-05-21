public class BMI {

    private String Name;
    private int Age;
    private double Weight;
    private double Height;

    BMI(String myName, double myWeight, double myHeight){
        Name = myName;
        Weight = myWeight;
        Height = myHeight;
    } 

    public double getBMI(){
        return Math.round((new WeightConverter().poundsToKilogram(Weight)/(Math.pow(new LengthConverter().inchesToMeters(Height), 2))) * 100.0) / 100.0;
    }

    public String getName(){ return Name; }

    public int getAge(){ return Age; }

    public double getWeight(){ return Weight; }

    public double getHeight(){ return Height; }

    public void setAge(int i){ Age = i; }

    public void setName(String s){ Name = s; }

    public void setWeight(double w){ Weight = w; }
    
    public void setHeight(double h){ Height = h; }

}