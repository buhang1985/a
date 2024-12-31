package iih.bl.cg.s.bp.et;

import java.util.List;

import iih.bl.cg.dto.d.BlInccaItmDTO;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
* @ClassName: GetEtInccaItmListBP  
* @Description: 获取门诊\住院账单项集合
* @author xy.zhou
* @date 2019年3月16日
 */
public class GetEtInccaItmListBP {

	public BlInccaItmDTO[] exec(String entId,String inccaItmCode , String id_stoep) throws BizException{
		
		if(StringUtil.isEmpty(entId)){
			throw new BizException("就诊id为空！");
		}
		
		Integer blst0002 = BlParams.BLST0002();
		String sql=null;
		SqlParam param=new SqlParam();
		if(blst0002==1){
			sql=this.getOepSql(entId,inccaItmCode,id_stoep,param);
		}else if(blst0002==2){
			sql=this.getIpSql(entId,inccaItmCode,id_stoep,param);
		}else{
			throw new BizException("参数BLST0002为空或者维护范围错误，参数 为："+blst0002);
		}
		@SuppressWarnings("unchecked")
		List<BlInccaItmDTO> list = (List<BlInccaItmDTO>) new DAFacade().execQuery(sql,param, new BeanListHandler(BlInccaItmDTO.class));
		if(ListUtil.isEmpty(list)){
			return null;
		}
		return list.toArray(new BlInccaItmDTO []{});
	}
	/**
	 * 获取门诊sql
	 */
	private  String getOepSql(String entId,String inccaItmCode , String id_stoep,SqlParam param){
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("SELECT ITEM.NAME_INCCAITM NAME_INCCAITM, ");
		sqlSb.append("       ITEM.CODE_INCCAITM CODE_INCCAITM, ");
		sqlSb.append("       SUM(ITEM.AMT_RATIO * CG.EU_DIRECT) AMT_RATIO, ");
		sqlSb.append("       DEP1.NAME NAME_DEP_OR, ");
		sqlSb.append("       DEP2.NAME NAME_DEP_MP, ");
		sqlSb.append("       ITEM.ID_DEP_OR, ");
		sqlSb.append("       ITEM.ID_DEP_MP, ");
		sqlSb.append("       SUBSTR(CG.DT_CG, 1, 10) Dt_CG ");
		sqlSb.append("  FROM BL_CG_ITM_OEP ITEM ");
		sqlSb.append("  LEFT JOIN BL_CG_OEP CG ");
		sqlSb.append("    ON CG.ID_CGOEP = ITEM.ID_CGOEP ");
		sqlSb.append("  LEFT JOIN BL_ST_OEP STOEP ");
		sqlSb.append("    ON ITEM.ID_STOEP = STOEP.ID_STOEP ");
		sqlSb.append("  LEFT JOIN BD_DEP DEP1 ");
		sqlSb.append("    ON DEP1.ID_DEP = ITEM.ID_DEP_OR ");
		sqlSb.append("  LEFT JOIN BD_DEP DEP2 ");
		sqlSb.append("    ON DEP2.ID_DEP = ITEM.ID_DEP_MP ");
		sqlSb.append(" WHERE ITEM.ID_ENT =? ");
		param.addParam(entId);
		sqlSb.append("   AND ITEM.CODE_INCCAITM =? ");
		param.addParam(inccaItmCode);
		sqlSb.append("   AND NVL(STOEP.FG_CANC, 'N') = 'N' ");
		sqlSb.append("   AND NVL(STOEP.EU_DIRECT, '1') = '1' ");
		if(!StringUtil.isEmpty(id_stoep)){
			sqlSb.append(" AND ITEM.ID_STOEP =?");
			param.addParam(id_stoep);
		}else{
			sqlSb.append(" AND ITEM.FG_ST = 'N'" );
		}
		sqlSb.append(" GROUP BY (ITEM.NAME_INCCAITM, ITEM.CODE_INCCAITM, ");
		sqlSb.append("           SUBSTR(CG.DT_CG, 1, 10), DEP1.NAME, DEP2.NAME, ITEM.ID_DEP_OR, ");
		sqlSb.append("           ITEM.ID_DEP_MP) ");
		sqlSb.append(" ORDER BY SUBSTR(CG.DT_CG, 1, 10)");

		return sqlSb.toString();
	}
	/**
	 * 获取门诊sql
	 */
	private  String getIpSql(String entId,String inccaItmCode , String id_stoep,SqlParam param){
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("SELECT cgip.NAME_INCCAITM Name_inccaitm, ");
		sqlSb.append("       cgip.CODE_INCCAITM Code_inccaitm, ");
		sqlSb.append("       SUM(cgip.amt_ratio * cgip.EU_DIRECT) Amt_ratio, ");
		sqlSb.append("       dep1.name Name_dep_or, ");
		sqlSb.append("       dep2.name Name_dep_mp, ");
		sqlSb.append("       cgip.id_dep_or, ");
		sqlSb.append("       cgip.id_dep_mp, ");
		sqlSb.append("       SUBSTR(CGIP.dt_cg, 1, 10) Dt_cg ");
		sqlSb.append("  FROM BL_CG_IP cgip ");
		sqlSb.append("  LEFT JOIN bl_st_ip stip ");
		sqlSb.append("    ON CGIP.id_stip = STIP.id_stip ");
		sqlSb.append("  left join bd_dep dep1 ");
		sqlSb.append("    on dep1.id_dep = cgip.id_dep_or ");
		sqlSb.append("  left join bd_dep dep2 ");
		sqlSb.append("    on dep2.id_dep = cgip.id_dep_mp ");
		sqlSb.append(" WHERE cgip.ID_ENT =? ");
		param.addParam(entId);
		sqlSb.append("   AND cgip.CODE_INCCAITM =? ");
		param.addParam(inccaItmCode);
		sqlSb.append("   AND NVL(stip.FG_CANC, 'N') = 'N' ");
		sqlSb.append("   AND NVL(STIP.EU_DIRECT, '1') = '1' ");
		if(!StringUtil.isEmpty(id_stoep)){
			sqlSb.append(" and cgip.id_stip =?");
			param.addParam(id_stoep);
		}else{
			sqlSb.append(" and cgip.fg_st = 'N'" );
		}
		sqlSb.append(" GROUP BY (cgip.NAME_INCCAITM, cgip.CODE_INCCAITM, ");
		sqlSb.append("           SUBSTR(CGIP.dt_cg, 1, 10), dep1.name, dep2.name, ");
		sqlSb.append("           cgip.id_dep_or, cgip.id_dep_mp) ");
		sqlSb.append(" ORDER BY SUBSTR(CGIP.dt_cg, 1, 10)");

		return sqlSb.toString();
	}
}
