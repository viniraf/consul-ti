package Entities;

public class Produto {
    private String _produto;
    private String _descricao;
    private String _fornecedor;
    private float _custo;
    private float _venda;
    private float _icms;
    private int _tamanho;
    


public Produto (String nome, String descricao, String fornecedor, float custo, float venda, float icms, int tamanho){
    this._produto = nome;
    this._descricao = descricao;
    this._fornecedor = fornecedor;
    this._custo = custo;
    this._venda = venda;
    this._icms = icms;
    this._tamanho = tamanho;
}

public void SetNome (String nome) {
    this._produto = nome;
}

public String GetNome () {
    return this._produto;
}

public void SetDescricao (String descricao) {
    this._descricao = descricao;
}

public String GetDescricao () {
    return this._descricao;
}

public void SetFornecedor (String fornecedor) {
    this._fornecedor = fornecedor;
}

public String GetFornecedor () {
    return this._fornecedor;
}

public void SetCusto (float custo) {
    this._custo = custo;
}

public float GetCusto () {
    return this._custo;
}

public void SetVenda (float venda) {
    this._venda = venda;
}

public float GetVenda () {
    return this._venda;
}

public void SetIcms (float icms) {
    this._icms = icms;
}

public float GetIcms () {
    return this._icms;
}

public void SetTamanho (int tamanho) {
    this._tamanho = tamanho;
}

public float GetTamanho () {
    return this._tamanho;
}

}