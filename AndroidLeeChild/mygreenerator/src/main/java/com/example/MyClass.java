package com.example;
import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;
public class MyClass {
    public static void main(String args[]) throws Exception
    {
        //初始化一下数据库
        //第一个参数是版本号,第二个参数是为你生成的bean类放的文件夹名
        Schema schema = new Schema(1, "com.lee.entitys");
        //设置一下生成的三个java文件的目录
        schema.setDefaultJavaPackageDao("com.lee.dao");

        //建立一个表
        Entity userBean = schema.addEntity("Users");
        //此行可有可无,就是对表进行重命名
        userBean.setTableName("Users");
        //此行被注,因为加上引行,下面的字段总会少一个.不知道为什么
        //userBean.addLongProperty("id").primaryKey().index().autoincrement();
        //建立自增的主键
        userBean.addIdProperty();
        userBean.addStringProperty("uSex");
        userBean.addStringProperty("uTelphone");
        userBean.addStringProperty("uAge");
        userBean.addStringProperty("uName");
        userBean.addStringProperty("uPic");
        userBean.addStringProperty("uChannel");
        new DaoGenerator().generateAll(schema,"./LeeChild/src/main/java");
    }


}
