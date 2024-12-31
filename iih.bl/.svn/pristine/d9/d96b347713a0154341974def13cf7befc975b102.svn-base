package iih.bl.cg.s.provide.mbh.qry;

import iih.bl.cg.dto.mb.ipfeebill.d.BlCgIpFeeBillCondDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院患者费用清单查询
 * @author ly 2018/08/06
 *
 */
public class GetIpFeeBillForMbhQry implements ITransQry {

	private BlCgIpFeeBillCondDTO cond;
	
	public GetIpFeeBillForMbhQry(BlCgIpFeeBillCondDTO cond){
		this.cond = cond;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {
		SqlParam param = new SqlParam();
		param.addParam(cond.getId_ent());
		
		if(cond.getDt_begin() != null){
			sqlSb.append("and dt_cg >= ? ");
			param.addParam(cond.getDt_begin().toString());
		}
		
		if(cond.getDt_end() != null){
			sqlSb.append("and dt_cg <= ? ");
			param.addParam(cond.getDt_end().toString());
		}
		
		sqlSb.append("group by code_inccaitm,name_inccaitm,name_mm,name_srv,price_ratio,spec ");
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ");
		sqlSb.append("code_inccaitm code_type,");
		sqlSb.append("name_inccaitm name_type,");
		sqlSb.append("nvl(name_mm,name_srv) name,");
		sqlSb.append("bl_cg_ip.price_ratio price,");
		sqlSb.append("sum(eu_direct * amt_ratio) amt,");
		sqlSb.append("sum(eu_direct * quan) quan,");
		sqlSb.append("spec ");
		sqlSb.append("from bl_cg_ip ");
		sqlSb.append("where id_ent = ? ");
		
		return sqlSb.toString();
	}
}
