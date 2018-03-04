package com.mauriciotogneri.cryptos.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.mauriciotogneri.cryptos.R;
import com.mauriciotogneri.cryptos.fragments.BuyFragment;
import com.mauriciotogneri.cryptos.fragments.SellFragment;
import com.mauriciotogneri.cryptos.fragments.SummaryFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{
    private final Fragment buyFragment = new BuyFragment();
    private final Fragment sellFragment = new SellFragment();
    private final Fragment summaryFragment = new SummaryFragment();

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        displayFragment(buyFragment);
    }

    @OnClick(R.id.tab_buy)
    public void onBuyTab()
    {
        displayFragment(buyFragment);
    }

    @OnClick(R.id.tab_sell)
    public void onSellTab()
    {
        displayFragment(sellFragment);
    }

    @OnClick(R.id.tab_summary)
    public void onSummaryTab()
    {
        displayFragment(summaryFragment);
    }

    private void displayFragment(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }
}