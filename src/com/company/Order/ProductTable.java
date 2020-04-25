//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.Order;

public class ProductTable {
    String prodIDCol;
    String prodNameCol;
    String prodPriceCol;

    public ProductTable(String prodIDCol, String prodNameCol, String prodPriceCol) {
        this.prodIDCol = prodIDCol;
        this.prodNameCol = prodNameCol;
        this.prodPriceCol = prodPriceCol;

    }

    public String getProdPriceCol() {
        return this.prodPriceCol;
    }

    public void setProdPRice(String prodIDCol) {
        this.prodPriceCol = prodPriceCol;
    }

    public String getProdIDCol() {
        return this.prodIDCol;
    }

    public void setProdIDCol(String prodIDCol) {
        this.prodIDCol = prodIDCol;
    }

    public String getProdNameCol() {
        return this.prodNameCol;
    }

    public void setProdNameCol(String prodNameCol) {
        this.prodNameCol = prodNameCol;
    }

}
