package prograavanzada2016.anotherworld.modelos;

public class InteligenciaArtificial {
	private int id;
	private int movimiento[];
	
	public InteligenciaArtificial(int id){
		this.id=id;
		movimiento = new int[]{200, 200, 250,250,350,250,350,200};
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
