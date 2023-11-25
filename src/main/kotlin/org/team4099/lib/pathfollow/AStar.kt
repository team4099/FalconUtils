package org.team4099.lib.pathfollow

import org.team4099.lib.geometry.Pose2d
import org.team4099.lib.units.base.inMeters
import kotlin.math.pow

/**
 * Takes two points and runs A* which is a pathfinding algorithm in order to find the most optimal
 * path between two points. Used primarily for on-the-fly trajectory generation.
 */
class AStar {
  internal data class Node(val parent: Node?, val position: Pose2d) {
    var g: Int = 0 // Manhattan distance (cost used in Dijkstra's algorithm.)
    var h: Int = 0 // Heuristic (in our implementation of A*, it'll be the Pythagorean distance.)
    var f: Int = 0 // Total cost (g + h)

    override fun equals(other: Any?): Boolean {
      if (other !is Node) {
        return false
      }

      return this.position == other.position
    }
  }

  companion object {
    fun solve(
      startingPosition: Pose2d,
      endingPosition: Pose2d,
      grid: List<List<Pose2d>>
    ): List<Pose2d> {
      val yPoints =
        grid.map {
          it[0].y
        } // Implementation note: Each row of the grid should always have the same y values.

      // Calculate the closest nodes to the starting and ending positions
      val bestYStarting =
        yPoints
          .withIndex()
          .minByOrNull { (_, y) -> (startingPosition.y - y).absoluteValue.inMeters }
          ?.index
          ?: 0
      val bestXStarting =
        grid[bestYStarting]
          .withIndex()
          .minByOrNull { (_, pose) -> (startingPosition.x - pose.x).absoluteValue.inMeters }
          ?.index
          ?: 0
      val startingNode = Node(null, grid[bestYStarting][bestXStarting])

      val bestYEnding =
        yPoints
          .withIndex()
          .minByOrNull { (_, y) -> (endingPosition.y - y).absoluteValue.inMeters }
          ?.index
          ?: 0
      val bestXEnding =
        grid[bestYEnding]
          .withIndex()
          .minByOrNull { (_, pose) -> (endingPosition.x - pose.x).absoluteValue.inMeters }
          ?.index
          ?: 0
      val endingNode = Node(null, grid[bestYEnding][bestXEnding])

      // Other variables instantiated for later use when running the algorithm.
      val deltas =
        listOf(
          listOf(0, -1),
          listOf(0, 1),
          listOf(-1, 0),
          listOf(1, 0),
          listOf(-1, -1),
          listOf(1, 1),
          listOf(-1, 1),
          listOf(1, -1)
        )
      val openList = mutableListOf<Node>(startingNode)
      val closedList = mutableListOf<Node>(endingNode)
      var currentNode: Node?

      while (openList.size >=
        1
      ) { // Keep running until all the nodes are visited. In that case, no optimal path is
        // found.
        currentNode =
          openList.minByOrNull { it.f } ?: openList.last() // Find the node with the lowest cost.

        openList.remove(currentNode)
        closedList.add(currentNode)

        // Path found (current node with the lowest cost is the ending node).
        if (currentNode == endingNode) {
          val path = mutableListOf<Pose2d>()

          while (currentNode != null) {
            path.add(currentNode.position)
            currentNode = currentNode.parent
          }

          return path.reversed()
        }

        val currentY = yPoints.indexOfFirst { it.epsilonEquals(currentNode.position.y) }
        val currentX = grid[currentY].indexOfFirst { it.x.epsilonEquals(currentNode.position.x) }

        // Iterate through all the adjacent nodes.
        for ((deltaX, deltaY) in deltas) {
          val newY = currentY + deltaY
          val newX = currentX + deltaX

          // Suggested adjacent node is out of range.
          if (!(0 <= newY && newY < grid.size) || !(0 <= newX && newX < grid[newY].size)) {
            continue
          }

          val newNode = Node(currentNode, grid[newY][newX])
          newNode.g = currentNode.g + 1
          newNode.h =
            (
              (currentNode.position.x - newNode.position.x).absoluteValue.inMeters.pow(2.0) +
                (currentNode.position.y - newNode.position.y).absoluteValue.inMeters.pow(2.0)
              )
              .toInt()
          newNode.f = newNode.g + newNode.h

          // Discard node if it means going over the charge station.
          if ((newNode.position.x - currentNode.position.x).absoluteValue.inMeters >= 10) {
            continue
          }

          // Already visited this node.
          if (newNode in closedList) {
            continue
          }
          // Discard the node if it is in the open list and has a higher cost than the node already
          // opened.
          else if (newNode in openList && newNode.g > openList.first { newNode == it }.g) {
            continue
          }

          openList.add(newNode)
        }
      }

      return listOf()
    }
  }
}
