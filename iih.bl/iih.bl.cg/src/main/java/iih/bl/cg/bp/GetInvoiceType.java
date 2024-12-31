package iih.bl.cg.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import iih.bd.srv.srvrtctl.d.SrvRtItmDO;
import iih.bl.cg.dto.d.SrvVsInvoiceTypeDTO;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;

public class GetInvoiceType {
	/**根据就诊ID，返回（住院费用）获取项目发票打印信息SQL
	 * 
	 * @param id_cgitmoep
	 * @return
	 */
	public String GetInvocieTypeFromBlCgIpByIdentSql()
	{
		  StringBuffer sql=new StringBuffer();

		  
		 // sql.append("    SELECT X.ID_SRV,x.name_srv,x.amt*x.eu_direct amt,x.amt_std*x.eu_direct amt_std,Z.invoicety_name,y.code CODE_SRVCA ,x.sd_srvtp");
		  sql.append("    SELECT X.ID_SRV,x.name_srv,x.amt*x.eu_direct amt,x.amt_std*x.eu_direct amt_std,name_inccaitm invoicety_name,x.sd_srvtp");
		  sql.append(" 		     FROM BL_CG_IP X ");
		//  sql.append(" 		     JOIN BD_SRVCA Y ");
		//  sql.append(" 		       ON X.ID_SRVCA = Y.ID_SRVCA ");
		//  sql.append(" 		     LEFT JOIN (SELECT B.ID_INCCAITM, ");
		//  sql.append(" 		                       B.NAME  as invoicety_name, ");
		//  sql.append(" 		                       B.CODE        AS CODE_INCCAITM, ");
		//  sql.append(" 		                       C.ID_SRV ");
		//  sql.append(" 		                  FROM  BD_INCCA_ITM B ");
		//  sql.append(" 		                  JOIN BD_INCCA_ITM_REL C ");
		//  sql.append(" 		                    ON B.ID_INCCAITM = C.ID_INCCAITM ");
		//  sql.append(" 		                 WHERE c.ID_INCCA =?) Z ");//住院票据分类ID
		//  sql.append(" 		       ON X.ID_SRV = Z.ID_SRV ");
		  sql.append("             WHERE X.ID_ENT=?  ");//就诊ID
		  sql.append("              and x.id_pat=? and x.fg_st='N' ");//病人ID
		  return sql.toString();
	}
	/**根据记账主键，返回获取项目发票打印信息SQL
	 * 
	 * @param id_cgitmoep
	 * @return
	 */
	private String GetInvocieTypeByCgOepIdSql()
	{
		  StringBuffer sql=new StringBuffer();
//		  sql.append(" SELECT  INCREL.ID_SRV ,INCITM.NAME");
//		  sql.append("  FROM BD_INCCA INCCA ");
//		  sql.append("  JOIN BD_INCCA_ITM INCITM ");
//		  sql.append("    ON INCCA.ID_INCCA = INCITM.ID_INCCA ");
//		  sql.append("  JOIN BD_INCCA_ITM_REL INCREL ");
//		  sql.append("    ON INCITM.ID_INCCAITM = INCREL.ID_INCCAITM ");
//		  sql.append("  JOIN BL_CG_ITM_OEP CG ");
//		  sql.append("    ON CG.ID_SRV = INCREL.ID_SRV ");
//		  sql.append(" WHERE INCCA.ID_INCCA = ? ");//门诊票据分类ID
//		  sql.append("   AND CG.ID_CGOEP in (?) ");//记账号
		  
		  sql.append(" SELECT X.ID_SRV, Z.NAME");
		  sql.append("   FROM BL_CG_ITM_OEP X");
		  sql.append("   LEFT JOIN (SELECT B.ID_INCCAITM,");
		  sql.append("                     B.NAME        ,");
		  sql.append("                     B.CODE        AS CODE_INCCAITM,");
		  sql.append("                     C.EU_SRVORCA,");
		  sql.append("                     C.ID_SRV,");
		  sql.append("                     C.ID_SRVCA");
		 // sql.append("                     D.CODE        AS CODE_SRVCA");
		  sql.append("                FROM  BD_INCCA_ITM B");
		  sql.append("                JOIN BD_INCCA_ITM_REL C");
		  sql.append("                  ON B.ID_INCCAITM = C.ID_INCCAITM");
		  sql.append("               WHERE C.ID_INCCA =?) Z");//门诊票据分类ID
		  sql.append("     ON X.ID_SRV = Z.ID_SRV");
		  sql.append("      WHERE X.ID_CGOEP in (?) ");//记账号
		  return sql.toString();
	}
	
