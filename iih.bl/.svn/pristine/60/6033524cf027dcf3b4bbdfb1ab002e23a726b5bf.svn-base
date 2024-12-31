package iih.bl.cg.s.bp.et;

import java.util.List;

import iih.bl.cg.dto.d.BlAnalysisQueryNodeDTO;
import iih.bl.cg.dto.d.BlIpCgDTO;
import iih.bl.cg.dto.d.BlIpCgSrvSumDTO;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
* @ClassName: GetEtCgListBySrvSumBP  
* @Description: 费用明细查询记账查询 
* @author xy.zhou
* @date 2019年3月15日
 */
public class GetEtCgListBySrvSumBP {
	
	public BlIpCgDTO[] exec(String entId, BlIpCgSrvSumDTO inIpCgSrvSumDto, BlAnalysisQueryNodeDTO blAnalysisQuery) throws BizException{
		
    	if(StringUtil.isEmpty(entId)){
    		throw new BizException("就诊id为空！");
    	}
    	Integer blst0002 = BlParams.BLST0002();
    	SqlParam param=new SqlParam();
    	String sql=null;
		if(blst0002==1){
			sql = this.getOepCgSql(entId, inIpCgSrvSumDto,blAnalysisQuery,param);
		}else if(blst0002==2){
			sql =this.getIpCgSql(entId, inIpCgSrvSumDto,blAnalysisQuery,param);
		}else{
			throw new BizException("参数BLST0002为空或者维护范围错误，参数 为："+blst0002);
		}
		@SuppressWarnings("unchecked")
		List<BlIpCgDTO> list = (List<BlIpCgDTO>) new DAFacade().execQuery(sql, param,new BeanListHandler(BlIpCgDTO.class));
		if(ListUtil.isEmpty(list)){
			return null;
		}
		return list.toArray(new BlIpCgDTO[]{});
	}
	private String getOepCgSql(String id_ent,BlIpCgSrvSumDTO inIpCgSrvSumDto, BlAnalysisQueryNodeDTO blAnalysisQuery,SqlParam param){
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("SELECT ITEM.ID_DEP_OR, ");
		sqlSb.append("       DEP.NAME AS NAME_DEP_OR, ");
		sqlSb.append("       ITEM.ID_DEP_MP, ");
		sqlSb.append("       DEP2.NAME AS NAME_DEP_MP, ");
		sqlSb.append("       ITEM.ID_SRV, ");
		sqlSb.append("       ITEM.NAME_SRV, ");
		sqlSb.append("       ITEM.PRICE_RATIO, ");
		sqlSb.append("       (ITEM.QUAN * CG.EU_DIRECT) AS QUAN_MEND, ");
		sqlSb.append("       ITEM.AMT_RATIO, ");
		sqlSb.append("       NVL(ITEM.SPEC, '/') SPEC, ");
		sqlSb.append("       ITEM.NAME_MM, ");
		sqlSb.append("       ITEM.ID_MM, ");
		sqlSb.append("       NVL(MEASDOC_CUR.ID_MEASDOC, '') IDUNIT, ");
		sqlSb.append("       NVL(CIOR.NAME_OR, '') NAME_OR, ");
		sqlSb.append("       NVL(PSN.NAME, '') NAME_EMP_OR, ");
		sqlSb.append("       ITEM.CODE_INCCAITM, ");
		sqlSb.append("       ITEM.NAME_INCCAITM, ");
		sqlSb.append("       CG.DT_CG, ");
		sqlSb.append("       PSN2.NAME AS NAME_EMP_CG, ");
		sqlSb.append("       DECODE(HPSRV.SD_HPSRVTP, '1', '甲类', '2', '乙类', '丙类') SD_HPSRVTP ");
		sqlSb.append("  FROM BL_CG_ITM_OEP ITEM ");
		sqlSb.append("  LEFT JOIN BL_CG_OEP CG ");
		sqlSb.append("    ON ITEM.ID_CGOEP = CG.ID_CGOEP ");
		sqlSb.append("  LEFT JOIN CI_ORDER CIOR ");
		sqlSb.append("    ON CIOR.ID_OR = ITEM.ID_OR ");
		sqlSb.append("  LEFT JOIN BD_PSNDOC PSN ");
		sqlSb.append("    ON ITEM.ID_EMP_OR = PSN.ID_PSNDOC ");
		sqlSb.append("  LEFT JOIN BD_DEP DEP ");
		sqlSb.append("    ON ITEM.ID_DEP_OR = DEP.ID_DEP ");
		sqlSb.append("  LEFT JOIN BD_DEP DEP2 ");
		sqlSb.append("    ON ITEM.ID_DEP_MP = DEP2.ID_DEP ");
		sqlSb.append("  LEFT JOIN BD_MEASDOC MEASDOC_CUR ");
		sqlSb.append("    ON MEASDOC_CUR.ID_MEASDOC = ITEM.PGKU_CUR ");
		sqlSb.append("  LEFT JOIN BD_HP_SRVORCA HPSRV ");
		sqlSb.append("    ON ((ITEM.ID_SRV = HPSRV.ID_SRV AND ITEM.FG_MM = 'N') OR ");
		sqlSb.append("       (ITEM.ID_MM = HPSRV.ID_MM AND ITEM.FG_MM = 'Y')) ");
		sqlSb.append("  LEFT JOIN BD_PSNDOC PSN2 ");
		sqlSb.append("    ON CG.ID_EMP_CG = PSN2.ID_PSNDOC");

		sqlSb.append(" where ITEM.id_ent=?");
		param.addParam(id_ent);
		//sqlSb.append("	AND nvl(ITEM.fg_research,'N')='N' ");
		
		if(!StringUtil.isEmpty(inIpCgSrvSumDto.getId_srv())){
			sqlSb.append(" and ITEM.id_srv = ?  ");
			param.addParam(inIpCgSrvSumDto.getId_srv());
		}
		if(!StringUtil.isEmpty(inIpCgSrvSumDto.getId_dep_mp())){
			sqlSb.append(" and ITEM.id_dep_mp=?");
			param.addParam(inIpCgSrvSumDto.getId_dep_mp());
		}
		if(!StringUtil.isEmpty(inIpCgSrvSumDto.getId_dep_or())){
			sqlSb.append(" and ITEM.id_dep_or=?");
			param.addParam(inIpCgSrvSumDto.getId_dep_or());
		}
		if(blAnalysisQuery.getDt_entry()!=null){
			sqlSb.append(" and cg.dt_cg >=?");
			param.addParam(blAnalysisQuery.getDt_entry());
		}
		if(blAnalysisQuery.getDt_end()!=null){
			sqlSb.append(" and cg.dt_cg <=?");
			param.addParam(blAnalysisQuery.getDt_end());
		}
		if (blAnalysisQuery.getFg_st()!=null) {
			if (blAnalysisQuery.getFg_st().booleanValue()) {
				sqlSb.append(" and ITEM.fg_st='Y' ");
			}else {
				sqlSb.append(" and ITEM.fg_st='N' ");
			}
		}
		return sqlSb.toString();
	}
	private String getIpCgSql(String id_ent,BlIpCgSrvSumDTO inIpCgSrvSumDto, BlAnalysisQueryNodeDTO blAnalysisQuery,SqlParam param){
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("SELECT CGIP.ID_DEP_OR, ");
		sqlSb.append("       DEP.NAME AS NAME_DEP_OR, ");
		sqlSb.append("       CGIP.ID_DEP_MP, ");
		sqlSb.append("       DEP2.NAME AS NAME_DEP_MP, ");
		sqlSb.append("       CGIP.ID_SRV, ");
		sqlSb.append("       CGIP.NAME_SRV, ");
		sqlSb.append("       CGIP.PRICE_RATIO, ");
		sqlSb.append("       (CGIP.QUAN * CGIP.EU_DIRECT) AS QUAN_MEND, ");
		sqlSb.append("       CGIP.AMT_RATIO, ");
		sqlSb.append("       NVL(CGIP.SPEC, '/') SPEC, ");
		sqlSb.append("       CGIP.NAME_MM, ");
		sqlSb.append("       CGIP.ID_MM, ");
		sqlSb.append("       NVL(MEASDOC_CUR.ID_MEASDOC,'') IDUNIT, ");
		sqlSb.append("       NVL(CIOR.NAME_OR,'')  NAME_OR, ");
		sqlSb.append("       NVL( PSN.NAME,'') NAME_EMP_OR, ");
		sqlSb.append("       CGIP.CODE_INCCAITM, ");
		sqlSb.append("       CGIP.NAME_INCCAITM, ");
		sqlSb.append("       CGIP.DT_CG, ");
		sqlSb.append("       PSN2.NAME AS NAME_EMP_CG, ");
		sqlSb.append("       CGIP.FG_BB, ");
		sqlSb.append("       DECODE(HPSRV.SD_HPSRVTP, '1', '甲类', '2', '乙类', '丙类') SD_HPSRVTP ");
		sqlSb.append("  FROM BL_CG_IP CGIP ");
		sqlSb.append(" ");
		sqlSb.append("  LEFT JOIN CI_ORDER CIOR ");
		sqlSb.append("    ON CIOR.ID_OR = CGIP.ID_OR ");
		sqlSb.append("  LEFT JOIN BD_PSNDOC PSN ");
		sqlSb.append("    ON CGIP.ID_EMP_OR = PSN.ID_PSNDOC ");
		sqlSb.append("  LEFT JOIN BD_DEP DEP ");
		sqlSb.append("    ON CGIP.ID_DEP_OR = DEP.ID_DEP ");
		sqlSb.append("  LEFT JOIN BD_DEP DEP2 ");
		sqlSb.append("    ON CGIP.ID_DEP_MP = DEP2.ID_DEP ");
		sqlSb.append("  LEFT  JOIN BD_MEASDOC MEASDOC_CUR ");
		sqlSb.append("    ON MEASDOC_CUR.ID_MEASDOC = CGIP.PGKU_CUR ");
		sqlSb.append("  LEFT JOIN BD_HP_SRVORCA HPSRV ");
		sqlSb.append("    ON ((CGIP.ID_SRV = HPSRV.ID_SRV AND CGIP.FG_MM = 'N') OR ");
		sqlSb.append("       (CGIP.ID_MM = HPSRV.ID_MM AND CGIP.FG_MM = 'Y')) ");
		sqlSb.append("  LEFT JOIN BD_PSNDOC PSN2 ");
		sqlSb.append("    ON CGIP.ID_EMP_CG = PSN2.ID_PSNDOC");
		
		sqlSb.append(" where cgip.id_ent=?");
		param.addParam(id_ent);
		sqlSb.append("	AND nvl(cgip.fg_research,'N')='N' ");
		
		if(!StringUtil.isEmpty(inIpCgSrvSumDto.getId_srv())){
			sqlSb.append(" and cgip.id_srv = ?  ");
			param.addParam(inIpCgSrvSumDto.getId_srv());
		}
		if(!StringUtil.isEmpty(inIpCgSrvSumDto.getId_dep_mp())){
			sqlSb.append(" and cgip.id_dep_mp=?");
			param.addParam(inIpCgSrvSumDto.getId_dep_mp());
		}
		if(!StringUtil.isEmpty(inIpCgSrvSumDto.getId_dep_or())){
			sqlSb.append(" and cgip.id_dep_or=?");
			param.addParam(inIpCgSrvSumDto.getId_dep_or());
		}
		if(blAnalysisQuery.getDt_entry()!=null){
			sqlSb.append(" and cgip.dt_cg >=?");
			param.addParam(blAnalysisQuery.getDt_entry());
		}
		if(blAnalysisQuery.getDt_end()!=null){
			sqlSb.append(" and cgip.dt_cg <=?");
			param.addParam(blAnalysisQuery.getDt_end());
		}
		if (blAnalysisQuery.getFg_st()!=null) {
			if (blAnalysisQuery.getFg_st().booleanValue()) {
				sqlSb.append(" and cgip.fg_st='Y' ");
			}else {
				sqlSb.append(" and cgip.fg_st='N' ");
			}
		}
		return sqlSb.toString();
	}
}
