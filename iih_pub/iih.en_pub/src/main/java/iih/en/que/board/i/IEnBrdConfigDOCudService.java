package iih.en.que.board.i;

import xap.mw.core.data.BizException;
import iih.en.que.board.d.EnBrdConfigDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 患者就诊_大屏数据维护服务
*/
public interface IEnBrdConfigDOCudService {
	/**
	*  患者就诊_大屏数据真删除
	*/
    public abstract void delete(EnBrdConfigDO[] aggdos) throws BizException;
    
    /**
	*  患者就诊_大屏数据插入保存
	*/
	public abstract EnBrdConfigDO[] insert(EnBrdConfigDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_大屏数据保存
	*/
	public abstract EnBrdConfigDO[] save(EnBrdConfigDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_大屏数据更新
	*/
	public abstract EnBrdConfigDO[] update(EnBrdConfigDO[] aggdos) throws BizException;
	
	/**
	*  患者就诊_大屏数据逻辑删除
	*/
	public abstract void logicDelete(EnBrdConfigDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnBrdConfigDO[] enableWithoutFilter(EnBrdConfigDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnBrdConfigDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnBrdConfigDO[] disableVOWithoutFilter(EnBrdConfigDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnBrdConfigDO[] aggdos) throws BizException ;
	
}
