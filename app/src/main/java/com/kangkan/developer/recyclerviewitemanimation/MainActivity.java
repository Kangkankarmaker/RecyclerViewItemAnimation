package com.kangkan.developer.recyclerviewitemanimation;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
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

    EditText editText;

    @SuppressLint({"WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        floatingActionButton=findViewById(R.id.fab_switcher_color);
        rootlayout=findViewById(R.id.rootLayout);
        editText=findViewById(R.id.editText);

        NewsRecycleView =findViewById(R.id.rec);
        mData=new ArrayList<>();

        isDark=getThemepref();
        if (isDark){
            editText.setBackgroundResource(R.drawable.card_bd_dark);
            rootlayout.setBackgroundColor(getResources().getColor(android.R.color.black));
        }else {
            editText.setBackgroundResource(R.drawable.card_bg);
            rootlayout.setBackgroundColor(getResources().getColor(android.R.color.white));
        }

        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("o ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("u ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("z ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("b ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("n ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("c ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("s ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("h ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("o ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("d ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("Kangkan ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("p ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));
        mData.add(new NewsItem("dip ","I am a developer","24.12.1997",R.drawable.ic_launcher_background));


        newsAdapter=new NewsAdapter(this,mData,isDark);
        NewsRecycleView.setAdapter(newsAdapter);
        NewsRecycleView.setLayoutManager(new LinearLayoutManager(this));



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isDark=!isDark;

                if (isDark){
                    rootlayout.setBackgroundColor(getResources().getColor(R.color.black));
                    editText.setBackgroundResource(R.drawable.card_bd_dark);
                }else {
                    rootlayout.setBackgroundColor(getResources().getColor(R.color.white));
                    editText.setBackgroundResource(R.drawable.card_bg);
                }
                newsAdapter=new NewsAdapter(getApplicationContext(),mData,isDark);
                NewsRecycleView.setAdapter(newsAdapter);

                saveThemepref(isDark);

            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                newsAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

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
