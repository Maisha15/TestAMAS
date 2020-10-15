package uabc.ic.maishari.testamas;

import java.io.Serializable;

public class ItemAmas implements Serializable {
    private int id;
    private String items;
    private String si;
    private String no;
    private int inquihiper;
    private int ansieFisio;
    private int ansieexam;
    private int ansieSoc;
    private int mentira;
    private int ansiedadTotal;

    public ItemAmas() {
    }

    public int getId() {
        return id;
    }

    public String getItems() {
        return items;
    }

    public ItemAmas(int id, String items, String si, String no, int inquihiper, int ansieFisio, int ansieexam, int ansieSoc, int mentira, int ansiedadTotal) {
        this.id = id;
        this.items = items;
        this.si = si;
        this.no = no;
        this.inquihiper = inquihiper;
        this.ansieFisio = ansieFisio;
        this.ansieexam = ansieexam;
        this.ansieSoc = ansieSoc;
        this.mentira = mentira;
        this.ansiedadTotal = ansiedadTotal;
    }

    public String getItem(){
        return "";
    }

    @Override
    public String toString() {
        return "ItemAmas{" +
                "id=" + id +
                ", items='" + items + '\'' +
                ", resp2=" + si +
                ", resp1=" + no +
                ", inquihiper=" + inquihiper +
                ", ansieFisio=" + ansieFisio +
                ", ansieexam=" + ansieexam +
                ", ansieSoc=" + ansieSoc +
                ", mentira=" + mentira +
                ", ansiedadTotal=" + ansiedadTotal +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setInquihiper(int inquihiper) {
        this.inquihiper = inquihiper;
    }

    public void setAnsieFisio(int ansieFisio) {
        this.ansieFisio = ansieFisio;
    }

    public void setAnsieexam(int ansieexam) {
        this.ansieexam = ansieexam;
    }

    public void setAnsieSoc(int ansieSoc) {
        this.ansieSoc = ansieSoc;
    }

    public void setMentira(int mentira) {
        this.mentira = mentira;
    }

    public void setAnsiedadTotal(int ansiedadTotal) {
        this.ansiedadTotal = ansiedadTotal;
    }
}
