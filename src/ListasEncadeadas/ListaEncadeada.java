package ListasEncadeadas;

public class ListaEncadeada<T> {
    No<T> referenciaEntrada; 

    public ListaEncadeada(){
        this.referenciaEntrada = null; 
    }

    // método Get (retorna o conteudo do no)
    public T get(int index){
        return getNo(index).getConteudo();
    }

    // metodo toString()
    @Override 
    public String toString(){
        String strRetorno = ""; 
        No<T> noAuxiliar = referenciaEntrada;
        for(int i = 0; i < this.size(); i++){
            strRetorno += "No: " + noAuxiliar.getConteudo() + "  ";
            noAuxiliar = noAuxiliar.getProximoNo(); 
        }
        strRetorno += "null";
        return strRetorno;
    }

    // metodo GetNo
    private No<T> getNo(int index){
        validaIndice(index); 
        No<T> noAuxiliar = referenciaEntrada; 
        No<T> noRetorno = null; 
        for(int i = 0; i <= index; i++){
            noRetorno = noAuxiliar; 
            noAuxiliar = noAuxiliar.getProximoNo(); 
        } 
        return noRetorno;
    }

    // metodo remove
    public T remove(int index){
        No<T> noPivor = this.getNo(index); 
        if(index == 0){
            // removendo o primeiro nó 
            referenciaEntrada = noPivor.getProximoNo(); 
            return noPivor.getConteudo();
        }
        No<T> noAnterior = getNo(index - 1);
        noAnterior.setProximoNo(noPivor.getProximoNo());
        return noPivor.getConteudo();
    }

    public void validaIndice(int index){
        if(index >= size()){
            int ultimoIndice = size() - 1;
            throw new IndexOutOfBoundsException("Não existe conteudo no indice: " + index + " somente até o indice " + ultimoIndice); 
        }
    }

    public int size(){
        int tamanhoLista = 0; 

        No<T> referenciaAux = referenciaEntrada; 

        while(true){
            if(referenciaAux != null){
                tamanhoLista++; 
                if(referenciaAux.getProximoNo() != null){
                    referenciaAux = referenciaAux.getProximoNo(); 
                } else{
                    break; 
                }
            }else {
                break;
            }
        }
        return tamanhoLista; 
    }

    // metodo isEmpty 
    public boolean isEmpty(){
        return referenciaEntrada == null ? true : false; 
    }

    // metodo Add
    public void add(T conteudo){
        No<T> novoNo = new No<>(); 
        if(this.isEmpty()){
            referenciaEntrada = novoNo; 
            return; 
        }
        No<T> noAuxiliar = referenciaEntrada; 
        for(int i = 0; i < this.size(); i++){
            noAuxiliar = noAuxiliar.getProximoNo();
        } 
        noAuxiliar.setProximoNo(novoNo);
    }
}
