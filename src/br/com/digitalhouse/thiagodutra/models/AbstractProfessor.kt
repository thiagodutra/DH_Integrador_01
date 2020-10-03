package br.com.digitalhouse.thiagodutra.models

import java.util.*

abstract class AbstractProfessor {

    lateinit var name : String
    lateinit var surname : String
    var code : Int = 0
    lateinit var time : Date

}