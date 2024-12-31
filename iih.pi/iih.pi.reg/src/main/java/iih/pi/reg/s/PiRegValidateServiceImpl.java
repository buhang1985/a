package iih.pi.reg.s;

import iih.pi.reg.i.IPiRegValidateService;
import iih.pi.reg.s.bp.PiPatCheckCardCodeBP;
import iih.pi.reg.s.bp.PiPatCheckIDCodeBP;
import iih.pi.reg.s.bp.PiPatJudgeIfSocialMedInsBP;
import iih.pi.reg.s.bp.psw.PiPswCheckBP;
import iih.pi.reg.s.customer.guoji.PiPatCheckInHosChisBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 患者校验服务
 * @author ly
 */
@Service(serviceInterfaces={IPiRegValidateService.class}, binding=Binding.JSONRPC)
public class PiRegValidateServiceImpl implements IPiRegValidateService{

	/**
	 * 判断患者是否有社会医疗保险
	 * @param patId 患者id
	 * @return true:患者拥有社会医保类型医保 false:患者没有社会医保类型医保
	 * @throws BizException 患者id不存在,患者失效
	 */
	@Override
	public FBoolean hasSocialMedIns(String patId) throws BizException{
		PiPatJudgeIfSocialMedInsBP bp = new PiPatJudgeIfSocialMedInsBP();
		return bp.exec(patId);
	}
	
	/**
	 * 核对患者身份证信息
	 * @param patId 患者id
	 * @param code 身份证号
	 * @return true:核对成功 false:核对失败
	 * @throws BizException 入参患者id为空
	 */
	@Override
	public FBoolean checkPatIDCode(String patId,String code) throws BizException{
		PiPatCheckIDCodeBP bp = new PiPatCheckIDCodeBP();
		return bp.exec(patId, code);
	}
	
	/**
	 * 核对患者就诊卡信息
	 * @param patId 患者id
	 * @param code 就诊卡号
	 * @return true:核对成功 false:核对失败
	 * @throws BizException 入参患者id为空
	 */
	@Override
	public FBoolean checkPatCardCode(String patId,String code) throws BizException{
		PiPatCheckCardCodeBP bp = new PiPatCheckCardCodeBP();
		return bp.exec(patId, code);
	}
	
	/**
	 * 校验患者密码
	 * @param patId 患者id
	 * @param pwd 密码
	 * @return 校验结果
	 * @throws BizException
	 */
	@Override
	public FBoolean checkPatPassword(String patId, String pwd) throws BizException{
		PiPswCheckBP bp = new PiPswCheckBP();
		return bp.exec(patId, pwd);
	}
	
	/**
	 * 判断患者是否在院(chis库)
	 * @param idCode 身份证号
	 * @return 校验结果
	 * @throws BizException
	 */
	@Override
	public FBoolean checkPatInHosChis(String idCode) throws BizException{
		PiPatCheckInHosChisBP bp = new PiPatCheckInHosChisBP();
		return bp.exec(idCode);
	}
}