	/**根据结算主键，返回获取项目发票打印信息SQL
	 * 
	 * @param id_cgitmoep
	 * @return
	 */
	private String GetInvocieTypeByStIdSql()
	{
		  StringBuffer sql=new StringBuffer();
		  
//		  sql.append(" SELECT x.id_srv, y.eu_direct*x.AMT_ratio amt_ratio,Z.CODE_INCCAITM as code,Z.NAME");
//		  sql.append("   FROM BL_CG_ITM_OEP X inner join bl_cg_oep y on x.id_cgoep=y.id_cgoep");
//		  sql.append("   LEFT JOIN (SELECT B.ID_INCCAITM,");
//		  sql.append("                     B.NAME        ,");
//		  sql.append("                     B.CODE        AS CODE_INCCAITM,");
//		  sql.append("                     C.EU_SRVORCA,");
//		  sql.append("                     C.ID_SRV,");
//		  sql.append("                     C.ID_SRVCA");
//		 // sql.append("                     D.CODE        AS CODE_SRVCA");
//		  sql.append("                FROM   BD_INCCA bb inner join BD_INCCA_ITM B on bb.id_incca=b.id_incca ");
//		  sql.append("                JOIN BD_INCCA_ITM_REL C");
//		  sql.append("                  ON B.ID_INCCAITM = C.ID_INCCAITM");
//		  sql.append("               WHERE bb.code =?) Z");//门诊票据分类CODE
//		  sql.append("     ON X.ID_SRV = Z.ID_SRV");
//		  sql.append("      WHERE X.ID_stOEP in (?) ");//结算号
		  
		  sql.append(" SELECT x.id_srv,");
		  sql.append("             y.eu_direct * x.AMT_ratio amt_ratio,");
		  sql.append("             x.name_inccaitm name,");
		  sql.append("             x.code_inccaitm code");
		  sql.append("        FROM BL_CG_ITM_OEP X ");
		  sql.append("       inner join bl_cg_oep y ");
		  sql.append("          on x.id_cgoep = y.id_cgoep ");
		  sql.append("       where ");//门诊票据分类CODE
		  sql.append("       	x.id_stoep in (?) ");//结算号

		  
		  
		  
		  
		  return sql.toString();
	}

	
	/**
	 * 根据记账主键，生成该记账主键下的所有发票信息,不能用记账，如果有提前记账的内容，则当前记账下的内容不全
	 * @param id_cgitmoep
	 * @return
	 * @throws BizException
	 */
	/**public BlIncItmVsTypeDTO[] getBlIncItmVsTypeDTOs(String id_stoep,String id_incca)   throws BizException  
	{
		ArrayList<BlIncItmVsTypeDTO> blIncItmVsTypeDTOList=new ArrayList<BlIncItmVsTypeDTO>();
		//明天的活儿
		ColumnHandler handler = new ColumnHandler();
    	String sql=GetInvocieTypeByStIdSql();
    	SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_incca);
		sqlParam.addParam(id_stoep);
    	DAFacade cade = new DAFacade();
    	List<BlIncItmVsTypeDTO> list= (List<BlIncItmVsTypeDTO>)new DAFacade().execQuery(sql,sqlParam, new BeanListHandler(BlIncItmVsTypeDTO.class));
		
		return blIncItmVsTypeDTOList.toArray(new BlIncItmVsTypeDTO[]{});
	}*/
	/**
	 * 获取所有服务的对应的发票分类SQL
	 * @param id_incca 发票类型
	 * @return
	 */
	private String GetAllSrvInvocieTypeSql()
	{
		StringBuffer sql=new StringBuffer();
		
		sql.append(" SELECT A.ID_SRV,");
		sql.append("    B.NAME");
		sql.append(" FROM");
		sql.append(" FROM BD_INCCA_ITM A");
		sql.append(" JOIN BD_INCCA_ITM_REL B ON A.ID_INCCAITM = B.ID_INCCAITM  ");
		sql.append(" WHERE B.ID_INCCA = ? "); // 门诊发票 0001AA1000000001SHRD 

		

		
//		sql.append(" SELECT ID_SRV,");
//		sql.append("    NAME");
//		sql.append(" FROM");
//		sql.append(" (SELECT A.name,");
//		sql.append("      E.ID_SRV,");
//		sql.append("      B.FACTOR");
//		sql.append(" FROM BD_INCCA_ITM A");
//		sql.append(" JOIN BD_INCCA_ITM_REL B ON A.ID_INCCAITM = B.ID_INCCAITM AND B.EU_SRVORCA = 0 ");
//		sql.append(" JOIN BD_SRVCA C ON B.ID_SRVCA = C.ID_SRVCA ");
//		sql.append(" JOIN BD_SRVCA D ON D.CODE LIKE C.CODE ");
//		sql.append(" JOIN BD_SRV E ON E.ID_SRVCA = D.ID_SRVCA ");
//		sql.append(" WHERE A.ID_INCCA = ? "); // 门诊发票 0001AA1000000001SHRD 
//		sql.append(" UNION ALL ");
//		sql.append(" SELECT O.name, ");
//		sql.append("      P.ID_SRV, ");
//		sql.append("      P.FACTOR ");
//		sql.append(" FROM BD_INCCA_ITM O ");
//		sql.append(" JOIN BD_INCCA_ITM_REL P ON O.ID_INCCAITM = P.ID_INCCAITM AND P.EU_SRVORCA = 1) ");
//		sql.append(" GROUP BY name,ID_SRV ");
//		sql.append(" HAVING SUM(FACTOR) > 0 ");
		return sql.toString();
	}
	
