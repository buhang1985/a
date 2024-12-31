package iih.bd.fc.mdwfor.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.mdwfor.d.MdWfOrDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医嘱流向开立参数数据维护服务
*/
public interface IMdwforCudService {
	/**
	*  医嘱流向开立参数数据真删除
	*/
    public abstract void delete(MdWfOrDO[] aggdos) throws BizException;
    
    /**
	*  医嘱流向开立参数数据插入保存
	*/
	public abstract MdWfOrDO[] insert(MdWfOrDO[] aggdos) throws BizException;
	
    /**
	*  医嘱流向开立参数数据保存
	*/
	public abstract MdWfOrDO[] save(MdWfOrDO[] aggdos) throws BizException;
	
    /**
	*  医嘱流向开立参数数据更新
	*/
	public abstract MdWfOrDO[] update(MdWfOrDO[] aggdos) throws BizException;
	
	/**
	*  医嘱流向开立参数数据逻辑删除
	*/
	public abstract void logicDelete(MdWfOrDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MdWfOrDO[] enableWithoutFilter(MdWfOrDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MdWfOrDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MdWfOrDO[] disableVOWithoutFilter(MdWfOrDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MdWfOrDO[] dos) throws BizException ;
}
