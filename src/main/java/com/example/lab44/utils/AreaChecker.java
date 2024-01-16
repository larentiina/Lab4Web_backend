package com.example.lab44.utils;

public class AreaChecker {
    public static boolean areaCheck(double x, double y, double r){
        if (Math.pow(x,2)+Math.pow(y,2)<=Math.pow(r/2,2) && x>=0 && y>=0){
            return true;
        } else if (Math.abs(x)<=(r) && Math.abs(y)<=r && x<=0 && y<=0) {
            return true;
        } else return y >= x - r/2 && x >= 0 && y <= 0;
    }
}
