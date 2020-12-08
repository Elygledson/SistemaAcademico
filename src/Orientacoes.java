

public class Orientacoes extends ProducaoAcademica{

    @Override
    public void AdicionarAutores()
    {
        System.out.println("\nDigite o nome do professor");

        var autor = input.nextLine();
        System.out.println("Digite o(s) nome(s) do(s) aluno(s) a ser orientados");
        this.Autores.add(autor);

    }
}

