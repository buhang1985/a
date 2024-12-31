package iih.pe.listener.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetInpatientDOSql implements ITransQry {
	
	private String medicalno;
	private int visittimes;
	public GetInpatientDOSql(String medicalno, int visittimes){
		this.medicalno = medicalno;
		this.visittimes = visittimes;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(medicalno);
		param.addParam(visittimes);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(" select i.id_ent from en_ent_ip i ");
		sb.append(" where i.fg_pe = 'Y' ");
		sb.append(" and i.code_amr_ip = ? and and i.times_ip = ? ");
		
		return sb.toString();
	}

}
