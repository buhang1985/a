package iih.mc.common.bp;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

public class GetSystemSerialNo {
	
	public static <T extends BaseDO> String getBillNo(T baseDO) throws BizException {
		
		IBillcodeManage iBillcodeManage = ServiceFinder.find(IBillcodeManage.class);
		
		String code = iBillcodeManage.getBillCode_RequiresNew(baseDO.getClass().getName(), baseDO);
		if (StringUtils.isBlank(code)) {

			code = "" + System.currentTimeMillis();
		}
		
		return code;
	}
}
