package engine;

import screen.GameScreen;
import screen.PauseScreen;
import screen.Screen;

import java.util.logging.Logger;

public final class Pause extends Thread{
    /** Width of current screen. */
    private static final int WIDTH = 258;
    /** Height of current screen. */
    private static final int HEIGHT = 300;
    /** Frame to draw the screen on. */
    private static Frame frame;
    /** Screen currently shown. */
    private Screen ShowScreen;
    /** Application logger. */
    private static final Logger LOGGER = Logger.getLogger(Core.class
            .getSimpleName());
    /** Screen is not shown. This screen is for game, and slept by using thread. */
    private final GameScreen gameScreen;
    /** To select option. */
    public static int returnCode;

    /**
     * Constructor
     * save GameScreen Obj
     *
     * @param gameScreen
     *          is Stopped Thread
     */
    public Pause(final GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }

    public void run() {
        frame = new Frame(WIDTH, HEIGHT);
        DrawManager.getInstance().setFrame(frame);
        ShowScreen = new PauseScreen(WIDTH, HEIGHT, Core.getFps());
        LOGGER.info("Starting show Pause Screen");
        returnCode = frame.setScreen(ShowScreen);

        switch (returnCode) {
            case 0:
                // Resume played game and close pause screen
                // 멈춰놨던 스레드 다시 기동 및 일시정지 창 닫기
                LOGGER.info("Resume game screen.");
                frame.dispose();
                gameScreen.restart();
                break;

            case 1:
                // Exit to main menu and close pause screen
                // Main menu 로 이동
                LOGGER.info("Closing pause screen.");
                frame.dispose();
                gameScreen.changeLives(0); // Make game over
                gameScreen.changeIsRunning(false);
                gameScreen.restart();
                break;

            default:
                break;
        }
    }

    public GameScreen getGameScreen(){
        return gameScreen;
    }



}
