import java.util.ArrayList;
import java.util.Scanner;

public class Projetos 
{
    public String Titulo,DataInicio,DataTermino,A_financiadora,Objetivo,Descricao,Status;
    public double Valor; 
    public int q_professor; /*Quantidade de professores associados*/
    public ArrayList<Colaboradores> participantes; 
    public ArrayList<ProducaoAcademica> producao; /*publicações ou orientações associadas ao projeto*/
    static Scanner input = new Scanner(System.in);

    public Projetos(String titulo,String DataInicio,String DataTermino,
    String a_financiadora,double valor,String objetivo,String descricao,String status)
    {
        this.Titulo = titulo;
        this.DataInicio = DataInicio;
        this.DataTermino = DataTermino;
        this.A_financiadora = a_financiadora;
        this.Valor = valor;
        this.Objetivo = objetivo;
        this.Descricao = descricao;
        this.Status = status;
        this.participantes = new ArrayList<Colaboradores>();
        this.producao = new ArrayList<ProducaoAcademica>();
    }
    public String getStatus()
    {
        return this.Status;
    }

    public int getNumeroPartcipantes()
    {
        return this.participantes.size();
    }

    public int getPublicacoes()
    {
        return this.producao.size();
    }

    public static boolean Verificacao(Colaboradores colaborador,String Titulo)
    {
        for(int i = 0;i < colaborador.projetos.size();i++)
        {
            if(colaborador.projetos.get(i).Titulo.equals(Titulo))
            {
                return true;
            }
        }
        return false;
    }

    public static  void setStatus(ArrayList<Projetos> ProjetosCadastrados)
    {
       int i,q_professor,q_aluno;
       Projetos.ListarProjetos(ProjetosCadastrados);
       var getResponse = input.nextInt(); 
       System.out.printf("Opção selecionada [%d]\n",getResponse);
       System.out.println("\nAlterar status para:");
       System.out.println("[1] - Em andamento");
       System.out.println("[2] - Concluído\n");
       var opcao = input.nextInt();
       /*Entrar na fase de desenvolvimento*/
      if(opcao == 1){
      for(i = 0,q_professor = 0,q_aluno = 0;i < ProjetosCadastrados.get(getResponse - 1).participantes.size();i++)
      {
            if(ProjetosCadastrados.get(getResponse - 1).participantes.get(i).tipo.equals("PROFESSOR")) q_professor++;
            else if(ProjetosCadastrados.get(getResponse - 1).participantes.get(i).tipo.equals("ALUNO"))q_aluno++;
      }

      if(q_professor >= 1 && q_aluno >= 1){
          ProjetosCadastrados.get(getResponse - 1).Status = "EM ANDAMENTO";
          System.out.println("Status alterado para ''EM ANDAMENTO''.");
      }
      else{
        System.out.println("Erro: não foi possível alterar status para ''EM ANDAMENTO''.");
      }
      return;
     }
     /*Entrar na fase final*/
     else{
        if(!ProjetosCadastrados.get(getResponse - 1).producao.isEmpty())
        {
            ProjetosCadastrados.get(getResponse - 1).Status = "CONCLUÍDO";
            System.out.println("Status alterado para ''CONCLUÍDO''.");
        }
        else{
            System.out.println("Erro: não foi possível alterar status para ''CONCLUÍDO''.");
        }
     }
      return;
    }
    

    public static void ListarProjetos(ArrayList<Projetos> projetos)
    {
        System.out.println("Selecione um projeto abaixo:\n");
        for(int i = 0;i < projetos.size();i++)
        {
            System.out.println("Informações do projeto:");
            System.out.printf("[OPÇÃO]\n[%d] - [STATUS] -> ''%s'' [TÍTULO] -> %s [DATA INÍCIO] -> %s [DATA TERMINO] -> %s [FINANCIADORA] -> %s [VALOR] -> R$ %.2f \n",
            i + 1,projetos.get(i).Status,projetos.get(i).Titulo,projetos.get(i).DataInicio,
            projetos.get(i).DataTermino,projetos.get(i).A_financiadora,projetos.get(i).Valor);
            System.out.printf("[%d] - [DESCRIÇÃO]\n      %s\n[%d] - [OBJETIVO]  \n      %s \n",i + 1,projetos.get(i).Descricao,i+1,projetos.get(i).Objetivo);
        }
    }

    public static Projetos CadastrarProjeto()
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
