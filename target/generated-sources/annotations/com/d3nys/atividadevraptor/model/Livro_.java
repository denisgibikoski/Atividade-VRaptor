package com.d3nys.atividadevraptor.model;

import com.d3nys.atividadevraptor.model.Editora;
import com.d3nys.atividadevraptor.model.Genero;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-12T16:08:01")
@StaticMetamodel(Livro.class)
public class Livro_ { 

    public static volatile SingularAttribute<Livro, Integer> paginas;
    public static volatile SingularAttribute<Livro, Integer> ano;
    public static volatile SingularAttribute<Livro, String> isbn;
    public static volatile SingularAttribute<Livro, Genero> genero;
    public static volatile SingularAttribute<Livro, String> titulo;
    public static volatile SingularAttribute<Livro, Long> id;
    public static volatile SingularAttribute<Livro, Editora> editora;

}