package br.com.fiap.resource;

import br.com.fiap.bo.TecnologiaRenovavelBO;
import br.com.fiap.to.TecnologiaRenovavelTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/consultar/tecnologiaRenovavel")
public class TecnologiaRenovavelResource {
    private TecnologiaRenovavelBO tecnologiaRenovavelBO = new TecnologiaRenovavelBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<TecnologiaRenovavelTO> resultado = tecnologiaRenovavelBO.findAll();
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
        TecnologiaRenovavelTO resultado = tecnologiaRenovavelBO.findByCodigo(codigo);
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
    public Response save(@Valid TecnologiaRenovavelTO tecnologiaRenovavel) {
        TecnologiaRenovavelTO resultado = tecnologiaRenovavelBO.save(tecnologiaRenovavel);
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
        if (tecnologiaRenovavelBO.delete(codigo)) {
            response = Response.status(204); // 204 - NO CONTENT
        } else {
            response = Response.status(404); // 404 - NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid TecnologiaRenovavelTO tecnologiaRenovavel, @PathParam("codigo") Long codigo) {
        tecnologiaRenovavel.setCodigo(codigo);
        TecnologiaRenovavelTO resultado = tecnologiaRenovavelBO.update(tecnologiaRenovavel);
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
