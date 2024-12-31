package iih.ci.ord.s.bp.qry;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOrdAlwaysQry implements ITransQry {
	private String qryStr;
	public GetOrdAlwaysQry(String qryStr){
		this.qryStr = qryStr;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append(" select"); 
		sb.append(" ci.id_or,");
		sb.append(" pat.code as code_pat,");
		sb.append(" pat.name as name_pat,");
		sb.append(" pat.dt_birth,");
		sb.append(" ci.sd_su_or,");
		sb.append(" ci.content_or,");
		sb.append(" ci.dt_effe,");
		sb.append(" ci.dt_end,");
		sb.append(" ci.fg_stop,");
		sb.append(" ci.sd_su_mp,");
		sb.append(" ip.name_bed");
		sb.append(" from ci_order ci left join pi_pat pat");
		sb.append(" on ci.id_pat=pat.id_pat");
		sb.append(" left join en_ent_ip ip");
		sb.append(" on ci.id_en = ip.id_ent");
		sb.append(" left join en_ent en");
		sb.append(" on ci.id_en = en.id_ent");
		sb.append(" where en.id_dep_nur='"+Context.get().getDeptId()+"'");
		sb.append(" and ci.fg_canc ='N'");
		sb.append(" and ci.fg_sign ='Y'");
		sb.append(" and ( ci.id_freq = '"+IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ALWAYS+"'");
        sb.append(" or(  ci.fg_long = 'Y'");	 
		sb.append(" and ci.fg_chk_stop = 'Y')) ");		 
		if(!StringUtils.isEmpty(this.qryStr)){
			sb.append(" and "+this.qryStr);
		}else{
			sb.append(" and 1=2");
		}
		sb.append(" order by ip.name_bed,ci.dt_stop");
		return sb.toString();
	}

}
