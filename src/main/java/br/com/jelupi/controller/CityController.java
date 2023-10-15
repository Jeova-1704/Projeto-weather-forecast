package br.com.jelupi.controller;

import br.com.jelupi.service.ICityService;
import br.com.jelupi.service.nominatim.NominatimCityService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller utilizado para tratar as requisições acerca das informações de cidades que pode ser acessado com base nas
 * URLs fornecidas em urlPatterns na annotation @WebServlet dessa classe <br><br>
 * APIs utilizadas:
 * <ul>
 *     <li><a href="https://nominatim.org/release-docs/latest/api/Overview/">Nominatim</a></li>
 * </ul>
 */
@WebServlet (urlPatterns = {"/CityLocation"})
public class CityController extends HttpServlet {
    private ICityService cityService;

    /**
     * Trata as requisições que utilizam o método POST, verificando o domínio através do qual foi acessado e realizando
     * as operações necessárias de acordo com esta
     * <b>OBS:</b><br>
     * <ul>
     *     <li>Requisições à <b>"/CityLocation"</b> devem respeitar o formato: <br> {"pesquisa_cidade":"nome da cidade"}</li>
     * </ul>
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        if (req.getServletPath().equals("/CityLocation")) {
            this.cityService = new NominatimCityService();

            resp.setContentType("application/json");

            String jsonInput = req.getReader().lines().reduce("", (acummulator, actual) -> acummulator + actual);

            resp.getWriter().write(this.cityService.getCityInformation(jsonInput));
        }
    }

}
