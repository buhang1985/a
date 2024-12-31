package iih.ci.ord.printmanage.srv;

import iih.ci.ord.printmanage.dto.OrdConsRptDO;
import iih.ci.ord.printmanage.dto.UtilsDTO;

import java.util.Date;
import java.util.List;

import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

import com.mysql.jdbc.StringUtils;

/**
 * 会诊记录服务
 * @author Young
 *
 */
public class OrdConsRptService {

	public List<OrdConsRptDO> exec(String ids) throws Exception {
		if (StringUtils.isNullOrEmpty(ids))return null;
		List<OrdConsRptDO> ordlist = this.getOrderList(this.getOrdInfoSqlQry(ids));
		if (ordlist == null || ordlist.size() == 0)return null;
		for (int i = 0; i < ordlist.size(); i++) {
			if (ordlist.get(i).getDt_birth() != null) {
				Date birth = new Date();
				birth = CiorderPrintUtils.ConvertStrToDate(ordlist.get(i).getDt_birth());
				FDate dt = new FDate(birth);
				ordlist.get(i).setAge(AgeCalcUtil.getAge(dt));
			}
			if(ordlist.get(i).getId_en()!=null){
				ordlist.get(i).setDi(GetStr_name_di(ordlist.get(i).getId_en()));
			}
		}
		return ordlist;
	}
	
	private List<OrdConsRptDO> getOrderList(String sqlQry) throws Exception {
		List<OrdConsRptDO> result = CiorderPrintUtils.GetQueryResulte(OrdConsRptDO.class, sqlQry);
		return result;
	}
	
	/**
	 * 获取当前就诊诊断
	 * 
	 * @param id_en
	 * @return
	 * @throws Exception 
	 */
	public String GetStr_name_di(String id_en) throws Exception {
		if (StringUtils.isNullOrEmpty(id_en))
			return null;
		String sql = "select DI.Str_name_di Def1 from "
				+ "(select id_ent,max(to_char(Str_name_di)) as Str_name_di from (select K.id_ent, wmsys.wm_concat(K.name_didef_dis) over (partition by K.id_ent order by K.Sortno) as Str_name_di "
				+ "from en_ent_di K) group by id_ent) DI where DI.id_ent = '" + id_en + "'";

		List<UtilsDTO> result = CiorderPrintUtils.GetQueryResulte(UtilsDTO.class, sql);

		String str_name_di = "";
		if (result != null && result.size() > 0) {
			str_name_di = result.get(0).getDef1();
		}

		return str_name_di;
	}
	
	public String getOrdInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("select ORG.NAME NAME_ORG,");//	0122284: 住院医生站窗口会诊记录中打印出来会诊记录单格式错误 gh 现有报表为固定标题，将标题改为从数据库中获取
		str.append("APCONS.Id_or,");
		str.append("ORD.Id_en,");
		str.append("PAT.Name as Name_pati,");
		str.append("PAT.Dt_birth,");
		str.append("PAT_SEX.Name as Gender,");
		str.append("'' as Age,");
		str.append("DEPIP.Name as Dep_pati,");
		str.append("ENTIP.Name_bed as Code_bed,");
		str.append("ENTIP.Code_amr_ip as Code_en,");
		str.append("to_char(wm_concat(DEPINVIT.Name)) as Dep_invited,");
		str.append("ORD.Dt_effe as Dt_sign,");
		str.append("RPTCONS.Des_emr,");
		str.append("RPTCONS.Des_psp,");
		str.append("DEPOR.Name as Name_dep_or,");
		str.append("EMPOR.Name as Name_emp_or,");
		str.append("RPTCONS.Dt_actual as Dt_cons,");
		str.append("RPTCONS.Advice,");
		str.append("EMPRPT.Name as Name_emp_rpt,");
		str.append("RPTCONS.Dt_rpt,");
//		0122284: 住院医生站窗口会诊记录中打印出来会诊记录单格式错误   会诊类型使用的是加急字段  如果为Y 展示加急  如果为N  则不显示
//		125960: 住院医生站窗口会诊记录中打印出来会诊记录单格式错误   会诊类型使用的是加急字段  如果为Y 展示加急  如果为N  则显示常规
		str.append("CASE APCONS.Fg_urgent WHEN 'Y' THEN '加急' ELSE '常规' END Fg_urgent ");
		
		
		str.append("from ci_ap_cons APCONS ");
		str.append("left join ci_order ORD on APCONS.Id_or = ORD.Id_or ");
		str.append("left join bd_org ORG on ORD.ID_ORG=ORG.ID_ORG ");
		str.append("left join pi_pat PAT on ORD.Id_pat = PAT.Id_pat ");
		str.append("left join bd_udidoc PAT_SEX on PAT.Id_sex = PAT_SEX.Id_udidoc ");
		str.append("left join en_ent_ip ENTIP on ORD.Id_en = ENTIP.Id_ent ");
		str.append("left join bd_dep DEPIP on DEPIP.Id_dep = ORD.id_dep_or ");
		str.append("left join ci_invite_cons INVITCONS on INVITCONS.Id_apcons = APCONS.Id_apcons ");
		str.append("left join bd_dep DEPINVIT on DEPINVIT.Id_dep = INVITCONS.Id_dep ");
		str.append("left join bd_dep DEPOR on DEPOR.Id_dep = ORD.Id_dep_or ");
		str.append("left join bd_psndoc EMPOR on EMPOR.Id_psndoc = ORD.Id_emp_or ");
		str.append("left join ci_rpt_cons RPTCONS on RPTCONS.Id_apcons = APCONS.Id_apcons ");
		str.append("left join bd_psndoc EMPRPT on EMPRPT.Id_psndoc = INVITCONS.Id_emp ");
		
		str.append(" where APCONS.Id_apcons in (" + ids + ") ");
		str.append(" group by ORG.NAME ,EMPRPT.Name ,APCONS.Id_or,ORD.Id_en,PAT.Name ,PAT.Dt_birth,PAT_SEX.Name , '',DEPIP.Name ,ENTIP.Name_bed ,ENTIP.Code_amr_ip ,ORD.Dt_effe ,RPTCONS.Des_emr,RPTCONS.Des_psp,DEPOR.Name ,EMPOR.Name ,RPTCONS.Dt_actual ,RPTCONS.Advice,RPTCONS.Dt_rpt,APCONS.Fg_urgent");

		return str.toString();
	}
}
