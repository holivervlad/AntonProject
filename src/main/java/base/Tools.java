package base;

import pages.accounts.AccountsPage;

public class Tools {

    public static String getFakeName (String partOfName) {

        return randomRangeBetween(1, 1000) +" "+ partOfName;
    }

    public static double getFakeSlaSerialNumber () {
        return randomRangeBetween(1, 10000);
    }


    private static double randomRangeBetween(double min, double max){
        double x = (Math.random()*((max-min)+1))+min;
        return x;
    }
}
