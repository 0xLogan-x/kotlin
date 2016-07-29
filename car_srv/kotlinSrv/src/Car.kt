import carControl.Control
import carControl.RouteExecutor
import carControl.RouteExecutorImpl.MoveDirection

/**
 * Created by user on 7/27/16.
 */
class Car constructor(routeExecutor: RouteExecutor, controller: Control) {

    val exec: dynamic

    val velocityMove = 0.3278
    val velocityRotation = 12.3

    //position
    var x: Double
    var y: Double
    var angle: Double

    var moveDirection: MoveDirection = MoveDirection.STOP

    val routeExecutor: RouteExecutor
    val controller: Control

    init {
        this.routeExecutor = routeExecutor
        this.controller = controller
        this.x = 0.0
        this.y = 0.0
        this.angle = 0.0
        this.exec = require("child_process").exec
    }

    fun stopCar() {
        move(MoveDirection.STOP, 0.0, {})
    }

    fun refreshLocation(delta: Int) {
        val deltaSeconds = delta.toDouble() / 1000
        when (moveDirection) {
            MoveDirection.FORWARD -> {
                this.x += this.velocityMove * deltaSeconds * Math.cos(this.angle * Math.PI / 180);
                this.y += this.velocityMove * deltaSeconds * Math.sin(this.angle * Math.PI / 180);
            }
            MoveDirection.BACKWARD -> {
                this.x -= this.velocityMove * deltaSeconds * Math.cos(this.angle * Math.PI / 180);
                this.y -= this.velocityMove * deltaSeconds * Math.sin(this.angle * Math.PI / 180);
            }
            MoveDirection.LEFT -> this.angle += velocityRotation * deltaSeconds
            MoveDirection.RIGHT -> this.angle -= velocityRotation * deltaSeconds
            else -> {

            }
        }
//        println("x=$x; y=$y; angle=$angle")
    }

    fun routeDone() {
        controller.stopCar()
    }

    fun move(moveDirection: MoveDirection, value: Double, callBack: () -> Unit) {
        //value - angle for rotation command and distance for forward/backward command
        val functionAfterStty = { error: dynamic, stdOut: dynamic, stdErr: dynamic ->
            if (error != null) {
                println("error in execute stty\n" + error.toString())
            }
            this.moveDirection = moveDirection
            when (moveDirection) {
                MoveDirection.STOP -> controller.stopCar()
                MoveDirection.FORWARD -> controller.moveCarForward()
                MoveDirection.BACKWARD -> controller.moveCarBackward()
                MoveDirection.LEFT -> controller.moveCarLeft()
                MoveDirection.RIGHT -> controller.moveCarRight()
            }
            if (moveDirection != MoveDirection.STOP) {
                if (moveDirection == MoveDirection.FORWARD || moveDirection == MoveDirection.BACKWARD) {
                    controller.delay(getTimeForMoving(value, velocityMove), callBack)
                } else {
                    controller.delay(getTimeForMoving(value, velocityRotation), callBack)
                }
            }
        }

        exec("stty -F ${MicroController.instance.transportFilePath} raw -echo -echoe -echok", functionAfterStty)

    }

    fun getTimeForMoving(value: Double, velocity: Double): Int {
        return (1000 * Math.abs(value) / velocity).toInt()
    }
}