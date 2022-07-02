package com.example.godjunpyo_recent;

import android.content.ClipData;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.constraintlayout.widget.Group;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.godjunpyo_recent.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        binding.appBarMain.toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "This function is not supported", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
/** this section is a comment for the floating button which had been declared in layout/app_bar_main.xml **/
/*
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This function is not supported", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
 */
        DrawerLayout drawer = binding.drawerLayout;
        navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,
                R.id.nav_board,
                R.id.nav_normal_mentoring,
                R.id.nav_prof_mentoring,
                R.id.nav_see_all,
                R.id.nav_solid,
                R.id.nav_eng_math,
                R.id.nav_material,
                R.id.nav_dynamics,
                R.id.nav_thermo,
                R.id.nav_transfer,
                R.id.nav_fluid,
                R.id.nav_auto_control,
                R.id.nav_material_behavior,
                R.id.nav_statics,
                R.id.nav_vibration,
                R.id.nav_coding)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        /** for navigator icons' color **/
        setMenuColors();

        /** variables for external sources **/
        MenuItem menuItem = navigationView.getMenu().getItem(3);
        MenuItem item_youtube = menuItem.getSubMenu().getItem(0);
        MenuItem item_webpage = menuItem.getSubMenu().getItem(1);

        /** for youtube channel open **/
        item_youtube.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                openYouTube("https://www.youtube.com/channel/UCJnkVzabcISCdf7TXT66O2A");
                return true;
            }
        });

        /** for godjunpyo homepage open **/
        item_webpage.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                openWebBrowser("https://godjunpyo.com");
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void setMenuColors(){
        // Set free ItemIconTintList.
        navigationView.setItemIconTintList(null);
    }

    /** on YouTube **/
    private void openYouTube(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setPackage("com.google.android.youtube");
        startActivity(intent);
    }

    /** on Browser **/
    private void openWebBrowser(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public boolean clickToPopUp(MenuItem menuItem){
        Log.d("POPUP", "clickToPopUp: Pass");
        Intent intent = new Intent(this, PopUpActivity.class);
        startActivity(intent);
        //startActivityForResult(intent, 1);
        return true;
    }
}