package com.firasayari.currencyconverter.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firasayari.currencyconverter.R;
import com.firasayari.currencyconverter.database.Operations;

import java.util.List;

public class OperationsAdapter  extends RecyclerView.Adapter<OperationViewHolder> {
    private static final String TAG = OperationsAdapter.class.getSimpleName();
    private List<Operations> operationsModels;

    public OperationsAdapter(List<Operations> operationsModels) {
        this.operationsModels = operationsModels;
    }

    @NonNull
    @Override
    public OperationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.op_layout, parent, false);
        return new OperationViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull OperationViewHolder holder, int position) {
        final Operations model = operationsModels.get(position);

        holder.operation.setText(model.getOp());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get item click id
            }
        });
    }



    @Override
    public int getItemCount() {
        return operationsModels.size();
    }









}
