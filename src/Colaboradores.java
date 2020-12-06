import java.util.Scanner;

import java.util.ArrayList;

public class Colaboradores {
    public String nome,tipo,email,grau;

    private Integer SecretCode;
    /*projetos que está participando ou participou*/
    public ArrayList<Projetos> projetos; 
    /*publicações feitas*/
    public ArrayList<ProducaoAcademica> producao;

    public static Scanner input = new Scanner(System.in);

    public Colaboradores(String nome,String tipo,String email,String grau,Integer SecretCode){
        this.nome = nome;
        this.tipo = tipo;
        this.grau = grau;
        this.email = email;
        this.SecretCode = SecretCode;
        this.projetos= new ArrayList<Projetos>();
        this.producao = new ArrayList<ProducaoAcademica>();
    }

    public String getNome()
    {
        return this.nome;
    }   
    
    private Integer getSecretCode()
    {
        return this.SecretCode;
    }
    
    public String getEmail()
    {
        return this.email;
    }

    public static boolean VerificarEmail(String email,ArrayList<Colaboradores> colaboradores)
    {
        for (int i = 0;i < colaboradores.size();i++) {
            if(email.equals(colaboradores.get(i).email)){
                return true;
            }
        }
        return false;
    }

    public static Colaboradores AdicionarColaborador(ArrayList<Colaboradores> colaboradores)
    {
        System.out.println("\nDigite o nome do colaborador:");

        var nome = input.nextLine();

        System.out.println("Digite o seu email:");

        var email = input.nextLine(); 

        System.out.println("Digite um código secreto:\nAviso: deve conter apenas números inteiros");

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
    input.close();
    return null;
    }


    public void AddProjeto(ArrayList<Projetos> ProjCadastrados,Colaboradores colaborador)
    {
        if(ProjCadastrados.size() == 0){
            System.out.println("\nNenhum projeto cadastrado!\n");
            return;
        }
        Projetos.ListarProjetos(ProjCadastrados);
        var getInput = Integer.parseInt(input.nextLine());
        System.out.printf("Projeto selecionado [%d]\n",getInput);

        while(getInput > ProjCadastrados.size() || getInput <= 0){
                System.out.println("Opção inválida!Tente novamente.");
                getInput = Integer.parseInt(input.nextLine());
            }

        if(Projetos.Verificacao(colaborador,ProjCadastrados.get(getInput - 1).Titulo)){
            System.out.println("Erro: você já está participando desse projeto!\n");
            return;
        }

        if(colaborador.grau.equals("GRADUAÇÂO"))
        {
            if(colaborador.projetos.size() < 2 && ProjCadastrados.get(getInput - 1).Status.equals("EM ELABORAÇÃO"))
            {
                this.projetos.add(ProjCadastrados.get(getInput - 1));
                ProjCadastrados.get(getInput - 1).participantes.add(colaborador);
                System.out.println("Colaborador(a) associado ao projeto!");
                return;
            }
            else{
              System.out.println("De acordo com as regras do sistema: alunos de graduação não pode está em mais de dois projetos.");
              return;
            }
        }
        else{
            this.projetos.add(ProjCadastrados.get(getInput - 1));
            ProjCadastrados.get(getInput - 1).participantes.add(colaborador);
            System.out.println("Colaborador(a) associado ao projeto!");
        }
    }


    public static void BuscarColaborador(ArrayList<Projetos> ProjCadastrados,ArrayList<Colaboradores> colaboradores)
    {
        System.out.println("\nDigite o email do colaborador\n");

        var n = input.nextLine();

        System.out.println("\nDigite o seu código secreto\n");

        var SecretCode = Integer.parseInt(input.nextLine());

        if(colaboradores.isEmpty()){
            System.out.println("Ainda não há colaboradores cadastrados!");
            return;
        }

        for(int i = 0;i < colaboradores.size();i++)
        {
            Integer code = colaboradores.get(i).getSecretCode();
            String email = colaboradores.get(i).getEmail();
            if(SecretCode == code && n.equals(email)) 
            {
                colaboradores.get(i).AddProjeto(ProjCadastrados,colaboradores.get(i));
                return;
            }
        }
        System.out.printf("O email ''%s'' não está cadastrado no sistema.\n",n);
    }

    public static void ListarColaboradores(ArrayList<Colaboradores> colaboradores)
    {

        if(colaboradores.isEmpty()){
            System.out.println("Ainda não há colaboradores cadastrados!");
            return;
        }

        for(int i = 0;i < colaboradores.size();i++)
        {

            System.out.println("\nDados do colaborador:\n");
            System.out.printf("[NOME]  ->%s \n[TIPO]  ->[%s|%s]\n",colaboradores.get(i).nome,colaboradores.get(i).tipo,colaboradores.get(i).grau);
           
            if(colaboradores.get(i).projetos.isEmpty()){ 
                System.out.printf("AVISO: No momento  ''%s'' não está participando de nenhum projeto.\n",colaboradores.get(i).nome); continue;
            }

            System.out.println("Participando dos projetos:");
            for(int j = 0; j < colaboradores.get(i).projetos.size(); j++){
                
                System.out.printf("[%d] [TITULO] -> %s \n  [DATA INÍCIO] -> %s [DATA TERMINO] -> %s \n  [FINANCIADOR] -> %s \n  [VALOR] ->R$ %.2f\n",j + 1,
                colaboradores.get(i).projetos.get(j).Titulo,colaboradores.get(i).projetos.get(j).DataInicio,colaboradores.get(i).projetos.get(j).DataTermino,
                colaboradores.get(i).projetos.get(j).A_financiadora,colaboradores.get(i).projetos.get(j).Valor);
            }

        }
    }
}
