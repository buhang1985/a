package iih.ei.std.s.v1.bp.mp.updatestatusbylab.qry;

import java.util.List;

import iih.ei.std.s.v1.bp.mp.common.MpnrUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
* @ClassName: QueryApplynoSql
* @Description: 查询申请单号
* @author zhy
* @date 2019年9月29日
*
 */
public class QueryApplynoSql implements ITransQry{
	private List<String> nobarList;
	public QueryApplynoSql(List<String> nobarList){
		this.nobarList = nobarList;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		MpnrUtils.setSqlParam(param, nobarList.toArray(new String[0]));
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select ci.applyno from mp_or_pr  orpr ");
		sql.append(" inner join ci_order ci on ci.id_or = orpr.id_or");
		sql.append(" left join mp_ne_lab_samp_itm_ref itmref on itmref.id_or_pr = orpr.id_or_pr ");
		sql.append(" left join mp_ne_lab_samp labsamp on labsamp.id_labsamp = itmref.id_labsamp");
		sql.append(" where 1=1 ");
		if(nobarList !=null && nobarList.size()>0){
			sql.append(" and labsamp.no_bar in ("+MpnrUtils.getSqlParamChars(nobarList.toArray(new String[0]))+")");
		}
		return sql.toString();
	}
}
