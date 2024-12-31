package iih.ci.mr.s.bp.qry;

import java.text.MessageFormat;

import iih.bd.bc.udi.pub.IMpDictCodeTypeConst;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetNewTemperaturesql implements ITransQry {

	private String id_ents;
	private FDateTime dt_vt;
	
	public GetNewTemperaturesql(String id_ents,FDateTime dt_vt){
		this.id_ents = id_ents;
		this.dt_vt = dt_vt;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam rtnParam = new SqlParam();
		rtnParam.addParam(dt_vt);
		rtnParam.addParam(IMpDictCodeTypeConst.SD_TEMPERATURE_SRVVT);
		rtnParam.addParam(dt_vt);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		return getSqlStr();
	}

	public String getSqlStr()
	{
		StringBuffer SqlStr=new StringBuffer();
		
		SqlStr.append(" select * from  ");
		SqlStr.append(" ( ");
		SqlStr.append("   select  ");
		SqlStr.append("   mr.id_ent, ");
		SqlStr.append("   srvvt.id_srvvt, ");
		SqlStr.append("   srv.code, ");
		SqlStr.append("   mrvtitm.name, ");
		SqlStr.append("   mrvt.dt_vt, ");
		SqlStr.append("   mrvtitm.value ");
		SqlStr.append("   from ci_mr_vt_itm mrvtitm ");
		SqlStr.append("   left join ci_mr_vt mrvt on mrvtitm.id_mrvt=mrvt.id_mrvt ");
		SqlStr.append("   left join ci_mr mr on mrvt.id_mr=mr.id_mr ");
		SqlStr.append("   left join bd_srv_vt srvvt on mrvtitm.id_srv=srvvt.id_srv ");
		SqlStr.append("   left join bd_srv srv on mrvtitm.id_srv=srv.id_srv ");
		SqlStr.append("   left join bd_measdoc unit on srvvt.id_unit=unit.id_measdoc ");
		SqlStr.append("   where mr.id_ent in ({0}) and dt_vt<? and srv.code=?");
		SqlStr.append("   and mrvtitm.ds=0 ");
		SqlStr.append(" ) vtresult ");
		SqlStr.append(" where exists ");
		SqlStr.append(" ( ");
		SqlStr.append("     select 1 from  ");
		SqlStr.append("     ( ");
		SqlStr.append("       select  ");
		SqlStr.append("        cimr.id_ent,  ");
		SqlStr.append("        max(cimrvt.dt_vt) as dt_vt ");
		SqlStr.append("       from ci_mr_vt_itm cimrvtitm ");
		SqlStr.append("       left join ci_mr_vt cimrvt on cimrvtitm.id_mrvt=cimrvt.id_mrvt ");
		SqlStr.append("       left join ci_mr cimr on cimrvt.id_mr=cimr.id_mr ");
		SqlStr.append("       left join bd_srv_vt bdsrvvt on cimrvtitm.id_srv=bdsrvvt.id_srv ");
		SqlStr.append("       where cimr.id_ent in ({1}) and dt_vt<?");
		SqlStr.append("       and cimrvtitm.ds=0 ");
		SqlStr.append("       group by  cimr.id_ent");
		SqlStr.append("     ) groupres ");
		SqlStr.append("     where groupres.id_ent=vtresult.id_ent ");
		SqlStr.append("     and groupres.dt_vt=vtresult.dt_vt ");
		SqlStr.append(" )  ");
		
		String Sql = MessageFormat.format(SqlStr.toString(), id_ents,id_ents);
		return Sql;
	}
}
