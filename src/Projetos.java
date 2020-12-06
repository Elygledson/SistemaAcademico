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
    String a_financiadora,double valor,String objetivo,String descricao)
    {
        this.Titulo = titulo;
        this.DataInicio = DataInicio;
        this.DataTermino = DataTermino;
        this.A_financiadora = a_financiadora;
        this.Valor = valor;
        this.Objetivo = objetivo;
        this.Descricao = descricao;
        this.participantes = new ArrayList<Colaboradores>();
    }

    public void Alocar(Colaboradores pessoa)
    {
        /*somente permitido se estiver em "elaboração";
        verificar se a pessoa a ser alocada é graduando;
        verificar se já está no grupo caso esteja pois não é permitido está alocando em mais de dois grupos
        */
        /*true para em fase de elaboração*/
        var tipo = pessoa.tipo.toUpperCase();
       System.out.println(tipo);
    
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

    public void AlterarStatus()
    {
      
    }

    public static void ListarProjetos(ArrayList<Projetos> projetos)
    {
        System.out.println("Selecione um projeto abaixo:\n");
        for(int i = 0;i < projetos.size();i++)
        {
            System.out.println("Informações do projeto:");
            System.out.printf("[OPÇÃO]\n[%d] - [TÍTULO] -> %s [DATA INÍCIO] -> %s [DATA TERMINO] -> %s [FINANCIADORA] -> %s [VALOR] -> R$ %.2f \n",i + 1,projetos.get(i).Titulo,projetos.get(i).DataInicio,
            projetos.get(i).DataTermino,projetos.get(i).A_financiadora,projetos.get(i).Valor);
            System.out.printf("[%d] - [DESCRIÇÃO]\n      %s\n[%d] - [OBJETIVO]  \n      %s \n",i+1,projetos.get(i).Descricao,i+1,projetos.get(i).Objetivo);
        }
    }
    static Projetos CadastrarProjeto()
    {
        System.out.println("\nDigite o título:");
        var Titulo = input.nextLine();
        System.out.println("Digite a data de início:");
        var DataInicio =  input.nextLine();
        System.out.println("Digite a data de termino:");
        var DataTermino = input.nextLine();
        System.out.println("Digite o agente financiador:");
        var A_financiadora = input.nextLine();
        System.out.println("Digite o valor:");
        var Valor = Double.parseDouble(input.nextLine());
        System.out.println("Digite o objetivo:");
        var Objetivo = input.nextLine();
        System.out.println("Digite a descrição:");
        var Descricao = input.nextLine();
        Projetos Instance = new Projetos(Titulo,DataInicio,DataTermino,A_financiadora,Valor,Objetivo,Descricao);
        return  Instance;
    }
}
