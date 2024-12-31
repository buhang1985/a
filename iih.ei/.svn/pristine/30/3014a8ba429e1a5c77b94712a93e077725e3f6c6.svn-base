package iih.ei.xhcmu.s;

import iih.ei.xhcmu.i.IXhcmuQueryService;
import iih.ei.xhcmu.pat.GetNameBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IXhcmuQueryService.class }, binding = Binding.JSONRPC)
public class IXhcmuQueryServiceImpl implements IXhcmuQueryService{

	/**
	 * 获取患者姓名
	 */
	@Override
	public String getName(String firstName) throws BizException {
		GetNameBp bp=new GetNameBp();
		return bp.exec(firstName);
	}

}
