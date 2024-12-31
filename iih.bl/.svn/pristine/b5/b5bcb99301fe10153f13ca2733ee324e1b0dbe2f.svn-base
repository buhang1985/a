package iih.bl.itf.std.inner.en.bp;

import java.util.List;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 挂号费记账状态
 * @author shaokx 2020/07/13
 *
 */
public class GetRegCgStatusBP {

	/**
	 * 挂号费记账状态
	 *
	 */
	public int exec(String entId) throws BizException{
		//未记账 0
		//记账未结算 1
		//记账已结算未付款 2
		//记账已付款 3
		//已退费 4
		
		if(StringUtil.isEmpty(entId)){
			throw new BizException("入参就诊id为空");
		}
		
		//1、查询记账未结算
		StringBuilder sql = new StringBuilder();
		
		//记账未结算 1
		sql.append(" select decode(a.id_cgitmoep,null,null,1) eu_srctp ");
		sql.append(" from ");
		sql.append(" (select cgitm.id_cgitmoep ");
		sql.append(" from bl_cg_itm_oep cgitm ");
		sql.append(" where cgitm.eu_srctp = 1 ");
		sql.append(" and cgitm.id_ent = ? ");
		sql.append(" and (cgitm.fg_hp = 'Y' or cgitm.fg_acc = 'Y') ");
		sql.append(" and cgitm.id_stoep = '~' ");
		sql.append(" union all ");
		sql.append(" select null from dual) a where rownum <= 1 ");
		
		sql.append(" union all ");
		
		//记账已结算未付款 2
		sql.append(" select decode(a.id_cgitmoep,null,null,2) eu_srctp ");
		sql.append(" from ");
		sql.append(" (select cgitm.id_cgitmoep ");
		sql.append(" from bl_cg_itm_oep cgitm ");
		sql.append(" inner join bl_st_oep st on cgitm.id_stoep = st.id_stoep ");
		sql.append(" where cgitm.eu_srctp = 1 ");
		sql.append(" and cgitm.id_ent = ? ");
		sql.append(" and st.id_paypatoep = '~' ");
		sql.append(" and st.eu_direct = 1 ");
		sql.append(" union all ");
		sql.append(" select null from dual) a where rownum <= 1 ");
		
		sql.append(" union all ");
		
		//记账已付款 3
		sql.append(" select decode(a.id_cgitmoep,null,null,3) eu_srctp ");
		sql.append(" from ");
		sql.append(" (select cgitm.id_cgitmoep ");
		sql.append(" from bl_cg_itm_oep cgitm ");
		sql.append(" inner join bl_st_oep st on cgitm.id_stoep = st.id_stoep ");
		sql.append(" where cgitm.eu_srctp = 1 ");
		sql.append(" and cgitm.id_ent = ? ");
		sql.append(" and st.id_paypatoep <> '~' ");
		sql.append(" and st.fg_canc = 'N' ");
		sql.append(" and st.eu_direct = 1 ");
		sql.append(" union all ");
		sql.append(" select null from dual) a where rownum <= 1 ");
		
		sql.append(" union all ");
		
		//已退费 4
		sql.append(" select decode(a.id_cgitmoep,null,null,4) eu_srctp ");
		sql.append(" from ");
		sql.append(" (select cgitm.id_cgitmoep ");
		sql.append(" from bl_cg_itm_oep cgitm ");
		sql.append(" inner join bl_st_oep st on cgitm.id_stoep = st.id_stoep ");
		sql.append(" where cgitm.eu_srctp = 1 ");
		sql.append(" and cgitm.id_ent = ? ");
		sql.append(" and st.fg_canc = 'Y' ");
		sql.append(" union all ");
		sql.append(" select null from dual) a where rownum <= 1 ");
		
		SqlParam param = new SqlParam();
		param.addParam(entId);
		param.addParam(entId);
		param.addParam(entId);
		param.addParam(entId);
		
		List<BlCgItmOepDO> list = (List<BlCgItmOepDO>) new DAFacade().execQuery(sql.toString(),param,
				new BeanListHandler(BlCgItmOepDO.class));
		
		if(ListUtil.isEmpty(list)){
			return 0;
		}
		
		for (BlCgItmOepDO itm : list) {
			if(itm.getEu_srctp() != null){
				return itm.getEu_srctp();//注意这里有自动拆箱，一定要判断itm.getEu_srctp() != null
			}
		}

		return 0;
	}
}
