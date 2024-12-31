package iih.mp.nr.mpnelabsamp.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.mpnelabsamp.d.LabSampDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 检验标本数据维护服务
*/
public interface IMpnelabsampCudService {
	/**
	*  检验标本数据真删除
	*/
    public abstract void delete(LabSampDO[] aggdos) throws BizException;
    
    /**
	*  检验标本数据插入保存
	*/
	public abstract LabSampDO[] insert(LabSampDO[] aggdos) throws BizException;
	
    /**
	*  检验标本数据保存
	*/
	public abstract LabSampDO[] save(LabSampDO[] aggdos) throws BizException;
	
    /**
	*  检验标本数据更新
	*/
	public abstract LabSampDO[] update(LabSampDO[] aggdos) throws BizException;
	
	/**
	*  检验标本数据逻辑删除
	*/
	public abstract void logicDelete(LabSampDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public LabSampDO[] enableWithoutFilter(LabSampDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(LabSampDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public LabSampDO[] disableVOWithoutFilter(LabSampDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(LabSampDO[] dos) throws BizException ;
}
