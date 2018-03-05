package com.mauriciotogneri.cryptos.fragments;

import android.widget.ListView;

import com.mauriciotogneri.androidutils.ToastMessage;
import com.mauriciotogneri.cryptos.R;
import com.mauriciotogneri.cryptos.adapters.SellAdapter;
import com.mauriciotogneri.cryptos.api.json.JsonSell;
import com.mauriciotogneri.cryptos.base.BaseFragment;

public class SellFragment extends BaseFragment
{
    public void fill(JsonSell[] sells)
    {
        SellAdapter adapter = new SellAdapter(getContext());
        adapter.add(sells);

        ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView, view, position, id) ->
        {
            JsonSell item = (JsonSell) adapterView.getItemAtPosition(position);
            onItemSelected(item);
        });
    }

    private void onItemSelected(JsonSell buy)
    {
        new ToastMessage(getContext()).shortMessage(buy.coin);
    }

    @Override
    public int layout()
    {
        return R.layout.fragment_sell;
    }
}