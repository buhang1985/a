package iih.ei.std.s.v1.bp.en;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.queben.d.QueBenDO;
import iih.bd.fc.queben.i.IQuebenRService;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.ei.std.d.v1.en.makeentarrive.d.MakeEntArriveParamDTO;
import iih.ei.std.d.v1.en.makeentarrive.d.MakeEntArriveResultDTO;
import iih.ei.std.d.v1.utils.EiAppUtils;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.EiParamUtils;
import iih.en.pv.dto.d.OpRegDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import iih.en.que.enqueue.i.IEnqueueRService;
import iih.en.que.i.IEnQueCmdService;
import iih.en.que.i.IEnQueOutCmdService;
import iih.en.que.i.IEnQueQryService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.sc.pub.ScGroupControlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/****
 * 签到分诊
 * @author fanlq
 * @date: 2019年10月12日 下午2:21:29
 */
public class MakeEntArriveBP extends IIHServiceBaseBP<MakeEntArriveParamDTO, MakeEntArriveResultDTO> {

	@Override
	protected void checkParam(MakeEntArriveParamDTO param) throws BizException {
		if(StringUtils.isNullOrEmpty(param.getCode_pat()))
			throw new BizException("患者编码不能为空！");
		if(StringUtils.isNullOrEmpty(param.getTimes_op()))
			throw new BizException("就诊次数不能为空！");
		if(StringUtils.isNullOrEmpty(param.getCode_queben()))
			throw new BizException("分诊台编码不能为空！");
		if(StringUtils.isNullOrEmpty(param.getCode_opr()))
			throw new BizException("操作员编码不能为空！");
	}

