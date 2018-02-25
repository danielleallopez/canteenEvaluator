package com.dleal.canteen.domain

/**
 * Created by Daniel Leal on 26/2/18.
 */
sealed class Evaluation

object Always : Evaluation()
object Sometimes : Evaluation()
object Never : Evaluation()