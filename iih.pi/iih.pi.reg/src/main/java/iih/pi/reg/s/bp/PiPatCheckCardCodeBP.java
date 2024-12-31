package iih.pi.reg.s.bp;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 核对患者就诊卡信息
 * @author ly 2017/06/23
 *
 */
public class PiPatCheckCardCodeBP {

	/**
	 * 核对患者就诊卡信息
	 * @param patId 患者id
	 * @param code 就诊卡号
	 * @return true:核对成功 false:核对失败
	 * @throws BizException 患者id入参为空
	 */
	public FBoolean exec(String patId,String code) throws BizException{
	
		if(StringUtil.isEmpty(patId))
			throw new BizException("核对患者就诊卡信息服务:入参患者id为空");
		
		if(StringUtil.isEmpty(code))
			return FBoolean.FALSE;
		
		DAFacade daf = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(patId);
		param.addParam(code);
		param.addParam(IPiDictCodeConst.SD_CARD_TYPE_TREATMENT);
		
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
		sqlSb.append("from pi_pat a ");
		sqlSb.append("inner join pi_pat_card b ");
		sqlSb.append("on a.id_pat = b.id_pat ");
		sqlSb.append("inner join pi_card c ");
		sqlSb.append("on b.id_card = c.id_card ");
		sqlSb.append("inner join pi_pat_cardtp d ");
		sqlSb.append("on b.id_patcardtp = d.id_cardtp ");

		sqlSb.append("where a.id_pat = ? ");
		sqlSb.append("and a.fg_invd = 'N' ");
		sqlSb.append("and b.code = ? ");
		sqlSb.append("and c.eu_cardsu= 1 ");
		sqlSb.append("and d.sd_patcardtp = ? ");
		
		return sqlSb.toString();
	}
}
