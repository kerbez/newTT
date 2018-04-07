package com.example.kerbe.newtt;

/**
 * Created by kerbe on 03.04.2018.
 */

public class Klass {
    int id;
    String subject;
    String teacher;
    String place;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    String day;
    String start, finish;
    String kind;
    String group;


    public String getSubject() {
        return subject;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Klass(int id, String subject, String teacher, String place,String day, String start, String finish, String kind, String group) {
        this.id = id;
        this.subject = subject;
        this.teacher = teacher;
        this.place = place;
        this.day = day;
        this.start = start;
        this.finish = finish;
        this.kind = kind;
        this.group = group;
    }

    public Klass() {
    }
}
