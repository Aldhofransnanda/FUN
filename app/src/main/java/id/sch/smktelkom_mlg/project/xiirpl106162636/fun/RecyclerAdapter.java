package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user_adnig on 11/14/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    static List<Score> dbList;
    static Context context;
    public TextView mapel, chapter, score;

    RecyclerAdapter(Context context, List<Score> dbList) {
        RecyclerAdapter.dbList = new ArrayList<Score>();
        RecyclerAdapter.context = context;
        RecyclerAdapter.dbList = dbList;

    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_row, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        holder.mapel.setText(dbList.get(position).getLESSON_NAME());
        holder.chapter.setText("" + dbList.get(position).getCHAPTER_ID());
        holder.score.setText("" + dbList.get(position).getSCORE_VALUE());
    }

    @Override
    public int getItemCount() {
        return dbList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mapel, chapter, score;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            mapel = (TextView) itemLayoutView.findViewById(R.id.mataPelajaran);
            chapter = (TextView) itemLayoutView.findViewById(R.id.chapterSoal);
            score = (TextView) itemLayoutView.findViewById(R.id.skorSoal);
            itemLayoutView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            Intent intent = new Intent(context,DetailsActivity.class);
//
//            Bundle extras = new Bundle();
//            extras.putInt("position",getAdapterPosition());
//            intent.putExtras(extras);
//
//            /*
//            int i=getAdapterPosition();
//            intent.putExtra("position", getAdapterPosition());*/
//            context.startActivity(intent);
//            Toast.makeText(RecyclerAdapter.context, "you have clicked Row " + getAdapterPosition(), Toast.LENGTH_LONG).show();
        }
    }
}
