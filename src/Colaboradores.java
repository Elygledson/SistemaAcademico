import java.util.Scanner;
import java.util.ArrayList;

public class Colaboradores {
    public String nome,tipo,email;
    /*projetos que está participando ou participou*/
    public ArrayList<Projetos> projetos; 
    /*publicações feitas*/
    public ArrayList<ProducaoAcademica> producao;
    public static Scanner write = new Scanner(System.in);
    static void AdicionarColaborador()
    {
        System.out.println("\nDigite o nome do colaborador:");
        var nome = write.nextLine();
        System.out.println("Digite o seu email:");
        var email = write.nextLine(); 
        System.out.println("Digite o tipo de colaborador:");
        var get = write.nextLine();
        var tipo = get.toUpperCase();
        System.out.printf("%s\n",tipo);  
        write.close();      
    }
    public void Mostrar()
    {
        System.out.println(this.nome + this.tipo + this.email);
    }
    public void AdicionarProjetos(String NomedoProjeto)
    {
        
    }
}
