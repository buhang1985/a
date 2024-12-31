package iih.bl.hp.s.bp;

import iih.bl.comm.IBlMsgConst;
import iih.bl.hp.hpsignin.d.HpSignInDO;
import iih.bl.hp.hpsignin.i.IHpsigninRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取可用医保业务周期号
 * 
 * @author yang.lu
 * @version 2017年7月13日
 */
public class GetHpBizCodeBP {

	/**
	 * 获取可用医保业务周期号
	 * 
	 * @param empId
	 * @return
	 * @throws BizException
	 * @author
	 */
	public String exec(String empId) throws BizException {
		// 1.校验
		if (StringUtil.isEmpty(empId))
			return null;

		// 2.查询 启用标志为TRUE 并且 是当前用户的数据
		IHpsigninRService service = ServiceFinder.find(IHpsigninRService.class);

		String sqlWhere = " ID_EMP='" + empId + "' AND FG_ACTIVE='Y'";

		HpSignInDO[] hpInDOs = service.find(sqlWhere, "", FBoolean.FALSE);
		// 3.不为空并且有数据的情况下
		if (!ArrayUtil.isEmpty(hpInDOs) && hpInDOs.length != 0) {

			// 4.如果数据为一条 返回当前业务周启号
			if (hpInDOs.length == 1) {
				return hpInDOs[0].getCode_business();
			} else {
				// 否则为数据异常情况
				throw new BizException(IBlMsgConst.SIGNIN_LENGTH_ERROR);
			}
		}

		return null;
	}
}
