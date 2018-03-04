package com.mauriciotogneri.cryptos.fragments;

import android.widget.ListView;

import com.mauriciotogneri.androidutils.ToastMessage;
import com.mauriciotogneri.cryptos.R;
import com.mauriciotogneri.cryptos.adapters.BuyAdapter;
import com.mauriciotogneri.cryptos.api.json.JsonBuy;
import com.mauriciotogneri.cryptos.base.BaseFragment;

public class BuyFragment extends BaseFragment
{
    public void fill(JsonBuy[] buys)
    {
        BuyAdapter buyAdapter = new BuyAdapter(getContext());
        buyAdapter.add(buys);

        ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(buyAdapter);
        listView.setOnItemClickListener((adapterView, view, position, id) ->
        {
            JsonBuy jsonBuy = (JsonBuy) adapterView.getItemAtPosition(position);
            onItemSelected(jsonBuy);
        });
    }

    private void onItemSelected(JsonBuy buy)
    {
        new ToastMessage(getContext()).shortMessage(buy.coin);
    }

    @Override
    public int layout()
    {
        return R.layout.fragment_buy;
    }
}