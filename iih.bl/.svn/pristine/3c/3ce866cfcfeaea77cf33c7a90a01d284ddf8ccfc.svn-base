package iih.bl.cg.s.bp.ip.qry;

import iih.bl.cg.dto.addfee.d.BlCgAddFeeQryCondDTO;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院补费用查询
 * @author ly 2018/05/11
 *
 */
public class BlIpAddFeeQry implements ITransQry {

	private BlCgAddFeeQryCondDTO cond;
	
	public BlIpAddFeeQry(BlCgAddFeeQryCondDTO cond){
		this.cond = cond;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {
		
		SqlParam param = new SqlParam();
		sqlSb.append("and cgip.id_ent = ? ");
		param.addParam(this.cond.getId_ent());
		
		if(!StringUtil.isEmpty(this.cond.getSrcfunc_des())){
			sqlSb.append("and cgip.srcfunc_des = ? ");
			param.addParam(this.cond.getSrcfunc_des());
		}
		
		if(!StringUtil.isEmpty(this.cond.getId_dep_cg())){
			sqlSb.append("and cgip.id_dep_cg = ? ");
			param.addParam(this.cond.getId_dep_cg());
		}
		
		if(FBoolean.TRUE.equals(this.cond.getFg_relateor())){
			sqlSb.append("and cgip.id_or = ? ");
			param.addParam(this.cond.getId_or());
		}else{
			sqlSb.append("and nvl(cgip.id_or,'~') = '~' ");
		}
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ");
		sqlSb.append("cgip.id_cgip id_cg,");
		sqlSb.append("cgip.id_emp_cg,");
		sqlSb.append("psn.name name_emp_cg,");
		sqlSb.append("cgip.dt_cg,");
		sqlSb.append("cgip.id_or,");
		sqlSb.append("cgip.id_srv,");
		sqlSb.append("cgip.code_srv,");
		sqlSb.append("cgip.name_srv,");
		sqlSb.append("cgip.quan,");
		sqlSb.append("cgip.quan_ret,");
		sqlSb.append("cgip.eu_direct,");
		sqlSb.append("cgip.price price_std,");
		sqlSb.append("cgip.price_ratio,");
		sqlSb.append("cgip.amt_std,");
		sqlSb.append("cgip.amt_ratio ");
		sqlSb.append("from bl_cg_ip cgip ");
		sqlSb.append("left join bd_psndoc psn ");
		sqlSb.append("on cgip.id_emp_cg = psn.id_psndoc ");
		sqlSb.append("where cgip.fg_refund = 'N' ");
		sqlSb.append("and cgip.fg_additm = 'Y' ");
		
		if(FBoolean.FALSE.equals(this.cond.getFg_containrefund())){
			sqlSb.append("and cgip.eu_direct = 1 ");
		}
		sqlSb.append("and nvl(cgip.fg_research,'N')='N'");
		
		return sqlSb.toString();
	}
}
