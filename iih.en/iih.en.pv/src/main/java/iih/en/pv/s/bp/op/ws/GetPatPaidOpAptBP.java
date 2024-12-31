package iih.en.pv.s.bp.op.ws;

import iih.bd.fc.que.i.IQueQryService;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import iih.bl.cg.i.IBlOpCgSelfExternalService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.appoint.s.bp.GetStOepInfoBP;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.OpPatAptDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.sch.sctick.d.EuAddTickMod;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @author 
 *
 */
public class GetPatPaidOpAptBP {
	/**
	 * 获取患者已付费的挂号记录
	 * 
	 * @param patCode 患者编码
	 * @param deptCode 科室编码
	 * @param doctorCode 医生编码
	 * @param regDate 挂号日期
	 * @param dayslotType 午别
	 * @param seqNo 顺序号
	 * @return
	 * @throws BizException
	 */
	public OpPatAptDTO exec(String patCode,String deptCode,String doctorCode,String regDate, String dayslotType,String seqNo) throws BizException{
		String entId = this.getEntId(patCode, deptCode, doctorCode, regDate, dayslotType, seqNo);
		if(EnValidator.isEmpty(entId)){
			Logger.info("未找到就诊记录！");
			return null;
		}
		OpPatAptDTO patApt = new OpPatAptDTO();
		patApt.setSeqNo(seqNo);
		patApt.setEntTime(regDate);
		//设置就诊信息
		this.setPvInfo(entId, patApt);
		//设置门诊信息
		this.setOpInfo(entId, patApt);
		return patApt;
	}
	/**
	 * 获取预约详细信息
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	public OpPatAptDTO exec(String aptId) throws BizException{
		//记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：GetPatPaidOpAptBP参数为:aptId:"+aptId);
		ScAptDO apt = this.getApt(aptId);
		if(apt == null){
			Logger.info("未找到预约记录！");
			return null;
		}
		OpPatAptDTO patApt = new OpPatAptDTO();
		//设置预约信息
		this.setAptInfo(patApt, apt);
		//设置门诊信息
		OutpatientDO op = this.setOpInfo2(aptId, patApt);
		if(op==null)
			return null;
		//设置就诊信息		
		this.setPvInfo(op.getId_ent(), patApt);
		this.setAddr(patApt, op.getId_sch());
		this.setBlance(patApt, apt.getId_pat());
		this.setAmt(patApt, op.getId_cg());
		this.setDaysLotValue(op.getId_dateslot(), patApt);
		this.setStInfo(patApt, op.getId_cg());
		return patApt;
	}
	/**
	 * 设置午别的值
	 * @param daysLotId
	 * @param patApt
	 * @throws BizException
	 */
	private void setDaysLotValue(String daysLotId,OpPatAptDTO patApt) throws BizException{
		if(EnValidator.isEmpty(daysLotId))
			return;
		DaysLotDO dayslot =this.getDaysLot(daysLotId);
		patApt.setDayslotName(dayslot.getName());
		patApt.setDayslottp(dayslot.getSd_dayslottp());
	}
	
