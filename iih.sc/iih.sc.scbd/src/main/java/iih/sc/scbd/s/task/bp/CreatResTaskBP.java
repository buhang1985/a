package iih.sc.scbd.s.task.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeTypeConst;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.i.ISchedulecaRService;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.scheduleres.i.IScheduleresCudService;
import iih.sc.scbd.scheduleres.i.IScheduleresRService;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 创建资源(对所有不存在资源的科室和人员创建资源)
 * 
 * @author libaoliang
 */
public class CreatResTaskBP {
	private static final String ORG_ID = "Id_org";
	/**
	 * 执行
	 * 
	 * @author libaoliang
	 * @throws BizException
	 */
	public void exec(Map<String, Object> map) throws BizException {
		String orgId = (String)map.get(ORG_ID);
		if(StringUtils.isBlank(orgId)){
			Logger.error("自动添加资源任务：任务部署未设置组织！");
			return;
		}
		Context.get().setOrgId(orgId);
		List<ScheduleResDO> insertResDoList = new ArrayList<ScheduleResDO>();// 后台任务需要添加的资源do
		List<String> resDepList = new ArrayList<String>();// 存放已存在的资源类型为 部门的资源的部门id
		List<String> resEmpList = new ArrayList<String>();// 存放已存在的资源类型为 人员的资源的部门id+人员id
		IScheduleresRService scheduleresRService = ServiceFinder.find(IScheduleresRService.class);
		String whereStr = " sd_sctp='" + IScDictCodeConst.SD_SCTP_OP + "' and sd_screstp='" + IScDictCodeConst.SD_SCRESTP_DEP + "' ";
		ScheduleResDO[] res_dep_dos = scheduleresRService.find(whereStr, "", FBoolean.FALSE);// 资源类型为部门已存在的所有资源
		for (int i = 0; res_dep_dos != null && i < res_dep_dos.length; i++)
			resDepList.add(res_dep_dos[i].getId_dep());
		whereStr = " sd_sctp='" + IScDictCodeConst.SD_SCTP_OP + "' and sd_screstp='" + IScDictCodeConst.SD_SCRESTP_EMP + "' ";
		ScheduleResDO[] res_emp_dos = scheduleresRService.find(whereStr, "", FBoolean.FALSE);// 资源类型为人员已存在的所有资源
		for (int i = 0; res_emp_dos != null && i < res_emp_dos.length; i++)
			resEmpList.add(res_emp_dos[i].getId_dep() + "_" + res_emp_dos[i].getId_emp());
		// 获取所有 类型为门诊的部门
		IDeptRService deptRService = ServiceFinder.find(IDeptRService.class);
		DeptDO[] deptDOs = deptRService.find("sd_depttp='" + IBdResDictCodeConst.SD_DEPTTP_CLINICAL + "' and fg_op='" + FBoolean.TRUE + "'", "", FBoolean.FALSE);
		// 获取排班类型
		IUdidocServiceExt udidocServiceExt = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] udidocDOs = udidocServiceExt.findByUdidoclistCode(IScDictCodeTypeConst.SD_SCHTYPE_TP);
		UdidocDO udidocDO = null;
		for (int i = 0; udidocDOs != null && i < udidocDOs.length; i++) {
			if (IScDictCodeConst.SD_SCTP_OP.equals(udidocDOs[i].getCode())) {
				udidocDO = udidocDOs[i];
				break;
			}
		}
		// 获取排班分类
		ISchedulecaRService schedulecaRService = ServiceFinder.find((ISchedulecaRService.class));
		ScheduleCADO[] scheCaDos = schedulecaRService.find("sd_sctp = '" + IScDictCodeConst.SD_SCTP_OP + "'", "", FBoolean.FALSE);
		// 获取排班资源类型
		UdidocDO[] scSchResTypeUdidocDOs = udidocServiceExt.findByUdidoclistCode(IScDictCodeTypeConst.SD_SCHRESTYPE_TP);
		UdidocDO scSchResType_DepUdidoc = null;// 部门
		UdidocDO scSchResType_EmpUdidoc = null;// 人员
		for (int i = 0; udidocDOs != null && i < udidocDOs.length; i++) {
			if (IScDictCodeConst.SD_SCRESTP_DEP.equals(udidocDOs[i].getCode())) {
				scSchResType_DepUdidoc = udidocDOs[i];
			} else if (IScDictCodeConst.SD_SCRESTP_EMP.equals(udidocDOs[i].getCode())) {
				scSchResType_EmpUdidoc = udidocDOs[i];
			}
		}
		IPsndocMDORService psndocRService = ServiceFinder.find(IPsndocMDORService.class);
		FArrayList depIdList = new FArrayList();// 存放所有部门id
		for (int i = 0; deptDOs != null && i < deptDOs.length; i++) {
			if (!resDepList.contains(deptDOs[i].getId_dep())) {// 不包括 资源类型为科室的部门，需要添加
				ScheduleResDO resDo = getDefaultResDo(udidocDO, scheCaDos, deptDOs[i].getId_dep());
				// 资源类型为 部门 时
				resDo.setName(deptDOs[i].getName());
				resDo.setCode(deptDOs[i].getCode());
				processPinYin_WuBi_MnCode(resDo);
				resDo.setId_screstp(scSchResType_EmpUdidoc.getId_udidoc());// 资源类型id
				resDo.setSd_screstp(IScDictCodeConst.SD_SCRESTP_DEP);// 资源类型编码
//				 resDo.setDes(deptDOs[i].getName() + "-后台任务添加！");
				insertResDoList.add(resDo);
			}
			depIdList.add(deptDOs[i].getId_dep());
		}
		PsnDocDO[] psnDocDOs = psndocRService.findByAttrValList("Id_dep", depIdList);
		for (int i = 0; psnDocDOs != null && i < psnDocDOs.length; i++) {
			if (!resEmpList.contains(psnDocDOs[i].getId_dep() + "_" + psnDocDOs[i].getId_psndoc())) {
				ScheduleResDO resDo = getDefaultResDo(udidocDO, scheCaDos, psnDocDOs[i].getId_dep());
				// 资源类型为 人员 时
				resDo.setName(psnDocDOs[i].getName());
				resDo.setCode(psnDocDOs[i].getCode());
				processPinYin_WuBi_MnCode(resDo);
				resDo.setId_screstp(scSchResType_EmpUdidoc.getId_udidoc());// 资源类型id
				resDo.setSd_screstp(IScDictCodeConst.SD_SCRESTP_EMP);// 资源类型编码
				resDo.setId_emp(psnDocDOs[i].getId_psndoc());// 对应人员
				// resDo.setDes(psnDocDOs[i].getName() + "-后台任务添加！");
				insertResDoList.add(resDo);
			}
		}
		IScheduleresCudService cudService = ServiceFinder.find(IScheduleresCudService.class);
		cudService.insert(insertResDoList.toArray(new ScheduleResDO[insertResDoList.size()]));
	}

	/**
	 * 获取一个新的默认的ScheduleResDO
	 * 
	 * @param udidocDO
	 *            排班类型
	 * @param scheCaDos
	 *            排班分类
	 * @param id_dep
	 *            部门id
	 * @return
	 */
	private ScheduleResDO getDefaultResDo(UdidocDO udidocDO, ScheduleCADO[] scheCaDos, String id_dep) {
		ScheduleResDO resDo = new ScheduleResDO();
		resDo.setId_grp(Context.get().getGroupId());
		resDo.setId_org(Context.get().getOrgId());
		resDo.setFg_active(FBoolean.TRUE);
		if (udidocDO != null) {
			// 排班类型
			resDo.setSd_sctp(udidocDO.getCode());
			resDo.setName_sctp(udidocDO.getName());
			resDo.setId_sctp(udidocDO.getId_udidoc());
			resDo.setCode_sctp(udidocDO.getCode());
		}
		// 排班分类
		if (scheCaDos != null && scheCaDos.length > 0) {
			resDo.setId_scca(scheCaDos[0].getId_scca());
		}
		// DeptDO deptDO = deptDOs[i];
		// resDo.setId_dep(deptDO.getId_dep());
		// resDo.setName_dept(deptDO.getName());
		// resDo.setCode_dept(deptDO.getCode());
		resDo.setId_dep(id_dep);
		// 必须设置状态。
		resDo.setStatus(DOStatus.NEW);
		return resDo;
	}

	/**
	 * 处理 拼音，五笔码，助记码
	 * 
	 * @param resDo
	 */
	private void processPinYin_WuBi_MnCode(ScheduleResDO resDo) {
		String py = CnToPy.getPyFirstCode(resDo.getName());
		String wb = CnToWB.getWBCode(resDo.getName());
		resDo.setWbcode(wb);
		resDo.setPycode(py);
		resDo.setMnecode(resDo.getCode());
	}
}
