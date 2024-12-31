package iih.bd.fc.que.bp;

import java.util.LinkedList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.d.desc.QueDODesc;
import iih.bd.fc.que.i.IQueCudService;
import iih.bd.fc.que.i.IQueRService;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.scheduleres.i.IScheduleresRService;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.d.desc.ScPlanDODesc;
import iih.sc.scp.scplan.i.IScplanRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 生成队列(排班计划调用)
 * 
 * @author liubin
 *
 */
public class CreateQueueBP {
	/**
     * 生成队列(排班计划调用)
     * 
     * @param depId 科室ID
     * @param resId 资源ID
     * @param scTpCode 排班类型编码
     * @throws BizException
     */
	public void exec(String depId, String resId, String scTpCode) throws BizException {
		if(StringUtil.isEmptyWithTrim(depId))
			throw new BizException("生成队列：科室不能为空！");
		if(StringUtil.isEmptyWithTrim(resId))
			throw new BizException("生成队列：资源不能为空！");
		// 验证排班类型是否传值正确
		this.volidate(scTpCode);
		//获取排班计划
		ScPlanDO[] scpls = this.getScPlanDOs(depId, resId, scTpCode);
		//获取队列
		QueDO[] ques = this.getQues(depId, resId, scTpCode);

		if(!ArrayUtil.isEmpty(scpls)){
			List<ScPlanDO> activeScPls = getActiveScpl(scpls);
			if(!ArrayUtil.isEmpty(ques)){
				//修改排班
				//把已经停止排班计划对应的队列标示为停止
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
     * 生成队列(排班计划调用)
     * 
     * @param depId 科室ID
     * @param resId 资源ID
     * @param srvId 服务ID
     * @param scTpCode 排班类型编码
     * @throws BizException
     */
	public void exec2(String depId, String resId,String queBenId, String scTpCode) throws BizException {
		if(StringUtil.isEmptyWithTrim(depId))
			throw new BizException("生成队列：科室不能为空！");
		if(StringUtil.isEmptyWithTrim(resId))
			throw new BizException("生成队列：资源不能为空！");
		// 验证排班类型是否传值正确
		this.volidate(scTpCode);
		//获取排班计划
		ScPlanDO[] scpls = this.getScPlanDOsSrv(depId, resId,queBenId,scTpCode);
		//获取队列
		QueDO[] ques = this.getQuesSrv(depId, resId,queBenId, scTpCode);

		if(!ArrayUtil.isEmpty(scpls)){
			List<ScPlanDO> activeScPls = getActiveScpl(scpls);
			if(!ArrayUtil.isEmpty(ques)){
				//修改排班
				//把已经停止排班计划对应的队列标示为停止
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

		//获取需要停止的队列，fanlq-2018.02.07
		this.getStopQues(depId, resId);	
	}
	/***
	 * 获取需要停止的队列，fanlq-2018.02.07
	 * @author fanlq 
	 * @param depId 科室id
	 * @param resId 资源id
	 * @throws BizException
	 */
	private void getStopQues(String depId, String resId) throws BizException{
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT * ");
		builder.append(" FROM BD_QUE BD_QUE ");
		builder.append(" WHERE BD_QUE.ID_QUE NOT IN (");
		builder.append(" SELECT BQ.ID_QUE FROM BD_QUE BQ ");
		builder.append(" INNER JOIN SC_PL SCPL ON BQ.ID_DEP = SCPL.ID_DEP ");
		builder.append(" AND BQ.ID_SCRES = SCPL.ID_SCRES AND BQ.ID_QUEBEN = SCPL.ID_QUEBEN ");
		builder.append(" WHERE BQ.ID_DEP = ? ");
		builder.append(" AND BQ.ID_SCRES = ? ");
		builder.append(" AND SCPL.FG_ACTIVE = ? ");
		builder.append(" AND BQ.FG_ACTIVE = ? ) ");
		builder.append(" AND BD_QUE.ID_DEP = ? ");
		builder.append(" AND BD_QUE.ID_SCRES = ? ");
		builder.append(" AND BD_QUE.FG_ACTIVE = ? ");
		SqlParam param = new SqlParam();
		param.addParam(depId);
		param.addParam(resId);
		param.addParam(FBoolean.TRUE);
		param.addParam(FBoolean.TRUE);
		param.addParam(depId);
		param.addParam(resId);
		param.addParam(FBoolean.TRUE);
		@SuppressWarnings("unchecked")
		List<QueDO> dateList = (List<QueDO>) new DAFacade().execQuery(builder.toString(), param, new BeanListHandler(QueDO.class));
		if (ListUtil.isEmpty(dateList)) {
			return;
		}
		 this.updateQues(dateList.toArray(new QueDO[0]),FBoolean.FALSE, null);
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
	private ScPlanDO[] getScPlanDOs(String depId, String resId, String scTpCode) throws BizException {
		String whereStr = String.format("%s.ID_DEP = '%s' AND %s.ID_SCRES = '%s' ", 
				ScPlanDODesc.TABLE_ALIAS_NAME, depId,
				ScPlanDODesc.TABLE_ALIAS_NAME, resId);
		IScplanRService serv = ServiceFinder.find(IScplanRService.class);
		return serv.find(whereStr, null, FBoolean.FALSE);
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
	private ScPlanDO[] getScPlanDOsSrv(String depId, String resId,String queBenId, String scTpCode) throws BizException {
		String whereStr = String.format("%s.ID_DEP = '%s' AND %s.ID_SCRES = '%s' AND %s.ID_QUEBEN = '%s'", 
				ScPlanDODesc.TABLE_ALIAS_NAME, depId,
				ScPlanDODesc.TABLE_ALIAS_NAME, resId,
				ScPlanDODesc.TABLE_ALIAS_NAME, queBenId);
		IScplanRService serv = ServiceFinder.find(IScplanRService.class);
		return serv.find(whereStr, null, FBoolean.FALSE);
	}
	/**
	 * 获取队列
	 * 
	 * @param depId
	 * @param resId
	 * @param scTpCode
	 * @return
	 * @throws BizException
	 */
	private QueDO[] getQues(String depId, String resId, String scTpCode) throws BizException {
		String whereStr = String.format("%s.ID_DEP = '%s' AND %s.ID_SCRES = '%s' AND %s.SD_QUETP = '%s'", 
				QueDODesc.TABLE_ALIAS_NAME, depId,
				QueDODesc.TABLE_ALIAS_NAME, resId,
				QueDODesc.TABLE_ALIAS_NAME, this.getQueTpCode(scTpCode));
		IQueRService serv = ServiceFinder.find(IQueRService.class);
		return serv.find(whereStr, null, FBoolean.FALSE);
	}
	/**
	 * 获取队列 - fanlq
	 * 
	 * @param depId -科室id
	 * @param resId -资源id
	 * @param srvId -服务id
	 * @param scTpCode
	 * @return
	 * @throws BizException
	 */
	private QueDO[] getQuesSrv(String depId, String resId,String queBenId,String scTpCode) throws BizException {
		String whereStr = String.format("%s.ID_DEP = '%s' AND %s.ID_SCRES = '%s' AND %s.ID_QUEBEN = '%s' AND %s.SD_QUETP = '%s'", 
				QueDODesc.TABLE_ALIAS_NAME, depId,
				QueDODesc.TABLE_ALIAS_NAME, resId,
				QueDODesc.TABLE_ALIAS_NAME, queBenId,
				QueDODesc.TABLE_ALIAS_NAME, this.getQueTpCode(scTpCode));
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
				//保存分诊台，fanlq-add
				if(activeScPls != null && activeScPls.get(0).getId_queben() != null)
				{
					que.setId_queben(activeScPls.get(0).getId_queben());
					que.setName_queben(activeScPls.get(0).getName_queben());
					que.setCode_queben(activeScPls.get(0).getCode_queben());
				}
				if(!hasScSrv(que.getId_scsrv(), activeScPls))
					que.setId_scsrv(activeScPls.get(0).getId_scsrv());
			}
		}
		this.saveQues(ques);
	}
	
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
		QueDO que = new QueDO();
		que.setStatus(DOStatus.NEW);
		que.setId_grp(scpl.getId_grp());//集团
		que.setId_org(scpl.getId_org());//组织
		que.setCode(QueCodeUtils.getNewQueCode());//编码
		que.setName((dep.getShortname() != null? dep.getShortname() : dep.getName()) + res.getName());//名称-fanlq-update
		que.setDes(dep.getName()+res.getName() + "("+scpl.getName_queben()+")");//描述 -fanlq-update
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
		que.setId_queben(scpl.getId_queben());//分诊台队列，fanlq-add
		que.setName_queben(scpl.getName_queben());
		que.setCode_queben(scpl.getCode_queben());
		if (IScDictCodeConst.SD_SCRESTP_EMP.equals(res.getSd_screstp())|| IScDictCodeConst.SD_SCTP_MT.equals(scpl.getSd_sctp())) {
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
	/**
	 * 验证排班类型是否传值正确
	 * 
	 * @param scTp
	 * @throws BizException
	 */
	private void volidate(String scTp) throws BizException{
		if(IScDictCodeConst.SD_SCTP_OP.equals(scTp)
				|| IScDictCodeConst.SD_SCTP_JZ.equals(scTp)
				|| IScDictCodeConst.SD_SCTP_MT.equals(scTp)||IScDictCodeConst.SD_SCTP_OT.equals(scTp)) {
			return;
		}
		throw new BizException(String.format("生成队列：排班类型编码【%s】错误！", scTp));
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
