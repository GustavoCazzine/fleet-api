package br.com.cazzine.fleet_api.dto;

public class FipeModelDTO {
    private Integer codigo;
    private String nome;

    public FipeModelDTO(){}

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
