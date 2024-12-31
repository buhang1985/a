package iih.pi.dic.patientcategory.refs;

import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.d.desc.PiPatCaDODesc;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 诊间结算用患者分类参照（勿动）
 * @author liming06
 *
 */
@SuppressWarnings("serial")
public class PiPatCaRefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode(){
		return new String[]{PiPatCaDO.CODE,PiPatCaDO.NAME};
	}
	@Override
	public String[] getHiddenFieldCode(){
		return new String[]{PiPatCaDO.ID_PATCA, PiPatCaDO.ID_PATCRETTP, PiPatCaDO.ID_PATPRITP, PiPatCaDO.PATCRETTP_NAME, PiPatCaDO.PATPRITP_NAME,
				"id_hp","hp_code","hp_name","fg_reqhpcode","id_medkind","code_medkind","name_medkind"};
	}
	@Override
	public String[] getShowFieldName(){
		return new String[]{"编码","名称"};
	}
	@Override
	public String getPkFieldCode(){		
		return PiPatCaDO.ID_PATCA;
	}
	@Override
	public String[] getBlurFields() {
		return new String[] { PiPatCaDO.CODE, PiPatCaDO.NAME, PiPatCaDO.PYCODE, PiPatCaDO.WBCODE,PiPatCaDO.MNECODE };
	}
	@Override
	public String getTableName(){
		return PiPatCaDODesc.TABLE_NAME;
	}
	@Override
	public String getRefCodeField(){
		return PiPatCaDO.CODE;
	}
	@Override
	public String getRefNameField(){
		return PiPatCaDO.NAME;
	}
	

	@Override
	public String getRefSql() {

		String refSql =	"select pi_pat_ca.Code," +
				"       pi_pat_ca.Name," + 
				"       pi_pat_ca.Id_patca," + 
				"       pi_pat_ca.Id_patcrettp," + 
				"       pi_pat_ca.Id_patpritp," + 
				"       cret.name Patcrettp_name," + 
				"       pri.name Patpritp_name, " + 
				"       hp.id_hp," + 
				"       hp.code hp_code," +
				"       hp.name hp_name," + 
				"       hp.fg_reqhpcode," + 
				"       med.id_hpmedkindah as id_medkind," + 
				"       med.code as code_medkind," + 
				"       med.name as name_medkind " + 
				"  from pi_pat_ca" + 
				"  left join bd_pri_pat pri" + 
				"  on pi_pat_ca.id_patpritp = pri.id_pripat" + 
				"  left join pi_pat_cret cret" + 
				"  on pi_pat_ca.id_patcrettp = cret.id_patcret " +
				"  left join pi_pat_ca_hp caHp " +
				"  on pi_pat_ca.id_patca = caHp.id_patca " +
				"  left join bd_hp hp " +
				"  on caHp.id_hp = hp.id_hp " +
				"  left join bd_hp_med_kind_ah med " +
				"  on caHp.id_medkind_oepdft = med.id_hpmedkindah " +
				"";
		
		StringBuilder sb = new StringBuilder(refSql);
		sb.append(" Where 1=1 ");
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}
		String orgStr = EnvContextUtil.processEnvContext("", new PiPatCaDO(), "pi_pat_ca");
		sb.append(String.format(" and %s ", orgStr));

		// 患者分类类型
		String fg_op = (String) this.getExtendAttributeValue("fg_op");//门诊标识
		String fg_ip = (String) this.getExtendAttributeValue("fg_ip");//住院标识
		if (!StringUtils.isBlank(fg_op) &&!StringUtils.isBlank(fg_ip)) {
			sb.append(" and (fg_op = 'Y' or fg_ip = 'Y') ");
		}		
		else if (!StringUtils.isBlank(fg_ip)) {
			sb.append(" and fg_ip = 'Y' ");
		}
		else if(!StringUtils.isBlank(fg_op)){			
			sb.append(" and fg_op = 'Y' ");
		}
		sb.append(" order by pi_pat_ca.sortno,pi_pat_ca.code ");
		
		return sb.toString();
	}
}
