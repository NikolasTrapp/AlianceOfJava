package equipamentos;

public enum Raridade {
	

	LENDARIO(5),

	EPICO(15),

	RARO(35),
	
	INCOMUM(65),
	
	COMUM(100);
	
	int chance;
	
	Raridade(int chance) {
		this.chance = chance;
	}
	
	public int getChance() {
		
		return chance;
	}
	
	public void setChance(int chance) {
		this.chance = chance;
	}
	

}
