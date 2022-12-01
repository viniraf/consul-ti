/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author vinic
 */
public class LoginModel {
    
    // Atributos
    private String login;
    private String password;

    
    // Construtores

    public LoginModel() {
    }

    public LoginModel(String login, String password) {
        this.login = login;
        this.password = password;
    }


    

    
    // Getters e Setters
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
