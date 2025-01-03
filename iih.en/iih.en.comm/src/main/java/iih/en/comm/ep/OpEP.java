package iih.en.comm.ep;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.outpatient.i.IOutpatientCudService;
import iih.en.pv.outpatient.i.IOutpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊
 * 
 * @author yank
 *
 */
public class OpEP {
	/**
	 * 通过主键得到OutpatientDO
	 * 
	 * @param entOpId
	 * @return
	 * @throws BizException
	 */
	public OutpatientDO getOutpatientById(String entOpId) throws BizException{
		if(EnValidator.isEmpty(entOpId)){
			return null;
		}
		return getOpRServ().findById(entOpId);
	}
	/**
	 * 根据就诊ID查询门诊DO
	 * 
	 * @param entId 就诊ID
	 * @return 门诊DO
	 * @throws BizException
	 * @author yank
	 */
	public OutpatientDO getOpByEntId(String entId) throws BizException {
		if (EnValidator.isEmpty(entId))
			return null;
		IOutpatientRService opRService = ServiceFinder.find(IOutpatientRService.class);
		OutpatientDO[] opDOs = opRService.findByAttrValString(OutpatientDO.ID_ENT, entId);
		if (!EnValidator.isEmpty(opDOs)) {
			return opDOs[0];
		} else {
			return null;
		}
	}
	
	/**
	 * 根据就诊ID查询门诊DO 不查关联字段
	 * 
	 * @param entId 就诊ID
	 * @return 门诊DO
	 * @throws BizException
	 * @author yank
	 */
	@SuppressWarnings("unchecked")
	public OutpatientDO getOpByEntIdWithOutRef(String entId) throws BizException {
		if (EnValidator.isEmpty(entId))
			return null;
		List<OutpatientDO> list = (List<OutpatientDO>) new DAFacade().findByAttrValString(OutpatientDO.class, OutpatientDO.ID_ENT, entId, null);
		if (!EnValidator.isEmpty(list)) {
			return list.get(0);
		} else {
			return null;
		}
	}
	/**
	 *  根据ID查询门诊DO
	 * 
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	public OutpatientDO getOpByAptId(String aptId) throws BizException{
		if (EnValidator.isEmpty(aptId))
			return null;
		IOutpatientRService opRService = ServiceFinder.find(IOutpatientRService.class);
		OutpatientDO[] opDOs = opRService.findByAttrValString(OutpatientDO.ID_SCHAPT, aptId);
		if (!EnValidator.isEmpty(opDOs)) {
			return opDOs[0];
		} else {
			return null;
		}
	}

	/**
	 * 根据就诊ID批量查询门诊DO
	 *
	 * @param entIds 就诊ID数组
	 * @return 门诊DO数组
	 * @throws BizException
	 * @author zhengcm
	 */
	public OutpatientDO[] getOpByEntIds(String[] entIds) throws BizException {
		if (EnValidator.isEmpty(entIds)) {
			return null;
		}
		IOutpatientRService opRService = ServiceFinder.find(IOutpatientRService.class);
		return opRService.findByAttrValStrings(OutpatientDO.ID_ENT, entIds);
	}
	/**
	 * 通过entId集合得到OutpatientDO
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public OutpatientDO[] getOutpatientsByDAFacade(String[] entIds) throws BizException{
		if(EnValidator.isEmpty(entIds)){
			return null;
		}
		List<OutpatientDO> list = (List<OutpatientDO>) new DAFacade().findByAttrValStrings(OutpatientDO.class, OutpatientDO.ID_ENT, entIds, null);
		if(!EnValidator.isEmpty(list))
			return list.toArray(new OutpatientDO[0]);
		return null;
	}
	/**
	 * 通过entId集合得到PatiVisitDO
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public PatiVisitDO[] getPatiVisitDOByDAFacade(String[] entIds) throws BizException{
		if(EnValidator.isEmpty(entIds)){
			return null;
		}
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().findByAttrValStrings(PatiVisitDO.class, PatiVisitDO.ID_ENT, entIds, null);
		if(!EnValidator.isEmpty(list))
			return list.toArray(new PatiVisitDO[0]);
		return null;
	}
	/**
	 * 更新至结算
	 * 
	 * @param entId 就诊ID
	 * @param cgId 结算ID
	 * @param fgCg 是否已结算，否则记账
	 * @throws BizException
	 */
	public void updateToSettled(String entId, String cgId, FBoolean fgCg) throws BizException {
		OutpatientDO opDO = this.getOpByEntIdWithOutRef(entId);
		if (opDO == null) {
			throw new BizException(IEnMsgConst.ERROR_OP_OPINFO_NOT_EXISTS);
		}
		opDO.setId_cg(cgId);// 记账主键
		opDO.setFg_cg(fgCg);// 已结算标识
		opDO.setStatus(DOStatus.UPDATED);
		this.save(opDO);
	}
	/**
	 * 更新门诊结算标志
	 * 
	 * @param entId
	 * @throws BizException
	 */
	public void updateOpFgCg(String entId, FBoolean fgcg) throws BizException{
		OutpatientDO opDO = this.getOpByEntIdWithOutRef(entId);
		if (opDO == null)
			return;
		opDO.setFg_cg(fgcg);// 已结算标识
		opDO.setStatus(DOStatus.UPDATED);
		this.save(opDO);
	}
	/**
	 * 更新门诊病情等级
	 * 
	 * @param entId 就诊id
	 * @param levelId 病情等级
	 * @param levelCode 病情等级编码
	 * @throws BizException
	 */
	public void updateOpDiseLevel(String entId, String levelId, String levelCode)
			throws BizException {
		// 1、根据就诊ID获取门诊DO对象
		OutpatientDO opDO = getOpByEntId(entId);
		if (opDO == null) {
			throw new BizException(IEnMsgConst.ERROR_OP_OPINFO_NOT_EXISTS);
		}

		// 2、更新就诊病情等级
		opDO.setId_level_dise(levelId);
		opDO.setSd_level_dise(levelCode);
		opDO.setStatus(DOStatus.UPDATED);
		save(opDO);
	}

