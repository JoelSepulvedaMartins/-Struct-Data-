

public class HashTable {
    private NodeTabela[] tabela;
    private int colisoes;
    private int tamanho;

    //
    //Hash Functions para primordiais a implementaçao da table
    //

    public HashTable(int tamanho){
        this.tamanho = tamanho;
        this.tabela = new NodeTabela[tamanho];

        for(int i = 0;i<tamanho;i++){

            this.tabela[i] = new NodeTabela();  /*Tratamento de colisoes*/

        }

        this.colisoes = 0;
    }


    private int hash(int key){
        int hash = key % this.tamanho;

        if (hash < 0) {
            hash += this.tamanho; // Parte que ira controlar  numeros  negativos
        }


        return hash;
    }

    //
    //Tratamento das colisoes
    //
    public int getColisoes(){


        return this.colisoes;
    }

    public int getTamanho(){
        return this.tamanho;
    }


    private void modificarTamanho() {
        int newTam = this.tamanho * 2;     //Dobra o tamanho tabela
        NodeTabela[] tabelaNova = new NodeTabela[newTam];

        for (int i = 0; i < this.tamanho; i++) {

            if (this.tabela[i].getData() != -1) {

                int data = this.tabela[i].getData();
                int newPosition = data % newTam;


                if (tabelaNova[newPosition] == null) {
                    tabelaNova[newPosition] = new NodeTabela();
                }


                tabelaNova[newPosition].Insert(data);
            }
        }
        this.tabela = tabelaNova;
        this.tamanho = newTam;


    }

    //
    //Inserts e Removes de elementos
    //

    public void addElement(int data){
        int posicao = hash(data);


        if (0 != this.tabela[posicao].Insert(data)){
            this.colisoes++;

        }

        // Verificar o fator de carga e redimensionar, para tentar lindar com as colisoes, ele aumenta o tamanho da tabela

        if ((float)(this.colisoes + 1) / this.tamanho > 0.75) {

            modificarTamanho();

        }


    }
    public int removeElemento(int data){

        int posicao = hash(data);
        data = this.tabela[posicao].Remove(data);

        return data;

    }


    //Verifica KEY
    public boolean keyInTable(int key){
        int k = hash(key);

        return (-1 == this.tabela[k].getData());
    }




    //Metodo Para Mostar  Tabela no console
    public void showTable(){

        for(int i = 0; i < tamanho; i++){

            System.out.println(this.tabela[i].dataTableConsole());

        }

    }


}