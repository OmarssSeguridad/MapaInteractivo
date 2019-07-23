package com.example.mapainteractivo;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        setTitle("Eventos Próximos");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedor, new EventosFragment(),"fragmento").addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragmento = null;
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();

        if (id == R.id.eventos) {
            setTitle("Eventos Proximos");
            fragmento = new EventosFragment();

        } else if (id == R.id.edificios) {
            setTitle("Edificios Intitucionales");
            fragmento = new EdificiosFragment();

        } else if (id == R.id.mapageneral) {

        }  else if (id == R.id.sincronizar) {

        }  else if (id == R.id.perfil) {
            setTitle("Mi Perfil");
            fragmento = new PerfilFragment();

        }  else if (id == R.id.version) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
            builder.setTitle("Versión");
            builder.setMessage("La versión es 1.0");
            builder.setPositiveButton("OK",null);
            builder.create();
            builder.show();

        }  else if (id == R.id.acerca) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
            builder.setTitle("Creditos");
            builder.setMessage("Desarrollo de aplicaciones móviles" +
                    "\nIntegrantes" +
                    "\nOmar Blanco Macedo" +
                    "\nJosé Adán Cruz Castrejón" +
                    "\nLourdes Cecilia Vega Mondragon" +
                    "\nProfesora: Rocio Elizabeth Pulido Alba");
            builder.setPositiveButton("OK",null);
            builder.create();
            builder.show();

        }

        if (fragmento != null) {
            transaction.replace(R.id.contenedor, fragmento,"fragmento").addToBackStack(null);
            transaction.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
