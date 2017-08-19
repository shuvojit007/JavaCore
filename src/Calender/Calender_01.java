package Calender;

import java.util.Calendar;

/**
 * Created by SHOBOJIT on 6/27/2017.
 */
public class Calender_01 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println("The current date is : " + c.getTime());


        System.out.println("At present Calendar's Year: " + c.get(Calendar.YEAR));

        System.out.println("At present Calendar's Day: " + c.get(Calendar.DATE));

        int maximum = c.getMaximum(Calendar.DAY_OF_WEEK);
        System.out.println("Maximum number of days in week: " + maximum);
        maximum = c.getMaximum(Calendar.WEEK_OF_YEAR);
        System.out.println("Maximum number of weeks in year: " + maximum);
/*
        c.add(Calendar.DATE, -15);
        System.out.println("15 days ago: " + c.getTime());

        c.add(Calendar.MONTH, 4);
        System.out.println("4 months later: " + c.getTime());

        c.add(Calendar.YEAR, 2);
        System.out.println("2 years later: " + c.getTime());*/

/*
        int NowDay =c.getInstance().get(Calendar.DAY_OF_WEEK);
        System.out.println(NowDay);

        int nowHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        System.out.println(nowHour-12);

        int nowMinute = Calendar.getInstance().get(Calendar.MINUTE);
        System.out.println(nowMinute);

        if (Calendar.FRIDAY ==NowDay)
            System.out.println(true);
        else
            System.out.println(false);*/

        Calendar cc  = Calendar.getInstance();
        cc.add(Calendar.WEEK_OF_YEAR,1);
        System.out.println("DATE NEW : "+cc.getTime());
/*
    boolean re= !(true&&false);
    System.out.println(re);

        boolean ree= !(true&&false&&false);
        System.out.println(ree);


        if (true && !(true &&false)&&!(true&&false&&true)) {
        System.out.println("Yes");
        }*/
    }
}




