package iih.ci.mb.bp;

import java.util.List;

import iih.bd.base.validator.ParamValidator;
import iih.bd.utils.BdEnvContextUtil;
import iih.ci.mb.i.ArrayOfDCUser;
import iih.ci.mb.i.DCUser;
import iih.ci.mb.i.GetDoctorOfDepartmentResponse;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取科室医生列表
 * @author yankan
 * @since 2018-03-12
 *
 */
public class GetDeptDoctorsBP {
	/**
	 * 获取科室医生列表
	 * @param deptId 科室ID
	 * @return 医生信息集合
	 * @throws BizException
	 * @author yankan
	 */
	public GetDoctorOfDepartmentResponse exec(String deptId) throws BizException{
		//参数校验
		ParamValidator.validateNotNull("科室ID", deptId);
		
		//1、查询医生信息
		DCUser[] users = this.getDeptDoctorList(deptId);
		
		//2、包装返回结果
		ArrayOfDCUser dcUserArray = new ArrayOfDCUser();
		dcUserArray.setDCUser(users);
		GetDoctorOfDepartmentResponse response = new GetDoctorOfDepartmentResponse();
		response.setGetDoctorOfDepartmentResult(dcUserArray);
		return response;		
	}
	/**
	 * 获取科室医生集合
	 * @param deptId 科室ID
	 * @return
	 * @throws BizException
	 */
	private DCUser[] getDeptDoctorList(String deptId) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT PSN.ID_PSNDOC AS ID,PSN.NAME,SEX.NAME AS SEX,");
		sqlBuilder.append("NULL AS NATION,1 AS USERROLE,SUSER.CODE AS USERNAME,");
		sqlBuilder.append("PSN.ID_EMPTITLE,TITLE.NAME AS TITLE");
		sqlBuilder.append(" FROM BD_PSNDOC PSN ");
		sqlBuilder.append(" LEFT JOIN SYS_USER SUSER ON SUSER.ID_PSN=PSN.ID_PSNDOC");
		sqlBuilder.append(" LEFT JOIN BD_EMP_PHY PHY ON PSN.ID_PSNDOC=PHY.ID_PSNDOC");
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC TITLE ON PSN.ID_EMPTITLE=TITLE.ID_UDIDOC");
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC SEX ON SEX.ID_UDIDOC=PSN.SEX");
		sqlBuilder.append(" WHERE PSN.ID_DEP=?");
		sqlBuilder.append(" AND "+BdEnvContextUtil.processEnvContext(new PsnDocDO(), "PSN"));// 增加多组织)
		sqlBuilder.append(" ORDER BY PSN.ID_PSNDOC");
		
		SqlParam param = new SqlParam();
		param.addParam(deptId);
		
		List<DCUser> userList = (List<DCUser>) new DAFacade().execQuery(sqlBuilder.toString(), param, new BeanListHandler(DCUser.class));
		if(!ListUtil.isEmpty(userList)){
			return userList.toArray(new DCUser[0]);
		}
		return null;
	}
}
