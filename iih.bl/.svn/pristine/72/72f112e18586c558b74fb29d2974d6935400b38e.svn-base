package iih.bl.cg.bp.self.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取就诊的医保计划
 * @author LIM
 *
 */
public class GetEntHpQry implements ITransQry {
	String id_ent;
	public GetEntHpQry(String id_ent){
		this.id_ent=id_ent;	
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();	
		if (this.id_ent != null && this.id_ent != "") {
			param.addParam(this.id_ent);
		}			
		return param;
	}
	@Override
	public String getQrySQLStr() {
		StringBuilder sb= new StringBuilder();
		sb.append("select hp.id_hp,hp.code ");
		sb.append(" from en_ent ent inner join bd_hp hp on ent.id_hp= hp.id_hp");
	    sb.append(" where ent.id_ent=?");
		return sb.toString();
	}
}
