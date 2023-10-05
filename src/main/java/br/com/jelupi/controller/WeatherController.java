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

    private IWeatherService weatherRequest;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getServletPath().equals("/WeatherAcess")) {
            this.weatherRequest = new OpenWeatherService();

            resp.setContentType("application/json");

            String jsonInput = req.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);

            resp.getWriter().write(this.weatherRequest.getWeatherInformation(jsonInput));
        }
    }

}
