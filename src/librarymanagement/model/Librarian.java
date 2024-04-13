package librarymanagement.model;

public class Librarian extends User{
    private String position;
    public Librarian(int id, String name) {
        super(id, name);
        this.position="Librarian";
    }
}