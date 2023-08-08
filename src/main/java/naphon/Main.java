package naphon;

import java.util.*;

public class Main {

    public static Map<Double, Double> data = new HashMap<>();

    public static void main(String[] args) {
        setupData();
        double meanx = getMean(data.keySet());
        double meany = getMean(new HashSet<>(data.values()));
        double m  = getM(meanx, meany);
        double c = getC(meanx, meany,m);

        Scanner scanner = new Scanner(System.in);
        while(true) {
            double in = scanner.nextDouble();
            System.out.println("If the height is " + in + " centimeters, the weight is approximately " + (m * in + c) + " kilograms.");
        }
    }

    private static double getC(double meanx, double meany, double m) {
        return meany - (meanx*m);
    }

    private static double getM(double meanx, double meany) {
        double m = 0.0;
        double sum1 = 0.0;
        double sum2 = 0.0;

        for(double x : data.keySet()){
            double y = data.get(x);
            sum1+=(x-meanx)*(y-meany);
            sum2+=(Math.pow(x-meanx,2));
        }
            m=sum1/sum2;

        return m;
    }

    private static double getMean(Set<Double> set) {
        double xm = 0.0;
        for(Double x : set){
            xm+=x;
        }
        xm/=set.size();
        return xm;
    }

    private static void setupData() {
        data.put(150.0, 57.5);
        data.put(175.2, 70.1);
        data.put(184.3, 75.2);
    }
}