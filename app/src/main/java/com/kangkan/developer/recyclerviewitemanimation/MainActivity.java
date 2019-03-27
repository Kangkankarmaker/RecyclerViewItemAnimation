package com.kangkan.developer.recyclerviewitemanimation;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView NewsRecycleView;
    NewsAdapter newsAdapter;
    List<NewsItem>mData;

    FloatingActionButton floatingActionButton;
    boolean isDark=false;
    RelativeLayout rootlayout;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        floatingActionButton=findViewById(R.id.fab_switcher_color);
        rootlayout=findViewById(R.id.rootLayout);

        NewsRecycleView =findViewById(R.id.rec);
        mData=new ArrayList<>();

        isDark=getThemepref();
        if (isDark){
            rootlayout.setBackgroundColor(getResources().getColor(android.R.color.black));
        }else {
            rootlayout.setBackgroundColor(getResources().getColor(android.R.color.white));
        }

        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));


        newsAdapter=new NewsAdapter(this,mData,isDark);
        NewsRecycleView.setAdapter(newsAdapter);
        NewsRecycleView.setLayoutManager(new LinearLayoutManager(this));



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isDark=!isDark;

                if (isDark){
                    rootlayout.setBackgroundColor(getResources().getColor(R.color.black));
                }else {
                    rootlayout.setBackgroundColor(getResources().getColor(R.color.white));
                }
                newsAdapter=new NewsAdapter(getApplicationContext(),mData,isDark);
                NewsRecycleView.setAdapter(newsAdapter);

                saveThemepref(isDark);

            }
        });

    }

    private void saveThemepref(boolean isDark) {

        SharedPreferences pref=getApplicationContext().getSharedPreferences("mypref",MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putBoolean("isDark",isDark);
        editor.commit();
    }

    private  boolean getThemepref (){
        SharedPreferences pref=getApplicationContext().getSharedPreferences("mypref",MODE_PRIVATE);
        boolean isDark=pref.getBoolean("isDark",false);
        return isDark;

    }

}
