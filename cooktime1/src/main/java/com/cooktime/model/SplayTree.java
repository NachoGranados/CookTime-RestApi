package com.cooktime.model;

public class SplayTree {

    private NodeSplayTree root;
    private int count = 0;

    public SplayTree() {

        root = null;

    }

    public boolean isEmpty() {

        return root == null;

    }
    
    public boolean contains(String name) {

        return containsAux(name) != null;

    }
    
    private NodeSplayTree containsAux(String name) {
        
        NodeSplayTree PrevNode = null;
        
        while (this.root != null) {
            
            PrevNode = this.root;
            
            int compareResult = name.compareTo(this.root.getEnterprise().getName());
    
            if (compareResult < 0) {

                this.root = this.root.getLeft();

            } else if (compareResult > 0) {

                this.root = this.root.getRight();          

            } else if (compareResult == 0) {
                
                Splay(this.root);
                
                return this.root;                
                
            }
            
        }
        
        if (PrevNode != null) {
            
            Splay(PrevNode);
            
            return null;
            
        }
        
        return null;
        
    }
        
    public Enterprise getEnterprise(String name) {

        return getEnterpriseAux(name).getEnterprise();

    }
    
    private NodeSplayTree getEnterpriseAux(String name) {
        
        NodeSplayTree PrevNode = null;
        
        while (this.root != null) {
            
            PrevNode = this.root;
            
            int compareResult = name.compareTo(this.root.getEnterprise().getName());
    
            if (compareResult < 0) {

                this.root = this.root.getLeft();

            } else if (compareResult > 0) {

                this.root = this.root.getRight();          

            } else if (compareResult == 0) {
                
                Splay(this.root);
                
                return this.root;                
                
            }
            
        }
        
        if (PrevNode != null) {
            
            Splay(PrevNode);
            
            return null;
            
        }
        
        return null;
        
    }
    
    public void makeLeftChildParent(NodeSplayTree parent, NodeSplayTree grandParent) {

        if ((parent == null) || (grandParent == null) || (grandParent.getLeft() != parent)
                || (parent.getParent() != grandParent)) {

            throw new RuntimeException("WRONG");

        }

        if (grandParent.getParent() != null) {

            if (grandParent == grandParent.getParent().getLeft()) {

                grandParent.getParent().setLeft(parent);

            } else {

                grandParent.getParent().setRight(parent);

            }

        }

        if (parent.getRight() != null) {

            parent.getRight().setParent(grandParent);

        }

        parent.setParent(grandParent.getParent());
        grandParent.setParent(parent);
        grandParent.setLeft(parent.getRight());
        parent.setRight(grandParent);

    }

    public void makeRightChildParent(NodeSplayTree parent, NodeSplayTree grandParent) {

        if ((parent == null) || (grandParent == null) || (grandParent.getRight() != parent)
                || (parent.getParent() != grandParent)) {

            throw new RuntimeException("WRONG");

        }

        if (grandParent.getParent() != null) {

            if (grandParent == grandParent.getParent().getLeft()) {

                grandParent.getParent().setLeft(parent);

            } else {

                grandParent.getParent().setRight(parent);

            }

        }

        if (parent.getLeft() != null) {

            parent.getLeft().setParent(grandParent);

        }

        parent.setParent(grandParent.getParent());
        grandParent.setParent(parent);
        grandParent.setRight(parent.getLeft());
        parent.setLeft(grandParent);

    }

    private void Splay(NodeSplayTree node) {

        while (node.getParent() != null) {

            if (node.getParent().getParent() == null) {

                if (node == node.getParent().getLeft()) {

                    makeLeftChildParent(node, node.getParent());

                } else {

                    makeRightChildParent(node, node.getParent());

                }

            } else {

                if (node == node.getParent().getLeft()) {

                    if (node.getParent() == node.getParent().getParent().getLeft()) {

                        makeLeftChildParent(node.getParent(), node.getParent().getParent());
                        makeLeftChildParent(node, node.getParent());

                    } else {

                        makeLeftChildParent(node, node.getParent());
                        makeRightChildParent(node, node.getParent());
                    }

                } else {

                    if (node.getParent() == node.getParent().getParent().getLeft()) {

                        makeRightChildParent(node, node.getParent());
                        makeLeftChildParent(node, node.getParent());

                    } else {

                        makeRightChildParent(node.getParent(), node.getParent().getParent());
                        makeRightChildParent(node, node.getParent());

                    }

                }

            }

        }

        this.root = node;

    }    
    
    public void insert(String name, String logo, String contact, String schedule,
                       String direction) {
        
        Enterprise newEnterprise = new Enterprise(name,logo,contact,schedule,direction);
        
        NodeSplayTree node1 = this.root;
        NodeSplayTree node2 = null;
        
        int compareResult;
        
        while (node1 != null) {
            
            node2 = node1;
            
            compareResult = newEnterprise.getName().compareTo(node2.getEnterprise().getName());
            
            if (compareResult < 0) {
                
                node1 = node1.getLeft();
            
            } else if (compareResult > 0) {
                
                node1 = node1.getRight();                     

            }
            
        }
        
        node1 = new NodeSplayTree();        
        node1.setEnterprise(newEnterprise);        
        node1.setParent(node2);       
                
        if (node2 == null) {

            this.root = node1;
            
        } else {
            
            compareResult = newEnterprise.getName().compareTo(node2.getEnterprise().getName());
            
            if (compareResult < 0) {
            
                node2.setLeft(node1);

            } else if (compareResult > 0) {

                node2.setRight(node1);

            } 
        
        }
           
        Splay(node1);
        
        count ++;
        
    }
        
    public void inorder() {
        
        inorder(this.root);
        
    }

    private void inorder(NodeSplayTree r) {
        
        if (r != null) {
            
            inorder(r.getLeft());
            System.out.print(r.getEnterprise().getName());
            System.out.println("");
            inorder(r.getRight());
            
        }
        
    }
    
}