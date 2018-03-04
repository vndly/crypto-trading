package com.mauriciotogneri.cryptos.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.mauriciotogneri.cryptos.R;
import com.mauriciotogneri.cryptos.adapters.BuyAdapter.ViewHolder;
import com.mauriciotogneri.cryptos.api.json.JsonBuy;
import com.mauriciotogneri.cryptos.base.BaseListAdapter;

public class BuyAdapter extends BaseListAdapter<JsonBuy, ViewHolder>
{
    public BuyAdapter(Context context)
    {
        super(context, R.layout.card_buy);
    }

    @Override
    protected void fillView(ViewHolder holder, JsonBuy buy, int position, View rowView)
    {
        holder.coin.setText(buy.coin);
    }

    @Override
    protected ViewHolder viewHolder(View view)
    {
        return new ViewHolder(view);
    }

    public static class ViewHolder
    {
        public TextView coin;

        protected ViewHolder(View view)
        {
            coin = view.findViewById(R.id.title);
        }
    }
}