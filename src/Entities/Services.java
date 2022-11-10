/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

public class Services {
    
    private String description;
    private String category;
    private String provider;
    
    public Services () {
        
    }
    
    public Services (String description, String category, String provider) {
        this.description = description;
        this.category = category;
        this.provider = provider;
    }
    
    
    public String GetDescription() {
        return description;
    }

    public void SetDescription(String description) {
        this.description = description;
    }

    public String GetCategory() {
        return category;
    }

    public void SetCategory(String category) {
        this.category = category;
    }


    public String GetProvider() {
        return provider;
    }

    public void SetProvider(String provider) {
        this.provider = provider;
    }

}
