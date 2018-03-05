package com.mauriciotogneri.cryptos.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.mauriciotogneri.androidutils.Clipboard;
import com.mauriciotogneri.androidutils.ToastMessage;
import com.mauriciotogneri.cryptos.R;
import com.mauriciotogneri.cryptos.base.BaseActivity;
import com.mauriciotogneri.cryptos.format.NumberFormat;

import butterknife.ButterKnife;

public class CalculateAmount extends BaseActivity
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
                String text = investmentView.getText().toString();

                if (!TextUtils.isEmpty(text))
                {
                    calculateAmount(unitPrice, Double.parseDouble(text));
                }
                else
                {
                    calculateAmount(unitPrice, 0);
                }
            }
        });
        investmentView.setText(NumberFormat.price(DEFAULT_INVESTMENT));

        TextView amountView = findViewById(R.id.amount);
        amountView.setOnClickListener(view ->
        {
            Clipboard clipboard = new Clipboard(getBaseContext());
            clipboard.copy(amountView.getText().toString());

            new ToastMessage(getBaseContext()).shortMessage(R.string.calculate_copied);
        });
    }

    private void calculateAmount(double unitPrice, double investment)
    {
        TextView amountView = findViewById(R.id.amount);
        amountView.setText(String.valueOf((int)(investment / unitPrice)));
    }
}