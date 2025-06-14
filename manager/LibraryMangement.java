package manager;
import java.util.ArrayList;
import model.*;


public class LibraryMangement {
    
   private ArrayList<Book>books=new ArrayList<>();
   private ArrayList<User>users=new ArrayList<>();
    
   public void addBook(Book b){
       books.add(b);
       
   }
    //constructor
    public void addUser(User u){
        users.add(u);
    }
    public void viewAllBooks(){
        for(Book b: books){
            System.out.println(b);
        }
    }
    public ArrayList<User> getAllUsers(){
        return users;
        
    }
    public Book getBookById(int bookId){
        for (Book b:books){
            if(b.getBookId()==bookId){
                return b;
            }
        }
        return null;
            
    }
    public User getUserById(int userId){
        for(User u: users){
            if (u.getUserId() == userId){
                return u;
            }
        }
        return null;
    }
    public void searchBookByTitle(String t){
        boolean found= false;
        String title=t.toLowerCase();
        for(Book b: books){
            String bookTitle=b.getTitle().toLowerCase();
            if(bookTitle.contains(title)){
                System.out.println(b);
                found=true;
                
            }
            
        }
        if(found==false){
            System.out.println("No books found");
            
        }
    }
    public void borrowBook(int bookId, int userId){
        Book b= getBookById(bookId);
        User u= getUserById(userId);
        if(b!=null && u!= null && b.getAvailablecopies()>0){
            b.decreaseCopies();
            u.borrowBook(bookId);
            System.out.println("Book borrowed Succesfully");
            
        }else{
            System.out.println("Unable to borrow book");
        }
        
    }
    public void returnBook(int bookId,int userId){
        Book b = getBookById(bookId);
        User u = getUserById(userId);
        if(b!=null && u!=null){
            b.increaseCopies();
            u.returnBook(bookId);
            System.out.println("Book returned Successfully");
        }else{
            System.out.println("Unable to return book");
        }
    }
    
}