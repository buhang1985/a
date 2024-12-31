package iih.bd.bc.medterm.refs;

import iih.bd.bc.medterm.d.SampCollectTimeDictDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class SampCollectTimeDictRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { SampCollectTimeDictDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { SampCollectTimeDictDO.ID_SAMPCOLLECTTIME, SampCollectTimeDictDO.ID_SAMPCOLLECTTIMETP,
				SampCollectTimeDictDO.SD_SAMPCOLLECTTIMETP, SampCollectTimeDictDO.LEN_TIME,
				SampCollectTimeDictDO.ID_UNIT_TIME };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { SampCollectTimeDictDO.ID_SAMPCOLLECTTIME, SampCollectTimeDictDO.PYCODE,
				SampCollectTimeDictDO.WBCODE, SampCollectTimeDictDO.MNECODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return SampCollectTimeDictDO.ID_SAMPCOLLECTTIME;
	}

	@Override
	public String getTableName() {
		return new SampCollectTimeDictDO().getTableName();
	}

	@Override
	public String getRefNameField() {
		return SampCollectTimeDictDO.NAME;
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new SampCollectTimeDictDO(), false);
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
		return stringBuilder.toString();
	}
}
