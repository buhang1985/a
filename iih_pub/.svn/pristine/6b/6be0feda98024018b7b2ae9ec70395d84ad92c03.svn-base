package iih.bd.mm.certi.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.certi.d.CertificationDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class CertiRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { CertificationDO.CODE, CertificationDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { CertificationDO.ID_MMCF, CertificationDO.ID_ORG };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return CertificationDO.ID_MMCF;
	}

	@Override
	public String getRefCodeField() {
		return CertificationDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return CertificationDO.NAME;
	}

	@Override
	public String getTableName() {
		return new CertificationDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { CertificationDO.NAME, CertificationDO.CODE, CertificationDO.PYCODE,
				CertificationDO.WBCODE, CertificationDO.INSTR };
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new CertificationDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		String sd_mmtp = (String) this.getExtendAttributeValue("Sd_mmtp");

		if (!StringUtils.isBlank(sd_mmtp)) {
			if (sd_mmtp.startsWith(IBdMmDictCodeConst.SD_MMTP_WEISHENG)) {
				stringBuilder.append(" and fg_vitems = 'Y' ");
			} else if (sd_mmtp.startsWith(IBdMmDictCodeConst.SD_MMTP_WEISHENG_HIGH)) {
				stringBuilder.append(" and fg_vitems = 'Y' ");
			} else if (sd_mmtp.startsWith(IBdMmDictCodeConst.SD_MMTP_WEISHENG_COMM)) {
				stringBuilder.append(" and fg_items = 'Y' ");
			} else if (sd_mmtp.startsWith(IBdMmDictCodeConst.SD_MMTP_DRUG)) {
				stringBuilder.append(" and fg_drug = 'Y' ");
			} else {
				stringBuilder.append(" and 1 = 0 ");
			}
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
		stringBuilder.append(String.format("%s", CertificationDO.CODE));
		return stringBuilder.toString();
	}

}