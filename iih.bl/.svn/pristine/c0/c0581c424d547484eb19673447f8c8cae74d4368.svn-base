package iih.bl.st.blstip.bp;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bl.params.BlParams;
import iih.bl.st.blcgipdto.d.BlCgIpDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院结算-调入 记账费用明细（分页）(改造)
 * 
 * @author liwenqiang
 *
 */
public class BlStarIpReFormBp {
	/**
	 * 住院结算-调入 记账费用明细（分页）(改造)
	 * 
	 * @param map
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BlCgIpDTO> exec(FMap map, PaginationInfo pageInfo)
			throws BizException {
		PagingRtnData<BlCgIpDTO> data = this.getBlCgIpPageDos(map, pageInfo);
		return data;

	}

	/**
	 * 住院结算-调入 记账费用明细（分页）
	 * 
	 * @param map
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 * @author Liwq
	 */
	public PagingRtnData<BlCgIpDTO> getBlCgIpPageDos(FMap map,
			PaginationInfo pageInfo) throws BizException {
		PagingRtnData<BlCgIpDTO> pageFeeDTO = new PagingRtnData<BlCgIpDTO>();
		PagingServiceImpl<BlCgIpDTO> service = new PagingServiceImpl<BlCgIpDTO>();
		if (map.isEmpty()) {

			return pageFeeDTO;
		}
		String id_ent = map.get("id_ent").toString();
		String id_dep = map.get("id_dep").toString();

		StringBuilder sql = new StringBuilder();

		sql.append(" select a0.Amt*eu_direct  amt,         ");
		sql.append("     a0.Amt_hp*eu_direct amt_hp,         ");
		sql.append("     a0.Amt_pat*eu_direct amt_pat,        ");
		sql.append("     a0.Amt_ratio*eu_direct amt_ratio,      ");
		sql.append("     a0.Amt_std*eu_direct amt_std,        ");
		sql.append("     a0.Apprno,         ");
		sql.append("     a0.Cd_batch,       ");
		sql.append("     a0.Code_apply,     ");
		sql.append("     a0.Code_cg,        ");
		sql.append("     a0.Code_enttp,     ");
		sql.append("     a0.Code_inccaitm,  ");
		sql.append("     a0.Code_mm,        ");
		sql.append("     a0.Code_srv,       ");
		sql.append("     a0.Ds,             ");
		sql.append("     a0.Dt_cg,          ");
		sql.append("     a0.Dt_or,          ");
		sql.append("     a0.Dt_srv,         ");
		sql.append("     a0.Dt_st,          ");
		sql.append("     a0.Eu_direct,      ");
		sql.append("     a0.Eu_srctp,       ");
		sql.append("     a0.Factor,         ");
		sql.append("     a0.Fg_additm,      ");
		sql.append("     a0.Fg_free,        ");
		sql.append("     a0.Fg_hp,          ");
		sql.append("     a0.Fg_mm,          ");
		sql.append("     a0.Fg_pddisc,      ");
		sql.append("     a0.Fg_recg,        ");
		sql.append("     a0.Fg_refund,      ");
		sql.append("     a0.Fg_st,          ");
		sql.append("     a0.Fg_susp,        ");
		sql.append("     a0.Id_cgip,        ");
		sql.append("     a0.Id_dep_cg,      ");
		sql.append("     a0.Id_dep_mp,      ");
		sql.append("     a0.Id_dep_nur,     ");
		sql.append("     a0.Id_dep_or,      ");
		sql.append("     a0.Id_dep_wh,      ");
		sql.append("     a0.Id_emp_cg,      ");
		sql.append("     a0.Id_emp_or,      ");
		sql.append("     a0.Id_ent,         ");
		sql.append("     a0.Id_enttp,       ");
		sql.append("     a0.Id_grp,         ");
		sql.append("     a0.Id_hp,          ");
		sql.append("     a0.Id_mm,          ");
		sql.append("     a0.Id_mmtp,        ");
		sql.append("     a0.Id_or,          ");
		sql.append("     a0.Id_or_pr,       ");
		sql.append("     a0.Id_or_pr_srv,   ");
		sql.append("     a0.Id_org,         ");
		sql.append("     a0.Id_org_cg,      ");
		sql.append("     a0.Id_org_mp,      ");
		sql.append("     a0.Id_org_or,      ");
		sql.append("     a0.Id_orsrv,       ");
		sql.append("     a0.Id_par,         ");
		sql.append("     a0.Id_pat,         ");
		sql.append("     a0.Id_pres,        ");
		sql.append("     a0.Id_pripat,      ");
		sql.append("     a0.Id_recg_ip,     ");
		sql.append("     a0.Id_srv,         ");
		sql.append("     a0.Id_srvca,       ");
		sql.append("     a0.Id_srvtp,       ");
		sql.append("     a0.Id_stip,        ");
		sql.append("     a0.Id_wg_or,       ");
		sql.append("     a0.Name_inccaitm,  ");
		sql.append("     a0.Name_mm,        ");
		sql.append("     a0.Name_srv ,       ");
		sql.append("     a0.Note,           ");
		sql.append("     a0.Onlycode,       ");
		sql.append("     a0.Pgku_base,      ");
		sql.append("     a0.Pgku_cur,       ");
		sql.append("     a0.Pri_ss,         ");
		sql.append("     a0.Price,          ");
		sql.append("     a0.Price_ratio,    ");
		sql.append("     a0.Quan*eu_direct quan,           ");
		sql.append("     a0.Quan_base,      ");
		sql.append("     a0.Ratio_hp,       ");
		sql.append("     a0.Ratio_pripat,   ");
		sql.append("     a0.Sd_mmtp,        ");
		sql.append("     a0.Sd_srvtp,       ");
		sql.append("     a0.Spec,           ");
		sql.append("     a0.Srcfunc_des,    ");
		sql.append("     a0.Srvu,           ");
		sql.append("     b0.name unit       ");

		sql.append(" from bl_cg_ip a0 left join bd_measdoc b0 on a0.srvu = b0.id_measdoc  ");

		SqlParam param = new SqlParam();

		// 获取BLSTIP0005母婴是否合并结算参数 by liwq 2017-9-23 16:09:17
		FBoolean isMerge =  BlParams.BLSTIP0005();
		// 查询母婴关系
		IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
		NewbornDO enNewBorn = enService.getNewbornDO(id_ent);
		// 需测试 母婴合并结算 禁止婴儿调用费用 ？？？？
		if (FBoolean.TRUE.equals(isMerge)) {
			if (enNewBorn != null) {
				sql.append(" where  ( a0.ID_ENT = ? or a0.id_ent = ? ) ");
				param.addParam(enNewBorn.getId_ent_mom());
			} else {
				sql.append(" where  ( a0.ID_ENT = ? or a0.id_ent_mom=? ) ");
				param.addParam(id_ent);
			}
		} else {
			sql.append(" where  ( a0.ID_ENT = ?  ) ");
		}
		param.addParam(id_ent);

		// 判断如果id_dep为*则查找所有科室的就诊,否则查找单科室的就诊数据
		if (!StringUtils.isBlank(id_dep) && !"*".equals(id_dep)) {
			sql.append(" AND a0.ID_DEP_OR = '").append(id_dep).append("' ");
		}

		String dt_end_str = "";
		if (!"".equals(map.get("dt_end").toString())) {
			FDateTime dt_end = new FDateTime(map.get("dt_end").toString());
			dt_end_str = dt_end.getDate().getDateAfter(1).toString()
					+ " 00:00:00";

		}
		sql.append(" AND a0.DT_CG < ?  ");
		param.addParam(dt_end_str);
		// 是否有结算数据
		FBoolean isSettled = new FBoolean(map.get("isSettled").toString());
		if (isSettled.booleanValue()) {
			StringBuilder sqlSt = new StringBuilder();
			sqlSt.append(
					"select id_stip from bl_st_ip where fg_canc = 'N' and id_ent = '")
					.append(id_ent).append("'  order by dt_end desc ");
			@SuppressWarnings("unchecked")
			List<String> idstipList = (List<String>) new DAFacade().execQuery(
					sqlSt.toString(), new ColumnListHandler());

			String id_stip = idstipList.get(0);
			sql.append(" and a0.fg_st = 'Y' and a0.id_stip = '")
					.append(id_stip).append("' ");
		} else {
			sql.append(" and a0.fg_st = 'N' ");
		}
		//保内外标识
		if(map.containsKey("fg_selfpay")){
			String fg_selfpay = map.get("fg_selfpay").toString();
			if(StringUtils.isNotBlank(fg_selfpay)){
				sql.append(" and a0.fg_selfpay = ? ");
				param.addParam(fg_selfpay);
			}
		}

		pageFeeDTO = service.findByPageInfo(new BlCgIpDTO(), pageInfo,
				sql.toString(), "", param);

		return pageFeeDTO;
	}

}
