package com.example.geraldo.farra.util;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Geraldo on 22/06/2017.
 */

public class DataBaseConfigUtil extends OrmLiteConfigUtil{
    public static void main(String[] args) throws IOException, SQLException {
        writeConfigFile("ormlite_config.txt");
    }
}
