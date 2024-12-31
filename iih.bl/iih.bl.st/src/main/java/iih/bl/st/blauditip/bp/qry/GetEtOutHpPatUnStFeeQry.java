package iih.bl.st.blauditip.bp.qry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetEtOutHpPatUnStFeeQry  implements ITransQry{
	private String whereStr;
	private String[] idHpArr;
	public GetEtOutHpPatUnStFeeQry(String whereStr,String[] idHpArr) {
		
		
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
		sb.append("select cg.id_ent,sum(nvl(cg.amt_ratio,'0')*oep.eu_direct) as amt_ratio ");
		sb.append(" from bl_cg_itm_oep cg ");
		sb.append(" inner join bl_cg_oep oep on cg.id_cgoep =oep.id_cgoep ");
		sb.append(" inner join en_ent ent on cg.id_ent =ent.id_ent ");
		sb.append(" left join bl_audit_ip auditip on auditip.id_ent = ent.id_ent ");
		sb.append(" inner join bd_dep in_nur on in_nur.id_dep = ent.id_dep_nur ");
		sb.append(" inner join bd_dep in_dep on in_dep.id_dep = ent.id_dep_phy ");
		sb.append(" where  cg.id_stoep='~'and ent.fg_ip='N' ");
		
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
