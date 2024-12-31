package iih.pi.reg.pat.s.rule;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.s.bp.psw.PiPswUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 修改患者保存前加密患者密码规则
 * 
 * @author hao_wu 2018-5-31
 *
 */
public class EncryptPatPwdBeforeUpdateRule implements ICompareRule<PatiAggDO> {

	@Override
	public void process(PatiAggDO[] newPatAggs, PatiAggDO[] oldPatAggs) throws BizException {
		if (newPatAggs == null || newPatAggs.length <= 0) {
			return;
		}

		encryptPatPwd(newPatAggs, oldPatAggs);
	}

	/**
	 * 加密患者密码
	 * 
	 * @param patAggs
	 * @throws BizException
	 */
	private void encryptPatPwd(PatiAggDO[] newPatAggs, PatiAggDO[] oldPatAggs) throws BizException {
		for (int i = 0; i < newPatAggs.length; i++) {
			PatDO newPatDO = newPatAggs[i].getParentDO();
			PatDO oldPatDO = oldPatAggs[i].getParentDO();
			encryptPatPwd(newPatDO, oldPatDO);
		}
	}

	/**
	 * 加密患者密码
	 * 
	 * @param patDO
	 *            患者信息
	 * @throws BizException
	 */
	private void encryptPatPwd(PatDO newPatDO, PatDO oldPatDO) throws BizException {
		if (!StringUtil.isEmpty(newPatDO.getPassword()) && !newPatDO.getPassword().equals(oldPatDO.getPassword())) {
			// 新密码不等于空且新密码不等于旧密码时对修改后的密码进行重新加密
			String encryptPwd = PiPswUtil.createPassword(newPatDO, newPatDO.getPassword());
			newPatDO.setPassword(encryptPwd);
		}
	}
}
