package iih.mc.st.mcoutrel.i;

import xap.mw.core.data.BizException;
import iih.mc.st.mcoutrel.d.McOutRelDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 高值出库关联数据维护服务
*/
public interface IMcoutrelCudService {
	/**
	*  高值出库关联数据真删除
	*/
    public abstract void delete(McOutRelDO[] aggdos) throws BizException;
    
    /**
	*  高值出库关联数据插入保存
	*/
	public abstract McOutRelDO[] insert(McOutRelDO[] aggdos) throws BizException;
	
    /**
	*  高值出库关联数据保存
	*/
	public abstract McOutRelDO[] save(McOutRelDO[] aggdos) throws BizException;
	
    /**
	*  高值出库关联数据更新
	*/
	public abstract McOutRelDO[] update(McOutRelDO[] aggdos) throws BizException;
	
	/**
	*  高值出库关联数据逻辑删除
	*/
	public abstract void logicDelete(McOutRelDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public McOutRelDO[] enableWithoutFilter(McOutRelDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(McOutRelDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public McOutRelDO[] disableVOWithoutFilter(McOutRelDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(McOutRelDO[] dos) throws BizException ;
}
