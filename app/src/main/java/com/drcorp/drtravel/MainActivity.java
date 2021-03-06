package com.drcorp.drtravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.drcorp.drtravel.login.RegisterActivity;
import com.drcorp.drtravel.storage.SharedPrefManager;
import com.drcorp.drtravel.ui.home.HomeFragment;
import com.drcorp.drtravel.ui.lainnya.LainnyaFragment;
import com.drcorp.drtravel.ui.penanda.PenandaFragment;
import com.drcorp.drtravel.ui.wisata.WisataFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set default Home Fragment
        loadFragment(new HomeFragment());

        BottomNavigationView navView =findViewById(R.id.bn_main);
        navView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(this, RegisterActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
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

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

//        AlertDialog alertbox = new AlertDialog.Builder(this)
//                .setMessage("Yakin ingin keluar ?")
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//
//                    // do something when the button is clicked
//                    public void onClick(DialogInterface arg0, int arg1) {
//
//                        finish();
//                        //close();
//
//
//                    }
//                })
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//
//                    // do something when the button is clicked
//                    public void onClick(DialogInterface arg0, int arg1) {
//                    }
//                })
//                .show();

    }
}