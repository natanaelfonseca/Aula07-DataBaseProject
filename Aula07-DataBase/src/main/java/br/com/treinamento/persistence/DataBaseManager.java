package br.com.treinamento.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.treinamento.domainmodel.Pessoa;

/**
 * Created by natanaelfonseca on 19/06/13.
 */
public class DataBaseManager {

    private MyDataBaseHelper dbHelper;

    private SQLiteDatabase db;

    public DataBaseManager(Context ctx) {
        dbHelper = new MyDataBaseHelper( ctx );
    }

    public void open(){
        db = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }


    //Metodos relacionados a persistencia da entidade pessoa

    public Long insert( Pessoa p ){

        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", p.getNome() );
        contentValues.put("telefone", p.getTelefone() );
        contentValues.put("endereco", p.getEndereco() );

        return db.insert( "tbl_pessoa", null, contentValues );
    }

    public Cursor find( Pessoa p ){

        Cursor mCursor = db.query( true, "tbl_pessoa", new String[]{}, "_id=" + p.getId(), null, null, null, null, null );

        if( mCursor != null ){
            mCursor.moveToFirst();
        }

        return mCursor;
    }

    public boolean delete( Long id ){
        return db.delete( "tbl_pessoa", "_id" + "=" + id, null  ) > 0;
    }

    public boolean updateContact(Pessoa p){
        ContentValues values = new ContentValues();
        return db.update( "tbl_pessoa", values, "_id=" + p.getId(), null )  > 0;
    }

    public Cursor getAll(){
        return db.query( "tbl_pessoa", null, null, null, null, null, null );
    }

}
