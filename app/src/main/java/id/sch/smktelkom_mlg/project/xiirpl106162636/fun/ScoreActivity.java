package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScoreActivity extends ListActivity {

    QuizHelper controller = new QuizHelper(this);
    List<Score> dbList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        dbList = new ArrayList<Score>();
        dbList = controller.getDataFromDB();

        ArrayList<HashMap<String, String>> scoreList = controller.getScore();
        /* jikta tidak kosong, tampilkan data kampus ke ListView
		 *
		 */
        ListAdapter adapter = new SimpleAdapter(ScoreActivity.this,
                scoreList, R.layout.activity_view__score__entry, new String[]{
                "lesson", "chapter", "score"}, new int[]{
                R.id.mataPelajaran, R.id.chapterSoal, R.id.skorSoal});
        setListAdapter(adapter);
    }
}
