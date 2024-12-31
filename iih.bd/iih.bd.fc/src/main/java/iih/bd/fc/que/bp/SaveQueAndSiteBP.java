package iih.bd.fc.que.bp;

import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueCudService;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * 保存队列和站点
 * 
 * @author liubin
 *
 */
public class SaveQueAndSiteBP {
	/**
     * 保存队列和站点
     * 
     * @param ques 队列集合
     * @param quesites 站点集合
     * @return
     * @throws BizException
     */
	public QueDO[] exec(QueDO[] ques, QueSiteDO[] quesites) throws BizException {
		if(ArrayUtil.isEmpty(ques)){
			throw new BizException("保存的队列不能为空！");
		}
		IQueCudService queCudServ = ServiceFinder.find(IQueCudService.class);
		ques = queCudServ.save(ques);
		
		if(!ArrayUtil.isEmpty(quesites)){
			IQuesiteCudService siteCudServ = ServiceFinder.find(IQuesiteCudService.class);
			siteCudServ.save(quesites);
		}
		
		return ques;
	}
}
