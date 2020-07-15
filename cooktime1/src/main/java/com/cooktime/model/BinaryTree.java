package com.cooktime.model;

import com.cooktime.model.NodeBinaryTree;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class BinaryTree {
    
    private NodeBinaryTree root;
    private ArrayList<User> userList = new ArrayList<User>();

    public BinaryTree() {

        this.root = null;

    }

    public boolean isEmpty() {

        return this.root == null;

    }
    
    public boolean contains(String email) {
        
        return this.containsAux(email, this.root);
        
    }
    
    private boolean containsAux(String email, NodeBinaryTree node) {
        
        if (node == null) {
            
            return false;
        
        } else {
            
            int compareResult = email.compareTo(node.getUser().getEmail());

            if (compareResult < 0) {

                return containsAux(email, node.getLeft());

            } else if (compareResult > 0) {

                return containsAux(email, node.getRight());

            } else {

            return true;

            }
        
        }
        
    }
    
    public User getUser(String email) {
        
        return this.getUserAux(email, this.root);
        
    }
    
    private User getUserAux(String email, NodeBinaryTree node) {        
                    
        int compareResult = email.compareTo(node.getUser().getEmail());

        if (compareResult < 0) {

            return getUserAux(email, node.getLeft());

        } else if (compareResult > 0) {

            return getUserAux(email, node.getRight());

        } else {

        return node.getUser();

        }
        
        
        
    }
    
    public User findMin() {
        
        if (this.isEmpty()) {
            
            return null;
        
        } else {
            
            return this.findMinAux(this.root);
        
        }
        
    }       
    
    private User findMinAux(NodeBinaryTree node) {
        
        if (node == null) {
            
            return null;
            
        } else if (node.getLeft() == null) {
            
            return node.getUser();
            
        } else {
            
            return findMinAux(node.getLeft());
            
        }
        
    }
    
    public User findMax() {

        if (this.isEmpty()) {

            return null;

        } else {

            return this.findMaxAux(this.root);

        }
        
    }
        
    private User findMaxAux(NodeBinaryTree node) {
        
        if (node!= null) {
    
            while (node.getRight() != null) {
    
                node = node.getRight();
    
            }    
            
        }
    
        return node.getUser();           
        
    }
       
    public void insert(String email, String name, String lastName, int age, String password, String photo,
                       ArrayList<Recipe> myMenuList, ArrayList<String> followers, ArrayList<String> followed, boolean chef) {
        
        String newPassword = encrypte("password", password);        
                
        User newUser = new User(email, name, lastName, age, newPassword, photo, myMenuList, followers, followed, chef);
        
        this.root = this.insertAux(newUser, this.root);
        
    }
    
    private NodeBinaryTree insertAux(User newUser, NodeBinaryTree node) {
    
        if (node == null) {
    
            return new NodeBinaryTree(newUser, null, null);
            
        }
    
        int compareResult = newUser.getEmail().compareTo(node.getUser().getEmail());
    
        if (compareResult < 0) {
    
            node.setLeft(this.insertAux(newUser, node.getLeft()));
            
        } else if (compareResult > 0) {
    
            node.setRight(this.insertAux(newUser, node.getRight()));          
            
        }
    
        return node;            
    
    }
    
    public void remove(String email) {
 
        this.root = this.removeAux(email, this.root);
 
    }
    
    private NodeBinaryTree removeAux(String email, NodeBinaryTree node) {
        
        if (node == null) {
                    
            return node;
            
        }

        int compareResult = email.compareTo(node.getUser().getEmail());
        
        if (compareResult < 0) {
        
            node.setLeft(removeAux(email, node.getLeft()));
            
        } else if (compareResult > 0) {
        
            node.setRight(removeAux(email, node.getRight()));
            
        } else if (node.getLeft() != null && node.getRight() != null){
                    
            node.setUser(findMinAux(node.getRight()));
            node.setRight(removeAux(node.getUser().getEmail(), node.getRight()));
                    
        } else {                
            
            node = node.getLeft() != null ? node.getLeft() : node.getRight();
                
        }
        
        return node;
        
    }
    
    public ArrayList<User> inOrder() {
        
        this.userList.clear();
        
        return this.inOrderAux(userList, this.root);
      
    }
    
    private ArrayList<User> inOrderAux(ArrayList<User> userList, NodeBinaryTree node) {
        
      if (node == null) {
          
        return null;
        
      }
      
      inOrderAux(userList, node.getLeft());
      userList.add(node.getUser());
      inOrderAux(userList, node.getRight());
      
      return userList;
      
    }
        
    public String encrypte(String secretKey, String password) {
        
        String encryptedPassword = "";
        
        try {
            
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] keyPassword = md5.digest(secretKey.getBytes("utf-8"));
            byte[] BytesKey = Arrays.copyOf(keyPassword, 24);
            SecretKey key = new SecretKeySpec(BytesKey, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainTextBytes = password.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            encryptedPassword = new String(base64Bytes);
            
        } catch (Exception ex) {
            
        }
        
        return encryptedPassword;
        
    }
    
}
