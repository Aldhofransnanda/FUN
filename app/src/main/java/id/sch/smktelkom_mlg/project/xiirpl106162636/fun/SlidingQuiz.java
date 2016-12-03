package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;



public class SlidingQuiz extends AppCompatActivity implements FragmentCommunication {

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
    int j, k = 0;

    int lesson = 0, chapter = 0;
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

        j = l.getInt("lesson");
        k = l.getInt("chapter");

        QuizHelper db = new QuizHelper(this);  // my question bank class
        quesList = db.getAllQuestions(j, k);  // this will fetch all quetonall questions

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("START"));
        tabLayout.addTab(tabLayout.newTab().setText("1"));
        tabLayout.addTab(tabLayout.newTab().setText("2"));
        tabLayout.addTab(tabLayout.newTab().setText("3"));
        tabLayout.addTab(tabLayout.newTab().setText("4"));
        tabLayout.addTab(tabLayout.newTab().setText("5"));
        tabLayout.addTab(tabLayout.newTab().setText("6"));
        tabLayout.addTab(tabLayout.newTab().setText("7"));
        tabLayout.addTab(tabLayout.newTab().setText("8"));
        tabLayout.addTab(tabLayout.newTab().setText("9"));
        tabLayout.addTab(tabLayout.newTab().setText("10"));
        tabLayout.addTab(tabLayout.newTab().setText("SUBMIT"));
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

    public void scoring() {
        for (int i = 0; i < 10; i++) {
            if (answers[i].equals(kunci[i])) {
                score += 10;
            }
        }


        String mapel;
        if (j == 1)
            mapel = "Bahasa Indonesia";
        else if (j == 2)
            mapel = "Matematika";
        else
            mapel = "Bahasa Inggris";


        basDat = openOrCreateDatabase("mathsone", Context.MODE_PRIVATE, null);
        String query = "INSERT INTO score values (null, '" + j + "', '" + mapel + "', '" + k + "', '" + score + "');";
        basDat.execSQL(query);

        Log.d("questions", query);


        Intent intent = new Intent(getBaseContext(),
                ResultActivity.class);

        //passing the int value
        Bundle b = new Bundle();
        b.putInt("score", score); // Your score
        b.putStringArray("answers", answers);
        intent.putExtras(b); // Put your score to your next
        onBackPressed();
        startActivity(intent);

    }

    public void getAnswer1(String message) {
        answers[0] = message;
        cobaText1.setText(cobaText1.getText() + " " + message);
    }

    public void getAnswer2(String message) {
        answers[1] = message;
        cobaText1.setText(cobaText1.getText() + " " + message);
    }

    public void getAnswer3(String message) {
        answers[2] = message;
        cobaText1.setText(cobaText1.getText() + " " + message);
    }

    public void getAnswer4(String message) {
        answers[3] = message;
        cobaText1.setText(cobaText1.getText() + " " + message);
    }

    public void getAnswer5(String message) {
        answers[4] = message;
        cobaText1.setText(cobaText1.getText() + " " + message);
    }

    public void getAnswer6(String message) {
        answers[5] = message;
        cobaText1.setText(cobaText1.getText() + " " + message);
    }

    public void getAnswer7(String message) {
        answers[6] = message;
        cobaText1.setText(cobaText1.getText() + " " + message);
    }

    public void getAnswer8(String message) {
        answers[7] = message;
        cobaText1.setText(cobaText1.getText() + " " + message);
    }

    public void getAnswer9(String message) {
        answers[8] = message;
        cobaText1.setText(cobaText1.getText() + " " + message);
    }

    public void getAnswer10(String message) {
        answers[9] = message;
        cobaText1.setText(cobaText1.getText() + " " + message);
    }
}