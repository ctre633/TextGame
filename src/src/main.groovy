//Create the rooms for the game
//Naming is as follows r = room L = level ex. room 1 Level 1 = r1L1
//L1 is top
Room r1L1 = new Room(
        roomId: 1,
        title: "room 1",
        description: "This is the starting room."
)

Room r2L1 = new Room(
        roomId: 2,
        title: "room 2",
        description: "This is room two."
)

Room r3L1 = new Room(
        roomId: 3,
        title: "room 3",
        description: "This is room three."
)

Room r4L1 = new Room(
        roomId: 4,
        title: "room 4",
        description: "This is room four."
)

Room r1L2 = new Room(
        roomId: 5,
        title: "room 5",
        description: "This is room five."
)

Room r2L2 = new Room(
        roomId: 6,
        title: "room 6",
        description: "This is room six."
)

Room r3L2 = new Room(
        roomId: 7,
        title: "room 7",
        description: "This is room seven."
)

Room r4L2 = new Room(
        roomId: 8,
        title: "room 8",
        description: "This is room eight."
)
//Add connections to different rooms
r1L1.connections = ['e':r2L1, 's':r3L1, 'down':r1L2]
r2L1.connections = ['w':r1L1, 's':r4L1, 'down':r2L2]
r3L1.connections = ['n':r1L1, 'e':r4L1, 'down':r3L2]
r4L1.connections = ['n':r2L1, 'w':r3L1, 'down':r4L2]
r1L2.connections = ['e':r2L2, 's':r3L2, 'up':r1L1]
r2L2.connections = ['w':r1L2, 's':r4L2, 'up':r2L1]
r3L2.connections = ['n':r1L2, 'e':r4L2, 'up':r3L1]
r4L2.connections = ['n':r2L2, 'w':r3L2, 'up':r4L1]

//create variables needed outside of while loop
Boolean keepPlaying = true
def currentRoom = r1L1
Boolean invertedMap = false
//while loop for game code
while(keepPlaying){

    //Create a user input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
    println "Welcome to $currentRoom.title"
    println "You see exits to the ${currentRoom.connections.keySet()}"
    println "Where would you like to go? "
    def userInput = br.readLine()

    //If statement for exiting the game or incorrect inputs
    if(userInput == "q"){
        println "Quitting..."
        keepPlaying = false
    }else if(!userInput){
        println "Choice can't be empty. Please try again."
    }else if(userInput.isInteger()){
        println "Please enter a directions (n, s, e, w)."
    }else {
        Room room = currentRoom.connections.get(userInput)
        if(room){
            currentRoom = room
        } else {
            println "You can't go that way."
        }
    }
}