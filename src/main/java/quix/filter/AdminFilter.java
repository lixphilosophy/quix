package quix.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter extends HttpFilter {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = req.getSession(false);

        if(session == null || session.getAttribute("userID") == null) {
            res.sendRedirect(req.getContextPath()+"/login");
        } else if(session.getAttribute("role") == null || (int)session.getAttribute("role") != 2) {
            res.sendRedirect(req.getContextPath() + "/page/quiz");
        } else {
            chain.doFilter(req, res);
        }
    }
}
