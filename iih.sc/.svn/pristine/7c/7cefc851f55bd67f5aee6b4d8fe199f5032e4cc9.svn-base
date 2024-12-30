package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.res.empdep.d.EmpDepDO;
import iih.bd.res.empdep.i.IEmpdepRService;
import iih.en.pv.i.IEnOutQryService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 根据当前科室查询科室下所有病区的人员（护士），包括人员部门关系中符合的人员BP
 * 
 * @author zhengcm
 * @date 2016-09-09 14:25:57
 *
 */
public class GetPsnInCondBP {

	/**
	 * 根据当前科室查询科室下所有病区的人员（护士），包括人员部门关系中符合的人员
	 *
	 * @param id_dep 当前科室
	 * @return 人员（护士）的In查询条件
	 * @throws BizException
	 * @author zhengcm
	 */
	public String exec(String id_dep) throws BizException {
		// 1、检查参数
		ScValidator.validateParam("id_dep", id_dep);

		// 2、当前科室
		DeptDO deptDO = ServiceFinder.find(IDeptRService.class).findById(id_dep);

		// 3、当前科室的所有病区
		DeptDO[] wardDOs = this.getDeptAllWards(deptDO);
		if (ArrayUtil.isEmpty(wardDOs)) {
			throw new BizException(IScMsgConst.SC_SCH_ORAL_NO_WARD.replace("x", deptDO.getName()));
		}
		return null;
	}

	/**
	 * 查询当前科室的所有病区
	 *
	 * @param deptDO 当前科室DO
	 * @return 当前科室的所有病区DO
	 * @throws BizException
	 * @author zhengcm
	 */
	private DeptDO[] getDeptAllWards(DeptDO deptDO) throws BizException {
		// 调用就诊对外查询服务查询科室下的所有病区
		IEnOutQryService enQryService = ServiceFinder.find(IEnOutQryService.class);
		return enQryService
				.getDepListByDepl(deptDO.getId_dep(), IBdResDictCodeConst.SD_DEPROLE_DEP);
	}

	/**
	 * 获取当前科室所有病区的护士
	 *
	 * @param depDO 当前科室DO
	 * @return 当前科室所有病区的护士DO
	 * @throws BizException
	 * @author zhengcm
	 */
	private PsnDocDO[] getDeptAllWardsNurs(DeptDO[] wardDOs) throws BizException {
		// 获取人员表中当前科室所有病区的护士
		IPsndocMDORService psnQryService = ServiceFinder.find(IPsndocMDORService.class);
		String wherePart = this.getWherePart(wardDOs) + " and sd_empwktp = '"
				+ IBdResDictCodeConst.SD_PSN_EMPWKTP_NURS + "' and activestate = "
				+ IBdResDictCodeConst.SD_PSN_ACTIVESTATE_ENABLE;
		return psnQryService.find(wherePart, null, FBoolean.FALSE);
	}

	/**
	 * 获取科室员工关系表中的护士
	 *
	 * @param wardDOs 当前科室的所有病区
	 * @return 科室员工关系表中的护士
	 * @throws BizException
	 * @author zhengcm
	 */
	private PsnDocDO[] getEmpDepNurs(DeptDO[] wardDOs) throws BizException {
		PsnDocDO[] depPsnDOs = null;
		IEmpdepRService empQryService = ServiceFinder.find(IEmpdepRService.class);
		EmpDepDO[] empDOs = empQryService.find(this.getWherePart(wardDOs), null, FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(empDOs)) {
			List<String> psnIds = new ArrayList<String>();
			for (EmpDepDO empDO : empDOs) {
				psnIds.add(empDO.getId_emp());
			}
			String where = ScSqlUtils.getInSqlByIds("id_psndoc", psnIds) + " and sd_humantype = '"
					+ IBdResDictCodeConst.SD_PSN_HUMANTYPT_NURS + "' and activestate = "
					+ IBdResDictCodeConst.SD_PSN_ACTIVESTATE_ENABLE;
			IPsndocMDORService psnQryService = ServiceFinder.find(IPsndocMDORService.class);
			depPsnDOs = psnQryService.find(where, null, FBoolean.FALSE);
		}
		return depPsnDOs;
	}

	/**
	 * 根据病区DO拼装查询条件
	 *
	 * @param wardDOs 科室所有病区DO
	 * @return SQL查询条件
	 * @throws BizException
	 * @author zhengcm
	 */
	private String getWherePart(DeptDO[] wardDOs) throws BizException {
		List<String> deptList = new ArrayList<String>();
		for (DeptDO deptDO : wardDOs) {
			deptList.add(deptDO.getId_dep());
		}
		return ScSqlUtils.getInSqlByIds("id_dep", deptList);
	}

	/**
	 * 合并病区护士和科室人员关系中的护士
	 *
	 * @param psnDOs 病区护士
	 * @param depPsnDOs 科室人员关系中的护士
	 * @return 所有护士主键列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private List<String> mergeNurs(PsnDocDO[] psnDOs, PsnDocDO[] depPsnDOs) throws BizException {
		List<String> ids = new ArrayList<String>();
		if (!ArrayUtil.isEmpty(psnDOs)) {
			for (PsnDocDO psnDO : psnDOs) {
				if (!ids.contains(psnDO.getId_psndoc())) {
					ids.add(psnDO.getId_psndoc());
				}
			}
		}
		if (!ArrayUtil.isEmpty(depPsnDOs)) {
			for (PsnDocDO psnDO : depPsnDOs) {
				if (!ids.contains(psnDO.getId_psndoc())) {
					ids.add(psnDO.getId_psndoc());
				}
			}
		}
		return ids;
	}

}
