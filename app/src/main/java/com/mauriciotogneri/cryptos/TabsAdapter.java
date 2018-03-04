package com.mauriciotogneri.cryptos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mauriciotogneri.cryptos.fragments.BuyFragment;

public class TabsAdapter extends FragmentStatePagerAdapter
{
    public TabsAdapter(FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int i)
    {
        Fragment fragment = new BuyFragment();

        return fragment;
    }

    @Override
    public int getCount()
    {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return "TAB " + position;
    }
}