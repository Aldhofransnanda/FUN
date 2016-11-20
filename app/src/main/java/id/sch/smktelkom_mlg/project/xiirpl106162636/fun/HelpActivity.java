package id.sch.smktelkom_mlg.project.xiirpl106162636.fun;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl106162636.fun.adapter.HelpAdapter;
import id.sch.smktelkom_mlg.project.xiirpl106162636.fun.model.help;

public class HelpActivity extends AppCompatActivity implements HelpAdapter.IHelpAdapter {

    public static final String HELP = "help";
    ArrayList<help> mList = new ArrayList<>();
    HelpAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new HelpAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        fillData();
    }

    private void fillData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.judul);
        String[] arDetail = resources.getStringArray(R.array.details);
        TypedArray a = resources.obtainTypedArray(R.array.places_picture);
        String[] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            int id = a.getResourceId(i, 0);
            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + resources.getResourcePackageName(id) + '/'
                    + resources.getResourceTypeName(id) + '/'
                    + resources.getResourceEntryName(id);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new help(arJudul[i], arDetail[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(HELP, mList.get(pos));
        startActivity(intent);
    }
}