	@Override
	protected MakeEntArriveResultDTO process(MakeEntArriveParamDTO param) throws BizException {
		//1.获取分诊台信息
		TriageBenInfoDTO triageBenInfo = getTriageBenInfo(param.getCode_queben());
		//2.获取患者有效挂号信息
		OpRegDTO opRegInfo = getEnRegInfo(param.getCode_pat(), triageBenInfo,param.getTimes_op());
		//3.校验患者状态
		validateEnInfo(opRegInfo, triageBenInfo);
		//4.设置患者为回诊
		setEntFirstOrRtn(opRegInfo);
		//5.签到
		makeArrive(opRegInfo, triageBenInfo);
		//6.签到后判断诊台，如果id_que_site不为空，则不需要调用自动分诊
		EnQueueDO queue = getEnQueue(opRegInfo.getId_ent());
		MakeEntArriveResultDTO result = new MakeEntArriveResultDTO();
		if(!StringUtil.isEmptyWithTrim(queue.getId_que_site())){
			result.setName_site(getSiteName(queue.getId_que_site()));
			return result;
		}
		//7.自动分诊
		result = this.autoTriage(opRegInfo, triageBenInfo, result);
		return result;
	}
	/**
	 * 获取分诊台信息
	 * 
	 * @param benCode
	 * @return
	 * @throws BizException
	 */
	private TriageBenInfoDTO getTriageBenInfo(String benCode) throws BizException{		
		IQuebenRService queService = ServiceFinder.find(IQuebenRService.class);
		String whereStr = String.format("Code = '%s' and Sd_quebentp = '%s'", benCode, IBdFcDictCodeConst.SD_QUETP_EMP);
		QueBenDO[] benDOs = queService.find(whereStr, "", FBoolean.FALSE);
		TriageBenInfoDTO triageInfo = null;
		if (!ArrayUtil.isEmpty(benDOs)) {
			IEnQueQryService serv = ServiceFinder.find(IEnQueQryService.class);
			triageInfo = serv.getTriageBenInfo(benDOs[0].getId_queben(), IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		}
		if(triageInfo == null){
			throw new BizException(String.format("未查询到%s对应的分诊台！", benCode));
		}
		return triageInfo;
	}
	/**
	 * 获取患者的挂号信息
	 * 
	 * @param patCode
	 * @param triageInfo
	 * @param optimes
	 * @return
	 * @throws BizException
	 */
	private OpRegDTO getEnRegInfo(String patCode, TriageBenInfoDTO triageInfo, String optimes)
			throws BizException {
		//获取患者id
		String whereStr = String.format("Code = '%s' and Fg_invd = 'N'", patCode);
		IPatiMDORService rService = ServiceFinder.find(IPatiMDORService.class);
		PatDO[] patDo = rService.find(whereStr, null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(patDo)){
			throw new BizException(String.format("未查询到%s对应的患者信息！", patCode));
		}
		List<String> patIdList = new ArrayList<String>();
		patIdList.add(patDo[0].getId_pat());
		List<String> benIdList = new ArrayList<String>();
		benIdList.add(triageInfo.getId_queben());
	    OpRegDTO[]  opRegDTOs= this.getOpRegList(patIdList.toArray(new String[0]),benIdList.toArray(new String[0]), EiAppUtils.getAcptQryDateTime(triageInfo.getDate(), triageInfo.getId_dayslot()), optimes);
	    if(ArrayUtil.isEmpty(opRegDTOs)){
	    	throw new BizException("未检索到在该分诊台分诊的挂号信息!");
	    }
		return opRegDTOs[0];
	}
	/**
	 * 校验挂号状态
	 * @param opRegDTO
	 * @param regRst
	 */
	private void validateEnInfo(OpRegDTO opRegDTO, TriageBenInfoDTO triageBenInfo) throws BizException{
		if(triageBenInfo.getId_dayslot()!=null && !triageBenInfo.getId_dayslot().equals(opRegDTO.getId_dateslot()))
			return;
		String res = new GetEntStatusBP().getVisitStatus(opRegDTO.getSd_status(), opRegDTO.getSd_status_acpt(), opRegDTO.getId_que_site(), opRegDTO.getSortno_called());
		if(GetEntStatusBP.STATUS_TRIAGE.equals(res)){
			throw new BizException("已分诊，请等候叫号接诊!");
		}
		if (GetEntStatusBP.STATUS_NOTIFY.equals(res)) {
			throw new BizException(String.format("已叫号，请直接到%s处接诊!", getSiteName(opRegDTO.getId_que_site())));
		}
		if(GetEntStatusBP.STATUS_TRIAGEANDSCREENED.equals(res)){
			throw new BizException("已上屏，请等候叫号接诊!");
		}
	}
	/**
	 * 计算可提前接诊时间
	 * 
	 * @param dateTime
	 * @return
	 */
	public FDateTime getAdvanceAcptTime(FDateTime dateTime){
		int time = EiParamUtils.getAdvanceAcptTime();
		if(time > 0)
			return dateTime.addSeconds(time * 60);
		return dateTime;
	}
	/**
	 * 获取医生站点名称
	 * 
	 * @param siteId
	 * @return
	 * @throws BizException
	 */
	private String getSiteName(String siteId) throws BizException{
		IQuesiteRService serv = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO site =  serv.findById(siteId);
		if(site == null)
			throw new BizException("获取医生诊台失败！");
		return site.getName();
	}
	/**
	 * 设置患者为回诊
	 * 
	 * @param opRegDTO
	 * @throws BizException
	 */
	private void setEntFirstOrRtn(OpRegDTO opRegDTO)  throws BizException {
		if(!IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED.equals(opRegDTO.getSd_status_acpt()))
			return;
		if(FBoolean.TRUE.equals(opRegDTO.getFg_needrtn()))
			return;
		if(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER.equals(opRegDTO.getSd_status()) 
				|| IEnDictCodeConst.SD_ENSTATUS_OP_FINISH.equals(opRegDTO.getSd_status())){
			IEnQueCmdService serv = ServiceFinder.find(IEnQueCmdService.class);
			serv.setEntFirstOrRtn(opRegDTO.getId_ent(), FBoolean.FALSE);
		}
	}
	/**
	 * 签到
	 * @param opRegDTOs
	 * @param triageDTO
	 * @param regRst
	 * @throws BizException
	 */
	private void makeArrive(OpRegDTO opRegDTO, TriageBenInfoDTO triageDTO) throws BizException {
		IEnQueCmdService service = ServiceFinder.find(IEnQueCmdService.class);
		service.arrive(opRegDTO, triageDTO);	
	}
	/**
	 * 通过entId得到EnQueueDO
	 * 
	 * @param entId 就诊ID
	 * @param queTp 队列类型
	 * @return
	 * @throws BizException
	 */
	private EnQueueDO getEnQueue(String entId) throws BizException{
		String whereStr = String.format("%s.ID_ENT = '%s' AND %s.SD_ENTQUE_TP = '%s'", 
				EnQueueDODesc.TABLE_ALIAS_NAME, entId,
				EnQueueDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUETP_EMP);
		EnQueueDO[] queues = ServiceFinder.find(IEnqueueRService.class).find(whereStr, null, FBoolean.FALSE);
		return queues[0];
	}
	/**
	 * 自动分诊
	 * @param opRegDTOs
	 * @param regRst
	 * @throws BizException
	 */
	private MakeEntArriveResultDTO autoTriage(OpRegDTO opRegDTO, TriageBenInfoDTO triageBenInfo,MakeEntArriveResultDTO result) throws BizException{		
		try {
			IEnQueOutCmdService service = ServiceFinder.find(IEnQueOutCmdService.class);
			FMap map = service.autoTriagePat(triageBenInfo, opRegDTO.getId_ent());
			if(map!=null && map.containsKey("site")){
				result.setName_site(map.get("site").toString());
			}
		} catch (BizRuntimeException ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	private OpRegDTO[] getOpRegList(String[] patIds,String[] benIds,FDateTime dateTime,String opTimes) throws BizException{
		if(dateTime==null)
			dateTime = EiAppUtils.getServerDateTime();
		SqlParam param = new SqlParam();
		StringBuilder builder = this.getBaseSqlBuilder();
		builder.append("WHERE EN.FG_CANC = ? ");
		param.addParam(FBoolean.FALSE);
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		builder.append(" AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		if(!ArrayUtil.isEmpty(patIds)){
			builder.append("AND ").append(SqlUtils.getInSqlByIds("EN.ID_PAT", patIds));
		}
		if(!ArrayUtil.isEmpty(benIds)){
			builder.append("AND ").append(SqlUtils.getInSqlByIds("BQ.ID_QUEBEN", benIds));
		}
		builder.append("AND OP.DT_VALID_B <= ? ");
		builder.append("AND OP.DT_VALID_E >= ? ");
		param.addParam(this.getAdvanceAcptTime(dateTime));
		param.addParam(dateTime);
		if(!StringUtil.isEmptyWithTrim(opTimes)){
			builder.append("AND OP.TIMES_OP = ? ");
			param.addParam(opTimes);
		}
		Boolean aptNeedCfm = EiParamUtils.getAptNeedCfm();
		if(!aptNeedCfm){
			builder.append("AND OP.SD_STATUS IN (?,?,?,?) ");
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_ORDER);
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER);
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER);
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
		}else{
			builder.append("AND OP.SD_STATUS IN (?,?,?) ");
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER);
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER);
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
		}
	   String sql = builder.toString();
	   return this.execQuery(sql, param);
	}
	/**
	 * 查询数据
	 * 
	 * @param sql
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private OpRegDTO[] execQuery(String sql, SqlParam param) throws BizException{
		List<OpRegDTO> list = (List<OpRegDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(OpRegDTO.class));
		if(!ListUtil.isEmpty(list)){
			return list.toArray(new OpRegDTO[0]);
		}
		return null;
	}
	/**
	 * 获取基础查询SQL
	 * 
	 * @return
	 */
	private StringBuilder getBaseSqlBuilder(){
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT EN.ID_ENT AS ID_ENT,");
		builder.append("EN.ID_PAT AS ID_PAT,");
		builder.append("SUBSTR(EN.DT_ENTRY, 0, 10) AS DT_ENTRY,");
		builder.append("EN.DT_INSERT AS DT_INSERT,");
		builder.append("EN.CODE_ENTP AS CODE_ENTP,");
		builder.append("EN.ID_HP AS ID_HP,");
		builder.append("EQ.ID_DATESLOT AS ID_DATESLOT,");
		builder.append("OP.ID_SCRES AS ID_SCRES,");
		builder.append("OP.ID_SCSRV AS ID_SCSRV,");
		builder.append("OP.ID_DEP_REG AS ID_DEP_REG,");
		builder.append("OP.SD_STATUS AS SD_STATUS,");
		builder.append("OP.ID_LEVEL_DISE AS ID_LEVEL_DISE,");
		builder.append("OP.SD_LEVEL_DISE AS SD_LEVEL_DISE,");
		builder.append("OP.FG_NEEDRTN AS FG_NEEDRTN,");
		builder.append("EQ.SORTNO AS SORTNO,");
		builder.append("EQ.ID_QUE_SITE, ");
		builder.append("EQ.ID_ENT_QUE AS ID_ENT_QUE, ");
		builder.append("EQ.SORTNO_CALLED, ");
		builder.append("EQ.SD_STATUS_ACPT AS SD_STATUS_ACPT,");
		builder.append("EQ.ID_QUE AS ID_QUE,");
		builder.append("PI_PAT.FG_REALNAME AS FG_REALNAME, ");
		builder.append("LOT.NAME AS NAME_DATESLOT,");
		builder.append("RES.NAME AS NAME_SCRES,");
		builder.append("SRV.NAME AS NAME_SCSRV,");
		builder.append("DEP.NAME AS NAME_DEP_REG, ");
		builder.append("ENTQUE.DT_IN AS DT_ARRV ");
		builder.append("FROM EN_ENT EN ");
		builder.append("INNER JOIN EN_ENT_OP OP ON OP.ID_ENT = EN.ID_ENT ");
		builder.append("INNER JOIN EN_ENT_QUE EQ ON EQ.ID_ENT = EN.ID_ENT ");
		builder.append("INNER JOIN PI_PAT PI_PAT ON EN.ID_PAT = PI_PAT.ID_PAT ");
		builder.append("LEFT  JOIN EN_ENT_QUE  ENTQUE  ON  EN.ID_ENT = ENTQUE.ID_ENT AND  ENTQUE.SD_ENTQUE_TP = '0' ");
		builder.append("LEFT JOIN BD_QUE BQ ON EQ.ID_QUE = BQ.ID_QUE ");
		builder.append("LEFT JOIN SC_RES RES ON OP.ID_SCRES = RES.ID_SCRES ");
		builder.append("LEFT JOIN SC_SRV SRV ON OP.ID_SCSRV = SRV.ID_SCSRV ");
		builder.append("LEFT JOIN BD_DAYSLOT LOT ON EQ.ID_DATESLOT = LOT.ID_DAYSLOT ");
		builder.append("LEFT JOIN BD_DEP DEP ON OP.ID_DEP_REG = DEP.ID_DEP ");
		return builder;
	}
}
