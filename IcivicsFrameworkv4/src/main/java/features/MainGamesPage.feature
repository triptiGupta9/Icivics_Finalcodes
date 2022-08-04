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

Scenario: C73 - Register banner not logged in
Given Verify Banner to register as a student appears

Scenario: C73 - Register banner logged in
Given Verify when login as a student Banner to register as a student DOES NOT appear
And Verify when login as a teacher Banner to register as a student DOES NOT appear


