package iih.bd.bc.medterm.i;

import xap.mw.core.data.BizException;
import iih.bd.bc.medterm.d.SampCollectTimeDictDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 标本采集时间数据维护服务
*/
public interface ISampcoltimedictCudService {
	/**
	*  标本采集时间数据真删除
	*/
    public abstract void delete(SampCollectTimeDictDO[] aggdos) throws BizException;
    
    /**
	*  标本采集时间数据插入保存
	*/
	public abstract SampCollectTimeDictDO[] insert(SampCollectTimeDictDO[] aggdos) throws BizException;
	
    /**
	*  标本采集时间数据保存
	*/
	public abstract SampCollectTimeDictDO[] save(SampCollectTimeDictDO[] aggdos) throws BizException;
	
    /**
	*  标本采集时间数据更新
	*/
	public abstract SampCollectTimeDictDO[] update(SampCollectTimeDictDO[] aggdos) throws BizException;
	
	/**
	*  标本采集时间数据逻辑删除
	*/
	public abstract void logicDelete(SampCollectTimeDictDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SampCollectTimeDictDO[] enableWithoutFilter(SampCollectTimeDictDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SampCollectTimeDictDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SampCollectTimeDictDO[] disableVOWithoutFilter(SampCollectTimeDictDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SampCollectTimeDictDO[] dos) throws BizException ;
}
