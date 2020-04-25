//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.Invoice;

public class InvoiceTable {
    String invIDCol;
    String invDateCol;
    String invCustIDCol;
    String invEmpIDCol;
    String invProdIDCol;


    public InvoiceTable(String invIDCol, String invDateCol, String invCustIDCol, String invEmpIDCol, String invProdIDCol) {
        this.invIDCol = invIDCol;
        this.invDateCol = invDateCol;
        this.invCustIDCol = invCustIDCol;
        this.invEmpIDCol = invEmpIDCol;
        this.invProdIDCol = invProdIDCol;

    }

    public String getInvIDCol() {
        return this.invIDCol;
    }

    public void setInvIDCol(String invIDCol) {
        this.invIDCol = invIDCol;
    }

    public String getInvDateCol() {
        return this.invDateCol;
    }

    public void setInvDateCol(String invDateCol) {
        this.invDateCol = invDateCol;
    }

    public String getInvCustIDCol() {
        return this.invCustIDCol;
    }

    public void setInvCustIDCol(String invCustIDCol) {
        this.invCustIDCol = invCustIDCol;
    }

    public String getInvEmpIDCol() {
        return this.invEmpIDCol;
    }

    public void setInvEmpIDCol(String invEmpIDCol) {
        this.invEmpIDCol = invEmpIDCol;
    }

    public String getInvProdIDCol() {
        return this.invProdIDCol;
    }

    public void setInvProdIDCol(String invProdIDCol) {
        this.invProdIDCol = invProdIDCol;
    }

}
