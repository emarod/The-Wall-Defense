package mapa;

public class Cell extends Celda {

	public Cell(int posX, int posY) {
		super(posX, posY);
	}

	@Override
	public void addChild(Celda c) {
		throw new UnsupportedOperationException("Operacion no soportada");
	}

	@Override
	public void removeChild() {
		throw new UnsupportedOperationException("Operacion no soportada");
	}

	@Override
	public Celda getChild() {
		throw new UnsupportedOperationException("Operacion no soportada");
	}

	@Override
	public void removeTail() {
		throw new UnsupportedOperationException("Operacion no soportada");

	}

	@Override
	public void setTail(Celda c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setChild(Celda c) {
		// TODO Auto-generated method stub

	}

}
