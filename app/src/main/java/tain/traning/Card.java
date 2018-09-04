package tain.traning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import tain.traning.Business.ListItemCart;
import tain.traning.Model.Categoryitem;
import tain.traning.adapter.adaptercard;
import tain.traning.adapter.adaptercategories;
import tain.traning.adapter.adapteritemscategory;

public class Card extends AppCompatActivity implements tain.traning.Views.Card{
    RecyclerView recyclerView;
    adaptercard mAdapter;
    ListItemCart list=new ListItemCart();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Toast.makeText(this, ""+list.getlist().size(), Toast.LENGTH_SHORT).show();

        Recyclview();

    }
    public void Recyclview(){
        recyclerView = findViewById(R.id.Recyclecard);
        recyclerView.setHasFixedSize(true);
        mAdapter = new adaptercard(list.getlist(),this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void listard(List<Categoryitem> card) {


    }
}
