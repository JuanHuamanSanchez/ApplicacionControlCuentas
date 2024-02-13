package com.example.applicacioncontrolcuentas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder> {
    private List<Email> emailList;

    public EmailAdapter(List<Email> emailList) {
        this.emailList = emailList;
    }

    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_email, parent, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, int position) {
        Email email = emailList.get(position);
        holder.textViewEmail.setText(email.getEmail());
        holder.textViewTexto2.setText(email.getTexto2());
        holder.textViewTexto3.setText(email.getTexto3());
    }

    @Override
    public int getItemCount() {
        return emailList.size();
    }

    static class EmailViewHolder extends RecyclerView.ViewHolder {
        TextView textViewEmail, textViewTexto2, textViewTexto3;

        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewEmail = itemView.findViewById(R.id.textViewEmail);
            textViewTexto2 = itemView.findViewById(R.id.textViewTexto2);
            textViewTexto3 = itemView.findViewById(R.id.textViewTexto3);
        }
    }
}
