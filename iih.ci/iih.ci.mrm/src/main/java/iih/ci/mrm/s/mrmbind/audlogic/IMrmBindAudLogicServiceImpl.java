package iih.ci.mrm.s.mrmbind.audlogic;

import iih.ci.mrm.i.mrmbind.audlogic.IMrmBindAudLogicService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces={IMrmBindAudLogicService.class}, binding=Binding.JSONRPC)
public class IMrmBindAudLogicServiceImpl implements IMrmBindAudLogicService{

}
