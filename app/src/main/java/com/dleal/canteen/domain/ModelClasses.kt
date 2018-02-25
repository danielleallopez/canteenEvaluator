package com.dleal.canteen.domain

import java.util.Date

/**
 * Created by Daniel Leal on 26/2/18.
 */
data class Student(
        val name: String,
        val surname: String,
        val birthday: Date
)

data class FoodEvaluation(
        val firstDish: Evaluation,
        val secondDish: Evaluation,
        val fruitEating: Evaluation,
        val fishEating: Evaluation,
        val vegetablesEating: Evaluation,
        val eatsAlone: Evaluation,
        val eatingRhythm: Evaluation,
        val observations: String,
        val improvements: String
)

data class HygieneEvaluation(
        val behavior: Evaluation,
        val cutleryUsage: Evaluation,
        val napkinUsage: Evaluation,
        val handWashing: Evaluation,
        val cleansUp: Evaluation,
        val observations: String,
        val improvements: String
)

data class BehaviourEvaluation(
        val respectsRules: Evaluation,
        val respectsControllers: Evaluation,
        val respectsOtherStudents: Evaluation,
        val collaborates: Evaluation,
        val observations: String,
        val improvements: String
)