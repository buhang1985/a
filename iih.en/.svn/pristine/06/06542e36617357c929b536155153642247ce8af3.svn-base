package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.dto.d.TriageEntDTO;
import iih.en.que.enqueue.d.EntQueStatus;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取待分诊的患者列表
 * 
 * @author liu bin
 */
public class GetOpTriageEntBP {

	/**
	 * 
	 * 根据status状态获取待分诊的患者列表
	 * 
	 * @param benId
	 * 		分诊台ID 
	 * @param date
	 * 		日期
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
	public TriageEntDTO[] exec(String benId,FDate date,String dayslotId,int status) throws BizException {
		if (EnValidator.isEmpty(benId) || EnValidator.isEmpty(date)|| EnValidator.isEmpty(dayslotId)) {
			return null;
		}
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT EQ.ID_ENT_QUE AS ID_ENTQUE,EN.ID_ENT AS ID_ENT,EQ.ID_QUE AS ID_QUE,");
		builder.append("EN.ID_PAT AS ID_PAT,OP.TICKETNO AS TICKNO,EN.NAME_PAT AS PAT_NAME,OP.ID_SCRES AS ID_SCRES,");
		builder.append("SR.NAME AS RES,EQ.ID_QUE_SITE AS ID_QUESITE,QS.NAME AS NAME_QUESITE,EN.ID_DEP_PHY AS ID_DEP, ");
		builder.append("DEP.NAME AS NAME_DEP,OP.ID_SCSRV AS ID_SCSRV,SS.NAME AS NAME_SRV,OP.ID_LEVEL_DISE AS ID_LEVEL_DISE,");
		builder.append("OP.SD_LEVEL_DISE,EQ.LEVEL_PRI,EQ.LEVEL_PRI_RSN,OP.FG_FIRST,EQ.SD_STATUS_ACPT,OP.SD_STATUS, ");
		builder.append("EQ.DT_REGIST AS DT_REGIST,EQ.FG_MANUAL,OP.FG_NEEDRTN,DL.NAME AS NAME_DAYSLOT ");
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("INNER JOIN EN_ENT EN ON EQ.ID_ENT = EN.ID_ENT ");
		builder.append("INNER JOIN EN_ENT_OP OP ON EQ.ID_ENT = OP.ID_ENT ");
		builder.append("INNER JOIN BD_QUE BQ ON EQ.ID_QUE = BQ.ID_QUE ");
		builder.append("LEFT JOIN SC_RES SR ON OP.ID_SCRES = SR.ID_SCRES ");
		builder.append("LEFT JOIN SC_SRV SS ON OP.ID_SCSRV = SS.ID_SCSRV ");
		builder.append("LEFT JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");
		builder.append("LEFT JOIN BD_QUE_SITE QS ON EQ.ID_QUE_SITE = QS.ID_QUESITE ");
		builder.append("LEFT JOIN BD_DAYSLOT DL ON EQ.ID_DATESLOT = DL.ID_DAYSLOT ");
		builder.append("WHERE BQ.ID_QUEBEN = ? ");
		builder.append("AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		builder.append("AND EQ.DT_REGIST = ? ");
		builder.append("AND EQ.ID_DATESLOT = ? ");
		param.addParam(benId);
		param.addParam(date);
		param.addParam(dayslotId);
		if (status == EntQueStatus.NonArrival) {
			builder.append("AND EQ.SD_STATUS_ACPT = ? ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		} else if (status == EntQueStatus.Arrived) {
			builder.append("AND (EQ.SD_STATUS_ACPT = ? AND ISNULL(EQ.ID_QUE_SITE,'~')='~') ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		} else if (status == EntQueStatus.Triaged) {
			builder.append("AND (EQ.SD_STATUS_ACPT = ? AND ISNULL(EQ.ID_QUE_SITE,'~')<>'~') ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
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
		builder.append("ORDER BY EQ.DT_IN DESC");
		String sql = builder.toString();
		List<TriageEntDTO> list = (List<TriageEntDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageEntDTO.class));
		if (!EnValidator.isEmpty(list)) {
			return list.toArray(new TriageEntDTO[0]);
		}
		return null;
	}
}
