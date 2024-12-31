package iih.bl.hp.s.bp;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取住院记账明细集合的就诊患者
 * @author hanjq 上午11:06:42 *
 */
public class GetHpPatiVisitBP {

	
	public PatiVisitDO[] exec(String condition, String orderBy, FBoolean isUpload) throws DAException {
		DAFacade daf = new DAFacade();
		String sql = getSql(condition, orderBy, isUpload);
		List<PatiVisitDO> PatiVisitDOs = (List<PatiVisitDO>) daf.execQuery(sql, new BeanListHandler(PatiVisitDO.class));
		PatiVisitDO[] datas = new PatiVisitDO[0];
		if(PatiVisitDOs != null && PatiVisitDOs.size() > 0){
			return PatiVisitDOs.toArray(datas );
		}
		return datas;
	}
	
	private String getSql(String wherePart, String orderBy, FBoolean isUpload) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT distinct  ");
		sb.append(" ent.Id_ent, ");
		sb.append(" ent.Id_hp, ");
//		sb.append(" pat.code pat_code, ");
		// 入科时间，DT_ACPT是登记时间
//		sb.append(" ent.DT_Entry, ");
//		sb.append(" (CASE ent.FG_IP WHEN 'Y' THEN '是' ELSE '否' END) IsIn,");
//		sb.append(" ent.code, ");
//		sb.append(" eip.TIMES_IP times_ip, ");
//		sb.append(" eip.Code_Amr_Ip,");
//		sb.append(" ent.Telno_pat, ");
//		sb.append(" depphy.name Name_dep_phy, ");
//		sb.append(" depnur.name Name_dep_nur, ");		
		sb.append(" ent.id_pat, ");
//		sb.append(" ent.code_entp, ");
//		sb.append(" ent.fg_ip, ");
//		sb.append(" ent.ID_dep_nur, ");
//		sb.append(" ent.ID_dep_phy, ");
//		sb.append(" ent.ID_emp_phy, ");
//		sb.append(" ent.DT_ACPT, ");
//		sb.append(" ent.ds, ");
		sb.append(" ent.sv ");
		sb.append(" FROM en_ent ent	");
		sb.append(" INNER JOIN bd_hp hp on hp.id_hp = ent.id_hp ");
//		sb.append(" INNER JOIN pi_pat pat ON ent.ID_PAT = pat.ID_PAT ");
//		sb.append(" LEFT OUTER JOIN EN_ENT_IP eip ON ent.ID_ENT = eip.ID_ENT ");
		//sb.append(" join bd_pri_pat pripat on ent.id_pripat=pripat.id_pripat ");
//		sb.append(" left join bd_dep depnur on ent.id_dep_nur=depnur.id_dep ");
//		sb.append(" left join bd_dep depphy on ent.ID_dep_phy=depphy.id_dep ");
		sb.append(" WHERE 1 = 1  AND ent.FG_CANC='N' ");//and cgip.fg_st = 'N' 
		sb.append(" AND nvl(ENT.id_hp,'~') <> '~' ");
		sb.append(" AND ent.fg_st = 'N'		 ");
		if(FBoolean.TRUE.equals(isUpload)){
			sb.append(" AND exists (select 1 from bl_cg_ip cgip where cgip.id_ent = ent.id_ent and cgip.fg_hp  = 'Y') ");
		}else{
			sb.append(" AND exists (select 1 from bl_cg_ip cgip where cgip.id_ent = ent.id_ent and cgip.fg_hp  = 'N') ");
		}
		
		if (StringUtils.isNotBlank(wherePart)) {
			sb.append(" and ").append(wherePart);
		}
		
//		sb.append(" order by ");
//		if(StringUtils.isNotBlank(orderBy)){
//			sb.append(orderBy);
//		}else{
//			sb.append(" ent.dt_entry desc");
//		}
		
		return sb.toString();
	}

}
