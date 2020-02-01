package com.nucldev.simpleweatherlocator.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nucldev.simpleweatherlocator.R;
import com.nucldev.simpleweatherlocator.netinteraction.forecastpojo.ListItem;

import java.util.List;


public class ForecastRecyclerViewAdapter extends RecyclerView.Adapter<ForecastRecyclerViewAdapter.ForecastViewHolder> {
        private List<ListItem> list;

        public ForecastRecyclerViewAdapter(List<ListItem> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            int itemLayout = R.layout.item_forecast;
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(itemLayout, parent, false);
            ForecastViewHolder forecastViewHolder = new ForecastViewHolder(view);
            return  forecastViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
            holder.bind(this.list.get(position).toString());
        }

        @Override
        public int getItemCount() {
            return this.list.size();
        }

        class ForecastViewHolder extends RecyclerView.ViewHolder {
            TextView forecastItem;
            public ForecastViewHolder(@NonNull View itemView) {
                super(itemView);
                forecastItem = itemView.findViewById(R.id.forecastItemTextView);
            }
            void bind (String s){
                this.forecastItem.setText(s);
            }
        }


}