	/**
	 * 返回指定结算号所有服务对应的发票分类<name code,amt_ratio>
	 * @param code_incca 票据类型代码
	 * @param id_stoeps sql中in格式的，例如   '11','23'
	 * @return
	 * @throws BizException
	 */
	public SrvVsInvoiceTypeDTO[] GetInvocieTypeByStOepId(String id_stoeps) throws BizException
	{
		Map<String,FDouble> InvocieTypeAndAmtByStId=new HashMap<String,FDouble>();
		
		SqlParam sqlp=new SqlParam();
		//sqlp.addParam(code_incca);
		sqlp.addParam(id_stoeps);
		ArrayList<SrvVsInvoiceTypeDTO> InvocieTypeByStIds = (ArrayList<SrvVsInvoiceTypeDTO>)new DAFacade().execQuery(GetInvocieTypeByStIdSql(), sqlp,new BeanListHandler(SrvVsInvoiceTypeDTO.class));
        if(InvocieTypeByStIds==null || InvocieTypeByStIds.size()==0)
        {
        	return null;
        }
		return InvocieTypeByStIds.toArray(new SrvVsInvoiceTypeDTO[0]);
	}
	
	/**
	 * 返回指定记账主键号所有服务对应的发票分类
	 * @param id_incca 票据类型
	 * @param id_stoeps sql中in格式的，例如   '11','23'
	 * @return
	 * @throws BizException
	 */
	public Map<String,String> GetInvocieTypeByBlCgOepId(String id_incca,String id_cgoeps) throws BizException
	{
		Map<String,String> InvocieTypeByStId=new HashMap<String,String>();
		
		SqlParam sqlp=new SqlParam();
		sqlp.addParam(id_incca);
		sqlp.addParam(id_cgoeps);
		ArrayList<SrvVsInvoiceTypeDTO> InvocieTypeByStIds = (ArrayList<SrvVsInvoiceTypeDTO>)new DAFacade().execQuery(GetInvocieTypeByCgOepIdSql(), sqlp,new BeanListHandler(SrvVsInvoiceTypeDTO.class));
        for(SrvVsInvoiceTypeDTO InvocieTypeByStId1:InvocieTypeByStIds)
        {
        	InvocieTypeByStId.put(InvocieTypeByStId1.getId_srv(),InvocieTypeByStId1.getName());
        }
		return InvocieTypeByStId;
	}
	
//	/**
//	 * 返回指定就诊所有住院服务对应的发票分类
//	 * @param id_incca 票据类型
//	 * @param id_ent 就诊ID
//	 * @return
//	 * @throws BizException
//	 */
//	public Map<String,String> GetInvocieTypeByStId(String id_incca,String id_ent) throws BizException
//	{
//		Map<String,String> InvocieTypeByStId=new HashMap<String,String>();
//		
//		SqlParam sqlp=new SqlParam();
//		sqlp.addParam(id_incca);
//		sqlp.addParam(id_ent);
//		ArrayList<SrvVsInvoiceTypeDTO> InvocieTypeByStIds = (ArrayList<SrvVsInvoiceTypeDTO>)new DAFacade().execQuery(GetInvocieTypeFromBlCgIpByIdentSql(), sqlp,new BeanListHandler(SrvVsInvoiceTypeDTO.class));
//        for(SrvVsInvoiceTypeDTO InvocieTypeByStId1:InvocieTypeByStIds)
//        {
//        	InvocieTypeByStId.put(InvocieTypeByStId1.getId_srv(),InvocieTypeByStId1.getName());
//        }
//		return InvocieTypeByStId;
//	}
	
	/**
	 * 返回所有服务对应的发票分类
	 * @param id_incca 票据类型
	 * @return
	 * @throws BizException
	 */
	public Map<String,String> GetAllSrvInvocieType(String id_incca) throws BizException
	{
		Map<String,String> AllSrvInvoiceType=new HashMap<String,String>();
		
		SqlParam sqlp=new SqlParam();
		sqlp.addParam(id_incca);
		ArrayList<SrvVsInvoiceTypeDTO> srvVsInvoiceTypeDTOs = (ArrayList<SrvVsInvoiceTypeDTO>)new DAFacade().execQuery(GetAllSrvInvocieTypeSql(),sqlp, new BeanListHandler(SrvVsInvoiceTypeDTO.class));
        for(SrvVsInvoiceTypeDTO srvVsInvoiceTypeDTO:srvVsInvoiceTypeDTOs)
        {
        	AllSrvInvoiceType.put(srvVsInvoiceTypeDTO.getId_srv(),srvVsInvoiceTypeDTO.getName());
        }
		return AllSrvInvoiceType;
	}
//	private String GetNewAllSrvInvocieTypeSql(String id_incca)
//	{
//		
//	}

}
