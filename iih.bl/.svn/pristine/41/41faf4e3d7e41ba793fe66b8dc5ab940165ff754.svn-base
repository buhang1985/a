package iih.bl.cg.s.bp;

import java.util.List;

import iih.bl.cg.bloepdelcostdto.d.BlOepDeLCostDTO;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询门诊销账待销账信息
 * 
 * @author zhangxin06 2018-9-29
 *
 */
public class BlCgOepSellAccountBp {

	/**
	 * 查询门诊销账待销账信息
	 * 
	 * @param id_pat
	 *            患者id
	 * @param dt_b
	 *            开始时间
	 * @param dt_e
	 *            结束时间
	 * @return BlOepDeLCostDTO 可销账列表
	 * @throws DAException
	 */
	public BlOepDeLCostDTO[] exec(String id_pat, FDateTime dt_b, FDateTime dt_e) throws DAException {
		
		StringBuffer sql = new StringBuffer();
		sql.append("   select itm.id_or,  ");
		sql.append("   ci.name_or name_or, ");
		sql.append("   itm.id_pres, ");
		sql.append("   itm.id_cgitmoep ,");
		sql.append("   itm.id_cgoep , ");
		sql.append("   itm.id_pat , ");
		sql.append("   itm.name_srv, ");
		sql.append("   itm.quan, ");
		sql.append("   itm.srvu, ");
		sql.append("   mea.name as srvu_name, ");
		sql.append("   itm.price_ratio as price,");
		sql.append("   itm.amt_ratio , ");
		sql.append("   itm.quan as return_quan ,");
		sql.append("   itm.quan as can_quan ,");
		sql.append("   itm.amt_ratio as return_amt ,");
		sql.append("   udi.name as name_su_mp   ");
		sql.append("   from bl_cg_itm_oep itm ");
		sql.append("   left join bl_cg_oep oep on oep.id_cgoep = itm.id_cgoep");
		sql.append("   left join bd_measdoc mea on mea.id_measdoc = itm.srvu ");
		sql.append("   left join ci_order  ci on itm.id_or = ci.id_or ");
		sql.append("   left join bd_udidoc udi on udi.id_udidoc = ci.id_su_mp ");
		sql.append("   where itm.fg_refund = 'N' ");
		sql.append("   and itm.fg_mm = 'N' ");
		sql.append("   and oep.eu_direct ='1' ");
		sql.append("   and itm.fg_st= 'N' ");
		sql.append("   and itm.fg_acc = 'Y' ");
		//sql.append("   and itm.id_or !='~' ");
		sql.append("   and itm.id_pat =  ? ");
		sql.append("   and oep.dt_cg between ? and ? ");

		SqlParam sp = new SqlParam();
		sp.addParam(id_pat);
		sp.addParam(dt_b);
		sp.addParam(dt_e);
		@SuppressWarnings("unchecked")
		List<BlOepDeLCostDTO> list = (List<BlOepDeLCostDTO>) new DAFacade().execQuery(sql.toString(), sp,
				new BeanListHandler(BlOepDeLCostDTO.class));
		//分组辅助方法
		for (BlOepDeLCostDTO blOepDeLCostDTO : list) {
			if(StringUtil.isEmptyWithTrim(blOepDeLCostDTO.getId_or())){
				blOepDeLCostDTO.setId_or(blOepDeLCostDTO.getName_srv());
			}
			if(StringUtil.isEmptyWithTrim(blOepDeLCostDTO.getName_or())){
				blOepDeLCostDTO.setName_or(blOepDeLCostDTO.getName_srv());
			}
		}
		return ListUtil.isEmpty(list) ? null : list.toArray(new BlOepDeLCostDTO[] {});
	}
}
