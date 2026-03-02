package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class App_ListGridSpinner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_app_list_grid_spinner);

        Button list = findViewById(R.id.list);
        Button grid = findViewById(R.id.grid);
        Button recyclerList = findViewById(R.id.recyclerList);
        Button recyclerGrid = findViewById(R.id.recyclerGrid);


        list.setOnClickListener(v -> {
            startActivity(new Intent(this, ListActivity.class));
        });

        grid.setOnClickListener(v -> {
            startActivity(new Intent(this, GridActivity.class));
        });


        recyclerList.setOnClickListener(v -> {
            startActivity(new Intent(this, ListRecyclerActivity.class));
        });

        recyclerGrid.setOnClickListener(v -> {
            startActivity(new Intent(this, GridRecyclerActivity.class));
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        getMenuInflater().inflate(R.menu.menu_test,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id=item.getItemId();
//        if(id==R.id.listMenu)
//        {
//            startActivity(new Intent(this,ListActivity.class));
//        }
//        if (id==R.id.gridMenu)
//        {
//            startActivity(new Intent(this,GridActivity.class));
//        }
//        return super.onOptionsItemSelected(item);
//    }
//}
