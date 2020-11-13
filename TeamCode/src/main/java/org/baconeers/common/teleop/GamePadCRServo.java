package org.baconeers.common.teleop;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;


/**
 * Operation to assist with Gamepad actions on DCMotors
 */
public class GamePadCRServo extends BaconComponent {

    private final ButtonControl forwardControl;
    private final ButtonControl reverseControl;
    private final CRServo crservo;
    private final Gamepad gamepad;
    private final float crservopower;
    private boolean crservoOn = false;
    private boolean lastButtonState = false;
    private final Telemetry.Item item;


    /**
     * Constructor for operation.  Telemetry enabled by default.
     *
     * @param opMode
     * @param gamepad        Gamepad
     * @param motor          DcMotor to operate on
     * @param forwardControl {@link ButtonControl}
     * @param power          power to apply when using gamepad buttons
     * @param showTelemetry  display the power values on the telemetry
     */
    public GamePadCRServo(BaconOpMode opMode, Gamepad gamepad, CRServo crservo,
                          ButtonControl forwardControl, ButtonControl reverseControl,
                          float power, boolean showTelemetry) {
        super(opMode);

        this.gamepad = gamepad;
        this.crservo = crservo;
        this.forwardControl = forwardControl;
        this.reverseControl = reverseControl;
        this.crservopower = power;

        if (showTelemetry) {
            item = opMode.telemetry.addData("Control " + forwardControl.name(), 0.0f);
            item.setRetained(true);
        } else {
            item = null;
        }
    }

    public GamePadCRServo(BaconOpMode opMode, Gamepad gamepad, CRServo crservo,
                          ButtonControl forwardControl, ButtonControl reverseControl, float power) {
        this(opMode, gamepad, crservo, forwardControl, reverseControl, power, true);
    }


    /**
     * Update servo with latest gamepad state
     */
    public void update() {
        // Only toggle when the button state changes from false to true, ie when the
        // button is pressed down (and not when the button comes back up)
        double direction = 0.0;
        if (buttonPressed(gamepad, forwardControl)) {
            direction = 1.0;
        } else if (buttonPressed(gamepad, reverseControl)) {
            direction = -1.0;
        }
        double power = direction * crservopower;
        crservo.setPower(power);
        if (item != null) {
            item.setValue(power);
        }
        getOpMode().telemetry.log().add("%s crservo: %.2f", forwardControl.name(), power);
    }
}
