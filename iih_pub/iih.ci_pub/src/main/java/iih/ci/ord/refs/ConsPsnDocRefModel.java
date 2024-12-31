package iih.ci.ord.refs;

import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;
import xap.sys.permfw.pub.EnvContextUtil;

import java.util.List;

import org.apache.commons.lang.StringUtils;

public class ConsPsnDocRefModel  extends RefGridModel{

	private static final long serialVersionUID = 1L;

	  public String[] getShowFieldName()
	  {
	    return new String[] { "人员编码", "人员姓名", "部门" };
	  }

	  public String[] getShowFieldCode()
	  {
	    return new String[] { "Code", "Name", "dep_name" };
	  }

	  public String[] getHiddenFieldCode()
	  {
	    return new String[] { "Id_psndoc", "Id_emptitle", "Sd_emptitle", "name_emptitle", "Des", "Id_dep" };
	  }

	  public String[] getBlurFields()
	  {
	    return new String[] { "Code", "Name", "Pycode", "Wbcode", "Mnecode" };
	  }

	  public String getPkFieldCode()
	  {
	    return "Id_psndoc";
	  }

	  public String getRefCodeField()
	  {
	    return "Code";
	  }

	  public String getRefNameField()
	  {
	    return "Name";
	  }

	  public String getTableName()
	  {
	    return "bd_psndoc";
	  }
	  protected String buildOrderPart()
	  {
	    return "bd_psndoc.pycode,bd_psndoc.code,bd_psndoc.id_psndoc";
	  }
	  private String getBaseRefSql() {
		  StringBuilder sqlBuilder = new StringBuilder();
		    sqlBuilder.append("SELECT bd_psndoc.code,");
		    sqlBuilder.append("bd_psndoc.name,");
		    sqlBuilder.append("dep.name as dep_name,");
		    sqlBuilder.append("bd_psndoc.id_psndoc,");
		    sqlBuilder.append("bd_psndoc.id_emptitle,");
		    sqlBuilder.append("bd_psndoc.sd_emptitle,");
		    sqlBuilder.append("doc.name AS name_emptitle,");
		    sqlBuilder.append("emp.note_phy AS des,");
		    sqlBuilder.append("bd_psndoc.id_dep ");
		    sqlBuilder.append("FROM bd_psndoc ");
		    sqlBuilder.append("LEFT JOIN bd_udidoc doc ");
		    sqlBuilder.append("ON bd_psndoc.id_emptitle = doc.id_udidoc ");
		    sqlBuilder.append("LEFT JOIN bd_dep dep ");
		    sqlBuilder.append("ON bd_psndoc.id_dep = dep.id_dep ");
		    sqlBuilder.append("LEFT JOIN bd_emp_phy emp ");
		    sqlBuilder.append("ON emp.id_psndoc = bd_psndoc.id_psndoc ");
		    return sqlBuilder.toString();
		  }
	  private String getBaseRefSql1(String id_dep,String wp,String id_wg) {
		    StringBuilder sqlBuilder = new StringBuilder();
		    String basesql=this.getBaseRefSql();
		    sqlBuilder.append(basesql);
		    String wherePart = buildWherePart(id_dep,wp,id_wg);
		    String orderPart = buildOrderPart();
		    if (StringUtils.isNotEmpty(wherePart)) {
		    	sqlBuilder.append(" where ");
		    	sqlBuilder.append( wherePart );
		    }
		    if (StringUtils.isNotEmpty(orderPart)) {
		    	sqlBuilder.append(" ORDER BY ");		    	
		    	sqlBuilder.append( orderPart );
		    }
		    return sqlBuilder.toString();
		  }
	  private String getBaseRefSql2(String id_dep,String wp,String id_wg) {
		    StringBuilder sqlBuilder = new StringBuilder();
		    String basesql=this.getBaseRefSql();
		    sqlBuilder.append(basesql);
		    String wherePart = buildWherePart2(id_dep,wp,id_wg);
		    String orderPart = buildOrderPart();
		    if (StringUtils.isNotEmpty(wherePart)) {
		    	sqlBuilder.append(" where ");
		    	sqlBuilder.append( wherePart );
		    }
		    if (StringUtils.isNotEmpty(orderPart)) {
		    	sqlBuilder.append(" ORDER BY ");		    	
		    	sqlBuilder.append( orderPart );
		    }
		    return sqlBuilder.toString();
		  }
	  public String getRefSql()
	  {
		String  wherePart = (String)getExtendAttributeValue("wherePart");
		String depId = (String)getExtendAttributeValue("id_dep");
		String wgId = (String)getExtendAttributeValue("id_wg");
		String baseRefSql = getBaseRefSql1(depId,wherePart,wgId);
		String baseRefSql2 = getBaseRefSql2(depId,wherePart,wgId);
		return "select * from ("+baseRefSql2+")T1 union select * from ("+baseRefSql+")T2";
//	    String wherePart = buildWherePart();
//	    String orderPart = buildOrderPart();
//	    try
//	    {
//	      if (StringUtils.isNotEmpty(wherePart)) {
//	        getWherePart().add(wherePart);
//	      }
//	      if (StringUtils.isNotEmpty(orderPart)) {
//	        getOrderPart().add(orderPart);
//	      }
//
//	      String baseRefSql = getBaseRefSql();
//	      String refSql;
//	      if (StringUtils.isEmpty(baseRefSql))
//	        refSql = super.getRefSql();
//	      else
//	        refSql = getRefSql(baseRefSql);
//	      return refSql;
//	    }
//	    finally
//	    {
//
//	      if (StringUtils.isNotEmpty(wherePart)) {
//	        getWherePart().remove(wherePart);
//	      }
//	      if (StringUtils.isNotEmpty(orderPart))
//	        getOrderPart().remove(orderPart);
//	    }

	  }
	  
