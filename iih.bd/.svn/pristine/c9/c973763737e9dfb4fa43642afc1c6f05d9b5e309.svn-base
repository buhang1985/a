package iih.bd.fc.s.bp.shortselect.qry;

import iih.bd.fc.dto.shortselect.d.CardCondDTO;
import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.s.bp.common.WfUtils;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * @Description:查询档案信息
 * @author: xu_xing@founder.com.cn
 * @version：2019年3月14日 下午4:21:09 创建
 */
public class GetDocSql implements ITransQry {

	private CardCondDTO cond;
	private String id_udidoclist;
	private String id_udidoc;
	private String[] id_keys;

	public GetDocSql(CardCondDTO cond, String id_udidoc, String id_udidoclist, String[] id_keys) {
		this.cond = cond;
		this.id_udidoc = id_udidoc;
		this.id_keys = id_keys;
		this.id_udidoclist = id_udidoclist;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this.id_udidoclist);
		if (!StringUtil.isEmptyWithTrim(id_udidoc))
			param.addParam(this.id_udidoc);
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
		sqlStr.append(" select               ");
		sqlStr.append(" doc.id_udidoc as id, ");
		sqlStr.append(" doc.code,            ");
		sqlStr.append(" doc.name,            ");
		sqlStr.append(" 'Y' as fg_display    ");
		sqlStr.append(" from bd_udidoc doc   ");
		sqlStr.append(" where doc.ds = 0     ");
		sqlStr.append(" and " + new BdFcEnvContextUtil().getWherePart(new UdidocDO(), "doc"));
		sqlStr.append(" and doc.activestate = 2        ");
		sqlStr.append(" and doc.id_udidoclist = ?      ");
		if (!StringUtil.isEmptyWithTrim(this.id_udidoc))
			sqlStr.append(" and doc.id_udidoc = ?      ");
		String whereNotIn = WfUtils.getSqlParamChars(this.id_keys);
		if (!StringUtil.isEmptyWithTrim(whereNotIn))
			sqlStr.append(" and doc.id_udidoc not in (" + whereNotIn + ")   ");
		if (!StringUtil.isEmptyWithTrim(this.cond.getKey())) {
			sqlStr.append(" and                   ");
			sqlStr.append(" (                     ");
			sqlStr.append(" doc.code like ?       ");
			sqlStr.append(" or doc.name like ?    ");
			sqlStr.append(" or doc.pycode like ?  ");
			sqlStr.append(" or doc.wbcode like ?  ");
			sqlStr.append(" or doc.mnecode like ? ");
			sqlStr.append(" )                     ");
		}
		sqlStr.append(" order by doc.code as ");
		return sqlStr.toString();
	}
}
