package iih.sc.att.s.bp;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.sc.apt.dto.d.EuAptStatus;
import iih.sc.att.dto.d.AttExecDTO;
import iih.sc.att.s.bp.qry.GetDaysLotDOListQry;
import iih.sc.att.s.bp.qry.GetScTaskPlDOListQry;
import iih.sc.att.s.bp.qry.GetScTaskPlEmpDOListQry;
import iih.sc.att.s.bp.qry.GetScTaskPlWeekDOListQry;
import iih.sc.att.s.bp.qry.GetSctaskexecQry;
import iih.sc.att.sctaskexec.d.SctaskexecDO;
import iih.sc.att.sctaskexec.d.TaskstatusEum;
import iih.sc.att.sctaskexec.i.ISctaskexecCudService;
import iih.sc.att.sctaskexec.i.ISctaskexecRService;
import iih.sc.att.sctaskexecemp.d.ScTaskExecEmpDO;
import iih.sc.att.sctaskexecemp.i.ISctaskexecempCudService;
import iih.sc.att.sctaskexecemp.i.ISctaskexecempRService;
import iih.sc.att.sctaskpl.d.ScTaskPlDO;
import iih.sc.att.sctaskpl.i.ISctaskplRService;
import iih.sc.att.sctaskplemp.d.ScTaskPlEmpDO;
import iih.sc.att.sctaskplweek.d.ScTaskPlWeekDO;
import iih.sc.comm.ScContextUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.portal.pin.msg.Msg;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 生成考勤执行
 * 
 * @author yang.lu,renying
 * 
 */
public class GenerateAttExecBP {
	/**
	 * 生成考勤执行
	 * 
	 * @param 考勤执行DTO
	 * @return 考勤执行DTO
	 * @throws BizException
	 */
	public String exec(AttExecDTO attExecDTO) throws BizException {

		StringBuffer msg = new StringBuffer();
		// 1.保存考勤执行
		SctaskexecDO[] sctaskexecDOs = SaveSctaskexecDO(attExecDTO, msg);
		if (sctaskexecDOs != null)
			// 2.保存考勤执行明细
			SavetempList(sctaskexecDOs, attExecDTO.getD_b().toDate(), attExecDTO.getD_e().toDate());
		// 3.返回考勤消息数据
		if (!StringUtil.isEmptyWithTrim(msg.toString()))
			return msg.toString() + "已存在，无法创建上述考勤执行！";
		return null;
	}

	/**
	 * 填充保存集合与删除集合并会添加消息的值
	 * 
	 * @param 考勤计划集合
	 * @param 考勤执行DTO
	 * @param 需要保存的集合
	 * @param 需要删除的集合
	 * @throws BizException
	 */
	private void SetSaveAndDelete(ScTaskPlDO[] sctakList, AttExecDTO attExecDTO, List<SctaskexecDO> saveList, List<ScTaskExecEmpDO> delList, StringBuffer msg) throws BizException {
		// 1.获取符合区间与计划的考勤执行，计划编号可以为空
		SctaskexecDO[] taskexecDo = GetIsHaveSctaskexecDO(attExecDTO.getId_period(), attExecDTO.getId_taskpl());
		// 2.循环考勤计划
		for (ScTaskPlDO sctakDO : sctakList) {
			// 3.获取是否在区间内有相关的考勤计划
			SctaskexecDO taskDo = isHaveTaskpexec(sctakDO.getId_taskpl(), taskexecDo);
			// 4.如果有并可以覆盖将计划与明细进行删除
			if (taskDo != null) {
				if (taskDo.getEu_task_status() != TaskstatusEum.WFB) {
					msg.append((StringUtil.isEmptyWithTrim(msg.toString()) ? "考勤执行：" : ",") + taskDo.getName() + "（已发布）；");
					continue;
				} else {
					if (attExecDTO.getFg_cover().booleanValue()) {
						taskDo.setStatus(DOStatus.DELETED);
						saveList.add(taskDo);
						delList.addAll(GetExecEmpDO(taskDo));
					} else {
						msg.append((StringUtil.isEmptyWithTrim(msg.toString()) ? "考勤执行：" : ",") + taskDo.getName() + "；");
						continue;
					}
				}
			}
			// 获取需要添加的考勤执行
			SctaskexecDO execDo = CreadtSctaskexecDO(sctakDO, attExecDTO.getId_period(), attExecDTO.getD_b(), attExecDTO.getD_e(), GetExecDoCode(sctakDO, attExecDTO.getName_period()),
					GetExecDoName(sctakDO, attExecDTO.getD_b().toDate()));
			saveList.add(execDo);
		}

	}

