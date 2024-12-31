package iih.pi.acc.account.s.bp.help;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.d.desc.PiPatAccDODesc;
import iih.pi.acc.account.s.AccountMDOCrudServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;

/**
 * 账户校验逻辑类
 * @author ly
 *
 */
public class PatiAccValidateBP {

	/**
	 * 账户校验
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	public PiPatAccDO exec(String patId) throws BizException{
		
		String whereSql = PiPatAccDODesc.TABLE_ALIAS_NAME + ".id_pat = '"+patId+"' and " 
						+ PiPatAccDODesc.TABLE_ALIAS_NAME +".fg_active = 'Y'";
		
		AccountMDOCrudServiceImpl service = new AccountMDOCrudServiceImpl();
		PiPatAccDO[] accDos = service.find(whereSql, "", FBoolean.FALSE);
		
		if(ArrayUtil.isEmpty(accDos)){
    		throw new DAException("患者账户不存在");
    	}
    	
    	PiPatAccDO piPatAccDo =  accDos[0];//获取患者账户
    	
    	if (IPiDictCodeConst.SD_ACCSTA_FREEZE.equals(piPatAccDo.getSd_accsta())) {
			throw new BizException("患者账户已被冻结");
		}
    	
    	return piPatAccDo;
	}
}
