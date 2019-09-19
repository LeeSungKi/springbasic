package vo;

public class BookVo {
	private String title;
	private int price;
	private String genre;
	
	public BookVo() {}
	public BookVo(String t, int p, String g) {
		title = t;
		price = p;
		genre = g;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
