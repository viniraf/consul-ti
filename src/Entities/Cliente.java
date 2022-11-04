
package Entities;

public class Cliente {
    private String _nome;
    private String _cpf;
    private String _sexo;
    private String _endereco;
    public String _cidade;
    public String _estado;
    
    public Cliente (String nome, String cpf, String sexo, String endereco, String cidade, String estado) {
        this._nome = nome;
        this._cpf = cpf;
        this._sexo = sexo;
        this._endereco = endereco;
        this._cidade = cidade;
        this._estado = estado;
    }

    
    public void SetNome(String nome) {
        this._nome = nome;
    }
    
    public String GetNome() {
        return this._nome;
    }
    
    public void SetCpf (String cpf) {
        this._cpf = cpf;
    }
    
    public String GetCpf () {
        return this._cpf;
    }
    
    public void SetSexo (String sexo) {
        this._sexo = sexo;
    }
    
    public String GetSexo () {
        return this._sexo;
    }
    
    public void SetEndereco (String endereco) {
        this._endereco = endereco;
    }
    
    public String GetEndereco () {
        return this._endereco;
    }
    
    public void SetCidade (String cidade) {
        this._cidade = cidade;
    }
    
    public String GetCidade () {
        return this._cidade;
    }
    
    public void SetEstado (String estado) {
        this._estado = estado;
    }
    
    public String GetEstado () {
        return this._estado;
    }

    
    
    
    
    
    
    
    
}
