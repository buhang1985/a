package iih.nm.nhr.nmgrp.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmgrp.d.NmGrpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理小组数据维护服务
*/
public interface INmgrpMDOCudService {
	/**
	*  护理小组数据真删除
	*/
    public abstract void delete(NmGrpDO[] aggdos) throws BizException;
    
    /**
	*  护理小组数据插入保存
	*/
	public abstract NmGrpDO[] insert(NmGrpDO[] aggdos) throws BizException;
	
    /**
	*  护理小组数据保存
	*/
	public abstract NmGrpDO[] save(NmGrpDO[] aggdos) throws BizException;
	
    /**
	*  护理小组数据更新
	*/
	public abstract NmGrpDO[] update(NmGrpDO[] aggdos) throws BizException;
	
	/**
	*  护理小组数据逻辑删除
	*/
	public abstract void logicDelete(NmGrpDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmGrpDO[] enableWithoutFilter(NmGrpDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmGrpDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmGrpDO[] disableVOWithoutFilter(NmGrpDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmGrpDO[] aggdos) throws BizException ;
	
}
