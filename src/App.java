import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("\nNome do Projeto");
        Scanner ler = new Scanner(System.in);
        var titulo = ler.nextLine();
        System.out.println("Data de início:");
        var data_inicio = ler.nextLine(); 
        System.out.println("Data de termino:");
        var data_termino = ler.nextLine(); 
        System.out.println("Agente financiadora:");
        var financiadora = ler.nextLine(); 
        System.out.println("Valor:");
        var valor = ler.nextDouble(); 
        ler.nextLine(); 
        System.out.println("Objetivo:");
        var Objetivo = ler.nextLine(); 
        System.out.println("Descrição:");
        var Descrição = ler.nextLine(); 

        Projetos primeiro = new Projetos(titulo,data_inicio,data_termino,
        financiadora,valor,Objetivo,Descrição);
        primeiro.mostrar();
        System.out.println("\nDigite o nome do coloborador:");
        var nome = ler.nextLine();
        System.out.println("Digite o tipo de formação:");
        var tipo = ler.nextLine(); 
        Colaboradores pessoa = new Colaboradores(nome, tipo);
        pessoa.AdicionarProjetos("Circuito");
        pessoa.MostraParticipante();

    }
}
