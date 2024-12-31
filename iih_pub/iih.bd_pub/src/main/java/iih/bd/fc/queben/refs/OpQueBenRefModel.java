package iih.bd.fc.queben.refs;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.queben.d.QueBenDO;
import iih.bd.utils.BdEnvContextUtil;

/**
 * 门诊分诊台参照模型
 * 
 * @author liubin
 *
 */
public class OpQueBenRefModel extends QueBenRefModel {

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
		stringBuilder
				.append(String.format(" and fg_active = 'Y' and Sd_quebentp = '%s' ", IBdFcDictCodeConst.SD_QUETP_EMP));
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new QueBenDO(), false);
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
		stringBuilder.append(String.format("%s", QueBenDO.CODE));
		return stringBuilder.toString();
	}
}
