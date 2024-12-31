package iih.ci.ord.s.bp.iemsg;

import iih.ci.ord.iemsg.d.IEPharmOrEnDTO;

import java.util.Map;

import com.founder.xap.core.utils.StringUtils;

import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

public class CiIEMsgInfoHelper {
	/**
	 * 创建集成平台药品医嘱确认数据信息
	 * @param confirminfo
	 * @return
	 */
	public static IEPharmOrEnDTO map2IEPharmOrEnDTO(Map<String,Object> confirminfo){
		IEPharmOrEnDTO rtn=new IEPharmOrEnDTO();
		rtn.setId_iepharmoren((String)confirminfo.get("id_iepharmoren"));
		rtn.setPatientid((String)confirminfo.get("patientid"));
		rtn.setPatientseqnum((String)confirminfo.get("patientseqnum"));
		rtn.setAdmiss_times(confirminfo.get("admiss_times")+"");
		rtn.setDeptcode((String)confirminfo.get("deptcode"));
		rtn.setDeptname((String)confirminfo.get("deptname"));
		rtn.setWardcode((String)confirminfo.get("wardcode"));
		rtn.setWardname((String)confirminfo.get("wardname"));
		rtn.setBedcode((String)confirminfo.get("bedcode"));
		rtn.setName((String)confirminfo.get("name"));
		rtn.setSexid((String)confirminfo.get("sexid"));
		if(confirminfo.get("birthdaydate")!=null&&confirminfo.get("birthdaydate")!="") {
			rtn.setBirthdaydate(new FDate(confirminfo.get("birthdaydate")+""));
			rtn.setBirthdaydate_hms(new FDateTime(confirminfo.get("birthdaydate")+""));
			String ager=AgeCalcUtil.getAge(new FDate(new FDateTime(confirminfo.get("birthdaydate").toString()).toString()));
			rtn.setAge(ager);
		}
		//详细的出生日期
		if(confirminfo.get("confirm_date")!=null&&confirminfo.get("confirm_date")!="") {
			rtn.setConfirm_date(new FDateTime(confirminfo.get("confirm_date")+""));
		}
		rtn.setConfirm_nurse_code((String)confirminfo.get("confirm_nurse_code"));
		rtn.setConfirm_nurse_name((String)confirminfo.get("confirm_nurse_name"));
		rtn.setOrgcode((String)confirminfo.get("orgcode"));
		rtn.setOrgname((String)confirminfo.get("orgname"));
		rtn.setVisite_seq_no((String)confirminfo.get("visite_seq_no"));//就诊流水号
		rtn.setVisite_type_code((String) confirminfo.get("visite_type_code"));//就诊类别编码
		rtn.setVisite_type_name((String) confirminfo.get("visite_type_name"));//就诊类别名称
		rtn.setDomain_id("01");
		return rtn;
	}

}
