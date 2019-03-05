package test.nik.notesresolvertest;

public class Note {
    private int id;
    private String text;

    public Note(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public Note(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
