package com.firasayari.currencyconverter.view;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.firasayari.currencyconverter.R;
public class OperationViewHolder  extends RecyclerView.ViewHolder {

    public AppCompatTextView operation;

    public View view;

    public OperationViewHolder(@NonNull View itemView) {
        super(itemView);
        operation = (AppCompatTextView)itemView.findViewById(R.id.item_text);
        view = itemView;
    }


}
