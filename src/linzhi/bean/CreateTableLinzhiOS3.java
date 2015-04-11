package linzhi.bean;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Created by wanglinzhizhi on 15-3-27.
 */
public class CreateTableLinzhiOS3 {
    public static void main(String[] args) {

        SchemaExport schemaExport=new SchemaExport(new Configuration().configure());

        schemaExport.create(true,true);

    }
}
