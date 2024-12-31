package iih.bd.fc.s.bp.orwfcfg.qry;

import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.s.bp.common.WfUtils;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @Description:查询物品结存信息
 * @author: xu_xing@founder.com.cn
 * @version：2019年10月11日 下午4:30:16 创建
 * @version：xuxing_修正参数顺序错误
 */
public class GetMmStockSql implements ITransQry {
	
	private String[] id_deps;
	private String[] id_mms;

	public GetMmStockSql(String[] id_deps, String[] id_mms) {
		this.id_deps = id_deps;
		this.id_mms = id_mms;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		WfUtils.setSqlParam(param, this.id_mms);
		WfUtils.setSqlParam(param, this.id_deps);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                               ");
		sqlStr.append(" mmbl.id_mm||'|'||wh.id_dep_belong as id_key,         ");
		sqlStr.append(" mmbl.id_mm,                                          ");
		sqlStr.append(" wh.id_dep_belong as id_dep,                          ");
		sqlStr.append(" mmwh.fg_out,                                         ");
		sqlStr.append(" mmbl.quan_usable                                     ");
		sqlStr.append(" from mm_bl mmbl                                      ");
		sqlStr.append(" inner join bd_mm_wh mmwh on mmwh.id_wh = mmbl.id_wh and mmwh.id_mm = mmbl.id_mm  ");
		sqlStr.append(" inner join bd_wh wh on wh.id_wh = mmwh.id_wh         ");
		sqlStr.append(" where " + new BdFcEnvContextUtil().getWherePart(new WarehouseInfoDO(), "mmwh"));
		sqlStr.append(" and mmwh.fg_active = 'Y'                             ");// 增加启用和停开校验
		// 物品校验
		String whereMmInStr = WfUtils.getSqlParamChars(this.id_mms);
		if (!StringUtil.isEmptyWithTrim(whereMmInStr))
			sqlStr.append(" and mmbl.id_mm in (" + whereMmInStr + ")");
		else
			sqlStr.append(" and 1 = 2                                        ");
		// 科室校验
		String whereInStr = WfUtils.getSqlParamChars(this.id_deps);
		if (!StringUtil.isEmptyWithTrim(whereInStr))
			sqlStr.append(" and wh.id_dep_belong in (" + whereInStr + ")     ");
		else
			sqlStr.append(" and 1 = 2                                        ");

		return sqlStr.toString();
	}
}
