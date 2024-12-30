package iih.sc.apt.s.bp;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.dto.d.RegResultDTO;
import iih.sc.apt.scapt.d.AptExChlDO;
import iih.sc.apt.scapt.i.IAptexchlRService;
import iih.sc.apt.scapt.s.AptexchlCrudServiceImpl;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.scsch.d.ScSchDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class AptForWechatBP {
	
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
	public RegResultDTO exec(String scsrvCode,String doctorCode, String requestDate, String deptCode, String dayslotType, String chlType, Integer seqNo, String aptCode, String patCode, String agentCode) throws BizException{
		//验证是否存在重复预约码
		this.volidateAptCode(aptCode);
		
		IScSchOutQryService schQryService = ServiceFinder.find(IScSchOutQryService.class);
		RegResDTO regResDTO = null;
		// 1. 获取日期分组信息
		DaysLotDO dayslotDo = this.getDayslotInfo(dayslotType);
		if (dayslotDo == null) {
			throw new BizException("获取午别信息失败！");
		}

		// 2. 获取渠道信息
		SchedulechlDO schedulechlDo = this.getScChlByTp(chlType);
		if (schedulechlDo == null) {
			throw new BizException("获取渠道信息失败！");
		}

		// 3. 获取排班信息
		List<ScSchDO> schInfoList = this.getSchInfos(scsrvCode, doctorCode,
				requestDate, deptCode, dayslotDo.getId_dayslot());
		if (schInfoList == null || schInfoList.size() > 1) {
			throw new BizException("获取排班信息失败！");
		}

		// 获取可挂号资源的信息
		regResDTO = schQryService.getAptRes(schInfoList.get(0).getId_sch(),
				FBoolean.TRUE, schedulechlDo.getId_scchl());
		if (regResDTO == null) {
			throw new BizException("获取资源信息失败！");
		}

		OpAptDTO aptDto = new OpAptDTO();
		FArrayList regResArr = new FArrayList();
		regResArr.add(regResDTO);
		aptDto.setRegresarray(regResArr); // 资源信息

		IPatiMDORService patiMDoRService = ServiceFinder
				.find(IPatiMDORService.class);
		PatDO[] patInfos = patiMDoRService.findByAttrValString(PatDO.CODE,
				patCode);
		if (patInfos == null || patInfos.length == 0) {
			throw new BizException("获取患者信息失败！");
		}
		aptDto.setId_pat(patInfos[0].getId_pat()); // 患者ID

		// 4. 预约
		AptOpBP aptOpBp = new AptOpBP();
		String aptId = aptOpBp.exec(aptDto, FBoolean.FALSE, FBoolean.FALSE,
				schedulechlDo.getId_scchl(), null);
		if (StringUtil.isEmpty(aptId)) {
			throw new BizException("登入预约信息失败！");
		}

		// 5. 保存入参信息
		AptExChlDO[] aptExChlDOs = this.saveScAptExchl(aptId, patCode,
				agentCode, seqNo, deptCode, doctorCode, requestDate,
				dayslotType, aptCode);
		if (aptExChlDOs == null) {
			throw new BizException("保存入参信息失败！");
		}
		// 6.获取挂号成功后相关信息
		RegResultDTO regRstTemp = this.getAptAfterReg(aptId, regResDTO,
				patInfos[0].getId_pat());
		if (regRstTemp == null) {
			throw new BizException("返回预约信息异常！");
		}
		return regRstTemp;
	}
	
	/**
	 * 获取午别信息
	 * @param dayslotType 午别类型,a或p
	 * @return
	 * @throws DAException
	 */
	private DaysLotDO getDayslotInfo(String dayslotType) throws DAException{
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append("SELECT * FROM BD_DAYSLOT DT ");
		sqlBuilder.append("WHERE DT.ID_DAYSLOTCA IN ( ");
		sqlBuilder.append("SELECT CA.ID_DAYSLOTCA FROM BD_DAYSLOTCA CA ");
		sqlBuilder.append("WHERE CA.SD_DAYSLOTCATP= '1' ");
		sqlBuilder.append(") ");
		sqlBuilder.append("AND DT.SD_DAYSLOTTP = ? ");
		if("a".equals(dayslotType))
			param.addParam("01");
		else if("p".equals(dayslotType))
			param.addParam("03");
		
		List<DaysLotDO> dayslotList = (List<DaysLotDO>) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(DaysLotDO.class));
		if (ListUtil.isEmpty(dayslotList)) return null;
		return dayslotList.get(0);
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
	 * 获取排班信息
	 * @param scsrvCode 号别编码
	 * @param doctorCode 医生编码
	 * @param requestDate 日期
	 * @param deptCode 科室编码
	 * @param dayslotId 午别ID
	 * @return
	 * @throws DAException
	 * @author WJY
	 */
	private List<ScSchDO> getSchInfos(String scsrvCode,String doctorCode, String requestDate, String deptCode, String dayslotId) throws DAException{
		StringBuilder builder =new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT SCH.ID_SCH ");
		builder.append("FROM SC_SCH SCH ");
		builder.append("INNER JOIN SC_PL CPL ON SCH.ID_SCPL = CPL.ID_SCPL ");
		builder.append("INNER JOIN SC_SRV SRV ON CPL.ID_SCSRV = SRV.ID_SCSRV ");
		builder.append("INNER JOIN SC_RES RES ON CPL.ID_SCRES = RES.ID_SCRES ");
		builder.append("INNER JOIN BD_DEP DEP ON CPL.ID_DEP = DEP.ID_DEP ");
		
		builder.append("WHERE SCH.D_SCH = ? ");
		param.addParam(requestDate);
		
		builder.append("AND SCH.ID_DAYSLOT = ? ");
		param.addParam(dayslotId);
		
		builder.append("AND SRV.CODE = ? ");
		param.addParam(scsrvCode);
		
		builder.append("AND DEP.CODE = ? ");
		param.addParam(deptCode);
		
		if(!StringUtil.isEmpty(doctorCode)){
			builder.append("AND RES.ID_EMP IN (");
			builder.append("SELECT EMP.ID_PSNDOC FROM BD_PSNDOC EMP WHERE EMP.CODE= ? )");
			builder.append("AND RES.SD_SCRESTP='01' ");
			param.addParam(doctorCode);
		}else{
			builder.append("AND RES.ID_DEP = (");
			builder.append("SELECT DEP.ID_DEP FROM BD_DEP DEP WHERE DEP.CODE= ? )");
			builder.append("AND RES.SD_SCRESTP='00' ");
			param.addParam(deptCode);
		}

		List<ScSchDO> schInfoList =(List<ScSchDO>) new DAFacade().execQuery(builder.toString(), 
				param,new BeanListHandler(ScSchDO.class));	
		if (ListUtil.isEmpty(schInfoList)) return null;
		return schInfoList;
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
	private AptExChlDO[] saveScAptExchl(String aptId, String patCode, String patProxyCode, Integer seqNo, String deptCode, String doctorCode, String requestDate, String dayslotType, String aptCode) throws BizException{
		AptExChlDO aptExChlDo = new AptExChlDO();
		aptExChlDo.setId_apt(aptId);
		aptExChlDo.setCode_pat(patCode);
		aptExChlDo.setCode_pat_proxy(patProxyCode);
		aptExChlDo.setEx_seqno(seqNo);
		aptExChlDo.setCode_dep(deptCode);
		aptExChlDo.setCode_emp_phy(doctorCode);
		aptExChlDo.setD_sc(new FDate(requestDate));
		aptExChlDo.setAmpm(dayslotType);
		aptExChlDo.setCode_apt(aptCode);
		aptExChlDo.setStatus(DOStatus.NEW);
		
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
		str_buf.append("SELECT SUBSTR(APT.DT_B, 0, 10) AS ENTDATE,");
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
	 * 获取就诊次数
	 * @param patId
	 * @return
	 * @throws DAException 
	 */
	private Integer getTimesEntOp(String patId) throws DAException{
		StringBuilder str_buf = new StringBuilder();
		str_buf.append("SELECT MAX(OP.TIMES_OP) FROM EN_ENT ENT ");
		str_buf.append("INNER JOIN EN_ENT_OP OP ");
		str_buf.append("ON ENT.ID_ENT=OP.ID_ENT ");
		str_buf.append("WHERE ENT.ID_PAT=?");
		SqlParam params = new SqlParam();
		params.addParam(patId);
		Integer temesOp = (Integer) new DAFacade().execQuery(str_buf.toString(), params, new ColumnHandler());
		return temesOp == null ? 0 : temesOp;
	}
	
	/**
	 * 获取就诊地点
	 * @param deptId
	 * @param scresId
	 * @return
	 * @throws BizException 
	 */
	private String getQueBenDes(String deptId, String scresId) throws BizException {
		StringBuilder str_buf = new StringBuilder();
		str_buf.append("SELECT BEN.DES AS benDes ");
		str_buf.append("FROM BD_QUE_BEN BEN ");
		str_buf.append("WHERE BEN.ID_QUEBEN IN (");
		str_buf.append("SELECT QUE.ID_QUEBEN ");
		str_buf.append("FROM BD_QUE QUE ");
		str_buf.append("WHERE QUE.ID_DEP=? ");
		str_buf.append("AND QUE.ID_SCRES=? ");
		str_buf.append(")");
		SqlParam params = new SqlParam();
		params.addParam(deptId);
		params.addParam(scresId);
		String queBenDes = (String) new DAFacade().execQuery(str_buf.toString(), params, new ColumnHandler());
		return queBenDes;
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
		regRstTemp.setTimes(this.getTimesEntOp(patId).toString());
		this.setPeriodInfo(regRstTemp);
		regRstTemp.setPlaceOfVisit(this.getQueBenDes(regResDTO.getId_dep(), regResDTO.getId_scres()));
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
}
