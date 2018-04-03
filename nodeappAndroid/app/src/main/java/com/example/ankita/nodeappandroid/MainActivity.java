package com.example.ankita.nodeappandroid;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.ankita.nodeappandroid.adapter.gridAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
LinearLayout l1;
GridView gridView;
String names[];
int[] image;
boolean flagPagechange;
boolean flagPageChangeSetting=false;
boolean flagPageChangePassword=false;
    Dialog dialogDeleteAccount;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    Spinner s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_login);


        flagPagechange=false;



    }

//    public void coll(View view) {
//        l1.setVisibility(LinearLayout.GONE);
//        Animation animation   =    AnimationUtils.loadAnimation(this, R.anim.anim2);
//        animation.setDuration(500);
//        l1.setAnimation(animation);
//        l1.animate();
//        animation.start();
//    }


    public void mainLayout(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        drawer.closeDrawers();

        gridView=findViewById(R.id.gridView);
        names=new String[]{"Carpenter","Electrician","Mechanic","Plumber","Wall Painter","AC repair","Packers and Movers","Pest Control"};
        image=new int[]{R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user};
        gridAdapter adapter=new gridAdapter(this,names,image);
        gridView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.close: drawer.closeDrawers();
                break;
            case R.id.loginButton:
                flagPagechange=false;
                setContentView(R.layout.activity_main);
                mainLayout();
                break;
            case R.id.linkSignup:
                flagPagechange=true;
                setContentView(R.layout.activity_sign_up);
                break;

            case R.id.linkLogin:
                setContentView(R.layout.activity_main_login);
                flagPagechange=false;
            break;
            case R.id.signupButton:
                setContentView(R.layout.activity_main_login);
                flagPagechange=false;
                break;
            case R.id.nav_logout:
                setContentView(R.layout.activity_main_login);
                break;
            case R.id.postButton:
                post();
                break;
            case R.id.forgotPassword:
                setContentView(R.layout.forgort_password);
                flagPagechange=true;
                break;
            case R.id.nav_profile:
                setContentView(R.layout.profile);
                break;
            case R.id.nav_setting:
                setContentView(R.layout.setting);
                flagPageChangeSetting=true;
                break;
            case R.id.setting_changePassword:
                setContentView(R.layout.changepassword);
                flagPageChangeSetting=false;
                flagPageChangePassword=true;
                break;
            case R.id.setting_deleteAccount:
                showDeleteAccountDialogBox();
                break;
            case R.id.delete_dialog_no_button:
                hideDeleteAccountDialogBox();
                break;
            case R.id.delete_dialog_yes_button:
                flagPageChangeSetting=false;
                hideDeleteAccountDialogBox();
                setContentView(R.layout.activity_main_login);
                break;

        }
    }
    public void post(){
        Intent i = new Intent(this,PostActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed(){
        if (flagPagechange){
            setContentView(R.layout.activity_main_login);
            flagPagechange=false;
        }
        else if(flagPageChangeSetting){
            setContentView(R.layout.activity_main);
            mainLayout();
            flagPageChangeSetting=false;
        }
        else if(flagPageChangePassword)
        {
            setContentView(R.layout.setting);
            flagPageChangePassword=false;
            flagPageChangeSetting=true;
        }
    }
    public void showDeleteAccountDialogBox() {
        dialogDeleteAccount = new Dialog(this);
        dialogDeleteAccount.setContentView(R.layout.delete_acount_dialog_box);
        dialogDeleteAccount.setCancelable(false);
        dialogDeleteAccount.show();
    }
    public void hideDeleteAccountDialogBox()
    {
        dialogDeleteAccount.dismiss();

    }
}
