import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static Biblioteca biblio = new Biblioteca();
    static Scanner input = new Scanner(System.in);

    private static int inputNumerico(String mensagem){
        int valor = 0;
        boolean entradaValida = false;
        do {
            System.out.println(mensagem);
            String valorStr = input.nextLine();
            try {
                valor = Integer.parseInt(valorStr); 
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("ERRO. Insira um número inteiro");
            }
        }while(!entradaValida);
        return valor;
    }

    private static void adicionar() {
        Livro novoLivro = new Livro();
        System.out.println("====== ADICIONANDO NOVO LIVRO ======");
        System.out.print("Informe o titulo do livro: ");
        String titulo = input.nextLine();
        novoLivro.setTitulo(titulo);

        System.out.print("Informe o nome do autor: ");
        novoLivro.setAutor(input.nextLine());

        System.out.print("Informe o ano de publicação: ");
        novoLivro.setAnoPublicacao(input.nextInt());
        input.nextLine();

        System.out.print("Informe o numero de paginas: ");
        novoLivro.setnPaginas(input.nextInt());
        input.nextLine();

        try {
            biblio.adicionar(novoLivro);
            System.out.println("Livro Adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        input.nextLine();

    }

    private static void listar() {
        // List<Livros> livro = biblio.pesquisarTodos();
        var livros = biblio.pesquisarTodos();
        livros.sort(Comparator.comparing(Livro::getTitulo));
        System.out.println("====== LISTA DE LIVROS ======");
        for (Livro livro : livros) {
            System.out.println("Titulo: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Ano :" + livro.getAnoPublicacao());
            System.out.println("N. Páginas: " + livro.getnPaginas());
        }
    }

    private static void pesquisar() {
        System.out.println("====== PESQUISAR LIVROS ======");
        System.out.print("Insira o titulo do livro: ");
        String titulo = input.nextLine();
        var livros = biblio.pesquisarPorTitulo(titulo);
        for (Livro livro : livros) {
            System.out.println("-----------------");
            System.out.println("Titulo: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Ano :" + livro.getAnoPublicacao());
            System.out.println("N. Páginas: " + livro.getnPaginas());
        }
    }
    public static void main(String[] args) {
        String menu = """

                    SISTEMA DE GERENCIAMENTO DE BIBLIOTECA

                Escolha uma das opções:

                1 - Adicionar novo livro
                2 - Listar todos os livros
                3 - Pesquisar livros
                4 - Remover livro
                0 - Sair
                    """;
        int opcao;
        do {
            //System.out.println(menu);
            //opcao = input.nextInt();
            //input.nextLine();
            opcao = inputNumerico(menu);
            switch (opcao) {
                case 0:
                    System.out.println("Volte sempre!");
                    break;
                case 1:
                    adicionar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    pesquisar();
                    break;
                case 4:
                    // Remover
                    break;
                default:
                    System.out.println("Opção Invalida");
                    input.nextLine();
                    break;
            }

        } while (opcao != 0);
    }

}