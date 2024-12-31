package iih.pi.reg.s.ws;

import iih.bd.base.exception.ArgumentNullException;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.s.bp.psw.PiPswUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;

public class PatPasswordValidBP {
	public boolean exec(String patCode,String passWord)throws BizException{
		//1.参数校验
		this.valiData(patCode,passWord);
		//2.获取患者信息
		PatDO patDO=this.getPatDo(patCode);
		//3.患者密码校验
		FBoolean bValid=PiPswUtil.checkPassword(patDO, passWord);
		
		return bValid.booleanValue();
	}
	/**
	 * 入参校验
	 * 
	 * @param dto
	 * @throws BizException
	 */
	private void valiData(String patCode,String passWord) throws BizException {
		if (StringUtil.isEmpty(patCode)) {
			throw new ArgumentNullException("患者密码校验", "患者code");
		}
		if (StringUtil.isEmpty(passWord)) {
			throw new ArgumentNullException("患者密码校验", "患者密码");
		}
	}
	/**
	 * 获取患者信息
	 * @param patCode
	 * @return
	 * @throws DAException 
	 */
	private PatDO getPatDo(String patCode) throws BizException{
		IPatiMDORService patService= ServiceFinder.find(IPatiMDORService.class);
		PatDO[] patDO=patService.find("code='" + patCode +"'","",FBoolean.FALSE);
		if(patDO!=null && patDO.length>0){
			return patDO[0];
		}else{
			throw new BizException("该患者不存在！");
		}
	}
}
