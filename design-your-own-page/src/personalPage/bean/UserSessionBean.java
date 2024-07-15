package personalPage.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import javax.faces.context.FacesContext;

@ManagedBean(name = "userSessionBean")
@SessionScoped
public class UserSessionBean implements Serializable {
    private static final long serialVersionUID = 1L;  // Unique identifier for Serializable class
    private boolean loggedIn; // Flag to track login status

    /**
     * Returns the login status of the user.
     * @return true if the user is logged in, otherwise false.
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * Sets the user's login status and updates the session attribute accordingly.
     * @param loggedIn true to set the user as logged in, false otherwise.
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
        if (loggedIn) {
            getSession().setAttribute("loggedIn", true);
        } else {
            getSession().removeAttribute("loggedIn");
        }
    }

    /**
     * Logs out the user by setting the loggedIn flag to false and invalidating the session.
     * @return Navigation string that redirects to the index page.
     */
    public String logout() {
        loggedIn = false;
        getSession().invalidate();
        return "index?faces-redirect=true";
    }

    /**
     * Determines the appropriate redirection page based on user's login status.
     * @return String representing the navigation target: 'design' if logged in, 'login' if not.
     */
    public String getRedirectPage() {
        HttpSession session = getSession();
        Boolean sessionLoggedIn = (Boolean) session.getAttribute("loggedIn");
        return (sessionLoggedIn != null && sessionLoggedIn) ? "design" : "login";
    }

    /**
     * Retrieves the current HTTP session, creating one if it does not exist.
     * @return The current HttpSession object.
     */
    private HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }
}
