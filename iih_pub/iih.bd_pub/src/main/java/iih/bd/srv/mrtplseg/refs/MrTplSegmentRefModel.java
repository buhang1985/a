package iih.bd.srv.mrtplseg.refs;

import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class MrTplSegmentRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MrTplSegmentDO.CODE, MrTplSegmentDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MrTplSegmentDO.ID_MRTPLSEC };
	}

	@Override
	public String getTableName() {
		return new MrTplSegmentDO().getTableName();
	}

	@Override
	public String getPkFieldCode() {
		return MrTplSegmentDO.ID_MRTPLSEC;
	}

	@Override
	public String getRefCodeField() {
		return MrTplSegmentDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MrTplSegmentDO.NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MrTplSegmentDO.CODE, MrTplSegmentDO.NAME, MrTplSegmentDO.PYCODE, MrTplSegmentDO.WBCODE,
				MrTplSegmentDO.MNECODE };
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().add(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().add(orderPart);}
			refSql = super.getRefSql();

		} finally {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().remove(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().remove(orderPart);}
		}

		return refSql;
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {

		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MrTplSegmentDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", MrTplSegmentDO.CODE));
		return stringBuilder.toString();
	}
}
