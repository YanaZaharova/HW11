package ru.netology;

public class MovieManager {

    private String[] movies = new String[0];
    private int lengthLimit;

    public MovieManager() {
        this.lengthLimit = 5;
    }

    public MovieManager(int lengthLimit) {
        this.lengthLimit = lengthLimit;
    }

    public void addNewMovie(String movie) {
        String[] tmp = new String[movies.length + 1];
        for (int m = 0; m < movies.length; m++) {
            tmp[m] = movies[m];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        int currentLength;
        if (movies.length < lengthLimit) {
            currentLength = movies.length;
        } else {
            currentLength = lengthLimit;
        }
        String[] tmp = new String[currentLength];
        for (int m = 0; m < tmp.length; m++) {
            tmp[m] = movies[movies.length - 1 - m];
        }
        return tmp;
    }
}
