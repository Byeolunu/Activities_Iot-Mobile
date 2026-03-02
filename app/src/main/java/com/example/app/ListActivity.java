package com.example.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListActivity extends AppCompatActivity {

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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView listView = findViewById(R.id.countryListView);

        CountryAdapter adapter = new CountryAdapter();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedCountry = countries[position];
            Toast.makeText(ListActivity.this, "Pays sélectionné : " + selectedCountry, Toast.LENGTH_SHORT).show();
        });
    }

    class CountryAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return countries.length;
        }

        @Override
        public Object getItem(int position) {
            return countries[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(ListActivity.this).inflate(R.layout.list_item_country, parent, false);
            }

            ImageView flagView = convertView.findViewById(R.id.countryFlag);
            TextView nameView = convertView.findViewById(R.id.countryName);

            flagView.setImageResource(flags[position]);
            nameView.setText(countries[position]);

            return convertView;
        }
    }
}