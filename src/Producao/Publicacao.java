package Producao;

import java.util.Scanner;

import Colaboradores.Colaboradores;
import main.Sistema;

public class Publicacao extends ProducaoAcademica{


    static Scanner input = new Scanner(System.in);

    public boolean setGeral(Colaboradores colaborador,String NomeProjeto)
    {
        if(!Sistema.AnaliseGeral(colaborador,NomeProjeto))
        {
            return false;
        }
        this.Projetos.add(NomeProjeto);
        System.out.println("Escreva a publicação:");
        var publicacao = input.nextLine();
        this.publicacao.add(publicacao);
        return true;
    }

    public void setAutores()
    {
        System.out.println("Digite o nome do(a) autor(a):");

        var autor = input.nextLine();

        this.Autores.add(autor);
        System.out.println("\nVoce gostaria de adicionar outro autor?\nSelecione a opção:\n[1] - SIM\n[2] - NÃO");
        var response = Integer.parseInt(input.nextLine());
        while(response > 2 || response <= 0)
        {
            System.out.println("Comando inválido!Tente novamente");
            response = Integer.parseInt(input.nextLine());
        }
         if(response == 1){
            setAutores();
         }
    }
}
