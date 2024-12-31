package iih.hp.cp.hpcpvarirsnstatdto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.sys.jdbc.handler.BeanListHandler;

public class HpcpVariRsnStatService {
	
	//诊疗路径启用状态
	private static final String HPCP_STATUS_ENABLE = "30";
	//不执行匹配人数
	private static final String NUM_TYPE_NOEXCU = "10";
	//门诊或院方已查
	private static final String NUM_TYPE_CHECKED = "1005";
	//患方不同意
	private static final String NUM_TYPE_NOAGREE = "1010";
	//患方原因(病情需要)
	private static final String NUM_TYPE_NEEDED = "1015";
	//患方原因(患方要求)
	private static final String NUM_TYPE_PATIENT= "1020";
	//医护原因
	private static final String NUM_TYPE_MEDICAL = "1025";
	//医院客观原因
	private static final String NUM_TYPE_HOSPITAL = "1030";
	//其他
	private static final String NUM_TYPE_OTHER = "1035";
	
	public List<?> fillBeanList(String dateBegin, String dateEnd, String id_dep, String id_cp, String id_grp, String id_org) throws Exception {
		if("null".equals(dateBegin) && "null".equals(dateEnd) && "null".equals(id_dep) && "null".equals(id_cp)) {
			return new ArrayList<HpcpVarirsnStatDTO>();
		}
		
		//诊疗路径获取
		List<HpcpVarirsnStatDTO> hpcpInfos = this.getHpcpInfo(id_cp, id_grp, id_org);
		if(hpcpInfos == null || hpcpInfos.size() <= 0) {
			return new ArrayList<HpcpVarirsnStatDTO>();
		}
		
		List<HpcpVarirsnStatDTO> result = new ArrayList<HpcpVarirsnStatDTO>();
		for(HpcpVarirsnStatDTO hpcpInfo : hpcpInfos) {
			HpcpVarirsnStatDTO hpcpVarirsnStatDTO = new HpcpVarirsnStatDTO();
			
			//路径主键
			hpcpVarirsnStatDTO.setId_cp(String.valueOf(hpcpInfo.getId_cp()));
			
			//路径名称
			hpcpVarirsnStatDTO.setCp_name(String.valueOf(hpcpInfo.getCp_name()));
			
			//住院科室
			hpcpVarirsnStatDTO.setDep_name(this.getDepName(dateBegin, dateEnd, id_dep, String.valueOf(hpcpInfo.getId_cp())));
			
			//变异人次
			Integer variNum = this.getHpcpVariNum(dateBegin, dateEnd, id_dep, String.valueOf(hpcpInfo.getId_cp()), NUM_TYPE_NOEXCU);
			hpcpVarirsnStatDTO.setVari_num(variNum);
			
			if(variNum == 0) {
				//门诊或外院已查(人次、占比)
				hpcpVarirsnStatDTO.setChecked_num(0);
				hpcpVarirsnStatDTO.setCheckde_rate("0");
				
				//患方不同意(人次、占比)
				hpcpVarirsnStatDTO.setNoagree_num(0);
				hpcpVarirsnStatDTO.setNoagree_rate("0");
				
				//患方原因(病情需要)(人次、占比)
				hpcpVarirsnStatDTO.setNeeded_num(0);
				hpcpVarirsnStatDTO.setNeeded_rate("0");
				
				//患方原因(患方要求)(人次、占比)
				hpcpVarirsnStatDTO.setPatient_num(0);
				hpcpVarirsnStatDTO.setPatient_rate("0");
				
				//医护原因(人次、占比)
				hpcpVarirsnStatDTO.setMedical_num(0);
				hpcpVarirsnStatDTO.setMedical_rate("0");
				
				//医护客观原因(人次、占比)
				hpcpVarirsnStatDTO.setHospital_num(0);
				hpcpVarirsnStatDTO.setHostipal_rate("0");
				
				//其他(人次、占比)
				hpcpVarirsnStatDTO.setOther_num(0);
				hpcpVarirsnStatDTO.setOther_rate("0");
			} else {
				//门诊或外院已查(人次、占比)
				Integer checkedNum = this.getHpcpVariNum(dateBegin, dateEnd, id_dep, String.valueOf(hpcpInfo.getId_cp()), NUM_TYPE_CHECKED);
				hpcpVarirsnStatDTO.setChecked_num(checkedNum);
				
				if(checkedNum == 0) {
					hpcpVarirsnStatDTO.setCheckde_rate("0");
				} else {
					hpcpVarirsnStatDTO.setCheckde_rate(this.getRate(variNum, checkedNum).get(0).getRate());
				}
				
				//患方不同意(人次、占比)
				Integer noAgreeNum = this.getHpcpVariNum(dateBegin, dateEnd, id_dep, String.valueOf(hpcpInfo.getId_cp()), NUM_TYPE_NOAGREE);
				hpcpVarirsnStatDTO.setNoagree_num(noAgreeNum);

				if(noAgreeNum == 0) {
					hpcpVarirsnStatDTO.setNoagree_rate("0");
				} else {
					hpcpVarirsnStatDTO.setNoagree_rate(this.getRate(variNum, noAgreeNum).get(0).getRate());
				}
				
				//患方原因(病情需要)(人次、占比)
				Integer neededNum = this.getHpcpVariNum(dateBegin, dateEnd, id_dep, String.valueOf(hpcpInfo.getId_cp()), NUM_TYPE_NEEDED);
				hpcpVarirsnStatDTO.setNeeded_num(neededNum);
				
				if(neededNum == 0) {
					hpcpVarirsnStatDTO.setNeeded_rate("0");
				} else {
					hpcpVarirsnStatDTO.setNeeded_rate(this.getRate(variNum, neededNum).get(0).getRate());
				}
				
				//患方原因(患方要求)(人次、占比)
				Integer patientNum = this.getHpcpVariNum(dateBegin, dateEnd, id_dep, String.valueOf(hpcpInfo.getId_cp()), NUM_TYPE_PATIENT);
				hpcpVarirsnStatDTO.setPatient_num(patientNum);
				
				if(patientNum == 0) {
					hpcpVarirsnStatDTO.setPatient_rate("0");
				} else {
					hpcpVarirsnStatDTO.setPatient_rate(this.getRate(variNum, patientNum).get(0).getRate());
				}
				
				//医护原因(人次、占比)
				//医护原因(人次)
				Integer medicalNum = this.getHpcpVariNum(dateBegin, dateEnd, id_dep, String.valueOf(hpcpInfo.getId_cp()), NUM_TYPE_MEDICAL);
				hpcpVarirsnStatDTO.setMedical_num(medicalNum);
				
				if(medicalNum == 0) {
					hpcpVarirsnStatDTO.setMedical_rate("0");
				} else {
					hpcpVarirsnStatDTO.setMedical_rate(this.getRate(variNum, medicalNum).get(0).getRate());
				}
				
				//医护客观原因(人次、占比)
				Integer hospitalNum = this.getHpcpVariNum(dateBegin, dateEnd, id_dep, String.valueOf(hpcpInfo.getId_cp()), NUM_TYPE_HOSPITAL);
				hpcpVarirsnStatDTO.setHospital_num(hospitalNum);
				
				if(hospitalNum == 0) {
					hpcpVarirsnStatDTO.setHostipal_rate("0");
				} else {
					hpcpVarirsnStatDTO.setHostipal_rate(this.getRate(variNum, hospitalNum).get(0).getRate());
				}
				
				//其他(人次、占比)
				Integer otherNum = this.getHpcpVariNum(dateBegin, dateEnd, id_dep, String.valueOf(hpcpInfo.getId_cp()), NUM_TYPE_OTHER);
				hpcpVarirsnStatDTO.setOther_num(otherNum);

				if(otherNum == 0) {
					hpcpVarirsnStatDTO.setOther_rate("0");
				} else {
					hpcpVarirsnStatDTO.setOther_rate(this.getRate(variNum, otherNum).get(0).getRate());
				}
			}
			
			result.add(hpcpVarirsnStatDTO);
		}
		
		return result;
	}
	
