package brufjfdcc025.sistemapagamento;

import java.util.ArrayList;
import java.util.Scanner;

/*
    Gabriel Evaristo Carlos
    201965034AB
 */
public class Sistema {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        String buffer,nome;
        float salario;
        String[][] associados = new String[100][100];
        
        for(int i = 0; i<100;i++)
            for(int j = 0; j<100; j++)
                associados[i][j] = "0";
        
        int opc = 1;
        System.out.println("Bem vindo!!!!");
        while(opc != 6){
            System.out.println("O que gostaria de fazer?");
            System.out.println("1. cadastrar Vendedor;\n" +
                                "2. cadastrar Gerente;\n" +
                                "3. associar um Vendedor a um Gerente;\n" +
                                "4. registrar as vendas realizadas por um Vendedor;\n" +
                                "5. calcular o valor que será pago a cada Funcionário no final do dia;\n" +
                                "6. sair.");
            System.out.println("Sua opcao: ");
            opc = teclado.nextInt();
            switch(opc){
                case 1:
                    buffer = teclado.nextLine();
                    System.out.println("Qual o nome do funcionário: ");
                    nome = teclado.nextLine();
                    Vendedor vendedor = new Vendedor(nome);
                    funcionarios.add(vendedor);
                    System.out.println("Qual o salário a ser recebido: ");
                    salario = teclado.nextFloat();
                    vendedor.salario = salario;
                    break;
                case 2:
                    buffer = teclado.nextLine();
                    System.out.println("Qual o nome: ");
                    nome = teclado.nextLine();
                    Gerente gerente = new Gerente(nome);
                    funcionarios.add(gerente);
                    for(int i = 0; i<funcionarios.size();i++)
                        if(associados[i][0].equals("0")){
                            associados[i][0] = nome;
                            break;
                        }
                    System.out.println("Qual o salário a ser recebido: ");
                    salario = teclado.nextFloat();
                    gerente.salario = salario;        
                    break;
                case 3:
                    buffer = teclado.nextLine();
                    System.out.println("Nome do gerente a qual associar: ");
                    nome = teclado.nextLine();
                    boolean achou = false, associado = false;
                    for(int i = 0; i < funcionarios.size(); i++){
                        if(associados[i][0].equals(nome)){
                            System.out.println("Nome do funcionario associado: ");
                            nome = teclado.nextLine();
                            for(Funcionario f : funcionarios){
                                for(int k = 0; k < funcionarios.size(); k++){
                                    if(f.nome.equals(associados[k][0]))
                                        break;
                                    if(f.nome.equals(nome)){
                                        associado = true;
                                        break;
                                    }
                                }
                            }
                            if(associado == true){
                                for(int j = 1; j <funcionarios.size(); j++)
                                    if(associados[i][j].equals("0")){
                                        associados[i][j] = nome;
                                        break;
                                    }
                            }
                            else
                            {
                                System.out.println("Nome invalido!!");
                            }
                            achou = true;
                            break;
                        }
                    }

                    if(achou == false){
                        System.out.println("Nome inválido!");
                    }
                    break;
                case 4: 
                    boolean realizarvenda = true,ac = false;
                    float valorvenda;
                    buffer = teclado.nextLine();
                    System.out.println("Qual o nome do funcionário que realizou a venda?");
                    nome = teclado.nextLine();
                    
                    for(Funcionario f : funcionarios){
                        if(f.nome.equals(nome))
                            ac = true;
                    }
                    
                    if(ac == false){
                        System.out.println("Nome inválido!!");
                        break;
                    }
                    
                    while(realizarvenda){
                        System.out.println("Qual o valor da venda?");
                        valorvenda = teclado.nextFloat();
                        Venda venda = new Venda(valorvenda);
                        for(Funcionario f : funcionarios){
                            if(f.nome.equals(nome)){
                                f.Comissao(venda.valor);
                                for(int i = 0; i<funcionarios.size();i++)
                                    for(int j = 0; j<funcionarios.size(); j++)
                                        if(associados[i][j].equals(nome)){
                                            for(Funcionario h : funcionarios)
                                                if(h.nome.equals(associados[i][0]))
                                                    h.Comissao(venda.valor);
                                        }
                            }
                        }
                        
                        System.out.println("Deseja registrar outra venda? ");
                        System.out.println("1- Sim\n2- Não");
                        int x = teclado.nextInt();
                        if(x == 1)
                            realizarvenda = true;
                        else
                            realizarvenda = false;
                    }
                    break;
                case 5: 
                    System.out.println("Salarios ao final do dia: ");
                    for(Funcionario f : funcionarios){
                        System.out.println(f.nome + " receberá R$"+ f.salario);
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opção Inválida!!!!");
                    break;
            }
        }
    }
}
