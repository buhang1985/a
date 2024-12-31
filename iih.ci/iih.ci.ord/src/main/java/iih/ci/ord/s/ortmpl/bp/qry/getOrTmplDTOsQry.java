package iih.ci.ord.s.ortmpl.bp.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医嘱模板分类关系
 * @author Young
 *
 */
public class getOrTmplDTOsQry implements ITransQry {

	private String code_entp;
	private String id_ortmplca;
	private String sd_ortmpltp;
	
	public getOrTmplDTOsQry(String code_entp, String id_ortmplca,String sd_ortmpltp){
		this.code_entp = code_entp;
		this.id_ortmplca=id_ortmplca;
		this.sd_ortmpltp=sd_ortmpltp;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select REL.Id_ortmplcarel,REL.Id_ortmplca,REL.Fg_sync as Fg_sync_carel,TMPL.Id_ortmpl,TMPL.Sd_ortmpltp,TMPL.Name ");
		sb.append("from bd_srv_ortmpl_ca_rel REL ");
		sb.append("left join bd_srv_ortmpl TMPL on REL.Id_ortmpl=TMPL.Id_ortmpl ");
		sb.append("where REL.Id_ortmplca in (" + this.id_ortmplca + ") ");
		sb.append("and TMPL.sd_ortmpltp in (" + this.sd_ortmpltp + ") ");
		sb.append("and TMPL.fg_active='Y' and TMPL.fg_sync='N'");
		sb.append(this.getstrFgentp());
		sb.append(" order by TMPL.Seqno");
		
		return sb.toString();
	}

	/**
	 * 就诊类型条件字符串
	 * @return
	 */
	private String getstrFgentp() {
		String str = "";
		switch (this.code_entp) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
			str += " and TMPL.fg_entp_op='Y'";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:
			str += " and TMPL.fg_entp_er='Y'";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:
			str += " and TMPL.fg_entp_er1='Y'";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:
			str += " and TMPL.fg_entp_er2='Y'";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
			str += " and TMPL.fg_entp_ip='Y'";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
			str += " and TMPL.fg_entp_pe='Y'";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
			str += " and TMPL.fg_entp_fm='Y'";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE:
			str += " and TMPL.fg_use_pip='Y'";
			break;
		}
		return str;
	}
}
