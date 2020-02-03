package com.nucldev.simpleweatherlocator.ui.main;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nucldev.simpleweatherlocator.R;
import com.nucldev.simpleweatherlocator.components.Main2Activity;

import java.io.File;
import java.nio.file.Path;


public class ForecastRecyclerViewAdapter extends RecyclerView.Adapter<ForecastRecyclerViewAdapter.ForecastViewHolder> {
        private Object[] itemArray;
        private Context context;

        public ForecastRecyclerViewAdapter(Object[] itemArray) {
            this.itemArray = itemArray;
        }

        @NonNull
        @Override
        public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            context = parent.getContext();
            int itemLayout = R.layout.item_forecast;
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(itemLayout, parent, false);
            ForecastViewHolder forecastViewHolder = new ForecastViewHolder(view);
            return  forecastViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
            holder.bind((String[]) this.itemArray[position]);
        }

        @Override
        public int getItemCount() {
            return this.itemArray.length;
        }

        class ForecastViewHolder extends RecyclerView.ViewHolder {
            TextView descriptioTextView;
            TextView temperatureTextView;
            TextView dateTextView;
            ImageView weatherImageView;
            public ForecastViewHolder(@NonNull View itemView) {
                super(itemView);
                descriptioTextView = itemView.findViewById(R.id.descriptionTextView);
                temperatureTextView = itemView.findViewById(R.id.forecastTemperatureTextView);
                dateTextView = itemView.findViewById(R.id.dateTextView);
                weatherImageView = itemView.findViewById(R.id.weatherImageView);
            }
            void bind (String[] sArray){
                this.descriptioTextView.setText(sArray[0]);
                this.dateTextView.setText(sArray[2]);
                String[] arrFromTempreture = sArray[1].split("℃");
                if(Integer.parseInt(arrFromTempreture[0])>=20)
                    this.temperatureTextView.setTextColor(Color.rgb(243,9,9));
                if(Integer.parseInt(arrFromTempreture[0])<20 & Integer.parseInt(arrFromTempreture[0])>=10)
                    this.temperatureTextView.setTextColor(Color.rgb(63,177,22));
                if(Integer.parseInt(arrFromTempreture[0])<10 & Integer.parseInt(arrFromTempreture[0])>=0)
                    this.temperatureTextView.setTextColor(Color.rgb(10,135,240));
                if(Integer.parseInt(arrFromTempreture[0])<0 & Integer.parseInt(arrFromTempreture[0])>-10)
                    this.temperatureTextView.setTextColor(Color.rgb(13,71,161));
                if(Integer.parseInt(arrFromTempreture[0])<=-10)
                    this.temperatureTextView.setTextColor(Color.BLUE);
                this.temperatureTextView.setText(sArray[1]);
                int imgId = context.getResources()
                        .getIdentifier(sArray[3],"drawable", context.getPackageName());
                this.weatherImageView.setImageResource(imgId);
            }
        }


}
