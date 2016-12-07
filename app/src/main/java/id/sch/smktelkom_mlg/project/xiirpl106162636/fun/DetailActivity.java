package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import id.sch.smktelkom_mlg.project.xiirpl106162636.fun.model.help;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        help help = (help) getIntent().getSerializableExtra(HelpActivity.HELP);

        ImageView ivFoto = (ImageView) findViewById(R.id.imageFoto);
        ivFoto.setImageURI(Uri.parse(help.foto));
        TextView tvDeskripsi = (TextView) findViewById(R.id.detail);
        tvDeskripsi.setText(help.detail + "\n\n");
    }
}
