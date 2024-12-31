/**  
 * Project Name:iih.bd.mm  
 * File Name:MediDirecDtoSql.java  
 * Package Name:iih.bd.mm.medidirecdto.s.bp.sql  
 * Date:2018年7月23日上午10:25:44  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package iih.bd.mm.medidirecdto.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**  
 * ClassName:MediDirecDtoSql <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2018年7月23日 上午10:25:44 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_80  
 * @see        
 */
public class MediDirecDtoSql implements ITransQry {

	
	private String _wherePart;

	public MediDirecDtoSql(String wherePart) {
		this._wherePart = wherePart;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return null;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT  ");
		sb.append("G.FG_ACTIVE, ");
		sb.append("F.CODE, ");
		sb.append("F.NAME, ");
		sb.append("F.SPEC, ");
		sb.append("F.Sup_Name, ");
		sb.append("C.NAME AS ID_ROUTE,  ");
		sb.append("H.NAME AS GENERICNAME,  ");
		sb.append("K.NAME AS DOSAGEFORM,   ");
		sb.append("G.ID_ORALMECH_REL,  ");
		sb.append("G.SV  ,");
		sb.append("G.ID_GRP  ,");
		sb.append("G.ID_ORG  ");
		sb.append("FROM( ");
		sb.append("SELECT FG_ACTIVE, ");
		sb.append("ID_ORALMECH_REL, ");
		sb.append("ID_MM, ");
		sb.append("ID_SRV, ");
		sb.append("ID_ROUTE, ");
		sb.append("Sup_Name, ");
		sb.append("ID_DOSAGE,SV,ID_ORG,ID_GRP FROM(SELECT  ");
		sb.append("N.FG_ACTIVE, ");
		sb.append("N.ID_ORALMECH_REL, ");
		sb.append("N.ID_MM, ");
		sb.append("B.ID_SRV, ");
		sb.append("B.ID_ROUTE, ");
		sb.append("B.Sup_Name, ");
		sb.append("E.ID_DOSAGE, ");
		sb.append("N.SV ,");
		sb.append("N.ID_GRP  ,");
		sb.append("N.ID_ORG  ");
		sb.append("FROM  BD_MM_ORALMECH_REL N ");
		sb.append("LEFT JOIN BD_MM B ON N.ID_MM=B.ID_MM ");
		sb.append("LEFT JOIN BD_SRV D ON D.ID_SRV=B.ID_SRV ");
		sb.append("LEFT JOIN BD_SRV_DRUG E ON E.ID_SRV=D.ID_SRV  ORDER BY N.SV DESC) ");
		sb.append("WHERE ");
		String wherePart = GetWherePart();
		sb.append(wherePart);
		sb.append(String.format(" and id_grp = '%s' and id_org = '%s'",Context.get().getGroupId(), Context.get().getOrgId()));
		sb.append(" ) G ");
		sb.append("LEFT JOIN BD_MM F ON G.ID_MM=F.ID_MM ");
		sb.append("LEFT JOIN BD_SRV H ON H.ID_SRV=G.ID_SRV ");
		sb.append("LEFT JOIN BD_SRV_DRUG J ON J.ID_SRV=G.ID_SRV ");
		sb.append("LEFT JOIN BD_ROUTE C ON C.ID_ROUTE=G.ID_ROUTE ");
		sb.append("LEFT JOIN BD_UDIDOC K ON K.ID_UDIDOC=G.ID_DOSAGE ");
		return sb.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		if (StringUtils.isNotEmpty(this._wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

}
  
