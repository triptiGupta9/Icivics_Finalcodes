Feature: Individual Games Page Validation

Scenario: C81 - Link to Leaderboard and Achievements
Given Launch the icivis game Argumentwar URL
Then Verify Link to leaderboard and achievements appears

Scenario: C82 - Leaderboard and Achievements
Given Verify Popup dialog appears for leaderboard and achievements

Scenario: C83 - Game load
Given Verify Game loads within iFrame


Scenario: C84 - Educator buttons
Given Verify for logged in as an educator download teacher resources and assign buttons appear

Scenario: C85 - Educator buttons
Given Verify for logged in as an Student download teacher resources and assign buttons appear

Scenario: C86 - Download teacher resources
Given Verify click link to download teacher resources Popup dialog appears with links to teacher resources

Scenario: C87 - Assign button - no classes
Given Verify click link to assign Popup dialog appears with message that the teacher has no classes

Scenario: C88 - Assign button
Given Verify click link to assign Popup dialog appears with form to assign the game

Scenario: C89 - Apple app store button
Given Verify Apple App Store button appears

Scenario: C90 - Link to Apple app store
Given Verify click link to Apple app store Page goes to Apple app store with the correct game


Scenario: C91 - Google play store button
Given Verify Google Play Store button appears

Scenario: C92 - Link to Google play store
Given Verify click link to Google play store Page goes to Google play store with the correct game

Scenario: C93 - Extension pack section
Given Verify Go to game page Extension pack link appears

Scenario: C94 - Extension pack section
Given Verify Go to game page, not logged in or logged in as a student Extension pack link DOES NOT appear

Scenario: C95 - Link to extension pack
Given Verify click link to extension pack Page goes to lesson plan containing game extension pack

Scenario: C96 - Learning objectives section
Given Verify Go to game page Learning objectives section appears

Scenario: C97 - Extension pack section
Given Verify Go to game page not logged in Learning objectives section DOES NOT appear
Then Verify Go to game page logged in as a student Learning objectives section DOES NOT appear









