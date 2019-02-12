package metube.web.servlets.user;

import metube.domain.models.binding.user.UserRegisterBindingModel;
import metube.services.UserService;
import metube.web.WebConstants;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(WebConstants.URL_USER_REGISTER)
public class UserRegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final UserService userService;

    @Inject
    public UserRegisterServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(WebConstants.JSP_USER_REGISTER).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRegisterBindingModel model = (UserRegisterBindingModel) req.getAttribute(WebConstants.ATTRIBUTE_MODEL);
        if (userService.register(model)) {
            resp.sendRedirect(WebConstants.URL_USER_LOGIN);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "User registration failed");
        }
    }
}
