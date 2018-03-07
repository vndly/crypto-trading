package com.mauriciotogneri.cryptos.base;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseListAdapter<T, V> extends ArrayAdapter<T>
{
    private final LayoutInflater inflater;
    private final int resourceId;

    public BaseListAdapter(Context context, int resourceId)
    {
        super(context, android.R.layout.simple_list_item_1, new ArrayList<>());

        this.inflater = LayoutInflater.from(context);
        this.resourceId = resourceId;
    }

    public void add(T[] list)
    {
        add(Arrays.asList(list));
    }

    public void add(List<T> list)
    {
        addAll(list);
        notifyDataSetChanged();
    }

    protected abstract void fillView(V viewHolder, T item, int position, View rowView);

    protected abstract V viewHolder(View view);

    @Override
    @NonNull
    @SuppressWarnings("unchecked")
    public View getView(int position, View convertView, @NonNull ViewGroup parent)
    {
        View rowView = convertView;

        if (rowView == null)
        {
            rowView = generatedRowView(parent);
        }

        V viewHolder = (V) rowView.getTag();

        T item = getItem(position);

        fillView(viewHolder, item, position, rowView);

        return rowView;
    }

    protected View generatedRowView(ViewGroup parent)
    {
        View rowView = inflater.inflate(resourceId, parent, false);
        V viewHolder = viewHolder(rowView);
        rowView.setTag(viewHolder);

        return rowView;
    }

    protected int color(@ColorRes int id)
    {
        return ContextCompat.getColor(getContext(), id);
    }
}