import java.util.Scanner;


public class Aluno extends Colaboradores{

    public static Scanner input = new Scanner(System.in);
    public String grau;

    public Aluno(String nome,String tipo,String grau,String email)
    {
        super(nome, tipo, email, grau);
    }
    public String GetTipo()
    {
        return this.tipo;
    }

    public static String SetTipo() 
    {
        System.out.println("\nSelecione o tipo:");
        System.out.println("[1] - Graduação");
        System.out.println("[2] - Mestrado");
        System.out.println("[3] - Doutorado");
        var getInput  = Integer.parseInt(input.nextLine());
        var flag = true;
        while(flag){
            switch(getInput){
             case 1:
             flag = false;
             System.out.printf("Opção [%d]\n",getInput);
             return "GRADUAÇÂO";

            case 2:
             flag = false;
             System.out.printf("Opção [%d]\n",getInput);
             return "MESTRADO";
            
            case 3:
             flag = false;
             System.out.printf("Opção [%d]\n",getInput);
             return "DOUTORADO";

            default:
             System.out.println("Opção inválida!Tente novamente.");
             getInput  = Integer.parseInt(input.nextLine());
             break;
         }
        }
        return null;
    }
}
