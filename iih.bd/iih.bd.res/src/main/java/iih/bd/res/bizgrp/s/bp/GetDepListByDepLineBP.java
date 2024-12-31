package iih.bd.res.bizgrp.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.deptl.d.BizLineDO;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 根据业务线获取科室或病区///直接从en域拿来用的
 * 
 * @author renying
 */
public class GetDepListByDepLineBP {
	/**
	 * 根据病区获取业务线对应的科室 或者根据科室获取对应的业务线病区
	 * 
	 * @param nurId 部门或病区Id
	 * @param role 是不是通过病区来获取科室
	 * @return
	 * @throws BizException
	 */
	public DeptDO[] exec(String depId, String deplrole) throws BizException {

		StringBuilder sb = new StringBuilder();
		sb.append("  select distinct depl_dep2.id_dep ");
		sb.append("  from bd_depl_dep depl_dep ");
		sb.append("  inner join bd_depl depl ");
		sb.append("  on depl_dep.id_depl = depl.id_depl ");
		sb.append("  and depl.sd_deptltp=? ");// '0106'
		sb.append("  inner join bd_depl_dep depl_dep2 ");
		sb.append("  on depl_dep2.id_depl = depl.id_depl ");
		sb.append("  and depl_dep2.sd_deplrole=? ");// 0100 --科室 0101 病区
		
		sb.append("  inner join bd_dep DEP ");//--0123543:过滤条件应该用部门的组织，用业务线的组织不准确
		sb.append("  on DEP.id_dep = depl_dep2.id_dep ");		
		String dep_org =EnvContextUtil.processEnvContext("", new BizLineDO(), "DEP");
		sb.append( " and ");
		sb.append( dep_org);
		
		sb.append("  where depl_dep.sd_deplrole =? ");// 0100 --科室 0101 病区
		sb.append("  and depl_dep.id_dep =? ");// '0001AA1000000003QO11'
		String sql =EnvContextUtil.processEnvContext("", new BizLineDO(), "depl");
		sb.append( " and ");
		sb.append( sql);
		SqlParam param = new SqlParam();
		param.addParam(IBdResDictCodeConst.SD_DEPLTP_DEPNUR);
		//EnvContextUtil.processEnvContext("", Dept, "depl");
		if (IBdResDictCodeConst.SD_DEPROlE_NUR.equals(deplrole)) { // 根据病区查科室
			param.addParam(IBdResDictCodeConst.SD_DEPROLE_DEP);
			param.addParam(IBdResDictCodeConst.SD_DEPROlE_NUR);
		} else if (IBdResDictCodeConst.SD_DEPROLE_DEP.equals(deplrole)) { // 根据科室查病区
			param.addParam(IBdResDictCodeConst.SD_DEPROlE_NUR);
			param.addParam(IBdResDictCodeConst.SD_DEPROLE_DEP);
		}
		param.addParam(depId);
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(sb.toString(), param, new ColumnListHandler());
		IDeptRService ideptService = ServiceFinder.find(IDeptRService.class);
		DeptDO[] deptDOs = ideptService.findByIds(list.toArray(new String[0]), FBoolean.FALSE);
		if (ListUtil.isEmpty(list)) {
			return null;
		}

		return deptDOs;
	}
}
