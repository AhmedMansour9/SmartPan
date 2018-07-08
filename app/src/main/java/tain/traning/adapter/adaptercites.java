package tain.traning.adapter;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tain.traning.Model.City;
import tain.traning.R;

/**
 * Created by HP on 08/07/2018.
 */

public class adaptercites extends RecyclerView.Adapter<adaptercites.MyViewHolder>{

    private List<City> movie=new ArrayList<>();


    public adaptercites(List<City> movie) {
        this.movie=movie;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        public TextView title;
        public TextView btndelete;
        public TextView confirm;

        public MyViewHolder(View view) {
            super(view);
            title =  view.findViewById(R.id.id);
            btndelete=view.findViewById(R.id.arabicname);
            confirm=view.findViewById(R.id.englishname);

        }

    }





    @Override
    public adaptercites.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemcites, parent, false);
        return new adaptercites.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final adaptercites.MyViewHolder holder, final int position) {
        City email=movie.get(position);
        holder.btndelete.setText(email.getArabicName());
        holder.title.setText(email.getEnglishName());

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
