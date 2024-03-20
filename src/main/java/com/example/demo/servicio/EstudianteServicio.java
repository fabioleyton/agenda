package com.example.demo.servicio;

import com.example.demo.modelo.Estudiante;
import com.example.demo.repositorio.EstudianteRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServicio {

	@Autowired
    private EstudianteRepositorio estudianteRepositorio;

    public List<Estudiante> listarEstudiantes() {
        return estudianteRepositorio.findAll();
    }

    public void guardarEstudiante(Estudiante estudiante) {
        estudianteRepositorio.save(estudiante);
    }

    public Estudiante obtenerEstudiantePorCodigo(Long codigo) {
        return estudianteRepositorio.findById(codigo).orElse(null);
    }

    public void eliminarEstudiante(Long codigo) {
        estudianteRepositorio.deleteById(codigo);
    }
}
