package com.cogpunk;

import java.security.SecureRandom;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class SampleClass {

  public static final String TEST = "test";

  public SampleClass() throws ClassNotFoundException, SQLException {
    SecureRandom sr = new SecureRandom();
		sr.setSeed(123456L); 

    String password ="password";

    Class.forName("org.hsqldb.jdbcDriver");
    Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:resource;sql.syntax_ora=true", "sa", "");
  }
  
}