	  private String getRefSql(String baseRefSql)
	  {
	    StringBuilder sqlBuilder = new StringBuilder();
	    sqlBuilder.append(baseRefSql);

	    List<String> wherePartList = getWherePart();
	    if ((wherePartList != null) && (wherePartList.size() > 0)) {
	      sqlBuilder.append(" WHERE 1 = 1 ");
	      for (String wherePart : wherePartList) {
	        sqlBuilder.append(" AND ");
	        sqlBuilder.append(wherePart);
	      }
	    }

	    List<String> orderPartList = getOrderPart();
	    if ((orderPartList != null) && (orderPartList.size() > 0)) {
	      sqlBuilder.append(" ORDER BY ");
	      for (int i = 0; i < orderPartList.size(); i++) {
	        if (i != 0) {
	          sqlBuilder.append(" , ");
	        }
	        sqlBuilder.append((String)orderPartList.get(i));
	      }
	    }
	    return sqlBuilder.toString();
	  }
	  
	  protected String buildWherePart2(String depId,String wp,String wgId) {
		  StringBuilder wherePartBuilder = new StringBuilder("bd_psndoc.ds = '0'");

		    String wherePart = String.format(" and bd_psndoc.activestate = '%s'", new Object[] { Integer.valueOf(ActiveStateEnum.ACTIVE.intValue()) });
		    wherePartBuilder.append(wherePart);

		    String bdModeWherePart = EnvContextUtil.processEnvContext("", new PsnDocDO(), false);
		    if (StringUtils.isNotEmpty(bdModeWherePart)) {
		      wherePartBuilder.append(String.format(" AND %s ", new Object[] { bdModeWherePart }));
		    }

		   
//		    if (StringUtils.isNotEmpty(wp)) {
//		      wherePartBuilder.append(" AND ");
//		      wherePartBuilder.append(wp);
//		    }
		    List<String> wherePartList = getWherePart();
		    if ((wherePartList != null) && (wherePartList.size() > 0)) {
		      for (String wpart : wherePartList) {
		    	  wherePartBuilder.append(" AND ");
		        wherePartBuilder.append(wpart);
		      }
		    }

		    if (StringUtils.isNotBlank(depId))
		    {
		    	String sql="select distinct bd_psndoc.id_psndoc " + 
			      		"  from sys_subject_org a " + 
			      		"  left join bd_dep b " + 
			      		"    on a.id_org = b.id_dep " + 
			      		" inner join sys_user c " + 
			      		"    on a.subjectid = c.id_user " + 
			      		"    left join bd_psndoc bd_psndoc on c.id_psn=bd_psndoc.id_psndoc " + 
			      		"    where a.id_org='"+depId+"' ";
			      StringBuilder wherePartBuilder2 = new StringBuilder();
			      wherePartBuilder2.append(sql).append(" and bd_psndoc.ds = '0' ");
			      wherePart = String.format(" and bd_psndoc.activestate = '%s'", new Object[] { Integer.valueOf(ActiveStateEnum.ACTIVE.intValue()) });
				  wherePartBuilder2.append(wherePart);
				  if (StringUtils.isNotEmpty(bdModeWherePart)) {
					 wherePartBuilder2.append(String.format(" AND %s ", new Object[] { bdModeWherePart }));
				  }
				 
//				    if (StringUtils.isNotEmpty(wp)) {
//				      wherePartBuilder2.append(" AND ");
//				      wherePartBuilder2.append(wp);
//				    }
				  if ((wherePartList != null) && (wherePartList.size() > 0)) {
				      for (String wpart : wherePartList) {
				    	  wherePartBuilder2.append(" AND ");
				        wherePartBuilder2.append(wpart);
				      }
				    }
		    	wherePart=" and  bd_psndoc.id_psndoc in ("+wherePartBuilder2.toString()+")";
		    	wherePartBuilder.append(wherePart);
		    }
		    
		    if (StringUtils.isNotBlank(wgId)) {
		      FDate nowDate = new FDate();
		      wherePart = String.format(" and bd_psndoc.id_psndoc in (select id_emp from bd_emp_wg wg where wg.id_wg = '%s' AND wg.d_b <= '%s' AND isnull(wg.d_e,'2100-01-01' ) >= '%s')", new Object[] { wgId, nowDate, nowDate });

		      wherePartBuilder.append(wherePart);
		    }
		    return wherePartBuilder.toString();
	  }

