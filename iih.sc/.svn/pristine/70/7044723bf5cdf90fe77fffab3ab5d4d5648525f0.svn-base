package iih.sc.att.s.bp;

import iih.sc.att.sctaskexec.d.SctaskexecDO;
import iih.sc.att.sctaskexec.d.TaskstatusEum;
import iih.sc.att.sctaskexec.d.desc.SctaskexecDODesc;
import iih.sc.att.sctaskexec.i.ISctaskexecCudService;
import iih.sc.att.sctaskexec.i.ISctaskexecRService;
import iih.sc.att.sctaskexecemp.d.ScTaskExecEmpDO;
import iih.sc.att.sctaskexecemp.d.desc.ScTaskExecEmpDODesc;
import iih.sc.att.sctaskexecemp.i.ISctaskexecempCudService;
import iih.sc.att.sctaskexecemp.i.ISctaskexecempRService;
import iih.sc.att.sctaskpl.d.ScTaskPlDO;
import iih.sc.att.sctaskpl.d.desc.ScTaskPlDODesc;
import iih.sc.att.sctaskpl.i.ISctaskplRService;
import iih.sc.att.sctaskplemp.d.ScTaskPlEmpDO;
import iih.sc.att.sctaskplemp.i.ISctaskplempRService;
import iih.sc.att.sctaskplweek.d.ScTaskPlWeekDO;
import iih.sc.att.sctaskplweek.d.desc.ScTaskPlWeekDODesc;
import iih.sc.att.sctaskplweek.i.ISctaskplweekRService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 考勤排班
 * @author ccj
 *
 */
public class AddSctaskexeceBp {
	/**
	 * 考勤排班
	 * @param id_dep 部门id
	 * @param id_taskpl 计划id
	 * @param xdaysStrs  排班日期
	 * @param id_peri  区间id
	 * @param d_b  开始日期
	 * @param d_e  结束日期
	 * @param note  备注
	 * @return 返回已经发布了的考勤执行名称，不能删除
	 * @throws BizException
	 */
	public Map<String,Object> exec(String id_dep,String id_taskpl, String[] xdaysStrs, String id_peri,
		String d_b, String d_e, String note,String code,String name,FBoolean fBoolean)throws BizException{
			ISctaskplRService iSctaskplRService = ServiceFinder.find(ISctaskplRService.class);
			StringBuilder sb = new StringBuilder();
			Map map = null;
			SctaskexecDO sctaskexecDO = null;
			if(StringUtils.isEmpty(id_dep)){
				// 部门为null 排所有的班
				ScTaskPlDO[] plDOs; //计划dos
				plDOs = iSctaskplRService.find(ScTaskPlDODesc.TABLE_ALIAS_NAME+".fg_active = 2", "", FBoolean.TRUE);
				for (ScTaskPlDO scTaskPlDO2 : plDOs) {
					map = createEexcEmpByBmJh(scTaskPlDO2.getId_taskpl(),xdaysStrs,id_peri,d_b,d_e,note,code,name,fBoolean);
					if(map.containsKey("name")){
						sb.append(map.get("name"));
						sb.append("、");
					}
					if(map.containsKey("sctaskexecDO")){
						sctaskexecDO = (SctaskexecDO) map.get("sctaskexecDO");
					}
				}
			}else if(StringUtils.isEmpty(id_taskpl)){
				// 计划为null 生成一个部门下所有计划
				ScTaskPlDO[] plDOs = iSctaskplRService.find(ScTaskPlDODesc.TABLE_ALIAS_NAME+".fg_active = 2 and "+ScTaskPlDODesc.TABLE_ALIAS_NAME+".id_dep = '"+id_dep+"'", "", FBoolean.TRUE);
				for (ScTaskPlDO scTaskPlDO2 : plDOs) {
					map = createEexcEmpByBmJh(scTaskPlDO2.getId_taskpl(),xdaysStrs,id_peri,d_b,d_e,note,code,name,fBoolean);
					if(map.containsKey("name")){
						sb.append(map.get("name"));
						sb.append("、");
					}
					if(map.containsKey("sctaskexecDO")){
						sctaskexecDO = (SctaskexecDO) map.get("sctaskexecDO");
					}
				}
			}else{
				//生成一个计划排班
				map = createEexcEmpByBmJh(id_taskpl,xdaysStrs,id_peri,d_b,d_e,note,code,name,fBoolean);
				if(map.containsKey("name")){
					sb.append(map.get("name"));
					sb.append("、");
				}
				if(map.containsKey("sctaskexecDO")){
					sctaskexecDO = (SctaskexecDO) map.get("sctaskexecDO");
				}
			}
			String string = sb.toString();
			if(sb.lastIndexOf("、")>-1){
				// 只有一个已经发布的考勤执行
				string = sb.substring(0, sb.lastIndexOf("、"));
			}
			if(map != null){
				map.put("name", string);
				map.put("sctaskexecDO", sctaskexecDO);
			}
			return map;
	}
	
