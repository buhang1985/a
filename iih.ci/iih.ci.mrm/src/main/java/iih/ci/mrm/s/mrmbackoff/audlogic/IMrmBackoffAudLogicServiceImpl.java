package iih.ci.mrm.s.mrmbackoff.audlogic;

import iih.ci.mrm.i.mrmbackoff.audlogic.IMrmBackoffAudLogicService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces={IMrmBackoffAudLogicService.class}, binding=Binding.JSONRPC)
public class IMrmBackoffAudLogicServiceImpl implements IMrmBackoffAudLogicService{

}
