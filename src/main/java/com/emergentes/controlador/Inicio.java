package com.emergentes.controlador;

import com.emergentes.dao.EventoDAO;
import com.emergentes.dao.EventoDAOimpl;
import com.emergentes.modelo.Evento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EventoDAO dao = new EventoDAOimpl();
            int id;
            Evento ev = new Evento();
            String action = (request.getParameter("action") !=null) ? request.getParameter("action"):"view";
            switch(action){
                case "add":
                    request.setAttribute("evento", ev);
                    request.getRequestDispatcher("frmevento.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    ev = dao.getById(id);
                    request.setAttribute("evento", ev);
                    request.getRequestDispatcher("frmevento.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Inicio");
                    break;
                case "view":
                    List<Evento>lista = dao.getAll();
                    request.setAttribute("eventos", lista);
                    request.getRequestDispatcher("listado.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error" +e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EventoDAO dao = new EventoDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String exposito = request.getParameter("expositor");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        int cupo = Integer.parseInt(request.getParameter("cupo"));
        
        Evento ev = new Evento();
        ev.setId(id);
        ev.setTitulo(titulo);
        ev.setExpositor(exposito);
        ev.setFecha(fecha);
        ev.setHora(hora);
        ev.setCupo(cupo);
        
        if(id == 0){
            try {
                dao.insert(ev);
                response.sendRedirect("Inicio");
            } catch (Exception ex) {
                System.out.println("Error"+ ex.getMessage());
            }
        }else {
            try {
                dao.update(ev);
                response.sendRedirect("Inicio");
            } catch (Exception ex) {
                System.out.println("Error" + ex.getMessage());
            }
        }
    }

}
