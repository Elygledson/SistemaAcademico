import java.util.ArrayList;

public class Projetos 
{
    public String Titulo,DataInicio,DataTermino,A_financiadora,Objetivo,Descricao,Status;
    public double Valor; 
    public int q_professor; /*Quantidade de professores associados*/
    public ArrayList<Colaboradores> participantes; 

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
    
    }
    public void Verificar(String nome)
    {
        
    }
    public void AlterarStatus()
    {
      
    }
    public void mostrar(){
        System.out.printf("%s\n%s\n%s\n%s\n%.2f", this.Titulo,this.DataInicio,this.DataTermino,this.A_financiadora,this.Valor);
    }
}
