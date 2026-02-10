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

// This imports the code that runs the servo
import com.qualcomm.robotcore.hardware.Servo;

/**
 * This file contains an example of an iterative (Non-Linear) "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When a selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This upgraded version controls 6 LEDs with an alternating color pattern.
 * Even-numbered LEDs (0, 2, 4) display one color while odd-numbered LEDs (1, 3, 5)
 * display a complementary color, creating a dynamic light show effect.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */
@Autonomous(name="Mentor Jen: Sparkle Party", group="Iterative Opmode")

public class MentorJen_Sparkle_Party extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    // Declare all 6 LED servos
    private Servo led0;
    private Servo led1;
    private Servo led2;
    private Servo led3;
    private Servo led4;
    private Servo led5;

    // Single variable for all LEDs
    private double ledPositionAll;

    // Two position variables for alternating pattern
    // Even LEDs (0, 2, 4) will use ledPositionEven
    // Odd LEDs (1, 3, 5) will use ledPositionOdd
    private double ledPositionEven;
    private double ledPositionOdd;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        // Initialize all 6 LED servos from the hardware map
        led0 = hardwareMap.get(Servo.class, "ledZero");
        led1 = hardwareMap.get(Servo.class, "ledOne");
        led2 = hardwareMap.get(Servo.class, "ledTwo");
        led3 = hardwareMap.get(Servo.class, "ledThree");
        led4 = hardwareMap.get(Servo.class, "ledFour");
        led5 = hardwareMap.get(Servo.class, "ledFive");

        // Tell the driver that initialization is complete
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Info", "6 LEDs ready for sparkle party!");
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

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        double seconds = runtime.seconds();

        // Call the defaultMode method to set the LED colors based on time
        darkMode(seconds);

        // Display the current LED positions and runtime on the driver station
        telemetry.addData("Even LED Position", ledPositionEven);
        telemetry.addData("Odd LED Position", ledPositionOdd);
        telemetry.addData("Status", "Run Time: " + runtime.seconds());
    }

    private void defaultMode(double seconds) {
        // This timing logic controls the color sequence for the light show
        // Based on elapsed time, we set different color values for even and odd LEDs
        // The servo position values correspond to different colors on the LED color wheel

        if (seconds < 2.0 ) {
            ledPositionEven = 0.388;  // Yellow on even LEDs
            ledPositionOdd = 0.611;   // Blue on odd LEDs
        } else if (seconds < 5.0 ) {
            ledPositionEven = 0.444;  // Sage on even LEDs
            ledPositionOdd = 0.555;   // Azure on odd LEDs
        } else if (seconds < 7.0) {
            ledPositionEven = 0.489;  // Green on even LEDs
            ledPositionOdd = 0.722;   // Violet on odd LEDs
        } else if (seconds < 9.0) {
            ledPositionEven = 0.555;  // Azure on even LEDs
            ledPositionOdd = 0.444;   // Sage on odd LEDs
        } else if (seconds < 12.0) {
            ledPositionEven = 0.611;  // Blue on even LEDs
            ledPositionOdd = 0.388;   // Yellow on odd LEDs
        } else if (seconds < 15.0) {
            ledPositionEven = 0.666;  // Indigo on even LEDs
            ledPositionOdd = 0.300;   // Orange on odd LEDs
        } else if (seconds < 17.0) {
            ledPositionEven = 0.722;  // Violet on even LEDs
            ledPositionOdd = 0.280;   // Red on odd LEDs
        } else if (seconds < 19.0) {
            ledPositionEven = 0.615;  // Blue-ish on even LEDs
            ledPositionOdd = 0.444;   // Sage on odd LEDs
        } else if (seconds < 22.0) {
            ledPositionEven = 0.280;  // Red on even LEDs
            ledPositionOdd = 0.722;   // Violet on odd LEDs
        } else if (seconds < 25.0) {
            ledPositionEven = 0.555;  // Azure on even LEDs
            ledPositionOdd = 0.280;   // Red on odd LEDs
        } else if (seconds < 27.0) {
            ledPositionEven = 0.280;  // Red on even LEDs
            ledPositionOdd = 0.722;   // Violet on odd LEDs
        } else if (seconds < 29.0) {
            ledPositionEven = 0.444;  // Sage on even LEDs
            ledPositionOdd = 0.333;   // Orange-ish on odd LEDs
        } else {
            ledPositionEven = 0.388;  // Yellow on even LEDs
            ledPositionOdd = 0.444;   // Sage on odd LEDs
        }

        // Set the position for all 6 LEDs
        // Even LEDs get ledPositionEven, odd LEDs get ledPositionOdd
        led0.setPosition(ledPositionEven);
        led1.setPosition(ledPositionOdd);
        led2.setPosition(ledPositionEven);
        led3.setPosition(ledPositionOdd);
        led4.setPosition(ledPositionEven);
        led5.setPosition(ledPositionOdd);
    }

    private void darkMode(double seconds) {
        // This timing logic controls the color sequence for the light show
        // Based on elapsed time, we set different color values for even and odd LEDs
        // The servo position values correspond to different colors on the LED color wheel

        if (seconds < 2.0 ) {
            ledPositionAll = 0.280;  // Red on all LEDs
        } else {
            ledPositionAll = 0.444;   // Sage on all LEDs
        }

        led0.setPosition(ledPositionAll);
        led1.setPosition(ledPositionAll);
        led2.setPosition(ledPositionAll);
        led3.setPosition(ledPositionAll);
        led4.setPosition(ledPositionAll);
        led5.setPosition(ledPositionAll);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        // Reset all LEDs to white (position 1.0) when the program stops
        led0.setPosition(1.0);
        led1.setPosition(1.0);
        led2.setPosition(1.0);
        led3.setPosition(1.0);
        led4.setPosition(1.0);
        led5.setPosition(1.0);
    }
}
