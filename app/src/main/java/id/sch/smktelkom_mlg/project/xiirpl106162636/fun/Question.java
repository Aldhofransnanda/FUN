package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

/**
 * Created by Fadwa on 10/18/2016.
 */

import android.app.Activity;

public class Question extends Activity {
    private int ID;
    private int ID_LESSON;
    private int ID_CHAPTER;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;
    private String OPTD;
    private String OPTE;
    private String ANSWER;

    public Question() {
        ID = 0;
        ID_LESSON = 0;
        ID_CHAPTER = 0;
        QUESTION = "";
        OPTA = "";
        OPTB = "";
        OPTC = "";
        OPTD = "";
        OPTE = "";
        ANSWER = "";
    }

    public Question(int iD_lESSON, int iD_cHAPTER, String qUESTION, String oPTA, String oPTB, String oPTC, String oPTD, String oPTE, String aNSWER) {
        ID_LESSON = iD_lESSON;
        ID_CHAPTER = iD_cHAPTER;
        QUESTION = qUESTION;
        OPTA = oPTA;
        OPTB = oPTB;
        OPTC = oPTC;
        OPTD = oPTD;
        OPTE = oPTE;
        ANSWER = aNSWER;
    }

    public int getID() {
        return ID;
    }

    public void setID(int id) {
        ID = id;
    }

    public int getID_LESSON() {
        return ID_LESSON;
    }

    public void setID_LESSON(int iD_lESSON) {
        ID_LESSON = iD_lESSON;
    }

    public int getID_CHAPTER() {
        return ID_CHAPTER;
    }

    public void setID_CHAPTER(int iD_cHAPTER) {
        ID_CHAPTER = iD_cHAPTER;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public void setQUESTION(String qUESTION) {
        QUESTION = qUESTION;
    }

    public String getOPTA() {
        return OPTA;
    }

    public void setOPTA(String oPTA) {
        OPTA = oPTA;
    }

    public String getOPTB() {
        return OPTB;
    }

    public void setOPTB(String oPTB) {
        OPTB = oPTB;
    }

    public String getOPTC() {
        return OPTC;
    }

    public void setOPTC(String oPTC) {
        OPTC = oPTC;
    }

    public String getOPTD() {
        return OPTD;
    }

    public void setOPTD(String oPTD) {
        OPTD = oPTD;
    }

    public String getOPTE() {
        return OPTE;
    }

    public void setOPTE(String oPTE) {
        OPTE = oPTE;
    }

    public String getANSWER() {
        return ANSWER;
    }

    public void setANSWER(String aNSWER) {
        ANSWER = aNSWER;
    }
}
