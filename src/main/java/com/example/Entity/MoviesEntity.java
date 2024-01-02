package com.example.Entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="movie_metadata")
public class MoviesEntity {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long id;
	 @Column()
	 private String adult;
	 @Column()
	 private String belongs_to_collection;
	 @Column()
	 private String budget;
	 @Column()
	 private String genres;
	 @Column()
	 private String homepage;
	 @Column()
	 private String imdb_id;
	 @Column()
	 private String original_language;
	 @Column()
	 private String original_title;
	 @Column()
	 private String overview;
	 @Column()
	 private String popularity;
	 @Column()
	 private String poster_path;
	 @Column()
	 private String production_companies;
	 @Column()
	 private String production_countries;
	 @Column()
	 private String release_date;
	 @Column()
	 private String revenue;
	 @Column()
	 private String runtime;
	 @Column()
	 private String spoken_languages;
	 @Column()
	 private String status;
	 @Column()
	 private String tagline;
	 @Column()
	 private String title;
	 @Column()
	 private String video;
	 @Column()
	 private String vote_average;
	 @Column()
	 private String vote_count;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdult() {
		return adult;
	}
	public void setAdult(String adult) {
		this.adult = adult;
	}
	public String getBelongs_to_collection() {
		return belongs_to_collection;
	}
	public void setBelongs_to_collection(String belongs_to_collection) {
		this.belongs_to_collection = belongs_to_collection;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getImdb_id() {
		return imdb_id;
	}
	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}
	public String getOriginal_language() {
		return original_language;
	}
	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}
	public String getOriginal_title() {
		return original_title;
	}
	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getPopularity() {
		return popularity;
	}
	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}
	public String getPoster_path() {
		return poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	public String getProduction_companies() {
		return production_companies;
	}
	public void setProduction_companies(String production_companies) {
		this.production_companies = production_companies;
	}
	public String getProduction_countries() {
		return production_countries;
	}
	public void setProduction_countries(String production_countries) {
		this.production_countries = production_countries;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getRevenue() {
		return revenue;
	}
	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getSpoken_languages() {
		return spoken_languages;
	}
	public void setSpoken_languages(String spoken_languages) {
		this.spoken_languages = spoken_languages;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getVote_average() {
		return vote_average;
	}
	public void setVote_average(String vote_average) {
		this.vote_average = vote_average;
	}
	public String getVote_count() {
		return vote_count;
	}
	public void setVote_count(String vote_count) {
		this.vote_count = vote_count;
	}
	 
}