	/**
	 *  一个计划的排班
	 * @param scTaskPlDO 考勤计划do
	 * @param xdaysStrs 日期数组
	 * @param id_dep 排班部门ID
	 * @param id_peri 考勤区间ID
	 * @param d_b 区间开始日期
	 * @param d_e 区间结束日期
	 * @param note 备注
	 * @param code 考勤执行do
	 * @return map key: name 返回发布了不能删除的考勤执行名称； sctaskexecDO 放回新生成的考勤
	 * @throws BizException
	 */
	private  Map<String,Object> createEexcEmpByBmJh(String id_taskpl, String[] xdaysStrs, String id_peri,
			String d_b, String d_e, String note,String code,String name,FBoolean fBoolean) throws BizException{
			
			Map<String,Object> map = new HashMap<String,Object>();
			// 获取考勤周计划信息
			ISctaskplweekRService sctaskplweekRService = ServiceFinder.find(ISctaskplweekRService.class);
			ScTaskPlWeekDO[] plWeekDOs = sctaskplweekRService.find(ScTaskPlWeekDODesc.TABLE_ALIAS_NAME+".id_taskpl = '"+id_taskpl+"'", "", FBoolean.TRUE);
			// 获取计划下的所有人员信息
			ISctaskplempRService rService = ServiceFinder.find(ISctaskplempRService.class);
			ScTaskPlEmpDO[] empDOs = rService.find(ScTaskPlDODesc.TABLE_ALIAS_NAME+".id_taskpl = '"+id_taskpl+"'", "", FBoolean.TRUE);
			String execName = "";
			ScTaskPlDO scTaskPlDO = null;
			ISctaskplRService iSctaskplRService = ServiceFinder.find(ISctaskplRService.class);
			scTaskPlDO = iSctaskplRService.findById(id_taskpl);
			if(empDOs != null && empDOs.length>0){
				List<ScTaskExecEmpDO> taskExecEmpDOList = new ArrayList<ScTaskExecEmpDO>();
				ISctaskexecRService execRService = ServiceFinder.find(ISctaskexecRService.class);  //考勤执行查询服务
				SctaskexecDO[] execDOs = execRService.find(SctaskexecDODesc.TABLE_ALIAS_NAME+".id_taskpl = '"+id_taskpl+"' and "+SctaskexecDODesc.TABLE_ALIAS_NAME+".id_period='"+id_peri+"'", "", FBoolean.TRUE);
				// 计划在考勤区间已经有排班了  现在默认覆盖
				SctaskexecDO sctaskexecDO;
				if(execDOs != null && execDOs.length>0){
					// 存在已经排班的情况
					sctaskexecDO = execDOs[0];
					if(TaskstatusEum.WFB == sctaskexecDO.getEu_task_status() && fBoolean.booleanValue() ){
						//已经发布了 且是覆盖
						// 先删除考勤执行下面的考勤执行明细
						ISctaskexecempRService sctaskexecempRService = ServiceFinder.find(ISctaskexecempRService.class);
						ISctaskexecempCudService cudService = ServiceFinder.find(ISctaskexecempCudService.class);
						ScTaskExecEmpDO[] scTaskExecEmpDOs = sctaskexecempRService.find(ScTaskExecEmpDODesc.TABLE_ALIAS_NAME+".id_taskexec = '"+execDOs[0].getId_taskexec()+"'", "", FBoolean.TRUE);
						cudService.delete(scTaskExecEmpDOs);
						//删除考勤执行
						ISctaskexecCudService execCudService = ServiceFinder.find(ISctaskexecCudService.class);
						execCudService.delete(execDOs);
					}else{
						execName = sctaskexecDO.getName();
						map.put("name", execName);
						map.put("sctaskexecDO", sctaskexecDO);
						return map;
					}	
				}
				// 生成考勤执行表信息:考勤计划、考勤区间、开始日期、结束日期、状态、备注	
				 sctaskexecDO = createTaskExec(code,name,scTaskPlDO, id_peri, d_b, d_e, note);
				 map.put("sctaskexecDO", sctaskexecDO);
				 GetScTaskExecEmpListBP empListBP = new GetScTaskExecEmpListBP();
				 for (ScTaskPlEmpDO scTaskExecEmpDO : empDOs) {
					// 生成考勤执行明细DO数组
					List<ScTaskExecEmpDO> execEmpDOs =  empListBP.exec(plWeekDOs, xdaysStrs, scTaskExecEmpDO.getId_emp(),scTaskExecEmpDO.getId_taskplemp(),sctaskexecDO.getId_taskexec());
					if(execEmpDOs == null || execEmpDOs.size() == 0 ) continue;
					taskExecEmpDOList.addAll(execEmpDOs);
				 }
				 ScTaskExecEmpDO[] execEmpDOs = taskExecEmpDOList.toArray(new ScTaskExecEmpDO[taskExecEmpDOList.size()]);
				 ISctaskexecempCudService execEmpCudService = ServiceFinder.find(ISctaskexecempCudService.class);
				 execEmpCudService.save(execEmpDOs);
			}else{
				throw new BizException(scTaskPlDO.getName()+"计划不存在人员");
			}
			return map;
		}
	
