/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

public class Collaborator extends User{
    private String _categoria;
    
    public String GetCategoria() {
        return _categoria;
    }
    
    public void SetCategoria(String categoria) {
        this._categoria = categoria;
    }
    
}
