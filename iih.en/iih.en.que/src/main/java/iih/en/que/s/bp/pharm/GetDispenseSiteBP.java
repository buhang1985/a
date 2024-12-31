package iih.en.que.s.bp.pharm;

import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.i.IEnqueueRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取发药窗口
 * @author yank
 *
 */
public class GetDispenseSiteBP {
	private static final String KEY_QUESITE = "quesite";
	private static final String KEY_SORTNO = "sortno";
	/**
	 * 获取发药窗口
	 * @param presId 处方id
	 * @param pharmDepId 药房科室id
	 * @return 站点DO
	 * @throws BizException
	 */
	public FMap exec(String presId,String pharmDepId) throws BizException{
		FMap map = new FMap();
		IEnqueueRService enqueRService = ServiceFinder.find(IEnqueueRService.class);
		EnQueueDO[] queArray = enqueRService.findByAttrValString(EnQueueDO.ID_PRES, presId);
		if(queArray!=null && queArray.length>0){
			map.put(KEY_SORTNO, queArray[0].getSortno());
			
			IQuesiteRService queSiteRService = ServiceFinder.find(IQuesiteRService.class);
			String whereStr = String.format("ID_QUE_SITE='%s' AND FG_ACTIVE = '%s'",queArray[0].getId_que_site(), FBoolean.TRUE);
			QueSiteDO[] queSiteArray =  queSiteRService.find(whereStr, null, FBoolean.FALSE);
			if(queSiteArray!=null && queSiteArray.length>0){
				map.put(KEY_QUESITE, queSiteArray[0]);
			}
		}
		
		return map;	
	}
}
