package iih.pi.reg.s.customer.guoji;

import iih.bd.res.params.BdResParams;
import iih.pi.params.PiParams;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 患者在院(chis)校验类
 * @author ly 2017/10/13
 *
 */
public class PiPatCheckInHosChisBP {
	
	/**
	 * 判断患者是否在院(chis库)
	 * @param idCode 身份证号
	 * @return 校验结果
	 * @throws BizException
	 */
	public FBoolean exec(String idCode) throws BizException{
		
		if(StringUtil.isEmpty(idCode))
			throw new BizException("患者在院(chis)校验服务：传入参数身份证号为空");
		
		//chis建档开启
		FBoolean syncChis = new PiParams().PIPAT0002();
		if(FBoolean.FALSE.equals(syncChis))
			return FBoolean.FALSE;
		
		//chis数据源
		String chisDb = new BdResParams().CHISDB();
		if(StringUtil.isEmpty(chisDb))
			return FBoolean.FALSE;
		
		String chisSql = "select count(1) from view_iih_zy_actpatient where social_no = ? ";
		DAFacade daf = new DAFacade(chisDb);
		SqlParam param = new SqlParam();
		param.addParam(idCode);
		
		int count = (Integer)daf.execQuery(chisSql, param, new ColumnHandler());
		if(count > 0)
			return FBoolean.TRUE;
		
		return FBoolean.FALSE;
	}
}
