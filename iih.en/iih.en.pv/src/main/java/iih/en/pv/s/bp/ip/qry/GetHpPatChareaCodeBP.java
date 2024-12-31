package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.validator.EnValidator;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取医保患者参合地编码
 * 
 * @author liubin
 * 
 */
public class GetHpPatChareaCodeBP {
	/**
	 * 获取医保患者参合地编码
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public String exec(String entId) throws BizException {
		if(EnValidator.isEmpty(entId))
			return null;
		String sql = "SELECT REFERRAL.CHAREACODE FROM EN_ENT EN INNER JOIN EN_ENT_HP_REFERRAL REFERRAL ON EN.CODE = REFERRAL.ENT_CODE WHERE EN.ID_ENT = ? ";
		SqlParam param = new SqlParam();
		param.addParam(entId);
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		return EnValidator.isEmpty(list)?null:list.get(0);
	}
}
