package vo;

public class PokemonVo {
	private String name;
	private int level;
	private int hp;
	
	public PokemonVo() {
		System.out.println("PokemonVo 의 기본생성자");
	}
	
	public PokemonVo(String n, int lv, int hp) {
		name = n;
		level = lv;
		this.hp = hp;
		System.out.println("PokemonVo 의 생성자(String, int, int)");
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	

}
