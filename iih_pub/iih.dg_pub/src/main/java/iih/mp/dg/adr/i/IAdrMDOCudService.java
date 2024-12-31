package iih.mp.dg.adr.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.adr.d.MpDgAdrDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 药品不良反应数据维护服务
*/
public interface IAdrMDOCudService {
	/**
	*  药品不良反应数据真删除
	*/
    public abstract void delete(MpDgAdrDO[] aggdos) throws BizException;
    
    /**
	*  药品不良反应数据插入保存
	*/
	public abstract MpDgAdrDO[] insert(MpDgAdrDO[] aggdos) throws BizException;
	
    /**
	*  药品不良反应数据保存
	*/
	public abstract MpDgAdrDO[] save(MpDgAdrDO[] aggdos) throws BizException;
	
    /**
	*  药品不良反应数据更新
	*/
	public abstract MpDgAdrDO[] update(MpDgAdrDO[] aggdos) throws BizException;
	
	/**
	*  药品不良反应数据逻辑删除
	*/
	public abstract void logicDelete(MpDgAdrDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpDgAdrDO[] enableWithoutFilter(MpDgAdrDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpDgAdrDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpDgAdrDO[] disableVOWithoutFilter(MpDgAdrDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpDgAdrDO[] aggdos) throws BizException ;
	
}
