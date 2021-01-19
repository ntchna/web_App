package application.controller.command.imp;

import application.controller.command.Command;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

public abstract class AbstractCommand implements Command {
    public String getSortType(HttpServletRequest request) {
        String sortType = "none";
        Iterator<String> it = request.getParameterNames().asIterator();
        while (it.hasNext()) {
            String name = it.next();
            String[] values = request.getParameterValues(name);
            for (String value : values) {
                if (!value.equals("none"))
                    sortType = value;
            }
        }
        return sortType;
    }

    public void setErrorRequest(HttpServletRequest req, HttpServletResponse resp, String errMessage, String page) throws ServletException, IOException {
        req.setAttribute("error", errMessage);
        req.setAttribute("pagelink", page);
        req.getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
    }
}
