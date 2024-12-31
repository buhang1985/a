package iih.bl.hp.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bl.comm.IBlMsgConst;
import iih.bl.hp.hpsignin.d.HpSignInDO;
import iih.bl.hp.hpsignin.i.IHpsigninCudService;
import iih.bl.hp.hpsignin.i.IHpsigninRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 签退
 * 
 * @author
 *
 */
public class SignOutBP {
	/**
	 * 签退
	 * 
	 * @param empId
	 *            操作员ID
	 * @throws BizException
	 * @author
	 */
	public void exec(String empId) throws BizException {
		// 1.校验
		if (StringUtil.isEmpty(empId))
			return;

		// 2.查询 启用标志为TRUE 并且 是当前用户的数据
		IHpsigninRService service = ServiceFinder.find(IHpsigninRService.class);

		String sqlWhere = " ID_EMP='" + empId + "' AND FG_ACTIVE='Y'";

		HpSignInDO[] hpInDOs = service.find(sqlWhere, "", FBoolean.FALSE);
		// 3.不为空并且有数据的情况下
		if (!ArrayUtil.isEmpty(hpInDOs) && hpInDOs.length != 0) {

			// 4.如果数据为一条 返回当前业务周启号
			if (hpInDOs.length == 1) {
				hpInDOs[0].setDt_e(AppUtils.getServerDateTime());
				hpInDOs[0].setStatus(DOStatus.UPDATED);
				hpInDOs[0].setFg_active(FBoolean.FALSE);
				// 4.保存签到数据
				IHpsigninCudService cudService = ServiceFinder.find(IHpsigninCudService.class);
				cudService.save(hpInDOs);

			} else {
				// 否则为数据异常情况
				throw new BizException(IBlMsgConst.SIGNIN_LENGTH_ERROR);
			}
		}

	}
}