	  protected String buildWherePart(String depId,String wp,String wgId)
	  {
	    StringBuilder wherePartBuilder = new StringBuilder("bd_psndoc.ds = '0'");

	    String wherePart = String.format(" and bd_psndoc.activestate = '%s'", new Object[] { Integer.valueOf(ActiveStateEnum.ACTIVE.intValue()) });
	    wherePartBuilder.append(wherePart);

	    String bdModeWherePart = EnvContextUtil.processEnvContext("", new PsnDocDO(), false);
	    if (StringUtils.isNotEmpty(bdModeWherePart)) {
	      wherePartBuilder.append(String.format(" AND %s ", new Object[] { bdModeWherePart }));
	    }

//	    if (StringUtils.isNotEmpty(wp)) {
//	      wherePartBuilder.append(" AND ");
//	      wherePartBuilder.append(wp);
//	    }
	    List<String> wherePartList = getWherePart();
	    if ((wherePartList != null) && (wherePartList.size() > 0)) {
	      for (String wpart : wherePartList) {
	    	  wherePartBuilder.append(" AND ");
	        wherePartBuilder.append(wpart);
	      }
	    }

	    if (StringUtils.isNotBlank(depId))
	    {
	     wherePart = String.format(" and (bd_psndoc.id_dep = '%s' ", new Object[] { depId });
	      wherePartBuilder.append(wherePart);
	      wherePartBuilder.append("OR bd_psndoc.id_psndoc IN (SELECT distinct b.id_psndoc FROM bd_emp_dep a ");

	      wherePart = String.format("INNER JOIN bd_psndoc b ON a.id_emp =b.id_psndoc AND a.id_dep = '%s' ) ", new Object[] { depId });
	      wherePartBuilder.append(wherePart);
	      wherePartBuilder.append(") ");
	      String sql="select distinct bd_psndoc.id_psndoc " + 
	      		"  from sys_subject_org a " + 
	      		"  left join bd_dep b " + 
	      		"    on a.id_org = b.id_dep " + 
	      		" inner join sys_user c " + 
	      		"    on a.subjectid = c.id_user " + 
	      		"    left join bd_psndoc bd_psndoc on c.id_psn=bd_psndoc.id_psndoc " + 
	      		"    where a.id_org='"+depId+"' ";
	      StringBuilder wherePartBuilder2 = new StringBuilder();
	      wherePartBuilder2.append(sql).append(" and bd_psndoc.ds = '0' ");
	      wherePart = String.format(" and bd_psndoc.activestate = '%s'", new Object[] { Integer.valueOf(ActiveStateEnum.ACTIVE.intValue()) });
		  wherePartBuilder2.append(wherePart);
		  if (StringUtils.isNotEmpty(bdModeWherePart)) {
			 wherePartBuilder2.append(String.format(" AND %s ", new Object[] { bdModeWherePart }));
		  }
	
//		    if (StringUtils.isNotEmpty(wp)) {
//		      wherePartBuilder2.append(" AND ");
//		      wherePartBuilder2.append(wp);
//		    }
		  if ((wherePartList != null) && (wherePartList.size() > 0)) {
		      for (String wpart : wherePartList) {
		    	  wherePartBuilder2.append(" AND ");
		        wherePartBuilder2.append(wpart);
		      }
		    }
		    wherePartBuilder.append(" and not exists (");
		    wherePartBuilder.append(wherePartBuilder2.toString());
		    wherePartBuilder.append(")");
	    }

	    if (StringUtils.isNotBlank(wgId)) {
	      FDate nowDate = new FDate();
	      wherePart = String.format(" and bd_psndoc.id_psndoc in (select id_emp from bd_emp_wg wg where wg.id_wg = '%s' AND wg.d_b <= '%s' AND isnull(wg.d_e,'2100-01-01' ) >= '%s')", new Object[] { wgId, nowDate, nowDate });

	      wherePartBuilder.append(wherePart);
	    }

	    return wherePartBuilder.toString();
	  }
}
