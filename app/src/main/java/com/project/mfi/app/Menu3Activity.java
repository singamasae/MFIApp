package com.project.mfi.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.project.mfi.menu.MenuAdapter;
import com.project.mfi.menu.MenuModel;
import com.project.mfi.menu.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class Menu3Activity extends AppCompatActivity {
    private List<MenuModel> menuModels;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);

        menuModels = setMainMenuList();

        mRecyclerView = (RecyclerView) findViewById(R.id.main_menu_list);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        mAdapter = new MenuAdapter(menuModels);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        onMainMenuItemSelected(position);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        onMainMenuItemSelected(position);
                    }
                })
        );
    }

    private List<MenuModel> setMainMenuList() {
        List<MenuModel> menuModels = new ArrayList<>();
        menuModels.add(new MenuModel(R.mipmap.moneybag, getResources().getString(R.string.title_main_menu_4)));
        menuModels.add(new MenuModel(R.mipmap.moneytransfer, getResources().getString(R.string.title_main_menu_5)));

        return menuModels;
    }

    private void onMainMenuItemSelected(int position) {
        Intent intent;
        switch (position) {
            case 0:
                intent = new Intent(getApplication(), Menu4Activity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(getApplication(), Menu5Activity.class);
                startActivity(intent);
                break;

        }

    }
}
