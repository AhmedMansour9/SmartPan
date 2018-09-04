package tain.traning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.List;

import tain.traning.Model.Category;
import tain.traning.Presenter.LoginPrestener;
import tain.traning.Views.CategoryView;
import tain.traning.adapter.adaptercategories;
import tain.traning.adapter.adaptercites;

public class Categories extends AppCompatActivity implements CategoryView{
    RecyclerView recyclerView;
    adaptercategories mAdapter;
    LoginPrestener login;
    EditText product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        login=new LoginPrestener(this,this);
        login.getCites();
        Recyclview();
        product = findViewById(R.id.findyourproduct);
       RecycleviewSerach();
    }
    public void Recyclview(){
        recyclerView = findViewById(R.id.Recycles);
        recyclerView.setHasFixedSize(true);
    }
    public void RecycleviewSerach(){
        product.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                mAdapter.getFilter().filter(charSequence);
                mAdapter.notifyDataSetChanged();



            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
    @Override
    public void showlot(List<Category> cate) {
        mAdapter = new adaptercategories(cate,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }
}
