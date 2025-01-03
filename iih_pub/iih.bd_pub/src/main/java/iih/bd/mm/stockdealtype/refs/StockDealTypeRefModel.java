package iih.bd.mm.stockdealtype.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.mm.stockdealtype.d.StockDealTypeDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class StockDealTypeRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { StockDealTypeDO.CODE, StockDealTypeDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { StockDealTypeDO.ID_MMSTCA, StockDealTypeDO.ID_GRP, StockDealTypeDO.ID_ORG,
				StockDealTypeDO.ID_DIRECT, StockDealTypeDO.SD_DIRECT, StockDealTypeDO.ID_MMTP, StockDealTypeDO.SD_MMTP,
				StockDealTypeDO.SD_STTP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "分类编码", "分类名称" };
	}

	@Override
	public String getPkFieldCode() {
		return StockDealTypeDO.ID_MMSTCA;
	}

	@Override
	public String getRefCodeField() {
		return StockDealTypeDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return StockDealTypeDO.NAME;
	}

	@Override
	public String getTableName() {
		return new StockDealTypeDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { StockDealTypeDO.NAME, StockDealTypeDO.CODE, StockDealTypeDO.PYCODE,
				StockDealTypeDO.WBCODE, StockDealTypeDO.INSTR };
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
		stringBuilder.append(" and ds = 0 ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new StockDealTypeDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		String sd_sttp = (String) this.getExtendAttributeValue("sd_sttp");
		String sd_mmtp = (String) this.getExtendAttributeValue("sd_mmtp");
		String sd_direct = (String) this.getExtendAttributeValue("sd_direct");

		if (!StringUtils.isBlank(sd_sttp)) {
			stringBuilder.append(" and sd_sttp = '" + sd_sttp + "' ");
		}
		
		if (!StringUtils.isBlank(sd_mmtp)) {
			stringBuilder.append(" and sd_mmtp = '" + sd_mmtp + "' ");
		}
		
		if (!StringUtils.isBlank(sd_direct)) {
			stringBuilder.append(" and sd_direct = '" + sd_direct + "' ");
		}

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", StockDealTypeDO.CODE));
		return stringBuilder.toString();
	}
}
