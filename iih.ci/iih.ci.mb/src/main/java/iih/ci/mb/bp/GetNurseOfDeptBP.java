package iih.ci.mb.bp;

import java.util.List;

import iih.bd.base.validator.ParamValidator;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.ci.mb.i.DCDepartment;
import iih.ci.mb.i.GetDepartmentCareLevelCountOfDeptResponse;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取病区科室
 * @author yankan
 * @since 2018-03-13
 *
 */
public class GetNurseOfDeptBP {
	/**
	 * 
	 * @param deptId
	 * @return
	 * @throws BizException
	 */
	public GetDepartmentCareLevelCountOfDeptResponse exec(String deptId) throws BizException{
		//参数校验
		ParamValidator.validateNotNull("科室ID", deptId);
		
		//获取病区科室
		DCDepartment dept = this.getNurseOrDept(deptId);		
		GetDepartmentCareLevelCountOfDeptResponse response = new GetDepartmentCareLevelCountOfDeptResponse();
		response.setGetDepartmentCareLevelCountOfDeptResult(dept);
		return response;
	}
	/**
	 * 获取病区科室
	 * @param deptId 科室或病区ID
	 * @return
	 * @throws BizException
	 */
	private DCDepartment getNurseOrDept(String deptId) throws BizException{
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT DISTINCT DEPT.ID_DEP AS ID,DEPT.CODE AS DEPTCODE,DEPT.NAME AS DEPTNAME "); 
		builder.append(" FROM BD_DEPL_DEP DEPL ");
		builder.append(" INNER JOIN BD_DEPL_DEP NUR_DEPL ON NUR_DEPL.ID_DEPL=DEPL.ID_DEPL ");
		builder.append("  AND (NUR_DEPL.SD_DEPLROLE=? AND DEPL.SD_DEPLROLE=?)");
		builder.append(" LEFT JOIN  BD_DEP DEPT ON DEPT.ID_DEP = DEPL.ID_DEP");
		builder.append(" WHERE DEPL.ID_DEP=?");
		
		SqlParam param = new SqlParam();
		param.addParam(IBdResDictCodeConst.SD_DEPROlE_NUR);//病区
		param.addParam(IBdResDictCodeConst.SD_DEPROLE_DEP);//科室
		param.addParam(deptId);
		
		List<DCDepartment> deptList = (List<DCDepartment>)new DAFacade().execQuery(builder.toString(),param,new BeanListHandler(DCDepartment.class));
		if(ListUtil.isEmpty(deptList)){
			return null;
		}else{
			//TODO 是否业务中规定，一个科室对应一个病区
			return deptList.get(0);
		}
		
	}
}
