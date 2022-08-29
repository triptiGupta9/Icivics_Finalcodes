Feature: MainGamesPage Validation

Scenario: C73 - Game carousel
Given Launch the icivis URL
Then Verify Game carousel appears with 5-6 games

Scenario: C73 - Game carousel left arrow
Given  Verify Carousel goes to previous game

Scenario: C73 - Game carousel right arrow
Given  Carousel goes to next game

Scenario: C73 - Game carousel right arrow
Given Game carousel dots

Scenario: C73 - Game carousel dots navigation
Given Verify Carousel goes the 3rd game

Scenario: C73 - Register banner logged in
Given Verify Banner to register as a student appears for anonymous user
Given Verify when login as a student Banner to register as a student DOES NOT appear
And Verify when login as a teacher Banner to register as a student DOES NOT appear

Scenario: C73 - Register banner button click
Given Verify Goes to link user register?role=student&email=1

Scenario: C73 - Game tiles
Given  Verify Game tile appears for each game and Each tile contains Image Title of game Expected play time Short description

Scenario: C73 - Game tiles click
Given  Verify Click on game tile 

Scenario: C73 - Teacher tile
Given  Verify Green tile with teacher links appears after all games

Scenario: C73 - Teacher tile teach button
Given  Verify on clicking teach button goes to teachers

Scenario: C73 - Teacher tile
Given  Verify Click get started on teachers tile goes to getstarted



