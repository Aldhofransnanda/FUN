package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {

    QuizHelper controller = new QuizHelper(this);
    List<Score> dbList;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Scoreboard");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbList = new ArrayList<Score>();
        dbList = controller.getDataFromDB();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycleView1);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerAdapter(this, dbList);
        mRecyclerView.setAdapter(mAdapter);

        ArrayList<HashMap<String, String>> scoreList = controller.getScore();
        /* jikta tidak kosong, tampilkan data kampus ke ListView
		 *
		 */


//        ListAdapter adapter = new SimpleAdapter(ScoreActivity.this,
//                scoreList, R.layout.activity_view__score__entry, new String[]{
//                "lesson", "chapter", "score"}, new int[]{
//                R.id.mataPelajaran, R.id.chapterSoal, R.id.skorSoal});
//        setListAdapter(adapter);
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
