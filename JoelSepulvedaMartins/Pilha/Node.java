/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilhaEncadeada;

/**
 *
 * @author JoelS
 */

public class Node{
    private Integer informacao;
    private Node proximo;
    public Node(){
        informacao = null;
        proximo = null;
    }
    public void setInfo(Integer info){
        informacao = info;
    }
    public void setProximo(Node proximo){
        this.proximo = proximo;
    }
    public Integer getInfo(){
        return informacao;
    }
    public Node getProximo(){
        return proximo;
    } 
}

