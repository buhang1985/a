package iih.pe.phm.pesuvdigest.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pesuvdigest.d.PeSuvDigestDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 健康问卷摘要数据维护服务
*/
public interface IPesuvdigestCudService {
	/**
	*  健康问卷摘要数据真删除
	*/
    public abstract void delete(PeSuvDigestDO[] aggdos) throws BizException;
    
    /**
	*  健康问卷摘要数据插入保存
	*/
	public abstract PeSuvDigestDO[] insert(PeSuvDigestDO[] aggdos) throws BizException;
	
    /**
	*  健康问卷摘要数据保存
	*/
	public abstract PeSuvDigestDO[] save(PeSuvDigestDO[] aggdos) throws BizException;
	
    /**
	*  健康问卷摘要数据更新
	*/
	public abstract PeSuvDigestDO[] update(PeSuvDigestDO[] aggdos) throws BizException;
	
	/**
	*  健康问卷摘要数据逻辑删除
	*/
	public abstract void logicDelete(PeSuvDigestDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeSuvDigestDO[] enableWithoutFilter(PeSuvDigestDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeSuvDigestDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeSuvDigestDO[] disableVOWithoutFilter(PeSuvDigestDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeSuvDigestDO[] dos) throws BizException ;
}
