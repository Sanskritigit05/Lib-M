import java.util.*;
import manager.*;
import model.*;

public class Main {
    public static void main (String[] args){
        
        Scanner sc=new Scanner(System.in);
        LibraryMangement library= new LibraryMangement();
        LoginManager l= new LoginManager();
        
        User currentUser=null;
        while(currentUser== null){
            System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("3.Exit");
            int choice=sc.nextInt();
            if (choice==1){
                System.out.println("Username:");
                String username=sc.next();
                System.out.println("Password:");
                String password=sc.next();
                currentUser= l.login(username,password,library.getAllUsers());
                if(currentUser == null){
                    System.out.println("Invalid username or password, Try again");
                }
            }else if(choice ==2){
                System.out.print("Name");
                String name= sc.nextLine();
                System.out.print("Username");
                String username= sc.next();
                System.out.println("Password: ");
                String password=sc.next();
                int userId=1000+ new Random().nextInt(9000);
                User newuser= new User(userId,name,username,password,false);
                library.addUser(newuser);
                System.out.println("User Registered succesfully,Now you can login");
                
        }else if(choice==3){
            System.out.println("Goodbye!");
            return;
        }else{
            System.out.println("Invalid choice,Try again");
            
        }
            
        }
        
        System.out.println("Welcome" + currentUser.getname());
        int choice;
        do{
            System.out.println("=====Menu=====");
            if (currentUser.getisAdmin()){
                System.out.println("1.Add Book");
                System.out.println("2.View Book");
                System.out.println("4.Logout");
                choice=sc.nextInt();
                if(choice==1){
                    System.out.print("Book Title");
                    String title=sc.nextLine();
                    System.out.print("Book Author");
                    String author=sc.nextLine();
                    System.out.print("Book Publisher");
                    String publisher=sc.nextLine();
                    System.out.print("Book Year");
                    int year=sc.nextInt();
                    System.out.print("Copies");
                    int copies=sc.nextInt();
                    int bookId=1000 +new Random().nextInt(9000);
                    Book newBook =new Book(bookId,title,author,publisher,year,copies);
                    library.addBook(newBook);
                    System.out.println();
                    System.out.println("Book Added Succesfully");
                }else if(choice ==2){
                    System.out.println("=====Book List====");
                    library.viewAllBooks();
                    
                }else if(choice==3){
                    System.out.println("=====UserList=====");
                    ArrayList<User> users=library.getAllUsers();
                   for(User u:users){
                       String role;
                       if(u.getisAdmin()){
                           role="Admin";
                           
                       }else{
                           role="User";
                       }
                       System.out.println(u.getUserId() +u.getname()+"| Role" +role);
                   }
                }else if(choice==4){
                    System.out.println("GoodBye");
                    return;
                }else{
                    System.out.println("Invalid Choice,Try again");
                }
            }else{
                System.out.println("1.View Book");
                System.out.println("2.Search Book");
                System.out.println("3.Borrow Book");
                System.out.println("4.Return book");
                System.out.println("5.My Borrowed Book");
                System.out.println("6.Logout");
                choice=sc.nextInt();
                if (choice==1){
                    System.out.println("=====BookList====");
                    library.viewAllBooks();
                }else if(choice==2){
                    System.out.println("Keyword:");
                    String keyword=sc.nextLine();
                    library.searchBookByTitle(keyword);
                }else if(choice==3){
                    System.out.println("Book Id");
                    int bookId= sc.nextInt();
                    library.borrowBook(bookId,currentUser.getUserId());
                }else if(choice==4){
                    System.out.println("BookId");
                    int bookId=sc.nextInt();
                    library.returnBook(bookId,currentUser.getUserId());
                }else if(choice==5){
                    currentUser.ShowBorrowedBooks();
                }else if(choice==6){
                    System.out.println("=====Logout=====");
                    return;
                }else{
                    System.out.println("Invalid choice,Try again");
                }
                
            }
        }while (true);
        
        
    }
}
