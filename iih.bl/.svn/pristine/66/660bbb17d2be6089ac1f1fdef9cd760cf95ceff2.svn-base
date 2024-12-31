package iih.bl.cg.s.bp.ip.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * 根据就诊主键查询住院记账数据查询类
 * @author ly 2019/01/15
 *
 */
public class GetIpCgDataByEntIdQry implements ITransQry {

	private String entId;
	
	public GetIpCgDataByEntIdQry(String entId){
		this.entId = entId;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {
		
		SqlParam param = new SqlParam();
		param.addParam(this.entId);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ");
		sqlSb.append("cgip.id_srv,");
		sqlSb.append("cgip.code_srv,");
		sqlSb.append("cgip.name_srv,");
		sqlSb.append("cgip.price_ratio,");
		sqlSb.append("sum(cgip.quan * cgip.eu_direct) quan,");
		sqlSb.append("sum(cgip.amt_ratio * cgip.eu_direct) amt_ratio,");
		sqlSb.append("cgip.srvu id_measdoc,");
		sqlSb.append("measdoc.name name_measdoc,");
		sqlSb.append("cgip.spec ");

		sqlSb.append("from bl_cg_ip cgip ");
		sqlSb.append("left join bd_measdoc measdoc ");
		sqlSb.append("on cgip.srvu = measdoc.id_measdoc ");
		sqlSb.append("where cgip.id_ent = ? ");

		sqlSb.append("group by cgip.id_srv,cgip.code_srv,cgip.name_srv,cgip.price_ratio,cgip.srvu,measdoc.name,cgip.spec ");
		sqlSb.append("order by code_srv ");
		
		return sqlSb.toString();
	}

}
