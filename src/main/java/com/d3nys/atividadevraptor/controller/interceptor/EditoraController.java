/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d3nys.atividadevraptor.controller.interceptor;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;
import static br.com.caelum.vraptor.view.Results.json;
import static br.com.caelum.vraptor.view.Results.status;
import com.d3nys.atividadevraptor.model.Editora;
import com.d3nys.atividadevraptor.repository.EditoraRepository;
import com.d3nys.atividadevraptor.repository.impl.EditoraRepositoryImpl;
import javax.inject.Inject;

/**
 *
 * @author denis
 */
@Controller
@Path("/editora")
public class EditoraController {

    private Result result;

    private EditoraRepository editoraRepository;

    /**
     * @deprecated
     */
    public EditoraController() {
    }

    @Inject
    public EditoraController(Result result, EditoraRepositoryImpl editoraRepositoryImpl) {
        this.result = result;
        this.editoraRepository = editoraRepositoryImpl;

    }

    @Get
    @Path(value = {"", "/"})
    public void list() {

        result.use(json())
                .withoutRoot()
                .from(editoraRepository.findAll())
                .serialize();

    }
    
    @Get
    @Path(value =  "/{id}")
    public void buscar(Long id) {

        result.use(json())
                .withoutRoot()
                .from(editoraRepository.findOne(id))
                .serialize();

    }
    @Post
    @Path(value = {"/",""})
    @Consumes(value = "application/json",options = WithoutRoot.class )
    public void salvar(Editora editora){
        editoraRepository.save(editora);
        result.use(status()).created();
    }
    
    @Put
    @Path(value = {"/",""})
    @Consumes(value = "application/json",options = WithoutRoot.class )
    public void atualizar(Editora editora){
        editoraRepository.save(editora);
        result.use(status()).ok();
        
    }
    
    @Delete
    @Path(value =  "/{id}")
    public void remove(Long id){
        editoraRepository.remove(id);
        result.use(status()).ok();
        
    }
    
    @Delete
    @Path(value = "/")
    @Consumes(value = "application/json",options = WithoutRoot.class )
    public void remove(Editora editora){
        editoraRepository.remove(editora.getId());
        result.use(status()).ok();
        
    }

}
