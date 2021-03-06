package com.mauriciotogneri.cryptos.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.mauriciotogneri.cryptos.R;
import com.mauriciotogneri.cryptos.adapters.BuyAdapter.ViewHolder;
import com.mauriciotogneri.cryptos.api.json.JsonBuy;
import com.mauriciotogneri.cryptos.base.BaseListAdapter;
import com.mauriciotogneri.cryptos.format.NumberFormat;

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
        holder.currentPrice.setText(NumberFormat.price(buy.currentPrice));
        holder.highestPrice.setText(NumberFormat.price(buy.highestPrice));
        holder.lowestPrice.setText(NumberFormat.price(buy.lowestPrice));
        holder.changeFromHigh.setText(NumberFormat.percentage(buy.changeFromHigh));
        holder.changeFromLow.setText(NumberFormat.percentage(buy.changeFromLow));
        holder.trailing.setText(NumberFormat.percentage(buy.trailing));
    }

    @Override
    protected ViewHolder viewHolder(View view)
    {
        return new ViewHolder(view);
    }

    public static class ViewHolder
    {
        public final TextView coin;
        public final TextView currentPrice;
        public final TextView highestPrice;
        public final TextView lowestPrice;
        public final TextView changeFromHigh;
        public final TextView changeFromLow;
        public final TextView trailing;

        protected ViewHolder(View view)
        {
            coin = view.findViewById(R.id.coin);
            currentPrice = view.findViewById(R.id.currentPrice);
            highestPrice = view.findViewById(R.id.highestPrice);
            lowestPrice = view.findViewById(R.id.lowestPrice);
            changeFromHigh = view.findViewById(R.id.changeFromHigh);
            changeFromLow = view.findViewById(R.id.changeFromLow);
            trailing = view.findViewById(R.id.trailing);
        }
    }
}