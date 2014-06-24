package com.taller.proyectos.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taller.proyectos.bean.AlumnoBean;
import com.taller.proyectos.bean.CursoBean;

public class Matricular extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException{
		
		int key= Integer.parseInt(request.getParameter("key"));
		MatricularAlumno obj = new MatricularAlumno();
	
		switch (key) {
		case 1: long idAlumno = Long.parseLong(request.getParameter("alumno")); 
				List<CursoBean> reporteAlu = obj.obtenerCursosPorAlumno(idAlumno);
				request.setAttribute("nombre", obj.getNombreAlumno(idAlumno));
				request.setAttribute("reporte", reporteAlu );
				RequestDispatcher rd =	getServletContext().getRequestDispatcher("/reporteAlu.jsp");
				rd.forward(request, response);
			
			break;
		
		case 2: int idCurso = Integer.parseInt(request.getParameter("curso")); 
				List<AlumnoBean> reporteAlu2 = obj.obtenerAlumnosDeUnCurso(idCurso);
				request.setAttribute("nombre", obj.getNombreCurso(idCurso));
				request.setAttribute("reporte", reporteAlu2 );
				RequestDispatcher rdw =	getServletContext().getRequestDispatcher("/reporteAlu2.jsp");
				rdw.forward(request, response);
	
			break;

		default:
				request.setAttribute("reporte", "No se encontro");
				RequestDispatcher rdq =	getServletContext().getRequestDispatcher("/msn.jsp");
				rdq.forward(request, response);
			break;
		}
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException{
			
		int ciclo= Integer.parseInt(request.getParameter("ciclo"));
		MatricularAlumno obj = new MatricularAlumno();
		
		List<CursoBean> reporte = obj.obtenerResultadoPorCiclo(ciclo);
		request.setAttribute("reporte", reporte );
		RequestDispatcher rd =
		getServletContext().getRequestDispatcher("/ciclo"+ciclo+".jsp");
		rd.forward(request, response);
		
		
		
		
		
	}

}
