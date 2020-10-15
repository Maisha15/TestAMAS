package uabc.ic.maishari.testamas;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String matricula;
    private String correo;
    private int sumaInquiHi;
    private int sumaAnsieFis;
    private int sumaAnsiExam;
    private int sumaAnsiSoc;
    private int sumaMentira;
    private int sumaAnsiTotal;


    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", matricula='" + matricula + '\'' +
                ", correo='" + correo + '\'' +
                ", sumaInquiHi=" + sumaInquiHi +
                ", sumaAnsieFis=" + sumaAnsieFis +
                ", sumaAnsiExam=" + sumaAnsiExam +
                ", sumaAnsiSoc=" + sumaAnsiSoc +
                ", sumaMentira=" + sumaMentira +
                ", sumaAnsiTotal=" + sumaAnsiTotal +
                '}';
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getSumaInquiHi() {
        return sumaInquiHi;
    }

    public void setSumaInquiHi(int sumaInquiHi) {
        this.sumaInquiHi = sumaInquiHi;
    }

    public int getSumaAnsieFis() {
        return sumaAnsieFis;
    }

    public void setSumaAnsieFis(int sumaAnsieFis) {
        this.sumaAnsieFis = sumaAnsieFis;
    }

    public int getSumaAnsiExam() {
        return sumaAnsiExam;
    }

    public void setSumaAnsiExam(int sumaAnsiExam) {
        this.sumaAnsiExam = sumaAnsiExam;
    }

    public int getSumaAnsiSoc() {
        return sumaAnsiSoc;
    }

    public void setSumaAnsiSoc(int sumaAnsiSoc) {
        this.sumaAnsiSoc = sumaAnsiSoc;
    }

    public int getSumaMentira() {
        return sumaMentira;
    }

    public void setSumaMentira(int sumaMentira) {
        this.sumaMentira = sumaMentira;
    }

    public int getSumaAnsiTotal() {
        return sumaAnsiTotal;
    }

    public void setSumaAnsiTotal(int sumaAnsiTotal) {
        this.sumaAnsiTotal = sumaAnsiTotal;
    }
}
