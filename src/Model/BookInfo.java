package Model;


public class BookInfo {
    private String nameBook;
    private String firstNameAuthor;
    private String lastNameAuthor;
    private String surNameAuthor;
    private String publishingHouse;
    private int numberVolumes;
    private int circulation;
    private int totalVolumes;

    public BookInfo(String nameBook, String firstName, String lastName, String surName, String publishingHouse, int numberVolumes, int circulation, int totalVolumes) {
        this.nameBook = nameBook;
        this.firstNameAuthor = firstName;
        this.lastNameAuthor = lastName;
        this.surNameAuthor = surName;
        this.publishingHouse = publishingHouse;
        this.numberVolumes = numberVolumes;
        this.circulation = circulation;
        this.totalVolumes = totalVolumes;
    }

    public String getBookName() {
        return nameBook;
    }

    public String getLastName() {
        return lastNameAuthor;
    }

    public String getFirstName() {
        return firstNameAuthor;
    }

    public String getFatherName() {
        return surNameAuthor;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public int getNumberVolumes() {
        return numberVolumes;
    }

    public int getCirculation() {
        return circulation;
    }

    public int getTotalVolumes() {
        return totalVolumes;
    }
}
