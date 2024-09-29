package com.primeraEntrega.primeraEntrega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.primeraEntrega.primeraEntrega.model.Cliente;
import com.primeraEntrega.primeraEntrega.model.Panaderia;
import com.primeraEntrega.primeraEntrega.model.Producto;
import com.primeraEntrega.primeraEntrega.services.ClienteService;
import com.primeraEntrega.primeraEntrega.services.PanaderiaService;
import com.primeraEntrega.primeraEntrega.services.ProductoService;
import java.util.List;
import java.util.Optional;

//probamos la aplicacion con el commandlinerunner
@SpringBootApplication
public class PrimeraEntregaApplication implements CommandLineRunner {
	//se importan los services
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProductoService productoService;

	@Autowired
	private PanaderiaService panaderiaService;

	//se hace el override
	public static void main(String[] args) {
		SpringApplication.run(PrimeraEntregaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//creamos las panaderias
		System.out.println("Creamos las panaderias");

		//instanciamos con el new
		Panaderia panaderia1 = new Panaderia(null, "Panaderia La Fika", "Geronimo de alderete 1800", "56988888888");
		Panaderia panaderia2 = new Panaderia(null, "Panaderia Fornaio", "Andacollo 1280", "56977777777");

		// guardamos las panaderias
		panaderia1 = this.panaderiaService.savePanaderia(panaderia1);
    	panaderia2 = this.panaderiaService.savePanaderia(panaderia2);

		// creamos los productos para la panaderia especifica
		System.out.println("Creamos los productos para las panaderías");

		Producto producto1 = new Producto(null, "Pan de campo", 1500.0,5, "Pan", panaderia1);
		Producto producto2 = new Producto(null, "Croissant", 1200.0,5, "Bolleria", panaderia1);
		Producto producto3 = new Producto(null, "Focaccia", 2500.0,5, "Pan", panaderia2);
		Producto producto4 = new Producto(null, "Ciabatta", 2000.0,5, "Pan", panaderia2);

		//guardamos los productos
		this.productoService.saveProducto(producto1);
    	this.productoService.saveProducto(producto2);
    	this.productoService.saveProducto(producto3);
    	this.productoService.saveProducto(producto4);

		System.out.println("Creamos los clientes");

		//creamos clientes dependiendo de la panaderia que van
		Cliente cliente1 = new Cliente(null, "Pepe", "pepe@email.com", "56966666666", panaderia2);
		Cliente cliente2 = new Cliente(null, "Maria", "Maria@email.com", "56955555555", panaderia1);
		Cliente cliente3 = new Cliente(null, "Pablo", "Pablo@email.com", "56944444444", panaderia2);
		Cliente cliente4 = new Cliente(null, "Juan", "Juan@email.com", "56933333333", panaderia1);

		//guardamos los clientes
		this.clienteService.saveCliente(cliente1);
		this.clienteService.saveCliente(cliente2);
		this.clienteService.saveCliente(cliente3);
		this.clienteService.saveCliente(cliente4);

		//uso de metodos de busqueda
		System.out.println("buscamos las panaderias");

		//se llama al service y se le pide el metodo luego se itera para que nos de los atributos de cada panaderia
		List<Panaderia> panaderias = this.panaderiaService.getAllPanaderias();

			for (Panaderia panaderia : panaderias) {
			System.out.println("ID: " + panaderia.getId() + ", Nombre: " + panaderia.getNombre() + ", Dirección: " + panaderia.getDireccion() + ", Teléfono: " + panaderia.getTelefono());
		}

		System.out.println("buscamos clientes de la panaderia 1");

		// se llama al service para que nos de los clientes de la panaderia especifica y luego se itera para buscar los atributos
		List<Cliente> clientesPanaderia1 = this.clienteService.getClientesByPanaderiaId(1l);

			for (Cliente cliente : clientesPanaderia1) {
				System.out.println("ID: " + cliente.getNombre() + ", Correo: " + cliente.getCorreo() + ", Telefono: " + cliente.getTelefono());
			}
		// borremos un cliente en este caso al no existir se maneja la excepcion
		System.out.println("Probamos borrar un cliente que no existe");

		this.clienteService.deleteCliente(5l);

		// se añade mas stock de un producto por id
		System.out.println("añadimos más stock a un producto");
		// se llama al service
		this.productoService.updateStockProducto(2l, 10);
		// ahora para mostrarlo por consola debo buscarlo con el getbyid y si lo encuentra me muestra el nuevo stock por consola con los gets
		Optional<Producto> productoBuscar = this.productoService.getProductoById(2l);

		if (productoBuscar.isPresent()) {
			Producto producto = productoBuscar.get();
			System.out.println("Producto ID: " + producto.getId());
			System.out.println("Stock actual: " + producto.getStock());
		} else {
			System.out.println("Producto no encontrado");
		}

	}

}
