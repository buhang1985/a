package iih.ci.mr.s;

import iih.ci.mr.i.ICiMrCodeRuleService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

@Service(serviceInterfaces = {ICiMrCodeRuleService.class }, binding = Binding.JSONRPC)
public class CiMrCodeRuleServiceImpl implements ICiMrCodeRuleService {

	/**
	 * 根据DO的全路径名获取编码
	 */
	@Override
	public String getCodeByFullName(String fullName) throws BizException {
		IBillcodeManage service = ServiceFinder.find(IBillcodeManage.class);
		return service.getPreBillCode_RequiresNew(fullName);
	}

}
