package dateAndTime.legacy;;

import java.sql.Date;
/*

The main difference b/w  java.util.Date and java.sql.Date is util.date store the date along with the time stamp as well
and there s no way to have date without time stamp but in java.sql.Date it create the date without timestamp.

*/

public class JavaSQLDate {

    public static void exampleOfJavaSqlDateCreation() {
        Date currentDate = new Date(System.currentTimeMillis());
        java.util.Date currentDate1 = new java.util.Date(System.currentTimeMillis());
        System.out.println("Java.SQL.DATE :- " + currentDate);
        System.out.println( "JAVA.UTIL.DATE :- "+ currentDate1);
    }

}
