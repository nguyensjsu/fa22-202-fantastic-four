# Ray Sheng Journal

## Note:
- problem: no more new enemies after boss fight
- problem: when player is killed in boss fight, boss still moves and shoots in game over screen

## Weekly Scrum Report

### Week 4

- refactor fighter class to handle life loss using chain of responsibility: 2 hours
- add fighter powerup states to accommodate fire support status: 2 hours
- apply State pattern in fighter behavior code to handle fighter powerup status: 1 hour

- add fire support strat 0: none
- add fire support 1 drop
- add fire support 2 drop
- add shield powerup drop
- change drop mechanism for enemies to accommdate new powerups

- add sound effect for fire support strat 2
- change sprites for powered up fighter

- randomize fire support 2 missile starting x values
- add fire support strat 3: crossfire - tabled for now, implement if there is time later

### Week 3

- add fire support to fighter - done
- add fire support base strat - done
- add custom movement laser -done
- add fire support strat 1 - done
- add Timer mechanism for non-actor/non-world objects - done
- add fire support strat 2 - done

### Week 2

#### Scrum Report

##### Tasks Worked on

- Extended enemy classes to drop powerups on death
- Refactored player object class to accommodate health pick up effect
- Implemented health pick up feature

##### Tasks to Work on Next

- Design 4 more powerup features
- Implement 2 more powerup features

#### XP Core Value: Respect

The team has been respectful towards one another's ideas and opinions. As we worked on the planned features and gained better understanding of the adopted codebase, ideas for those features evolved. We were respectful of each team member's expertise on his part of the codebase, and trusted one another to modify the specific implementations of the previously discussed plans. As a result, each team member's creativity was being utilized to a fuller extent, and we were even more enthusiastic than before about the additions we were making to the game.

### Week 1

#### Scrum Report

##### Tasks Worked on
- Dived into Greenfoot documentations and followed Greenfoot tutorials to learn how it works and how to use it
- Searched for open-source code that we would use as a foundation for the project; explored different projects to compare their feasibility
- Met with the team to discuss and finalize a project to work on
	- We decided to improve [a classic space-shooter clone made by someone else](https://www.greenfoot.org/scenarios/25287)
- Collectively brainstormed new features to add to the base game

##### Tasks to Work on Next
- Add power-up pickup feature to game
- Add power-up effects to game
- Organize and update scrum board/burndown chart

##### Blockers
- No real blockers for this ideation phase of the project, the only minor difficulty was finding a time when everyone was available to discuss project ideas and make the initial decisions to get the work started.

#### XP Core Value: Respect

All team members have been respectful of everyone's time. Before we started working on the project, we needed to have a lengthy discussion to finalize ideas and lay out the details of what we will do. In order to schedule a meeting for this, everyone informed the team of his own time availability. It turns out that initially we didn't have a good time slot during the week when everyone was available. So those with schedules that were a little more flexible were able to accommodate those with more rigid schedules, and we were able to resolve the scheduling conflict in a respectful way.

When we came together to discuss and decide on the project details, everyone was respectful of one another's opinions. During the brainstorming session, when someone would have questions or concerns with a proposed feature or idea, we were able to voice them in a respectful way. As a result, we ended up with a plan that was acceptible to everyone.


## Quick notes - delete later

### Research ideas

#### base game candidates:

- [Galaga clone](https://www.greenfoot.org/scenarios/25287)
- [Space Invader clone](https://www.youtube.com/watch?v=JeVtaL55-z8)

#### universal features ideas:

- experience points/level up system
	- use Observer pattern: enemies are subject, player object is oberserver, when enemy gets hit, notify observer to add exp
- change bgm or on-screen effects based on state
	- for example: background image and music change when health is low
	- use State pattern to keep track of state if multivariable
	- use Observer pattern: player object is subject, app controller is observer, notify observer when player object state changes
- switch to a different attack or action mode
	- for example: think Contra's different weapons, changing the behavior of the shoot button
	- use Strategy pattern: swap in a different strategy for behavior on button press