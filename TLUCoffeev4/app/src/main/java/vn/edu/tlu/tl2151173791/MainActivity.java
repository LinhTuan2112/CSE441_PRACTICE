package vn.edu.tlu.tl2151173791;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_menu);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                Intent intent = new Intent(MainActivity.this, CafeActivity.class);
                if (itemId == R.id.ac_cafe) {
                    intent.putExtra("loai_do_uong", "cafe");

                    Toast.makeText(MainActivity.this, "Cafe Selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.ac_nuoctraicay) {
                    intent.putExtra("loai_do_uong", "nuoc_trai_cay");
                    Toast.makeText(MainActivity.this, "Nuoc trai cay Selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.ac_tradacbiet) {

                    Toast.makeText(MainActivity.this, "Tra dac biet Selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.ac_banhngot) {

                    Toast.makeText(MainActivity.this, "Banh ngot Selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.ac_banhman) {

                    Toast.makeText(MainActivity.this, "Banh man Selected", Toast.LENGTH_SHORT).show();
                }
                startActivity(intent);
                drawerLayout.closeDrawers();  // Close the drawer after item is selected
                return true;  // Return true to indicate the item selection has been handled
                }
            });
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

        @Override
        public void onBackPressed() {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
    }
}





