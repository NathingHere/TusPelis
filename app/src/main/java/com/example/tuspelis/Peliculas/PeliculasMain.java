package com.example.tuspelis.Peliculas;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.tuspelis.Adapters.AdapterTabLayoutPeliculas;
import com.example.tuspelis.Peliculas.Fragments.FragmentEstrenosPeliculas;
import com.example.tuspelis.Peliculas.Fragments.FragmentLanzamientoPeliculas;
import com.example.tuspelis.Peliculas.Fragments.FragmentTiposPeliculas;
import com.example.tuspelis.Peliculas.Fragments.FragmentTrendingPeliculas;
import com.example.tuspelis.R;
import com.google.android.material.tabs.TabLayout;

public class PeliculasMain extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peliculas_fragment);

        TabLayout tabLayout = findViewById(R.id.tablayout);
        ViewPager viewPager = findViewById(R.id.viewpager);


        setupFragment(viewPager,tabLayout);
        setupTabLayout(tabLayout);
    }

    private void setupFragment(ViewPager viewPager, TabLayout tabLayout){
        AdapterTabLayoutPeliculas adapterTabLayoutPeliculas = new AdapterTabLayoutPeliculas(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapterTabLayoutPeliculas.addFragment(new FragmentEstrenosPeliculas(),"");
        adapterTabLayoutPeliculas.addFragment(new FragmentLanzamientoPeliculas(),"");
        adapterTabLayoutPeliculas.addFragment(new FragmentTiposPeliculas(),"");
        adapterTabLayoutPeliculas.addFragment(new FragmentTrendingPeliculas(),"");

        viewPager.setAdapter(adapterTabLayoutPeliculas);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupTabLayout(TabLayout tabLayout){
        tabLayout.getTabAt(0).setIcon(R.drawable.iconofragmentestrenos);
        tabLayout.getTabAt(1).setIcon(R.drawable.iconofragmentlanzamiento);
        tabLayout.getTabAt(2).setIcon(R.drawable.iconofragmenttipos);
        tabLayout.getTabAt(3).setIcon(R.drawable.iconofragmenttrending);
    }
}
