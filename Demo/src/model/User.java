package model;
import java.util.ArrayList;


public class User{
    private int userId;
    private String name;
    private String username;
    private String password;
    private boolean isAdmin;
    private ArrayList<Integer>borrowedBooksId=new ArrayList<>();
    
    //constructor
    public User(int userId,String name,String username,String password,boolean IsAdmin){
        this.userId= userId;
        this.name= name;
        this.username= username;
        this.password=password;
        this.isAdmin=IsAdmin;
    }
    //getters
    public int getUserId(){
        return userId;
    }
    public String getname(){
        return name;
    }
    public String getusername(){
        return username;
    }
    public String getpassword(){
        return password;
    }
    public boolean getisAdmin(){
        return isAdmin;
    }
    public void borrowBook(int bookId){
        borrowedBooksId.add(bookId);
    }
    public void returnBook(int bookId){
        borrowedBooksId.remove(bookId);
    }
    public void ShowBorrowedBooks(){
        if(borrowedBooksId.isEmpty()){
            System.out.println("You have borrowed books");
        }else{
            System.out.println("Borrowed Books Id:" +borrowedBooksId);
        }
    }
    
    
}
