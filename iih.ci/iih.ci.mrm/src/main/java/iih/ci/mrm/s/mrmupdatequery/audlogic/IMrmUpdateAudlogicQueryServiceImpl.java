package iih.ci.mrm.s.mrmupdatequery.audlogic;

import iih.ci.mrm.i.mrmupdatequery.audlogic.IMrmUpdateAudlogicQueryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces={IMrmUpdateAudlogicQueryService.class}, binding=Binding.JSONRPC)
public class IMrmUpdateAudlogicQueryServiceImpl implements IMrmUpdateAudlogicQueryService{

}
