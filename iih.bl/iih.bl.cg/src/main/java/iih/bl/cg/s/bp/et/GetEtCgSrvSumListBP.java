package iih.bl.cg.s.bp.et;

import java.util.List;

import iih.bl.cg.dto.d.BlAnalysisQueryNodeDTO;
import iih.bl.cg.dto.d.BlIpCgSrvSumDTO;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 
* @ClassName: GetEtCgSrvSumListBP  
* @Description: 查询留观记账按服务的分组汇总信息BP
* @author xy.zhou
* @date 2019年3月15日
 */
public class GetEtCgSrvSumListBP {

	public BlIpCgSrvSumDTO[] exec(String entId,BlAnalysisQueryNodeDTO blAnalysisQuery) throws BizException{
		
		if(StringUtil.isEmpty(entId)){
			throw new BizException("就诊id为空！");
		}
		
		Integer blst0002 = BlParams.BLST0002();
		
		String sql=null;
		if(blst0002==1){
			sql = this.getOepCgSql(entId, blAnalysisQuery);
		}else if(blst0002==2){
			sql =this.getIpCgSql(entId, blAnalysisQuery);
		}else{
			throw new BizException("参数BLST0002为空或者维护范围错误，参数 为："+blst0002);
		}
		@SuppressWarnings("unchecked")
		List<BlIpCgSrvSumDTO> list = (List<BlIpCgSrvSumDTO>) new DAFacade().execQuery(sql, new BeanListHandler(BlIpCgSrvSumDTO.class));
		
		return list.toArray(new BlIpCgSrvSumDTO[list.size()]);
	}
	
	private String getOepCgSql(String id_ent,BlAnalysisQueryNodeDTO blAnalysisQuery){
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("SELECT ITEM.id_srv, ");
		sqlSb.append("       ITEM.name_srv, ");
		sqlSb.append("       ITEM.code_srv, ");
		sqlSb.append("       ITEM.id_mm, ");
		sqlSb.append("       ITEM.name_mm, ");
		sqlSb.append("       decode(hpsrv.sd_hpsrvtp, '1', '甲类', '2', '乙类', '丙类') sd_hpsrvtp, ");
		sqlSb.append("       measdoc_cur.id_measdoc idunit, ");
		sqlSb.append("       sum(ITEM.amt_ratio * cg.eu_direct) as amt_ratio, ");
		sqlSb.append("       sum(ITEM.quan * cg.eu_direct) as quan, ");
		sqlSb.append("       decode(mm.spec, '', '/', mm.spec) spec, ");
		sqlSb.append("       ITEM.name_mm, ");
		sqlSb.append("       ITEM.id_dep_or, ");
		sqlSb.append("       ITEM.id_dep_mp, ");
		sqlSb.append("       dep1.name name_dep_or, ");
		sqlSb.append("       dep2.name name_dep_mp ");
		sqlSb.append("  FROM BL_CG_ITM_OEP ITEM ");
		sqlSb.append("  LEFT JOIN BL_CG_OEP CG ");
		sqlSb.append("    ON cg.id_cgoep = item.id_cgoep ");
		sqlSb.append("  LEFT JOIN bl_st_oep stop ");
		sqlSb.append("    on stop.id_stoep = item.id_stoep ");
		sqlSb.append("  LEFT JOIN BD_HP_SRVORCA HPSRV ");
		sqlSb.append("    ON ((ITEM.ID_SRV = HPSRV.ID_SRV AND ITEM.FG_MM = 'N') OR ");
		sqlSb.append("       (ITEM.ID_MM = HPSRV.ID_MM AND ITEM.FG_MM = 'Y')) ");
		sqlSb.append("  LEFT JOIN BD_MM MM ");
		sqlSb.append("    ON MM.ID_MM = ITEM.ID_MM ");
		sqlSb.append("  LEFT OUTER JOIN BD_MEASDOC MEASDOC_CUR ");
		sqlSb.append("    ON MEASDOC_CUR.ID_MEASDOC = ITEM.PGKU_CUR ");
		sqlSb.append("  LEFT JOIN BD_DEP DEP1 ");
		sqlSb.append("    ON DEP1.ID_DEP = ITEM.ID_DEP_OR ");
		sqlSb.append("  LEFT JOIN BD_DEP DEP2 ");
		sqlSb.append("    ON DEP2.ID_DEP = ITEM.ID_DEP_MP ");
		sqlSb.append(" where NVL(stop.FG_CANC, 'N') = 'N' ");
		sqlSb.append("   AND NVL(stop.EU_DIRECT, '1') = '1' ");
		sqlSb.append("  and ITEM.id_ent ='").append(id_ent).append("' ");

		StringBuffer buffer = analysis(blAnalysisQuery,"ITEM");
		sqlSb.append(buffer);
		if (blAnalysisQuery.getDt_entry()!=null) {
			sqlSb.append(" and cg.dt_cg >= '").append(blAnalysisQuery.getDt_entry()).append("'");;
		}
		if (blAnalysisQuery.getDt_end()!=null) {
			sqlSb.append(" and cg.dt_cg <= '").append(blAnalysisQuery.getDt_end()).append("'");;
		}
		sqlSb.append(" group by ITEM.id_srv, ");
		sqlSb.append("          ITEM.id_mm, ");
		sqlSb.append("          measdoc_cur.id_measdoc, ");
		sqlSb.append("          ITEM.name_srv, ");
		sqlSb.append("          ITEM.code_srv, ");
		sqlSb.append("          ITEM.name_mm, ");
		sqlSb.append("          ITEM.id_dep_or, ");
		sqlSb.append("          ITEM.id_dep_mp, ");
		sqlSb.append("          dep1.name, ");
		sqlSb.append("          dep2.name, ");
		sqlSb.append("          ITEM.sd_srvtp, ");
		sqlSb.append("          hpsrv.sd_hpsrvtp, ");
		sqlSb.append("          mm.spec ");
		sqlSb.append(" order by ITEM.name_srv, ITEM.name_mm");

		return sqlSb.toString();
	}
	
