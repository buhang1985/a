package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriageEntDTO;
import iih.en.que.enqueue.d.EntQueStatus;
import iih.en.que.s.bp.er.HandleTriageEntErInfoBP;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取待分诊的患者列表
 * 
 * @author liubin
 *
 */
public class GetWaitingByBenBP {

	/**
	 * 
	 * 根据status状态获取待分诊的患者列表
	 * 
	 * @param benId
	 * 		分诊台ID 
	 * @param dayslotId
	 * 		时间分诊ID
	 * @param status
	 * 		状态
	 * <ul>
	 * <li>[-1] 未到诊状态患者</li>
	 * <li>[0] 到诊状态患者</li>
	 * <li>[1] 分诊状态患者</li>
	 * <li>[2] 通知状态患者</li>
	 * <li>[3] 就诊状态患者</li>
	 * <li>[4] 全部状态患者（不包括未到诊患者）</li>
	 * </ul>
	 * @return
	 * @throws BizException
	 */
	public TriageEntDTO[] exec(TriageBenInfoDTO triageInfo, String dayslotId, int status,String entId) throws BizException {
		if (triageInfo == null || EnValidator.isEmpty(triageInfo.getId_queben())) {
			return null;
		}
		boolean isBenQueMgr = EnParamUtils.isBenQueMgr();
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT EQ.ID_ENT_QUE AS ID_ENTQUE,EN.ID_ENT AS ID_ENT,EQ.ID_QUE AS ID_QUE,OP.EU_PREOBS AS Eu_preobs,OP.TIMES_OP,");
		builder.append("EN.ID_PAT AS ID_PAT,EQ.SORTNO AS TICKNO,EN.NAME_PAT AS PAT_NAME,OP.ID_SCRES AS ID_SCRES,");
		builder.append("SR.NAME AS RES,EQ.ID_QUE_SITE AS ID_QUESITE,QS.NAME AS NAME_QUESITE,EN.ID_DEP_PHY AS ID_DEP, ");
		builder.append("DEP.NAME AS NAME_DEP,OP.ID_SCSRV AS ID_SCSRV,SS.NAME AS NAME_SRV,OP.ID_LEVEL_DISE AS ID_LEVEL_DISE,");
		builder.append("OP.SD_LEVEL_DISE,EQ.LEVEL_PRI,EQ.LEVEL_PRI_RSN,OP.FG_FIRST,EQ.SD_STATUS_ACPT,OP.SD_STATUS, BQ.SD_MODE, EQ.SORTNO_CALLED, ");
		builder.append("EQ.DT_REGIST AS DT_REGIST,EQ.FG_MANUAL,OP.FG_NEEDRTN,DL.NAME AS NAME_DAYSLOT,EN.DT_BIRTH_PAT Dt_birth,");
		builder.append("PAT.CODE AS CODE_PAT, EN.CODE AS CODE_ENT,");
		builder.append("PL.ID_SCPL,ISNULL(PL.NAME, SR.NAME||'('||SS.NAME||')') AS NAME_SCPL ");
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("INNER JOIN EN_ENT EN ON EQ.ID_ENT = EN.ID_ENT ");
		builder.append("INNER JOIN EN_ENT_OP OP ON EQ.ID_ENT = OP.ID_ENT ");
		builder.append("INNER JOIN BD_QUE BQ ON EQ.ID_QUE = BQ.ID_QUE ");
		builder.append("INNER JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");
		builder.append("LEFT JOIN SC_SCH SCH ON OP.ID_SCH = SCH.ID_SCH ");
		builder.append("LEFT JOIN SC_PL PL ON SCH.ID_SCPL = PL.ID_SCPL ");
		builder.append("LEFT JOIN SC_RES SR ON OP.ID_SCRES = SR.ID_SCRES ");
		builder.append("LEFT JOIN SC_SRV SS ON OP.ID_SCSRV = SS.ID_SCSRV ");
		builder.append("LEFT JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");
		builder.append("LEFT JOIN BD_QUE_SITE QS ON EQ.ID_QUE_SITE = QS.ID_QUESITE ");
		builder.append("LEFT JOIN BD_DAYSLOT DL ON EQ.ID_DATESLOT = DL.ID_DAYSLOT ");
		builder.append("WHERE BQ.ID_QUEBEN = ? ");
		builder.append("AND EQ.DT_REGIST = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		builder.append("AND EN.FG_CANC = ? ");
		builder.append("AND ").append(EnSqlUtils.getOpOrErTpSql("EN", triageInfo.getCode_entp()));
		param.addParam(triageInfo.getId_queben());
		param.addParam(triageInfo.getDate());
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(FBoolean.FALSE);
		if(!EnValidator.isEmpty(dayslotId)){
			builder.append("AND EQ.ID_DATESLOT = ? ");
			param.addParam(dayslotId);
		}
		if(!EnValidator.isEmpty(entId)){
			builder.append("AND EN.ID_ENT= ? ");
			param.addParam(entId);
		}
		if (status == EntQueStatus.NonArrival) {
			builder.append("AND EQ.SD_STATUS_ACPT = ? ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		} else if (status == EntQueStatus.Arrived) {
			builder.append("AND EQ.SD_STATUS_ACPT = ? ");
			builder.append("AND ISNULL(EQ.ID_QUE_SITE,'~')='~' ");
			builder.append("AND (BQ.SD_MODE = ? OR ");
			builder.append("(BQ.SD_MODE = ? AND NOT EXISTS ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
			param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_TRIAGE);
			param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
			if(isBenQueMgr){
				builder.append(" (SELECT QS1.ID_QUESITE FROM BD_QUE_SITE QS1 INNER JOIN EN_QUE_EMP EMP ON QS1.ID_EMP = EMP.ID_EMP WHERE EMP.ID_QUE = EQ.ID_QUE AND EMP.ID_DAYSLOT= EQ.ID_DATESLOT AND EMP.D_QUE = EQ.DT_REGIST AND EMP.FG_ACTIVE=? AND QS1.ID_QUEBEN = BQ.ID_QUEBEN AND QS1.EU_PAUSE = ? AND QS1.FG_ACTIVE = ? )");
				param.addParam(FBoolean.TRUE);
				param.addParam(PauseEnum.ONLINE);
				param.addParam(FBoolean.TRUE);
			}else{
				builder.append(" (SELECT QS1.ID_QUESITE FROM BD_QUE_SITE QS1 WHERE QS1.ID_QUE = EQ.ID_QUE AND QS1.ID_QUEBEN = BQ.ID_QUEBEN AND QS1.EU_PAUSE = ? AND QS1.FG_ACTIVE = ? )");
				param.addParam(PauseEnum.ONLINE);
				param.addParam(FBoolean.TRUE);
			}
			builder.append(" )) ");
		} else if (status == EntQueStatus.Triaged) {
			builder.append("AND EQ.SD_STATUS_ACPT = ? ");
			builder.append("AND (ISNULL(EQ.ID_QUE_SITE,'~')<>'~' OR ");
			builder.append("(BQ.SD_MODE = ? AND EXISTS ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
			param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
			if(isBenQueMgr){
				builder.append(" (SELECT QS1.ID_QUESITE FROM BD_QUE_SITE QS1 INNER JOIN EN_QUE_EMP EMP ON QS1.ID_EMP = EMP.ID_EMP WHERE EMP.ID_QUE = EQ.ID_QUE AND EMP.ID_DAYSLOT= EQ.ID_DATESLOT AND EMP.D_QUE = EQ.DT_REGIST AND EMP.FG_ACTIVE=? AND QS1.ID_QUEBEN = BQ.ID_QUEBEN AND QS1.EU_PAUSE = ? AND QS1.FG_ACTIVE = ? )");
				param.addParam(FBoolean.TRUE);
				param.addParam(PauseEnum.ONLINE);
				param.addParam(FBoolean.TRUE);
			}else{
				builder.append(" (SELECT QS1.ID_QUESITE FROM BD_QUE_SITE QS1 WHERE QS1.ID_QUE = EQ.ID_QUE AND QS1.ID_QUEBEN = BQ.ID_QUEBEN AND QS1.EU_PAUSE = ? AND QS1.FG_ACTIVE = ? ) ");
				param.addParam(PauseEnum.ONLINE);
				param.addParam(FBoolean.TRUE);
			}
			builder.append(" )) ");
		} else if (status == EntQueStatus.Called) {
			builder.append("AND EQ.SD_STATUS_ACPT IN (?,?) ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
		} else if (status == EntQueStatus.Accept) {
			builder.append("AND EQ.SD_STATUS_ACPT = ? ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED);
		} else if (status == EntQueStatus.AllArrival) {
			builder.append("AND EQ.SD_STATUS_ACPT<>? ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		} else if (status == EntQueStatus.ReturnVisit){
			builder.append("AND EQ.SD_STATUS_ACPT IN (?,?) ");
			builder.append("AND OP.FG_NEEDRTN = ? ");
			builder.append("AND OP.SD_STATUS = ? ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED);
			param.addParam(FBoolean.TRUE);
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
		}
		
		builder.append("ORDER BY EQ.ID_DATESLOT, EN.ID_DEP_PHY, OP.ID_SCH, EQ.SORTNO ");
		
		String sql = builder.toString();
		List<TriageEntDTO> list = (List<TriageEntDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageEntDTO.class));
		TriageEntDTO[] ents =  EnValidator.isEmpty(list)?null:list.toArray(new TriageEntDTO[0]);
		//急诊处理
		new HandleTriageEntErInfoBP().exec(ents, triageInfo.getCode_entp());
		return ents;
	}
	
}
