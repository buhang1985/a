package iih.bd.pp.accountclassifi.refs;

import iih.bd.pp.accountclassifi.d.AccountClassifiDO;
import iih.bd.utils.BdEnvContextUtil;
import org.apache.commons.lang.StringUtils;
import xap.sys.appfw.refinfo.RefGridModel;

public class AccountClassifiRefModel extends RefGridModel{

	@Override
	public String[] getShowFieldCode() {
		return new String[] {AccountClassifiDO.CODE, AccountClassifiDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "核算体系编码", "核算体系名称" };
	}

	@Override
	public String getPkFieldCode() {
		return AccountClassifiDO.ID_ACCOUNT;
	}

	@Override
	public String getRefCodeField() {
		return AccountClassifiDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return AccountClassifiDO.NAME;
	}

	@Override
	public String getTableName() {
		return new AccountClassifiDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { AccountClassifiDO.CODE, AccountClassifiDO.NAME };
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
	
	private String BuildWherePart() {
		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		stringBuilder.append(" and ds = 0 ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new AccountClassifiDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		// 物品分类类型
		String BLAC000002 = (String) this.getExtendAttributeValue("BLAC000002");
		if (!StringUtils.isBlank(BLAC000002)) {
			if("Y".equals(BLAC000002)){
				stringBuilder.append(String.format(" and code = '0' "));
				
			} else if("N".equals(BLAC000002)){								
				stringBuilder.append(String.format(" and code in ('1','2') "));
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
		stringBuilder.append(String.format("%s", AccountClassifiDO.CODE));
		return stringBuilder.toString();
	}
}
