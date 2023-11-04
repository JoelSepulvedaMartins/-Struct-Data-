public class NodeTabela {
    private int data;
    private LinkedList lista;
    private boolean Rehashed;
    public int Insert(int data) {
        if (this.data == -1) {
            this.data = data;
            return 0;
        }

        if (this.lista == null) {
            this.lista = new LinkedList();
        }

        this.lista.insertNode(data);

        return -1;
    }


    public boolean isRehashed() {
        return Rehashed;
    }

    public void setRehashed(boolean rehashed) {
        Rehashed = rehashed;
    }

    public int Remove(int data) {
        if (this.data == data) {
            int auxData = this.data;
            Node headLista = this.lista.getHead();
            this.data = headLista.getData();
            this.lista.removeHead();
            return auxData;
        }

        int removedData = this.lista.remove(data);

        return removedData;
    }

    public int getData() {
        return this.data;
    }

    public NodeTabela() {
        this.data = -1;
        this.lista = null;
    }

    public LinkedList getLista() {
        return this.lista;
    }

    public String dataTableConsole() {
        StringBuilder retorno = new StringBuilder("/");
        retorno.append(this.data).append("/");

        if (this.lista != null) {
            retorno.append(this.lista.dataTableConsole());
        }

        return retorno.toString();
    }
}
