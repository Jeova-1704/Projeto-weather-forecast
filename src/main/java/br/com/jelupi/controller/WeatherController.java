package br.com.jelupi.controller;

import br.com.jelupi.service.IWeatherService;
import br.com.jelupi.service.OpenWeatherService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/WeatherAcess"})
public class WeatherController extends HttpServlet {

    private IWeatherService weatherService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");

        if (req.getServletPath().equals("/WeatherAcess")) {
            this.weatherService = new OpenWeatherService();

            resp.setContentType("application/json");

            String jsonInput = req.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);

            System.out.println(jsonInput);

            resp.getWriter().write(this.weatherService.getWeatherInformation(jsonInput));
        }
    }

}
