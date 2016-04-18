/**
 *  This is where the states will be represented
 *  and will make us know which layout has to be
 *  shown and which not
 *  States :
 *      1. Init
 *          Start : game
 *          Option : key binding, skin
 *          About : about devs
*           Quit : game
 *      2. About
 *      3. In Game
 *      4. Pause
 *          Continue
 *          Quit
 *      5. Game Over
 *
 *  Singleton : http://thecodersbreakfast.net/index.php?post/2008/02/25/26-de-la-bonne-implementation-du-singleton-en-java
 */

/** GAME MANAGER : class */
public class GameManager {

    /** enum */
    enum GameStates{
        Init, About,
        InGame, Pause,
        GameOver
    }

    /** SINGLETON PATTERN */
    //will need modification : overly generic pattern
    /** constructor */
    private GameManager(){}
    /** methods */
    //HOLDER
    private static class GameManagerHolder{
        //UNIQUE NO PRE-INITIALIZED INSTANCE
        private final static GameManager instance = new GameManager();
    }
    //UNIQUE INSTANCE SINGLETON ACCESS POINT
    public static GameManager getInstance(){
        return GameManagerHolder.instance;
    }



}
