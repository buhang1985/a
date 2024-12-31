package iih.ci.mr.s.bp.qry;

import iih.bd.bc.udi.pub.IMpDictCodeTypeConst;

import java.text.MessageFormat;

import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetHisDataSql implements ITransQry {
	
	private String id_ents;
	private String id_mrtplvt;
	private FDateTime threedays;
	private FDateTime dt_vt;

	
	public GetHisDataSql(String id_ents,String id_mrtplvt,FDateTime threedays,FDateTime dt_vt){
		this.id_ents = id_ents;
		this.id_mrtplvt = id_mrtplvt;
		this.threedays = threedays;
		this.dt_vt = dt_vt;

	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_mrtplvt);
		param.addParam(IMpDictCodeTypeConst.SD_TEMPERATURE_SRVVT);
		param.addParam(threedays);
		param.addParam(dt_vt);
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}

	
	public String getSql(){
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select");
		sql.append(" cimr.id_ent, ");
		sql.append(" cimrvt.dt_vt,");
		sql.append(" mrvtitm.value ");
		sql.append(" from CI_MR_VT_ITM mrvtitm ");
		sql.append(" inner join CI_MR_VT cimrvt on mrvtitm.id_mrvt=cimrvt.id_mrvt ");
		sql.append(" inner join BD_MRTPL_VT_ITM mrtplitm on mrvtitm.id_mrtplvtitm=mrtplitm.id_mrtplvtitm and mrtplitm.id_mrtplvt=?");
		sql.append(" left join bd_srv_vt srvvt on mrtplitm.id_srv=srvvt.id_srv ");
		sql.append(" left join bd_srv srv on srv.id_srv=srvvt.id_srv ");
		sql.append(" inner join CI_MR cimr on cimrvt.id_mr=cimr.id_mr ");
		sql.append(" where mrvtitm.ds=0 and cimr.id_ent in ({0}) ");
		sql.append(" and srv.code=? ");
		sql.append(" and cimrvt.dt_vt>? and cimrvt.dt_vt<?");
		String Sql = MessageFormat.format(sql.toString(), id_ents);
		return Sql;
	}
}
