package graphs.bfs

import java.util.*

class BFS {

    fun prepareAdjacencyList(): Map<Int, Set<Int>> {
        return mapOf(
            1 to setOf(2, 3, 4),
            2 to setOf(4, 5),
            3 to setOf(4, 6),
            4 to setOf(5, 6)
        )
    }

    fun bfs(nodesCount: Int, startNode: Int, endNode: Int): Array<Int> {
        val result = LinkedList<Int>()
        val adjacencyLists = prepareAdjacencyList()

        val visited = Array(nodesCount + 1) { false }
        val nodesToVisit = LinkedList<Int>()
        nodesToVisit.add(startNode)
        val previous = IntArray(nodesCount + 1) { -1 }
        val distance = IntArray(nodesCount + 1) { -1 }
        distance[startNode] = 0

        while (nodesToVisit.isNotEmpty()) {
            val node = nodesToVisit.poll()
            visited[node] = true

            adjacencyLists[node]?.forEach {
                if (!visited[it]) {
                    visited[it] = true
                    nodesToVisit.add(it)
                    // this is not needed for this problem
                    previous[it] = node
                    distance[it] = distance[node] + 6
                }
            }
        }

        distance.forEachIndexed { index, value ->
            if (index > 0 && value != 0) {
                result.add(value)
            }
        }

        return result.toTypedArray()
    }

}
