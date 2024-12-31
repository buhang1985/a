package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.validator.EnValidator;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.EntQueStatus;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取就诊队列状态
 * 
 * @author liubin
 *
 */
public class GetEnQueStatusBP {
	/**
	 * 获取就诊队列状态
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public Integer exec(String entId)throws BizException{
		if(EnValidator.isEmpty(entId))
			return null;
		EnQueEP ep = new EnQueEP();
		String whereStr = String.format("ID_ENT = '%s' AND SD_ENTQUE_TP = '%s' ", entId, IBdFcDictCodeConst.SD_QUETP_EMP);
		EnQueueDO[] enques = ep.getEnQueueByDAFacade(whereStr, null);
		if(EnValidator.isEmpty(enques))
			return null;
		EnQueueDO enque = enques[0];
		switch (enque.getSd_status_acpt()) {
		//如果刷卡记录为未到诊状态【EN_ENT_QUE.SD_STATUS_ACPT=-1】
        case IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED:
            break;
        //如果刷卡记录为到诊状态【EN_ENT_QUE.SD_STATUS_ACPT=0】
        case IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT:
            //未分诊
            return this.getArrivedOrTriaged(entId);
        //如果刷卡记录为叫号状态【EN_ENT_QUE.SD_STATUS_ACPT=1】
        case IEnDictCodeConst.SD_STATUS_ACPT_CALL:
        //如果刷卡记录为过号状态【EN_ENT_QUE.SD_STATUS_ACPT=2】
        case IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME:
            return EntQueStatus.Called;
        //如果刷卡记录为就诊状态【EN_ENT_QUE.SD_STATUS_ACPT=3】
        case IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED:
            return EntQueStatus.Accept;
		}
		return null;
	}
	/**
	 * 获取患者是到诊还是分诊状态
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private Integer getArrivedOrTriaged(String entId) throws BizException{
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT EQ.* ");
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("INNER JOIN BD_QUE BQ ON EQ.ID_QUE = BQ.ID_QUE ");
		builder.append("WHERE EQ.ID_ENT = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		builder.append("AND EQ.SD_STATUS_ACPT = ? ");
		builder.append("AND ISNULL(EQ.ID_QUE_SITE,'~')='~' ");
		builder.append("AND (BQ.SD_MODE = ? OR ");
		builder.append("(BQ.SD_MODE = ? AND NOT EXISTS ");
		builder.append("(SELECT QS1.ID_QUESITE FROM BD_QUE_SITE QS1 WHERE QS1.ID_QUE = EQ.ID_QUE AND QS1.ID_QUEBEN = BQ.ID_QUEBEN AND QS1.EU_PAUSE = ? AND QS1.FG_ACTIVE = ? ))) ");
		SqlParam param = new SqlParam();
		param.addParam(entId);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_TRIAGE);
		param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
		param.addParam(PauseEnum.ONLINE);
		param.addParam(FBoolean.TRUE);
		List<EnQueueDO> list = (List<EnQueueDO>) new DAFacade().execQuery(builder.toString(), param, new BeanListHandler(EnQueueDO.class));
		return EnValidator.isEmpty(list) ? EntQueStatus.Triaged : EntQueStatus.Arrived;
	}
}
