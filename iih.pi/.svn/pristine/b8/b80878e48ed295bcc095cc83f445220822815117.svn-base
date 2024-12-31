package iih.pi.reg.s.bp;

import iih.pi.overview.overview.d.PiPatDO;
import iih.pi.reg.dto.ws.ResultInfo;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取患者是否有密码
 * 
 * @author yang.lu
 *
 */
public class DoCheckNullPasswordBP {
	/**
	 * 获取当前患者是否有密码
	 * 
	 * @param patCode
	 * @return
	 * @throws BizException
	 */
	public ResultInfo exec(String patCode) throws BizException {
		ResultInfo retInfo = new ResultInfo();
		retInfo.setResultCode("-1");
		if (StringUtil.isEmpty(patCode)) {
			retInfo.setErrorMsg("未找到对应患者，无法验证！");
			return retInfo;
		}
		IPatiMDORService service = ServiceFinder.find(IPatiMDORService.class);
		PatDO[] pats = service.findByAttrValString(PiPatDO.CODE, patCode);
		if (ArrayUtil.isEmpty(pats)) {
			retInfo.setErrorMsg("未找到对应患者，无法验证！");
			return retInfo;
		}
		if (pats.length == 1 && !StringUtil.isEmpty(pats[0].getPassword())) {
			retInfo.setResultCode("0");
		} else {
			retInfo.setErrorMsg("当前患者未设置密码！");
		}
		return retInfo;
	}
}