	private List<HpcpVarirsnStatDTO> getHpcpInfo(String id_cp, String id_grp, String id_org) throws Exception {
		StringBuffer strSql = new StringBuffer();
		strSql.append(" select id_cp, name cp_name");
		strSql.append(" from HP_CP ");
		strSql.append(" where sd_status = '" + HPCP_STATUS_ENABLE + "' ");
		strSql.append(" and id_grp = '" + id_grp + "' ");
		strSql.append(" and id_org = '" + id_org + "' ");
		strSql.append(" and ds = 0 ");
		if(!StringUtils.isBlank(id_cp) && !"null".equals(id_cp) && !"".equals(id_cp.trim())) {
			strSql.append(" and id_cp = '" + id_cp + "' ");
		}
		strSql.append(" order by code ");
		
		return this.getResultBySql(strSql.toString());
	}
	
	@SuppressWarnings("unchecked")
	private List<HpcpVarirsnStatDTO> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(HpcpVarirsnStatDTO.class);
		List<HpcpVarirsnStatDTO> result = (List<HpcpVarirsnStatDTO>)beanlist_handler.processRs(cached_rs);

		sql_rdr.destroy();
		
		if(result == null || result.size() <= 0) {
			return null;
		}
		
		return result;
	}
	
	private String getDepName(String dateBegin, String dateEnd, String id_dep,
			String id_cp) throws Exception {
		StringBuffer strSql = new StringBuffer();
		if(StringUtils.isBlank(id_dep) || "null".equals(id_dep) || "".equals(id_dep.trim())) {
			strSql.append(" select BD_DEP.name dep_name ");
			strSql.append(" from HP_CP_APP APP ");
			strSql.append(" inner join EN_ENT ENT on APP.Id_Ent = ENT.Id_Ent ");
			strSql.append(" inner join EN_ENT_IP ENTIP on ENTIP.Id_Ent = ENT.Id_Ent ");
			strSql.append(" left outer join BD_DEP on ENTIP.Id_Dep_Phydisc = BD_DEP.Id_Dep ");
			strSql.append(" where ENT.code_entp = '10' and ENT.Fg_Canc = 'N' and ENT.Fg_ip = 'N' ");
            if(!StringUtils.isBlank(dateBegin) && !"null".equals(dateBegin) && !"".equals(dateBegin.trim())) {
				strSql.append(" and ENT.Dt_End >= '" + dateBegin + "' ");
			}
            if(!StringUtils.isBlank(dateEnd) && !"null".equals(dateEnd) && !"".equals(dateEnd.trim())) {
				strSql.append(" and ENT.Dt_End <= '" + dateEnd + "' ");
			}
			strSql.append(" and APP.Id_Cp = '" + id_cp + "' ");
			strSql.append(" and BD_DEP.name is not null ");
		} else {
			strSql.append(" select name dep_name from BD_DEP where id_dep = '" + id_dep + "' ");
		}
		
		List<HpcpVarirsnStatDTO> result = this.getResultBySql(strSql.toString());
		
		if(result != null && result.size() >= 0) {
			return String.valueOf(result.get(0).getDep_name());
		}
		return null;
	}
	
	private Integer getHpcpVariNum(String dateBegin, String dateEnd,
			String id_dep, String id_cp, String numType) throws Exception {
		StringBuffer strSql = new StringBuffer();
		strSql.append(" select distinct APP.ID_CPAPP ");
		strSql.append(" from HP_CP_APP APP ");
		strSql.append(" inner join HP_CP_APP_ALTER_LOG ALTER_LOG on APP.Id_Cpapp = ALTER_LOG.ID_CPAPP ");
		strSql.append(" inner join EN_ENT ENT on APP.Id_Ent = ENT.Id_Ent ");
		strSql.append(" inner join EN_ENT_IP ENTIP on ENT.Id_Ent = ENTIP.Id_Ent ");
		strSql.append(" where ENT.code_entp = '10' and ENT.Fg_Canc = 'N' and ENT.Fg_ip = 'N' ");
		if(!StringUtils.isBlank(dateBegin) && !"null".equals(dateBegin) && !"".equals(dateBegin.trim())) {
			strSql.append(" and ENT.Dt_End >= '" + dateBegin + "' ");
		}
		if(!StringUtils.isBlank(dateEnd) && !"null".equals(dateEnd) && !"".equals(dateEnd.trim())) {
			strSql.append(" and ENT.Dt_End <= '" + dateEnd + "' ");
		}
		if(!StringUtils.isBlank(id_dep) && !"null".equals(id_dep) && !"".equals(id_dep.trim())) {
			strSql.append(" and ENTIP.Id_Dep_Phydisc = '" + id_dep + "' ");
		}
		strSql.append(" and ALTER_LOG.Sd_Alter_Rsn_Tp like '%" + numType + "%' ");
		strSql.append(" and APP.Id_Cp = '" + id_cp + "' ");

		List<HpcpVarirsnStatDTO> result = this.getResultBySql(strSql.toString());
		
		if(result != null && result.size() >= 0) {
			return result.size();
		}
		
		return 0;
	}
	
	private List<HpcpVarirsnStatDTO> getRate(Integer rateDeno, Integer rateMole) throws Exception {
		StringBuffer strSql = new StringBuffer();
		strSql.append(" select  to_char(round(" + String.valueOf(rateMole) + "/" + String.valueOf(rateDeno) + " * 100, 2),  'FM999.00') || '%' rate " );
		strSql.append(" from HP_CP ");
		
		return this.getResultBySql(strSql.toString());
	}
}
