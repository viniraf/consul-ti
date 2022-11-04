
package Entities;


public class User {
    
    private String _nome;
    private String _email;
    private String _login;
    private String _senha;
    private int _Cpf;
    
    
    public String GetNome (){
    return this._nome;
}
    public void SetNome(String nome) {
        this._nome = nome;
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
    
        public String GetSenha (){
    return this._senha;
}
        
    public void SetSenha(String senha) {
        this._senha = senha;
    }
    
        public int GetCpf (){
    return this._Cpf;
}
        
    public void SetCpf(int cpf) {
        this._Cpf = cpf;
    }
    
    
    
    
    
    
    
}
