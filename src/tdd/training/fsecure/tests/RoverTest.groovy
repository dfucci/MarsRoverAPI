package tdd.training.fsecure.tests;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat
import static org.hamcrest.CoreMatchers.*
import static org.junit.matchers.JUnitMatchers.*
import org.junit.Test;
import org.junit.Before;
import tdd.training.fsecure.Cell
import tdd.training.fsecure.Planet
import tdd.training.fsecure.Rover

class RoverTest {
	Rover rover
	Planet mars
	Cell obstacle 
	def obstacles = []
	@Before void setup(){
		rover = new Rover()
		mars = new Planet(side:100, obstacles: obstacles)
		rover.planet = mars
	}
	@Test
	void aRoverShouldLandIn00FacingNorth() {
		assertThat rover.orientation, is("N")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(0)
	}

	@Test
	void theRoverShouldBeIn01AfterAfCommand(){
		rover.executeCommand("f")
		assertThat rover.position.x, is (0)
		assertThat rover.position.y, is(1)
		assertThat rover.orientation, is("N")
	}

	@Test
	void theRoverShouldBeIn02AfterffCommand(){
		rover.executeCommand("ff")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(2)
		assertThat rover.orientation, is("N")
	}

	@Test
	void theRoverShouldBein03AfterfffCommand(){
		rover.executeCommand("fff")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(3)
		assertThat rover.orientation, is("N")
	}

	@Test
	void theRoverShouldMoveBackwardsWhenNotOnTheEdgeofThePlanet(){
		rover.executeCommand "ffb"
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(1)
		assertThat rover.orientation, is("N")
	}

	@Test
	void theRoverShouldBein00AfterANumberoffcommandsFollowedByAnEqualNumberOfbcommands(){
		rover.executeCommand("fffbbb")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(0)
		assertThat rover.orientation, is("N")
	}

	@Test
	void theJustLandedRoverShouldChangeFacingToEAfterlcommand(){
		rover.executeCommand("l")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(0)
		assertThat rover.orientation, is("W")
	}

	@Test
	void theRoverShouldFacingEAfterMovingForwardAndTurningLeft(){
		rover.executeCommand("ffl")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(2)
		assertThat rover.orientation, is("W")
	}

	@Test
	void theRoverShouldFacingEAfterMovingForwardAndBackwardsAndTurningLeft(){
		rover.executeCommand("ffbbl")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(0)
		assertThat rover.orientation, is("W")
	}


	@Test
	void theJustLandedRoverShouldChangeFacingToWAfterlcommand(){
		rover.executeCommand("r")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(0)
		assertThat rover.orientation, is("E")
	}

	@Test
	void theRoverShouldFacingWestAfterMovingForwardAndTurningRight(){
		rover.executeCommand("ffr")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(2)
		assertThat rover.orientation, is("E")
	}

	@Test
	void theRoverShouldFacingWestAfterMovingForwardAndBackwardsAndTurningRight(){
		rover.executeCommand("ffbbr")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(0)
		assertThat rover.orientation, is("E")
	}

	@Test
	void theRoverShouldBeFacingSouthAfterllcommand(){
		rover.executeCommand("ll")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(0)
		assertThat rover.orientation, is("S")
	}

	@Test
	void theRoverShouldBeFacingSouthAfterrrcommand(){
		rover.executeCommand("rr")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(0)
		assertThat rover.orientation, is("S")
	}

	@Test
	void theRoverShouldBeFacingSouthAfteffrrrcommand(){
		rover.executeCommand("ffrr")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(2)
		assertThat rover.orientation, is("S")
	}

	@Test
	void theRoverShouldBeFacingSouthAfteffbbrrrcommand(){
		rover.executeCommand("ffbbrr")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(0)
		assertThat rover.orientation, is("S")
	}

	@Test
	void theRoverShouldFaceWestAfterlllcommand(){
		rover.executeCommand("lll")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(0)
		assertThat rover.orientation, is("E")
	}


	@Test
	void theRoverShouldFacingEastAfterrrrcommand(){
		rover.executeCommand("rrr")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(0)
		assertThat rover.orientation, is("W")
	}

	@Test
	void theRoverShouldBeFacingNorthAfterllllcommand(){
		rover.executeCommand("llll")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(0)
		assertThat rover.orientation, is("N")
	}

	@Test
	void theRoverShouldBeFacingNorthAfterrrrrcommand(){
		rover.executeCommand("rrrr")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(0)
		assertThat rover.orientation, is("N")
	}

	@Test
	void theRoverShouldBeFacingNorthAfterMovingForwardAndrrrrcommand(){
		rover.executeCommand("ffrrrr")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(2)
		assertThat rover.orientation, is("N")
	}

	@Test
	void theRoverShouldBeFacingNorthAfterMovingForwardBackwardAndrrrrcommand(){
		rover.executeCommand("ffbbrrrr")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(0)
		assertThat rover.orientation, is("N")
	}

	@Test
	void theRoverShouldBeIn22AfterffrffCommand(){
		rover.executeCommand("ffrff")
		assertThat rover.position.x, is(2)
		assertThat rover.position.y, is(2)
		assertThat rover.orientation, is("E")
	}
	
