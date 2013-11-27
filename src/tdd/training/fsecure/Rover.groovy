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
		move(it, this.orientation)
		orientRover(this.orientation, it)
	}

	private move(moveCommand, currentOrientation) {
		if(moveCommand=="f" && currentOrientation=="N") changePosition(0, 1)
		else if(moveCommand=="f" && currentOrientation == "E") changePosition(1, 0)
		else if(moveCommand=="f" && currentOrientation == "W") changePosition(-1, 0)
		else if(moveCommand=="f" && currentOrientation == "S") changePosition(0,-1)
		else if(moveCommand=="b" && currentOrientation=="N") changePosition(0, -1)
		else if(moveCommand=="b" && currentOrientation=="E") changePosition(-1, 0)
		else if(moveCommand=="b" && currentOrientation == "W") changePosition(1, 0)
		else if(moveCommand=="b" && currentOrientation== "S") changePosition(0, 1)
	}

	
	
	private changePosition(x_modifier, y_modifier) {
		Cell arrivingCell = new Cell(x: this.position.x + x_modifier, y: this.position.y + y_modifier)
		if (arrivingCellIsObstacle(arrivingCell)) this.foundObstacles.push(arrivingCell)
		else {
			this.position.y = this.position.y + y_modifier
			this.position.x = this.position.x + x_modifier
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
