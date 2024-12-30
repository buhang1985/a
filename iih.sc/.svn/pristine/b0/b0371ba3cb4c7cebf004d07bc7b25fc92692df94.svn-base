package iih.sc.scp.s.rule.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.d.desc.QueDODesc;
import iih.bd.fc.que.i.IQueCudService;
import iih.bd.fc.que.i.IQueRService;
import iih.sc.comm.ScCodeUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.scheduleres.i.IScheduleresRService;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.d.desc.ScPlanDODesc;
import iih.sc.scp.scplan.i.IScplanRService;

import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 生成队列(排班计划调用)
 * 
 * @author liubin
 *
 */
public class CreateQueBP {
	
	/**
	 * 生成队列
	 * 
	 * @author liubin
	 * 
	 * @param scPlanDo
	 * @throws BizException
	 */
	public void exec(ScPlanDO scPlanDo) throws BizException {
		if(!IScDictCodeConst.SD_SCTP_OP.equals(scPlanDo.getSd_sctp())
				&& !IScDictCodeConst.SD_SCTP_JZ.equals(scPlanDo.getSd_sctp())
				&& !IScDictCodeConst.SD_SCTP_MT.equals(scPlanDo.getSd_sctp()))
				return;
		this.validate(scPlanDo);
		//获取排班计划
		ScPlanDO[] scpls = this.getScPlanDOs(scPlanDo);
		//获取队列
		QueDO[] ques = this.getQues(scPlanDo);
		if(!ArrayUtil.isEmpty(scpls)){
			List<ScPlanDO> activeScPls = getActiveScpl(scpls);
			if(!ArrayUtil.isEmpty(ques)){
				//修改队列停用启用状态
				this.updateQues(ques, new FBoolean(activeScPls.size() > 0), activeScPls);
			}else{
				//新增排班
				if(activeScPls.size() > 0 ){
					this.insertQues(activeScPls.get(0));
				}
			}
		}else{
			//删除排班
			//把已经删除的排班计划对应的队列标示为停止
			if(!ArrayUtil.isEmpty(ques)){
				this.updateQues(ques, FBoolean.FALSE, null);
			}
		}
	}
	/**
	 * 验证数据
	 * 
	 * @author liubin
	 * 
	 * @param scPlanDo
	 * @throws BizException
	 */
	private void validate(ScPlanDO scPlanDo) throws BizException {
		if(ScValidator.isEmptyIgnoreBlank(scPlanDo.getId_dep()))
			throw new BizException("生成队列：科室不能为空！");
		if(ScValidator.isEmptyIgnoreBlank(scPlanDo.getId_scres()))
			throw new BizException("生成队列：排班资源不能为空！");
		if(ScValidator.isEmptyIgnoreBlank(scPlanDo.getId_scsrv()))
			throw new BizException("生成队列：排班服务不能为空！");
		if(ScValidator.isEmptyIgnoreBlank(scPlanDo.getId_queben()))
			throw new BizException("生成队列：分诊台不能为空！");
	}
	/**
	 * 获取排班计划
	 * 
	 * @param depId
	 * @param resId
	 * @param scTpCode
	 * @return
	 * @throws BizException
	 */
	private ScPlanDO[] getScPlanDOs(ScPlanDO scPlanDo) throws BizException {
		String whereStr = String.format("%s.ID_DEP = '%s' AND %s.ID_SCRES = '%s' AND %s.ID_QUEBEN = '%s'", 
				ScPlanDODesc.TABLE_ALIAS_NAME, scPlanDo.getId_dep(),
				ScPlanDODesc.TABLE_ALIAS_NAME, scPlanDo.getId_scres(),
				ScPlanDODesc.TABLE_ALIAS_NAME, scPlanDo.getId_queben());
		if(IScDictCodeConst.SD_SCTP_MT.equals(scPlanDo.getSd_sctp()))
			whereStr += String.format(" AND %s.ID_SCSRV = '%S' ", ScPlanDODesc.TABLE_ALIAS_NAME, scPlanDo.getId_scsrv());
		IScplanRService serv = ServiceFinder.find(IScplanRService.class);
		return serv.find(whereStr, null, FBoolean.FALSE);
	}
	/**
	 * 获取队列
	 * 
	 * @param depId -科室id
	 * @param resId -资源id
	 * @param srvId -服务id
	 * @param scTpCode
	 * @return
	 * @throws BizException
	 */
	private QueDO[] getQues(ScPlanDO scPlanDo) throws BizException {
		String whereStr = String.format("%s.ID_DEP = '%s' AND %s.ID_SCRES = '%s' AND %s.ID_QUEBEN = '%s' AND %s.SD_QUETP = '%s'", 
				QueDODesc.TABLE_ALIAS_NAME, scPlanDo.getId_dep(),
				QueDODesc.TABLE_ALIAS_NAME, scPlanDo.getId_scres(),
				QueDODesc.TABLE_ALIAS_NAME, scPlanDo.getId_queben(),
				QueDODesc.TABLE_ALIAS_NAME, this.getQueTpCode(scPlanDo.getSd_sctp()));
		if(IScDictCodeConst.SD_SCTP_MT.equals(scPlanDo.getSd_sctp()))
			whereStr += String.format(" AND %s.ID_SCSRV = '%S' ", QueDODesc.TABLE_ALIAS_NAME, scPlanDo.getId_scsrv());
		IQueRService serv = ServiceFinder.find(IQueRService.class);
		return serv.find(whereStr, null, FBoolean.FALSE);
	}
	/**
	 * 保存队列
	 * 
	 * @param ques
	 * @throws BizException
	 */
	private void saveQues(QueDO[] ques) throws BizException {
		IQueCudService serv = ServiceFinder.find(IQueCudService.class);
		serv.save(ques);
	}
	/**
	 * 修改队列状态
	 * @param ques
	 * @param active
	 */
	private void updateQues(QueDO[] ques, FBoolean active, List<ScPlanDO> activeScPls) throws BizException {
		if(FBoolean.FALSE.equals(active)){
			String endTime = this.getServerDateTime().toString();
			for(QueDO que : ques){
				if(active.equals(que.getFg_active()))
					continue;
				que.setStatus(DOStatus.UPDATED);
				que.setFg_active(active);
				que.setDt_endtime(endTime);
			}
		}else{
			for(QueDO que : ques){
				que.setStatus(DOStatus.UPDATED);
				que.setFg_active(active);
				que.setDt_endtime(null);
				if(activeScPls != null && !hasScSrv(que.getId_scsrv(), activeScPls))
					que.setId_scsrv(activeScPls.get(0).getId_scsrv());
			}
		}
		this.saveQues(ques);
	}
	/**
	 * 队列的排班服务是否在启用的排班服务之内
	 * 
	 * @author liubin
	 * 
	 * @param id_scsrv
	 * @param activeScPls
	 * @return
	 */
	private boolean hasScSrv(String id_scsrv, List<ScPlanDO> activeScPls){
		boolean res = false;
		if(StringUtil.isEmptyWithTrim(id_scsrv))
			return res;
		for(ScPlanDO activeScPl : activeScPls){
			if(id_scsrv.equals(activeScPl.getId_scsrv()))
				return true;
		}
		return res;
	}
	
