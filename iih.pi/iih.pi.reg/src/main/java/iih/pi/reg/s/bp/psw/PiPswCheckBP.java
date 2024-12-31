package iih.pi.reg.s.bp.psw;

import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 患者密码校验逻辑类
 * @author ly 2017/06/22
 *
 */
public class PiPswCheckBP {

	/**
	 * 患者密码校验
	 * @param patId 患者id
	 * @param pwd 密码
	 * @return 校验结果
	 * @throws BizException
	 */
	public FBoolean exec(String patId, String pwd) throws BizException{
		
		if(StringUtil.isEmpty(patId)){
			throw new BizException("患者密码校验服务：入参患者id为空");
		}
		
		DAFacade daf = new DAFacade();
		PatDO patDo = (PatDO)daf.findByPK(PatDO.class, patId);
		
		if(patDo == null){
			throw new BizException("患者密码校验服务：未查询到患者信息");
		}
		
		if(StringUtil.isEmpty(patDo.getPassword())){
			throw new BizException("患者密码校验服务：患者当前密码为空");
		}
		
		return PiPswUtil.checkPassword(patDo, pwd);
	}
}
