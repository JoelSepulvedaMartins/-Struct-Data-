// Este código é feito para fins de testes e estudos referentes às colisões de acordo com o algoritmo hash. Dito isso, ele se torna um pouco volumoso pelo fato de ter que verificar o algoritmo hash a ser usado a cada inserção.
// No entanto, a verificação do algoritmo hash afetará muito pouco o tempo de criação da HashTable.
//by Joel Sepulveda Martins.
public class HashTable {
    private NodeTabela[] tabela;
    private int colisoes;
    private int tamanho;
    private double  FactorHash = 0.6180339887; //Fator padrao, muito usado(Constante Empírica ou número do outro)
    private int tempHash;
    private HashAlgorithm hashAlgorithm;

    private double loadFactorThreshold = 0.7; // Limite fator de carga
    private int maxRehashes = 1; //limite rehashings

    private int numElements = 0; //count elementos na tabela
    private int numRehashes = 0; // count de rehashings adicionais feitos


    //Construtores

    //
    //Hash Functions para primordiais a implementaçao da table
    //

    public HashTable(int tamanho, HashAlgorithm hashAlgorithm){
        this.hashAlgorithm = hashAlgorithm;
        this.tamanho = tamanho;
        this.tabela = new NodeTabela[tamanho];

        for(int i = 0;i<tamanho;i++){

            this.tabela[i] = new NodeTabela();  /*Tratamento de colisoes*/

        }

        this.colisoes = 0;
    }



    public int hash(int data){
        int hashValue = 0;
        switch (hashAlgorithm){
            case Modulo:
                hashValue = hashModTam(data);
                break;
            case Factor:
                hashValue = hashFactor(data,this.FactorHash);

                break;
            case FactorOtimizado:
                hashValue = hashFactorOptimized(data,this.FactorHash);

                break;
            case DigitFolding:
                hashValue = digitHashFolding(data);

                break;
            case DigitFoldingLast3:
                hashValue = hashFoldingLast3(data);
                break;
            case BITSignificant:
                hashValue = significantBitHash(data);

                break;
            default:
                System.out.println("!!Erro Algoritmo Hash!!Nao Definido");

        }
        return hashValue;

    }

    //geter's Seter's

    public double getFactorHash() {
        return FactorHash;
    }

    public void setFactorHash(double factorHash) {
        FactorHash = factorHash;
    }

    //Adaptando codigo Rodar com dierentes algoritmos hash na main
    public enum HashAlgorithm{
        Modulo,Factor,FactorOtimizado,DigitFolding,DigitFoldingLast3,BITSignificant

    }

    //////HASH FUNCTION
    ////Hash por Modulo do tamanho
    private int hashModTam(int key){
        int hash = key % this.tamanho;

        if (hash < 0) {
            hash += this.tamanho; // Parte que ira controlar  numeros  negativos
        }


        return hash;
    }
    ////Hash Por Multiplicaçao do fator
    private int hashFactor(int key, double Factor){
        this.FactorHash = Factor;

        double hashValue = key * FactorHash; // Multiplica a key pelo fator escolhido
        int intPart = (int) hashValue; //Faz um cast para pegar a parte inteira da multiplicaçao, removendo os flutuantes

        hashValue -= intPart; //Retira a parte interia do valor original, deixando so a fracionaria

        hashValue *= this.tamanho; //Multiplica a parte inteira pelo tamanho da tabela

        if(hashValue < 0){ //Trata resultados negativos convertendo para positivo
            hashValue = -hashValue;

        }
        tempHash = (int) hashValue;

        return  tempHash % this.tamanho;//limita ao tamanho da tabela

    }

    ///HashFactor multiplicaçao otimizado
    private int hashFactorOptimized(int key, double Factor){
        this.FactorHash = Factor;

        double hashValue = key * Factor * this.tamanho;

        if (hashValue < 0) {

            hashValue = -hashValue;

        }

        return (int) (hashValue % this.tamanho);



    }


    ////Hash Percorrendo digito por digito (dobramento)

    private int digitHashFolding(int key){
        //Dobramento
        int hashValue = 0;
        int keyCopy = key; //Chave usada no loop para o dobramento
       // System.out.println("keyCopyInicial: " + keyCopy);
        while (keyCopy > 0) {
            int digit = keyCopy % 10; //Pegar o ultimo digito
            //System.out.println("digite: " + digit);
            hashValue += digit; //Somando os digitos
           // System.out.println("hashValue: " + hashValue);
            keyCopy /= 10; //Removendo o ultimo numero, como é divisaod e dois ints, ele ignorara o numero flutuante, eliminando  o automaticamente
           // System.out.println("keyCopy: " + keyCopy);
        }

        return hashValue % this.tamanho; //Garante que o resultado esteja entre o intervalo do tamanho da tabela
    }


    ////Hash removendo os 3 ultimos digitos(Dobramento)

    private int hashFoldingLast3(int key){
        int hashValue = 0;

        while (key > 0) {
            int digit = key % 1000; // Pega os últimos três dígitos
            hashValue += digit;
            key /= 1000; // Remove os três últimos dígitos
        }

        return hashValue % this.tamanho;
    }



    ////hash usando bits significativos, a principio é para melhorar as colisoes levando em conta o insert de numeros aleatorios
    private int significantBitHash(int key) {
        int hashValue = 0;

        int mask = 0x7FFFFFFF;  //Remove o bit mais significativo que seria o sinal

        while (key > 0) {

            int digitGroup = key & mask; //aplica o and entre key e mask

            hashValue ^= digitGroup; //aplica o ou exclusivo hashValue e digitGroup

            key >>= 7;//essa parte desloca sete bits pra direita removendo os bits que ja foram processados acima
        }


        // Converte para positivo
        if (hashValue < 0) {
            hashValue = -hashValue;
        }

        return hashValue % this.tamanho;  //Garante que o resultado esteja entre o intervalo do tamanho da tabela
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




    //
    //Inserts e Removes de elementos
    //

    public void addElement(int data){
        int posicao = hash(data);
        if (0 != this.tabela[posicao].Insert(data)){
            this.colisoes++;
        }

        if (numRehashes < maxRehashes && (double) (numElements + 1) / tamanho > loadFactorThreshold) {
            // rehashing adicional quando o fator de carga passar do limite devfinido
            posicao = significantBitHash(data);//usa outro hash como rehashing, da pra usar o mesmo padrao tambem
            this.tabela[posicao].setRehashed(true);
            this.numRehashes++;
            addElement(data); //insere o elemento depois do  rehashing
        }
        this.numRehashes = 0;


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