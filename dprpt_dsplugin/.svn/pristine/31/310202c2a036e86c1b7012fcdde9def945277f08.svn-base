package iih.ci.ord.printmanage.srv.ord;

import iih.ci.ord.printmanage.dto.ANcdxPrintDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;

import java.util.Date;
import java.util.List;

import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

import com.mysql.jdbc.StringUtils;

public class ANcdxPrintService {
	
	public List<ANcdxPrintDTO> exec(String ids) throws Exception {
		if (StringUtils.isNullOrEmpty(ids)){
			return null;
		}
		List<ANcdxPrintDTO> mylist = this.getMyList(this.getAmyInfoSqlQry(ids));
		if (mylist == null || mylist.size() == 0){
			return null;
		}
		for (int i = 0; i < mylist.size(); i++) {
			if (mylist.get(i).getDt_birth() != null) {
				Date birth = new Date();
				birth = CiorderPrintUtils.ConvertStrToDate(mylist.get(i).getDt_birth());
				FDate dt = new FDate(birth);
				mylist.get(i).setAge(AgeCalcUtil.getAge(dt));
				mylist.get(i).setDt_plan(mylist.get(i).getDt_plan().substring(0,10));
			}
			/*if(mylist.get(i).getId_en()!=null){
				mylist.get(i).setDi(GetStr_name_di(mylist.get(i).getId_en()));
			}*/
		}
		return mylist;
		
		
	}
	
	private List<ANcdxPrintDTO> getMyList(String sqlQry) throws Exception {
		List<ANcdxPrintDTO> result = CiorderPrintUtils.GetQueryResulte(ANcdxPrintDTO.class, sqlQry);
		return result;
	}
	
	public String getAmyInfoSqlQry(String ids) {
		StringBuilder str = new StringBuilder();
		str.append("SELECT PPC.NAME NAME, bd_dep.name      AS Name_dep_or,PAT.Barcode_chis AS Barcode,");
		str.append(" PAT.NAME Name_pati,PAT.DT_BIRTH Dt_birth,");
		str.append("nvl(NOTICE_PLACENOTICE.name,NOTICE_PLACENOTICESUP.name) as PlaceNOTICE, ");//注意事项：地点
		str.append("PAT.Dt_birth,");
		str.append("'' AS Age,");
		str.append("ba.fullname as county,");
		str.append(" PAT.MOB Mob,cal.Str_name_di AS Str_name_di,UDIDOC.Name     AS Samptp,");
		str.append("CAL.ANNOUNCEMENTS Announcements,EMP_APP.Name AS Name_emp_or,CAL.dt_plan as dt_plan,");
		str.append("CAL.Amt_app_total as Amt_total ");
		str.append(" FROM CI_APP_LIS CAL LEFT JOIN PI_PAT PAT ON CAL.ID_PAT=PAT.ID_PAT ");
		str.append("LEFT JOIN EN_ENT EN ON PAT.ID_PAT=EN.ID_PAT ");
		str.append("LEFT JOIN PI_PAT_CA PPC ON EN.ID_PATCA=PPC.ID_PATCA ");
		str.append("LEFT JOIN CI_ORDER CO ON PAT.ID_PAT=CO.ID_PAT ");
		str.append("LEFT JOIN BD_NOTICE NOTICE_PLACENOTICE ON NOTICE_PLACENOTICE.sd_noticetp = '21' and NOTICE_PLACENOTICE.id_srvca = CO.id_srvca  ");
		str.append("LEFT JOIN BD_NOTICE NOTICE_PLACENOTICESUP ON NOTICE_PLACENOTICESUP.sd_noticetp = '21' and NOTICE_PLACENOTICESUP.id_srvca = '0001Z810000000001FSY'  ");
		str.append("LEFT JOIN bd_dep ON cal.Id_Dep_App = bd_dep.Id_Dep ");
		str.append("LEFT JOIN bd_psndoc EMP_APP ON CAL.Id_Emp_App = EMP_APP.Id_Psndoc ");
		str.append("LEFT JOIN ci_app_lis_or APP_LIS_OR ON CAL.id_ciapplissheet=APP_LIS_OR.id_ciapplissheet ");
		str.append("LEFT JOIN ci_ap_lab AP_LAB ON APP_LIS_OR.Id_Or = AP_LAB.Id_Or ");
		str.append("LEFT JOIN bd_udidoc UDIDOC ON AP_LAB.Id_Samptp = UDIDOC.Id_Udidoc ");
		str.append("LEFT JOIN pi_pat_addr ppa on ppa.id_pat = PAT.id_pat and ppa.sd_addrtp='9' ");
		str.append("LEFT JOIN bd_adminarea ba on ba.id_adminarea=ppa.id_admdiv ");
		str.append("WHERE co.id_or in (" + ids + ")");
		
		return str.toString();
	}
}
