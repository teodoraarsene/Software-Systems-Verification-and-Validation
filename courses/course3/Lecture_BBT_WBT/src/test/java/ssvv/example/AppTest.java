package ssvv.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ssvv.example.repository.Repository;
import ssvv.example.controller.ParticipantController;


import static org.junit.Assert.assertEquals;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    private Repository rep;
    private ParticipantController ctrl;

    @Test
    public void tc_4_AllParticipantsMax() {

        rep = new Repository("FileParticipantsMaxAll.txt");

        ctrl=new ParticipantController(rep);
        int noParticipantsMax= ctrl.getNumberOfParticipantWithMaxPointsReceived();

        assertEquals(4, noParticipantsMax);
    }
    @Test
    public void tc_3_AllParticipantsOnlyOne() {
        rep = new Repository("FileParticipantsMaxOne.txt");

        ctrl=new ParticipantController(rep);
        int noParticipantsMax= ctrl.getNumberOfParticipantWithMaxPointsReceived();

        assertEquals(1, noParticipantsMax);
    }

    @Test
    public void tc_20_ParticipantsWith99Points() {
        rep = new Repository("FileParticipants99Points.txt");

        ctrl=new ParticipantController(rep);
        int noParticipantsMax= ctrl.getNumberOfParticipantWithMaxPointsReceived();

        assertEquals(3, noParticipantsMax);
    }

}
