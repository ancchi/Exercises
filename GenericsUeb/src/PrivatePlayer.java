/**
 * Created by afischer on 19/12/2016.
 */
public class PrivatePlayer {


    private String name;
    private Pocket leftPocket;
    private Pocket rightPocket;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pocket getLeftPocket() {
        return leftPocket;
    }

    public void setLeftPocket(Pocket leftPocket) {
        this.leftPocket = leftPocket;
    }

    public Pocket getRightPocket() {
        return rightPocket;
    }

    public void setRightPocket(Pocket rightPocket) {
        this.rightPocket = rightPocket;
    }
}
