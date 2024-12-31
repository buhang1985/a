package iih.pi.reg.s;

import iih.pi.reg.dto.ws.PatAccInfoBean;
import iih.pi.reg.dto.ws.PatGuardianInfoBean;
import iih.pi.reg.dto.ws.PatInfoBean;
import iih.pi.reg.dto.ws.ResultInfo;
import iih.pi.reg.i.IPiPatInfoQryService;
import iih.pi.reg.s.bp.DoCheckNullPasswordBP;
import iih.pi.reg.s.bp.DoSetPasswordBP;
import iih.pi.reg.s.ws.PatAccInfoQryWSBP;
import iih.pi.reg.s.ws.PatGuardianInfoBP;
import iih.pi.reg.s.ws.PatInfoQryWSBP;
import iih.pi.reg.s.ws.PatPasswordValidBP;
import xap.mw.core.data.BizException;

/**
 * 获取患者基本信息webservice服务
 * 
 * @author ly 2017/07/24
 *
 */
public class PiPatInfoQryServiceImpl implements IPiPatInfoQryService {

	/**
	 * 查询患者基本信息
	 * 
	 * @param codeTp
	 *            编码类型
	 * @param code
	 *            编码值
	 * @return
	 * @throws BizException
	 */
	@Override
	public PatInfoBean getPatInfo(String codeTp, String code) throws BizException {
		PatInfoQryWSBP bp = new PatInfoQryWSBP();
		return bp.exec(codeTp, code);
	}

	/**
	 * 查询患者账户信息
	 * 
	 * @param patCode
	 *            患者编码
	 * @return
	 * @throws BizException
	 */
	@Override
	public PatAccInfoBean getPatAccInfo(String patCode) throws BizException {
		PatAccInfoQryWSBP bp = new PatAccInfoQryWSBP();
		return bp.exec(patCode);
	}

	/**
	 * 监护人关联信息查询接口
	 * 
	 * @param codeTp
	 *            编码类型
	 * @param code
	 *            编码值
	 * @param operatorCode
	 *            操作人员编码
	 * @return
	 * @throws BizException
	 */
	@Override
	public PatGuardianInfoBean[] getPatInfoByGuardian(String codeTp, String code, String operatorCode) throws BizException {
		PatGuardianInfoBP bp = new PatGuardianInfoBP();
		return bp.exec(codeTp, code, operatorCode);
	}

	/**
	 * 患者使用预付费的密码校验
	 * 
	 * @param patCode
	 *            患者编码
	 * @param password
	 *            患者密码
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean doCheckPassword(String patCode, String passWord) throws BizException {
		PatPasswordValidBP bp = new PatPasswordValidBP();
		return bp.exec(patCode, passWord);
	}

	/**
	 * 患者账户密码是否为空
	 * 
	 * @param patCode
	 * @return
	 */
	@Override
	public ResultInfo doCheckNullPassword(String patCode) throws BizException {
		DoCheckNullPasswordBP bp = new DoCheckNullPasswordBP();
		return bp.exec(patCode);
	}

	/**
	 * 设置患者账户密码
	 * 
	 * @param patCode
	 *            患者编码
	 * @param password
	 *            患者密码s
	 * @return
	 * @throws BizException
	 */
	@Override
	public ResultInfo doSetPassword(String patCode, String password) throws BizException {
		DoSetPasswordBP bp = new DoSetPasswordBP();
		return bp.exec(patCode, password);
	}
}
