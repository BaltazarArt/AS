package mx.edu.cesba.as;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);

        getSupportFragmentManager().beginTransaction().add(R.id.content, new inicioFragment()).commit();
        setTitle("Inicio");

        //
        //setSupportActionBar(toolbar);

        toggle= setUpDrawerToggle();
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);

    }
    private ActionBarDrawerToggle setUpDrawerToggle(){
        return new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        selectItemNav(item);
        return true;
    }

    private void selectItemNav(MenuItem item) {
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();

        switch (item.getItemId()){
            case R.id.nav_inicio:
                ft.replace(R.id.content, new inicioFragment ()).commit();
                break;
            case R.id.nav_comprar:
                ft.replace(R.id.content, new comprarFragment ()).commit();
                break;
            case R.id.nav_especific:
                ft.replace(R.id.content, new especificacionFragment ()).commit();
                break;
            case R.id.nav_carrito:
                ft.replace(R.id.content, new carritoFragment ()).commit();
                break;
            case R.id.nav_pagar:
                ft.replace(R.id.content, new pagarFragment ()).commit();
                break;
            case R.id.nav_iniciarsesion:
                ft.replace(R.id.content, new iniciarsesionFragment ()).commit();
                break;
            case R.id.nav_registrar:
                ft.replace(R.id.content, new registrarseFragment ()).commit();
                break;
            case R.id.nav_contacto:
                ft.replace(R.id.content, new contactoFragment ()).commit();
                break;
        }
        setTitle(item.getTitle());
        drawerLayout.closeDrawers();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
           return true;
        }
        return super.onOptionsItemSelected(item);
    }
}