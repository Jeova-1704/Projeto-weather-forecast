package br.com.jelupi.controller;

import br.com.jelupi.service.IWeatherService;
import br.com.jelupi.service.OpenWeatherService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller utilizado para tratar as requisições acerca das informações do clima que pode ser acessado com base nas
 * URLs fornecidas em urlPatterns na annotation @WebServlet dessa classe <br><br>
 * APIs utilizadas:
 * <ul>
 *     <li><a href="https://openweathermap.org">OpenWeatherAPI</a></li>
 * </ul>
 */
@WebServlet(urlPatterns = {"/WeatherAcess"})
public class WeatherController extends HttpServlet {

    private IWeatherService weatherService;

    /**
     * Trata as requisições que utilizam o método POST, verificando o domínio através do qual foi acessado e realizando
     * as operações necessárias de acordo com esta
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");

        // Obtém informações da API OpenWeather
        if (req.getServletPath().equals("/WeatherAcess")) {
            this.weatherService = new OpenWeatherService();

            resp.setContentType("application/json");

            String jsonInput = req.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);

            resp.getWriter().write(this.weatherService.getWeatherInformation(jsonInput));
        }
    }

}
