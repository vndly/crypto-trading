package com.mauriciotogneri.cryptos.adapters;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.mauriciotogneri.cryptos.R;
import com.mauriciotogneri.cryptos.adapters.SellAdapter.ViewHolder;
import com.mauriciotogneri.cryptos.api.json.JsonSell;
import com.mauriciotogneri.cryptos.base.BaseListAdapter;
import com.mauriciotogneri.cryptos.format.NumberFormat;

public class SellAdapter extends BaseListAdapter<JsonSell, ViewHolder>
{
    public SellAdapter(Context context)
    {
        super(context, R.layout.card_sell);
    }

    @Override
    protected void fillView(ViewHolder holder, JsonSell sell, int position, View rowView)
    {
        holder.coin.setText(sell.coin);
        holder.unitPrice.setText(NumberFormat.price(sell.unitPrice));
        holder.amount.setText(NumberFormat.amount(sell.amount));
        holder.boughtPrice.setText(NumberFormat.price(sell.boughtPrice));
        holder.currentPrice.setText(NumberFormat.price(sell.currentPrice));
        holder.highestPrice.setText(NumberFormat.price(sell.highestPrice));
        holder.priceChange.setText(NumberFormat.percentage(sell.priceChange));
        holder.changeFromHigh.setText(NumberFormat.percentage(sell.changeFromHigh));
        holder.currentValue.setText(NumberFormat.price(sell.currentValue));
        holder.profit.setText(NumberFormat.percentage(sell.profit));
        holder.benefit.setText(NumberFormat.amount(sell.benefit));
        holder.stopLoss.setText(NumberFormat.percentage(sell.stopLoss));
        holder.trailing.setText(NumberFormat.percentage(sell.trailing));
        holder.startDate.setText(sell.startDate);
    }

    @Override
    protected ViewHolder viewHolder(View view)
    {
        return new ViewHolder(view);
    }

    public static class ViewHolder
    {
        public final TextView coin;
        public final TextView unitPrice;
        public final TextView amount;
        public final TextView boughtPrice;
        public final TextView currentPrice;
        public final TextView highestPrice;
        public final TextView priceChange;
        public final TextView changeFromHigh;
        public final TextView currentValue;
        public final TextView profit;
        public final TextView benefit;
        public final TextView stopLoss;
        public final TextView trailing;
        public final TextView startDate;

        protected ViewHolder(View view)
        {
            coin = view.findViewById(R.id.title);
            unitPrice = view.findViewById(R.id.unitPrice);
            amount = view.findViewById(R.id.amount);
            boughtPrice = view.findViewById(R.id.boughtPrice);
            currentPrice = view.findViewById(R.id.currentPrice);
            highestPrice = view.findViewById(R.id.highestPrice);
            priceChange = view.findViewById(R.id.priceChange);
            changeFromHigh = view.findViewById(R.id.changeFromHigh);
            currentValue = view.findViewById(R.id.currentValue);
            profit = view.findViewById(R.id.profit);
            benefit = view.findViewById(R.id.benefit);
            stopLoss = view.findViewById(R.id.stopLoss);
            trailing = view.findViewById(R.id.trailing);
            startDate = view.findViewById(R.id.startDate);
        }
    }
}