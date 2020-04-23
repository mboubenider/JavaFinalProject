//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.Order;

public class CustOrderTable {
    String custIDCol;
    String custFName;
    String custLName;

    public CustOrderTable(String custIDCol, String custFName, String custLName) {
        this.custIDCol = custIDCol;
        this.custFName = custFName;
        this.custLName = custLName;
    }

    public String getCustIDCol() {
        return this.custIDCol;
    }

    public void setCustIDCol(String custIDCol) {
        this.custIDCol = custIDCol;
    }

    public String getCustFName() {
        return this.custFName;
    }

    public void setCustFName(String custFName) {
        this.custFName = custFName;
    }

    public String getCustLName() {
        return this.custLName;
    }

    public void setCustLName(String custLName) {
        this.custLName = custLName;
    }
}
