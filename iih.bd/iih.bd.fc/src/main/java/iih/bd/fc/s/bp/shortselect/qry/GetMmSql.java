package iih.bd.fc.s.bp.shortselect.qry;

import iih.bd.fc.dto.shortselect.d.CardCondDTO;
import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.s.bp.common.WfUtils;
import iih.bd.mm.meterial.d.MeterialDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:查询物品信息
 * @author: xu_xing@founder.com.cn
 * @version：2019年3月14日 下午4:21:09 创建
 */
public class GetMmSql implements ITransQry {

	private CardCondDTO cond;
	private String[] id_keys;

	public GetMmSql(CardCondDTO cond, String[] id_keys) {
		this.cond = cond;
		this.id_keys = id_keys;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (!StringUtil.isEmptyWithTrim(this.cond.getId_mm()))
			param.addParam(this.cond.getId_mm());
		if (this.id_keys != null && this.id_keys.length > 0)
			WfUtils.setSqlParam(param, this.id_keys);
		if (!StringUtil.isEmptyWithTrim(this.cond.getKey())) {
			param.addParam("%" + this.cond.getKey() + "%");
			param.addParam("%" + this.cond.getKey() + "%");
			param.addParam("%" + this.cond.getKey() + "%");
			param.addParam("%" + this.cond.getKey() + "%");
			param.addParam("%" + this.cond.getKey() + "%");
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                 ");
		sqlStr.append(" mm.id_mm as id,        ");
		sqlStr.append(" mm.code,               ");
		sqlStr.append(" mm.name,               ");
		sqlStr.append(" 'Y' as fg_display      ");
		sqlStr.append(" from bd_mm mm          ");
		sqlStr.append(" where mm.ds = 0        ");
		sqlStr.append(" and " + new BdFcEnvContextUtil().getWherePart(new MeterialDO(), "mm"));
		sqlStr.append(" and mm.fg_active = 'Y' ");
		if (!StringUtil.isEmptyWithTrim(this.cond.getId_mm()))
			sqlStr.append(" and mm.id_mm = ?      ");
		String whereNotIn = WfUtils.getSqlParamChars(this.id_keys);
		if (!StringUtil.isEmptyWithTrim(whereNotIn))
			sqlStr.append(" and mm.id_mm not in (" + whereNotIn + ")   ");
		if (!StringUtil.isEmptyWithTrim(this.cond.getKey())) {
			sqlStr.append(" and                  ");
			sqlStr.append(" (                    ");
			sqlStr.append(" mm.code like ?       ");
			sqlStr.append(" or mm.name like ?    ");
			sqlStr.append(" or mm.pycode like ?  ");
			sqlStr.append(" or mm.wbcode like ?  ");
			sqlStr.append(" or mm.mnecode like ? ");
			sqlStr.append(" )                    ");
		}
		sqlStr.append(" order by mm.code asc ");
		return sqlStr.toString();
	}
}
