package iih.pi.reg.s.bp;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 核对患者身份证信息
 * @author ly 2017/06/23
 *
 */
public class PiPatCheckIDCodeBP {

	/**
	 * 核对患者身份证信息
	 * @param patId 患者id
	 * @param code 身份证号
	 * @return true:核对成功 false:核对失败
	 * @throws BizException 入参患者id为空
	 */
	public FBoolean exec(String patId,String code) throws BizException{
		
		if(StringUtil.isEmpty(patId))
			throw new BizException("核对患者身份证信息服务:入参患者id为空");
		
		if(StringUtil.isEmpty(code))
			return FBoolean.FALSE;
		
		DAFacade daf = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(patId);
		param.addParam(code);
		param.addParam(IPiDictCodeConst.SD_IDTP_IDENTITY);
		
		Integer count = (Integer)daf.execQuery(this.getMainSql(), param, new ColumnHandler());
		if(count !=null && count == 1)
			return FBoolean.TRUE;
		
		return FBoolean.FALSE;
	}
	
	/**
	 * 主体sql
	 * @return
	 */
	private String getMainSql(){
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select count(1) ");
		sqlSb.append("from pi_pat ");
		sqlSb.append("where id_pat = ? ");
		sqlSb.append("and id_code =  ? ");
		sqlSb.append("and sd_idtp = ? ");
		sqlSb.append("and fg_invd = 'N' ");
		
		return sqlSb.toString();
	}
}
