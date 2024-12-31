package iih.nmr.pkuf.nmrdi.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.nmrdi.d.NmrDiMeaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理诊断数据维护服务
*/
public interface INmrDiMeaDOCudService {
	/**
	*  护理诊断数据真删除
	*/
    public abstract void delete(NmrDiMeaDO[] aggdos) throws BizException;
    
    /**
	*  护理诊断数据插入保存
	*/
	public abstract NmrDiMeaDO[] insert(NmrDiMeaDO[] aggdos) throws BizException;
	
    /**
	*  护理诊断数据保存
	*/
	public abstract NmrDiMeaDO[] save(NmrDiMeaDO[] aggdos) throws BizException;
	
    /**
	*  护理诊断数据更新
	*/
	public abstract NmrDiMeaDO[] update(NmrDiMeaDO[] aggdos) throws BizException;
	
	/**
	*  护理诊断数据逻辑删除
	*/
	public abstract void logicDelete(NmrDiMeaDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmrDiMeaDO[] enableWithoutFilter(NmrDiMeaDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmrDiMeaDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmrDiMeaDO[] disableVOWithoutFilter(NmrDiMeaDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmrDiMeaDO[] aggdos) throws BizException ;
	
}