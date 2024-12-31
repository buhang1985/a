package iih.mkr.std.commonde.refs;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.mkr.std.commonde.d.DataElementDO;
import iih.mkr.utils.MkrEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 公共数据元参照模型
 * 
 * @author wangyuchun
 *
 */
public class DeSetsRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3371122101739592875L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DataElementDO.CODE, DataElementDO.NAME ,"DataElementListName" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DataElementDO.ID_DE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称","数据集名称" };
	}

	@Override
	public String getTableName() {
		return new DataElementDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { DataElementDO.CODE, DataElementDO.WBCODE, DataElementDO.PYCODE, DataElementDO.NAME,
				DataElementDO.MNECODE ,"DataElementListName" };
	}

	@Override
	public String getPkFieldCode() {
		return DataElementDO.ID_DE;
	}

	@Override
	public String getRefCodeField() {
		return DataElementDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return DataElementDO.NAME;
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();

		StringBuffer sql = new StringBuffer();
		sql.append(" select bd_de.Code, bd_de.Name,bd_de.DataElementListName,bd_de.ID_DE from (                                                               ");
		sql.append("select bd_de.id_org,bd_de.id_grp,bd_de.Code, bd_de.Name,bd_set.NAME AS DataElementListName ,bd_de.Id_de ,bd_de.FG_ACTIVE ,bd_de.MNECODE,bd_de.PYCODE,bd_de.WBCODE , bd_de.DS from bd_de bd_de ");
		sql.append(" left join BD_SET_DE bd_set_de on bd_de.ID_DE = bd_set_de.ID_DE  ");
		sql.append(" left join BD_SET bd_set on bd_set_de.ID_SET = bd_set.ID_SET ) bd_de ");
		sql.append(" where 1=1 and bd_de.id_de not in ('~') and bd_de.ds = 0  and 1 = 1 and bd_de.fg_active = 2  and (1 = 1)     ");
		if (wherePart != null && !"".equals(wherePart)) {
			this.getWherePart().add(wherePart);
		}
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {

			for (String where : whereList) {
				sql.append(" and ").append(where).append(" ");
			}
		}
		System.out.println(sql.toString());
		return sql.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {
		String dgId = (String) this.getExtendAttributeValue("dgId");

		StringBuilder stringBuilder = new StringBuilder("1 = 1 ");
		stringBuilder.append("and fg_active = 2 ");
		String BdModeWherePart = MkrEnvContextUtil.processEnvContext(new DataElementDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		if (!StringUtils.isBlank(dgId)) {
			String wherePart = String.format(" and id_de in (select id_de from bd_dg_de where id_dg = '%s') ", dgId);
			stringBuilder.append(wherePart);
		}

		System.out.println(stringBuilder.toString());
		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", DataElementDO.CODE));
		return stringBuilder.toString();
	}
}
