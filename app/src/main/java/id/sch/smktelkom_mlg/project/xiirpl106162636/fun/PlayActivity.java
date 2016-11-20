package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PlayActivity extends AppCompatActivity {


    public static final String MAT = "mat";
    int lesson = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        findViewById(R.id.imageViewMat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lesson = 2;
                Intent intent = new Intent(PlayActivity.this, PlayDetailActivity.class);
                intent.putExtra("lesson", lesson);
                startActivity(intent);
            }
        });

        findViewById(R.id.imageViewBin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lesson = 1;
                Intent intent = new Intent(PlayActivity.this, PlayDetailActivity.class);
                intent.putExtra("lesson", lesson);
                startActivity(intent);
            }
        });

        findViewById(R.id.imageViewBig).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lesson = 3;
                Intent intent = new Intent(PlayActivity.this, PlayDetailActivity.class);
                intent.putExtra("lesson", lesson);
                startActivity(intent);
            }
        });
    }
}
