package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AnswerFragment extends Fragment {

    Button submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LayoutInflater lf = getActivity().getLayoutInflater();
        View view = lf.inflate(R.layout.fragment_answer, container, false); //pass the correct layout name for the fragment

        submit = (Button) view.findViewById(R.id.submit);

        view.findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((SlidingQuiz) getActivity()).getKeyAnswer();
                ((SlidingQuiz) getActivity()).scoring();
            }
        });

        return view;

    }
}
