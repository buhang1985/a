package iih.bd.fc.entpwf.s;

import iih.bd.fc.entpwf.d.BdEntpWfDO;
import iih.bd.fc.entpwf.i.IEntpwfExtService;
import iih.bd.fc.entpwf.s.bp.EntpWfDeletebp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IEntpwfExtService.class }, binding = Binding.JSONRPC)
public class IEntpwfExtServiceImpl implements IEntpwfExtService {

	/**
	 * 就诊流程定义删除
	 */
	@Override
	public BdEntpWfDO[] delete(BdEntpWfDO wfdo) throws BizException {

		EntpWfDeletebp bp=new EntpWfDeletebp();
		
		return bp.exec(wfdo);
	}

}
