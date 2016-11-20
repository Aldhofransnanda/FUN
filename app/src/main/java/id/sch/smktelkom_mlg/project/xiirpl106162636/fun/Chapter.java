package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

import android.app.Activity;

/**
 * Created by Muhammad Pandu Widod on 20/11/2016.
 */

public class Chapter extends Activity {
    private int ID_CHAPTER;
    private int ID_LESSON;
    private int CHAPTER_NUMBER;

    public Chapter() {
        ID_LESSON = 0;
        CHAPTER_NUMBER = 0;
    }

    public Chapter(int lESSON, int number) {
        ID_LESSON = lESSON;
        CHAPTER_NUMBER = number;
    }


    public int getID_CHAPTER() {
        return ID_CHAPTER;
    }

    public int getID_LESSON() {
        return ID_LESSON;
    }

    public void setID_LESSON(int iD_lESSON) {
        ID_LESSON = iD_lESSON;
    }

    public int getCHAPTER_NUMBER() {
        return CHAPTER_NUMBER;
    }

    public void setCHAPTER_NUMBER(int number) {
        CHAPTER_NUMBER = number;
    }


}
