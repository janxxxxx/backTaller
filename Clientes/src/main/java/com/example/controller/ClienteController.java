package main.java.com.example.controller;

import com.projectjava.demosclient.services.clienteService.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping
public class ClienteController {

    @Autowired
    ClienteServices clienteServices;

    @Autowired
    ClienteDao clienteDao;


    // @GetMapping("/principal")
    // public String principal(Model model){
    //     model.addAttribute("titulo", "BIENVENIDO AL SISTEMA DE INVENTARIO");

    //     return "/principal";
    // }


    @GetMapping("/listar")
    public String listar(@RequestParam(name="page", defaultValue= "0") int page, @Param("palabraClave") String palabraClave, Model model) {
        //lista que va a llevar los clientes
        Pageable pageRequest =  PageRequest.of(page,4);
        Page<Cliente> listClient = clienteServices.findAll(pageRequest, palabraClave);
        PageRender pageRender = new PageRender<>("/listar", listClient);

        model.addAttribute("titulo", "SISTEMA INVENTARIO");


        model.addAttribute("clientes",listClient);

        model.addAttribute("page", pageRender);
        model.addAttribute("palabraClave",palabraClave);
        if(listClient.getSize() > 0) {
            listClient.stream().sorted();
        }
        return "/listar";
    }





    @GetMapping("/crear/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {

        Cliente cliente;
        if(id > 0){
            cliente = clienteServices.buscarClienteNuevo(id);

        }else{
            return "redirect:/listar";
        }
        model.put("cliente", cliente);
        model.put("titulo", "editar cliente");
        return "/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable(value = "id") Long id) {
        if (id >= 0) {
            clienteServices.eliminarClienteNuevo(id);
        }
            return "redirect:/listar";
    }

    @GetMapping("/ver/{id}")
    public String mostrarCliente(@PathVariable(value = "id") Long id, Map<String, Object> model) {
        Cliente cliente = clienteServices.buscarClienteNuevo(id);
        model.put("cliente", cliente);
        model.put("titulo", "cliente encotrado: " + cliente.getNombre());
        return "/ver";
    }



    @RequestMapping("/crear")
    public String crear(Map<String, Object> model){
        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Formulario cliente");
        return "/crear";
    }


    @PostMapping("/crear")
    public String guardarCliente(Cliente cliente,Map<String, Object> model, RedirectAttributes mensajeRap ){
        clienteServices.guardarCliente(cliente);
        if (cliente.getId() == null){
            mensajeRap.addFlashAttribute("Cliente existente ");
        }else{
            mensajeRap.addFlashAttribute("Cliente creado");
        }
        return "redirect:/listar";

    }

    @GetMapping("/contact")
    public String contact(){
        return "contact/contact";
    }


}

