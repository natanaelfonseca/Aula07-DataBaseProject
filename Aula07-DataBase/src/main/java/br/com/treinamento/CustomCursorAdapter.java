package br.com.treinamento;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by natanaelfonseca on 19/06/13.
 */
public class CustomCursorAdapter extends CursorAdapter {
    public CustomCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView nmId = (TextView)view.findViewById(R.id.idPessoa);
        TextView nmPessoa = (TextView)view.findViewById(R.id.textVwNmPessoa);
        TextView nmTelefone = (TextView)view.findViewById(R.id.textVwTelefonePessoa);
        TextView nmEndereco = (TextView)view.findViewById(R.id.textVwEndereco);

        nmId.setText( cursor.getString( 0 ) );
        nmPessoa.setText( cursor.getString( 1 ) );
        nmTelefone.setText( cursor.getString( 2 ) );
        nmEndereco.setText( cursor.getString( 3 ) );

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.item, parent, false);
        bindView(v, context, cursor);
        return v;
    }
}