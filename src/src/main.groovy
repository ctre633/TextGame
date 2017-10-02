Room startRoom = new Room(
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

Map<Integer, Room> rooms = [1:startRoom, 2:roomTwo, 3:roomThree, 4:roomFour, 5:roomFive]

Boolean keepPlaying = true

while(keepPlaying){

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
    print "Enter room number: "
    def userInput = br.readLine()

    if(userInput == "q"){
        println "Quitting..."
        keepPlaying = false
    }else if(!userInput){
        println "Choice can't be empty. Please try again."
    }else if(!userInput.isInteger()){
        println "Please enter a number."
    }else {
        Room room = rooms.get(userInput as Integer)
        if(room){
            println "Welcome to " + room.title
        } else {
            println "Sorry, room doesn't exist."
        }
    }
}