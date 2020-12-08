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

    

    static void ListarProjetos(ArrayList<Projetos> projetos)
    {
        if(projetos.isEmpty())
        {
            System.out.println("Nenhum projeto cadastrado.");
            return;
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

    static int PainelGerencia(ArrayList<Colaboradores> colaboradores,ArrayList<Projetos> projetos)
    {
        System.out.println("\nEntrar com credencias:");
        var getResponse = BuscarColaborador(colaboradores);
        if(getResponse == -1) return -1;
        if(colaboradores.get(getResponse).tipo == "PROFESSOR"){
            return BuscarProjeto(projetos);
        }else{
            System.out.println("*Permissão: somente professores pode fazem esse tipo de operação");
            System.out.println("Erro: Acesso negado!");
            return -1;
        }
    }

    static ProducaoAcademica CadastrarProducao(String NomedoColaborador)
    {
        System.out.printf("Olá %s,preencha as informações abaixo:\n",NomedoColaborador);
        System.out.println("Digite o tipo de produção acadêmica:");
        var tipo = input.nextLine();
        System.out.println("Digite um título para sua publicação:");
        var titulo = input.nextLine();
        
        if(tipo.equalsIgnoreCase("PUBLICACAO"))
        {
            System.out.println("Digite o nome da conferência:");
            var conferencia = input.nextLine();
            System.out.println("Digite o ano de publicação:");
            var ano = Integer.parseInt(input.nextLine());
            System.out.println("Digite onde foi publicado:");
            var local = input.nextLine();
            Publicacao novaPublicacao = new Publicacao();
            novaPublicacao.setTitulo(titulo);
            novaPublicacao.setAno(ano);
            novaPublicacao.setNome(conferencia);
            novaPublicacao.setTipo(tipo);
            novaPublicacao.setLocal(local);
            return novaPublicacao;
        }
        else
        {
            Orientacoes novaOrientacao = new Orientacoes();
            novaOrientacao.setTitulo(titulo);
            novaOrientacao.setTipo(tipo);
            return novaOrientacao;
        }

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
        System.out.println("Digite a data de início: [dd/MM/yyyy]");
        var DataInicio =  input.nextLine();
        System.out.println("Digite a data de previsão de termino: [dd/MM/yyyy]");
        var DataTermino = input.nextLine();
        System.out.println("Digite o agente financiador:");
        var A_financiadora = input.nextLine();
        System.out.println("Digite o valor:");
        var Valor = Double.parseDouble(input.nextLine());
        System.out.println("Digite a descrição do projeto:");
        var Descricao = input.nextLine();
        System.out.println("Digite o objetivo do projeto:");
        var Objetivo = input.nextLine();
        Projetos Instance = new Projetos(Titulo,DataInicio,DataTermino,A_financiadora,Valor,Objetivo,Descricao,"EM ELABORAÇÃO");
        return  Instance;
    }
}
