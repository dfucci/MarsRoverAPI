package tdd.training.fsecure

import org.codehaus.groovy.ast.stmt.SwitchStatement;

class Rover {
	Cell position
	String orientation
	def foundObstacles = []
	Planet planet
	
	Rover(){
		orientation = "N"
		position = new Cell(x:0, y:0)
	}

	public executeCommand(command){
		command.each{
			analizeCommand(it) 
		}
	}

	private analizeCommand(it) {
		move(it)
		orientRover(this.orientation, it)
	}

	private move(moveCommand) {
		if(isMovingUp(moveCommand)) moveOnAxis("y", 1)
		else if(isMovingDown(moveCommand)) moveOnAxis("y", -1)
		else if(isMovingRight(moveCommand)) moveOnAxis("x", 1)
		else if(isMovingLeft(moveCommand)) moveOnAxis("x", -1)
	}

	
	private boolean isMovingUp(String moveCommand){
		return moveCommand=="f" && this.orientation=="N" || moveCommand=="b" && this.orientation == "S"
	}
	
	
	private boolean isMovingDown(String moveCommand){
		return moveCommand=="f" && this.orientation == "S" || moveCommand=="b" && this.orientation =="N" 
	}
	
	private boolean isMovingLeft(String moveCommand){
		return moveCommand=="f" && this.orientation == "W" || moveCommand=="b" && this.orientation =="E"
	}
	
	private boolean isMovingRight(String moveCommand){
		return moveCommand=="b" && this.orientation == "W" || moveCommand=="f" && this.orientation == "E"
	}
	private moveOnAxis(String axis, int direction){
		if(axis=="y" && direction == 1) moveOnPositiveYaxis()
		else if(axis == "y" && direction == -1) moveOnNegativeYaxis()
		else if(axis == "x" && direction ==1) moveOnPositiveXaxis()
		else if(axis == "x" && direction == -1) moveOnNegativeXaxis()
	}
	
	private moveOnPositiveXaxis(){
		changePosition(1, 0)
	}
	
	private moveOnNegativeXaxis(){
		changePosition(-1, 0)
	}
	
	private moveOnPositiveYaxis(){
		changePosition(0, 1)
	}
	private moveOnNegativeYaxis(){
		changePosition(0, -1)
	}
	
	private changePosition(x_modifier, y_modifier) {
		Cell arrivingCell = new Cell(x: this.position.x + x_modifier, y: this.position.y + y_modifier)
		if (arrivingCellIsObstacle(arrivingCell)) this.foundObstacles.push(arrivingCell)
		else {
			this.position.y = this.position.y + y_modifier
			this.position.x = this.position.x + x_modifier
			
		}
		spawnOutOfFieldRover()
	}

	private spawnOutOfFieldRover() {
		if(this.position.y > this.planet.side) spawn("S")
		if(this.position.x > this.planet.side) spawn("W")
		if(this.position.y < 0) this.position.y = spawn("N")
		if(this.position.x < 0) this.position.x = spawn("E")
	}

	
	
	private spawn(String direction){
		switch(direction){
			case "N":
				this.position.y = this.planet.side
				break
			case "S":
				this.position.y = 0
				break
			case "W":
				this.position.x = 0
				break
			case "E":
				this.position.x = this.planet.side
				break
		}
	}
	
	private boolean arrivingCellIsObstacle(Cell arrivingCell) {
		return this.planet.obstacles.contains(arrivingCell)
	}


	private orientRover(orientation, orientationCommand) {
		if(orientationCommand=="l"){
			if(orientation == "N") this.orientation = "W"
			else if(orientation == "W") this.orientation = "S"
			else if(orientation == "S") this.orientation = "E"
			else if(orientation == "E") this.orientation = "N"
		}

		if(orientationCommand=="r"){
			if(orientation=="N") this.orientation = "E"
			else if(orientation == "E") this.orientation = "S"
			else if(orientation == "S") this.orientation = "W"
			else if(orientation == "W") this.orientation = "N"
		}
	}
}
