package com.lee.childbaby.dbhelper;

import android.content.Context;
import android.text.TextUtils;

import com.lee.dao.DaoSession;
import com.lee.dao.UsersDao;
import com.lee.childbaby.LeeApplication;

import java.util.List;

import com.lee.entitys.Users;

/**
 * Created by liwei5 on 2016/3/25.
 */
public class DbService {
    private static final String TAG = DbService.class.getSimpleName();
    private static DbService instance;
    private static Context appContext;
    private DaoSession mDaoSession;
    private UsersDao userDao;

    private DbService(){}
    /**
     * 采用单利模式
     */
    public static DbService getInstance(Context context){
        if (instance == null){
            instance = new DbService();
            if (appContext == null){
                appContext = context.getApplicationContext();
            }
            instance.mDaoSession = LeeApplication.getDaoSession(context);
            instance.userDao = instance.mDaoSession.getUsersDao();
        }
        return instance;
    }

    /**
     * 根据用户id 取出用户信息
     */
    public Users loadNote(long id){
        if (!TextUtils.isEmpty(id +"")){
            return userDao.load(id);
        }
        return null;
    }

    /**
     * 取出所有数据
     */
    public List<Users> loadAllNote(){
        return userDao.loadAll();
    }

    /**
     * 生成按照id到排序的列表
     */
    public List<Users> loadAllNotesByOrder(){
        return userDao.queryBuilder().orderDesc(UsersDao.Properties.Id).list();
    }

    /**
     * 根据查询条件，返回数据列表
     */
    public long saveNote(Users user){
        return userDao.insertOrReplace(user);
    }

    /**
     * 批量插入或修改用户信息
     */
    public void saveNoteLists(final List<Users> list){
        if (list ==null || list.isEmpty()){
            return;
        }
        userDao.getSession().runInTx(new Runnable() {
            @Override
            public void run() {
                for (int i= 0;i<list.size();i++){
                    Users user = list.get(i);
                    userDao.insertOrReplace(user);
                }
            }
        });
    }

    /**
     * 删除所有数据
     */
    public void deleteAllNote(){
        userDao.deleteAll();
    }

    /**
     * 根据id删除数据
     */
    public void deleteNote(long id){
        userDao.deleteByKey(id);
    }

    /**
     * 根据用户类，删除信息
     */
    public void deleteNote(Users user){
        userDao.delete(user);
    }



}
