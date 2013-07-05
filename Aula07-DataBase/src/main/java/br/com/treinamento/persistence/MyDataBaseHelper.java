package br.com.treinamento.persistence;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by natanaelfonseca on 19/06/13.
 */
public class MyDataBaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "treinamnento";

    private static final String DB_NAME =  "treinamento.sqlite";
    private static final int DB_VERSION =  1;

    private String SQL_CREATE = "create table tbl_pessoa (\n" +
                                "_id  integer primary key autoincrement,\n" +
                                "nome text not null,\n" +
                                "telefone text not null,\n" +
                                "endereco text not null\n" +
                                ");";


    private String SQL_DROP = "drop table if exists tbl_pessoa";

    public MyDataBaseHelper(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try{
            sqLiteDatabase.execSQL( SQL_CREATE );
        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        Log.d( TAG, "Atualizando o banco de dados da versao " + oldVersion + " para a versao " + newVersion );

        try{
            sqLiteDatabase.execSQL( SQL_DROP );
        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }
}