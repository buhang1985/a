package iih.en.que.s.bp.op.cmd.benmgr;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.enqueue.d.EnQueueDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 取消队列分诊（分诊台管理队列模式）
 * 把分诊未就诊，分诊诊台离线，或登录诊台的医生不再出诊该队列的患者取消分诊
 * 
 * @author liubin
 *
 */
public class CancelQueTriageBP {
	/**
	 * 取消队列分诊
	 * 
	 * @param benInfo
	 * @param queId
	 */
	public void exec(TriageBenInfoDTO benInfo, String queId) throws BizException{
		if(benInfo == null || EnValidator.isEmpty(queId))
			return;
		//1.获取就诊队列
		EnQueueDO[] queues = getEnqueues(benInfo, queId);
		//2.取消分诊
		cancelTriage(queues);
	}
	/**
	 * 获取就诊队列
	 * 
	 * @param benInfo
	 * @param queId
	 * @return
	 * @throws BizException
	 */
	private EnQueueDO[] getEnqueues(TriageBenInfoDTO benInfo, String queId) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" SELECT EQ.* ");
		sqlBuilder.append(" FROM EN_ENT_QUE EQ ");
		sqlBuilder.append(" WHERE EQ.SD_ENTQUE_TP = ? ");
		sqlBuilder.append(" AND NVL(EQ.ID_QUE_SITE,'~')<>'~' ");
		sqlBuilder.append(" AND EQ.FG_ACTIVE = 'Y' ");
		sqlBuilder.append(" AND EQ.DT_REGIST = ? ");
		sqlBuilder.append(" AND EQ.ID_QUE = ? ");
		sqlBuilder.append(" AND EQ.ID_DATESLOT = ? ");
		sqlBuilder.append(" AND EQ.SD_STATUS_ACPT IN (?, ?, ?) ");
		sqlBuilder.append(" AND (EXISTS (SELECT * FROM BD_QUE_SITE BS WHERE BS.ID_QUESITE = EQ.ID_QUE_SITE AND BS.EU_PAUSE = ?) ");
		sqlBuilder.append(" OR (NOT EXISTS (SELECT * FROM BD_QUE_SITE BS INNER JOIN EN_QUE_EMP EMP ");
		sqlBuilder.append(" ON BS.ID_EMP = EMP.ID_EMP AND EMP.FG_ACTIVE = 'Y' ");
		sqlBuilder.append(" INNER JOIN BD_QUE BQ ON BQ.ID_QUE = EMP.ID_QUE AND BS.ID_DEP = BQ.ID_DEP ");
		sqlBuilder.append(" WHERE BS.ID_QUESITE = EQ.ID_QUE_SITE ");
		sqlBuilder.append(" AND BQ.ID_QUE = EQ.ID_QUE ");
		sqlBuilder.append(" AND EMP.D_QUE = EQ.DT_REGIST ");
		sqlBuilder.append(" AND EMP.ID_DAYSLOT = EQ.ID_DATESLOT ");
		sqlBuilder.append(" AND BS.EU_PAUSE = ? ))) ");
		String sql = sqlBuilder.toString();
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(EnAppUtils.getServerDate());
		param.addParam(queId);
		param.addParam(benInfo.getId_dayslot());
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
		param.addParam(PauseEnum.OFFLINE);
		param.addParam(PauseEnum.ONLINE);
		List<EnQueueDO> list = (List<EnQueueDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(EnQueueDO.class));
		return EnValidator.isEmpty(list) ? null : list.toArray(new EnQueueDO[0]);
	}
	/**
	 * 取消分诊
	 * 
	 * @param queues
	 * @throws BizException 
	 */
	private void cancelTriage(EnQueueDO[] queues) throws BizException {
		if(EnValidator.isEmpty(queues))
			return;
		EnQueEP bp = new EnQueEP();
		for (EnQueueDO enQueue : queues) {
			enQueue.setId_que_site(null);
			enQueue.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
			enQueue.setSortno_called(0);
			enQueue.setStatus(DOStatus.UPDATED);
			enQueue.setId_emp_opreg(null);
			enQueue.setFg_manual(FBoolean.FALSE);
		}
		bp.save(queues);
	}
}
