import br.com.digitalhouse.thiagodutra.manager.DigitalHouseManager
import br.com.digitalhouse.thiagodutra.models.Aluno
import br.com.digitalhouse.thiagodutra.models.Curso
import br.com.digitalhouse.thiagodutra.models.ProfessorAdjunto
import br.com.digitalhouse.thiagodutra.models.ProfessorTitular
import java.util.*

fun main(){
    val digitalHouse = DigitalHouseManager()

    digitalHouse.registrarAluno("Thiago", "Dutra", 101)
    digitalHouse.registrarCurso("Calculo II", 2040, 5)
    digitalHouse.registrarCurso("Calculo Fechado", 2041, 0)
    digitalHouse.registrarProfessorTitular("Frederico", "Bublitz", 202, "IA")
    digitalHouse.resgistrarProfessorAdjunto("Misael", "Moraes", 203, 70)
    digitalHouse.matricularAluno(101, 2040)
    digitalHouse.matricularAluno(101, 2041)

    var aluno1 = Aluno()
    aluno1.surname = "Dutra"
    aluno1.name = "Thiago"
    aluno1.code = 101

    var professorTitular = ProfessorTitular()
    professorTitular.especialty = "calculo"
    professorTitular.surname = "Freire"
    professorTitular.name = "Onildo"
    professorTitular.code = 201
    professorTitular.time = Date()

    var professorAdjunto = ProfessorAdjunto()
    professorAdjunto.quantidadeHoras = 140
    professorAdjunto.time = Date()
    professorAdjunto.code = 301
    professorAdjunto.name = "Adilson"
    professorAdjunto.surname = "Batista"

    var curso1 = Curso()
    curso1.name = "Computação"
    curso1.maxAlunos = 10
    curso1.code = 2020

    var curso2 = Curso()
    curso2.name = "Calculo Especial"
    curso2.maxAlunos = 0
    curso2.code = 2030


}