	/**
	 * 创建一个考勤执行DO数据
	 * @param code 考勤编码
	 * @param name 考勤名称
	 * @param id_taskpl 考勤计划ID
	 * @param id_dep 部门ID
	 * @param id_taskperi 考勤区间ID
	 * @param d_b 开始日期
	 * @param d_e 结束日期
	 * @param note 备注
	 * @return
	 * @throws BizException
	 */
	private SctaskexecDO createTaskExec(String code, String name, ScTaskPlDO scTaskPlDO,String id_taskperi, String d_b, String d_e,String note) throws BizException {
		ISctaskexecCudService cudService = ServiceFinder.find(ISctaskexecCudService.class);
		SctaskexecDO execDo = new SctaskexecDO();
		execDo.setId_taskpl(scTaskPlDO.getId_taskpl());
		execDo.setId_dept(scTaskPlDO.getId_dep());
		execDo.setId_period(id_taskperi);
		execDo.setD_b(new FDate(d_b));
		execDo.setD_e(new FDate(d_e));
		execDo.setNote(note);
		execDo.setCode(code+scTaskPlDO.getCode());
		execDo.setName(name+scTaskPlDO.getName());
		execDo.setDs(0);
		execDo.setEu_task_status(TaskstatusEum.WFB); //执行生成初始化 使用状态为未发布
		execDo.setStatus(DOStatus.NEW);
		SctaskexecDO[] returnExecDOs = cudService.save(new SctaskexecDO[]{execDo});
		return returnExecDOs[0];
	}
	
}
