package bean;

public class Cliente {
    
    private int IDC;
    private String nome;
    private String CPF;
    private String matricula;
    private String senha;
    

    public Cliente() {
    }

    public Cliente(int IDC, String nome, String CPF, String matricula, String senha) {
        this.IDC = IDC;
        this.nome = nome;
        this.CPF = CPF;
        this.matricula = matricula;
        this.senha = senha;
    }

    public int getIDC() {
        return IDC;
    }

    public void setIDC(int IDC) {
        this.IDC = IDC;
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
        return "Cliente{" + "IDC=" + IDC + ", nome=" + nome + ", CPF=" + CPF + ", matricula=" + matricula + ", senha=" + senha + '}';
    }

   
}
