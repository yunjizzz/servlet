package org.example;

import org.example.calculator.Calculator;
import org.example.calculator.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 클래스 설명
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/16
 */
@WebServlet("/calculate")
public class CalculatorServlet implements Servlet {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorServlet.class);
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("service");
        int operand1 = Integer.parseInt(req.getParameter("operand1"));
        int operand2 = Integer.parseInt(req.getParameter("operand2"));
        String operator = req.getParameter("operator");

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
        PrintWriter writer = res.getWriter();
        writer.println(result);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
