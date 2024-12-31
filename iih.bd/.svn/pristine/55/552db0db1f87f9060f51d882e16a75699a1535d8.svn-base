package iih.bd.fc.s.bp.qry;

import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询部门拥有的仓库下的全部物品信息
 * 
 * @author xuxing_2018年6月27日15:55:52
 * @version xuxing_2018年8月9日15:23:24；增加启用和停开校验
 *
 */
public class GetWfDepMmInfoSql implements ITransQry {

	private String[] id_deps;

	public GetWfDepMmInfoSql(String[] id_deps) {
		this.id_deps = id_deps;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		if (this.id_deps != null && this.id_deps.length > 0) {
			for (String id_dep : id_deps) {
				param.addParam(id_dep);
			}
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                         ");
		sqlStr.append(" wh.id_dep_belong as id_dep,                    ");
		sqlStr.append(" mmwh.id_mm                                     ");
		sqlStr.append(" from bd_mm_wh mmwh                             ");
		sqlStr.append(" left join bd_wh wh on wh.id_wh = mmwh.id_wh    ");
		sqlStr.append(" where " + new BdFcEnvContextUtil().getWherePart(new WarehouseInfoDO(), "mmwh"));
		sqlStr.append(" and mmwh.fg_active = 'Y' and mmwh.fg_out = 'N' ");// 增加启用和停开校验
		if (this.id_deps != null && this.id_deps.length > 0) {
			String whereStr = "";
			for (int i = 0; i < this.id_deps.length; i++) {
				whereStr += (whereStr.length() == 0 ? "" : ",") + "?";
			}
			sqlStr.append(" and wh.id_dep_belong in (" + whereStr + ")  ");
		} else {
			sqlStr.append(" and 1 = 2  ");
		}
		return sqlStr.toString();
	}
}