	private String getIpCgSql(String id_ent,BlAnalysisQueryNodeDTO blAnalysisQuery){
		
		StringBuffer sb = new StringBuffer();
		//查询费用汇总时，不能按开立科室，执行科室就诊id分组，只能是单纯性的收费项目汇总
		sb.append(" select cgip.id_srv,cgip.name_srv,cgip.code_srv,cgip.id_mm,cgip.name_mm,");
		sb.append(" decode(hpsrv.sd_hpsrvtp,'1','甲类','2','乙类','丙类') sd_hpsrvtp, ");
		sb.append(" measdoc_cur.id_measdoc idunit, ");
		sb.append("sum(cgip.amt_ratio*cgip.eu_direct) as amt_ratio, sum(cgip.quan*cgip.eu_direct) as quan,decode(mm.spec,'','/',mm.spec) spec,cgip.name_mm, ");
		sb.append("cgip.id_dep_or,cgip.id_dep_mp,dep1.name name_dep_or,dep2.name name_dep_mp ");
		sb.append("from  bl_cg_ip cgip ");	
		sb.append("LEFT JOIN bl_st_ip stip ON CGIP.id_stip = STIP.id_stip ");
		sb.append("LEFT JOIN bd_hp_srvorca  hpsrv on  ((cgip.id_srv = hpsrv.id_srv and cgip.fg_mm='N') or (cgip.id_mm = hpsrv.id_mm and cgip.fg_mm = 'Y')) ");
		sb.append(" left join bd_mm mm on mm.id_mm = cgip.id_mm ");
		sb.append(" LEFT outer JOIN BD_MEASDOC measdoc_cur  ");
		sb.append(" ON measdoc_cur.id_measdoc = cgip.pgku_cur ");
		sb.append(" left join bd_dep dep1 on dep1.id_dep=cgip.id_dep_or ");
		sb.append(" left join bd_dep dep2 on dep2.id_dep=cgip.id_dep_mp ");
		//TODO 这里临时使用未结算的记账

		//只显示母亲费用 select * from bl_cg_ip where id_ent=’?’
		sb.append(" where NVL(stip.FG_CANC, 'N')='N' ");
		sb.append(" AND NVL(STIP.EU_DIRECT, '1')='1'  ");
		sb.append("  and cgip.id_ent ='").append(id_ent).append("' ");

		StringBuffer buffer = analysis(blAnalysisQuery,"cgip");
		sb.append(buffer);
		if (blAnalysisQuery.getDt_entry()!=null) {
			sb.append(" and cgip.dt_cg >= '").append(blAnalysisQuery.getDt_entry()).append("'");;
		}
		if (blAnalysisQuery.getDt_end()!=null) {
			sb.append(" and cgip.dt_cg <= '").append(blAnalysisQuery.getDt_end()).append("'");;
		}
		sb.append(" AND nvl(cgip.fg_research,'N')='N' ");
		sb.append(" group by  cgip.id_srv, cgip.id_mm, ");
		sb.append(" measdoc_cur.id_measdoc, ");
		sb.append(" cgip.name_srv,cgip.code_srv, cgip.name_mm, ");
		sb.append(" cgip.id_dep_or,cgip.id_dep_mp,dep1.name,dep2.name, ");
		sb.append(" cgip.sd_srvtp,hpsrv.sd_hpsrvtp, mm.spec  ");
		sb.append(" order by cgip.name_srv,cgip.name_mm ");
		return sb.toString();
	}
	/**
	 * 
	 * @Description: 解析查询方案    
	 * @author: xy.zhou     
	 * @throws
	 */
	private StringBuffer analysis(BlAnalysisQueryNodeDTO blAnalysisQuery,String param){
		StringBuffer sb=new StringBuffer();
		if (blAnalysisQuery!=null) {
			if (!StringUtil.isEmpty(blAnalysisQuery.getCode_inccaitm())) {
				sb.append(" and ").append(param).append(".code_inccaitm = '").append(blAnalysisQuery.getCode_inccaitm()).append("'");
			}
			if (!StringUtil.isEmpty(blAnalysisQuery.getId_dep_mp())) {
				sb.append(" and ").append(param).append(".id_dep_mp = '").append(blAnalysisQuery.getId_dep_mp()).append("'");;			
			}
			if (!StringUtil.isEmpty(blAnalysisQuery.getId_dep_or())) {
				sb.append(" and ").append(param).append(".id_dep_or = '").append(blAnalysisQuery.getId_dep_or()).append("'");;
			}
			if (!StringUtil.isEmpty(blAnalysisQuery.getId_srv())) {
				sb.append(" and ").append(param).append(".id_srv = '").append(blAnalysisQuery.getId_srv()).append("'");;
			}
			if (blAnalysisQuery.getFg_st()!=null) {
				if (blAnalysisQuery.getFg_st().booleanValue()) {
					sb.append(" and ").append(param).append(".fg_st='Y' ");
				}else {
					sb.append(" and ").append(param).append(".fg_st='N' ");
				}
			}
		}
		return sb;
	}
}
