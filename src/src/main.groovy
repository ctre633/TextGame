import NPC.Npc

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

//Create NPC's (Monsters) for the game
Npc commonMonster = new Npc(
        name: "Epically small monster",
        health: 100,
        isAggresive: true,
        multiplier: 2
)

Npc rareMonster = new Npc(
        name: "Epically medium monster",
        health: 150,
        isAggressive: true,
        multiplier: 4
)

Npc bossMonster = new Npc(
        name: "Epically epic monster",
        health: 200,
        isAggressive: true,
        multiplier: 6
)

//Create NPC's(Friendly)
Npc healer = new Npc(
        name: "Feels Good Man",
        health: 100,
        isAggressive: false,
        multiplier: 6
)

Npc justAGuy = new Npc(
        name: "Just a guy",
        health: 100,
        isAggressive: false,
        multiplier: 4
)

Npc uselessPerson = new Npc(
        name: "Basically useless person",
        health: 100,
        isAggressive: false,
        multiplier: 2
)

//Add connections to different rooms
roomOne.connections = ['e':roomThree, 'w':roomTwo]
roomTwo.connections = ['e':roomOne, 'n':roomFour]
roomThree.connections = ['w':roomOne, 's':roomFive]
roomFour.connections = ['s':roomTwo]
roomFive.connections = ['n':roomThree]

//Add NPC's to rooms
roomTwo.npcList = [commonMonster, uselessPerson]
roomFour.npcList = [commonMonster, rareMonster, justAGuy]
roomThree.npcList = [commonMonster, uselessPerson]
roomFive.npcList = [commonMonster, rareMonster, justAGuy]

//create variables needed outside of while loop
Boolean keepPlaying = true
def currentRoom = roomOne
Integer playerHealth = 100

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
    }

    else if(playerHealth == 0){
        println "You have died..."
        keepPlaying = false
    }

    else if(!userInput){
        println "Choice can't be empty. Please try again."
    }

    else if(userInput.isInteger()){
        println "Please enter a directions (n, s, e, w)."
    }

    else {
        Room room = currentRoom.connections.get(userInput)
        if(room){
            currentRoom = room
        } else {
            println "You can't go that way."
        }
    }
}