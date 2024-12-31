package iih.bl.hp.bp.Qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CheckIsHpBlackPatByPatIdQry implements ITransQry{

	String hpId;
	String patId;
	public CheckIsHpBlackPatByPatIdQry(String hpId,String patId){
		this.hpId=hpId;
		this.patId=patId;	
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();	
		param.addParam(this.hpId);	
		param.addParam(this.patId);
		return param;
	}
	@Override
	public String getQrySQLStr() {
		StringBuilder sb= new StringBuilder();
		
	sb.append("	SELECT	* FROM 	BL_HP_PAT_BLACKLIST ");
	sb.append(" WHERE ");
	sb.append("	ID_HP = ?   ");
	sb.append(" AND INSUR_NO = (SELECT NO_HP FROM PI_PAT_HP WHERE ID_PAT=?)  ");
	sb.append(" AND (dt_begin <= TO_CHAR ( SYSDATE, 'yyyy-mm-dd hh24:mi:ss' ) ");
	sb.append("     OR dt_begin IS NULL) ");
	sb.append(" AND (                             ");
	sb.append("	dt_end >= TO_CHAR (              ");
	sb.append("		SYSDATE,                     ");
	sb.append("		'yyyy-mm-dd hh24:mi:ss'      ");
	sb.append("	)                                ");
	sb.append("	OR dt_end IS NULL                ");
	sb.append(")                                 ");
		return sb.toString();                    
	}
}
