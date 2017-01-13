package com.project.mfi.app;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.project.mfi.menu.MenuAdapter;
import com.project.mfi.menu.MenuModel;
import com.project.mfi.menu.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private List<MenuModel> menuModels;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        // Retrieve the SearchView and plug it into SearchManager
        final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast toast = Toast.makeText(getApplicationContext(), "Settings menu is under construction", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        } else if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_account_info) {
            Toast toast = Toast.makeText(getApplicationContext(), "Account Info menu is under construction", Toast.LENGTH_SHORT);
            toast.show();

        } else if (id == R.id.nav_change_passwd) {
            Toast toast = Toast.makeText(getApplicationContext(), "Change Password menu is under construction", Toast.LENGTH_SHORT);
            toast.show();
        } else if (id == R.id.nav_settings) {
            Toast toast = Toast.makeText(getApplicationContext(), "Settings menu is under construction", Toast.LENGTH_SHORT);
            toast.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private List<MenuModel> setMainMenuList() {
        List<MenuModel> menuModels = new ArrayList<>();
        menuModels.add(new MenuModel(R.mipmap.debt, getResources().getString(R.string.title_main_menu_1)));
        menuModels.add(new MenuModel(R.mipmap.refund, getResources().getString(R.string.title_main_menu_2)));
        menuModels.add(new MenuModel(R.mipmap.cashinhand, getResources().getString(R.string.title_main_menu_3)));

        return menuModels;
    }

    private void onMainMenuItemSelected(int position) {
        Intent intent;
        switch (position) {
            case 0:
                intent = new Intent(getApplication(), Menu1Activity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(getApplication(), Menu2Activity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(getApplication(), Menu3Activity.class);
                startActivity(intent);
                break;

        }

    }
}
