package com.example.demo.controlador;

import com.example.demo.modelo.Estudiante;
import com.example.demo.servicio.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EstudianteControlador {

    @Autowired
    private EstudianteServicio estudianteServicio;

    @GetMapping({"/estudiantes", "/"})
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteServicio.listarEstudiantes());
        return "estudiantes"; // Devuelve la vista "estudiantes"
    }

    @GetMapping("/estudiantes/nuevo")
    public String mostrarFormularioRegistroEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "crear_estudiante"; // Devuelve la vista "crear_estudiante"
    }

    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        estudianteServicio.guardarEstudiante(estudiante);
        return "redirect:/estudiantes"; // Redirecciona a la URL "/estudiantes"
    }

    @GetMapping("/estudiantes/editar/{codigo}")
    public String mostrarFormularioEdicionEstudiante(@PathVariable(name = "codigo") Long codigo, Model model) {
        model.addAttribute("estudiante", estudianteServicio.obtenerEstudiantePorCodigo(codigo));
        return "editar_estudiante"; // Devuelve la vista "editar_estudiante"
    }

    @PostMapping("/estudiantes/{codigo}")
    public String actualizarEstudiante(@PathVariable Long codigo, @ModelAttribute("estudiante") Estudiante estudiante) {
        Estudiante estudianteExistente = estudianteServicio.obtenerEstudiantePorCodigo(codigo);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setCelular(estudiante.getCelular());
        estudianteServicio.guardarEstudiante(estudianteExistente);
        return "redirect:/estudiantes"; // Redirecciona a la URL "/estudiantes"
    }

    @GetMapping("/estudiantes/eliminar/{codigo}")
    public String eliminarEstudiante(@PathVariable(name = "codigo") Long codigo) {
        estudianteServicio.eliminarEstudiante(codigo);
        return "redirect:/estudiantes"; // Redirecciona a la URL "/estudiantes"
    }
}
