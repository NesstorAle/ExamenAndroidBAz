package com.baz.examenandroidbaz.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baz.examenandroidbaz.R;
import com.baz.examenandroidbaz.data.EmployeEntity;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderDatos> implements View.OnClickListener {
    ArrayList <EmployeEntity> listDatos;
    private View.OnClickListener listener;

    public Adapter(ArrayList<EmployeEntity> listDatos) {
        this.listDatos = listDatos;
    }

    @NonNull
    @Override
    public Adapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_list,null,false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolderDatos holder, int position) {
        holder.setNombre(listDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public void setOnclicklistener(View.OnClickListener listener) {
        this.listener = listener;
    }
    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView name, email;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_list_name);
            email = itemView.findViewById(R.id.item_list_email);
        }

        public void setNombre(EmployeEntity employeEntity) {
            name.setText(employeEntity.getName());
            email.setText(employeEntity.getMail());
        }
    }
}
