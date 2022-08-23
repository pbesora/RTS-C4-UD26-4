package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Investigador;



public interface IInvestigadorService {

		public List<Investigador> listarInvestigadores(); //Listar All 
		
		public Investigador guardarInvestigador(Investigador investigador);	//Guarda un Investigador CREATE
		
		public Investigador investigadorXID(String id); //Leer datos de un Investigador READ
		
		public Investigador actualizarInvestigador(Investigador investigador); //Actualiza datos del Investigador UPDATE
		
		public void eliminarInvestigador(String id);// Elimina el Investigador DELETE
	

}


