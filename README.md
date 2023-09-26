# Math Game
Math game that asks you simple multiplying, dividing, subtraction, and addition questions
## Functionality
The following **required** functionality is completed
* user starts by seeing the selector screen
* user can pick easy medium or hard difficulties
* user can pick addition, multiplication, subtraction, and division
* easy mode is from 0 - 10
* medium mode is from 0 - 25
* hard mode is from 0 - 50
* if the user presses the start button on the first screen and have picked how many questions they want,which operator,and a diffculty they will be sent to a new screen
* on this screen the user sees a editText box a submit button and text
* the user sees a question and then will answer it in the text box
* if the user doesnt not provide a number answer a toast will appear asking the user enters a valid input
* if the user gets the answer correct a correct sound and toast will appear
* if the user gets the answer wrong a wrong sound and toast will appear
* after the user answers all the questions they get returned to the orginal screen
* now the screen will have text saying how many questions they had and how many they got right
* if they get under 80% correct the text is red and says you should practice more
* if they get over 80% correct the text is gray and says good job
The following **extensions** are added
* when doing division the game rounds every answer to a hundreth and tells the user to do so through a toast
## Video Walkthrough
![mathGame2](https://github.com/shargent152/Math-Game/assets/125781283/503fd2b7-f002-477f-be4c-5fab20cdcbdf)
## Notes
* I did struggle thinking through some of the math logic then i realized it only had to run when the submit button was pushed
* doing the rounding for division was diffcult but once i figured it out it was a breeze
* the UI on the first screen was hard for me to do
* I struggle adding the textView into the app
## License

    Copyright 2023 Trevor Peevers

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
