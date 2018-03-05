package com.mauriciotogneri.cryptos.fragments;

import android.content.Intent;
import android.view.View;
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
        if (buys.length > 0)
        {
            BuyAdapter adapter = new BuyAdapter(getContext());
            adapter.add(buys);

            ListView listView = view.findViewById(R.id.list);
            listView.setVisibility(View.VISIBLE);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener((adapterView, view, position, id) ->
            {
                JsonBuy json = (JsonBuy) adapterView.getItemAtPosition(position);
                onItemSelected(json);
            });
        }
        else
        {
            View emptyView = view.findViewById(R.id.empty);
            emptyView.setVisibility(View.VISIBLE);
        }
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