package com.mazuryk.spring_boot.demo.controller;

public class Course {
    private String name;
    private int ChapterCount;

    public Course(String name, int chapterCount) {
        this.name = name;
        ChapterCount = chapterCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChapterCount() {
        return ChapterCount;
    }

    public void setChapterCount(int chapterCount) {
        ChapterCount = chapterCount;
    }
}