	/**
	 * 更新初诊标志
	 * 
	 * @param entId 就诊ID
	 * @param fgFirst 是否初诊
	 * @throws BizException
	 * @author yank
	 */
	public void updateOpFirstFlag(String entId, FBoolean fgFirst) throws BizException {
		EnValidator.validateParam("就诊ID", entId);

		// 1、根据就诊ID获取门诊DO对象
		OpEP opEP = new OpEP();
		OutpatientDO opDO = opEP.getOpByEntId(entId);
		if (opDO == null) {
			throw new BizException(IEnMsgConst.ERROR_OP_OPINFO_NOT_EXISTS);
		}

		// 2、更新初诊标志
		if (fgFirst == null) {
			fgFirst = FBoolean.TRUE;// 默认初诊
		}
		opDO.setFg_first(fgFirst);
		opDO.setStatus(DOStatus.UPDATED);
		opEP.save(opDO);
	}
	
	/**
	 * 更新状态
	 * 
	 * @param entId 就诊ID
	 * @param fgFirst 是否初诊
	 * @throws BizException
	 * @author yank
	 */
	public void updateStatus(String entId,String sd_status) throws BizException {
		EnValidator.validateParam("就诊ID", entId);

		// 1、根据就诊ID获取门诊DO对象
		OpEP opEP = new OpEP();
		OutpatientDO opDO = opEP.getOpByEntId(entId);
		if (opDO == null) {
			throw new BizException(IEnMsgConst.ERROR_OP_OPINFO_NOT_EXISTS);
		}

		opDO.setSd_status(sd_status);
		opDO.setStatus(DOStatus.UPDATED);
		opEP.save(opDO);
	}
	/**
	 * 修改回诊标志
	 * 
	 * @param entId
	 * @param needRtn
	 * @return
	 * @throws BizException
	 */
	public OutpatientDO[] updateFGNeedRtn(String entId, FBoolean needRtn) throws BizException{
		EnValidator.validateParam("entId", entId);
		EnValidator.validateParam("needRtn", needRtn);
		OutpatientDO outpatient = this.getOutpatientById(entId);
		if(outpatient != null){
			outpatient.setStatus(DOStatus.UPDATED);
			outpatient.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
			outpatient.setFg_needrtn(needRtn);
			return this.save(new OutpatientDO[] { outpatient } );
		}
		return null;
	}
	/**
	 * 保存门诊信息
	 * 
	 * @param opDO 门诊DO
	 * @throws BizException
	 */
	public void save(OutpatientDO opDO) throws BizException {
		IOutpatientCudService opCudService = ServiceFinder.find(IOutpatientCudService.class);
		opCudService.save(new OutpatientDO[] { opDO });
	}
	/**
	 * 保存OutpatientDO
	 * 
	 * @param outpatients
	 * @return
	 * @throws BizException
	 */
	public OutpatientDO[] save(OutpatientDO[] outpatients) throws BizException{
		EnValidator.validateParam("outpatients", outpatients);
		return getOpCudServ().save(outpatients);
	}
	/**
	 * 保存PatiVisitDO
	 * 
	 * @param patiVisits
	 * @return
	 * @throws BizException
	 */
	public PatiVisitDO[] save(PatiVisitDO[] patiVisits) throws BizException{
		EnValidator.validateParam("patiVisits", patiVisits);
		return getpvCudServ().save(patiVisits);
	}
	/**
	 * 创建门诊DO对象 不传
	 * 
	 * @param regInfoDTO 挂号信息
	 * @return
	 * @throws BizException
	 */
	public OutpatientDO createOpDO(RegInfoDTO regInfoDTO) throws BizException {
		return createOpDO(regInfoDTO,null);
	}
	/**
	 * 创建门诊DO对象
	 * 
	 * @param regInfoDTO 挂号信息
	 * @param FDateTime  有效开始开始日期
	 * @return
	 * @throws BizException
	 */
	public OutpatientDO createOutpatientDO(RegInfoDTO regInfoDTO,FDateTime dt_b) throws BizException {
		return createOpDO(regInfoDTO,dt_b);
	}
	
