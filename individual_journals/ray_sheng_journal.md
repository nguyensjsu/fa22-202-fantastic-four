# Ray Sheng Journal

## Weekly Scrum Report

### 10-29 to 11-04

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