package iih.en.que.s.bp.pharm;

import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.i.IEnqueueRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 查询窗口队列
 * @author yank
 *
 */
public class GetEntQueListBP {
	/**
	 * 查询窗口队列
	 * @param queSiteId 窗口id
	 * @param statusList 查询的状态列表，21-配药   22-叫号   23-叫号未到   24-发药
	 * @param qryDate 查询日期
	 * @return 就诊队列集合
	 * @throws BizException
	 */
	public EnQueueDO[] exec(String queSiteId,FArrayList statusList,FDate qryDate) throws BizException{
		IEnqueueRService enqueRService = ServiceFinder.find(IEnqueueRService.class);
		StringBuilder whereBuilder = new StringBuilder();
		whereBuilder.append(String.format("ID_QUE_SITE ='%s'",queSiteId));
		whereBuilder.append(String.format(" AND DT_REGIST = '%s' ",qryDate));
		if(statusList!=null && statusList.size()>0){
			whereBuilder.append(" AND SD_STATUS_ACPT IN (");
			boolean first = true;
			for(Object status : statusList){
				if(status==null ||status.toString().length()<=0){
					continue;
				}
				if(!first){
					whereBuilder.append(",");
				}else{first = false;}
				
				whereBuilder.append(String.format("'%s'",status));
			}			
			whereBuilder.append(")");
		}
		String whereStr = whereBuilder.toString();
		String orderStr = "LEVEL_PRI DESC, SORTNO ASC";
		EnQueueDO[] dtos = enqueRService.find(whereStr, orderStr, FBoolean.FALSE);		
		return dtos;
	}
}
