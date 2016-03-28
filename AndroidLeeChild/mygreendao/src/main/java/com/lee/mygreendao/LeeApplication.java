package com.lee.mygreendao;

import android.app.Application;
import android.content.Context;

import com.guangda.dao.DaoMaster;
import com.guangda.dao.DaoSession;

/**
 * Created by liwei5 on 2016/3/25.
 */
public class LeeApplication extends Application {
    private static LeeApplication instance = null;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        if (instance == null)
            instance = this;


    }
    /*取得DaoMaster
    * 上下文*/
    public static DaoMaster getDaoMaster(Context context)
    {
        if (daoMaster == null){
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context,"greendaodb",null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    /*取得DaoSession*/
    public static DaoSession getDaoSession(Context context)
    {
        if (daoSession == null)
        {
            if (daoMaster == null)
            {
                daoMaster = getDaoMaster(context);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }
}
