public class BST {

    private Node root;

    public boolean isEmpty(){
        return this.root == null;
    }

    public void add( int valor){
        Node newNode = new Node(valor);

        if(isEmpty()){
            this.root = newNode;

        } else {
            Node aux = this.root;

            while(aux != null){

                if(valor < aux.valor){
                    if(aux.left == null){
                        aux.left = newNode;
                        return;
                    }
                    aux = aux.left;
                } else {
                    if(aux.right == null){
                        aux.right = newNode;
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    }

    public void addRecursivo(int valor){

        if(isEmpty()){
            this.root = new Node(valor);
        }
        else {
            addRecursive(this.root, valor);
        }
    }

    private void addRecursive(Node node,int valor){

        if(node == null){
            throw new RuntimeException("Nó vazio");
        }

        if(valor < node.valor){
            if(node.left == null){
                node.left = new Node(valor);
                return;
            }
            addRecursive(node.left,valor);
        } else {
            if(node.right == null){
                node.right = new Node(valor);
                return;
            }
            addRecursive(node.right, valor);
        }
    }

    public int max(){

        if(isEmpty()){
            throw new RuntimeException("BST vazia");
        } else {
            Node aux = this.root;

            while(true){
                if(aux.right == null){
                    return aux.valor;
                }
                aux = aux.right;
            }
        }
    }

    public int min(){
        if(isEmpty()){
            throw new RuntimeException("BST vazia");
        } else {

            Node aux = this.root;

            while(true){
                if(aux.left == null){
                    return aux.valor;
                }
                aux = aux.left;
            }
        }
    }

    public int maxRecursivo(){

        if(isEmpty()){
            throw new RuntimeException("BST vazia");
        } else {
            return maxRecursive(root);
        }
    }

    private int maxRecursive(Node node){

        if(node.right == null){
            return node.valor;
        }
        return maxRecursive(node.right);
    }

    public int minRecursivo(){

        if(isEmpty()){
            throw new RuntimeException("BST vazia");
        } else {
            return minRecursive(root);
        }
    }

    private int minRecursive(Node node){

        if(node.left == null){
            return node.valor;
        }
        return minRecursive(node.left);
    }

    public  int search( int element) {

        if(isEmpty()){
            throw new RuntimeException("BST vazia");
        }
        Node aux = this.root;
        while(true){
            if(aux.valor == element){
                return aux.valor;
            }
            else if(element < aux.valor){
                 if(aux.left == null){
                    return -1;
                 }
                 aux = aux.left;
            }
            else {
                if(aux.right == null){
                    return -1;
                }
                aux = aux.right;
            }
        }
    }


}

class Node {

    Node left;
    Node right;
    int valor;

    public Node (int valor){
        this.valor = valor;
    }
}
