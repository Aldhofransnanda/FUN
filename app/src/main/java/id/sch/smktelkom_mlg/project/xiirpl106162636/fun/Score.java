package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

import android.app.Activity;

/**
 * Created by Fadwa on 20/11/2016.
 */

public class Score extends Activity {
    private int ID_SCORE;
    private int ID_LESSON;
    private String LESSON_NAME;
    private int CHAPTER_ID;
    private int SCORE_VALUE;

    public Score() {
        ID_SCORE = 0;
        ID_LESSON = 0;
        LESSON_NAME = "";
        CHAPTER_ID = 0;
        SCORE_VALUE = 0;
    }

    public Score(int lESSON, String lESSON_nAME, int cHAPTER, int sCORE) {
        ID_LESSON = lESSON;
        LESSON_NAME = lESSON_nAME;
        CHAPTER_ID = cHAPTER;
        SCORE_VALUE = sCORE;
    }


    public int getID_SCORE() {
        return ID_SCORE;
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

    public void setLESSON_NAME(String nAME_lESSON) {
        LESSON_NAME = nAME_lESSON;
    }

    public int getCHAPTER_ID() {
        return CHAPTER_ID;
    }

    public void setCHAPTER_ID(int chapter_id) {
        CHAPTER_ID = chapter_id;
    }

    public int getSCORE_VALUE() {
        return SCORE_VALUE;
    }

    public void setSCORE_VALUE(int value) {
        SCORE_VALUE = value;
    }

}