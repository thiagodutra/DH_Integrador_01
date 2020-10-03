package br.com.digitalhouse.thiagodutra.models

import java.util.*

class Matricula(aluno: Aluno, curso:Curso) {

    var aluno: Aluno;
    var curso: Curso;
    var dataMatricula: Date;

    init {
        this.dataMatricula = Date()
        this.aluno = aluno;
        this.curso = curso;
        this.dataMatricula = Date()
    }
}