	/**
	 * 获取存在的考勤执行数据
	 * 
	 * @param 考勤计划编号
	 * @param 考勤执行集合
	 * @return 已有的考勤执行，如果没有返回 空
	 */
	private SctaskexecDO isHaveTaskpexec(String id_taskpl, SctaskexecDO[] taskDo) {
		for (SctaskexecDO sctaskexecDO : taskDo) {
			if (sctaskexecDO.getId_taskpl().equals(id_taskpl))
				return sctaskexecDO;
		}
		return null;
	}

	/**
	 * * 保存考勤执行
	 * 
	 * @param 考勤执行DTO
	 * @return 考勤执行数组
	 * @throws BizException
	 */
	private SctaskexecDO[] SaveSctaskexecDO(AttExecDTO attExecDTO, StringBuffer msg) throws BizException {
		// 1. 创建要保存的考勤计划集合 与靠删除的考勤明细集合，以及考勤计划集合
		List<SctaskexecDO> saveList = new ArrayList<SctaskexecDO>();
		List<ScTaskExecEmpDO> delList = new ArrayList<ScTaskExecEmpDO>();
		ScTaskPlDO[] sctakList = null;

		// 2.判断是否选择考勤计划，如果已选中计划则将考勤执行DTO部分属性填充到考勤执行中，赋值考勤计划数组中
		if (!StringUtil.isEmptyWithTrim(attExecDTO.getId_taskpl())) {
			// 2.1 创建考勤计划，用当前DTO 填充计划所需要的属性

			ISctaskplRService iSctaskplRService = ServiceFinder.find(ISctaskplRService.class);
			ScTaskPlDO taskPlDO = iSctaskplRService.findById(attExecDTO.getId_taskpl());
			if (taskPlDO.getFg_active() != 2) {
				throw new BizException("当前考勤计划：" + taskPlDO.getName() + "，已停用，请重新选择考勤计划！");
			}
			sctakList = new ScTaskPlDO[] { taskPlDO };

		} else {
			// 2.2 否则获取部门下的所有考勤计划，如果没有部门编号为空则获取全部考勤计划（启动的）
			sctakList = GetTaskPlListByDept(attExecDTO.getId_dept());
		}
		// 3、填充需要保存与需要删除的集合
		SetSaveAndDelete(sctakList, attExecDTO, saveList, delList, msg);

		// 4.获取考勤执行服务类
		ISctaskexecCudService execService = ServiceFinder.find(ISctaskexecCudService.class);
		// 5.判断删除集合中是否有值
		if (delList != null && delList.size() != 0) {
			ISctaskexecempCudService execEmpService = ServiceFinder.find(ISctaskexecempCudService.class);
			execEmpService.delete(delList.toArray(new ScTaskExecEmpDO[]{}));
		}
		if (saveList.size() != 0)
			// 6.保存考勤执行
			return execService.save(saveList.toArray(new SctaskexecDO[saveList.size()]));
		// 7.返回保存后的考勤执行数组
		return null;
	}

	/**
	 * 获取考勤执行下的考勤明细
	 * 
	 * @param 考勤执行DO
	 * @return
	 * @throws BizException
	 */
	private List<ScTaskExecEmpDO> GetExecEmpDO(SctaskexecDO taskDo) throws BizException {
		List<ScTaskExecEmpDO> empList = new ArrayList<ScTaskExecEmpDO>();
		ScTaskExecEmpDO[] empDOs = ServiceFinder.find(ISctaskexecempRService.class).findByAttrValString(ScTaskExecEmpDO.ID_TASKEXEC, taskDo.getId_taskexec());
		if (empDOs != null)
			for (ScTaskExecEmpDO scTaskExecEmpDO : empDOs) {
				empList.add(scTaskExecEmpDO);
			}
		return empList;
	}

	/**
	 * 获取部门下的考勤排班部门计划
	 * 
	 * @param 部门编号
	 * @return
	 * @throws BizException
	 */
	private ScTaskPlDO[] GetTaskPlListByDept(String id_dept) throws BizException {
		return (ScTaskPlDO[]) AppFwUtil.getDORstWithDao(new GetScTaskPlDOListQry(id_dept), ScTaskPlDO.class);
	}

