package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class PlayDetailActivity extends AppCompatActivity {

    TextView cobalesson;

    QuizHelper helpher;
    List<Chapter> dbList;
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Pilih Chapter");

        cobalesson = (TextView) findViewById(R.id.textView);
        final Intent lesson = getIntent();
        Bundle l = lesson.getExtras();

        final int k = l.getInt("lesson");
        final String j = l.get("lesson").toString();
        cobalesson.setText(j);

        Button button1 = (Button) findViewById(R.id.buttonChapter1);
        Button button2 = (Button) findViewById(R.id.buttonChapter2);
        Button button3 = (Button) findViewById(R.id.buttonChapter3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int chapter = 1;
                Intent intent = new Intent(PlayDetailActivity.this, SlidingQuiz.class);
                intent.putExtra("lesson", k);
                intent.putExtra("chapter", chapter);
                onBackPressed();
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int chapter = 2;
                Intent intent = new Intent(PlayDetailActivity.this, SlidingQuiz.class);
                intent.putExtra("lesson", k);
                intent.putExtra("chapter", chapter);
                onBackPressed();
                startActivity(intent);


            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int chapter = 3;
                Intent intent = new Intent(PlayDetailActivity.this, SlidingQuiz.class);
                intent.putExtra("lesson", k);
                intent.putExtra("chapter", chapter);
                onBackPressed();
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
