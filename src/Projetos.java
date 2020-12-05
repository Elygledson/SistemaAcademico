import java.util.ArrayList;

public class Projetos 
{
    public String Titulo,DataInicio,DataTermino,A_financiadora,Objetivo,Descricao,Status;
    public double Valor; 
    public int q_professor; /*Quantidade de professores associados*/
    public ArrayList<Colaboradores> participantes; 
    public ArrayList<ProducaoAcademica> producao; /*publicações ou orientações associadas ao projeto*/

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
    public void Verificar(String nome)
    {
        
    }
    public void AlterarStatus()
    {
      
    }
    static void ListarProjetos(ArrayList<Projetos> projetos)
    {
        System.out.println("Selecione um projeto abaixo:\n");
        for(int i = 1;i <= projetos.size();i++)
        {
            System.out.println("Informações do projeto:");
            System.out.printf("[%d] - %s | %s | %s | %s | %.2f |\n",i,projetos.get(i).Titulo,projetos.get(i).DataInicio,
            projetos.get(i).DataTermino,projetos.get(i).A_financiadora,projetos.get(i).Valor,projetos.get(i).Objetivo,projetos.get(i).Descricao);
        }
    }
}
