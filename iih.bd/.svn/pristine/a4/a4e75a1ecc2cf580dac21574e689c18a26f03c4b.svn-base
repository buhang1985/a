package iih.bd.fc.s.bp.shortselect.qry;

import iih.bd.fc.dto.shortselect.d.CardCondDTO;
import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.s.bp.common.WfUtils;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:查询医疗服务信息
 * @author: xu_xing@founder.com.cn
 * @version：2019年3月14日 下午4:21:09 创建
 */
public class GetSrvSql implements ITransQry {

	private CardCondDTO cond;
	private String[] id_keys;

	public GetSrvSql(CardCondDTO cond, String[] id_keys) {
		this.cond = cond;
		this.id_keys = id_keys;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (!StringUtil.isEmptyWithTrim(this.cond.getId_srv()))
			param.addParam(this.cond.getId_srv());
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
		sqlStr.append(" select                  ");
		sqlStr.append(" srv.id_srv as id,       ");
		sqlStr.append(" srv.code,               ");
		sqlStr.append(" srv.name,               ");
		sqlStr.append(" 'Y' as fg_display       ");
		sqlStr.append(" from bd_srv srv         ");
		sqlStr.append(" where srv.ds = 0        ");
		sqlStr.append(" and srv.fg_active = 'Y' ");
		sqlStr.append(" and " + new BdFcEnvContextUtil().getWherePart(new MedSrvDO(), "srv"));
		if (!StringUtil.isEmptyWithTrim(this.cond.getId_srv()))
			sqlStr.append(" and srv.id_srv = ? ");
		String whereNotIn = WfUtils.getSqlParamChars(this.id_keys);
		if (!StringUtil.isEmptyWithTrim(whereNotIn))
			sqlStr.append(" and srv.id_srv not in (" + whereNotIn + ")   ");
		if (!StringUtil.isEmptyWithTrim(this.cond.getKey())) {
			sqlStr.append(" and                   ");
			sqlStr.append(" (                     ");
			sqlStr.append(" srv.code like ?       ");
			sqlStr.append(" or srv.name like ?    ");
			sqlStr.append(" or srv.pycode like ?  ");
			sqlStr.append(" or srv.wbcode like ?  ");
			sqlStr.append(" or srv.mnecode like ? ");
			sqlStr.append(" )                     ");
		}
		sqlStr.append(" order by srv.code asc   ");
		return sqlStr.toString();
	}
}
