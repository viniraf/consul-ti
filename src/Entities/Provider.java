/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

public class Provider extends User{
    
    private String category;
    
    public Provider () {
        
    }
    
    public Provider (String name, String email, String login, String password, String cpf, int registration, String category) {
        super(name, email, login, password, cpf, registration);
        this.category = category;
    }
    
    public String GetCategory() {
        return category;
    }

    public void SetCategory(String category) {
        this.category = category;
    }
    

    
}
