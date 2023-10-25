

public class arvoreBinariaAVL {

    public Node raiz = null;
    public int del;
    public long tamanhoEstrutura = 0;
    public Node nodeTemp;

    public Node AuxRemove;

    public void printArvore(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getDado());
            printArvore(node.getEsquerda(), prefix + (isLeft ? "│   " : "    "), true);
            printArvore(node.getDireita(), prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    public void imprimirArvore() {
        printArvore(raiz, "", true);
    }



    public void inserir(int elemento) {
        this.raiz = inserirRecursivamente(raiz, elemento);

    }
    //Inserir elementos na arvore por recursao

    public Node inserirRecursivamente(Node nodeTemp, int element) {

        if (nodeTemp == null) {

            return new Node(element);
        }

        if (element < nodeTemp.getDado()) {
            nodeTemp.setEsquerda(inserirRecursivamente(nodeTemp.getEsquerda(), element));
            nodeTemp.setBalanceamento(balanceamento(nodeTemp));

        }
        else if (element >= nodeTemp.getDado()) {
            nodeTemp.setDireita(inserirRecursivamente(nodeTemp.getDireita(), element));
            nodeTemp.setBalanceamento(balanceamento(nodeTemp));
        }

        nodeTemp.setBalanceamento(balanceamento(nodeTemp));

        return balancearAvl(nodeTemp);
    }

    public int balanceamento(Node node) {
        if (node != null) {
            return alturaArvore(node.getEsquerda()) - alturaArvore(node.getDireita());
        }
        return 0;
    }

    public Node balancearAvl(Node r) {
        if (r == null) {
            return null;
        } else {
            r.setEsquerda(balancearAvl(r.getEsquerda()));
            r.setDireita(balancearAvl(r.getDireita()));

            // Calculando o fator de balanceamento
            int balanceamento = balanceamento(r);

            // Tendendencia  esquerda
            if (balanceamento > 1) {
                Node esquerda = r.getEsquerda();
                int balanceamentoEsquerda = balanceamento(esquerda);

                // Rotação Simples à Direita (RR)
                if (balanceamentoEsquerda >= 0) {
                    return rotacaoDireita(r);
                } // Rotação Dupla à Esquerda-Direita (LR)
                else {
                    r.setEsquerda(rotacaoEsquerda(esquerda));
                    return rotacaoDireita(r);
                }
            }    // Tendencia  direita
            else if (balanceamento < -1) {
                Node direita = r.getDireita();
                int balanceamentoDireita = balanceamento(direita);

                // Rotação Simples à Esquerda (LL)
                if (balanceamentoDireita <= 0) {
                    return rotacaoEsquerda(r);
                } // Rotação Dupla à Direita-Esquerda (RL)
                else {
                    r.setDireita(rotacaoDireita(direita));
                    return rotacaoEsquerda(r);
                }
            }
        }

        return r;
    }




    //Algortimos de Print da arvore
    //algoritmos de busca e print das arvores
    public void printRecursivoInOrdem(Node printTemp) {
        if (printTemp == null) {
            return;
        }

        printRecursivoInOrdem(printTemp.getEsquerda());
        System.out.println(printTemp.getDado() + "Balanceamento: " + balanceamento(printTemp));

        printRecursivoInOrdem(printTemp.getDireita());
    }

    public void printRecursivoInOrdemReverso(Node printTemp) {
        if (printTemp == null) {
            return;
        }

        printRecursivoInOrdemReverso(printTemp.getDireita());
        System.out.println(printTemp.getDado());
        printRecursivoInOrdemReverso(printTemp.getEsquerda());
    }

    public void printRecursivoPosOrder(Node printTemp) {
        if (printTemp == null) {
            return;
        }

        printRecursivoPosOrder(printTemp.getEsquerda());
        printRecursivoPosOrder(printTemp.getDireita());
        System.out.println(printTemp.getDado());

    }

    public Node removerMaiorArvore(Node nodeTemp) {
        if (nodeTemp == null) {

            return null;
        }

        if (nodeTemp.getDireita() == null) {
            //achei uma forma de simplificar o if, fora do escopo da funçao recursiva
/*            if (nodeTemp==raiz){
                raiz = nodeTemp.getEsquerda();

            }*/
            AuxRemove = nodeTemp;
            nodeTemp = null;
            return AuxRemove.getEsquerda();
        }

        nodeTemp.setDireita(removerMaiorArvore(nodeTemp.getDireita()));

        return nodeTemp;
    }

    //Remover o menor numero, utiliza a mesma logica do remover maior so que envertendo pra onde vc vi percorrer e quem substituir
    public Node removerMenorArvore(Node nodeTemp) {
        if (nodeTemp == null) {

            return null;
        }

        if (nodeTemp.getEsquerda() == null) {
            /*//Achei uma forma de simplificar o cod, em vez de verificar em toda chama eu verifico isso fora da funçao, para otimizar o cod
            if (nodeTemp==raiz){
                raiz = nodeTemp.getDireita();

            }*/
            AuxRemove = nodeTemp;
            nodeTemp = null;
            return AuxRemove.getDireita();
        }

        nodeTemp.setEsquerda(removerMenorArvore(nodeTemp.getEsquerda()));

        return nodeTemp;
    }

    //Metodos de calcular altura e balancear por insercao
    //Aparentemente esse cod nao retorna a autura certa dos nos filho da raiz
    public int alturaArvore(Node nodeTemp) {
        if (nodeTemp == null) {
            return -1;//foram demasiadas horas para entender o real motivo por tras do -1, e realmente é uma sacada de mestre, porem me custou mt
        }

        int esquerda = alturaArvore(nodeTemp.getEsquerda());
        int direita = alturaArvore(nodeTemp.getDireita());
        if (esquerda > direita) {
            return esquerda + 1;
        } else {
            return direita + 1;
        }

    }

    public Node rotacaoDireita(Node raiz) {
        Node novaRaiz = raiz.getEsquerda();
        raiz.setEsquerda(novaRaiz.getDireita());
        novaRaiz.setDireita(raiz);

        return novaRaiz;
    }



    public Node rotacaoEsquerda(Node raiz) {
        Node novaRaiz = raiz.getDireita();
        raiz.setDireita(novaRaiz.getEsquerda());
        novaRaiz.setEsquerda(raiz);

        return novaRaiz;
    }

 //Deletar



    public Node removerElemento(int elemento) {
        raiz = removerElementoRecursivamente(raiz, elemento);
        return raiz;
    }

    private Node removerElementoRecursivamente(Node raiz, int elemento) {
        if (raiz == null) {
            System.out.println("Elemento não encontrado na árvore.");
            return raiz;
        }

        if (elemento < raiz.getDado()) {
            raiz.setEsquerda(removerElementoRecursivamente(raiz.getEsquerda(), elemento));
        } else if (elemento > raiz.getDado()) {
            raiz.setDireita(removerElementoRecursivamente(raiz.getDireita(), elemento));
        } else {

            if (raiz.getEsquerda() == null) {
                return raiz.getDireita();
            } else if (raiz.getDireita() == null) {
                return raiz.getEsquerda();
            }


            raiz.setDado(minimoValor(raiz.getDireita()));


            raiz.setDireita(removerElementoRecursivamente(raiz.getDireita(), raiz.getDado()));
        }


        raiz.setBalanceamento(balanceamento(raiz));
        return balancearAvl(raiz);
    }

    private int minimoValor(Node node) {
        int valorMinimo = node.getDado();
        while (node.getEsquerda() != null) {
            valorMinimo = node.getEsquerda().getDado();
            node = node.getEsquerda();
        }
        return valorMinimo;
    }











    // Buscar Elemento
    public Node buscarElementoMeio(Node raiz, int element){
        if (raiz == null) {
            System.out.println("Elemento não pertence à base de dados.");
            return null;
        }
        if (element == raiz.getDado()){
            System.out.println("Elemento: "+raiz.getDado() +" Encontrado.");
            return raiz;}
        else if(element > raiz.getDado()){

            System.out.println(" buscando:\n ");
            return buscarElementoMeio(raiz.getDireita(), element);

        }
        else {//element < raiz.getDado()
            System.out.println(" buscando:\n ");
            return buscarElementoMeio(raiz.getEsquerda(), element);}

    }

}