	@Test
	void theRoverShouldBeIn02AfterffrffbbCommand(){
		rover.executeCommand("ffrffbb")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(2)
		assertThat rover.orientation, is("E")
	}

	@Test
	void theRoverShouldMoveOnTheNegativeXWhenFacingWestAndMovingForward(){
		rover.executeCommand("rffrrf")
		assertThat rover.position.x, is(1)
		assertThat rover.position.y, is(0)
		assertThat rover.orientation, is("W")
	}
	
	@Test
	void theRoverShouldMoveOnTheNegativeYWhenFacingSouthAndMovingForward(){
		rover.executeCommand("ffrrf")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(1)
		assertThat rover.orientation, is("S")
	}
	
	@Test
	void theRoverShouldMoveOnThePositiveXWhenFacingWestAndMovingBackwards(){
		rover.executeCommand("lb")
		assertThat rover.position.x, is(1)
		assertThat rover.position.y, is(0)
		assertThat rover.orientation, is("W")
	}
	
	@Test
	void theRoverShouldMoveOnTheNegativeXWhenFacingEastAndMovingBackwards(){
		rover.executeCommand("rffb")
		assertThat rover.position.x, is(1)
		assertThat rover.position.y, is(0)
		assertThat rover.orientation, is("E")
	}
	
	@Test
	void theRoverShouldMoveOnThePositiveYWhenFacingSouthAndMovingBackwards(){
		rover.executeCommand("rrb")
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(1)
		assertThat rover.orientation, is("S")
	}
	
	@Test
	void theRoverPlanetHasOneObstacleWhenOneObstacleIsAddedToTheObstacles(){
		obstacle = new Cell(x:0, y:1)
		rover.planet.obstacles.push(obstacle)
		assertThat rover.planet.obstacles.size(), is (1)
		assertThat rover.planet.obstacles.get(0).x, is(0)
		assertThat rover.planet.obstacles.get(0).y, is(1)
	
	}
	
	@Test
	void theRoverShouldHoldTheObstacleEncounteredIn01AfterfCommand(){
		obstacle = new Cell(x:0, y:1)
		rover.planet.obstacles.push(obstacle)
		
		rover.executeCommand("f")
		assertThat "Obstacle is present", rover.planet.obstacles.size, is(1)
		assertThat "Can't find obstacle", rover.foundObstacles.size(), is(1)
		assertThat "Can't find obstacle", rover.foundObstacles.get(0).x, is(0)
		assertThat "Can't find obstacle", rover.foundObstacles.get(0).y, is(1)
	}
	
	@Test
	void theRoverShouldHoldTheObstacleEncounteredIn01AfterfCommandAndContinueWithOtherCommands(){
		obstacle = new Cell(x:0, y:1)
		rover.planet.obstacles.push(obstacle)
		
		rover.executeCommand("frf")
		assertThat "Obstacle is present", rover.planet.obstacles.size, is(1)
		assertThat "Can't find obstacle", rover.foundObstacles.size(), is(1)
		assertThat "Can't find obstacle", rover.foundObstacles.get(0).x, is(0)
		assertThat "Can't find obstacle", rover.foundObstacles.get(0).y, is(1)
		assertThat rover.position.x, is(1)
		assertThat rover.position.y, is(0)
		
	}
	
	@Test
	void theRoverShouldHoldTheObstacleEncounteredIn01AfterBackCommandAndContinueWithOtherCommands(){
		obstacle = new Cell(x:0, y:1)
		rover.planet.obstacles.push(obstacle)
		
		rover.executeCommand("rflfflfrb")
		assertThat "Obstacle is present", rover.planet.obstacles.size, is(1)
		assertThat "Can't find obstacle", rover.foundObstacles.size(), is(1)
		assertThat "Can't find obstacle", rover.foundObstacles.get(0).x, is(0)
		assertThat "Can't find obstacle", rover.foundObstacles.get(0).y, is(1)
		assertThat rover.position.x, is(0)
		assertThat rover.position.y, is(2)
		
	}
	
	@Test
	void whenTheRoverMovesOverTheTopEdgeItShouldBeAtTheBottomOfThePlanet(){
		1.upto(101) {rover.executeCommand("f")}
		assertThat "Rover is at the edge of Planet", rover.position.y, is(0)
	}
		
	@Test
	void whenTheRoverMovesOverTheRightEdgeItShouldSpawnAtTheLeftEdgeOfThePlanet(){
		rover.executeCommand("r")
		1.upto(100) {rover.executeCommand("f")}
		assertThat rover.position.x, is(100)
		rover.executeCommand("f")
		assertThat "Rover is at the right edge of the Planet", rover.position.x, is(0)
	}
	
	@Test
	void whenTheRoverIsAtTheBottomOfThePlanetAndMovesBackwardsItSpawnAtTheTop(){
		rover.executeCommand("b")
		assertThat rover.position.y, is(100)
	}
	
	
	@Test
	void whenTheRoverIsAtTheLeftEdgeOfThePlanetAndMoveBackwardsItSpawnAtTheRightEdge(){
		rover.executeCommand("rb")
		assertThat rover.position.x, is(100)
	}
}
