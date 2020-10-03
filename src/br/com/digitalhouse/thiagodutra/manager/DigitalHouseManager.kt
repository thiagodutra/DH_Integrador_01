package br.com.digitalhouse.thiagodutra.manager

import br.com.digitalhouse.thiagodutra.models.*

class DigitalHouseManager {

    var listaAlunos = mutableListOf<Aluno>()
    var listaProfessores = mutableListOf<AbstractProfessor>()
    var listaCursos = mutableListOf<Curso>()
    var listaMatricula = mutableListOf<Matricula>()

    fun registrarCurso(name: String, code: Int, maxAluno: Int) {
        var newCurso = Curso()
        newCurso.maxAlunos = maxAluno
        newCurso.code = code
        newCurso.name = name
        if (!listaCursos.contains(newCurso)) {
            listaCursos.add(newCurso)
        }
    }

    fun excluirCurso(codigo: Int) {
        val curso = listaCursos.filter { it.code.equals(codigo) }
        listaCursos.removeAll(curso);
    }

    fun resgistrarProfessorAdjunto(nome: String, sobrenome: String, codigo: Int, qntdHora: Int) {
        var newProfessor = ProfessorAdjunto();
        newProfessor.name = nome;
        newProfessor.surname = sobrenome
        newProfessor.quantidadeHoras = qntdHora
        newProfessor.code = codigo
        if (!listaProfessores.contains(newProfessor)) {
            listaProfessores.add(newProfessor)
        }
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigo: Int, especilidade: String) {
        var newProfessor = ProfessorTitular();
        newProfessor.name = nome;
        newProfessor.surname = sobrenome
        newProfessor.especialty = especilidade
        newProfessor.code = codigo
        if (!listaProfessores.contains(newProfessor)) {
            listaProfessores.add(newProfessor)
        }
    }

    fun excluirProfessor(codigo: Int) {
        val professor = listaProfessores.filter { it.code.equals(codigo) }
        if (!professor.isEmpty()) {
            listaProfessores.removeAll(professor)
        }
    }

    fun registrarAluno(nome: String, sobrenome: String, codigo: Int) {
        var aluno = Aluno()
        aluno.code = codigo
        aluno.name = nome
        aluno.surname = sobrenome
        if (!listaAlunos.contains(aluno)) {
            listaAlunos.add(aluno)
        }
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        val aluno = listaAlunos.firstOrNull { it.code.equals(codigoAluno) }
        val curso = listaCursos.firstOrNull { it.code.equals(codigoCurso) }

        if (curso != null && aluno != null) {
            val adiciona = curso.adicionarUmAluno(aluno)
            if (adiciona) {
                val matricula = Matricula(aluno, curso)
                listaMatricula.add(matricula)
                println("Matricula do aluno ${aluno.code} feita!")
            } else {
                println("A turma está cheia, portanto não é possível realizar a matrícula")
            }
        } else {
            println("Aluno ou curso não encontrados!")
        }
    }

    fun alocarProfessor(codigoCurso: Int, cProfessorTitular: Int, cProfessorAdjunto: Int) {
        val professorTitular = listaProfessores.first { it.code.equals(cProfessorTitular) }
        val professorAdjunto = listaProfessores.first { it.code.equals(cProfessorAdjunto) }
        val curso = listaCursos.first { it.code.equals(codigoCurso) }
        if (professorTitular == null || professorAdjunto == null || curso == null){
            println("Curso ou Professor não encontrado")
        }
        else {
            curso.professorAdjunto = professorAdjunto as ProfessorAdjunto
            curso.professorTitular = professorTitular as ProfessorTitular
            println("Professores alocados ao curso ${curso.code}")
        }
    }

}