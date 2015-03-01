package com.sadvit.persistence.dao;

import com.sadvit.persistence.domain.Stock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockDAO extends AbstractDAO<Stock> {

    @Override
    public Stock load(Integer id) {
        return super._load(Stock.class, id);
    }

    @Override
    public List<Stock> loadAll() {
        return super._loadAll(Stock.class);
    }

}
