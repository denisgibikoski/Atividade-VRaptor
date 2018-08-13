/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d3nys.atividadevraptor.controller.interceptor;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import static br.com.caelum.vraptor.view.Results.json;
import com.d3nys.atividadevraptor.model.Editora;
import com.d3nys.atividadevraptor.repository.EditoraRepository;
import com.d3nys.atividadevraptor.repository.Repository;
import javax.inject.Inject;

/**
 *
 * @author denis
 */
@Controller
@Path("/editora")
public class EditoraController extends AbstractController<Editora, Long> {

    @Inject
    private EditoraRepository editoraRepository;

    @Override
    protected Repository getRepository() {
        return editoraRepository;
    }

    @Path(value = {"", "/"})
    public void findAll() {
        result.use(json())
                .withoutRoot()
                .from(getRepository().findAll())
                .serialize();
    }

    @Override
    @Get
    @Path(value = "/page/")
    public void findAllPaged(int page, int size) {
        result.use(json())
                .withoutRoot()
                .from(getRepository().findAll(page, size))
                .serialize();

    }

}
