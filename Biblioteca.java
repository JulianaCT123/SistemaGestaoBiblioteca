import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    // BD em memória
    private List<Livro> acervo = new ArrayList<>();

    // void é pra quando não vai ter retorno
    public void adicionar(Livro livro) throws Exception{
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
            throw new Exception("Não é permitido cadastrar livro sem titulo");
        }
        else if(livro.getAutor() == null || livro.getAutor().isEmpty()) {
            throw new Exception("Não e possível cadastar um livro sem autor!");
        }
        else if(livro.getAnoPublicacao() < 1400 || livro.getAnoPublicacao() > LocalDate.now().getYear()){
            throw new Exception("Coloque um ano de publição valido! (Maior que 1400 e menor que o ano atual)");
        }
        else if(livro.getnPaginas() <= 0){
            throw new Exception("Coloque um número de páginas válido! (O número não pode ser negativo ou 0)");
        }
        for (Livro livroAcervo : acervo) {
            if (livroAcervo.getTitulo().equalsIgnoreCase(livro.getTitulo())) {
                throw new Exception("Já existe livro cadastrado com este título");
            }
        }
        acervo.add(livro);
    }

    public List<Livro> pesquisarPorTitulo(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())){
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }
    
    public void removerPorTitulo(String titulo) throws Exception {
        boolean i = false;
        for (Livro livro : acervo) {
            if(livro.getTitulo().equalsIgnoreCase(titulo)){
                acervo.remove(livro);
                i = true;
                break;
            }
        }
        if (!i){
            throw new Exception("Livro não encontrado!");
        }
    }

    public List<Livro> pesquisarTodos() {
        return this.acervo;
        
    }
}