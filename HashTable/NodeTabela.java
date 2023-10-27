public class NodeTabela {
    private int data;
    private LinkedList lista;

    public NodeTabela(){
        this.data = -1;
        this.lista = null;
    }

    public int getData(){
        return this.data;
    }

    public LinkedList getLista(){
        return this.lista;
    }

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

    public String displayData() {
        String retorno = "";
        retorno += this.data + ", ";
        if (null != this.lista) retorno += this.lista.displayData();
        return retorno;
    }
}