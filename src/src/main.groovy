Room startRoom = new Room(
        westWall: "There is a door to your left",
        eastWall: "There is a door to your right"
)

println "You wake up in a cold, dimly lit room.  As you try to recall how you got here you take a look around."
println "There isn't much to the room except a bare stone floor and roof. You do notice two doors though."
println "${startRoom.eastWall}"
println "${startRoom.westWall}"