	/**
	 * 创建门诊DO对象
	 * 
	 * @param regInfoDTO 挂号信息
	 * @return
	 * @throws BizException
	 */
	public OutpatientDO createOpDO(RegInfoDTO regInfoDTO,FDateTime dt_b) throws BizException {
		OutpatientDO opDO = new OutpatientDO();
		opDO.setStatus(DOStatus.NEW);
		opDO.setId_ent(regInfoDTO.getId_ent());// 就诊id
		opDO.setId_schapt(regInfoDTO.getId_apt());// 预约id
		RegResDTO resDTO = (RegResDTO) regInfoDTO.getRegresarray().get(0);

		//设置挂号有效期
		setValidTime(opDO, regInfoDTO,dt_b);
		
		IScBdOutQryService bdQryService = ServiceFinder.find(IScBdOutQryService.class);
		ScheduleSrvDO scSrvDO = bdQryService.getScSrvById(resDTO.getId_scsrv());
		if (null != scSrvDO) {
			opDO.setId_svrtp(scSrvDO.getId_srvtp());
			opDO.setSd_svrtp(scSrvDO.getSd_srvtp());
		}
		// opDO.setId_svrtp(resDTO.getId_srvtp());
		// opDO.setSd_svrtp(resDTO.getSd_srvtp()); // 医疗类型
		
		opDO.setId_emp_operator(regInfoDTO.getId_emp_entry());// 操作员;
		opDO.setId_schapt(regInfoDTO.getId_apt()); // 对应预约
		opDO.setId_sch(resDTO.getId_sch()); // 排班id
		opDO.setId_scres(resDTO.getId_scres()); // 排班资源
		opDO.setId_scsrv(resDTO.getId_scsrv()); // 排班服务
		opDO.setId_dateslot(resDTO.getId_dayslot()); // 日期分组
		opDO.setId_ticks(regInfoDTO.getId_ticks()); // 号段id
		opDO.setId_tick(regInfoDTO.getId_tick());// 号位
		opDO.setId_dep_reg(resDTO.getId_dep()); // 挂号科室
		opDO.setId_emp_reg(resDTO.getId_emp()); // 挂号医生
		opDO.setFg_needrtn(FBoolean.FALSE);// 回诊标志
		opDO.setEu_regtp(regInfoDTO.getEu_regtp()); // 门诊挂号类型
		opDO.setTicketno(regInfoDTO.getTickno()); // 就诊排队号
		opDO.setId_cg(regInfoDTO.getId_cg());
		opDO.setTimes_op(this.getMaxTimesOp(regInfoDTO.getId_pat())); // 就诊次数
		if (regInfoDTO.getIs_referral() != null) {
			opDO.setFg_first(regInfoDTO.getIs_referral().booleanValue() ? FBoolean.FALSE
					: FBoolean.TRUE); // 复诊
		} else {
			opDO.setFg_first(FBoolean.TRUE);
		}
		opDO.setSd_status(!EnValidator.isEmpty(regInfoDTO.getSd_status())? regInfoDTO.getSd_status():  IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER); // 就诊状态为挂号
		//如果就诊类型为急诊，设置预检状态为已预检
		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(regInfoDTO.getCode_entp())){
			opDO.setEu_preobs("2");
		}
		return opDO;
	}
	
	
	
	
	/**
	 * 设置挂号有效时间
	 * 1. 开始时间：挂号时间在午别开始前，就诊的开始时间按午别开始时间计算；挂号时间在午别开始时间后， 就诊的开始时间按按挂号时间记录
	 * 2. 结束时间：取(开始时间+有效期)(午别结束时间)最大值
	 * 
	 * @param regInfoDTO 日期分组
	 * @return
	 * @throws BizException
	 */
	private void setValidTime(OutpatientDO opDO, RegInfoDTO regInfoDTO,FDateTime Dt_valid_b) throws BizException {
		int hours = 0;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(regInfoDTO.getCode_entp())) {
			// 急诊
			hours = EnParamUtils.getEmgValidHours();
			if(hours <= 0)
				throw new BizException("急诊挂号有效期[ENER0080]配置错误！");
		} else {
			// 门诊
			if(regInfoDTO.getRegresarray() != null&& regInfoDTO.getRegresarray().size() > 0){
				RegResDTO[] regResDTOs = (RegResDTO[])regInfoDTO.getRegresarray().toArray(new RegResDTO[]{});
				hours = EnParamUtils.getOpValidHours(regResDTOs[0].getId_dep());
			}else{
				hours = EnParamUtils.getOpValidHours(null);
			}
			if(hours < 0)
				throw new BizException("门诊挂号有效期[ENOP0001]配置错误！");
		}
		//获取午别
		IDayslotMDORService serv = ServiceFinder.find(IDayslotMDORService.class);
		DaysLotDO daysLot = serv.findById(regInfoDTO.getId_dayslot());
		if(daysLot == null || daysLot.getTime_begin() == null || daysLot.getTime_end() == null)
			throw new BizException("日期分组配置错误！");
		//开始时间
		FDateTime validDtBegin = EnAppUtils.getFDateTime(regInfoDTO.getRegisted_date(), daysLot.getTime_begin());
		//结束时间_排班
		FDateTime validDtEndSch = EnAppUtils.getFDateTime(daysLot.getTime_begin().after(daysLot.getTime_end()) ? regInfoDTO.getRegisted_date().getDateAfter(1) : regInfoDTO.getRegisted_date(), daysLot.getTime_end());
		
		FDateTime currentTime = EnAppUtils.getServerDateTime();
		if(EnValidator.isEmpty(Dt_valid_b)){
			if(validDtBegin.before(currentTime)){
				validDtBegin = currentTime;
			}
		}else{
			validDtBegin = Dt_valid_b;
		}
		
		FDateTime endTime ;
		if(hours == 0){
			endTime = EnAppUtils.getFDateTime(validDtEndSch.getDate(), new FTime("23:59:59"));
		}else{
			endTime = validDtBegin.addSeconds(hours * 3600);
		}
		if(validDtEndSch.after(endTime)) 
			endTime = validDtEndSch;
		opDO.setDt_valid_b(validDtBegin); // 有效期限_开始
		opDO.setDt_valid_e(endTime); // 有效期限_结束
	}

	/**
	 * 获取最大就诊次数
	 * 
	 * @param patId 患者ID
	 * @return
	 * @throws BizException
	 * @author wjy
	 */
	public Integer getMaxTimesOp(String patId) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select max(op.times_op) timesop ");
		sql.append(" from en_ent_op op ");
		sql.append(" left join en_ent ent ");
		sql.append(" on op.id_ent = ent.id_ent ");
		sql.append(" where ent.id_pat = ? ");
		SqlParam param = new SqlParam();
        param.addParam(patId);

		DAFacade daf = new DAFacade();
		Integer timesop = 0;
		try {
			timesop = (Integer) daf.execQuery(sql.toString(),param, new ColumnHandler());
		} catch (DAException e) {
			e.printStackTrace();
		}
		Integer deftimesop = EnParamUtils.getDefTimesOp();
		if (timesop == null || timesop < deftimesop){
			if(deftimesop > 0)
				return deftimesop;
			timesop = 0;
		}
		return timesop + 1;
	}
	/**
	 * 获取OutpatientDO查询服务
	 * 
	 * @return
	 */
	public IOutpatientRService getOpRServ(){
		return ServiceFinder.find(IOutpatientRService.class);
	}
	/**
	 * 获取OutpatientDO增删改服务
	 * 
	 * @return
	 */
	public IOutpatientCudService getOpCudServ(){
		return ServiceFinder.find(IOutpatientCudService.class);
	}
	/**
	 * 获取PatiVisitDO增删改服务
	 * 
	 * @return
	 */
	public IPativisitCudService getpvCudServ(){
		return ServiceFinder.find(IPativisitCudService.class);
	}
}
