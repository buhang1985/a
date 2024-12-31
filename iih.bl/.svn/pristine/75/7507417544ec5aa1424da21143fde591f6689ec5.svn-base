package iih.bl.hp.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.utils.ContextUtils;
import iih.bl.comm.IBlMsgConst;
import iih.bl.hp.hpsignin.d.HpSignInDO;
import iih.bl.hp.hpsignin.i.IHpsigninCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 签到
 * 
 * @author yang.lu
 *
 */
public class SignInBP {
	/**
	 * 签到
	 * 
	 * @param empId
	 *            操作员ID
	 * @param businessCode
	 *            业务周期号
	 * @param mac
	 *            mac地址
	 * @throws BizException
	 * @author yang.lu 2017年7月13日
	 */
	public void exec(String empId, String businessCode, String mac) throws BizException {
		// 1.验证
		if (StringUtil.isEmpty(empId) || StringUtil.isEmpty(businessCode))
			return;
		// 2.获取当前用户是否有业务周期号 如果有 返回异常
		GetHpBizCodeBP codebp = new GetHpBizCodeBP();

		String code = codebp.exec(empId);

		if (StringUtil.isEmpty(code)) {
			// 3.添加签到数据初始值
			HpSignInDO signInDO = new HpSignInDO();
			signInDO.setStatus(DOStatus.NEW);
			signInDO.setId_emp(empId);
			signInDO.setCode_business(businessCode);
			signInDO.setMac(mac);
			signInDO.setDt_b(AppUtils.getServerDateTime());
			signInDO.setFg_active(FBoolean.TRUE);
			signInDO.setId_org(ContextUtils.getOrgId());
			signInDO.setId_grp(ContextUtils.getGrpId());

			// 4.保存签到数据
			IHpsigninCudService service = ServiceFinder.find(IHpsigninCudService.class);
			service.insert(new HpSignInDO[] { signInDO });

		} else {
			throw new BizException(IBlMsgConst.SIGNIN_INSERT_ERROR);
		}
	}
}
