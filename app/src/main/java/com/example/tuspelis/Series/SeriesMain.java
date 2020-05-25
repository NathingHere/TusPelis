package com.example.tuspelis.Series;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.tuspelis.Adapters.AdapterTabLayoutPeliculas;

import com.example.tuspelis.Peliculas.Fragments.FragmentGeneralPeliculas;
import com.example.tuspelis.R;
import com.example.tuspelis.Series.Fragments.FragmentActuales;
import com.example.tuspelis.Series.Fragments.FragmentOnAir;
import com.example.tuspelis.Series.Fragments.FragmentPopular;
import com.example.tuspelis.Series.Fragments.FragmentTopRated;
import com.google.android.material.tabs.TabLayout;

public class SeriesMain extends AppCompatActivity {
    private TabLayout tabLayout;
    private int[]tabIcons={R.drawable.iconofragmentestrenos, R.drawable.iconofragmentlanzamiento,R.drawable.iconofragmentgeneros,R.drawable.iconofragmenttrending};
    ViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments_main);
        setTitle("Series");
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        loadViewpager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabIcons();
        iconColor(tabLayout.getTabAt(tabLayout.getSelectedTabPosition()),"#3b5998");

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                iconColor(tab,"#3b5998");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                iconColor(tab,"#E0E0E0");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void loadViewpager(ViewPager viewPager){
        AdapterTabLayoutPeliculas adapter = new AdapterTabLayoutPeliculas(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addFragment(new FragmentActuales());
        adapter.addFragment(new FragmentOnAir());
        adapter.addFragment(new FragmentPopular());
        adapter.addFragment(new FragmentTopRated());
        viewPager.setAdapter(adapter);
    }

    private void tabIcons(){
        for(int i = 0; i < 4; i++){
            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
        }
    }

    private FragmentGeneralPeliculas newInstance(String title){
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        FragmentGeneralPeliculas fragment = new FragmentGeneralPeliculas();
        fragment.setArguments(bundle);

        return fragment;
    }

    private void iconColor(TabLayout.Tab tab, String color){
        tab.getIcon().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_IN);
    }
}