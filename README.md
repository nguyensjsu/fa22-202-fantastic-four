# Fantastic Four

## Team members

| Name          |  XP Core Value  |
| ------------- | --------------- |
| Yikang Chen   |                 |
| Jianle Li     | Communication   |
| Ray Sheng     |                 |
| Yiyang Yin    |                 |

## About the project
### Description 
Ray

### Feature Set
Yiyang

### How to run this project
- Option 1: Playing [online]()
- Option 2:
  * Install [Greenfoot](https://www.greenfoot.org/download)
  * Clone this [repository](https://github.com/nguyensjsu/fa22-202-fantastic-four)
  * Run `project.greenfoot` inside the src folder

## Project videos
12/3 meeting
* [User Story Video]()
* [Project Demo Video]()
* [Stand-up meeting]()
* [Retrospective meeting]()

## Project architecture
### UI Wireframes
Jianle
* Start Screen
* Game Screen
* Game Over Screen
Yiyang
* LeaderBoard Screen

### High level diagrams
#### Architecture Diagram
Yiyang

#### Component diagram
Yikang

#### State diagram
Ray

## Key feature designs
### Yikang Chen

### Jianle Li

### Ray Sheng

### Yiyang Yin

## Project backlog and chart
* Sprint Task Sheet
* Burn down chart
* Weekly Scrum Task Board
Yiyang
   * Week 1

   * Week 2

   * Week 3

   * Week 4

## Individual Contributions and team journals
### Contributions

* Yikang Chen

* Jianle Li
  * In this project, I am primarily responsible for functions pertaining to enemies and have mostly enhanced three features:
    1) The enemies' appearances has transitioned from a `one-time appearance` to a `steady appearance`. 
    2) The enemies will select its way of movement at random toward to player. It can choose three different movement methods, which are: `Stay still(default)`, `Move Vertically Down` and `Move Toward The Player`. (Strategy pattern is in used here.)
       * `Strategy Pattern `
         * For each movement method (or algorithm), we use a separate class for encapsulation. These algorithms are also interchangeable. So it is very suitable to use strategy pattern. This pattern makes the program very scalable. If we suddenly want to add a new movement method, we only need to add a new class.
         * Class Diagram for this will be show as following：![strategy pattern](images/EnemyMovingStrategy.png 'strategy pattern')
    3) Refactoring enemies lives implementation. Allowing enemies to `upgrade its level` (More lives)  (Decorator pattern is in used here.)
       * `Decorator Pattern`
         * The original enemy, whether it is Goei or Zako, has a health value of 1 and will disappear after being hit by a laser.
         In order to strengthen/extend the functions related to enemy life, we use the decorator pattern to divide the enemy into three levels:`Normal Enemy One Life`, `Elite Enemies Two Lives` and `Boss multiple lives`.
         * In different stages of the game, there will be different levels of enemies. That is to say, when creating an enemy object, use different life decorators to decorate the enemy object.
           Use `EnemyOneLifeDecorator` for normal enemies, `EnemyTwoLifeDecorator` for elite enemies, and `EnemyThreeLifeDecorator` for bosses.
         * Class Diagram for this will be show as following：![decorator pattern](images/EnemyLifeDecorator.png 'decorator pattern')
    4) (Pending work) By reading the current score of the player, the monster may be upgraded further (an upgraded version realized by the third features above).
       1) Each 500/1000 score is separated into several interval. Each interval has a unique assortment of enemies. The number of enemies at each interval grows, as does their speed. 
       2) Before reaching a specific score, the boss will not emerge.

* Ray Sheng

* Yiyang Yin

### Journals
- Yikang Chen - [Member Journal](/individual_journals/yikang_chen_journal.md)
- Jianle Li - [Member Journal](/individual_journals/jianle_li_journal.md)
- Ray Sheng - [Member Journal](/individual_journals/ray_sheng_journal.md)
- Yiyang Yin - [Member Journal](/individual_journals/yiyang_yin_journal.md)