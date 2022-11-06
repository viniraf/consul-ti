
package Entities;


public class User {
    
    private String name;
    private String email;
    private String login;
    private String password;
    private int cpf;
    private int registration;
    
    public String GetName (){
    return this.name;
}
    public void SetName(String name) {
        this.name = name;
    }
    
        public String GetEmail (){
    return this.email;
}
        
    public void SetEmail(String email) {
        this.email = email;
    }
    
        public String GetLogin (){
    return this.login;
}
        
    public void SetLogin(String login) {
        this.login = login;
    }
    
        public String GetPassword (){
    return this.password;
}
        
    public void SetPassword(String senha) {
        this.password = senha;
    }
    
        public int GetCpf (){
    return this.cpf;
}
        
    public void SetCpf(int cpf) {
        this.cpf = cpf;
    }
    
    public int GetRegistration (){
    return this.registration;
}
        
    public void SetRegistration(int registration) {
        this.registration = registration;
    }
    
    
    
    
    
    
}
