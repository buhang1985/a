package iih.ems.eass.emcard.refs;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.ems.common.udi.EmsUdiConst;
import xap.sys.appfw.refinfo.RefGridModel;

public class EmcardRefModel extends  RefGridModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1;

	@Override
	public String getPkFieldCode() {
		return "id_card";
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "name", "card_no","ca_name" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称", "编码","分类名称" };
	}
	
	@Override
	public String getRefNameField() {
		return "name";
	}
	@Override
	public String getRefCodeField() {
		return "card_no";
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_card","barcode","dt_fac","buy_price","batch","id_em","em_name","em_code","specs","emca_inrcode","brand_name","model"};
	}

	@Override
	public String getTableName() {
		return "card";
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { "name", "card_no"};
	}
	
	@Override
	public String getRefSql() {
		StringBuffer SQL = new StringBuffer();
		SQL.append(" SELECT ");
		
		SQL.append("     card.name, ");
		SQL.append("    card.card_no, ");
		SQL.append("    ca.name as ca_name, ");
		SQL.append("    card.id_card, ");
		SQL.append("    card.barcode, ");
		SQL.append("    card.dt_fac, ");
		SQL.append("    card.buy_price, ");
		SQL.append("    itm.batch, ");
		SQL.append("      info.id_em, ");
		SQL.append("      info.name as em_name, ");
		SQL.append("     info.code as em_code, ");
		SQL.append("     info.specs, ");
		SQL.append("    info.emca_inrcode, ");
		SQL.append("    info.brand_name, ");
		SQL.append("    info.model ");
		SQL.append(" from ");
		SQL.append("     ems_card card");
		SQL.append("      left join ems_info info");
		SQL.append("     on card.id_em = info.id_em");
		SQL.append("     left join ems_ca ca");
		SQL.append("     on ca.id_emca = card.id_emca ");
		SQL.append("      left join ems_in_itm itm ");
		SQL.append("      on card.id_initm = itm.id_initm ");
		SQL.append("  where   1=1 ");
		String id_wh = (String) this.getExtendAttributeValue("id_wh");
		if(!StringUtils.isBlank(id_wh)){
			SQL.append(" and card.id_wh = '" + id_wh + "'");
		}
		//可用的 并且审核通过的
		SQL.append(" and card.fg_avail = 'Y'  ");
		
		//资产入账状态
		String sd_stu = (String) this.getExtendAttributeValue("sd_stu");
		if(sd_stu==null){sd_stu="";}
		//默认加上入账审核的状态
		if(StringUtils.isBlank(sd_stu))
		{
			SQL.append(" and card.sd_stu = '"+EmsUdiConst.SD_CARD_INACC_SH+"'  ");
		}else if(sd_stu.equals("-1"))//-1为不验证入账状态
		{
			
		}else{
			SQL.append(" and card.sd_stu = '"+sd_stu+"'  ");
		}
		
		//设备是否已出库
		String fg_out = (String) this.getExtendAttributeValue("fg_out");
	    if(StringUtils.isNotBlank(fg_out))
		{
			SQL.append(" and card.fg_out = '"+fg_out+"'  ");
		}	
	    String not_in_card = (String) this.getExtendAttributeValue("not_in_card");
		if(!StringUtils.isBlank(not_in_card)){
			SQL.append(" and card.id_card not in ("+not_in_card+")");
		}
	    StringBuilder sb = new StringBuilder(SQL);
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}
		
		sb.append(" order by card_no ");
		
		return sb.toString();
		
		
	}
	
}
