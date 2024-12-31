package iih.bd.srv.medusage.refs;

import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;

import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.xbd.udi.d.UdidocDO;

public class UdoiUseageRefModel extends RefGridModel{
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{UdidocDO.CODE,UdidocDO.NAME};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{UdidocDO.ID_UDIDOC};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[]{"编码","名称"};
	}

	@Override
	public String getTableName() {
		return new UdidocDO().getTableName();
	}

	@Override
	public String getPkFieldCode() {
		return UdidocDO.ID_UDIDOC;
	}

	@Override
	public String getRefCodeField() {
		return UdidocDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return UdidocDO.NAME;
	}

	@Override
	public String getRefSql() {
		String srvtp = (String)getExtendAttributeValue("srvtp");
		String refSql = "";
		if(srvtp!=null&&srvtp.equals("Y"))
		//???todo  改为StringBuilder
		refSql += "select '00' as code,'全部' as name,'1' as id_udidoc from bd_udidoc  " 
				+ "union ";	
		refSql  += "select code,name,id_udidoc from bd_udidoc where id_udidoclist='"+IBdSrvDictCodeTypeConst.ID_SRVTP+"' and code like '__' ";
		


		StringBuilder sb = new StringBuilder(refSql);
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
		
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}

		sb.append(" order by code");
		return sb.toString();
	}	


}
