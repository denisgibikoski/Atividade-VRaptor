package com.d3nys.atividadevraptor.model;

import java.io.Serializable;

public interface AbstractModel <ID extends  Serializable> extends Serializable{
    ID getId();
}
