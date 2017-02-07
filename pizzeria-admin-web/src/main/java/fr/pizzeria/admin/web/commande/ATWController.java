package fr.pizzeria.admin.web.commande;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


/**
 * Created by Fawzi NASSIM on 07/02/2017.
 * API TO WEBSOCKET Controller
 * CALLED FROM THE SPRING BOOT API TO NOTICE THE ADMIN SERVER
 * WHEN CHANGED ARE MADE BY ANGULAR CLIENTS
 * THEN, PUSHES DATA THROUGH WEBSOCKET TO NOTICE EVERY ADMIN Connected
 */

@WebServlet("/admin/commandes/add")
public class ATWController extends HttpServlet {


}
