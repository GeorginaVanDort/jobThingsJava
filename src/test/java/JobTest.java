import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class JobTest{
  //REMEMBER TO RENAME!!!!!!1!one!
  @Test
  public void Job_instantiatesCorrectly_true() {
    Job job = new Job("Nerf-herder", "Herds nerfs", "The Empire", "Now", true);
    assertEquals(true, job instanceof Job);
  }

  @Test
  public void getTitle_returnsTitle_String() {
    Job job = new Job("Nerf-herder", "Herds nerfs", "The Empire", "Now", true);
    assertEquals("Nerf-herder", job.getTitle());
  }

  @Test
  public void getDescription_returnsDescription_String() {
    Job job = new Job("Nerf-herder", "Herds nerfs", "The Empire", "Now", true);
    assertEquals("Herds nerfs", job.getDescription());
  }

  @Test
  public void getCompany_returnsCompany_String() {
    Job job = new Job("Nerf-herder", "Herds nerfs", "The Empire", "Now", true);
    assertEquals("The Empire", job.getCompany());
  }

  @Test
  public void getDates_returnsDates_String() {
    Job job = new Job("Nerf-herder", "Herds nerfs", "The Empire", "Now", true);
    assertEquals("Now", job.getDates());
  }

  @Test
  public void getOpening_returnsOpening_boolean() {
    Job job = new Job("Nerf-herder", "Herds nerfs", "The Empire", "Now", true);
    assertEquals(true, job.getOpening());
  }
}
