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

import tain.traning.Model.Categoryitem;
import tain.traning.Model.ItemCart;
import tain.traning.R;
import tain.traning.Views.Categoryitemview;

/**
 * Created by HP on 08/08/2018.
 */

public class adaptercard extends RecyclerView.Adapter<adaptercard.MyViewHolder> {
    List<ItemCart> cate = new ArrayList<>();
    Context cont;

    public adaptercard(List<ItemCart> move, Context cont) {
        this.cate = move;
        this.cont = cont;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count, textprice;
        public ImageView img, plus, minus, cart;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.textenglissh);
            img = view.findViewById(R.id.Imagecard);
            count = view.findViewById(R.id.contune);
            plus = view.findViewById(R.id.pluss);
            minus = view.findViewById(R.id.minuss);
            textprice = view.findViewById(R.id.textpric);
            cart = view.findViewById(R.id.carddd);
        }

    }


    @Override
    public adaptercard.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemcard, parent, false);
        return new adaptercard.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final adaptercard.MyViewHolder holder, final int position) {
        ItemCart email = cate.get(position);

//        holder.title.setText(email.getItem_name());/
        holder.textprice.setText(String.valueOf(email.getItem_price()));

        Picasso.with(cont)
                .load(email.getItem_url())
                .into(holder.img);

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(holder.count.getText().toString());
                a++;
                holder.count.setText(String.valueOf(a));

            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(holder.count.getText().toString());
                if (a > 1) {
                    a--;
                    holder.count.setText(String.valueOf(a));
                }
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