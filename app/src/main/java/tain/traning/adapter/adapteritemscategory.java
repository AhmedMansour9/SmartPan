package tain.traning.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import tain.traning.Business.ListItemCart;
import tain.traning.Model.Category;
import tain.traning.Model.Categoryitem;
import tain.traning.Model.ItemCart;
import tain.traning.R;
import tain.traning.Views.Card;
import tain.traning.Views.Categoryitemview;
import tain.traning.itemscategory;

/**
 * Created by HP on 28/07/2018.
 */

public class adapteritemscategory extends RecyclerView.Adapter<adapteritemscategory.MyViewHolder>{
     List<Categoryitem> cate = new ArrayList<>();
    Context cont;
   public static List<ItemCart> itemcart= new ArrayList<>();
    Categoryitemview categorycount;

    public adapteritemscategory(List<Categoryitem> move, Context cont) {
        this.cate = move;
        this.cont=cont;
    }
    public void setlistcounter(Categoryitemview catt) {
        this.categorycount=catt;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,count,textprice;
        public ImageView img,plus,minus,cart;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.textimage);
            img = view.findViewById(R.id.ImageItem);
            count=view.findViewById(R.id.contuner);
            plus=view.findViewById(R.id.plus);
            minus=view.findViewById(R.id.minus);
           textprice=view.findViewById(R.id.textprice);
           cart=view.findViewById(R.id.card);
        }

    }


    @Override
    public adapteritemscategory.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemscategoryitem, parent, false);
        return new adapteritemscategory.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final adapteritemscategory.MyViewHolder holder, final int position) {
        final Categoryitem email = cate.get(position);

        holder.title.setText(email.getEnglishName());
        holder.textprice.setText(String.valueOf(email.getPrice()));

        Picasso.with(cont)
                .load(email.getImageUrl())
                .into(holder.img);

       holder.plus.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int a=Integer.parseInt(holder.count.getText().toString());
               a++;
               holder.count.setText(String.valueOf(a));

           }
       });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(holder.count.getText().toString());
                if(a>1) {
                    a--;
                    holder.count.setText(String.valueOf(a));
                }
            }
        });
        holder.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(holder.count.getText().toString());
                ItemCart category=new ItemCart(email.getImageUrl(),email.getEnglishName(),email.getPrice(),email.getCount());
                itemcart.add(category);
                categorycount.counter(String.valueOf(itemcart.size()));
                ListItemCart   lisst=new ListItemCart();
                lisst.Listitem(category);

                Toast.makeText(cont, ""+itemcart.size(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return cate.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


}
