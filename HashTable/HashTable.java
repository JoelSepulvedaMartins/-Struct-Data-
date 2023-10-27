

public class HashTable {
    private int tamanho;
    private NodeTabela[] tabela;
    private int colisoes;

    private int hash(int key){
        return key % this.tamanho;
    }

    public HashTable(int tamanho){
        this.tamanho = tamanho;
        this.tabela = new NodeTabela[tamanho];
        for(int i = 0;i<tamanho;i++){
            this.tabela[i] = new NodeTabela();/*Tratamento de colisoes*/
        }
        this.colisoes = 0;
    }

    public int getColisoes(){
        return this.colisoes;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public void addElement(int data){
        int posicao = hash(data);
        if (0 != this.tabela[posicao].Insert(data)){
            this.colisoes++;
        }
    }

    public int removeElemento(int data){
        int posicao = hash(data);
        data = this.tabela[posicao].Remove(data);
        return data;
    }

    public void showTable(){
        for(int i = 0; i < tamanho; i++){
            System.out.println(this.tabela[i].displayData());
        }
    }

    public boolean keyInTable(int key){
        int k = hash(key);
        return (-1 == this.tabela[k].getData());
    }

}