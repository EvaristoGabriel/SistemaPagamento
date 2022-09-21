package brufjfdcc025.sistemapagamento;
public class Gerente extends Funcionario{
    
    public Gerente(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void Comissao(float valor){
        //comissao é x0,005 das vendas dos vendedores
        float comissao = 0.005f;
        this.salario = salario + (valor*comissao);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
}
