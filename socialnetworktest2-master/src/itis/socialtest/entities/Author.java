package itis.socialtest.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Author {

    private Long id;
    private String nickname;
    private String birthdayDate;
    private static List<Author> authorList;

    public Author(Long id, String nickname, String birthdayDate) {
        this.id = id;
        this.nickname = nickname;
        this.birthdayDate = birthdayDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public static List<Author> authors (String file) throws IOException {
        ArrayList<Author> list = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line =  reader.readLine();
            while(line!=null){
                String[] split = line.split(",");
                list.add(new Author(Long.parseLong(split[0].trim()),split[1].trim(),split[2]));
                line = reader.readLine();
            }
        authorList = new ArrayList<>(list);
        return list;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", birthdayDate='" + birthdayDate + '\'' +
                '}';
    }
}