package main;

import java.util.ArrayList;
import java.util.Scanner;

import Colaboradores.Aluno;
import Colaboradores.Colaboradores;
import Colaboradores.Pesquisador;
import Colaboradores.Professor;
import Producao.Orientacoes;
import Producao.ProducaoAcademica;
import Producao.Publicacao;

public class Sistema{
    
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

        for(int i = 0;i < projetos.size();i++)
        {
            System.out.println("\nInformações do projeto:\n");
            System.out.printf("[OPÇÃO]\n[%d] - [STATUS] -> ''%s'' [TÍTULO] -> %s [DATA INÍCIO] -> %s [DATA TERMINO] -> %s [FINANCIADORA] -> %s [VALOR] -> R$ %.2f \n",
            i + 1,projetos.get(i).getStatus(), projetos.get(i).getTitulo(), projetos.get(i).getDataInicio(),
            projetos.get(i).getDataTermino(), projetos.get(i).A_financiadora, projetos.get(i).getValor());
            System.out.printf("[%d] - [DESCRIÇÃO]\n      %s\n[%d] - [OBJETIVO]  \n      %s \n",i + 1,projetos.get(i).getDescricao(),i + 1, projetos.get(i).getObjetivo());
        }
    }

    public static int BuscarProjeto(ArrayList<Projetos> projetos)
    {
        if(projetos.isEmpty())
        {
            System.out.println("Nenhum projeto cadastrado.");
            return -1;
        }

        for(int i = 0;i < projetos.size();i++)
        {
            System.out.println("\nInformações do projeto:\n");
            System.out.printf("[OPÇÃO]\n[%d] - [STATUS] -> ''%s'' [TÍTULO] -> %s [DATA DE INÍCIO] -> %s [DATA DE TERMINO] -> %s\n",
            i + 1,projetos.get(i).getStatus(), projetos.get(i).getTitulo(), projetos.get(i).getDataInicio(),
            projetos.get(i).getDataTermino());
        }
        System.out.println("\nSelecione um projeto acima:\n");
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
        if(colaboradores.get(getResponse).getTipo() == "PROFESSOR"){

           var request = BuscarProjeto(projetos);

            String titulo = projetos.get(request - 1).getTitulo();

            Colaboradores colaborador  = colaboradores.get(getResponse);

            if(!Projetos.Verificacao(colaborador,titulo)){
                System.out.println("ERRO: você não está participando desse projeto,portanto não há como concluir essa operação.");
                return -1;
            }

            return request;

        }else{
            System.out.println("*PERMISSÃO: somente professores pode fazem esse tipo de operação");
            System.out.println("ERRO: Acesso negado!");
            return -1;
        }
    }

    public static boolean AnaliseGeral(Colaboradores colaborador,String NomeProjeto)
    {
        for(int i = 0; i < colaborador.projetos.size();i++)
        {
           String status = colaborador.projetos.get(i).getStatus();
            if(NomeProjeto.equalsIgnoreCase(colaborador.projetos.get(i).getTitulo()) && status.equals("EM ANDAMENTO")){
                return true;
            }
        }
        System.out.println("ERRO: O(A) colaborador(a) não está participando desse projeto ou o projeto está em fase de elaboração.");
        return false;
    }

    /*Associar producao ao projeto*/
    public static void setProducao(ArrayList<Projetos> projetos,String NomeProjeto,ProducaoAcademica novaInstancia)
    {
        int posicao = 0;
        for(int i = 0;i < projetos.size();i++)
        {
            if(projetos.get(i).getTitulo().equals(NomeProjeto))
            {
                posicao = i;
                break;
            }
        }
            projetos.get(posicao).producao.add(novaInstancia);
    }

    static void FornecerRelatorio(ArrayList<Projetos> projetos,int NumeroColaboradores)
    {   
        int NumeroProjetos,elaboracao,andamento,concluidos,publicacoes,orientacoes;
        NumeroProjetos = elaboracao = andamento = concluidos = publicacoes = orientacoes = 0; 
        String status,tipo;
        for(int i = 0;i < projetos.size();i++)
        {
            status = projetos.get(i).getStatus();
            for(int j = 0;j < projetos.get(i).producao.size();j++)
            {
                tipo = projetos.get(i).producao.get(j).getTipo();
                if(tipo.equals("PUBLICAÇÃO")){
                    publicacoes++;
                }
                else{
                orientacoes++;
                }
            }

            if(status.equals("EM ELABORAÇÃO"))elaboracao++;

            if(status.equals("EM ANDAMENTO"))andamento++;

            if(status.equals("CONCLUIDOS"))concluidos++;

        }
        NumeroProjetos = projetos.size();
        System.out.println("\nInformações gerais:");
        System.out.println("Numero de colaboradores presentes no sistema: " + NumeroColaboradores);
        System.out.println("Total de projetos em elaboração: " + elaboracao);
        System.out.println("Total de projetos em andamento:" + andamento);
        System.out.println("Total de projetos concluídos:" + concluidos);
        System.out.println("Numero total de projetos: " + NumeroProjetos);
        System.out.println("Numero total de publicações: " + publicacoes);
        System.out.println("Numero total de orientações: " + orientacoes);
    }

    static ProducaoAcademica CadastrarProducao(ArrayList<Projetos> projetos,Colaboradores colaborador)
    {
        System.out.printf("Olá %s,preencha as informações abaixo:\n",colaborador.getNome());
        System.out.println("Selecione o tipo de produção acadêmica:\n[1] - Publicação\n[2] - Orientação");
        var tipo = Integer.parseInt(input.nextLine());
        System.out.printf("Opção selecionada [%d]\n",tipo);
        System.out.println("Digite um título para sua publicação:");
        var titulo = input.nextLine();
        
        if(tipo == 1)
        {
            System.out.println("Digite o nome da conferência:");
            var conferencia = input.nextLine();
            System.out.println("Digite o ano de publicação: Ex: yyyy");
            var ano = Integer.parseInt(input.nextLine());
            System.out.println("Digite onde foi publicado:");
            var local = input.nextLine();
            System.out.println("Digite o nome do projeto a ser associado");
            var NomeProjeto = input.nextLine();

            Publicacao novaPublicacao = new Publicacao();

            if(!novaPublicacao.setGeral(colaborador,NomeProjeto))return null;

            novaPublicacao.setAutores();

            novaPublicacao.setTitulo(titulo);

            novaPublicacao.setAno(ano);

            novaPublicacao.setNome(conferencia);

            novaPublicacao.setTipo("PUBLICAÇÃO");

            novaPublicacao.setLocal(local);

            Sistema.setProducao(projetos , NomeProjeto , novaPublicacao);

            return novaPublicacao;
        }
        else if(tipo == 2)
        {
            if(colaborador.getTipo().equals("PROFESSOR")){

                System.out.println("Digite o nome do projeto a ser associado");

                var NomeProjeto = input.nextLine();

                Orientacoes novaOrientacao = new Orientacoes();

                if(!novaOrientacao.setGeral(colaborador, NomeProjeto))return null;

                novaOrientacao.setTitulo(titulo);

                novaOrientacao.setTipo("ORIENTAÇÃO");

                Sistema.setProducao(projetos , NomeProjeto , novaOrientacao);

                return novaOrientacao;
            }
            else{
                System.out.println("Permissão: somente professores podem criar orientações!!");
            }
        }
        return null;
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
        System.out.println("Digite a data de início: dd/MM/yyyy");
        var DataInicio =  input.nextLine();
        System.out.println("Digite a data de previsão de termino: dd/MM/yyyy");
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



    public static void Painel() 
    {
        System.out.println("\nSelecione uma opção:");
        System.out.println("[1] - Cadastrar projeto.");
        System.out.println("[2] - Cadastrar participante.");
        System.out.println("[3] - Cadastrar produção academica");
        System.out.println("[4] - Alocar participante a projeto.");
        System.out.println("[5] - Alterar status de projeto");
        System.out.println("[6] - Consultar projeto");
        System.out.println("[7] - Consultar colaborador");
        System.out.println("[8] - Listar projetos");
        System.out.println("[9] - Relatório Acadêmico.");
        System.out.println("[10]- Sair\n");
	}
}
