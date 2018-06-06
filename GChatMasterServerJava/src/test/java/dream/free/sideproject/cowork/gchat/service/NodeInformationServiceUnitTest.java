package dream.free.sideproject.cowork.gchat.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dream.free.sideproject.cowork.gchat.config.BaseConfigurations;
import dream.free.sideproject.cowork.gchat.model.NodeInformation;

@Rollback(true)
@ActiveProfiles("unit-test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {BaseConfigurations.class})
public class NodeInformationServiceUnitTest {

    @Autowired
    private NodeInformationService informationNodeService;
    
    @Test
    public void testSaveInformationNode() {
        //Arrange
        String message = "何宗祐愛自摸";
        final byte[] messageInBytes = message.getBytes();
        
        NodeInformation nodeInformation = new NodeInformation();
        nodeInformation.setNodeId(1);
        nodeInformation.setInformationBody(messageInBytes);
        
        //Act
        NodeInformation savedNode = informationNodeService.saveInformationNode(nodeInformation);
        
        //Assert
        assertNotNull(savedNode);
        assertEquals(1, savedNode.getId());
        assertEquals(messageInBytes, savedNode.getInformationBody());
        
        System.err.println(savedNode);
    }
}
