
public class Projetos 
{
    public String Titulo,Data_inicio,Data_termino,A_financiadora,Objetivo,Descricao,Status;
    public double Valor; 
    public Colaboradores[] Participantes = new Colaboradores[1000];

    public Projetos(String titulo,String data_inicio,String data_termino,String a_financiadora,
    double valor,String objetivo,String descricao)
    {
        this.Titulo = titulo;
        this.Data_inicio = data_inicio;
        this.Data_termino = data_termino;
        this.A_financiadora = a_financiadora;
        this.Valor = valor;
        this.Objetivo = objetivo;
        this.Descricao = descricao;
        this.Status = "";
    }
    public void Alocar(Colaboradores nome)
    {
        /*somente permitido se estiver em "elaboração";
        verificar se a pessoa a ser alocada é graduando;
        verificar se já está no grupo casos seja pois não é permitido está alocando  
        */
        if (this.Status == "Elaboração")
        {
            
        }
    }
    public void AlterarStatus()
    {
        
    }
    public void mostrar(){
        System.out.printf("%s\n%s\n%s\n%s\n%.2f", this.Titulo,this.Data_inicio,this.Data_termino,this.A_financiadora,this.Valor);
    }
}
