package com.inreadyworkgroup.drtravel_beta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.inreadyworkgroup.drtravel_beta.ui.home.HomeFragment;
import com.inreadyworkgroup.drtravel_beta.ui.lainnya.LainnyaFragment;
import com.inreadyworkgroup.drtravel_beta.ui.penanda.PenandaFragment;
import com.inreadyworkgroup.drtravel_beta.ui.wisata.WisataFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

//    static MainActivity activity_home;
//
//    public static MainActivity getInstance() {
//        return activity_home;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        activity_home = this;

        //set default Home Fragment
        loadFragment(new HomeFragment());

        BottomNavigationView navView =findViewById(R.id.bn_main);

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupWithNavController(navView, navController);

        navView.setOnNavigationItemSelectedListener(this);

    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        //switch case fragment{}
        switch (menuItem.getItemId()){
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_wisata:
                fragment = new WisataFragment();
                break;
            case R.id.navigation_penanda:
                fragment = new PenandaFragment();
                break;
            case R.id.navigation_lainnya:
                fragment = new LainnyaFragment()    ;
                break;
        }
        return loadFragment(fragment);
    }
}