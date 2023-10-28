public class NodeTabela {
    private int data;
    private LinkedList lista;




    //Insert Elementos Linked Colisao
    public int Insert(int data){

        if (-1 == this.data){
            this.data = data;
            return 0;
        }

        if(null == this.lista){
            this.lista = new LinkedList();
        }

        this.lista.insertNode(data);


        return -1;
    }


    //Remove Elementos Linked Colisao
    public int Remove(int data) {

        if(this.data == data){

            int auxData = this.data;
            Node headLista = this.lista.getHead();
            this.data = headLista.getData();
            this.lista.removeHead();
            return auxData;

        }

        this.lista.remove(data);
        int auxData = 0;


        return auxData;
    }


    //Metodos Da Classe geter's Seter's

    public int getData(){

        return this.data;

    }




    public NodeTabela(){

        this.data = -1;
        this.lista = null;

    }





    public LinkedList getLista(){
        return this.lista;
    }




    //Printar Table

    public String dataTableConsole() {

        String retorno = "";
        retorno += this.data + ", ";
        if (null != this.lista) retorno += this.lista.dataTableConsole();


        return retorno;
    }
}