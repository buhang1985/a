package iih.nm.nbd.nbddepca.i;

import xap.mw.core.data.BizException;
import iih.nm.nbd.nbddepca.d.NbdDepCaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理单元数据维护服务
*/
public interface INbddepcaMDOCudService {
	/**
	*  护理单元数据真删除
	*/
    public abstract void delete(NbdDepCaDO[] aggdos) throws BizException;
    
    /**
	*  护理单元数据插入保存
	*/
	public abstract NbdDepCaDO[] insert(NbdDepCaDO[] aggdos) throws BizException;
	
    /**
	*  护理单元数据保存
	*/
	public abstract NbdDepCaDO[] save(NbdDepCaDO[] aggdos) throws BizException;
	
    /**
	*  护理单元数据更新
	*/
	public abstract NbdDepCaDO[] update(NbdDepCaDO[] aggdos) throws BizException;
	
	/**
	*  护理单元数据逻辑删除
	*/
	public abstract void logicDelete(NbdDepCaDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NbdDepCaDO[] enableWithoutFilter(NbdDepCaDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NbdDepCaDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NbdDepCaDO[] disableVOWithoutFilter(NbdDepCaDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NbdDepCaDO[] aggdos) throws BizException ;
	
}
