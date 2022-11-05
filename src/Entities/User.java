
package Entities;


public class User {
    
    private String _name;
    private String _email;
    private String _login;
    private String _password;
    private int _Cpf;
    
    
    public String GetName (){
    return this._name;
}
    public void SetName(String nome) {
        this._name = nome;
    }
    
        public String GetEmail (){
    return this._email;
}
        
    public void SetEmail(String email) {
        this._email = email;
    }
    
        public String GetLogin (){
    return this._login;
}
        
    public void SetLogin(String login) {
        this._login = login;
    }
    
        public String GetPassword (){
    return this._password;
}
        
    public void SetPassword(String senha) {
        this._password = senha;
    }
    
        public int GetCpf (){
    return this._Cpf;
}
        
    public void SetCpf(int cpf) {
        this._Cpf = cpf;
    }
    
    
    
    
    
    
    
}
