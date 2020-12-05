import java.util.Scanner;

public class Aluno extends Colaboradores{

    public Aluno(String nome,String tipo,String email)
    {
        super(nome, tipo, email);
    }
    public String GetTipo()
    {
        return this.tipo;
    }

    public void SelecioneTipo(Scanner input)
    {
        System.out.println("Selecione o tipo:");
        System.out.println("[1] - Graduação");
        System.out.println("[2] - Mestrado");
        System.out.println("[3] - Doutorado");
        var getInput  = Integer.parseInt(input.nextLine());
        System.out.printf("Opção [%d]",getInput);
    }
}
