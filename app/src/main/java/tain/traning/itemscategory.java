package tain.traning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import tain.traning.Model.Categoryitem;
import tain.traning.Presenter.LoginPrestener;
import tain.traning.Views.*;
import tain.traning.Views.Card;
import tain.traning.adapter.adaptercategories;
import tain.traning.adapter.adapteritemscategory;

public class itemscategory extends AppCompatActivity implements Categoryitemview,Card{
    RecyclerView recyclerView;
    adapteritemscategory mAdapter;
    LoginPrestener login;
    int id;
    TextView counter;
    ImageView card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemscategory);
        counter=findViewById(R.id.coun);
        card=findViewById(R.id.addcard);

        id=getIntent().getIntExtra("id",0);
        login=new LoginPrestener(this,this);
        login.getCategoriesItems(id);
        Recyclview();

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemscategory.this, tain.traning.Card.class);
                startActivity(intent);            }
        });

    }
    public void Recyclview(){
        recyclerView = findViewById(R.id.Recycleitems);
        recyclerView.setHasFixedSize(true);



    }
    @Override
    public void listitemsid(List<Categoryitem> cats) {
        mAdapter = new adapteritemscategory(cats,this);
        mAdapter.setlistcounter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void counter(String count) {
        counter.setText(count);
    }

    @Override
    public void listard(List<Categoryitem> card) {

    }
}
