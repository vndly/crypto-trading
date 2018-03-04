package com.mauriciotogneri.cryptos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.mauriciotogneri.cryptos.fragments.BuyFragment;
import com.mauriciotogneri.cryptos.fragments.SellFragment;
import com.mauriciotogneri.cryptos.fragments.SummaryFragment;

public class MainActivity2 extends AppCompatActivity
{
    private final Fragment buyFragment = new BuyFragment();
    private final Fragment sellFragment = new SellFragment();
    private final Fragment summaryFragment = new SummaryFragment();

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.tab_buy).setOnClickListener(view -> displayFragment(buyFragment));
        findViewById(R.id.tab_sell).setOnClickListener(view -> displayFragment(sellFragment));
        findViewById(R.id.tab_summary).setOnClickListener(view -> displayFragment(summaryFragment));

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, buyFragment);
        transaction.commit();
    }

    private void displayFragment(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }
}