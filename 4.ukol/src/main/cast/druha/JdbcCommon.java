package main.cast.druha;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

public class JdbcCommon extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public JdbcCommon() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Context context = null;
    DataSource ds = null;
    Hashtable env = new Hashtable();
    env.put(Context.INITIAL_CONTEXT_FACTORY, Config.JNDI_FACTORY);
    env.put(Context.PROVIDER_URL, Config.PROVIDER_URL);
    Statement stmt = null;
    Connection conn = null;
    try {
      context = new InitialContext(env);

      ds = (DataSource) context.lookup(Config.JNDI_MYSQL);
      conn = ds.getConnection();
      stmt = conn.createStatement();
      String query = "SELECT * FROM test_mdw";
      ResultSet rs = stmt.executeQuery(query);

      int result = 1;
      while (rs.next()) {
        response.getWriter()
            .println(result + ". result test: '" + rs.getString("test") + "' foobar: '" + rs.getString("foobar") + "'");
        result++;
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (context != null) context.close();
        if (conn != null) conn.close();
        if (stmt != null) stmt.close();
      }
      catch (NamingException e) {
        e.printStackTrace();
      }
      catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().println("Not supported method..use GET method.");
  }
}
