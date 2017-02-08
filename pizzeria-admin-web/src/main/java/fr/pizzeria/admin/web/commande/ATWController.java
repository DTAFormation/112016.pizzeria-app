package fr.pizzeria.admin.web.commande;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Fawzi NASSIM on 07/02/2017.
 * API TO WEBSOCKET Controller
 * CALLED FROM THE SPRING BOOT API TO NOTICE THE ADMIN SERVER
 * WHEN CHANGED ARE MADE BY ANGULAR CLIENTS
 * THEN, PUSHES DATA THROUGH WEBSOCKET TO NOTICE EVERY ADMIN Connected
 */

@WebServlet("/admin/commandes/add/atw")
public class ATWController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        System.out.println("==========>HELLO THERE :D<==========");
    }
}
