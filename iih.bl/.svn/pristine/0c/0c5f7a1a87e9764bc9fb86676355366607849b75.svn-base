package iih.bl.st.s.bp;

import iih.bl.cg.blcgquery.d.BlCgIpDO;

import java.util.List;

import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetCgIpDosPageBP {

	/**
	 * 住院结算-调入 记账费用明细（分页）
	 * @param map
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 * @author Liwq
	 */
	public PagingRtnData<BlCgIpDO> getBlCgIpPageDos(FMap map, PaginationInfo pageInfo) throws BizException {
		PagingRtnData<BlCgIpDO> pageFeeDTO = new PagingRtnData<BlCgIpDO>();
		PagingServiceImpl<BlCgIpDO> service = new PagingServiceImpl();
		if(map.isEmpty()) {
			
			return pageFeeDTO;
		}
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select a0.Amt*eu_direct  amt,         ");
		sql.append("     a0.Amt_hp*eu_direct amt_hp,         ");
		sql.append("     a0.Amt_pat*eu_direct amt_pat,        ");
		sql.append("     a0.Amt_ratio*eu_direct amt_ratio,      ");
		sql.append("     a0.Amt_std*eu_direct amt_std,        ");		
		sql.append("     a0.Code_apply,     ");		
		sql.append("     a0.Code_inccaitm,  ");
		sql.append("     a0.Code_mm,        ");
		sql.append("     a0.Code_srv,       ");		
		sql.append("     a0.Dt_cg,          ");
		sql.append("     a0.Dt_or,          ");
		sql.append("     a0.Dt_srv,         ");
		sql.append("     a0.Dt_st,          ");
		sql.append("     a0.Eu_direct,      ");
		sql.append("     a0.Eu_srctp,       ");
		sql.append("     a0.Fg_additm,      ");
		sql.append("     a0.Fg_free,        ");
		sql.append("     a0.Fg_hp,          ");
		sql.append("     a0.Fg_mm,          ");
		sql.append("     a0.Fg_pddisc,      "); //出院带药标志
		sql.append("     a0.Fg_recg,        ");
		sql.append("     a0.Fg_refund,      ");
		sql.append("     a0.Fg_st,          ");	
		sql.append("     a0.Id_cgip,        ");
		sql.append("     a0.Id_dep_cg,      ");
		sql.append("     a0.Id_dep_mp,      ");
		sql.append("     a0.Id_dep_nur,     ");
		sql.append("     a0.Id_dep_or,      ");
		sql.append("     a0.Id_dep_wh,      ");
		sql.append("     a0.Id_emp_cg,      ");
		sql.append("     a0.Id_emp_or,      ");
		sql.append("     a0.Id_ent,         ");	
		sql.append("     a0.Id_hp,          ");
		sql.append("     a0.Id_mm,          ");		
		sql.append("     a0.Id_or,          ");
		sql.append("     a0.Id_or_pr,       ");
		sql.append("     a0.Id_or_pr_srv,   ");
		sql.append("     a0.Id_org,         ");
		sql.append("     a0.Id_org_cg,      ");
		sql.append("     a0.Id_org_mp,      ");
		sql.append("     a0.Id_org_or,      ");
		sql.append("     a0.Id_orsrv,       ");
		sql.append("     a0.Id_pat,         ");
		sql.append("     a0.Id_pripat,      ");
		sql.append("     a0.Id_srv,         ");
		sql.append("     a0.Id_stip,        ");
		sql.append("     a0.Name_inccaitm,  ");
		sql.append("     a0.Name_mm,        ");
		sql.append("     a0.Name_srv ,       ");
		sql.append("     a0.Pgku_base,      ");
		sql.append("     a0.Pgku_cur,       ");
		sql.append("     a0.Price,          ");
		sql.append("     a0.Price_ratio,    ");
		sql.append("     a0.Quan*eu_direct quan,           ");
		sql.append("     a0.Quan_base,      ");
		sql.append("     a0.Ratio_hp,       ");
		sql.append("     a0.Ratio_pripat,   ");
		sql.append("     a0.Sd_srvtp,       ");
		sql.append("     a0.Spec,           ");	
		sql.append("     b0.name unit       ");
		
		sql.append(" from bl_cg_ip a0 left join bd_measdoc b0 on a0.srvu = b0.id_measdoc where   a0.ID_ENT = ? ");
		
		String id_ent = map.get("id_ent").toString();
		String id_dep = map.get("id_dep").toString();
		
		SqlParam  param = new SqlParam();
		param.addParam(id_ent);
		// 判断如果id_dep为*则查找所有科室的就诊,否则查找单科室的就诊数据
		if (!StringUtils.isBlank(id_dep) && !"*".equals(id_dep)) {
			sql.append(" AND a0.ID_DEP_OR = ? ");
			param.addParam(id_dep);
		}	
		
		
		String dt_end_str = "";
		if(!StringUtil.isEmpty(map.get("dt_end").toString())){
			FDateTime dt_end = new FDateTime(map.get("dt_end").toString());
			 dt_end_str = dt_end.getDate().getDateAfter(1).toString()	+ " 00:00:00";				
		}
		sql.append(" AND a0.DT_CG < ?  ");
		param.addParam(dt_end_str);
		
		FBoolean hasSettle = new FBoolean(map.get("hasSettle").toString());
		if(hasSettle.booleanValue()) {
			StringBuilder sqlSt = new StringBuilder();
			sqlSt.append("select id_stip from bl_st_ip where fg_canc = 'N' and id_ent = '").append(id_ent).append("'  order by dt_end desc ");
			List<String> idstipList = (List<String>) new DAFacade().execQuery(sqlSt.toString(), new ColumnListHandler());	
		
			String id_stip = idstipList.get(0);
			sql.append(" and a0.fg_st = 'Y' and a0.id_stip = '").append(id_stip).append("' ");
		}
		else {
			sql.append(" and a0.fg_st = 'N' ");
		}
		
		pageFeeDTO = service.findByPageInfo(new BlCgIpDO(), pageInfo,sql.toString(), "", param);
		
		return pageFeeDTO;
	}
}
