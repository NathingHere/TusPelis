package com.example.tuspelis.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.tuspelis.Peliculas.Fragments.FragmentEstrenosPeliculas;

import java.util.ArrayList;

public class AdapterTabLayoutPeliculas extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> listfragment = new ArrayList<>();
    private ArrayList<String> listTitles = new ArrayList<>();

    public AdapterTabLayoutPeliculas(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listfragment.get(position);
    }

    @Override
    public int getCount() {
        return listfragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitles.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        listTitles.add(title);
        listfragment.add(fragment);
    }
}
