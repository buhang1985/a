package iih.mi.bd.s.bp.sql;

import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author shao_yuan
 *
 */
public class FindRegionsByCodesSql  implements ITransQry{

	private String hpId;
	private String[] regionCodes;
	
	public FindRegionsByCodesSql(String hpId, String[] regionCodes) {
		this.hpId = hpId;
		this.regionCodes=regionCodes;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer where) {
		SqlParam param = new SqlParam();
		if (hpId != null) {
			param.addParam(hpId);
			where.append(" and reg.id_hp = ? ");
		}
		if(!ArrayUtil.isEmpty(regionCodes)) {
			where.append(" and reg.code in (");
			for(String r:regionCodes) {
				where.append("'").append(r).append("'").append(",");
			}
			where.deleteCharAt(where.length()-1);
			where.append(" ) ");
		}
		where.append(this.getOrderPart());
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append(" select ");
		sb.append(" reg.id_region, ");
		sb.append(" reg.id_grp, ");
		sb.append(" reg.id_org, ");
		sb.append(" reg.id_hp, ");
		sb.append(" reg.name, ");
		sb.append(" reg.code ");
		sb.append(" from bd_mhi_region reg ");
		sb.append(" where 1=1 ");
		
		return sb.toString();
	}

	/**
	 * 排序部分
	 * @return
	 */
	private Object getOrderPart() {
		return " order by reg.code ";
	}
}
