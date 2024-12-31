package iih.mp.orm.surgappconfirm.i;

import xap.mw.core.data.BizException;
import iih.mp.orm.surgappconfirm.d.SurgAppConfirmDO;
import iih.mp.orm.surgappconfirm.d.SurgappconfirmAggDO;

/**
* 手术申请单确认数据维护服务
*/
public interface ISurgappconfirmCudService {
	/**
	*  手术申请单确认数据真删除
	*/
    public abstract void delete(SurgappconfirmAggDO[] aggdos) throws BizException;
    
    /**
	*  手术申请单确认数据插入保存
	*/
	public abstract SurgappconfirmAggDO[] insert(SurgappconfirmAggDO[] aggdos) throws BizException;
	
    /**
	*  手术申请单确认数据保存
	*/
	public abstract SurgappconfirmAggDO[] save(SurgappconfirmAggDO[] aggdos) throws BizException;
	
    /**
	*  手术申请单确认数据更新
	*/
	public abstract SurgappconfirmAggDO[] update(SurgappconfirmAggDO[] aggdos) throws BizException;
	
	/**
	*  手术申请单确认数据逻辑删除
	*/
	public abstract void logicDelete(SurgappconfirmAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对手术申请单确认数据真删除
	 */
	public abstract void deleteByParentDO(SurgAppConfirmDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对手术申请单确认数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SurgAppConfirmDO[] mainDos) throws BizException;
}
