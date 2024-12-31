package iih.pi.reg.s.bp;

import iih.pi.overview.overview.d.PiPatDO;
import iih.pi.reg.dto.ws.ResultInfo;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDOCudService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.s.bp.psw.PiPswUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 创建患者密码
 * 
 * @author yang.lu
 *
 */
public class DoSetPasswordBP {
	/**
	 * 创建患者密码
	 * 
	 * @param patCode
	 * @param password
	 * @return
	 * @throws BizException
	 */
	public ResultInfo exec(String patCode, String password) throws BizException {
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
		if (pats.length == 1 && StringUtil.isEmpty(pats[0].getPassword())) {
			retInfo.setResultCode("0");
			String newPwd=PiPswUtil.createPassword(pats[0], password);
			pats[0].setPassword(newPwd);
			pats[0].setStatus(DOStatus.UPDATED);
			IPatiMDOCudService cudService = ServiceFinder.find(IPatiMDOCudService.class);
			cudService.update(pats);
		} else {
			retInfo.setErrorMsg("当前患者已创建密码，无法重新创建！");
		}

		return retInfo;
	}
}
