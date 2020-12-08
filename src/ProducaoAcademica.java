import java.util.ArrayList;
import java.util.Scanner;

public class ProducaoAcademica {

    public String Titulo,NomeConferencia,Local,Tipo;

    public int Ano;

    public ArrayList<String> Autores = new ArrayList<String>();
    /*projetos associados as publlicações*/


    static Scanner input = new Scanner(System.in);


    public String getTitulo()
    {
        return this.Titulo;
    }
    public String getTipo()
    {
        return this.Tipo;
    }

    public String getLocal()
    {
        return this.Local;
    }

    public String getNome()
    {
        return this.NomeConferencia;
    }

    public int getAno()
    {
        return this.Ano;
    }

    public void setTitulo(String get)
    {
        this.Titulo = get;
    }

    public void setTipo(String get)
    {
        this.Tipo = get;
    }

    public void setNome(String get)
    {
        this.NomeConferencia = get;
    }

    public void setLocal(String get)
    {
        this.Local = get;
    }

    public void setAno(Integer ano)
    {
        this.Ano = ano;
    }

    public void AdicionarAutores()
    {
        System.out.println("\nDigite os nome dos autores");

        var autor = input.nextLine();

        this.Autores.add(autor);
        System.out.println("\nVoce gostaria de adicionar outro autor?\nSelecione a opção:\n[1] - SIM\n[2] - NÃO");
        var response = Integer.parseInt(input.nextLine());
        while(response > 2 || response <= 0)
        {
            System.out.println("Comando inválido!Tente novamente");
            response = Integer.parseInt(input.nextLine());
        }
         if(response == 1){
            AdicionarAutores();
         }
    }
}
