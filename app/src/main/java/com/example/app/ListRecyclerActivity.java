package com.example.app;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListRecyclerActivity extends AppCompatActivity {

    private List<Country> countryList;
    private CountryRecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_recycler);

        initData();

        RecyclerView recyclerView = findViewById(R.id.rvCountries);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        adapter = new CountryRecyclerAdapter(countryList);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fabAdd);
        fab.setOnClickListener(v -> showAddDialog());
    }

    private void initData() {
        countryList = new ArrayList<>();
        countryList.add(new Country("Maroc", R.drawable.maroc));
        countryList.add(new Country("France", R.drawable.france));
        countryList.add(new Country("USA", R.drawable.usa));
    }

    private void showAddDialog() {
        EditText et = new EditText(this);
        et.setHint("Nom du pays (ex: Japon)");
        new AlertDialog.Builder(this)
                .setTitle("Ajouter un pays")
                .setView(et)
                .setPositiveButton("Ajouter", (dialog, which) -> {
                    String name = et.getText().toString().trim();
                    if (!name.isEmpty()) {
                        String resourceName = name.toLowerCase()
                                .replace("é", "e").replace("è", "e")
                                .replace("ê", "e").replace("ï", "i")
                                .replace("ô", "o").replace(" ", "_");

                        if (resourceName.equals("italie")) resourceName = "italy";
                        if (resourceName.equals("argentine")) resourceName = "argentina";
                        if (resourceName.equals("afrique_du_sud")) resourceName = "afs";
                        if (resourceName.equals("bresil") || resourceName.equals("brésil")) resourceName = "brezil";
                        if (resourceName.equals("mexique")) resourceName = "meique";
                        if (resourceName.equals("chine")) resourceName = "china";
                        if (resourceName.equals("inde")) resourceName = "india";
                        if (resourceName.equals("russie")) resourceName = "russia";
                        if (resourceName.equals("coree_du_sud") || resourceName.equals("corée_du_sud")) resourceName = "south_korea";

                        int resId = getResources().getIdentifier(resourceName, "drawable", getPackageName());

                        if (resId == 0) {
                            resId = R.drawable.usa;
                            Toast.makeText(this, "Drapeau non trouvé, icône par défaut utilisée", Toast.LENGTH_SHORT).show();
                        }

                        countryList.add(new Country(name, resId));
                        adapter.notifyItemInserted(countryList.size() - 1);
                    }
                })
                .setNegativeButton("Annuler", null)
                .show();
    }

    class CountryRecyclerAdapter extends RecyclerView.Adapter<CountryRecyclerAdapter.ViewHolder> {
        private List<Country> items;

        public CountryRecyclerAdapter(List<Country> items) {
            this.items = items;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_country, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Country country = items.get(position);
            holder.tvName.setText(country.getName());
            holder.ivFlag.setImageResource(country.getFlagResource());

            holder.itemView.setOnLongClickListener(v -> {
                new AlertDialog.Builder(ListRecyclerActivity.this)
                        .setTitle("Supprimer")
                        .setMessage("Voulez-vous supprimer " + country.getName() + " ?")
                        .setPositiveButton("Oui", (dialog, which) -> {
                            int pos = holder.getAdapterPosition();
                            items.remove(pos);
                            notifyItemRemoved(pos);
                        })
                        .setNegativeButton("Non", null)
                        .show();
                return true;
            });

            holder.itemView.setOnClickListener(v -> {
                EditText et = new EditText(ListRecyclerActivity.this);
                et.setText(country.getName());
                new AlertDialog.Builder(ListRecyclerActivity.this)
                        .setTitle("Modifier")
                        .setView(et)
                        .setPositiveButton("Enregistrer", (dialog, which) -> {
                            country.setName(et.getText().toString());
                            notifyItemChanged(holder.getAdapterPosition());
                        })
                        .setNegativeButton("Annuler", null)
                        .show();
            });
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView ivFlag;
            TextView tvName;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                ivFlag = itemView.findViewById(R.id.countryFlag);
                tvName = itemView.findViewById(R.id.countryName);
            }
        }
    }
}