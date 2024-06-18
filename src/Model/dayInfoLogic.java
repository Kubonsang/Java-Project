package Model;

import java.util.Comparator;
import java.util.Vector;

import static java.util.Collections.sort;

public class dayInfoLogic {
    public static final int KCAL = 1;
    public static final int EXERCISE_TIME = 2;
    private static final String DIRECTORY = "./data/";
    private Vector<dayInfo> dayList = new Vector<dayInfo>();

    public Vector<dayInfo> getList(int comparator){

        Vector<dayInfo> newList = (Vector<dayInfo>) dayList.clone();
        if(comparator == EXERCISE_TIME){
            newList.sort(new compareTime());
        }
        else if (comparator == KCAL){
            newList.sort(new compareKcal());
        }
        return newList;
    }
    // upstair
    static class compareKcal implements Comparator<dayInfo> {
        @Override
        public int compare(dayInfo o1, dayInfo o2) {
            return o1.getKcal() - o2.getKcal();
        }
    }

    // upstair
    static class compareTime implements Comparator<dayInfo> {
        @Override
        public int compare(dayInfo o1, dayInfo o2) {
            if(o1.getExerciseTime() > o2.getExerciseTime()){
                return 1;
            }
            else if(o1.getExerciseTime() < o2.getExerciseTime()){
                return -1;
            }
            return 0;
        }
    }

}
