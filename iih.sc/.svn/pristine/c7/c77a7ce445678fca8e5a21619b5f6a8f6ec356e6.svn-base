package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取某个科室对应业务线病区
 * @author zhouliming
 */
public class GetDeplNurBp {
	/**
	 * 根据科室id获取其对应业务线病区
	 * @param id_dep 科室id
	 * @return list 病区结合
	 * @throws DAException
	 */
	public String exec(String id_dep) throws DAException{
		if(StringUtils.isBlank(id_dep)) return null;
		String sd_deptp = IBdResDictCodeConst.SD_DEPLTP_DEPNUR;//业务线类型
		String depRole = IBdResDictCodeConst.SD_DEPROLE_DEP;//科室角色
		String nurRole = IBdResDictCodeConst.SD_DEPROlE_NUR;//部门角色
		
		StringBuffer sb = new StringBuffer();
		sb.append("select n.id_dep ");
		sb.append(" from bd_depl_dep p ");
		sb.append(" inner join bd_depl depl ");
		sb.append("	on p.id_depl = depl.id_depl ");
		sb.append(" and depl.sd_deptltp = ? ");
		sb.append(" and depl.activestate = '2' ");
		sb.append(" inner join bd_depl_dep n ");
		sb.append("	on depl.id_depl = n.id_depl ");
		sb.append(" and n.sd_deplrole like ? ");
		sb.append(" where p.sd_deplrole like ? "); 
		sb.append(" and p.id_dep = ? ");
		
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(sd_deptp);
		sqlParam.addParam(nurRole+"%");
		sqlParam.addParam(depRole+"%");
		sqlParam.addParam(id_dep);
		
		List<String> list = (List<String>) new DAFacade().execQuery(sb.toString(),sqlParam,new ColumnListHandler());
		
		StringBuffer nurList = new StringBuffer();
		String depNurStr = "";
	  	if(list == null || list.size() == 0) return null;
	  	nurList.append("(");
	  	for(int i = 0; i < list.size(); i++){
	  		nurList.append("'");
	  		nurList.append(list.get(i));
	  		nurList.append("',");
	  	}
	  	depNurStr = nurList.substring(0,nurList.length()-1);
	  	depNurStr += ")";
		return depNurStr;
	}
}
