# Ray Sheng Journal

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