	/**
	 * 获取是否有相同属性的排班信息
	 * 
	 * @param 考勤区间
	 * @param 考勤计划
	 * @return
	 * @throws BizException
	 */
	private SctaskexecDO[] GetIsHaveSctaskexecDO(String id_period, String id_taskpl) throws BizException {
		if (!StringUtil.isEmptyWithTrim(id_period)) {
			return (SctaskexecDO[]) AppFwUtil.getDORstWithDao(new GetSctaskexecQry(id_period, id_taskpl), SctaskexecDO.class);
		}
		return null;
	}

	/**
	 * 创建考勤执行及数据
	 * 
	 * @param 考勤执行DTO
	 * @param 考勤计划编号
	 * @param 考勤Code
	 * @param 考勤名称
	 * @return
	 */
	private SctaskexecDO CreadtSctaskexecDO(ScTaskPlDO taskPlDO, String id_period, FDate d_b, FDate d_e, String code, String name) {
		SctaskexecDO execDo = new SctaskexecDO();
		execDo.setId_grp(taskPlDO.getId_grp());
		execDo.setId_org(taskPlDO.getId_org());
		execDo.setId_dept(taskPlDO.getId_dep());
		execDo.setId_taskpl(taskPlDO.getId_taskpl());
		execDo.setCode(code);
		execDo.setName(name);
		execDo.setId_period(id_period);
		execDo.setD_b(d_b);
		execDo.setD_e(d_e);
		execDo.setStatus(DOStatus.NEW);
		execDo.setEu_task_status(TaskstatusEum.WFB);
		return execDo;
	}

	/**
	 * 获取考勤执行Code 部门编码+考勤计划编码Code+考勤期间
	 * 
	 * @param 考勤执行计划
	 * @param 考勤区间名称
	 * @return
	 */
	private String GetExecDoCode(ScTaskPlDO taskPlDO, String name_period) {
		return taskPlDO.getCode_dep() + taskPlDO.getCode() + name_period;
	}

