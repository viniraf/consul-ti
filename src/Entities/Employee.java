/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

public class Employee extends User1{
    
    private String area;
    
    public Employee () {
        
    }
    
    public Employee (String name, String email, String login, String password, String cpf, int registration, String area) {
        super(name, email, login, password, cpf, registration);
        this.area = area;
    }
    
    public String GetArea() {
        return area;
    }
    public void SetArea(String area) {
        this.area = area;
    }
    
    
    
    
    
    
    
    
    
    
}
