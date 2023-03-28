package ssvv.example;

import ssvv.example.controller.ParticipantController;
import ssvv.example.model.Participant;
import ssvv.example.repository.Repository;
import ssvv.example.ui.ParticipantUI;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        String participantsFile = "FileParticipants.txt";

        Repository repo = new Repository(participantsFile);
        ParticipantController ctrl = new ParticipantController(repo);

        ParticipantUI console = new ParticipantUI(ctrl);
        console.Run();
    }



}
