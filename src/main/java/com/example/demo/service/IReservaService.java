package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Reserva;

public interface IReservaService {

	//Metodos del CRUD
		public List<Reserva> listarReservas();
		
		public Reserva guardarReserva(Reserva reserva);
		
		public Reserva reservaXID(int id);
		
		public Reserva actualizarReserva(Reserva reserva);
		
		public void eliminarReserva(int id);
	
}


