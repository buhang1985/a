package iih.bd.fc.que.bp;

import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueCudService;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteCudService;
import iih.bd.fc.quesite.i.IQuesiteRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 删除队列和队列下站点
 * 
 * @author liubin
 *
 */
public class DelQueAndSiteBP {
	/**
     * 删除队列和队列下站点
     * 
     * @param ques 队列集合
     * @throws BizException
     */
	public void exec(QueDO[] ques) throws BizException {
		if(ArrayUtil.isEmpty(ques)){
			throw new BizException("删除的队列不能为空！");
		}
		
		IQueCudService queCudServ = ServiceFinder.find(IQueCudService.class);
		queCudServ.delete(ques);
		
		FArrayList queIdList = this.getQueIds(ques);
		IQuesiteRService siteRServ = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO[] quesites = siteRServ.findByAttrValList(QueSiteDO.ID_QUE, queIdList);
		IQuesiteCudService siteCudServ = ServiceFinder.find(IQuesiteCudService.class);
		siteCudServ.delete(quesites);
	}
	
	/**
	 * 得到队列ID集合
	 * 
	 * @param ques
	 * @return
	 */
	private FArrayList getQueIds(QueDO[] ques){
		FArrayList list = new FArrayList();
		for(QueDO que : ques){
			list.add(que.getId_que());
		}
		return list;
	}
}
