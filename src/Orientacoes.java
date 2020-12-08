import java.util.Scanner;

public class Orientacoes extends ProducaoAcademica {

    static Scanner input = new Scanner(System.in);

    public boolean setGeral(Colaboradores colaborador,String NomeProjeto)
    {
        if(!Sistema.AnaliseGeral(colaborador,NomeProjeto))
        {
            return false;
        }
        this.Projetos.add(NomeProjeto);
        System.out.println("Digite o ano dessa produção: Ex: yyyy");
        var ano = Integer.parseInt(input.nextLine());
        this.Ano = ano; 
        System.out.println("Escreva o nome do aluno a ser orientado:");
        var aluno = input.nextLine();
        this.Alunos.add(aluno);
        System.out.println("Escreva a orientaçao:");
        var orientacao = input.nextLine();
        this.orientacao.add(orientacao);
        while(true)
        {
            System.out.println("Deseja escrever uma orientação a outro aluno(a)? \n[1] - SIM\n[2] - NÃO");
            var opcao = Integer.parseInt(input.nextLine());
            if(opcao == 2)break;
            System.out.println("Escreva o nome do aluno a ser orientado:");
            aluno = input.nextLine();
            this.Alunos.add(aluno);
            System.out.println("Escreva a orientaçao:");
            orientacao = input.nextLine();
            this.orientacao.add(orientacao);
        }
        return true;
    }
    }

