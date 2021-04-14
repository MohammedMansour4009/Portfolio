package com.zero1tec.portfolio.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.zero1tec.portfolio.R;
import com.zero1tec.portfolio.databinding.ActivityMainBinding;
import com.zero1tec.portfolio.model.experience.details.ExperienceDetails;
import com.zero1tec.portfolio.model.experience.details.InfoLink;
import com.zero1tec.portfolio.model.experience.details.InfoResponsibilities;
import com.zero1tec.portfolio.model.experience.details.LatLngMy;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseBindingActivity<ActivityMainBinding> {
    private NavController navController;
    private AppBarConfiguration appBarConfiguration ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        init();
        setToolbar();
        setNavBottomAndDrawerNav();



    }
    private void init() {
        navController  = Navigation.findNavController(this, R.id.nav_host_fragment);
        appBarConfiguration= new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(binding.drawerLayout).build();

    }
    private void setToolbar() {
        setSupportActionBar(binding.toolbar);

    }


    private void setNavBottomAndDrawerNav() {
        NavigationUI.setupWithNavController(binding.bottomNav,navController);
        NavigationUI.setupWithNavController(binding.navView,navController);
        NavigationUI.setupActionBarWithNavController(this, navController,appBarConfiguration);
    }
    @Override
    protected ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }
    @Override //play back Button at toolbar
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }


}