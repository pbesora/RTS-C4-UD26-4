package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Investigador;
import com.example.demo.service.InvestigadorServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	InvestigadorServiceImpl productoServiceImpl;
	
	@GetMapping("/productos")
	public List<Investigador> listarCcursos(){
		return productoServiceImpl.listarProductos();
	}
	
	
	@PostMapping("/productos")
	public Investigador salvarProducto(@RequestBody Investigador producto) {
		
		return productoServiceImpl.guardarProducto(producto);
	}
	
	
	@GetMapping("/productos/{id}")
	public Investigador ProductoXID(@PathVariable(name="id") int id) {
		
		Investigador Producto_xid= new Investigador();
		
		Producto_xid=productoServiceImpl.productoXID(id);
		
		System.out.println("Producto XID: "+Producto_xid);
		
		return Producto_xid;
	}
	
	@PutMapping("/productos/{id}")
	public Investigador actualizarProducto(@PathVariable(name="id")int id,@RequestBody Investigador producto) {
		
		Investigador producto_seleccionado= new Investigador();
		Investigador producto_actualizado= new Investigador();
		
		producto_seleccionado= productoServiceImpl.productoXID(id);
		
		producto_seleccionado.setNombre(producto.getNombre());
		producto_seleccionado.setPrecio(producto.getPrecio());
		
		producto_actualizado = productoServiceImpl.actualizarProducto(producto_seleccionado);
		
		System.out.println("El Producto actualizado es: "+ producto_actualizado);
		
		return producto_actualizado;
	}
	
	@DeleteMapping("/productos/{id}")
	public String eliminarProducto(@PathVariable(name="id")int id) {
		try {
			productoServiceImpl.eliminarProducto(id);
			return "Producto eliminado";
		} catch (Exception e) {
			return "El producto no se puede eliminar";
		}
	}
	
	
}
