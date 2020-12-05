import java.util.Scanner;
import java.util.ArrayList;

public class Colaboradores {
    public String nome,tipo,email;
    /*projetos que está participando ou participou*/
    public ArrayList<Projetos> projetos; 
    /*publicações feitas*/
    public ArrayList<ProducaoAcademica> producao;
    public static Scanner input = new Scanner(System.in);

    public Colaboradores(String nome,String tipo,String email){
        this.nome = nome;
        this.tipo = tipo;
        this.email = email;
        this.projetos= new ArrayList<Projetos>();
        this.producao = new ArrayList<ProducaoAcademica>();
    }

    public static Colaboradores AdicionarColaborador()
    {
        System.out.println("\nDigite o nome do colaborador:");
        var nome = input.nextLine();
        System.out.println("Digite o seu email:");
        var email = input.nextLine(); 
        System.out.println("Digite o tipo de colaborador:\n");
        System.out.println("1 - Professor");
        System.out.println("2 - Pesquisador");
        System.out.println("3 - Aluno\n");
        var getInput = input.nextInt();
        System.out.printf("Opção [%d]\n",getInput);   
        switch(getInput){
            case 1:
                Aluno aluno = new Aluno(nome,"ALUNO",email);
                aluno.SelecioneTipo(input);
                return aluno;
            case 2:
                Professor professor = new Professor(nome,"PROFESSOR",email);
                return professor;
            case 3:
                Pesquisador pesquisador = new Pesquisador(nome,"PESQUISADOR",email);
                return pesquisador;
        }
    }


    public void AddProjeto(ArrayList<Projetos> ProjCadastrados)
    {
        Projetos.ListarProjetos(ProjCadastrados);
        System.out.println("Selecione o projeto:");
        var get = Integer.parseInt(input.nextLine());
        System.out.printf("Projeto selecionado [%d]\n",get);
        this.projetos.add(ProjCadastrados.get(get - 1));
    }

    public String getNome()
    {
        return this.nome;
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
                colaboradores.get(i).AddProjeto(ProjCadastrados);
                return;
            }
        }
        System.out.printf("O colaborador '%s' não está cadastrado no sistema.\n",n);
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
            System.out.printf("[NOME]  ->%s \n[EMAIL] ->%s \n",colaboradores.get(i).nome,colaboradores.get(i).email);
            if(colaboradores.get(i).projetos.isEmpty()){ 
                System.out.printf("AVISO: No momento  '%s' não está participando de nenhum projeto.\n",colaboradores.get(i).nome); continue;
            }
            System.out.println("Participando dos projetos:");
            for(int j = 0; j < colaboradores.get(i).projetos.size(); j++){
                
                System.out.printf("[%d] [TITULO] -> %s [DATA INÍCIO] -> %s [DATA TERMINO] -> %s [FINANCIADOR] -> %s [VALOR] -> %.2f\n",j + 1,
                colaboradores.get(i).projetos.get(j).Titulo,colaboradores.get(i).projetos.get(j).DataInicio,colaboradores.get(i).projetos.get(j).DataTermino,
                colaboradores.get(i).projetos.get(j).A_financiadora,colaboradores.get(i).projetos.get(j).Valor);
            }
        }
    }
}
