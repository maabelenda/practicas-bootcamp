package Utils;

import Entity.FiguraGeometrica;

public class StringUtil {

    public static double areaPromedio (FiguraGeometrica arr[]) {
        double areaPromedio = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            areaPromedio += arr[i].area();
        }
        return areaPromedio/arr.length;
    }
}
