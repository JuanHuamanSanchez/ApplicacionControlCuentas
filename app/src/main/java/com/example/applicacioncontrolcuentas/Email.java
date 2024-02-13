package com.example.applicacioncontrolcuentas;

public class Email {
    private String email;
    private String texto2;
    private String texto3;

    // Constructor
    public Email(String email, String texto2, String texto3) {
        this.email = email;
        this.texto2 = texto2;
        this.texto3 = texto3;
}
    // Métodos getter y setter para email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Métodos getter y setter para texto2
    public String getTexto2() {
        return texto2;
    }

    public void setTexto2(String texto2) {
        this.texto2 = texto2;
    }

    // Métodos getter y setter para texto3
    public String getTexto3() {
        return texto3;
    }

    public void setTexto3(String texto3) {
        this.texto3 = texto3;
    }
}
