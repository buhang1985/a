package iih.bd.mm.mmgrp.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.mmgrp.d.MmGrpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 物品分组数据维护服务
*/
public interface IMmgrpCudService {
	/**
	*  物品分组数据真删除
	*/
    public abstract void delete(MmGrpDO[] aggdos) throws BizException;
    
    /**
	*  物品分组数据插入保存
	*/
	public abstract MmGrpDO[] insert(MmGrpDO[] aggdos) throws BizException;
	
    /**
	*  物品分组数据保存
	*/
	public abstract MmGrpDO[] save(MmGrpDO[] aggdos) throws BizException;
	
    /**
	*  物品分组数据更新
	*/
	public abstract MmGrpDO[] update(MmGrpDO[] aggdos) throws BizException;
	
	/**
	*  物品分组数据逻辑删除
	*/
	public abstract void logicDelete(MmGrpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MmGrpDO[] enableWithoutFilter(MmGrpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MmGrpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MmGrpDO[] disableVOWithoutFilter(MmGrpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MmGrpDO[] dos) throws BizException ;
}
