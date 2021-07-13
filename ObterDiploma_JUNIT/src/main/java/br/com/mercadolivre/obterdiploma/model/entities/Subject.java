package br.com.mercadolivre.obterdiploma.model.entities;

public class Subject {
    private String subject;
    private double note;

    public Subject(String subject, double note) {
        this.subject = subject;
        this.note = note;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
