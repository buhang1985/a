package iih.en.comm.ep;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import iih.en.que.enqueue.i.IEnqueueCudService;
import iih.en.que.enqueue.i.IEnqueueRService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 对EnQueueDO进行操作
 * 
 * @author liubin
 *
 */
public class EnQueEP {
	
	/**
	 * 通过主键得到EnQueueDO
	 * 
	 * @param entQueId
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO getEnQueueById(String entQueId) throws BizException{
		if(EnValidator.isEmpty(entQueId)){
			return null;
		}
		return getEnQueRServ().findById(entQueId);
	}
	
	/**
	 * 通过主键得到EnQueueDO
	 * 
	 * @param entQueId
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO[] getEnQueueByIds(String[] entQueIds) throws BizException{
		if(EnValidator.isEmpty(entQueIds)){
			return null;
		}
		return getEnQueRServ().findByIds(entQueIds, FBoolean.FALSE);
	}
	
	/**
	 * 通过entId得到EnQueueDO
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO[] getEnQueueByEntId(String entId) throws BizException{
		if(EnValidator.isEmpty(entId)){
			return null;
		}
		return getEnQueRServ().findByAttrValString(EnQueueDO.ID_ENT, entId);
	}
	/**
	 * 通过entId得到EnQueueDO
	 * 
	 * @param entId 就诊ID
	 * @param queTp 队列类型
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO[] getEnQueueByEntId(String entId, String queTp) throws BizException{
		if(EnValidator.isEmpty(entId)){
			return null;
		}
		String whereStr = String.format("%s.ID_ENT = '%s' AND %s.SD_ENTQUE_TP = '%s'", 
				EnQueueDODesc.TABLE_ALIAS_NAME, entId,
				EnQueueDODesc.TABLE_ALIAS_NAME, queTp);
		return getEnQueueByWhereStr(whereStr, null);
	}
	/**
	 * 通过entId集合得到EnQueueDO
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO[] getEnQueueByEntIds(String[] entIds) throws BizException{
		if(EnValidator.isEmpty(entIds)){
			return null;
		}
		return getEnQueRServ().findByAttrValStrings(EnQueueDO.ID_ENT, entIds);
	}
	
	/**
	 * 通过查询条件得到EnQueueDO
	 * 
	 * @param whereStr
	 * 		where条件
	 * @param orderStr
	 * 		排序语句
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO[] getEnQueueByWhereStr(String whereStr, String orderStr) throws BizException{
		if(EnValidator.isEmpty(whereStr)){
			return null;
		}
		return getEnQueRServ().find(whereStr, orderStr, FBoolean.FALSE);
	}
	/**
	 * 通过查询条件得到EnQueueDO
	 * 不查询关联字段
	 * @param whereStr
	 * @param orderStr
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO[] getEnQueueByDAFacade(String whereStr, String orderStr) throws BizException{
		if(EnValidator.isEmpty(whereStr)){
			return null;
		}
		List<EnQueueDO> list = (List<EnQueueDO>) new DAFacade().findByCond(EnQueueDO.class, whereStr, orderStr);
		if(!EnValidator.isEmpty(list))
			return list.toArray(new EnQueueDO[0]);
		return null;
	}
	/**
	 * 保存EnQueueDO
	 * 
	 * @param enQueues
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO[] save(EnQueueDO[] enQueues) throws BizException{
		EnValidator.validateParam("enQueues", enQueues);
		return getEnQueCudServ().save(enQueues);
	}
	
	/**
	 * 删除EnQueueDO
	 * 
	 * @param enQueues
	 * @throws BizException
	 */
	public void delete(EnQueueDO[] enQueues) throws BizException{
		getEnQueCudServ().delete(enQueues);
	}
	
	/**
	 * 获取EnQueueDO查询服务
	 * 
	 * @return
	 */
	public IEnqueueRService getEnQueRServ(){
		return ServiceFinder.find(IEnqueueRService.class);
	}
	/**
	 * 获取EnQueueDO增删改服务
	 * 
	 * @return
	 */
	public IEnqueueCudService getEnQueCudServ(){
		return ServiceFinder.find(IEnqueueCudService.class);
	}
	
	/**
	 * 保存PatiVisitDO
	 * 
	 * @param patiVisits
	 * @return
	 * @throws BizException
	 */
	public void updateWithDAFcade(EnQueueDO[] enQueueDOs) throws BizException{
		EnValidator.validateParam("patiVisits", enQueueDOs);
		new DAFacade().updateDOs(enQueueDOs);
	}
	/**
	 * 保存PatiVisitDO
	 * 
	 * @param patiVisits
	 * @return
	 * @throws BizException
	 */
	public void updateWithDAFcade(PatiVisitDO[] patiVisits) throws BizException{
		EnValidator.validateParam("patiVisits", patiVisits);
		new DAFacade().updateDOs(patiVisits);
	}
}
