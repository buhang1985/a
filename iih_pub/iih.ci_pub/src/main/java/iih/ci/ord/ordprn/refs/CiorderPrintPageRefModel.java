package iih.ci.ord.ordprn.refs;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.ordprn.d.OrdPrintDO;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

/**
 * 医嘱单打印页码参照模型
 * @author Young
 *
 */
public class CiorderPrintPageRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { OrdPrintDO.PAGE_NUM };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { OrdPrintDO.ID_ORPRN };
	}

	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[] { "页号" };
	}

	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return OrdPrintDO.ID_ORPRN;
	}

	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return OrdPrintDO.ID_ORPRN;
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return OrdPrintDO.PAGE_NUM;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return new OrdPrintDO().getTableName();
	}

	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		String param = "";
		if (!StringUtils.isEmpty(blurValue) && isNumeric(blurValue)) {
			param = " ci_or_prn.Page_num+1 like ?";
			this.getParam().addParam("%" + (Integer.parseInt(blurValue)) + "%");
			this.addWherePart(param);
		}
		try {
			if (pg == null)
				return this.getRefData();
			else
				return this.getRefData(pg);
		} finally {
			this.removeWherePart(param);
		}
	}

	@Override
	public String getRefSql() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct page_num+1 page_num,id_en||'_'||cast(page_num as VARCHAR2(20)) id_orprn ")
		.append("from ci_or_prn where ds<1");
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String part : whereList) {
				sb.append(" and ").append(part);
			}
		}
		sb.append(" order by page_num");
		return sb.toString();
	}

	public boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}
	
}
