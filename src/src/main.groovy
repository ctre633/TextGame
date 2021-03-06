//Create the rooms for the game
Room roomOne = new Room(
        roomId: 1,
        title: "room 1",
        description: "This is the starting room."
)

Room roomTwo = new Room(
        roomId: 2,
        title: "room 2",
        description: "This is room two."
)

Room roomThree = new Room(
        roomId: 3,
        title: "room 3",
        description: "This is room three."
)

Room roomFour = new Room(
        roomId: 4,
        title: "room 4",
        description: "This is room four."
)

Room roomFive = new Room(
        roomId: 5,
        title: "room 5",
        description: "This is room five."
)
//Add connections to different rooms
roomOne.connections = ['e':roomThree, 'w':roomTwo]
roomTwo.connections = ['e':roomOne, 'n':roomFour]
roomThree.connections = ['w':roomOne, 's':roomFive]
roomFour.connections = ['s':roomTwo]
roomFive.connections = ['n':roomThree]

//create variables needed outside of while loop
Boolean keepPlaying = true
def currentRoom = roomOne

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