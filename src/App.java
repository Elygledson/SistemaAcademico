import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        int comando = 0;
        Scanner input = new Scanner(System.in);
        ArrayList<Colaboradores> pessoa = new ArrayList<Colaboradores>();
        ArrayList<Projetos> projetos = new ArrayList<Projetos>();

        while(comando != 4){
        System.out.println("\nSelecione uma opção:");
        System.out.println("1 - Cadastrar projeto.");
        System.out.println("2 - Cadastrar participante.");
        System.out.println("3 - Mostra lista de colaboradores");
        System.out.println("4 - Alocar participante a projeto.");
        System.out.println("5 - Sair.");

        comando = input.nextInt();
        switch (comando){
            case 1:
                break;
            case 2:
                Colaboradores.AdicionarColaborador();
                System.out.println("Colaborador adicionado!");
                break;
            case 3:
               Projetos.ListarProjetos(projetos);
               break;
            case 4:
               break;
        
    }
}
    input.close();
}
}
