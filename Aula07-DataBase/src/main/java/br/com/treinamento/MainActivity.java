package br.com.treinamento;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import br.com.treinamento.persistence.DataBaseManager;

public class MainActivity extends ListActivity implements AdapterView.OnItemLongClickListener {

    private DataBaseManager dbManager;

    private CustomCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        dbManager = CustomApplication.getInstance().getDbManager();

        adapter = new CustomCursorAdapter( this,  dbManager.getAll() );

        this.setListAdapter( adapter );

        this.getListView().setOnItemLongClickListener( this );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate( R.menu.main, menu );

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if( item.getItemId() == R.id.action_add ){
            this.startActivity( new Intent( this, AddActivity.class ));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

        TextView txtView = (TextView) view.findViewById(R.id.idPessoa);

        String id =  txtView.getText().toString();

        dbManager.delete( Long.parseLong( id ) );

        adapter = new CustomCursorAdapter( this,  dbManager.getAll() );
        this.setListAdapter( adapter );

        return false;
    }
}
