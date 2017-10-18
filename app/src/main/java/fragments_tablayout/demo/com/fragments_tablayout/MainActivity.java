package fragments_tablayout.demo.com.fragments_tablayout;

//import android.app.Fragment;
//import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;
import android.support.design.widget.TabLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static MyPageAdapter pageAdapter;
    public static TabLayout tabLayout;
    public static ArrayList tabTitles = new ArrayList();
    public static ViewPager pager;
    public static ArrayList<Fragment> fragmentsList = new ArrayList<Fragment>();
    public static int tabCounter = 0;
    public static FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragmentsList);

        pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setOffscreenPageLimit(20);
        pager.setAdapter(pageAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);

        tabTitles.add("Tab0");
        fragmentsList.add(Tab1.newInstance("Fragment 0"));
        tabCounter++;
        pageAdapter.notifyDataSetChanged();

    }

    @Override
    public void onStop() {
        Log.d("Home123", "Home button pressed");
        super.onStop();
        testFirstRun();
    }

    public void testFirstRun(){

        int currentVersionCode = 0;
        try {
            currentVersionCode = getPackageManager().getPackageInfo(getPackageName(),0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        if(currentVersionCode != 0){
            Log.d("Home123", "Current Version code: " + currentVersionCode);
            SharedPreferences storedVersionCode = getApplicationContext().getSharedPreferences("storedVersionCode", 0);
            int oldVersionCode = storedVersionCode.getInt("storedVersionCode", 0);
            if(currentVersionCode > oldVersionCode){
                //Toast.makeText(this, "New version detected", Toast.LENGTH_LONG).show();
                Log.d("Home123", "Stored Version code: " + oldVersionCode);
                Log.d("Home123", "New version detected");
                SharedPreferences settings = getSharedPreferences("storedVersionCode", 0);
                SharedPreferences.Editor edit = settings.edit();
                edit.putInt("storedVersionCode", currentVersionCode); //set to has run
                edit.commit(); //apply
                android.os.Process.killProcess(android.os.Process.myPid());
            }
            else{
                Log.d("Home123", "Stored Version code: " + oldVersionCode);
                Log.d("Home123", "Same version detected");
            }
        }

//        //this.context = context;
//        SharedPreferences runCheck = getApplicationContext().getSharedPreferences("hasRunBefore", 0); //load the preferences
//        Boolean hasRun = runCheck.getBoolean("hasRun", false); //see if it's run before, default no
//        if (!hasRun) {
//            SharedPreferences settings = getSharedPreferences("hasRunBefore", 0);
//            SharedPreferences.Editor edit = settings.edit();
//            edit.putBoolean("hasRun", true); //set to has run
//            edit.commit(); //apply
//            //code for if this is the first time the app has run
//            Log.d("Home123", "First run");
//            //finish();
////            finishAffinity();
//            android.os.Process.killProcess(android.os.Process.myPid());
//        }
//        else {
//            Log.d("Home123", "Later run");
//            //code if the app HAS run before
//        }
    }
}
