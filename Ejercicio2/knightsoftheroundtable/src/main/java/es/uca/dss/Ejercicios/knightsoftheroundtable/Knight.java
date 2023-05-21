package es.uca.dss.Ejercicios.knightsoftheroundtable;

public interface Knight{
    QuestItem embarkOnQuest() throws QuestFailedException;
}

class QuestFailedException extends RuntimeException {

}