package iih.bl.cg.bp.ip;



import iih.bl.cg.dto.d.BlAnalysisQueryNodeDTO;
import iih.bl.cg.dto.d.BlIpCgSrvSumDTO;
import iih.bl.params.BlParams;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 查询住院记账按服务的分组汇总信息
 * @author lpy
 *
 */
public class GetIpCgSrvSumListBP {
	/**
	 * 查询住院记账按服务的分组汇总信息
	 * @param entId 就诊id
	 * @param qryNode 查询模板
	 * @return 住院记账汇总信息集合
	 * @throws BizException
	 * @author liwq
	 */
	public BlIpCgSrvSumDTO[] exec(String entId,BlAnalysisQueryNodeDTO blAnalysisQuery) throws BizException{
//		 IQrySQLGeneratorService  ser =(IQrySQLGeneratorService) ServiceFinder.find(IQrySQLGeneratorService.class);
//		   String whereStr= ser.getQueryStringWithoutDesc(qryNode);
			
		FBoolean fg_merge =  BlParams.BLSTIP0005();//是否需要母婴合并结算
		   
		StringBuffer sb = new StringBuffer();
		//查询费用汇总时，不能按开立科室，执行科室就诊id分组，只能是单纯性的收费项目汇总
		sb.append(" select cgip.id_srv,cgip.name_srv,cgip.code_srv,cgip.id_mm,cgip.name_mm,");
		//sb.append(" decode(hpsrv.sd_hpsrvtp,'1','甲类','2','乙类','丙类') sd_hpsrvtp, ");
		sb.append("sum(cgip.amt_ratio*cgip.eu_direct) as amt_ratio,sum(cgip.quan*cgip.eu_direct) as quan,decode(mm.spec,'','/',mm.spec) spec,cgip.name_mm, ");
		sb.append("cgip.id_dep_or,cgip.id_dep_mp,dep1.name name_dep_or,dep2.name name_dep_mp ");
		sb.append("from  bl_cg_ip cgip ");	
		sb.append("LEFT JOIN bl_st_ip stip ON CGIP.id_stip = STIP.id_stip ");
		//sb.append("join bd_hp_srvorca  hpsrv on  (cgip.id_srv = hpsrv.id_srv and cgip.fg_mm='N') or (cgip.id_mm = hpsrv.id_mm and cgip.fg_mm = 'Y') ");
		sb.append(" left join bd_mm mm on mm.id_mm = cgip.id_mm ");
		sb.append(" left join bd_dep dep1 on dep1.id_dep=cgip.id_dep_or ");
		sb.append(" left join bd_dep dep2 on dep2.id_dep=cgip.id_dep_mp ");
		//TODO 这里临时使用未结算的记账
		if(FBoolean.TRUE.equals(fg_merge)){
			//合并显示母婴费用  select * from bl_cg_ip where id_ent=’?’ or id_ent_mom=’?’
			sb.append(" where NVL(stip.FG_CANC, 'N')='N' ");
			sb.append(" and cgip.fg_real = 'Y' ");
			sb.append(" AND NVL(STIP.EU_DIRECT, '1')='1'  ");
			sb.append("  and (cgip.id_ent ='").append(entId).append("' or id_ent_mom='").append(entId).append("') ");
		}else{
			//只显示母亲费用 select * from bl_cg_ip where id_ent=’?’
			sb.append(" where NVL(stip.FG_CANC, 'N')='N' ");
			sb.append(" and cgip.fg_real = 'Y' ");
			sb.append(" AND NVL(STIP.EU_DIRECT, '1')='1'  ");
			sb.append("  and cgip.id_ent ='").append(entId).append("' ");
		}
		
		StringBuffer buffer = analysis(blAnalysisQuery);
		sb.append(buffer);
		
		sb.append(" AND nvl(cgip.fg_research,'N')='N' ");
		sb.append(" group by  cgip.id_srv, cgip.id_mm, ");
		sb.append(" cgip.name_srv,cgip.code_srv, cgip.name_mm, ");
		sb.append(" cgip.id_dep_or,cgip.id_dep_mp,dep1.name,dep2.name, ");
		sb.append(" cgip.sd_srvtp, mm.spec  ");//,hpsrv.sd_hpsrvtp
		sb.append(" order by cgip.name_srv,cgip.name_mm ");
		@SuppressWarnings("unchecked")
		List<BlIpCgSrvSumDTO> list = (List<BlIpCgSrvSumDTO>) new DAFacade().execQuery(sb.toString(), new BeanListHandler(BlIpCgSrvSumDTO.class));

		return list.toArray(new BlIpCgSrvSumDTO[0]);
	}
	/**
	 * 
	 * @Description: 解析查询方案    
	 * @author: xy.zhou     
	 * @throws
	 */
	private StringBuffer analysis(BlAnalysisQueryNodeDTO blAnalysisQuery){
		StringBuffer sb=new StringBuffer();
		if (blAnalysisQuery!=null) {
			if (!StringUtil.isEmpty(blAnalysisQuery.getCode_inccaitm())) {
				sb.append(" and cgip.code_inccaitm = '").append(blAnalysisQuery.getCode_inccaitm()).append("'");
			}
			if (!StringUtil.isEmpty(blAnalysisQuery.getId_dep_mp())) {
				sb.append(" and cgip.id_dep_mp = '").append(blAnalysisQuery.getId_dep_mp()).append("'");;			
			}
			if (!StringUtil.isEmpty(blAnalysisQuery.getId_dep_or())) {
				sb.append("  and cgip.id_dep_or = '").append(blAnalysisQuery.getId_dep_or()).append("'");;
			}
			if (!StringUtil.isEmpty(blAnalysisQuery.getId_srv())) {
				sb.append(" and cgip.id_srv = '").append(blAnalysisQuery.getId_srv()).append("'");;
			}
			if (blAnalysisQuery.getDt_entry()!=null) {
				sb.append(" and cgip.dt_cg >= '").append(blAnalysisQuery.getDt_entry()).append("'");;
			}
			if (blAnalysisQuery.getDt_end()!=null) {
				sb.append(" and cgip.dt_cg <= '").append(blAnalysisQuery.getDt_end()).append("'");;
			}
			if (blAnalysisQuery.getFg_st()!=null) {
				if (blAnalysisQuery.getFg_st().booleanValue()) {
					sb.append(" and cgip.fg_st='Y' ");
				}else {
					sb.append(" and cgip.fg_st='N' ");
				}
			}
		}
		return sb;
	}
}
