package com.example.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GridRecyclerActivity extends AppCompatActivity {
    String[] countries = {
            "Maroc", "France", "USA", "Japon", "Canada",
            "Allemagne", "Italie", "Brésil", "Argentine", "Égypte",
            "Afrique du Sud", "Chine", "Inde", "Russie", "Mexique",
            "Nigéria", "Corée du Sud"
    };

    int[] flags = {
            R.drawable.maroc, R.drawable.france, R.drawable.usa, R.drawable.japon, R.drawable.canada,
            R.drawable.allemagne, R.drawable.italy, R.drawable.brezil, R.drawable.argentina, R.drawable.egypte,
            R.drawable.afs, R.drawable.china, R.drawable.india, R.drawable.russia, R.drawable.meique,
            R.drawable.nigeria, R.drawable.south_korea
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_recycler);

        RecyclerView recyclerView = findViewById(R.id.countryGrid);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        CountryRecyclerAdapter adapter = new CountryRecyclerAdapter(countries, flags);
        recyclerView.setAdapter(adapter);
    }

    class CountryRecyclerAdapter extends RecyclerView.Adapter<CountryRecyclerAdapter.ViewHolder> {

        private String[] countryNames;
        private int[] countryFlags;

        public CountryRecyclerAdapter(String[] names, int[] flags) {
            this.countryNames = names;
            this.countryFlags = flags;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_country, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.tvName.setText(countryNames[position]);
            holder.ivFlag.setImageResource(countryFlags[position]);

            holder.itemView.setOnClickListener(v ->
                    Toast.makeText(GridRecyclerActivity.this, countryNames[position], Toast.LENGTH_SHORT).show()
            );
        }

        @Override
        public int getItemCount() {
            return countryNames.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView ivFlag;
            TextView tvName;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                ivFlag = itemView.findViewById(R.id.gridImage);
                tvName = itemView.findViewById(R.id.gridText);
            }
        }
    }
}