	/**
	 * 新增队列
	 * 
	 * @param scpl
	 * @throws BizException
	 */
	private void insertQues(ScPlanDO scpl) throws BizException{
		IScheduleresRService serv = ServiceFinder.find(IScheduleresRService.class);
		ScheduleResDO res = serv.findById(scpl.getId_scres());
		IDeptRService depServ = ServiceFinder.find(IDeptRService.class);
		DeptDO dep = depServ.findById(scpl.getId_dep());
		IQueRService iqr = ServiceFinder.find(IQueRService.class);
		QueDO que = new QueDO();
		que.setStatus(DOStatus.NEW);
		que.setId_grp(scpl.getId_grp());//集团
		que.setId_org(scpl.getId_org());//组织
		que.setCode(ScCodeUtils.createQueCode());//编码
		if(IScDictCodeConst.SD_SCTP_MT.equals(scpl.getSd_sctp())){			
			que.setName(scpl.getName());
		}else{
			//为了防止 生成队列名称重复(不同科室的资源名称可以重复,但是队列名称不能重复)
			String queName = (dep.getShortname() != null? dep.getShortname() : dep.getName()) + res.getName();
			String whereiqr = "  name = '"+queName+"' and id_dep = '"+dep.getId_dep()+"'";
			QueDO[] queDo = iqr.find(whereiqr, null, FBoolean.FALSE);//传入查询条件如果如果得到的queDO的长度大于零,修改队列名称
			if(!ArrayUtil.isEmpty(queDo)){
				que.setName(res.getName_dept()+"_"+queName);
			}else{
				que.setName(queName);
			}
		}
		que.setDes(dep.getName()+res.getName() + "("+scpl.getName_queben()+")");
		que.setId_scres(scpl.getId_scres());//资源
		que.setId_dep(scpl.getId_dep());//科室
		que.setId_scsrv(scpl.getId_scsrv());//服务
		que.setId_quetp(this.getQueTpId(scpl.getSd_sctp()));//队列类型
		que.setSd_quetp(this.getQueTpCode(scpl.getSd_sctp()));//队列类型编码
		que.setFg_active(FBoolean.TRUE);//启用
		que.setRatio_first(1);//初诊比例
		que.setRatio_rtn(1);//回诊比例
		que.setPycode(res.getPycode());//拼音
		que.setWbcode(res.getWbcode());//五笔
		que.setMnecode(res.getMnecode());//助记码
		que.setId_queben(scpl.getId_queben());//分诊台队列
		que.setName_queben(scpl.getName_queben());
		que.setCode_queben(scpl.getCode_queben());
		if (IScDictCodeConst.SD_SCRESTP_EMP.equals(res.getSd_screstp())) {
			que.setSd_mode(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
			que.setId_mode(IBdFcDictCodeConst.ID_MODEL_OP_EMP);
		} else {
			que.setSd_mode(IBdFcDictCodeConst.SD_MODEL_OP_TRIAGE);
			que.setId_mode(IBdFcDictCodeConst.ID_MODEL_OP_TRIAGE);
		}
		this.saveQues(new QueDO[]{ que });
	}
	/**
	 * 获取启用的排班计划
	 * 
	 * @param scpls
	 * @return
	 */
	private List<ScPlanDO> getActiveScpl(ScPlanDO[] scpls) {
		List<ScPlanDO> activeScPls = new LinkedList<>();
		if(!ArrayUtil.isEmpty(scpls)){
			for(ScPlanDO scpl : scpls){
				if(FBoolean.TRUE.equals(scpl.getFg_active()))
					activeScPls.add(scpl);
			}
		}
		return activeScPls;
	}
	
	/**
	 * 根据排班类型得到队列类型编码
	 * 
	 * @param scTp
	 * @return
	 */
	private String getQueTpCode(String scTp){
		if(IScDictCodeConst.SD_SCTP_OP.equals(scTp)
				|| IScDictCodeConst.SD_SCTP_JZ.equals(scTp)) {
			return IBdFcDictCodeConst.SD_QUETP_EMP;
		}
		else {
			return IBdFcDictCodeConst.SD_QUETP_MT;
		}
	}
	/**
	 * 根据排班类型得到队列类型ID
	 * 
	 * @param scTp
	 * @return
	 */
	private String getQueTpId(String scTp){
		if(IScDictCodeConst.SD_SCTP_OP.equals(scTp)
				|| IScDictCodeConst.SD_SCTP_JZ.equals(scTp)) {
			return IBdFcDictCodeConst.ID_QUETP_EMP;
		}
		else {
			return IBdFcDictCodeConst.ID_QUETP_MT;
		}
	}
	/***
	 * 获得服务器日期时间
	 * @return
	 */
	private FDateTime getServerDateTime(){
		TimeService ts = ServiceFinder.find(TimeService.class);
		return  ts.getUFDateTime();
	}
	
}
