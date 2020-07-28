package com.example.makerschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    TextView hola;
    GridLayout gridLayout;

    CardView idea;
    CardView implement;
    CardView project;
    CardView space;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hola = findViewById(R.id.hola);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.drawer);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        //gridLayout = findViewById(R.id.gridLayout);
        //setSingleEvent(gridLayout);
        //setToggleEvent(gridLayout);

        idea = findViewById(R.id.idea);
        project = findViewById(R.id.project);
        implement = findViewById(R.id.implement);
        space = findViewById(R.id.space);

        idea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(idea.getCardBackgroundColor().getDefaultColor() == -1) {

                    idea.setCardBackgroundColor(Color.parseColor("#faef04"));
                    startActivity(new Intent(Home.this, Idea.class));
                    idea.setCardBackgroundColor(Color.parseColor("#ffffff"));
                }
                else{
                    idea.setCardBackgroundColor(Color.parseColor("#ffffff"));
                }
            }
        });

        project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Project.class));
            }
        });

        implement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Implement.class));
            }
        });

        space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Space.class));
            }
        });
    }





    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        String itemName =  (String)menuItem.getTitle();
        hola.setText(itemName);
        closeDrawer();

        switch (menuItem.getItemId()){
            case R.id.item1:
                break;

            case R.id.item2:
                break;
        }
        return true;
    }

    private void closeDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    private  void  openDrawer(){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            closeDrawer();
        }
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.right_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id==R.id.item8){
            hola.setText("Settings");
        }
       
        else if (id==R.id.item10){
            hola.setText("Successfully Logged Out!!!");
        }

        return super.onOptionsItemSelected(item);

    }
}
