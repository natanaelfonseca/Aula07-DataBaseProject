package br.com.treinamento;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import br.com.treinamento.domainmodel.Pessoa;
import br.com.treinamento.persistence.DataBaseManager;


/**
 * Created by natanaelfonseca on 19/06/13.
 */
public class AddActivity extends Activity {

    private Handler mHandler = new Handler();

    private ProgressBar mProgressBar;

    private EditText mNome;
    private EditText mTelefone;
    private EditText mendereco;

    private DataBaseManager dbManager;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.add);

        dbManager = CustomApplication.getInstance().getDbManager();

        mProgressBar = (ProgressBar) findViewById( R.id.progressBar );

        mNome = (EditText) findViewById( R.id.editText );
        mTelefone = (EditText) findViewById( R.id.editText2 );
        mendereco = (EditText) findViewById( R.id.editText3 );

    }

    public void onClick(View view){

        final Pessoa pessoa = new Pessoa();
        pessoa.setNome( mNome.getText().toString() );
        pessoa.setTelefone(mTelefone.getText().toString());
        pessoa.setEndereco(mendereco.getText().toString());

        mProgressBar.setVisibility( View.VISIBLE );

        new Thread(){

            @Override
            public void run() {

                dbManager.insert( pessoa );

                mHandler.post( new Runnable() {
                    @Override
                    public void run() {

                        mProgressBar.setVisibility( View.GONE );

                    }
                } );

            }
        }.start();

    }
}