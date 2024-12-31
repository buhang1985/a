package iih.pi.reg.pat.s.rule;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.s.bp.psw.PiPswUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.bizrule.IRule;

/**
 * 注册新患者保存前加密患者密码规则
 * 
 * @author hao_wu 2018-5-31
 *
 */
public class EncryptPatPwdBeforeInsertRule implements IRule<PatiAggDO> {

	@Override
	public void process(PatiAggDO... patAggs) throws BizException {

		if (patAggs == null || patAggs.length <= 0) {
			return;
		}

		encryptPatPwd(patAggs);
	}

	/**
	 * 加密患者密码
	 * 
	 * @param patAggs
	 * @throws BizException
	 */
	private void encryptPatPwd(PatiAggDO[] patAggs) throws BizException {
		for (PatiAggDO patiAggDO : patAggs) {
			PatDO patDO = patiAggDO.getParentDO();
			encryptPatPwd(patDO);
		}
	}

	/**
	 * 加密患者密码
	 * 
	 * @param patDO
	 *            患者信息
	 * @throws BizException
	 */
	private void encryptPatPwd(PatDO patDO) throws BizException {
		// 处理密码
		if (!StringUtil.isEmpty(patDO.getPassword())) {
			String encryptPwd = PiPswUtil.createPassword(patDO, patDO.getPassword());
			patDO.setPassword(encryptPwd);
		}
	}

}
