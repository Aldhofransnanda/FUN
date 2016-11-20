package id.sch.smktelkom_mlg.project.xiirpl106162636.fun.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl106162636.fun.R;
import id.sch.smktelkom_mlg.project.xiirpl106162636.fun.model.help;

/**
 * Created by erda on 11/16/2016.
 */

public class HelpAdapter extends RecyclerView.Adapter<HelpAdapter.ViewHolder> {

    ArrayList<help> helpList;
    IHelpAdapter mIHelpAdapter;

    public HelpAdapter(Context context, ArrayList<help> helpList) {
        this.helpList = helpList;
        mIHelpAdapter = (IHelpAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.help_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        help help = helpList.get(position);
        holder.tvJudul.setText(help.judul);
        holder.ivFoto.setImageURI(Uri.parse(help.foto));

    }

    @Override
    public int getItemCount() {
        if (helpList != null)
            return helpList.size();

        return 0;
    }

    public interface IHelpAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFoto;
        TextView tvJudul;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIHelpAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}