	/**
	 * 设置考勤执行名称部门+计划+日期YYMMDD
	 * 
	 * @param 考勤执行计划
	 * @param 开始日期
	 * @return
	 */
	private String GetExecDoName(ScTaskPlDO taskPlDO, Date d_b) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return taskPlDO.getName_dep() + taskPlDO.getName() + format.format(d_b);
	}

	/**
	 * 创建考勤执行明细DO
	 * 
	 * @param 考勤周计划DO
	 * @param 考勤执行DO
	 * @param 考勤计划人员DO
	 * @param 执行日期
	 * @return
	 */
	private ScTaskExecEmpDO CreatExecEmpDO(ScTaskPlWeekDO plWeekDO, SctaskexecDO execDo, ScTaskPlEmpDO scTaskPlEmpDO, Date D_task) {
		ScTaskExecEmpDO empDo = new ScTaskExecEmpDO();
		empDo.setId_taskexec(execDo.getId_taskexec());
		empDo.setId_group(ScContextUtils.getGrpId());//当前集团
		empDo.setId_org(ScContextUtils.getOrgId());//当前组织
		empDo.setId_taskplemp(scTaskPlEmpDO.getId_taskplemp());
		empDo.setId_emp(scTaskPlEmpDO.getId_emp());
		empDo.setD_task(new FDate(D_task));
		empDo.setId_dateslot(plWeekDO.getId_dateslot());
		empDo.setId_taskplweek(plWeekDO.getId_taskplweek());
		empDo.setEu_tasktp_pl(plWeekDO.getEu_tasktp());
		empDo.setFg_finish(new FBoolean(false));
		empDo.setStatus(DOStatus.NEW);
		return empDo;
	}

	/**
	 * 保存考勤执行明细方法
	 * 
	 * @param 考勤执行集合
	 * @param 考勤区间开始时间
	 * @param 考勤区间结束时间
	 * @throws BizException
	 */
	private void SavetempList(SctaskexecDO[] sctaskexecDOs, Date d_s, Date d_e) throws BizException {
		// 1. 创建保存考勤执行明细集合
		List<ScTaskExecEmpDO> saveList = new ArrayList<ScTaskExecEmpDO>();
		// 2. 获取考勤执行中的考勤人员
		ScTaskPlEmpDO[] taskplempList = (ScTaskPlEmpDO[]) AppFwUtil.getDORstWithDao(new GetScTaskPlEmpDOListQry(sctaskexecDOs), ScTaskPlEmpDO.class);
		if(ArrayUtil.isEmpty(taskplempList)){
			throw new BizException("请添加考勤人员");
		}
		// 3. 获取所有考勤的周计划
		ScTaskPlWeekDO[] taskPlWeekDOs = (ScTaskPlWeekDO[]) AppFwUtil.getDORstWithDao(new GetScTaskPlWeekDOListQry(sctaskexecDOs), ScTaskPlWeekDO.class);
		if(ArrayUtil.isEmpty(taskPlWeekDOs)){
			throw new BizException("请添加考勤周计划");
		}
		// 4. 获取午别集合
		DaysLotDO[] daysLotDOs = (DaysLotDO[]) AppFwUtil.getDORstWithDao(new GetDaysLotDOListQry(sctaskexecDOs), DaysLotDO.class);
		// 5. 设置周计划键值集合
		Map<String, ScTaskPlWeekDO> weekMap = new HashMap<String, ScTaskPlWeekDO>();
		for (ScTaskPlWeekDO scTaskPlWeekDO : taskPlWeekDOs) {
			weekMap.put(scTaskPlWeekDO.getId_taskpl() + "_" + scTaskPlWeekDO.getId_dateslot() + "_" + scTaskPlWeekDO.getWeekno(), scTaskPlWeekDO);
		}
		// 6. 创建考勤执行键值集合
		Map<String, SctaskexecDO> sctaskexecMap = new HashMap<String, SctaskexecDO>();
		for (SctaskexecDO sctaskexecDO : sctaskexecDOs) {
			sctaskexecMap.put(sctaskexecDO.getId_taskpl(), sctaskexecDO);
		}
		
		
		// 7 创建日期对象
		Calendar ca = Calendar.getInstance();
		ca.setTime(d_s);

		// 9.循环全部考勤计划人员
		for (ScTaskPlEmpDO scTaskPlEmpDO : taskplempList) {
			// 8.循环日期区间
			while (!d_e.before(ca.getTime())) {
			// 如果考勤人员计划日期不在排班日期内

//				if (scTaskPlEmpDO.getD_b() != null && scTaskPlEmpDO.getD_b().after(new FDate(ca.getTime()))) {
//					// 日期累加
//					ca.add(Calendar.DATE, 1);
//					continue;
//				}
//				if ((scTaskPlEmpDO.getD_b() != null && scTaskPlEmpDO.getD_b().before(new FDate(ca.getTime())))
//						&& (scTaskPlEmpDO.getD_e() != null && scTaskPlEmpDO.getD_e().after(new FDate(ca.getTime())))) {
					// 10.循环考勤下午别
					for (DaysLotDO daysLotDO : daysLotDOs) {
						// 11.判断当前午别是否属于当前计划
						if (daysLotDO.getId_dayslotca() == scTaskPlEmpDO.getId_dateslotca()) {
							// 12. 获取日期星期编号
							int weekno = GetWeekNo(ca.get(Calendar.DAY_OF_WEEK));

							// 14. 得到周计划的键
							String weekKey = scTaskPlEmpDO.getId_taskpl() + "_" + daysLotDO.getId_dayslot() + "_" + weekno;
							// 15.判断是否有周计划与考勤执行数据
							if (weekMap.containsKey(weekKey) && sctaskexecMap.containsKey(scTaskPlEmpDO.getId_taskpl())) {
								// 16. 获取周计划与考勤执行并获取考勤明细添加到需要存储的集合中
								ScTaskPlWeekDO plWeekDO = weekMap.get(weekKey);
								SctaskexecDO execDo = sctaskexecMap.get(scTaskPlEmpDO.getId_taskpl());
								saveList.add(CreatExecEmpDO(plWeekDO, execDo, scTaskPlEmpDO, ca.getTime()));
							}
						}
					}
					
//				}
				ca.add(Calendar.DATE, 1);
			}

		}
		// 18. 获取服务类
		ISctaskexecempCudService empService = ServiceFinder.find(ISctaskexecempCudService.class);
		// 19. 保存明细数据
		empService.save(saveList.toArray(new ScTaskExecEmpDO[saveList.size()]));
	}

	private int GetWeekNo(int weekno) {
		weekno = weekno - 1;
		if (weekno == 0)
			return 7;
		if (weekno == -1)
			return 6;
		return weekno;
	}
}
