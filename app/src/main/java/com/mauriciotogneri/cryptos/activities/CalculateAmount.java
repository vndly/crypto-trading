package com.mauriciotogneri.cryptos.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.mauriciotogneri.cryptos.R;
import com.mauriciotogneri.cryptos.format.NumberFormat;

import butterknife.ButterKnife;

public class CalculateAmount extends AppCompatActivity
{
    private static final String PARAMETER_COIN = "coin";
    private static final String PARAMETER_UNIT_PRICE = "unit.price";

    private static final Double DEFAULT_INVESTMENT = 0.01;

    public static Intent intent(Context context, String coin, Double unitPrice)
    {
        Intent intent = new Intent(context, CalculateAmount.class);
        intent.putExtra(PARAMETER_COIN, coin);
        intent.putExtra(PARAMETER_UNIT_PRICE, unitPrice);

        return intent;
    }

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculate_amount);
        ButterKnife.bind(this);

        Intent params = getIntent();

        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText(params.getStringExtra(PARAMETER_COIN));

        Double unitPrice = params.getDoubleExtra(PARAMETER_UNIT_PRICE, 0);
        TextView unitPriceView = findViewById(R.id.unitPrice);
        unitPriceView.setText(NumberFormat.price(unitPrice));

        EditText investmentView = findViewById(R.id.investment);
        investmentView.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                calculateAmount(unitPrice, Double.parseDouble(investmentView.getText().toString()));
            }
        });
        investmentView.setText(NumberFormat.price(DEFAULT_INVESTMENT));
    }

    private void calculateAmount(double unitPrice, double investment)
    {
        TextView amountView = findViewById(R.id.amount);
        amountView.setText(NumberFormat.amount(investment / unitPrice));
    }
}