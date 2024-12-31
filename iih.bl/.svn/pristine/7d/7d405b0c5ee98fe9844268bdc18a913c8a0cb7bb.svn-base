package iih.bl.st.blauditip.bp.qry;

import iih.bd.base.utils.SqlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 查询医保患者未结算费用（按医保算法，查amt_ratio）
 * @author LIM
 *
 */
public class GetOutHpPatUnStFeeQry implements ITransQry{
	private String whereStr;
	private String[] idHpArr;
	public GetOutHpPatUnStFeeQry(String whereStr,String[] idHpArr) {
		
		
		this.whereStr = whereStr;
		this.idHpArr=idHpArr;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		return param;
	}
	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		sb.append("select cg.id_ent,sum(nvl(cg.amt_ratio,'0')*cg.eu_direct) as amt_ratio ");
		sb.append(" from bl_cg_ip cg ");
		sb.append(" inner join en_ent ent on cg.id_ent =ent.id_ent ");
		sb.append(" inner join en_ent_hp enthp on ent.id_ent=enthp.id_ent ");
		sb.append(" left join bl_audit_ip auditip on auditip.id_ent = ent.id_ent ");
		sb.append(" inner join bd_dep in_nur on in_nur.id_dep = ent.id_dep_nur ");
		sb.append(" inner join bd_dep in_dep on in_dep.id_dep = ent.id_dep_phy ");

		sb.append(" where  cg.id_stip='~'and ent.fg_ip='N' ");
		if(!ArrayUtil.isEmpty(this.idHpArr)){
			sb.append(SqlUtils.getInSqlByIds(" and  enthp.id_hp ", this.idHpArr));
		}else{
			sb.append(" and 1=2 ");
		}
		
		if(StringUtil.isEmpty(whereStr))
		{
			sb.append(" and 1=2 ");
//			try {
//				throw new BizException("获取医保患者的未结费用时候，查询条件不能为空！");
//			} catch (BizException e) {
//				e.printStackTrace();
//			}
		}
		else
		{
			sb.append(" and " + whereStr);
		}
		
		sb.append(" group by cg.id_ent");
		return sb.toString();
	}
}
