package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PlayDetailActivity extends AppCompatActivity {

    TextView cobalesson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_detail);

        cobalesson = (TextView) findViewById(R.id.textView);
        Intent lesson = getIntent();
        Bundle l = lesson.getExtras();


        String j = l.get("lesson").toString();
        cobalesson.setText(j);
    }
}
