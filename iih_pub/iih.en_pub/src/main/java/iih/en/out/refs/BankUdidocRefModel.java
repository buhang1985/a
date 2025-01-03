package iih.en.out.refs;

 import java.util.List;

import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import xap.mw.core.utils.ListUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 银行参照_自定义档案
 * @author li.wm
 *
 */
public class BankUdidocRefModel extends RefGridModel {	

	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{UdidocDO.CODE,UdidocDO.NAME,UdidocDO.CTRL1};
	}

	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{UdidocDO.ID_UDIDOC};
	}

	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[]{"编码","名称","联行号"};
	}
	@Override
	public String[] getBlurFields() {
		return new String[]{UdidocDO.CODE,UdidocDO.NAME,UdidocDO.CTRL1,UdidocDO.ID_UDIDOC};
	}
	
	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return UdidocDO.ID_UDIDOC;
	}

	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return UdidocDO.CODE;
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return UdidocDO.NAME;
	}
	
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "BANK";
	}
	@Override
	public String getRefSql() {
		StringBuilder refSql = new StringBuilder();
		
		refSql.append(" SELECT  BANK.CODE,BANK.NAME,BANK.CTRL1,BANK.ID_UDIDOC FROM BD_UDIDOC  BANK      ");
		refSql.append(" LEFT JOIN BD_UDIDOCLIST LIST  ON LIST.ID_UDIDOCLIST = BANK.ID_UDIDOCLIST  ");
		refSql.append(" WHERE LIST.CODE = '"+IEnDictCodeTypeConst.SD_BANK_UDIDOC+"' ");
		
		List<String> whereList = getWherePart();
		if (!ListUtil.isEmpty(whereList)) {	
			for (String where : whereList) {
				refSql.append(" AND (").append(where).append(") ");
			}
		}
		
	    refSql.append(" ORDER BY  BANK.CODE   ");
	    
		return refSql.toString();
	}
	


}
