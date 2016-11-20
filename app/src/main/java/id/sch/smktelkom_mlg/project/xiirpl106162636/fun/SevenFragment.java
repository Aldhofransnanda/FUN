package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class SevenFragment extends Fragment {

    List<Question> quesList;
    int qid = 0;
    int chapter = 1;
    int lesson = 1;
    Question currentQ;
    RadioButton opt1, opt2, opt3, answer;
    private Button[] btn = new Button[5];
    private Button btn_unfocus;
    private int[] btn_id = {R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button5};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LayoutInflater lf = getActivity().getLayoutInflater();
        View view = lf.inflate(R.layout.fragment_seven, container, false); //pass the correct layout name for the fragment

        QuizHelper db = new QuizHelper(getActivity());  // my question bank class
        quesList = db.getAllQuestions(lesson, chapter);  // this will fetch all questionable questions
        currentQ = quesList.get(qid + 6); // the current question

        TextView txtQuest = (TextView) view.findViewById(R.id.txtQuestion);
        btn[0] = (Button) view.findViewById(btn_id[0]);
        btn[1] = (Button) view.findViewById(btn_id[1]);
        btn[2] = (Button) view.findViewById(btn_id[2]);
        btn[3] = (Button) view.findViewById(btn_id[3]);
        btn[4] = (Button) view.findViewById(btn_id[4]);

        txtQuest.setText(currentQ.getQUESTION());
        btn[0].setText("A");
        btn[1].setText("B");
        btn[2].setText("C");
        btn[3].setText("D");
        btn[4].setText("E");


        for (int i = 0; i < btn.length; i++) {
            btn[i] = (Button) view.findViewById(btn_id[i]);
            btn[i].setBackgroundColor(Color.rgb(207, 207, 207));
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.button1:
                            setFocus(btn_unfocus, btn[0]);
                            btn_unfocus = btn[0];
                            ((FragmentCommunication) getActivity()).getAnswer7(currentQ.getOPTA());
                            break;

                        case R.id.button2:
                            setFocus(btn_unfocus, btn[1]);
                            btn_unfocus = btn[1];
                            ((FragmentCommunication) getActivity()).getAnswer7(currentQ.getOPTB());
                            break;

                        case R.id.button3:
                            setFocus(btn_unfocus, btn[2]);
                            btn_unfocus = btn[2];
                            ((FragmentCommunication) getActivity()).getAnswer7(currentQ.getOPTC());
                            break;

                        case R.id.button4:
                            setFocus(btn_unfocus, btn[3]);
                            btn_unfocus = btn[3];
                            ((FragmentCommunication) getActivity()).getAnswer7(currentQ.getOPTD());
                            break;

                        case R.id.button5:
                            setFocus(btn_unfocus, btn[4]);
                            btn_unfocus = btn[4];
                            ((FragmentCommunication) getActivity()).getAnswer7(currentQ.getOPTE());
                            break;
                    }
                }
            });
        }

        btn_unfocus = btn[0];
        return view;

    }

    private void setFocus(Button btn_unfocus, Button btn_focus) {
        btn_unfocus.setTextColor(Color.rgb(49, 50, 51));
        btn_unfocus.setBackgroundColor(Color.rgb(207, 207, 207));
        btn_focus.setTextColor(Color.rgb(255, 255, 255));
        btn_focus.setBackgroundColor(Color.rgb(3, 106, 150));
    }

}
