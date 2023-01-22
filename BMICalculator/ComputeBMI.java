public class ComputeBMI {

    public String getStatus(String myName, int myAge, double myWeight, double myHeight){
        BMI myBMI = new BMI(myName, myWeight, myHeight);
        myBMI.setAge(myAge);
        String bmiResult;
        double bmiScore = myBMI.getBMI();
        if(bmiScore < 18.5){ bmiResult = " - Underweight"; }
        else if(bmiScore >= 18.5 && bmiScore < 25){bmiResult = " - Normal"; }
        else if(bmiScore >= 25 && bmiScore < 30){bmiResult = " - Overweight"; }
        else if(bmiScore >= 30){ bmiResult = " - Obese"; }
        else { bmiResult = " - Unknown"; }
        return ("The BMI For " + myBMI.getName() + " Is " + bmiScore + bmiResult);
    }

    public static void main(String[] args) {
        System.out.println(new ComputeBMI().getStatus("Ann Williams", 21, 145, 70));
        System.out.println(new ComputeBMI().getStatus("Ben Young", 32, 215, 70));
        System.out.println(new ComputeBMI().getStatus("Ali Hasan", 19, 130, 69.5));
        System.out.println(new ComputeBMI().getStatus("Jos Buttler", 31, 165, 71));
        System.out.println(new ComputeBMI().getStatus("Rao Rehman", 52, 165, 69));
    }

}