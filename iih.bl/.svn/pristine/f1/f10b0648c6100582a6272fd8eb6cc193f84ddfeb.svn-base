package iih.bl.st.s.bp.op;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.st.dto.d.BlStReFundBillDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 根据结算Id查询退费信息
 * @author wq.li
 *
 */
public class FindOepCgItmByStIdsBP {
	
	public BlStReFundBillDTO[] exec(String[] stIdArr) throws BizException
	{
		if(ArrayUtil.isEmpty(stIdArr))
		{
			return null;
		}
		

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT DISTINCT ");
		sql.append(" CGITEM.id_pat, ");
		sql.append(" CGITEM.id_ent, ");
		sql.append(" CGITEM.id_dep_mp, ");
		sql.append(" DEP.NAME name_dep_mp, ");
		sql.append(" dep.code code_dep_mp, ");
		sql.append(" CIORDER.DES_OR, ");
		sql.append(" CIORDER.name_or, ");
		sql.append(" CGITEM.id_or, ");
		sql.append(" CGITEM.name_srv, ");
		sql.append(" NVL (CGITEM.CODE_MM, CGITEM.CODE_SRV) code_srv, ");
		sql.append(" CGITEM.sd_srvtp, ");
		sql.append(" '' can_return, ");
		// 添加补费数据默认可退
		sql.append(
				" (CASE CGITEM.FG_ADDITM WHEN 'Y' THEN CGITEM.FG_ADDITM ELSE CIORDERSRV.fg_feertnable END) fg_feertnable, ");
		sql.append(" CGITEM.srvu, ");
		sql.append(" MEASDOC. NAME srvu_name, ");
		sql.append(" CGITEM.price, ");
		sql.append(" CGITEM.price_ratio, ");
		sql.append(" 0 return_quan, ");
		sql.append(" CGITEM.quan can_quan, ");
		sql.append(" CGITEM.quan, ");
		sql.append(" CGITEM.onlycode, ");
		sql.append(" CGITEM.amt, ");
		sql.append(" CGITEM.amt_std, ");
		sql.append(" CGITEM.amt_ratio, ");
		sql.append(" CGITEM.amt_pat, ");
		sql.append(" CGITEM.sd_hpsrvtp, ");
		sql.append(" CGITEM.id_hp, ");
		sql.append(" CGITEM.ratio_hp, ");
		sql.append(" CGITEM.amt_hp, ");
		sql.append(" CGITEM.fg_hp, ");
		sql.append(" CIORDERSRV.fg_specill fg_hpspcl, ");
		sql.append(" CGITEM.id_pres, ");
		sql.append(" nvl(pres.name,CIORDER.name_or) name_pres, ");
		sql.append(" CGITEM.id_cgitmoep, ");
		sql.append(" CGITEM.id_cgoep, ");
		sql.append(" CGITEM.Id_hpsrvmpayratio, ");
		// 设置单据分组数据----
		sql.append(" (DECODE(CGITEM.code_applytp, ");
		sql.append("'" + IBdSrvDictCodeConst.DRUG_TYPE + "','药品'");
		sql.append(",'" + IBdSrvDictCodeConst.RIS_TYPE + "','检查'");
		sql.append(",'" + IBdSrvDictCodeConst.LIS_TYPE + "','检验'");
		sql.append(",'" + IBdSrvDictCodeConst.TREATMENT_TYPE + "','诊疗'");
		sql.append(", '诊疗')||'\n'||'就诊次数:'||ENTOP.TIMES_OP||'\n'||'单据号:'||CGITEM.code_apply) code_apply,");
		// ---------------
		sql.append(" CGITEM.id_stoep, ");
		sql.append(" CGITEM.ratio_pripat, ");
		sql.append(" CGITEM.fg_mm, ");
		sql.append(" '' fg_pat_getmm, ");
		sql.append(" CGITEM.id_orsrv, ");
		sql.append(" cg.dt_cg, ");
		sql.append(" CGITEM.id_mm, ");
		sql.append(" CGITEM.id_srv, ");
		sql.append(" CGITEM.pgku_cur Req_unit_id, ");
		sql.append(" CGITEM.id_dep_mp Id_dep, ");
		sql.append(" CGITEM.id_dep_wh Id_dep_wh, ");
		sql.append(" CGITEM.fg_free, ");
		sql.append("  cgitem.name_mm, ");
		sql.append(" cgitem.code_mm, ");
		sql.append("  cgitem.code_inccaitm,");
		sql.append("  cgitem.name_inccaitm,");
		sql.append("  cgitem.spec,");
		sql.append(" cgitem.id_dep_or,");
		sql.append("  ordep.name name_dep_or, ");
		sql.append(" ordep.code code_dep_or, ");
		sql.append(" cgitem.id_emp_or, ");
		sql.append(" orpsn.code code_emp_or, ");
		sql.append(" orpsn.name name_emp_or ");
		sql.append(" FROM  ");
		sql.append(" BL_CG_ITM_OEP CGITEM ");
		sql.append(" left join bl_cg_oep cg on cg.id_cgoep=cgitem.id_cgoep ");
		sql.append(" INNER JOIN BD_DEP DEP ON CGITEM.id_dep_mp = DEP.id_dep ");
		sql.append(" left join bd_dep ordep on ordep.id_dep=cgitem.id_dep_or ");
		sql.append(" left join bd_psndoc orpsn on orpsn.id_psndoc = cgitem.id_emp_or ");
		sql.append(" LEFT OUTER JOIN CI_ORDER CIORDER ON CGITEM.id_or = CIORDER.ID_OR ");
		sql.append(" LEFT OUTER JOIN ci_or_srv CIORDERSRV ON CGITEM.Id_Orsrv = CIORDERSRV.Id_Orsrv ");
		sql.append(" LEFT OUTER JOIN bd_measdoc MEASDOC ON CGITEM.srvu = MEASDOC.id_measdoc ");
		sql.append(" LEFT OUTER JOIN EN_ENT_OP ENTOP ON CGITEM.id_ent = ENTOP.id_ent ");
		sql.append(" left join ci_pres pres on pres.id_pres=CGITEM.id_pres ");
		sql.append(" WHERE ");
		
		sql.append(SqlUtils.getInSqlByIds("CGITEM.ID_STOEP", stIdArr)) ;

		List<BlStReFundBillDTO> list = (List<BlStReFundBillDTO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(BlStReFundBillDTO.class));
		
		return list.toArray(new BlStReFundBillDTO[0]);
	}

}
