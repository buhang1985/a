package iih.pi.reg.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 患者校验服务
 * @author ly
 */
public interface IPiRegValidateService {

	/**
	 * 判断患者是否有社会医疗保险
	 * @param patId 患者id
	 * @return true:患者拥有社会医保类型医保 false:患者没有社会医保类型医保
	 * @throws BizException 患者id不存在,患者失效
	 */
	public abstract FBoolean hasSocialMedIns(String patId) throws BizException;
	
	/**
	 * 核对患者身份证信息
	 * @param patId 患者id
	 * @param code 身份证号
	 * @return true:核对成功 false:核对失败
	 * @throws BizException 入参患者id为空
	 */
	public abstract FBoolean checkPatIDCode(String patId,String code) throws BizException;
	
	/**
	 * 核对患者就诊卡信息
	 * @param patId 患者id
	 * @param code 就诊卡号
	 * @return true:核对成功 false:核对失败
	 * @throws BizException 入参患者id为空
	 */
	public abstract FBoolean checkPatCardCode(String patId,String code) throws BizException;

	/**
	 * 校验患者密码
	 * @param patId 患者id
	 * @param pwd 密码
	 * @return 校验结果
	 * @throws BizException 入参患者id为空,患者未设置密码
	 */
	public abstract FBoolean checkPatPassword(String patId, String pwd) throws BizException;

	/**
	 * 判断患者是否在院(chis库)
	 * @param idCode 身份证号
	 * @return 校验结果
	 * @throws BizException
	 */
	public abstract FBoolean checkPatInHosChis(String idCode) throws BizException;
}
