package iih.nmr.ha.tcho.adl.i;

import xap.mw.core.data.BizException;
import iih.nmr.ha.tcho.adl.d.TchoADLDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者生活自理能力评定量表数据维护服务
*/
public interface IAdlCudService {
	/**
	*  患者生活自理能力评定量表数据真删除
	*/
    public abstract void delete(TchoADLDO[] aggdos) throws BizException;
    
    /**
	*  患者生活自理能力评定量表数据插入保存
	*/
	public abstract TchoADLDO[] insert(TchoADLDO[] aggdos) throws BizException;
	
    /**
	*  患者生活自理能力评定量表数据保存
	*/
	public abstract TchoADLDO[] save(TchoADLDO[] aggdos) throws BizException;
	
    /**
	*  患者生活自理能力评定量表数据更新
	*/
	public abstract TchoADLDO[] update(TchoADLDO[] aggdos) throws BizException;
	
	/**
	*  患者生活自理能力评定量表数据逻辑删除
	*/
	public abstract void logicDelete(TchoADLDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public TchoADLDO[] enableWithoutFilter(TchoADLDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(TchoADLDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public TchoADLDO[] disableVOWithoutFilter(TchoADLDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(TchoADLDO[] dos) throws BizException ;
}
