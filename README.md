BracketCombinateService
=======================

Class project. Will autogenerate final four bracket and pick winners. Will allow for user to create own final four or create partial and generate the rest.

Calls:

Team Controller:
http://localhost:8080/teams
http://localhost:8080/teams/{id}

Final Four Controller:
(Will fill in things at random if not provided)

Random Final Four Selection:
http://localhost:8080/FinalFour

Selected Final Four:
http://localhost:8080/FinalFour/pick?teamIDs="1,17,33,49"
http://localhost:8080/FinalFour/teamIDs/{teamIDs}

Random Final Four Champions:
http://localhost:8080/FinalFour/champions

Selected Final Four Champions:
http://localhost:8080/FinalFour/champions/pick?teamIDs="1,17,33,49"&southEastChampion="Florida"&westMidwestChampion="Wichita State"&nationalChampion="Florida"