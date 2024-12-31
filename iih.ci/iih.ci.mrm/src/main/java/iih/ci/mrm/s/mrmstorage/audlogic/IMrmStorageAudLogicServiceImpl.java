package iih.ci.mrm.s.mrmstorage.audlogic;

import iih.ci.mrm.i.mrmstorage.audlogic.IMrmStorageAudLogicService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces={IMrmStorageAudLogicService.class}, binding=Binding.JSONRPC)
public class IMrmStorageAudLogicServiceImpl implements IMrmStorageAudLogicService{

}
