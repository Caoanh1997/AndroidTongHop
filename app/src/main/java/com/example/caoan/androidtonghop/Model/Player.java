package com.example.caoan.androidtonghop.Model;

public class Player {

    private String name;
    private float score;
    private int avatar;
    private String club;
    private String position;

    public Player(String name, float score, int avatar, String club, String position) {
        this.name = name;
        this.score = score;
        this.avatar = avatar;
        this.club = club;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", avatar=" + avatar +
                ", club='" + club + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
