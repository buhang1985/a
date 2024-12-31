package iih.ci.mr.s.bp.qry;

import java.text.MessageFormat;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author 作者 E-mail:huang_junhao
 * @version 创建时间：2016年10月19日 上午11:20:50
 * 类说明
 */
public class CustomItemSql implements ITransQry {

	private String id_ent;
	private String dt_vt;

	public CustomItemSql(String id_ent, String dt_vt) {
		this.id_ent = id_ent;
		this.dt_vt = dt_vt;
	}

	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(dt_vt);
		return param;
	}

	@Override
	public String getQrySQLStr() {

		return getSql();
	}

	private String getSql(){
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select  ");
		sql.append(" cimr.id_mr, ");
		sql.append(" cimrvt.id_mrvt, ");
		sql.append(" mrvtitm.id_mrvtitm, ");
		sql.append(" cimr.id_ent,  ");
		sql.append(" null as id_mrtplvt, ");
		sql.append(" cimrvt.dt_vt,  ");
		sql.append(" mrvtitm.id_mrtplvtitm,  ");
		sql.append(" mrvtitm.id_vt_pos, ");
		sql.append(" mrvtitm.id_vt_aux,  ");
		sql.append(" mrvtitm.value,  ");
		sql.append(" mrvtitm.value1, ");
		sql.append(" mrvtitm.value2, ");
		sql.append(" mrvtitm.value3,  ");
		sql.append(" ''Signs'' as typecode,  ");
		sql.append(" srvvt.id_srvvt  ");
		sql.append(" from CI_MR_VT_ITM mrvtitm  ");
		sql.append(" inner join CI_MR_VT cimrvt on mrvtitm.id_mrvt=cimrvt.id_mrvt and to_date(cimrvt.dt_vt,''yyyy-mm-dd hh24:mi:ss'')=to_date(?,''yyyy-mm-dd hh24:mi:ss'')  ");
		sql.append(" left join bd_srv_vt srvvt on mrvtitm.id_srv=srvvt.id_srv  ");
		sql.append(" inner join CI_MR cimr on cimrvt.id_mr=cimr.id_mr and cimr.id_ent in ({0})  ");
		sql.append(" where mrvtitm.ds=0 and nvl(mrvtitm.id_mrtplvtitm,''~'')=''~'' ");
		
		String qry = MessageFormat.format(sql.toString(), id_ent);
		return qry;
	}
}
