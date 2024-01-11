package dto;

import java.util.Arrays;

public class Movie 
{
	private int movieid;
	private String movivename;
	private double movieprice;
	private double movierating;
	private String moviegenre;
	private String movielang;
	private byte[] movieimage;
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public String getMovivename() {
		return movivename;
	}
	public void setMovivename(String movivename) {
		this.movivename = movivename;
	}
	public double getMovieprice() {
		return movieprice;
	}
	public void setMovieprice(double movieprice) {
		this.movieprice = movieprice;
	}
	public double getMovierating() {
		return movierating;
	}
	public void setMovierating(double movierating) {
		this.movierating = movierating;
	}
	public String getMoviegenre() {
		return moviegenre;
	}
	public void setMoviegenre(String moviegenre) {
		this.moviegenre = moviegenre;
	}
	public String getMovielang() {
		return movielang;
	}
	public void setMovielang(String movielang) {
		this.movielang = movielang;
	}
	public byte[] getMovieimage() {
		return movieimage;
	}
	public void setMovieimage(byte[] movieimage) {
		this.movieimage = movieimage;
	}
	@Override
	public String toString() {
		return "Movie [movieid=" + movieid + ", movivename=" + movivename + ", movieprice=" + movieprice
				+ ", movierating=" + movierating + ", moviegenre=" + moviegenre + ", movielang=" + movielang
				+ ", movieimage=" + Arrays.toString(movieimage) + "]";
	}
}

