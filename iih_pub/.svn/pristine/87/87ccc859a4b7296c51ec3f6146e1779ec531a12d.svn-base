package iih.bd.srv.medsrv.i;

import iih.bd.srv.medsrv.d.MedSrvRelMmDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗服务关联物品数据维护服务
*/
public interface IMedsrvRelMmCudService {
	/**
	*  医疗服务关联物品数据删除
	*/
    public abstract void delete(MedSrvRelMmDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务关联物品数据插入保存
	*/
	public abstract MedSrvRelMmDO[] insert(MedSrvRelMmDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务关联物品数据保存
	*/
	public abstract MedSrvRelMmDO[] save(MedSrvRelMmDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务关联物品数据更新
	*/
	public abstract MedSrvRelMmDO[] update(MedSrvRelMmDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务关联物品数据真删
	*/
	public abstract void logicDelete(MedSrvRelMmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MedSrvRelMmDO[] enableWithoutFilter(MedSrvRelMmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MedSrvRelMmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MedSrvRelMmDO[] disableVOWithoutFilter(MedSrvRelMmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MedSrvRelMmDO[] aggdos) throws BizException ;
	
}


