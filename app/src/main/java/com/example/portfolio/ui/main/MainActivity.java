package com.example.portfolio.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.portfolio.R;
import com.example.portfolio.databinding.ActivityMainBinding;
import com.example.portfolio.model.experience.Experience;
import com.example.portfolio.model.experience.InfoExperience;
import com.example.portfolio.model.experience.details.ExperienceDetails;
import com.example.portfolio.model.experience.details.InfoLink;
import com.example.portfolio.model.experience.details.InfoResponsibilities;
import com.example.portfolio.model.experience.details.LatLngMy;
import com.example.portfolio.model.portfolio.details.ImageApp;
import com.example.portfolio.model.portfolio.details.PortfolioDetails;
import com.example.portfolio.model.portfolio.details.Skills;
import com.example.portfolio.model.profile.Media;
import com.example.portfolio.model.profile.MoreInfo;
import com.example.portfolio.model.profile.Profile;
import com.example.portfolio.model.setting.Options;
import com.example.portfolio.model.setting.Setting;
import com.example.portfolio.model.setting.TitleOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseBindingActivity<ActivityMainBinding> {
    private NavController navController;
    private AppBarConfiguration appBarConfiguration ;
    private DatabaseReference mDatabase;


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
        //action global
            return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }
    @Override //play backButton at toolbar
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    private void upload() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
//        List<InfoExperience> titleOptionsList =new ArrayList<>();/s1
//        List<Options>  optionsList=new ArrayList<>(); //s2
        int index = 0;
        List<InfoResponsibilities> infoResponsibilitiesList =new ArrayList<>();
        infoResponsibilitiesList.add(new InfoResponsibilities(++index+"", "I built this app to show my skills passion for design and development passion for design and development"));
        infoResponsibilitiesList.add(new InfoResponsibilities(++index+"", "I built this app to show my skills passion for design and development passion for design and development"));
        infoResponsibilitiesList.add(new InfoResponsibilities(++index+"", "I built this app to show my skills passion for design and development passion for design and development"));
        infoResponsibilitiesList.add(new InfoResponsibilities(++index+"", "I built this app to show my skills passion for design and development passion for design and development"));
        infoResponsibilitiesList.add(new InfoResponsibilities(++index+"", "I built this app to show my skills passion for design and development passion for design and development"));

        List<InfoLink> infoLinkList = new ArrayList<>();
        infoLinkList.add(new InfoLink("https://ih1.redbubble.net/image.1469631910.3488/st,small,845x845-pad,1000x1000,f8f8f8.jpg","Personal Portfokio ","NAV 2018-Aug2019 month(s)"));
        infoLinkList.add(new InfoLink("https://ih1.redbubble.net/image.1469631910.3488/st,small,845x845-pad,1000x1000,f8f8f8.jpg","Personal Portfokio ","NAV 2018-Aug2019 month(s)"));
        infoLinkList.add(new InfoLink("https://ih1.redbubble.net/image.1469631910.3488/st,small,845x845-pad,1000x1000,f8f8f8.jpg","Personal Portfokio ","NAV 2018-Aug2019 month(s)"));
        infoLinkList.add(new InfoLink("https://ih1.redbubble.net/image.1469631910.3488/st,small,845x845-pad,1000x1000,f8f8f8.jpg","Personal Portfokio ","NAV 2018-Aug2019 month(s)"));
        infoLinkList.add(new InfoLink("https://ih1.redbubble.net/image.1469631910.3488/st,small,845x845-pad,1000x1000,f8f8f8.jpg","Personal Portfokio ","NAV 2018-Aug2019 month(s)"));




