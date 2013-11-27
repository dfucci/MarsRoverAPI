package tdd.training.fsecure

class Cell {
	int x
	int y
	
	boolean equals(Object c){
		if(null==c) return false
		return (x == c.x && y == c.y)
	}
}
