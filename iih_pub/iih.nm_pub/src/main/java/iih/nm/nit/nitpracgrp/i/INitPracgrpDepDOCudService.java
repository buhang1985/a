package iih.nm.nit.nitpracgrp.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nitpracgrp.d.NitPracgrpDepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 实习小组数据维护服务
*/
public interface INitPracgrpDepDOCudService {
	/**
	*  实习小组数据真删除
	*/
    public abstract void delete(NitPracgrpDepDO[] aggdos) throws BizException;
    
    /**
	*  实习小组数据插入保存
	*/
	public abstract NitPracgrpDepDO[] insert(NitPracgrpDepDO[] aggdos) throws BizException;
	
    /**
	*  实习小组数据保存
	*/
	public abstract NitPracgrpDepDO[] save(NitPracgrpDepDO[] aggdos) throws BizException;
	
    /**
	*  实习小组数据更新
	*/
	public abstract NitPracgrpDepDO[] update(NitPracgrpDepDO[] aggdos) throws BizException;
	
	/**
	*  实习小组数据逻辑删除
	*/
	public abstract void logicDelete(NitPracgrpDepDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NitPracgrpDepDO[] enableWithoutFilter(NitPracgrpDepDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NitPracgrpDepDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NitPracgrpDepDO[] disableVOWithoutFilter(NitPracgrpDepDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NitPracgrpDepDO[] aggdos) throws BizException ;
	
}
