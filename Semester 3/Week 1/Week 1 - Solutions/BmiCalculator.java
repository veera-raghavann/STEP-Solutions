public class BmiCalculator {
    static String getBmiStatus(double bmi) { return bmi<18.5?"Underweight":bmi<25?"Normal":bmi<30?"Overweight":"Obese"; }
    static void printWellnessReport(double[] heights, double[] weights) { System.out.println("Person | Height | Weight | BMI | Status"); for(int i=0;i<heights.length;i++){double bmi=weights[i]/(heights[i]*heights[i]);System.out.printf("%d | %.2f | %.1f | %.2f | %s%n",i+1,heights[i],weights[i],bmi,getBmiStatus(bmi));} }
    public static void main(String[] args) { printWellnessReport(new double[]{1.75,1.60},new double[]{70,90}); }
}