//
//        optionsList.add(new Options("https://lh3.googleusercontent.com/Pj7Y868nyXUhV6STMrTENWlNruv0VM0EREMp0EIspBauv0x3nN-pm41gzJ4e0-kxiiOu=s88","Choose","Light","uri"));
//        optionsList.add(new Options("https://lh3.googleusercontent.com/Pj7Y868nyXUhV6STMrTENWlNruv0VM0EREMp0EIspBauv0x3nN-pm41gzJ4e0-kxiiOu=s88","Choose","Light","uri"));
//        optionsList.add(new Options("https://lh3.googleusercontent.com/Pj7Y868nyXUhV6STMrTENWlNruv0VM0EREMp0EIspBauv0x3nN-pm41gzJ4e0-kxiiOu=s88","Choose","Light","uri"));
//        optionsList.add(new Options("https://lh3.googleusercontent.com/Pj7Y868nyXUhV6STMrTENWlNruv0VM0EREMp0EIspBauv0x3nN-pm41gzJ4e0-kxiiOu=s88","Choose","Light","uri"));
//
//        titleOptionsList.add(new InfoExperience(1,"https://ih1.redbubble.net/image.1469631910.3488/st,small,845x845-pad,1000x1000,f8f8f8.jpg","https://lh3.googleusercontent.com/4ul6qCmQ9csyOEOhRY4IrTZGwK6H2EqoFCbHJ5n-rbmwMeJk9snpqeA5zckE0hh9FZD5Akg=s85","Portfolio App 2.0 ","Daimler AG","Stuttgart ,Gernmany","Nov 2018 Aug 2019 | 9"));
//        titleOptionsList.add(new InfoExperience(1,"https://ih1.redbubble.net/image.1469631910.3488/st,small,845x845-pad,1000x1000,f8f8f8.jpg","https://lh3.googleusercontent.com/4ul6qCmQ9csyOEOhRY4IrTZGwK6H2EqoFCbHJ5n-rbmwMeJk9snpqeA5zckE0hh9FZD5Akg=s85","Portfolio App 2.0 ","Daimler AG","Stuttgart ,Gernmany","Nov 2018 Aug 2019 | 9"));
//        titleOptionsList.add(new InfoExperience(1,"https://ih1.redbubble.net/image.1469631910.3488/st,small,845x845-pad,1000x1000,f8f8f8.jpg","https://lh3.googleusercontent.com/4ul6qCmQ9csyOEOhRY4IrTZGwK6H2EqoFCbHJ5n-rbmwMeJk9snpqeA5zckE0hh9FZD5Akg=s85","Portfolio App 2.0 ","Daimler AG","Stuttgart ,Gernmany","Nov 2018 Aug 2019 | 9"));
//        titleOptionsList.add(new InfoExperience(1,"https://ih1.redbubble.net/image.1469631910.3488/st,small,845x845-pad,1000x1000,f8f8f8.jpg","https://lh3.googleusercontent.com/4ul6qCmQ9csyOEOhRY4IrTZGwK6H2EqoFCbHJ5n-rbmwMeJk9snpqeA5zckE0hh9FZD5Akg=s85","Portfolio App 2.0 ","Daimler AG","Stuttgart ,Gernmany","Nov 2018 Aug 2019 | 9"));




        ExperienceDetails setting = new ExperienceDetails("https://uploads-ssl.webflow.com/5f00d108e4e56c01c959e07a/5fa7ed04af64f3ace3d7c2d1_7-Advantages-of-Using-a-Mobile-Ordering-App-for-Your-Restaurant.jpg","https://ih1.redbubble.net/image.1469631910.3488/st,small,845x845-pad,1000x1000,f8f8f8.jpg","Portfolio App 2.0 ","Daimler AG","Stuttgart ,Gernmany","Nov 2018 Aug 2019 | 9","https://play.google.com/store/apps/collection/topselling_paid?clp=ChcKFQoPdG9wc2VsbGluZ19wYWlkEAcYAw%3D%3D:S:ANO1ljKH1g0&gsr=ChkKFwoVCg90b3BzZWxsaW5nX3BhaWQQBxgD:S:ANO1ljK56mE&utm_source=emea_Med&utm_medium=hasem&utm_content=Apr2815&utm_campaign=Evergreen&pcampaignid=MKT-EDR-emea-jo-all-Med-hasem-py-Evergreen-Apr2815-Text_Search&gclid=CjwKCAjw9r-DBhBxEiwA9qYUpaaA1PKMqjpRzgqM8K8l7mCrlb0owcjix0PL9LPSwpuUrrZApvHSlhoCmBUQAvD_BwE","https://play.google.com/store/apps/collection/topselling_paid?clp=ChcKFQoPdG9wc2VsbGluZ19wYWlkEAcYAw%3D%3D:S:ANO1ljKH1g0&gsr=ChkKFwoVCg90b3BzZWxsaW5nX3BhaWQQBxgD:S:ANO1ljK56mE&utm_source=emea_Med&utm_medium=hasem&utm_content=Apr2815&utm_campaign=Evergreen&pcampaignid=MKT-EDR-emea-jo-all-Med-hasem-py-Evergreen-Apr2815-Text_Search&gclid=CjwKCAjw9r-DBhBxEiwA9qYUpaaA1PKMqjpRzgqM8K8l7mCrlb0owcjix0PL9LPSwpuUrrZApvHSlhoCmBUQAvD_BwE","Self study through online resources  ","Responsibilities",infoResponsibilitiesList,"Links",infoLinkList,new LatLngMy(32.06614560182808, 36.048985749434216));
        mDatabase.child("info_Activity_Experience_Details ").child("Experience_Details").setValue(setting);
    }
}