package com.dleal.canteen.domain

import android.support.annotation.StringRes

/**
 * Created by Daniel Leal on 26/2/18.
 */
data class EvaluationSection(
        @StringRes val sectionTitle: Int,
        val fields : List<EvaluationField>
)

data class EvaluationField(
        @StringRes val title : Int,
        val score: Score
)

data class FoodEvaluation(
        val firstDish: Score,
        val secondDish: Score,
        val fruitEating: Score,
        val fishEating: Score,
        val vegetablesEating: Score,
        val eatsAlone: Score,
        val eatingRhythm: Score,
        val observations: String,
        val improvements: String
)

data class HygieneEvaluation(
        val behavior: Score,
        val cutleryUsage: Score,
        val napkinUsage: Score,
        val handWashing: Score,
        val cleansUp: Score,
        val observations: String,
        val improvements: String
)

data class BehaviourEvaluation(
        val respectsRules: Score,
        val respectsControllers: Score,
        val respectsOtherStudents: Score,
        val collaborates: Score,
        val observations: String,
        val improvements: String
)

sealed class Score

object Always : Score()
object Sometimes : Score()
object Never : Score()