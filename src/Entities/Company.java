
package Entities;

public class Company {

    private String name;
    private String category;
    private String cnpj;
    private String creationDate;
    private int monthsContractTime;
    
    public String GetName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public String GetCategory() {
        return category;
    }

    public void SetCategory(String category) {
        this.category = category;
    }
    
    public int GetMonthsContractTime() {
        return monthsContractTime;
    }

    public void SetMonthsContractTime(int monthsContractTime) {
        this.monthsContractTime = monthsContractTime;
    }
    
    public String GetCnpj() {
        return cnpj;
    }

    public void SetCnpj (String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String GetCreationDate() {
        return creationDate;
    }

    public void SetCreationDate (String creationDate) {
        this.creationDate = creationDate;
    }
    
    
    
    
    
    
    
    
    
}
