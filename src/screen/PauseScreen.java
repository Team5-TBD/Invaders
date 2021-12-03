package screen;

import engine.Cooldown;
import engine.Core;

import java.awt.event.KeyEvent;

public class PauseScreen extends Screen {

    /** Milliseconds between changes in user selection. */
    private static final int SELECTION_TIME = 200;

    /** Time between changes in user selection. */
    private Cooldown selectionCooldown;

    /**
     * Constructor, establishes the properties of the screen.
     *
     * @param width
     *            Screen width.
     * @param height
     *            Screen height.
     * @param fps
     *            Frames per second, frame rate at which the game is run.
     */
    public PauseScreen(final int width, final int height, final int fps) {
        super(width, height, fps);

        this.returnCode = 0;
        this.selectionCooldown = Core.getCooldown(SELECTION_TIME);
        this.selectionCooldown.reset();
    }

    @Override
    public final void initialize() {
        super.initialize();
    }

    /**
     * Starts the action.
     *
     * @return Next screen code.
     */
    public final int run() {
        super.run();

        return this.returnCode;
    }

    /**
     * Updates the elements on screen and checks for events.
     */
    protected final void update() {
        super.update();

        draw();
        if (this.selectionCooldown.checkFinished()
                && this.inputDelay.checkFinished()) {
            if (inputManager.isKeyDown(KeyEvent.VK_LEFT)) {
                previousMenu();
                this.selectionCooldown.reset();
            }
            if (inputManager.isKeyDown(KeyEvent.VK_RIGHT)){
                nextMenu();
                this.selectionCooldown.reset();
            }
            if (inputManager.isKeyDown(KeyEvent.VK_SPACE))
                this.isRunning = false;
        }

    }

    private void nextMenu() {
        if (this.returnCode == 1)
            this.returnCode = 0;
        else
            this.returnCode++;
    }

    private void previousMenu() {
        if (this.returnCode == 0)
            this.returnCode = 1;
        else
            this.returnCode--;
    }

    /**
     * Draws the elements associated with the screen.
     */
    private void draw() {
        drawManager.initDrawing(this);

        drawManager.drawPause(this, this.returnCode);
        drawManager.drawText(this, new String[]{"DO YOU WANT", "EXIT?"});

        drawManager.completeDrawing(this);
    }
}
