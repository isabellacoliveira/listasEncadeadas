import ListasEncadeadas.ListaEncadeada;

public class Main {
    public static void main(String[] args) throws Exception {
        
        ListaEncadeada<String> minhaListaEncadeada = new ListaEncadeada<>(); 
        minhaListaEncadeada.add("teste 1");
        minhaListaEncadeada.add("teste 2");
        minhaListaEncadeada.add("teste 3");
        minhaListaEncadeada.add("teste 4");
        minhaListaEncadeada.add("teste 5");
        minhaListaEncadeada.add("teste 6");
        minhaListaEncadeada.add("teste 7");

        System.out.println(minhaListaEncadeada); 
    }
}
