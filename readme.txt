Tennis Database Manager Instructions V1.0
Author: William Wakefield
Updated: 2 May, 2019

Current program needs to be either executed with an IDE or via the terminal with javac "Assignment1.java'

Input file with Tennis Players Data and Matches must follow the following format: 

Player entry: 
			PLAYER/<PLAYERID>/<FIRST NAME>/<LAST NAME>/<birthyear yyyy>/<COUNTRY>
		Match entry:
			MATCH/<player1 id>/<player2 id>/<date yyyymmdd>/<TOURNAMENT>/<scores, separated by commas e.g. 6-3,6-7,6-21>

Commands are numbers as follows:

1 --> Print all tennis players
2 --> Print all tennis matches of a player
3 --> Print all tennis matches.
4 --> Insert a tennis player.
5 --> Insert a tennis match.
9 --> Exit

The program will also print out these available commands each time they are full executed for your convenience.

Each command will also instruct you on what you need to input to add to the Tennis Database.

Bugs needed to be patched in next update:
	- Command 5: A type-safe error is printed to console before user provides an input. User can still continue with desired action