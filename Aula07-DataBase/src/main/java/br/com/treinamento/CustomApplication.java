package br.com.treinamento;

import android.app.Application;

import br.com.treinamento.persistence.DataBaseManager;

/**
 * Created by natanaelfonseca on 19/06/13.
 */
public class CustomApplication extends Application {

    private static CustomApplication singleton;

    private DataBaseManager dbManager;

    public static CustomApplication getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {

        super.onCreate();

        dbManager = new DataBaseManager( getApplicationContext() );
        dbManager.open();

        setSingleton(this);
    }

    public static final void setSingleton(final CustomApplication singleton) {
        CustomApplication.singleton = singleton;
    }

    @Override
    public void onTerminate() {

        super.onTerminate();

        dbManager.close();
    }

    public DataBaseManager getDbManager() {
        return dbManager;
    }
}
