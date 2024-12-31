package iih.pe.pitm.pewfoptionitem.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pewfoptionitem.d.PeWfOptionItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 流程选项与体检结果关联关系数据维护服务
*/
public interface IPewfoptionitemCudService {
	/**
	*  流程选项与体检结果关联关系数据真删除
	*/
    public abstract void delete(PeWfOptionItemDO[] aggdos) throws BizException;
    
    /**
	*  流程选项与体检结果关联关系数据插入保存
	*/
	public abstract PeWfOptionItemDO[] insert(PeWfOptionItemDO[] aggdos) throws BizException;
	
    /**
	*  流程选项与体检结果关联关系数据保存
	*/
	public abstract PeWfOptionItemDO[] save(PeWfOptionItemDO[] aggdos) throws BizException;
	
    /**
	*  流程选项与体检结果关联关系数据更新
	*/
	public abstract PeWfOptionItemDO[] update(PeWfOptionItemDO[] aggdos) throws BizException;
	
	/**
	*  流程选项与体检结果关联关系数据逻辑删除
	*/
	public abstract void logicDelete(PeWfOptionItemDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeWfOptionItemDO[] enableWithoutFilter(PeWfOptionItemDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeWfOptionItemDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeWfOptionItemDO[] disableVOWithoutFilter(PeWfOptionItemDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeWfOptionItemDO[] dos) throws BizException ;
}
