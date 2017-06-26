package app.ruinkami.kotlindemo;

import java.util.ArrayList;

import app.ruinkami.kotlindemo.java.JStudent;
import app.ruinkami.kotlindemo.kotlin.KStudent;

/**
 * Created by ruinkami on 2017/6/25.
 */

public class FakeServer {

    public final static int DEAFULT_SIZE = 6;

    public static String[] names = {"Ricky", "Luna", "Lina", "Kunkka", "Axe", "Meepo"};
    public static String[] universities = {"NJU", "ZJU", "PKU", "TSU", "SJTU", "FU"};
    public static String[] hobby = {"Dota2", "Football", "Basketball", "Tennis", "Gwent", "HearthStone"};

    public static ArrayList<JStudent> randomJavaResponse() {
        ArrayList<JStudent> sList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sList.add(randomJStudent(10000 + i));
        }
        return sList;
    }

    public static JStudent randomJStudent(int id) {
        return new JStudent(id,
                names[randomIndex()],
                (int) (Math.random() * 10) + 20,
                hobby[randomIndex()],
                universities[randomIndex()]);
    }

    public static int randomIndex() {
        return (int) (Math.random() * DEAFULT_SIZE);
    }

    public static KStudent randomKStudent(int id) {
        return new KStudent(id,
                names[randomIndex()],
                (int) (Math.random() * 10) + 20,
                hobby[randomIndex()],
                universities[randomIndex()]);
    }

    public static ArrayList<KStudent> randomKotlinResponse() {
        ArrayList<KStudent> sList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sList.add(randomKStudent(10000 + i));
        }
        return sList;
    }
}
