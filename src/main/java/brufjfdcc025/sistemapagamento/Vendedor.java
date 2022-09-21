package brufjfdcc025.sistemapagamento;
public class Vendedor extends Funcionario{

    Gerente associado;
    
    public Vendedor(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void Comissao(float valor){
        //valor da comissão é de x0,01 das vendas
        float comissao = 0.01f;
        this.salario = salario+(valor * comissao);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
}
