package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class SlidingQuiz extends AppCompatActivity {

    // tasks Question Chapter Columns names
    private static final String CHAP_ID = "cid";
    private static final String CHAP_NUMBER = "chapter_number";

    // tasks Question Lesson Columns names
    private static final String LESSON_ID = "lid";
    private static final String LESSON_NAME = "lesson_name";

    // tasks Question Score Columns names
    private static final String SCORE_ID = "sid";
    private static final String SCORE_VALUE = "score_value";

    List<Question> quesList;
    int score = 0;
    int qid = 0;
    int defaultValue = 0;
    int page = 0;
    int chapter = 1;
    int lesson = 1;
    String answers[] = {"", "", "", "", "", "", "", "", "", "", "", ""};
    String kunci[] = {"", "", "", "", "", "", "", "", "", "", "", ""};

    SQLiteDatabase basDat;

    Question currentQ;
    TextView cobaText1;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Intent lesson = getIntent();
        Bundle l = lesson.getExtras();

        final int j = l.getInt("lesson");
        final int k = l.getInt("chapter");

        QuizHelper db = new QuizHelper(this);  // my question bank class
        quesList = db.getAllQuestions(3, 1);  // this will fetch all quetonall questions

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("START"));
        tabLayout.addTab(tabLayout.newTab().setText("1"));
        tabLayout.addTab(tabLayout.newTab().setText("2"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                page = tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        cobaText1 = (TextView) findViewById(R.id.textView4);
        page = -1;

        cobaText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                viewPager.setCurrentItem(page + 1);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void getKeyAnswer() {
        for (int i = 0; i < 10; i++) {
            currentQ = quesList.get(i); // the current question
            kunci[i] = currentQ.getANSWER();
        }
    }
}