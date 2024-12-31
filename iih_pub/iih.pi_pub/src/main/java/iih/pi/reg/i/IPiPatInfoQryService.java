package iih.pi.reg.i;

import xap.mw.core.data.BizException;
import iih.pi.reg.dto.ws.PatAccInfoBean;
import iih.pi.reg.dto.ws.PatGuardianInfoBean;
import iih.pi.reg.dto.ws.PatInfoBean;
import iih.pi.reg.dto.ws.ResultInfo;

/**
 * 获取患者基本信息webservice服务
 * @author ly 2017/07/24
 *
 */
public interface IPiPatInfoQryService {

	/**
	 * 查询患者基本信息
	 * @param codeTp 编码类型
	 * @param code 编码值
	 * @return
	 * @throws BizException
	 */
	public abstract PatInfoBean getPatInfo(String codeTp,String code) throws BizException;
	
	/**
	 * 查询患者账户信息
	 * @param patCode 患者编码
	 * @return
	 * @throws BizException
	 */
	public abstract PatAccInfoBean getPatAccInfo(String patCode) throws BizException;
	
	/**
	 * 监护人关联信息查询接口
	 * @param codeTp 编码类型
	 * @param code 编码值
	 * @param operatorCode 操作人员编码
	 * @return
	 * @throws BizException
	 */
	public abstract PatGuardianInfoBean[] getPatInfoByGuardian(String codeTp,String code,String operatorCode) throws BizException;
	
	/**
	 * 患者使用预付费的密码校验
	 * @param patCode 患者编码
	 * @param password 患者密码
	 * @return
	 * @throws BizException
	 */
	public abstract boolean doCheckPassword(String patCode,String passWord)throws BizException;
	
	/**
	 * 患者账户密码是否为空
	 * @param patCode
	 * @return
	 */
	public ResultInfo doCheckNullPassword(String patCode)throws BizException;
	
	/**
	 * 设置患者账户密码
	 * @param patCode 患者编码
	 * @param password 患者密码
	 * @return
	 */
	public ResultInfo doSetPassword(String patCode,String password)throws BizException;
}
