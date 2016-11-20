package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

import android.app.Activity;

/**
 * Created by Muhammad Pandu Widod on 20/11/2016.
 */

public class Lesson extends Activity {
    private int ID_LESSON;
    private String LESSON_NAME;

    public Lesson() {
        LESSON_NAME = "";
    }

    public Lesson(String lESSON) {
        LESSON_NAME = lESSON;
    }


    public int getID_LESSON() {
        return ID_LESSON;
    }

    public void setID_LESSON(int iD_lESSON) {
        ID_LESSON = iD_lESSON;
    }

    public String getLESSON_NAME() {
        return LESSON_NAME;
    }

    public void setLESSON_NAME(String lESSON) {
        LESSON_NAME = lESSON;
    }


}
