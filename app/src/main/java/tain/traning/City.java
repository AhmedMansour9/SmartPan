package tain.traning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import tain.traning.Presenter.LoginPrestener;
import tain.traning.Views.cityview;
import tain.traning.adapter.adaptercites;

public class City extends AppCompatActivity implements cityview {
    RecyclerView recyclerView;
    adaptercites mAdapter;
    LoginPrestener login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        login=new LoginPrestener(this,this);
        login.getCeties();
        Recyclview();
    }
    public void Recyclview(){
        recyclerView = findViewById(R.id.Recycle);
        recyclerView.setHasFixedSize(true);



    }

    @Override
    public void showlistcites(List<tain.traning.Model.City> cites) {
        mAdapter = new adaptercites(cites);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }
}
