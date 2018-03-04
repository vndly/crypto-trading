package com.mauriciotogneri.cryptos.activities;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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

        onBuyTab();
    }

    @OnClick(R.id.tab_buy)
    public void onBuyTab()
    {
        displayFragment(R.string.menu_buy, buyFragment);
    }

    @OnClick(R.id.tab_sell)
    public void onSellTab()
    {
        displayFragment(R.string.menu_sell, sellFragment);
    }

    @OnClick(R.id.tab_summary)
    public void onSummaryTab()
    {
        displayFragment(R.string.menu_summary, summaryFragment);
    }

    private void displayFragment(@StringRes int title, Fragment fragment)
    {
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText(title);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}