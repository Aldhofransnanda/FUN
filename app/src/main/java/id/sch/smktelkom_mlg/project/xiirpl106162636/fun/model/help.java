package id.sch.smktelkom_mlg.project.xiirpl106162636.fun.model;

import java.io.Serializable;

/**
 * Created by erda on 11/16/2016.
 */

public class help implements Serializable {
    public String judul;
    public String detail;
    public String foto;

    public help(String judul, String detail, String foto) {
        this.judul = judul;
        this.detail = detail;
        this.foto = foto;

    }
}
