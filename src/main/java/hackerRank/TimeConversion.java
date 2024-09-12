package hackerRank;

import java.io.*;

public class TimeConversion {
    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        String convertedTime = null;

        int hours = Integer.parseInt(s.substring(0, 2));
        int minute = Integer.parseInt(s.substring(3, 5));
        int sec = Integer.parseInt(s.substring(6, 8));
        String amOrPM = s.substring(8, 10);

        if ("AM".equals(amOrPM)) {
            hours = 12 - hours;
            return hours + ":" + minute + ":" + sec;
        } else if ("PM".equals(s)) {
            if (hours > 12) {
                hours = 12 + hours;
                return hours + ":" + minute + ":" + sec;
            }
        }


        return convertedTime;
    }

}

/*
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}*/
