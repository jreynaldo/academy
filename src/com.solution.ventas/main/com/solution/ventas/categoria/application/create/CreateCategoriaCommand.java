package com.solution.ventas.categoria.application.create;

import com.solution.shared.domain.bus.command.Command;

public final class CreateCategoriaCommand implements Command {

    private String id;
    private String nombre;
    private String descripcion;

    public CreateCategoriaCommand(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String id() {
        return id;
    }

    public String nombre() {
        return nombre;
    }

    public String descripcion() {
        return descripcion;
    }
}