	/**
	 * 获取就诊Id
	 * 
	 * @param patCode 患者编码
	 * @param deptCode 科室编码
	 * @param doctorCode 医生编码
	 * @param regDate 挂号日期
	 * @param dayslotType 午别
	 * @param seqNo 顺序号
	 * @return
	 * @throws BizException
	 */
	private String getEntId(String patCode,String deptCode,String doctorCode,String regDate, String dayslotType,String seqNo) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT EN_ENT_OP.ID_ENT ");
		sb.append("FROM SC_APT_EXCHL SC_APT_EXCHL ");
		sb.append("INNER JOIN SC_APT SC_APT ON SC_APT_EXCHL.ID_APT = SC_APT.ID_APT ");
		sb.append("INNER JOIN EN_ENT_OP EN_ENT_OP ON SC_APT.ID_APT = EN_ENT_OP.ID_SCHAPT ");
		sb.append("WHERE SC_APT_EXCHL.CODE_PAT = ? ");
		sb.append("AND SC_APT_EXCHL.CODE_DEP = ? ");
		sb.append("AND SC_APT_EXCHL.D_SC = ? ");
		sb.append("AND SC_APT_EXCHL.AMPM = ? ");
		sb.append("AND SC_APT.QUENO = ? ");
		String sql = sb.toString();
		SqlParam param = new SqlParam();
		param.addParam(patCode);
		param.addParam(deptCode);
		param.addParam(regDate);
		param.addParam(dayslotType);
		param.addParam(seqNo);
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(!EnValidator.isEmpty(list)){
			if(list.size() > 1)
				Logger.info("找到多个就诊记录！");
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 设置就诊信息
	 * 
	 * @param entId
	 * @param patApt
	 * @throws BizException 
	 */
	private void setPvInfo(String entId, OpPatAptDTO patApt) throws BizException{
		PvEP ep = new PvEP();
		PatiVisitDO pv = ep.getPvById(entId);
		if(pv == null) {
			Logger.info(IEnMsgConst.ERROR_OP_PVINFO_NOT_EXISTS);
			return;
		}
		patApt.setId_ent(entId);
		patApt.setEntpCode(pv.getCode_entp());
		patApt.setEntpName(pv.getName_entp());
		patApt.setPatCa(pv.getSd_patca());
		patApt.setPatCaName(pv.getName_patca());
		patApt.setPatCode(pv.getCode_pat());
		patApt.setPatName(pv.getName_pat());
		patApt.setSex(pv.getSd_sex_pat());
		patApt.setBirthday(pv.getDt_birth_pat()+"");
		patApt.setAge(AgeCalcUtil.getAge(pv.getDt_birth_pat()));
		//EnAgeCalcUtil.setDoAges(new OpPatAptDTO[]{patApt}, "id_ent", "Age");
		patApt.setDeptCode(pv.getSd_dep_phy());
		patApt.setDeptName(pv.getName_dep_phy());
		patApt.setHospitalCode(pv.getOrgcode());
		patApt.setHospitalName(pv.getName_org());
		patApt.setHpName(pv.getName_hp());
	}
	/**
	 * 设置预约信息
	 * 
	 * @param patApt
	 * @param apt
	 */
	private void setAptInfo(OpPatAptDTO patApt, ScAptDO apt){
		patApt.setId_apt(apt.getId_apt());
		if( ("-1").equals(apt.getSugest_exmint())){
			patApt.setDt_b("");
			patApt.setDt_e("");
			patApt.setSugest_time("");
		}else if(apt.getDt_b().before(EnAppUtils.getServerDateTime()) ){
			patApt.setDt_b(apt.getDt_b().getBeginDate().toLocalString());
			patApt.setDt_e(apt.getDt_b().getBeginDate().toLocalString());
			//patApt.setSugest_time("");
		}else {
			patApt.setDt_b(apt.getDt_b().toLocalString());
			patApt.setDt_e(apt.getDt_e().toLocalString());
			if(apt.getSugest_exmint()!=null){
				patApt.setSugest_time(apt.getDt_b().addSeconds(apt.getSugest_exmint() * (-60)).toLocalString());
			}
		}
		patApt.setAptOpr(apt.getName_emp_appt());
		patApt.setAptChl(apt.getName_scchl());
		patApt.setAddFg(EuAddTickMod.JH.equals(apt.getEu_add()) ? "true" : "false");
	}
	
	/**
	 * 设置门诊信息
	 * 
	 * @param entId
	 * @param patApt
	 * @throws BizException 
	 */
	private void setOpInfo(String entId, OpPatAptDTO patApt) throws BizException{
		OpEP ep = new OpEP();
		OutpatientDO op = ep.getOpByEntId(entId);
		if(op == null) {
			Logger.info(IEnMsgConst.ERROR_OP_OPINFO_NOT_EXISTS);
			return;
		}
		patApt.setTimes(op.getTimes_op());
		patApt.setDoctorCode(op.getScres_code());
		patApt.setDoctorName(op.getScres_name());
	}
	/**
	 * 设置门诊信息
	 * 
	 * @param entId
	 * @param patApt
	 * @throws BizException 
	 */
	private OutpatientDO setOpInfo2(String aptId, OpPatAptDTO patApt) throws BizException{
		OpEP ep = new OpEP();
		OutpatientDO op = ep.getOpByAptId(aptId);
		if(op == null) {
			Logger.info(IEnMsgConst.ERROR_OP_OPINFO_NOT_EXISTS);
			return null;
		}
		patApt.setTimes(op.getTimes_op());
		patApt.setTimesOp(op.getTimes_op());
		patApt.setDoctorCode(op.getScres_code());
		patApt.setDoctorName(op.getScres_name());
		patApt.setSrvCode(op.getScsrv_code());
		patApt.setSrvName(op.getScsrv_name());
		patApt.setResCode(op.getScres_code());
		patApt.setResName(op.getScres_name());
		patApt.setTicketNo(op.getTicketno());
		return op;
	}
	/**
	 * 获取预约记录
	 * 
	 * @param aptId
	 * @return
	 * @throws BizException 
	 */
	private ScAptDO getApt(String aptId) throws BizException{
		IScaptMDORService serv = ServiceFinder.find(IScaptMDORService.class);
		return serv.findById(aptId);
	}
	/**
	 * 设置就诊地址
	 * 
	 * @param schId
	 * @throws BizException 
	 */
	private void setAddr(OpPatAptDTO patApt, String schId) throws BizException{
		String sql = "SELECT SC_PL.* FROM SC_PL SC_PL INNER JOIN SC_SCH SC_SCH ON SC_PL.ID_SCPL = SC_SCH.ID_SCPL WHERE SC_SCH.ID_SCH = ? ";
		SqlParam param = new SqlParam();
        param.addParam(schId);
		List<ScPlanDO> list = (List<ScPlanDO>) new DAFacade().execQuery(sql,param, new BeanListHandler(ScPlanDO.class));
		if(EnValidator.isEmpty(list))
			return;
		IQueQryService serv = ServiceFinder.find(IQueQryService.class);
		String addr = serv.getOpBenAddr(list.get(0).getId_dep(), list.get(0).getId_scres(), list.get(0).getId_queben());
		if(!EnValidator.isEmpty(addr))
			patApt.setAddress(addr);
		    patApt.setEntAddr(addr);
	}
	/**
	 * 设置剩余预交金
	 * 
	 * @param patApt
	 * @param patId
	 * @throws BizException 
	 */
	private void setBlance(OpPatAptDTO patApt, String patId) throws BizException{
		IPatAccServiceExt patAccService = ServiceFinder.find(IPatAccServiceExt.class);		
		PatRelAmountInfoDTO patAccDTO = patAccService.GetPatRelAmountInfo(patId);
		if(patAccDTO!=null)
			patApt.setBalance(patAccDTO.getMoney_canuse().toDouble());//设置余额
	}
	/**
	 * 设置支付金额
	 * @param patApt
	 * @param cgId
	 * @throws BizException 
	 */
	private void setAmt(OpPatAptDTO patApt, String cgId) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append("BL_ST_OEP.AMT_RATIO AS AMT ");
		sb.append("FROM BL_CG_ITM_OEP BL_CG_ITM_OEP ");
		sb.append("INNER JOIN BL_ST_OEP BL_ST_OEP ON BL_CG_ITM_OEP.ID_STOEP = BL_ST_OEP.ID_STOEP ");
		sb.append("WHERE BL_CG_ITM_OEP.ID_CGOEP = ? ");
		SqlParam param = new SqlParam();
		param.addParam(cgId);
		double amtPat = ServiceFinder.find(IBlOpCgSelfExternalService.class).getPatAmtBycgId(cgId);
		List<OpPatAptDTO> list = (List<OpPatAptDTO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(OpPatAptDTO.class));
		if(!EnValidator.isEmpty(list)){
			patApt.setAmt(list.get(0).getAmt());
			patApt.setAmtPat((float)amtPat);
		}
	}
	/**
	 * 获取午别
	 * @param daysLotId
	 * @return
	 * @throws BizException
	 */
	private DaysLotDO getDaysLot(String daysLotId) throws BizException{
		IDayslotMDORService rService = ServiceFinder.find(IDayslotMDORService.class);
		DaysLotDO daysLot =  rService.findById(daysLotId);
		if(daysLot == null)
			throw new BizException("未获取到午别");
		return daysLot;
	}
	/**
	 * 设置结算信息
	 * 
	 * @param resultDto
	 * @param aptId
	 * @throws BizException
	 */
	private void setStInfo(OpPatAptDTO patApt, String cgId) throws BizException{
		GetStOepInfoBP bp = new GetStOepInfoBP();
		BlStOepDO st = bp.queryByCgId(cgId);
		if(st == null)
			return;
		patApt.setId_stoep(st.getId_stoep());
		patApt.setCode_st(st.getCode_st());
		patApt.setDt_st(st.getDt_st()==null? null : st.getDt_st().toString());
	}
	
}
