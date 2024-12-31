package iih.bl.cg.s.bp.validate;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 是否收取过挂号费
 * @author ly 2018/07/17
 *
 */
public class OpHasChargedRegisterCostBP {
	
	/**
	 * 是否收取过挂号费
	 * @param entIds 就诊id数组
	 * @return 校验结果 true:收取过 false:未收取过
	 * @throws BizExeception
	 */
	public FBoolean exec(String[] entIds) throws BizException {
		
		if(ArrayUtil.isEmpty(entIds)){
			throw new ArgumentNullException("是否收取过挂号费", "就诊id数组");
		}
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select count(1) from ");
		sqlSb.append("bl_cg_oep oep ");
		sqlSb.append("inner join bl_cg_itm_oep itmoep ");
		sqlSb.append("on oep.id_cgoep = itmoep.id_cgoep ");
		sqlSb.append("where " + SqlUtils.getInSqlByIds("itmoep.id_ent", entIds) + " ");
		sqlSb.append("and oep.eu_direct = ? ");
		sqlSb.append("and itmoep.eu_srctp = ? ");
		sqlSb.append("and itmoep.fg_refund = 'N' ");
		sqlSb.append("and itmoep.amt_ratio > 0 ");
		
		SqlParam param = new SqlParam();
		param.addParam(BookRtnDirectEnum.CHARGES);
		param.addParam(FeeOriginEnum.ENCOUNTER_FEE);
		
		Integer count = (Integer) new DAFacade().execQuery(
				sqlSb.toString(), param, new ColumnHandler());
		
		return count == 0 ? FBoolean.FALSE : FBoolean.TRUE;
	}
}
