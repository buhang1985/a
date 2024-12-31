package iih.ci.mr.nu.babycare.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.babycare.d.BabyInfoDO;
import iih.ci.mr.nu.babycare.d.BabycareAggDO;

/**
* 新生儿护理记录单数据维护服务
*/
public interface IBabycareCudService {
	/**
	*  新生儿护理记录单数据真删除
	*/
    public abstract void delete(BabycareAggDO[] aggdos) throws BizException;
    
    /**
	*  新生儿护理记录单数据插入保存
	*/
	public abstract BabycareAggDO[] insert(BabycareAggDO[] aggdos) throws BizException;
	
    /**
	*  新生儿护理记录单数据保存
	*/
	public abstract BabycareAggDO[] save(BabycareAggDO[] aggdos) throws BizException;
	
    /**
	*  新生儿护理记录单数据更新
	*/
	public abstract BabycareAggDO[] update(BabycareAggDO[] aggdos) throws BizException;
	
	/**
	*  新生儿护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(BabycareAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对新生儿护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(BabyInfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对新生儿护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BabyInfoDO[] mainDos) throws BizException;
}
