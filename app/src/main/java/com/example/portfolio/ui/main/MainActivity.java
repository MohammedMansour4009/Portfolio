package com.example.portfolio.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.portfolio.R;
import com.example.portfolio.databinding.ActivityMainBinding;
import com.example.portfolio.model.experience.Experience;
import com.example.portfolio.model.experience.InfoExperience;
import com.example.portfolio.model.portfolio.details.ImageApp;
import com.example.portfolio.model.portfolio.details.PortfolioDetails;
import com.example.portfolio.model.portfolio.details.Skills;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseBindingActivity<ActivityMainBinding> {
    NavController navController;
    AppBarConfiguration appBarConfiguration ;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        init();
        setToolbar();
        setNavBottomAndDrawerNav();

//        upload();

    }
    private void init() {
        navController  = Navigation.findNavController(this, R.id.nav_host_fragment);
        appBarConfiguration= new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(binding.drawerLayout).build();

    }
    private void setToolbar() {
        setSupportActionBar(binding.toolbar);
        binding.toolbar.setTitle("Portfolio");

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
        //action global
            return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }
    @Override //play backButton at toolbar
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    private void upload() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        List<Skills> skillsList= new ArrayList<>();
        List<ImageApp> imageAppList= new ArrayList<>();
        skillsList.add(new Skills("https://as2.ftcdn.net/jpg/01/08/28/37/500_F_108283790_YYMKdb7m1qdEiPvaJ9we0Bunbf5wvBtK.jpg" ,"JETPACK" ));
        skillsList.add(new Skills("https://as2.ftcdn.net/jpg/01/08/28/37/500_F_108283790_YYMKdb7m1qdEiPvaJ9we0Bunbf5wvBtK.jpg" ,"JAVA" ));
        skillsList.add(new Skills("https://as2.ftcdn.net/jpg/01/08/28/37/500_F_108283790_YYMKdb7m1qdEiPvaJ9we0Bunbf5wvBtK.jpg" ,"MVVM" ));


        imageAppList.add(new ImageApp("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkiniJpEU3VNSvHGgdBZC0x56pUz1hFrRYPw&usqp=CAU"));
        imageAppList.add(new ImageApp("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkiniJpEU3VNSvHGgdBZC0x56pUz1hFrRYPw&usqp=CAU"));
        imageAppList.add(new ImageApp("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkiniJpEU3VNSvHGgdBZC0x56pUz1hFrRYPw&usqp=CAU"));
        imageAppList.add(new ImageApp("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkiniJpEU3VNSvHGgdBZC0x56pUz1hFrRYPw&usqp=CAU"));
        imageAppList.add(new ImageApp("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkiniJpEU3VNSvHGgdBZC0x56pUz1hFrRYPw&usqp=CAU"));



        PortfolioDetails ProfileFragment = new PortfolioDetails("https://lh3.googleusercontent.com/51Xn7o1k5VQdidtpFstgxrEQtkxWGL-mak-rmLlIUNXgZWe0uJFiL2CMeCDtfEwpJ-Q=s124","https://lh3.googleusercontent.com/4ul6qCmQ9csyOEOhRY4IrTZGwK6H2EqoFCbHJ5n-rbmwMeJk9snpqeA5zckE0hh9FZD5Akg=s85","Portfolio App 2.0","Portfolio App","Nav 2018 - Aug 2019 | 9 month()s","s","s",skillsList,imageAppList,"This is the latest version of my portfolio app where I want to share my skills and passion for Android development and it's a result of what I've learned through my learning of Kotlin and Android Jetpack, Material design and Firebase components. The app was written in Kotlin, built with Android Jetpack components and many third-party libraries such as Retrofit, OkHttp, Glide, LeanCanary, Koin, Kotlin Coroutines, etc. The code is available on Github, and it may help others to learn the latest Android development technologies to build fully functional Android apps. ","Applied number of best practices from the Android community, and l'm thankful to everyone who shared their knowledge and experience through social media and blog posts.");
        mDatabase.child("info Activity PortfolioDetails ").child("PortfolioDetails").setValue(ProfileFragment);
    }
}