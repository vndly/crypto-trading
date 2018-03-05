package com.mauriciotogneri.cryptos.base;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;

import com.mauriciotogneri.cryptos.R;

import butterknife.OnClick;

public class BaseActivity extends AppCompatActivity
{
    @OnClick(R.id.toolbar_excel)
    public void onExcel()
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/1JTUG8e2_YU-CP2Xe52VoHJbZolBxfbIni-n2DuZWFJM"));
        startActivity(intent);
    }
}