package com.sadvit.persistence.domain;

import com.sadvit.persistence.domain.Stock;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table
public class StockDetail implements java.io.Serializable {

    @GenericGenerator(
            name = "generator",
            strategy = "foreign",
            parameters = @Parameter(
                    name = "property",
                    value = "stock"
            )
    )
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "STOCK_ID", unique = true, nullable = false)
	private Integer stockId;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
	private Stock stock;

	public StockDetail() {
	}

	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}


	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
