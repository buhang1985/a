package iih.mi.itf2.ref;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mhi.baserefs.MhiBaseRefGridModel;
import iih.bd.utils.BdEnvContextUtil;
import iih.mi.bd.miudidoc.d.MiUdidocDO;
import iih.mi.bd.miudidoc.d.desc.MiUdidocDODesc;
import iih.mi.bd.miudidoclist.d.MiUdidoclistDO;
import xap.mw.coreitf.i.IBaseDO;
import xap.sys.appfw.refinfo.RefResultSet;

public class MiUdidocRefModel extends MhiBaseRefGridModel {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{ MiUdidocDO.CODE,MiUdidocDO.NAME};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{
				MiUdidocDO.ID_MIUDIDOCLIST
		};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{
				"编码","名称"
		};
	}
	
	@Override
	public String getPkFieldCode() {
		return MiUdidocDO.ID_MIUDIDOC;
	}
	
	@Override
	public String getRefCodeField() {
		return MiUdidocDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return MiUdidocDO.NAME;
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[]{
				MiUdidocDO.CODE,MiUdidocDO.NAME,MiUdidocDO.PYCODE,MiUdidocDO.WBCODE,MiUdidocDO.MNECODE
		};
	}
	
	@Override
	protected IBaseDO getDo() {
		return new MiUdidocDO();
	}
	
	@Override
	public String getTableName() {
		return MiUdidocDODesc.TABLE_NAME;
	}
	
	@Override
	protected String getBaseRefSql() {
		StringBuilder sql = new StringBuilder();
		sql.append(" select  udidoc.code,udidoc.name ");
		sql.append("     from  mi_udidoc  udidoc ");
		sql.append("     left  join  mi_udidoclist  udidoclist ");
		sql.append("         on  udidoc.id_miudidoclist  =  udidoc.id_miudidoclist ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MiUdidoclistDO(),"udidoclist");
		sql.append(String.format("WHERE %s ", BdModeWherePart));
		return sql.toString();
	}

	@Override
	public RefResultSet filterRefPks(String[] filterPks) {
		this._isByPks = true;
		RefResultSet resultSet = this.getRefResultByPks(filterPks);
		this._isByPks = false;
		return resultSet;
	}
	
	private RefResultSet getRefResultByPks(String[] filterPks) {
		String wherePart = SqlUtils.getInSqlByIds(MiUdidocDO.ID_MIUDIDOC, filterPks);

		try {
			this.addWherePart(wherePart);
			RefResultSet localRefResultSet = getRefData();
			return localRefResultSet;
		} finally {
			this.removeWherePart(wherePart);
		}
	}
	
	@Override
	protected String buildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", MiUdidocDO.CODE));
		return stringBuilder.toString();
	}
}
