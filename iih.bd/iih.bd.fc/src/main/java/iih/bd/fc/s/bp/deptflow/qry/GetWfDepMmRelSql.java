package iih.bd.fc.s.bp.deptflow.qry;

import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.s.bp.common.WfUtils;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @Description:查询部门与仓库关系
 * @author: xu_xing@founder.com.cn
 * @version：2019年1月10日 下午3:31:28 创建
 */
public class GetWfDepMmRelSql implements ITransQry {

	private String[] id_deps;
	private String[] id_mms;

	public GetWfDepMmRelSql(String[] id_deps, String[] id_mms) {
		this.id_deps = id_deps;
		this.id_mms = id_mms;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		WfUtils.setSqlParam(param, this.id_deps);
		WfUtils.setSqlParam(param, this.id_mms);
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

		// 科室校验
		String whereInStr = WfUtils.getSqlParamChars(this.id_deps);
		if (!StringUtil.isEmptyWithTrim(whereInStr))
			sqlStr.append(" and wh.id_dep_belong in (" + whereInStr + ")");
		else
			sqlStr.append(" and 1 = 2                                   ");

		// 物品校验，减少返回数据
		String whereMmInStr = WfUtils.getSqlParamChars(this.id_mms);
		if (!StringUtil.isEmptyWithTrim(whereMmInStr))
			sqlStr.append(" and mmwh.id_mm in (" + whereMmInStr + ")");
		else
			sqlStr.append(" and 1 = 2                                   ");

		return sqlStr.toString();
	}
}
