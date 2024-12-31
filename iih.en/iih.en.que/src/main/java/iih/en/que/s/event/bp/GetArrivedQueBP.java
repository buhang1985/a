package iih.en.que.s.event.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.que.enqueue.d.EnQueueDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 获取到诊队列
 * @author fanlq
 * @date: 2019年10月24日 上午11:27:05
 */
public class GetArrivedQueBP {

	/***
	 * @Description:根据分诊台id获取到诊队列
	 * @param benId
	 * @return
	 * @throws BizException 
	 */
	private EnQueueDO[] execByBenId(String benId,String id_dayslot,FDate curDtae) throws BizException{
		if(EnValidator.isEmpty(benId)) return null;
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append("select enque.* ");
		sql.append("from en_ent_que enque " );
		sql.append("inner join en_ent ent on ent.id_ent = enque.id_ent ");
		sql.append("inner join bd_que que on que.id_que = enque.id_que " );
		sql.append("inner join pi_pat pat on pat.id_pat = enque.id_pat " );
		sql.append("where enque.sd_entque_tp = ? " );
		sql.append("and enque.sd_status_acpt = ? " );
		sql.append("and enque.dt_in >= ? " );
		sql.append("and enque.dt_in <= ? " );
		sql.append("and enque.id_dateslot = ? " );
		sql.append("and enque.id_que_site is null ");
		sql.append("and que.id_queben = ? " );
		sql.append("and ent.fg_canc = 'N' ");
		sql.append("order by enque.dt_in ");
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(curDtae + " 00:00:00");
		param.addParam(curDtae + " 23:59:59");
		param.addParam(id_dayslot);
		param.addParam(benId);
		@SuppressWarnings("unchecked")
		List<EnQueueDO> list = (List<EnQueueDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(EnQueueDO.class));
		return list != null && list.size() > 0 ? list.toArray(new EnQueueDO[0]) : null;
	}

}
