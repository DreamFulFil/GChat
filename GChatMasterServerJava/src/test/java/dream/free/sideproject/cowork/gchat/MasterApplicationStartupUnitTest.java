package dream.free.sideproject.cowork.gchat;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import dream.free.sideproject.cowork.gchat.main.MasterApplicationStartup;

public class MasterApplicationStartupUnitTest{
   
    @Test
    public void sampleTest() {
        //Arrange
        MasterApplicationStartup startupApp = new MasterApplicationStartup();
        
        //Act
        MasterApplicationStartup.main(new String[] {"HI"});
        
        //Assert
        assertNotNull(startupApp);
    }
}
