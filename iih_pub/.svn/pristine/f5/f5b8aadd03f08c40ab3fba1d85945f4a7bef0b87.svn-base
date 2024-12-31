package iih.bd.srv.basemrtplfs.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.basemrtplfs.d.BaseMrTplStreamDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗记录基础模板流数据数据维护服务
*/
public interface IBasemrtplfsCudService {
	/**
	*  医疗记录基础模板流数据数据真删除
	*/
    public abstract void delete(BaseMrTplStreamDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录基础模板流数据数据插入保存
	*/
	public abstract BaseMrTplStreamDO[] insert(BaseMrTplStreamDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录基础模板流数据数据保存
	*/
	public abstract BaseMrTplStreamDO[] save(BaseMrTplStreamDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录基础模板流数据数据更新
	*/
	public abstract BaseMrTplStreamDO[] update(BaseMrTplStreamDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录基础模板流数据数据逻辑删除
	*/
	public abstract void logicDelete(BaseMrTplStreamDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BaseMrTplStreamDO[] enableWithoutFilter(BaseMrTplStreamDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BaseMrTplStreamDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BaseMrTplStreamDO[] disableVOWithoutFilter(BaseMrTplStreamDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BaseMrTplStreamDO[] dos) throws BizException ;
}
