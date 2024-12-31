package iih.en.que.task.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;

/**
 * 定时删除就诊队列
 * 
 * @author liubin
 *
 */
public class DelEntQueBP {
	
	/**
	 * 执行定时删除就诊队列任务
	 * 
	 * @throws BizException
	 */
	public void executeTask() throws BizException {
		FDateTime dateTime = EnAppUtils.getServerDateTime();
		if(dateTime == null){
			Logger.error("获取当前时间失败！");
			return;
		}
		// 1 删除已经过期的队列数据
		int overdueDays = EnParamUtils.getQueValidPeriod();//获取就诊队列有效期(天)
		if(overdueDays > 0){
			//删除已经过期的队列数据
			this.delOverdueQue(dateTime,overdueDays);
		}
	}
	/**
	 * 删除已经过期的队列数据
	 * 
	 * @param dateTime
	 * 			当前时间
	 * @param overdueDays
	 * 			接诊队列保存时长，以天为单位 
	 * @throws BizException
	 */
	private void delOverdueQue(FDateTime dateTime,int overdueDays) throws BizException {
		FDate date = dateTime.getDate().asLocalBegin().getDateBefore(overdueDays);
		EnQueEP bp = new EnQueEP();
		String whereStr = String.format("%s.DT_REGIST < '%s' AND %s.CODE_ENTP = '%s' AND %s.SD_ENTQUE_TP = '%s'",EnQueueDODesc.TABLE_ALIAS_NAME, date.toString(),EnQueueDODesc.TABLE_ALIAS_NAME,IBdFcDictCodeConst.SD_CODE_ENTP_OP, EnQueueDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUETP_EMP);
		EnQueueDO[] enQueueDOs = bp.getEnQueueByWhereStr(whereStr, null);
		if(!EnValidator.isEmpty(enQueueDOs)){
			bp.delete(enQueueDOs);
		}
	}
}
