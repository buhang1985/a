package iih.pi.reg.s.bp.psw;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.permfw.rbac.util.BaseDOPwdUtil;
import iih.pi.reg.pat.d.PatDO;

/**
 * 患者密码工具类
 * @author ly 2017/06/22
 *
 */
public class PiPswUtil {

	/**
	 * 生成密文
	 * @param pswStr 密码字符串
	 * @return 密文
	 * @throws BizException 
	 */
	public static String createPassword(PatDO patDo,String pswStr) throws BizException{
	
		if(patDo == null || StringUtil.isEmpty(pswStr))
			return "";
		
		//主键为空时，自动生成主键
		if(StringUtil.isEmpty(patDo.getId_pat())){
			String key =  new DBUtil().getOIDs(1)[0];
			patDo.setId_pat(key);
		}
		
		return BaseDOPwdUtil.getEncodedPassword(patDo, pswStr);
	}
	
	/**
	 * 校验密码
	 * @param patDo
	 * @param inputPsw
	 * @return
	 * @throws BizException
	 */
	public static FBoolean checkPassword(PatDO patDo,String inputPsw) throws BizException{
		
		if(patDo == null || StringUtil.isEmpty(patDo.getPassword()) || StringUtil.isEmpty(inputPsw))
			return FBoolean.FALSE;
		
		boolean chkRlt = BaseDOPwdUtil.checkPassword(patDo, inputPsw, patDo.getPassword());
		
		return new FBoolean(chkRlt);
	} 
}
