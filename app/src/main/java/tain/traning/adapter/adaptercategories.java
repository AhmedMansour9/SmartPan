package tain.traning.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import tain.traning.Categories;
import tain.traning.Model.Category;
import tain.traning.Model.City;
import tain.traning.R;
import tain.traning.Views.Card;
import tain.traning.itemscategory;

/**
 * Created by HP on 21/07/2018.
 */

public class adaptercategories extends RecyclerView.Adapter<adaptercategories.MyViewHolder> implements Filterable
{
    private List<Category> mArrayList;
    private List<Category> movie = new ArrayList<>();
   Context cont;

    public static List<Category> filteredList = new ArrayList<>();
    public adaptercategories(List<Category> movie, Context cont) {
        this.movie = movie;
        this.cont=cont;
        mArrayList=movie;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView img;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.tcategory);
            img = view.findViewById(R.id.imgcategory);

        }

    }
    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                filteredList.clear();
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    movie = mArrayList;
                } else {
                    for (Category androidVersion : mArrayList) {
                        if (androidVersion.getEnglishName().toLowerCase().contains(charString)) {
                            filteredList.add(androidVersion);}}
                    movie = filteredList;}
                FilterResults filterResults = new FilterResults();
                filterResults.values = movie;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                movie = (List<Category>) filterResults.values;

                notifyDataSetChanged();
            }
        };

    }


    @Override
    public adaptercategories.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemcategory, parent, false);
        return new adaptercategories.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final adaptercategories.MyViewHolder holder, final int position) {
        final Category email = movie.get(position);

        holder.title.setText(email.getEnglishName());

        Picasso.with(cont)
                .load(email.getImage())
                .into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inty=new Intent(cont,itemscategory.class);
                inty.putExtra("id",email.getCategoryId());
                cont.startActivity(inty);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movie.size();
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