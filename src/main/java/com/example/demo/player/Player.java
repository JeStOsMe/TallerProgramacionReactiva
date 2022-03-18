package com.example.demo.player;

public class Player {
    public int id;
    public String name;
    public int age;
    public String icon;
    public String national;
    public int winners;
    public int games;
    public String club;

    public Player(){

    }

    public Player(String id, String name, String age, String icon, String national, String winners, String games, String club) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.age = Integer.parseInt(age);
        this.icon = icon;
        this.national = national;
        this.winners = Integer.parseInt(winners);
        this.games = Integer.parseInt(games);
        this.club = club;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public int getWinners() {
        return winners;
    }

    public void setWinners(int winners) {
        this.winners = winners;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "Player [age=" + age + ", club=" + club + ", games=" + games + ", icon=" + icon + ", id=" + id
                + ", name=" + name + ", national=" + national + ", winners=" + winners + "]";
    }
    
}
