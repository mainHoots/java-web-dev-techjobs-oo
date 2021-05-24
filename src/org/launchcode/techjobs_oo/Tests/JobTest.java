package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;

public class JobTest {

    public Job jobUno;
    public Job jobDeuce;

    @Before
    public void initialize() {

        jobUno = new Job();
        jobDeuce = new Job();

    }

    @Test
    public void testSettingJobId() {

        assertEquals(jobUno.getId() + 1, jobDeuce.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields() {

        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job.getName());
        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals("ACME", job.getEmployer().toString());
        assertTrue(job.getLocation() instanceof Location);
        assertEquals("Desert", job.getLocation().toString());
        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals("Quality Control", job.getPositionType().toString());
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job.getCoreCompetency().toString());

    }

    @Test
    public void testJobsForEquality() {

        Job testJobUno = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
                "Quality control"), new CoreCompetency("Persistence"));
        Job testJobDeuce = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJobUno.equals(testJobDeuce));

    }

    @Test
    public void testBlankFieldLines() {

        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', job.toString().charAt(0));
        assertEquals('\n', job.toString().charAt(job.toString().length() -1));

    }

    @Test
    public void testFieldLabels() {

        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: " + job.getId()+ "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", job.toString());

    }

    @Test
    public void testEmptyEmployerField() {

        Job job = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: " + job.getId()+ "\nName: Product tester\nEmployer: Data not available\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", job.toString());

    }

    @Test
    public void testSingleFieldName() {

        Job job = new Job("Product tester", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("\nID: " + job.getId()+ "\nName: Product tester\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n", job.toString());

    }

    @Test
    public void testSingleFieldId() {

        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("OOPS! This job does not seem to exist.", job.toString());

    }

}
