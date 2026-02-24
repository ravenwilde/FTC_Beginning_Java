/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

// this imports the code that runs the servo
import com.qualcomm.robotcore.hardware.Servo;

/**
 * This file contains an example of an iterative (Non-Linear) "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When a selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.

 * It includes all the skeletal structure that all iterative OpModes contain.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */
@Autonomous(name="Khloe: Sparkle Party", group="Iterative Opmode")

public class Khloe_Sparkle_Party extends OpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private Servo led0;
    private Servo led1;
    private Servo led2;
    private Servo led3;
    private Servo led4;
    private Servo led5;
    private double ledPositionEven;
    private double ledPositionOdd;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    //Add Kool LED types not colors tho yet
    @Override
    public void init() {
        led0 = hardwareMap.get(Servo.class, "ledZero");
        led1 = hardwareMap.get(Servo.class, "ledOne");
        led2 = hardwareMap.get(Servo.class, "ledTwo");
        led3 = hardwareMap.get(Servo.class, "ledThree");
        led4 = hardwareMap.get(Servo.class, "ledFour");
        led5 = hardwareMap.get(Servo.class, "ledFive");

        //  ledPosition = 0.0;
        // Tell the driver that initialization is complete.
        //  telemetry.addData("Status", "LED Position", position);
        telemetry.addData("Status", "Initialized");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {

    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }
    private void basicMode(double seconds) {
        // Ya so this show that if its lower than like 2 secounds, making the LED
        //position, or color but theirs an weel that makes the colors, so this shows that if
        //its like under 2 secounds, than it turns YELLOWOWOOWOWOW *ahem* I mean, uh, yellow,
        //if its under 5 secounds, sage, ect. and continues onward into a rainbow
        if (seconds < 2.0 ) {
            ledPositionEven = 0.388; // yellow
            ledPositionOdd = 0.611;
        } else if (seconds < 5.0 ) {
            ledPositionEven = 0.444; // sage
            ledPositionOdd = 0.555;
        } else if (seconds < 7.0) {
            ledPositionEven = 0.489; //green
            ledPositionOdd = 0.722;
        } else if (seconds < 9.0) {
            ledPositionEven = 0.555; //Azurere
            ledPositionOdd = 0.444;
        } else if (seconds < 12.0) {
            ledPositionEven = 0.611; //BLUE
            ledPositionOdd = 0.444;
        } else if (seconds < 15.0) {
            ledPositionEven = 0.666; //Indigo
            ledPositionOdd = 0.300;
        } else if (seconds < 17.0) {
            ledPositionEven = 0.722; //Voilet
            ledPositionOdd = 0.280;
        } else if (seconds < 19.0) {
            ledPositionEven = 0.615;
            ledPositionOdd = 0.444;
        } else if (seconds < 22.0) {
            ledPositionEven = 0.280;
            ledPositionOdd = 0.722;
        } else if (seconds < 25.0) {
            ledPositionEven = 0.555;
            ledPositionOdd = 0.280;
        } else if (seconds < 27.0) {
            ledPositionEven = 0.280;
            ledPositionOdd = 0.722;
        } else if (seconds < 29.0) {
            ledPositionEven = 0.444;
            ledPositionOdd = 0.333;
        } else if (secounds < 32.0) {
            ledPositionEven = 0.666;
            ledPositionOdd = 0.722;
        } else if (secounds < 35.0) {
            ledPositionEven = 0.500;
            ledPositionOdd = 0.722;
        } else {
            ledPositionEven = 0.388;
            ledPositionOdd = 0.444;
        }
    }
    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        double seconds = runtime.seconds();

        basicMode(seconds);

        darkMode(seconds);

// I'm not completely sure on this one, but I beleive it means it adds the run time data with the led
//position, and uses the secounds to determin the roaton
        telemetry.addData("Run Time (ledPosition): ", ledPositionEven);
        telemetry.addData("Run Time (ledPosition): ", ledPositionOdd);
        telemetry.addData("Status", "Run Time: " + runtime.seconds());
        //HI I'M PAST YOU FOM 2026 6:20 JAN SOMTHINGY IDK :3
        led0.setPosition(ledPositionEven);
        led1.setPosition(ledPositionOdd);
        led2.setPosition(ledPositionEven);
        led3.setPosition(ledPositionOdd);
        led4.setPosition(ledPositionEven);
        led5.setPosition(ledPositionOdd);

    }

    private void darkmode (double seconds) {
    } else if (secounds < 0.00) {
        ledPositionEven = 0.489;
        ledPositionOdd = 0.555;
    } else if (secounds < 3.00)
    }   ledPositionEven =
    //Do u like....I forget now aw man y I forget
    } else if (secounds < 2.0) {

/*
 * LED CONTROL METHOD #1: setAllLEDs (no parameters)
 *
 * Uses the class variables ledPositionEven and ledPositionOdd
 * Best when: You've already calculated the colors elsewhere
 */
private void setAllLEDs() {
    led0.setPosition(ledPositionEven);
    led1.setPosition(ledPositionOdd);
    led2.setPosition(ledPositionEven);
    led3.setPosition(ledPositionOdd);
    led4.setPosition(ledPositionEven);
    led5.setPosition(ledPositionOdd);
}

/*
 * LED CONTROL METHOD #2: setAllLEDs with parameters
 *
 * Takes the even and odd positions as parameters
 * Best when: You want to set colors directly without using class variables
 *
 * Example usage: setAllLEDs(0.388, 0.611);
 *
 * Note: This is called "method overloading" - same name, different parameters
 */
private void setAllLEDs(double evenPosition, double oddPosition) {
    led0.setPosition(evenPosition);
    led1.setPosition(oddPosition);
    led2.setPosition(evenPosition);
    led3.setPosition(oddPosition);
    led4.setPosition(evenPosition);
    led5.setPosition(oddPosition);
}

/*
 * LED CONTROL METHOD #3: setAllLEDsSameColor
 *
 * Sets ALL LEDs to the same color (no alternating pattern)
 * Best when: You want a solid color across all LEDs
 *
 * Example usage: setAllLEDsSameColor(0.500);  // All green
 */
private void setAllLEDsSameColor(double position) {
    led0.setPosition(position);
    led1.setPosition(position);
    led2.setPosition(position);
    led3.setPosition(position);
    led4.setPosition(position);
    led5.setPosition(position);
}

/*
 * BONUS METHOD: setIndividualLED
 *
 * Sets a specific LED by number (0-5)
 * Useful for creating chase patterns or targeting specific LEDs
 *
 * Example usage: setIndividualLED(2, 0.722);  // Set LED 2 to violet
 */
private void setIndividualLED(int ledNumber, double position) {
    switch(ledNumber) {
        case 0:
            led0.setPosition(position);
            break;
        case 1:
            led1.setPosition(position);
            break;
        case 2:
            led2.setPosition(position);
            break;
        case 3:
            led3.setPosition(position);
            break;
        case 4:
            led4.setPosition(position);
            break;
        case 5:
            led5.setPosition(position);
            break;
    }
}
/*
         * Code to run ONCE after the driver hits STOP
         */
        @Override
        public void stop() {
            led0.setPosition(1.0);
        }
//I beleive this is to rest the color and LED positon after its turned off to white
        /* Test Edit Test Boo */
    }
