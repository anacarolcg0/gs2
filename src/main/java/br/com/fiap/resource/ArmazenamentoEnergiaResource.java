package br.com.fiap.resource;

import br.com.fiap.bo.ArmazenamentoEnergiaBO;
import br.com.fiap.to.ArmazenamentoEnergiaTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/consultar/armazenamentoEnergia")
public class ArmazenamentoEnergiaResource {
    private ArmazenamentoEnergiaBO armazenamentoEnergiaBO = new ArmazenamentoEnergiaBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ArmazenamentoEnergiaTO> resultado = armazenamentoEnergiaBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 (OK)
        } else {
            response = Response.status(404); // 404 (NOT FOUND)
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("codigo") Long codigo) {
        ArmazenamentoEnergiaTO resultado = armazenamentoEnergiaBO.findByCodigo(codigo);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 (OK)
        } else {
            response = Response.status(404); // 404 (NOT FOUND)
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid ArmazenamentoEnergiaTO armazenamentoEnergia) {
        ArmazenamentoEnergiaTO resultado = armazenamentoEnergiaBO.save(armazenamentoEnergia);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201 - CREATED
        } else {
            response = Response.status(400); // 400 - BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{codigo}")
    public Response delete(@PathParam("codigo") Long codigo) {
        Response.ResponseBuilder response = null;
        if (armazenamentoEnergiaBO.delete(codigo)) {
            response = Response.status(204); // 204 - NO CONTENT
        } else {
            response = Response.status(404); // 404 - NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ArmazenamentoEnergiaTO armazenamentoEnergia, @PathParam("codigo") Long codigo) {
        armazenamentoEnergia.setCodigo(codigo);
        ArmazenamentoEnergiaTO resultado = armazenamentoEnergiaBO.update(armazenamentoEnergia);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201 - CREATED
        } else {
            response = Response.status(400); // 400 - BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }
}
