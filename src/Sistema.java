import java.util.Scanner;
import java.util.ArrayList;

/*Classe Sistema: Criação e armazenamento de dados temporariamente*/

public class Sistema {
    
    static Scanner input = new Scanner(System.in);

    static int BuscarColaborador(ArrayList<Colaboradores> colaboradores)
    {
        System.out.println("\nDigite o email do colaborador");

        var n = input.nextLine();

        System.out.println("Digite o seu código secreto");


        var SecretCode = Integer.parseInt(input.nextLine());

        if(colaboradores.isEmpty()){
            System.out.println("Ainda não há colaboradores cadastrados!");
            return -1;
        }

        for(int i = 0;i < colaboradores.size();i++)
        {
            Integer code = colaboradores.get(i).getSecretCode();
            String email = colaboradores.get(i).getEmail();
            if(SecretCode == code && n.equals(email)) 
            {
                return i;
            }
        }
        System.out.printf("O email ''%s'' não está cadastrado no sistema ou o código secreto digitado está errado.\n",n);
        return -1;
    }

    static int BuscarProjeto(ArrayList<Projetos> projetos)
    {
        if(projetos.isEmpty())
        {
            System.out.println("Nenhum projeto cadastrado.");
            return -1;
        }

        System.out.println("Selecione um projeto abaixo:\n");
        for(int i = 0;i < projetos.size();i++)
        {
            System.out.println("\nInformações do projeto:\n");
            System.out.printf("[OPÇÃO]\n[%d] - [STATUS] -> ''%s'' [TÍTULO] -> %s [DATA INÍCIO] -> %s [DATA TERMINO] -> %s [FINANCIADORA] -> %s [VALOR] -> R$ %.2f \n",
            i + 1,projetos.get(i).Status,projetos.get(i).Titulo,projetos.get(i).DataInicio,
            projetos.get(i).DataTermino,projetos.get(i).A_financiadora,projetos.get(i).Valor);
            System.out.printf("[%d] - [DESCRIÇÃO]\n      %s\n[%d] - [OBJETIVO]  \n      %s \n",i + 1,projetos.get(i).Descricao,i + 1,projetos.get(i).Objetivo);
        }
        
        var getResponse = Integer.parseInt(input.nextLine());
        while(getResponse > projetos.size() || getResponse <= 0)
        {
            System.out.println("Opção inválida!Tente novamente.");
            getResponse = Integer.parseInt(input.nextLine());
        }
        System.out.printf("Opção selecionada [%d]\n",getResponse);
        return getResponse;   
    }

    public static Colaboradores AdicionarColaborador(ArrayList<Colaboradores> colaboradores)
    {

        System.out.println("\nDigite o nome do colaborador:");

        var nome = input.nextLine();

        System.out.println("Digite o seu email:");

        var email = input.nextLine(); 

        System.out.println("Digite um código secreto:\nAVISO: deve conter apenas números inteiros");
        
        var SecretCode = Integer.parseInt(input.nextLine()); 

        var flag = true; 

        while(flag){
            if(!Colaboradores.VerificarEmail(email,colaboradores)){
                flag = false;
            }
            else{
                System.out.println("Esse email já existe no sistema!Por favor,digite outro email.");
                email = input.nextLine(); 
            }
        }

        System.out.println("\nDigite o tipo de colaborador:\n");
        System.out.println("[1] - Professor");
        System.out.println("[2] - Pesquisador");
        System.out.println("[3] - Aluno\n");

        var getInput = Integer.parseInt(input.nextLine());

        System.out.printf("Opção [%d]\n",getInput); 

        flag = true; 

        while(flag){
        switch(getInput){
            case 1:
                Professor professor = new Professor(nome,"PROFESSOR",email,"CAMPO NÂO ESPECIFICADO",SecretCode);
                flag = false;
                return professor;
            case 2:
                Pesquisador pesquisador = new Pesquisador(nome,"PESQUISADOR",email,"CAMPO NÂO ESPECIFICADO",SecretCode);
                flag = false;
                return pesquisador;
            case 3:
                var grau = Aluno.SetTipo();
                Aluno aluno = new Aluno(nome,"ALUNO",email,grau,SecretCode);
                flag = false;
                return aluno;
            default:
                System.out.println("Opção inválida!Tente novamente.");
                getInput = Integer.parseInt(input.nextLine());
                break;
        }
    }
    return null;
    }

    static Projetos CadastrarProjeto()
    {
        System.out.println("\nDigite o título:");
        var Titulo = input.nextLine();
        System.out.println("Digite a data de início: [dia/mês/ano]");
        var DataInicio =  input.nextLine();
        System.out.println("Digite a data de previsão de termino: [dia/mês/ano]");
        var DataTermino = input.nextLine();
        System.out.println("Digite o agente financiador:");
        var A_financiadora = input.nextLine();
        System.out.println("Digite o valor:");
        var Valor = Double.parseDouble(input.nextLine());
        System.out.println("Digite a descrição:");
        var Descricao = input.nextLine();
        System.out.println("Digite o objetivo:");
        var Objetivo = input.nextLine();
        Projetos Instance = new Projetos(Titulo,DataInicio,DataTermino,A_financiadora,Valor,Objetivo,Descricao,"EM ELABORAÇÃO");
        return  Instance;
    }
}
