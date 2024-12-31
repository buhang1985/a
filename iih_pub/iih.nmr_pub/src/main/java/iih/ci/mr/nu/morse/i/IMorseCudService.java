package iih.ci.mr.nu.morse.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.morse.d.MorseDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* Morse跌倒/坠床风险评估单数据维护服务
*/
public interface IMorseCudService {
	/**
	*  Morse跌倒/坠床风险评估单数据真删除
	*/
    public abstract void delete(MorseDO[] aggdos) throws BizException;
    
    /**
	*  Morse跌倒/坠床风险评估单数据插入保存
	*/
	public abstract MorseDO[] insert(MorseDO[] aggdos) throws BizException;
	
    /**
	*  Morse跌倒/坠床风险评估单数据保存
	*/
	public abstract MorseDO[] save(MorseDO[] aggdos) throws BizException;
	
    /**
	*  Morse跌倒/坠床风险评估单数据更新
	*/
	public abstract MorseDO[] update(MorseDO[] aggdos) throws BizException;
	
	/**
	*  Morse跌倒/坠床风险评估单数据逻辑删除
	*/
	public abstract void logicDelete(MorseDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MorseDO[] enableWithoutFilter(MorseDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MorseDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MorseDO[] disableVOWithoutFilter(MorseDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MorseDO[] dos) throws BizException ;
}
