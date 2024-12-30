package iih.sc.apt.s.bp.op.qry;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.queben.d.QueBenDO;
import iih.bd.fc.queben.i.IQuebenRService;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.ScSqlUtils;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 查询预约门诊排班科室BP
 * 
 * @author zhengcm
 * @created by renying
 */
public class GetOpSchDeptBP {

	/**
	 * 查询预约门诊排班科室
	 *
	 * @param benId 分诊台id
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public DeptDO[] exec(String benId) throws BizException {
		List<String> deptIdList = this.getOpPlanDept();
		if (ListUtil.isEmpty(deptIdList)) {
			return null;
		}
		String cond = "fg_op = 'Y' and activestate = 2 and " + ScSqlUtils.getInSqlByIds("id_dep", deptIdList);
		if (!StringUtil.isEmptyWithTrim(benId)) {
			// 分诊台管理科室过滤
			List<String> ids = this.getBenDept(benId);
			if (ListUtil.isEmpty(ids)) {
				cond = cond + " and 1 = 2 ";
			} else {
				cond = cond + " and " + ScSqlUtils.getInSqlByIds("id_dep", ids);
			}
		}
		IDeptRService deptService = ServiceFinder.find(IDeptRService.class);
		return deptService.find(cond, null, FBoolean.FALSE);
	}

	/**
	 * 查询排班计划的科室
	 *
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private List<String> getOpPlanDept() throws BizException {
		String cond = String.format("fg_active = 'Y' and sd_sctp = '%s'", IScDictCodeConst.SD_SCTP_OP);
		ScPlanDO[] planDOs = new OralAptEP().getScPlanByCond(cond, null);
		if (ArrayUtil.isEmpty(planDOs)) {
			return null;
		}
		List<String> deptIdList = new ArrayList<String>();
		for (ScPlanDO planDO : planDOs) {
			if (!deptIdList.contains(planDO.getId_dep())) {
				deptIdList.add(planDO.getId_dep());
			}
		}
		return deptIdList;
	}

	/**
	 * 获取分诊台管理的科室
	 *
	 * @param benId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private List<String> getBenDept(String benId) throws BizException {
		IQuebenRService qryService = ServiceFinder.find(IQuebenRService.class);
		QueBenDO benDO = qryService.findById(benId);
		if (null == benDO) {
			return null;
		}
		String deptIds = benDO.getIds_dep_use();
		if (StringUtil.isEmptyWithTrim(deptIds)) {
			return null;
		}
		List<String> idList = new ArrayList<String>();
		String[] deptArr = deptIds.split(",");
		for (String deptId : deptArr) {
			idList.add(deptId);
		}
		return idList;
	}
}
