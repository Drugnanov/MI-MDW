package cz.fit.mdw.ukol3;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.nimbus.State;
import java.io.IOException;

/**
 * Created by Drugnanov on 4.11.2015.
 */
public class SessionServlet extends javax.servlet.http.HttpServlet {

  //  private static enum States {NEW , PAYMENT, COMPLETED};
  private static String[] states = new String[] {"NEW", "PAYMENT", "COMPLETED"};

  private final String PERSIST_COOKIE_TYPE = "cookie";
  private final String PERSIST_SESSION_TYPE = "session";

  private final String GET_PARAM_STATE = "state";

  protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
      throws javax.servlet.ServletException, IOException {
    response.getWriter().println("This app accepts only GET requests.");
  }

  protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
      throws javax.servlet.ServletException, IOException {

    int state = -1;
    String persistType = null;
    persistType = request.getParameter("persist");
    if (persistType == null) {
      //default persist type
      persistType = PERSIST_SESSION_TYPE;
    }

    if (persistType.equalsIgnoreCase(PERSIST_COOKIE_TYPE)) {
      state = cookieHandler(request, response);
    }
    else if (persistType.equalsIgnoreCase(PERSIST_SESSION_TYPE)) {
      state = sessionHandler(request);
    }
    else {
      response.getWriter().println("Unknown persist type!");
      return;
    }

    if (state == -1) {
      response.getWriter().println("Bad state!");
    }
    else {
      response.getWriter().println(states[state]);
    }
  }

  protected int sessionHandler(HttpServletRequest request) {

    HttpSession session = request.getSession();

    int state;
    if (session.getAttribute("state") == null) {
      state = 0;
      session.setAttribute(GET_PARAM_STATE, state);
      return 0;
    }
    state = (int) session.getAttribute("state");
    //dont know what to do;
    if (state < 0 || state > 2) {
      return -1;
    }
    state++;
    if (state >= 2) {
      session.invalidate();
    }
    else {
      session.setAttribute("state", state);
    }
    return state;
  }

  protected int cookieHandler(HttpServletRequest request, HttpServletResponse response) {

    Cookie[] cookies = request.getCookies();

    int state = 0;
    boolean cookieSet = false;

    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (GET_PARAM_STATE.equalsIgnoreCase(cookie.getName())) {
          cookieSet = true;
          state = Integer.parseInt(cookie.getValue());
          break;
        }
      }
    }

    //dont know what to do;
    if (state < 0 || state > 2) {
      return -1;
    }

    state = (cookieSet) ? ++state: 0;
    Cookie cookie = new Cookie(GET_PARAM_STATE, Integer.toString(state));
    if (state >= 2) {
      cookie.setMaxAge(0);
    }
    else {
      cookie.setMaxAge(3600);
    }
    response.addCookie(cookie);

    return state;
  }
}
