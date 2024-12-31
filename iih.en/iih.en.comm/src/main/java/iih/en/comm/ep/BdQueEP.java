package iih.en.comm.ep;

import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueCudService;
import iih.bd.fc.que.i.IQueRService;
import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 队列EP
 * 
 * @author liubin
 * 
 */
public class BdQueEP {

	/**
	 * 获取队列
	 * 
	 * @param queId 站点ID
	 * @return
	 * @throws BizException
	 */
	public QueDO getQueById(String queId) throws BizException {
		return getQueRServ().findById(queId);
	}

	/**
	 * 通过id_que数组获取队列DO数组
	 * 
	 * @param queId 站点ID
	 * @return
	 * @throws BizException
	 */
	public QueDO[] getQueDosByIds(String[] queIds) throws BizException {
		if (EnValidator.isEmpty(queIds)) {
			return null;
		}
		return getQueRServ().findByIds(queIds, FBoolean.FALSE);
	}
	
	/**
	 * 获取队列查询服务
	 * 
	 * @return
	 */
	public IQueRService getQueRServ() {
		return ServiceFinder.find(IQueRService.class);
	}

	/**
	 * 获取队列增加，删除，修改服务
	 * 
	 * @return
	 */
	public IQueCudService getQueCudServ() {
		return ServiceFinder.find(IQueCudService.class);
	}
}
