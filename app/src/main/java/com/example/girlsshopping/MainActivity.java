package com.example.girlsshopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.girlsshopping.products.AddProductActivity;
import com.example.girlsshopping.products.ProductDetailActivity;
import com.example.girlsshopping.products.ProductDetailFragment;
import com.example.girlsshopping.ui.gallery.GalleryFragment;
import com.example.girlsshopping.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements HomeFragment.OnProductClickedListener {
    private AppBarConfiguration mAppBarConfiguration;

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        GalleryFragment galleryFragment=new GalleryFragment();

    }


    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }



    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.home:
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            return true;
                            case R.id.action_searching:
                                SearchingFragment searchingFragment=new SearchingFragment();
                                openFragment(searchingFragment);
                            return true;
                            case R.id.action_add:
                                intent = new Intent(getApplicationContext(), AddProductActivity.class);
                                startActivity(intent);
                            return true;
                            case R.id.action_favoriter:
                                FavouritesFragment favouritesFragment=new FavouritesFragment();
                                openFragment(favouritesFragment);
                            return true;
                            case R.id.action_messages:
                                MessageFragment messageFragment=new MessageFragment();
                            openFragment(messageFragment);
                            return true;

                    }
                    return false;
                }
            };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(getApplicationContext(), "Nie masz żadnych nowych powiadomień", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProductClicked(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt(ProductDetailFragment.PRODUCTS_ID, id);

        Intent intent = new Intent(this, ProductDetailActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
