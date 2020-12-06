import java.util.Scanner;

import java.util.ArrayList;

public class Colaboradores {
    public String nome,tipo,email,grau;
    /*projetos que está participando ou participou*/
    public ArrayList<Projetos> projetos; 
    /*publicações feitas*/
    public ArrayList<ProducaoAcademica> producao;

    public static Scanner input = new Scanner(System.in);

    public Colaboradores(String nome,String tipo,String email,String grau){
        this.nome = nome;
        this.tipo = tipo;
        this.grau = grau;
        this.email = email;
        this.projetos= new ArrayList<Projetos>();
        this.producao = new ArrayList<ProducaoAcademica>();
    }

    public String getNome()
    {
        return this.nome;
    }
    
    public String getEmail()
    {
        return this.email;
    }

    public static boolean Verificar(String email,ArrayList<Colaboradores> colaboradores)
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

        var flag = true; 

        while(flag){
            if(!Colaboradores.Verificar(email,colaboradores)){
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
                Professor professor = new Professor(nome,"PROFESSOR","CAMPO NÂO ESPECIFICADO",email);
                flag = false;
                return professor;
            case 2:
                Pesquisador pesquisador = new Pesquisador(nome,"PESQUISADOR","CAMPO NÂO ESPECIFICADO",email);
                flag = false;
                return pesquisador;
            case 3:
                var grau = Aluno.SetTipo();
                Aluno aluno = new Aluno(nome,"ALUNO",grau,email);
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
        Projetos.ListarProjetos(ProjCadastrados);
        System.out.println("\nSelecione o projeto:");
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
            if(colaborador.projetos.size() < 2)
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
            System.out.println("Colaborador(a) associado ao projeto!");
        }
    }


    public static void BuscarColaborador(ArrayList<Projetos> ProjCadastrados,ArrayList<Colaboradores> colaboradores)
    {
        System.out.println("\nDigite o nome do colaborador");

        var n = input.nextLine();

        if(colaboradores.isEmpty()){
            System.out.println("Ainda não há colaboradores cadastrados!");
            return;
        }

        for(int i = 0;i < colaboradores.size();i++)
        {
            String nome = colaboradores.get(i).getNome();
            if(n.equals(nome)) 
            {
                colaboradores.get(i).AddProjeto(ProjCadastrados,colaboradores.get(i));
                return;
            }
        }
        System.out.printf(" '%s' não está cadastrado no sistema.\n",n);
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
            System.out.printf("[NOME]  ->%s \n[EMAIL] ->%s \n[TIPO]  ->[%s|%s]\n",colaboradores.get(i).nome,colaboradores.get(i).email,colaboradores.get(i).tipo,colaboradores.get(i).grau);
           
            if(colaboradores.get(i).projetos.isEmpty()){ 
                System.out.printf("AVISO: No momento  '%s' não está participando de nenhum projeto.\n",colaboradores.get(i).nome); continue;
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
