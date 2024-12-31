package iih.bl.cg.blredapply.s.rule;

import iih.bl.cg.blredapply.d.BlRefundApplyDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

public class BlRefundApplyInsertBefRule implements IRule<BlRefundApplyDO> {

	@Override
	public void process(BlRefundApplyDO... paramVarArgs) throws BizException {
		
		//获取退费申请单单号
		IBillcodeManage iBillcodeManage = ServiceFinder.find(IBillcodeManage.class);
		String[] strings = iBillcodeManage.getBatchBillCodes_RequiresNew(BlRefundApplyDO.class.getName(),new BlRefundApplyDO(), paramVarArgs.length);
		
		for (int i = 0; i < strings.length; i++) {
			
			if(StringUtil.isEmpty(paramVarArgs[i].getCode_rfdap())){
				paramVarArgs[i].setCode_rfdap(strings[i]);
			}
			
		}
	}


}
