package com.cinema.shop.model.requestData;

import com.cinema.shop.model.Category;
import com.cinema.shop.model.Language;
import com.cinema.shop.model.Rating;

import java.util.List;

public class FilterRequest {

    private List<Category> categories;

    private List<Language> languages;

    private List<Rating> ratings;

    private long min;

    private long max;

    public FilterRequest() {
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public long getMin() {
        return min;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }
}
