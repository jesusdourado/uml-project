package bean;

public class Vendedor {
    private int IDV;
    private String nome;
    private String CPF;
    private String matricula;
    private String senha;
    
    public Vendedor(){
    }

    public Vendedor(int IDV, String nome, String CPF, String matricula, String senha) {
        this.IDV = IDV;
        this.nome = nome;
        this.CPF = CPF;
        this.matricula = matricula;
        this.senha = senha;
    }

    public int getIDV() {
        return IDV;
    }

    public void setIDV(int IDV) {
        this.IDV = IDV;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "IDV=" + IDV + ", nome=" + nome + ", CPF=" + CPF + ", matricula=" + matricula + ", senha=" + senha + '}';
    }
    
}
