package iih.pi.reg.s.external.provide.bp;

import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据患者卡id查询卡类型
 * @author ly 2018/07/12
 *
 */
public class GetCardTpByPatCardIdBP {

	/**
	 * 根据患者卡id查询卡类型
	 * @param patcardId
	 * @return
	 * @throws BizException
	 */
	public PiPatCardTpDO exec(String patcardId) throws BizException{
		
		if(StringUtil.isEmpty(patcardId))
			return null;
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select cardtp.* ");
		sqlSb.append("from pi_pat_card patcard ");
		sqlSb.append("inner join pi_pat_cardtp cardtp ");
		sqlSb.append("on patcard.id_patcardtp = cardtp.id_cardtp ");
		sqlSb.append("where patcard.id_patcard = ? ");
		
		SqlParam param = new SqlParam();
		param.addParam(patcardId);
		
		PiPatCardTpDO cardDO = (PiPatCardTpDO)new DAFacade().execQuery(sqlSb.toString(), 
				param, new BeanHandler(PiPatCardTpDO.class));
		
		return cardDO;
	}
}
