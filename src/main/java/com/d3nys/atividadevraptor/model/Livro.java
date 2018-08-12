package com.d3nys.atividadevraptor.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "livro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString()
public class Livro implements AbstractModel, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", length = 50, nullable = false)
    private String titulo;

    @Column(name = "ano", length = 4, nullable = false)
    private Integer ano;

    @Column(name = "paginas", length = 4, nullable = false)
    private Integer paginas;
    
    @Column(name = "isbn", length = 13, nullable = false)
    private String isbn;

    @ManyToOne()
    @JoinColumn(name = "editora_id", referencedColumnName = "id")
    private Editora editora;

    @ManyToOne()
    @JoinColumn(name = "genero_id", referencedColumnName = "id")
    private Genero genero;
    
}
