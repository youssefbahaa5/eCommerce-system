package system;

import java.util.*;

public class ShippingService {
    private static final double FLAT_FEE = 30.0;

    public static double ship(List<Shippable> list){
        if(list.isEmpty()) return 0.0;

        class Line { String name; double unitW; int cnt=0; }
        List<Line> summary = new ArrayList<>();

        for(Shippable s : list){
            Line found=null;
            for(Line l : summary)
                if(l.name.equals(s.getName())){ found=l; break; }
            if(found==null){
                Line l=new Line();
                l.name=s.getName();
                l.unitW=s.getWeight();
                summary.add(l);
                found=l;
            }
            found.cnt++;
        }

        double totalKg = 0;
        for(Line l: summary) totalKg += l.cnt * l.unitW;

        System.out.println("** Shipment notice **");
        for(Line l: summary){
            double weightPerLineKg = l.cnt * l.unitW;
            System.out.printf("%dx %s %.1fkg%n", l.cnt, l.name, weightPerLineKg);
        }
        System.out.printf("Total package weight %.1fkg%n", totalKg);
        return FLAT_FEE;
    }
}
