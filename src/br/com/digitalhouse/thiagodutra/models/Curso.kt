package br.com.digitalhouse.thiagodutra.models

class Curso {

    var code: Int = 0
    lateinit var name: String;
    lateinit var professorTitular: ProfessorTitular;
    lateinit var professorAdjunto: ProfessorAdjunto;
    var maxAlunos = 0;
    var alunos = mutableListOf<Aluno>();


    fun adicionarUmAluno(aluno:Aluno):Boolean{
        if (alunos.size < maxAlunos && !alunos.contains(aluno)){
            alunos.add(aluno)
            return true
        }
        return false;
    }

    fun excluirAluno(aluno: Aluno){
        if (alunos.contains(aluno)){
            alunos.remove(aluno);
        }
    }


}