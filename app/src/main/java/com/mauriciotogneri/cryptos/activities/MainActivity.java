package com.mauriciotogneri.cryptos.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mauriciotogneri.androidutils.ToastMessage;
import com.mauriciotogneri.cryptos.R;
import com.mauriciotogneri.cryptos.api.Api;
import com.mauriciotogneri.cryptos.api.json.JsonState;
import com.mauriciotogneri.cryptos.fragments.BuyFragment;
import com.mauriciotogneri.cryptos.fragments.SellFragment;
import com.mauriciotogneri.cryptos.fragments.SummaryFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    private final BuyFragment buyFragment = new BuyFragment();
    private final SellFragment sellFragment = new SellFragment();
    private final SummaryFragment summaryFragment = new SummaryFragment();

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_container, summaryFragment);
        transaction.add(R.id.frame_container, sellFragment);
        transaction.add(R.id.frame_container, buyFragment);
        transaction.commitAllowingStateLoss();

        onBuyTab();
        loadState();
    }

    private void loadState()
    {
        ProgressDialog ringProgressDialog = ProgressDialog.show(this, "", getString(R.string.dialog_loading), true, false);

        Api.service().state().enqueue(new Callback<JsonState>()
        {
            @Override
            public void onResponse(Call<JsonState> call, Response<JsonState> response)
            {
                ringProgressDialog.dismiss();

                JsonState state = response.body();

                if (state != null)
                {
                    buyFragment.fill(state.buy);
                    sellFragment.fill(state.sell);
                }
            }

            @Override
            public void onFailure(Call<JsonState> call, Throwable t)
            {
                ringProgressDialog.dismiss();

                new ToastMessage(getBaseContext()).shortMessage(R.string.error_loading);
            }
        });
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

    @OnClick(R.id.toolbar_excel)
    public void onExcel()
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/1JTUG8e2_YU-CP2Xe52VoHJbZolBxfbIni-n2DuZWFJM"));
        startActivity(intent);
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
        transaction.hide(buyFragment);
        transaction.hide(sellFragment);
        transaction.hide(summaryFragment);
        transaction.show(fragment);
        transaction.commitAllowingStateLoss();
    }
}