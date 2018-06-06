package dream.free.sideproject.cowork.gchat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dream.free.sideproject.cowork.gchat.dao.InformationNodeDao;
import dream.free.sideproject.cowork.gchat.model.NodeInformation;
import dream.free.sideproject.cowork.gchat.service.NodeInformationService;

@Service
@Transactional
public class NodeInformationServiceImpl implements NodeInformationService {

    @Autowired
    private InformationNodeDao informationNodeDao;
    
    @Override
    public NodeInformation saveInformationNode(NodeInformation informationNode) {
        return informationNodeDao.save(informationNode);
    }
    
}
