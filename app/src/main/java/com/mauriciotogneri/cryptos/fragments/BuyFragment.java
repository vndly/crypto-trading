package com.mauriciotogneri.cryptos.fragments;

import android.content.Intent;
import android.widget.ListView;

import com.mauriciotogneri.cryptos.R;
import com.mauriciotogneri.cryptos.activities.CalculateAmount;
import com.mauriciotogneri.cryptos.adapters.BuyAdapter;
import com.mauriciotogneri.cryptos.api.json.JsonBuy;
import com.mauriciotogneri.cryptos.base.BaseFragment;

public class BuyFragment extends BaseFragment
{
    public void fill(JsonBuy[] buys)
    {
        BuyAdapter adapter = new BuyAdapter(getContext());
        adapter.add(buys);

        ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView, view, position, id) ->
        {
            JsonBuy json = (JsonBuy) adapterView.getItemAtPosition(position);
            onItemSelected(json);
        });
    }

    private void onItemSelected(JsonBuy buy)
    {
        Intent intent = CalculateAmount.intent(getContext(), buy.coin, buy.currentPrice);
        startActivity(intent);
    }

    @Override
    public int layout()
    {
        return R.layout.fragment_buy;
    }
}