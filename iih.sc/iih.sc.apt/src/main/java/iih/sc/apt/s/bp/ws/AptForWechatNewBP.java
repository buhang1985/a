package iih.sc.apt.s.bp.ws;
import iih.bd.fc.que.i.IQueQryService;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.sc.apt.dto.d.MakeAptDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.dto.d.RegResultDTO;
import iih.sc.apt.s.bp.AptOpBP;
import iih.sc.apt.scapt.d.AptExChlDO;
import iih.sc.apt.scapt.i.IAptexchlRService;
import iih.sc.apt.scapt.s.AptexchlCrudServiceImpl;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksRService;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class AptForWechatNewBP {
	
	/**
	 * 预约挂号（对微信接口）
	 * @param scsrvCode 服务编码
	 * @param doctorCode 医生编码
	 * @param requestDate 日期
	 * @param deptCode 科室编码
	 * @param dayslotType 午别编码，a或p
	 * @param chlType 渠道类型编码
	 * @param seqNo 渠道顺序号
	 * @param aptCode 预约码
	 * @param patCode 患者编码
	 * @param agentCode 挂号操作人编码
	 * @return true:预约成功;false:预约失败
	 * @author WJY
	 * @throws BizException 
	 */
	public RegResultDTO exec(MakeAptDTO makeAptDTO) throws BizException {
	//	String patCode, String aptCode, String chlType, String agentCode, String schId
		// 1.验证是否存在重复预约码
		this.volidateAptCode(makeAptDTO.getAptCode());
		
		// 2.调用PI接口查询患者， 如果患者不存在抛出异常。PI接口在本地找不到患者会对EMPI中的患者进行同步。
		IPiRegQryService serv = ServiceFinder.find(IPiRegQryService.class);
		PatiAggDO patiAggDo = serv.getPatInfoForAp(makeAptDTO.getPatCode());
		if(null == patiAggDo){
			Logger.error("IIH中未找到当前患者信息, 患者编码：" + makeAptDTO.getPatCode());
			throw new BizException("IIH中未找到当前患者信息！");
		}
		//未启用患者不能预约，0171393
		if(FBoolean.FALSE.equals(patiAggDo.getParentDO().getFg_active())){
			Logger.error("IIH中当前患者未启用, 患者编码：" + makeAptDTO.getPatCode());
			throw new BizException("IIH中当前患者未启用，不能预约！");
		}
		// 2. 获取渠道信息
		SchedulechlDO schedulechlDo = this.getScChlByTp(makeAptDTO.getChlType());
		if (schedulechlDo == null) {
			throw new BizException("获取渠道信息失败！");
		}
		
		// 3.获取可挂号资源的信息
		IScSchOutQryService schQryService = ServiceFinder.find(IScSchOutQryService.class);
		RegResDTO regResDTO = schQryService.getAptRes(makeAptDTO.getSchId(), FBoolean.TRUE, schedulechlDo.getId_scchl());
		if (regResDTO == null) {
			throw new BizException("未获取到排班资源！");
		}
		// 4.设置DTO
		OpAptDTO aptDto = this.SetOpAptDTO(regResDTO, patiAggDo,makeAptDTO,schedulechlDo);

		// 5. 预约
		AptOpBP aptOpBp = new AptOpBP();
		String aptId = aptOpBp.exec(aptDto, FBoolean.FALSE, FBoolean.FALSE, schedulechlDo.getId_scchl(), null);
		if (StringUtil.isEmpty(aptId)) {
			throw new BizException("登入预约信息失败！");
		}

		// 6. 保存入参信息
		AptExChlDO[] aptExChlDOs = this.saveScAptExchl(aptId, makeAptDTO, null, null, null, regResDTO.getD_sch(), null);
		if (aptExChlDOs == null) {
			throw new BizException("保存入参信息失败！");
		}
		// 7.获取挂号成功后相关信息
		RegResultDTO regRstTemp = this.getAptAfterReg(aptId, regResDTO, aptDto.getId_pat());
		if (regRstTemp == null) {
			throw new BizException("返回预约信息异常！");
		}
		return regRstTemp;
	}
	/**
	 * 设置DTO
	 * @param regResDTO
	 * @param patiAggDo
	 * @return
	 * @throws BizException 
	 */
	private OpAptDTO SetOpAptDTO(RegResDTO regResDTO,PatiAggDO patiAggDo,MakeAptDTO makeAptDTO,SchedulechlDO schedulechlDo) throws BizException{
		OpAptDTO aptDto = new OpAptDTO();
		FArrayList regResArr = new FArrayList();
		regResArr.add(regResDTO);
		aptDto.setRegresarray(regResArr); // 资源信息
		aptDto.setId_pat(patiAggDo.getParentDO().getId_pat()); // 患者ID
		if(StringUtils.isNullOrEmpty(makeAptDTO.getTickCode()) && StringUtils.isNullOrEmpty(makeAptDTO.getId_ticks())){
			return aptDto;
		}
		String tickID = this.getTickID(makeAptDTO,schedulechlDo);
		if(!StringUtil.isEmpty(tickID)){
			aptDto.setId_tick(tickID);
		}
		String ticksID = this.getTicksID(makeAptDTO);
		if(!StringUtil.isEmpty(ticksID)){
			aptDto.setId_ticks(ticksID);
		}
		return aptDto;
	}
	
	/**
	 * 根据渠道类型获取渠道信息
	 * @param chlType 渠道类型
	 * @return
	 * @throws BizException 
	 * @author WJY
	 */
	private SchedulechlDO getScChlByTp(String chlType) throws BizException{
		IScBdOutQryService bdQryService = ServiceFinder.find(IScBdOutQryService.class);
		SchedulechlDO[] chlDOs = bdQryService.getChlByTp(chlType);
		if(ArrayUtils.isNotEmpty(chlDOs)){
			return chlDOs[0];
		}
		return null;
	}
	
	/**
	 * 保存入参信息
	 * @param aptId 预约ID
	 * @param patCode 患者编码
	 * @param patProxyCode 挂号操作人编码
	 * @param seqNo 渠道的顺序号
	 * @param deptCode 科室编码
	 * @param doctorCode 医生编码
	 * @param requestDate 日期
	 * @param dayslotType 午别编码
	 * @param aptCode 预约码
	 * @throws BizException 
	 */
	private AptExChlDO[] saveScAptExchl(String aptId, MakeAptDTO aptDTO,  Integer seqNo, String deptCode, String doctorCode, FDate requestDate, String dayslotType) throws BizException{
		AptExChlDO aptExChlDo = new AptExChlDO();
		aptExChlDo.setId_apt(aptId);
		aptExChlDo.setCode_pat(aptDTO.getPatCode());
		aptExChlDo.setCode_pat_proxy(aptDTO.getAgentCode());
		aptExChlDo.setEx_seqno(seqNo);
		aptExChlDo.setCode_dep(deptCode);
		aptExChlDo.setCode_emp_phy(doctorCode);
		aptExChlDo.setD_sc(requestDate);
		aptExChlDo.setAmpm(dayslotType);
		aptExChlDo.setCode_apt(aptDTO.getAptCode());
		aptExChlDo.setStatus(DOStatus.NEW);
		if("1".equals(aptDTO.getTransFlag())){
			aptExChlDo.setFg_tranf(FBoolean.TRUE);
		}else{
			aptExChlDo.setFg_tranf(FBoolean.FALSE);
		}
		aptExChlDo.setName_org_apply(aptDTO.getOrgName_apply());
		aptExChlDo.setCtrl1(aptDTO.getCtrl1());
		aptExChlDo.setCtrl2(aptDTO.getCtrl2());
		aptExChlDo.setCtrl3(aptDTO.getCtrl3());
		aptExChlDo.setCtrl4(aptDTO.getCtrl4());
		aptExChlDo.setCtrl5(aptDTO.getCtrl5());
		AptexchlCrudServiceImpl service = new AptexchlCrudServiceImpl();
		AptExChlDO[] aptExchlDOs = service.save(aptExChlDo);
		
		if(aptExchlDOs == null || aptExchlDOs.length == 0) return null;
		return aptExchlDOs;
	}
	
	/**
	 * 获取预约信息
	 * @param aptId
	 * @return
	 * @throws DAException
	 */
	private RegResultDTO getAptInfo(String aptId) throws DAException{
		SqlParam param = new SqlParam();
		StringBuilder str_buf = new StringBuilder();
		str_buf.append("SELECT APT.ID_APT AS ID_APT,");
		str_buf.append("SUBSTR(APT.DT_B, 0, 10) AS ENTDATE,");
		str_buf.append("TK.T_B AS VISITINGTIME,");
		str_buf.append("SCH.SUGEST_EXMINT AS SUGGESTEXMINT,");
		str_buf.append("APT.QUENO AS SEQUENCENUMBER ");
		str_buf.append("FROM SC_APT APT ");
		str_buf.append("INNER JOIN SC_APT_OP AOP ");
		str_buf.append("ON APT.ID_APT = AOP.ID_APT ");
		str_buf.append("LEFT OUTER JOIN SC_SCH SCH ");
		str_buf.append("ON APT.ID_SCH = SCH.ID_SCH ");
		str_buf.append("LEFT OUTER JOIN SC_TICK TK ");
		str_buf.append("ON APT.ID_TICK = TK.ID_TICK ");
		str_buf.append("WHERE APT.ID_APT=?");
		
		param.addParam(aptId);
		List<RegResultDTO> regRstList = (List<RegResultDTO>) new DAFacade().execQuery(str_buf.toString(), param,
				new BeanListHandler(RegResultDTO.class));
		if(regRstList == null || regRstList.size() == 0)
			return null;
		return regRstList.get(0);
	}

	
	/**
	 * 获取就诊地点
	 * @param regResDTO
	 * @return
	 * @throws BizException 
	 */
	private String getQueBenDes(RegResDTO regResDTO) throws BizException {
		String sql = "SELECT SC_PL.* FROM SC_PL SC_PL INNER JOIN SC_SCH SC_SCH ON SC_PL.ID_SCPL = SC_SCH.ID_SCPL WHERE SC_SCH.ID_SCH = '" + regResDTO.getId_sch() + "' ";
		List<ScPlanDO> list = (List<ScPlanDO>) new DAFacade().execQuery(sql, new BeanListHandler(ScPlanDO.class));
		if(ListUtil.isEmpty(list))
			return null;
		IQueQryService serv = ServiceFinder.find(IQueQryService.class);
		return serv.getOpBenAddr(regResDTO.getId_dep(), regResDTO.getId_scres(), list.get(0).getId_queben());
	}
	
	/**
	 * 设置预计就诊时间
	 * @param printInfo
	 */
	private void setPeriodInfo(RegResultDTO regRst){
		Integer suggestExmin = new Integer(0);
		if(regRst.getSuggestExmint() != null){
			suggestExmin = regRst.getSuggestExmint();
		}
		FDateTime suggestTime = null;
		if(regRst.getVisitingTime() != null){
			String tempFd = regRst.getEntDate() + " " + regRst.getVisitingTime();
			FDateTime fd = new FDateTime(tempFd);
			suggestTime = fd.subSeconds(suggestExmin * 60);
			//获取当前服务器时间
			FDateTime dtService = ScAppUtils.getServerDateTime();
			if(suggestTime.compareTo(dtService) <= 0){
				//预计就诊时间小于当前时间
				regRst.setVisitingTime("-");
			}else{
				regRst.setVisitingTime(suggestTime.toString().substring(11, 16));
			}
		}else{
			regRst.setVisitingTime("-");
		}
	}
	
	/**
	 * 获取预约后的返回信息
	 * @param aptId
	 * @param regResDTO
	 * @return
	 * @throws BizException 
	 */
	private RegResultDTO getAptAfterReg(String aptId, RegResDTO regResDTO, String patId) throws BizException{
		RegResultDTO regRstTemp = this.getAptInfo(aptId);
		if(regRstTemp == null)
			return null;
	//	regRstTemp.setRegMsg("1");
		//regRstTemp.setTimes(this.getTimesEntOp(patId).toString()); 不能给就诊次数
		this.setPeriodInfo(regRstTemp);
		regRstTemp.setPlaceOfVisit(this.getQueBenDes(regResDTO));
		return regRstTemp;
	}
	/**
	 * 验证是否存在重复预约码
	 * 
	 * @param aptCode
	 * @throws BizException 
	 */
	private void volidateAptCode(String aptCode) throws BizException{
		IAptexchlRService serv = ServiceFinder.find(IAptexchlRService.class);
		AptExChlDO[] aptExs = serv.findByAttrValString(AptExChlDO.CODE_APT, aptCode);
		if(!ScValidator.isNullOrEmpty(aptExs))
			throw new BizException("已经存在该预约码！");
	}
	/**
	 * 设置号位 
	 * @param makeAptDTO
	 * @throws BizException
	 */
	private String getTickID(MakeAptDTO makeAptDTO,SchedulechlDO schedulechlDo) throws BizException{
		if(StringUtil.isEmpty(makeAptDTO.getSchId())){  //|| 
			return null;
		}
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		//指定号位
		if(!StringUtil.isEmpty(makeAptDTO.getTickCode()))
		{
			String whereStr = " id_sch = ? and queno = ? ";
			SqlParamDTO param = new SqlParamDTO();
			param.addParam(makeAptDTO.getSchId());
			param.addParam(makeAptDTO.getTickCode());
			ScSchTickDO[] tickDOs =	rService.find2(whereStr, param, "", FBoolean.FALSE);
			if(ArrayUtil.isEmpty(tickDOs)){
				throw new BizException("查找不到号位 排班为"+makeAptDTO.getSchId()+"号位为"+makeAptDTO.getTickCode());
			}
			if(!tickDOs[0].getEu_used().equals(EuUseState.WY)){
				throw new BizException("号位状态不是未用！");
			}
			if(!tickDOs[0].getEu_usescope().equals(EuUseScope.APT)){
				throw new BizException("号位未开放！");
			}
			if(!StringUtil.isEmpty(tickDOs[0].getIds_scchl())&& !tickDOs[0].getIds_scchl().contains(schedulechlDo.getId_scchl())){
				throw new BizException("号位未开放本渠道！");
			}
			return tickDOs[0].getId_tick();
		}
		return null;
	}
	/**
	 * 设置号位  号段
	 * @param makeAptDTO
	 * @throws BizException
	 */
	private String getTicksID(MakeAptDTO makeAptDTO) throws BizException{
		if(StringUtil.isEmpty(makeAptDTO.getSchId())){
			return null;
		}
		if(!StringUtil.isEmpty(makeAptDTO.getId_ticks())){
			//指定号段
			ScSchTicksDO[] ticksDOs =	ServiceFinder.find(IScticksRService.class).find("ID_SCH ='"+makeAptDTO.getSchId()+"' AND ID_TICKS ='"+makeAptDTO.getId_ticks()+"' AND FG_ACTIVE = 'Y' ",null, FBoolean.FALSE);
			if(ArrayUtil.isEmpty(ticksDOs)){
				throw new BizException("查找不到号段 排班为"+makeAptDTO.getSchId()+"号段id为"+makeAptDTO.getId_ticks());
			}
			if(FBoolean.TRUE.equals(ticksDOs[0].getFg_used())){
				throw new BizException("该号段已经用尽，请更换号段！");
			}
			return ticksDOs[0].getId_ticks();
		}	
		return null;
	}
}
