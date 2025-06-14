package model;
public class Book{
    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private int totalcopies;
    private int availableCopies;
    //constructor
    public Book(int bookId,String title,String author,String publisher,int year,int copies){
        this.bookId=bookId;
        this.title=title;
        this.author=author;
        this.publisher=publisher;
        this.year=year;
        this.totalcopies=copies;
        this.availableCopies=copies;
    }
    //getters
    public int getBookId(){
        return bookId;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getPublisher(){
        return publisher;
    }
    public int Year(){
        return year;
    }
    public int getTotalcopies(){
        return totalcopies;
    }
    public int getAvailablecopies(){
        return availableCopies;
    }
    public void increaseCopies(){
        this.availableCopies++;
        }
    public void decreaseCopies(){
        if(this.availableCopies>0){
            this.availableCopies--;
        }
    }
    public String fulldetails(){
        return "Book Id:" +bookId+"| Title: " +title+"| Author:" +author+"| Publisher: "+publisher+"| Year:" +year+ "|Copies:" + availableCopies+"/" +totalcopies;
    }
    
}