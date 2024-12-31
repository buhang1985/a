package iih.en.out.refs;

 import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.res.empdep.d.EmpDepDO;
import iih.bd.res.empdep.i.IEmpdepRService;
import iih.en.pv.i.IEnIpQryService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 根据业务线和科室员工关系查找人员
 * @author renying
 *
 */
public class PsnWithDeplAndDepRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{PsnDocDO.CODE,PsnDocDO.NAME,"dep_name"};
	}

	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{PsnDocDO.ID_PSNDOC,PsnDocDO.ID_DEP};
	}

	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[]{"编码","名称","部门名称"};
	}
	@Override
	public String[] getBlurFields() {
		return new String[]{"code", "name", "dep_name", "psn_pycode", "psn_wbcode", "psn_mnecode", "dep_pycode", "dep_wbcode", "dep_mnecode"};
	}
	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return PsnDocDO.ID_PSNDOC;
	}

	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return PsnDocDO.CODE;
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return PsnDocDO.NAME;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "deptpsn";
	}
	/**
	 * 查找科室对应的病区人员
	 * 1.病区所属人员
	 * 2，病区对应的科室人员关系人员
	 */
	public String getRefSql() {


		String depId = (String)getExtendAttributeValue("depId");	
		String deplrole = (String)getExtendAttributeValue("deplrole");
		DeptDO[] deptdos = null;
		String deptIds = null;
		StringBuilder sbSql = new StringBuilder();
		this.getSql(sbSql);	
		
		if(!StringUtil.isEmptyWithTrim(depId) && !StringUtil.isEmpty(deplrole) &&  IBdResDictCodeConst.SD_DEPROLE_DEP.equals(deplrole)){
			try {
				deptdos = this.getDeptByDeptl(depId, deplrole);
			} catch (BizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!ArrayUtil.isEmpty(deptdos)){
				 deptIds = this.getDeptIdString(deptdos);
			}
		}
		if(!StringUtil.isEmptyWithTrim(depId) && !StringUtil.isEmpty(deplrole) && IBdResDictCodeConst.SD_DEPROlE_NUR.equals(deplrole)){
			 deptIds = "'"+depId+"'";
		}
		
		if(!StringUtil.isEmpty(deptIds)){
			
			this.getDeptIdSql(deptIds, sbSql);
			
			try {
				this.getPsnDocByDeptRelation(sbSql,deptIds);
			} catch (BizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}			
	
		this.getOrgCondition(sbSql);		
		this.addwherePart(sbSql);
		this.addOrderPart(sbSql);		
		return sbSql.toString();
	}
	/**
	 * 
	 * @param sbSql
	 * @param depIdstr
	 * @return
	 * @throws BizException
	 */
	private void getPsnDocByDeptRelation(StringBuilder sbSql,String depIdstr) throws BizException{
		IEmpdepRService service = ServiceFinder.find(IEmpdepRService.class);
		EmpDepDO[] empDeps = service.find("id_dep in("+depIdstr+")","" , FBoolean.FALSE);
		if(ArrayUtil.isEmpty(empDeps)){
			return ;
		}
		List<String> psnList = new ArrayList<String>();
		for(EmpDepDO empDepdo:empDeps){
			psnList.add(empDepdo.getId_emp());			
		}
		String idStr = this.buildIdStr(psnList);
		sbSql.append(" or deptpsn.id_psndoc in (");
		sbSql.append(idStr);
	    sbSql.append(")");	
	}
	
	/**
	 * 加上科室条件
	 * @param str
	 * @param sbSql
	 */
	private void getDeptIdSql(String str,StringBuilder sbSql){
		if(StringUtil.isEmptyWithTrim(str))
			return;
		sbSql.append(" and deptpsn.id_dep in (");
		sbSql.append(str);
	    sbSql.append(")");		    	    	
	}
	
	/**
	 * 获取查询条件
	 * @param sbSql
	 */
	private void getSql(StringBuilder sbSql){
		sbSql.append(" select * from (select bd_psndoc.code code, bd_psndoc.name name,dep.name as dep_name,bd_psndoc.id_psndoc id_psndoc, dep.id_dep, dep.id_grp, dep.id_org,"
				+ " bd_psndoc.pycode as psn_pycode, bd_psndoc.wbcode as psn_wbcode, bd_psndoc.mnecode as psn_mnecode, "
				+ " dep.pycode as dep_pycode, dep.wbcode as dep_wbcode, dep.mnecode as dep_mnecode "
				+ " from bd_psndoc bd_psndoc "
				+" left join bd_dep dep on bd_psndoc.id_dep = dep.id_dep ");
		sbSql.append(" where bd_psndoc.activestate = '2' ) deptpsn ");
		sbSql.append(" where 1 = 1 ");
	}
	
	/**
	 * 获取管控条件
	 * @param sbSql
	 */
	private void getOrgCondition(StringBuilder sbSql){
		String grpPart = EnvContextUtil.processEnvContext(null, new DeptDO(), "deptpsn");
		sbSql.append(" and " + grpPart);
	}
	
	/**
	 * 增加查询条件
	 * @param sbSql
	 */
	private void addwherePart(StringBuilder sbSql){
		List<String> whereList = getWherePart();
		if (whereList.size() > 0) {
			for (String where : whereList) {
				sbSql.append(" and (").append(where).append(") ");
			}
		}
	}
	
	/**
	 * 增加排序条件
	 * @param sbSql
	 */
	private void addOrderPart(StringBuilder sbSql){
		List<String> orderList = getOrderPart();
		if (orderList.size() > 0) {
			sbSql.append(" order by ");
			for (int i = 0; i < orderList.size(); i++) {
				String order = (String) orderList.get(i);
				if (i == 0) {
					sbSql.append(order);
				} else {
					sbSql.append("," + order);
				}
			}
		}
	}
	
	/**
	 * 根据业务线查找科室
	 * @param depId
	 * @param deplrole
	 * @return
	 * @throws BizException
	 */
	private DeptDO[] getDeptByDeptl(String depId, String deplrole) throws BizException {
		IEnIpQryService ipRService = ServiceFinder.find(IEnIpQryService.class);
		return ipRService.getDepListByDepl(depId, deplrole);
	}
	/**
	 * 获取科室id
	 * @param deptdos
	 * @return
	 */
	private String getDeptIdString(DeptDO[] deptdos){
		List<String> list = new ArrayList<String>();
		for(DeptDO deptdo:deptdos){
			list.add(deptdo.getId_dep());
		}
		return  this.buildIdStr(list);
	}
	/**
	 * 生成id的查询串
	 * 
	 * @param idList id集合
	 * @return
	 */
	public  String buildIdStr(List<String> idList) {
		if (ListUtil.isEmpty(idList)) {
			return null;
		}

		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (String id : idList) {
			if (StringUtil.isEmpty(id)) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				builder.append(",");
			}
			builder.append(String.format("'%s'", id));
		}

		return builder.toString();
	}


}
