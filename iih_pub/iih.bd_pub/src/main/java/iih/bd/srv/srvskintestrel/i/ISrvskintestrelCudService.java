package iih.bd.srv.srvskintestrel.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvskintestrel.d.SrvSkinTestRelDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗服务_过敏分类和皮试项目对照关系数据维护服务
*/
public interface ISrvskintestrelCudService {
	/**
	*  医疗服务_过敏分类和皮试项目对照关系数据真删除
	*/
    public abstract void delete(SrvSkinTestRelDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务_过敏分类和皮试项目对照关系数据插入保存
	*/
	public abstract SrvSkinTestRelDO[] insert(SrvSkinTestRelDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务_过敏分类和皮试项目对照关系数据保存
	*/
	public abstract SrvSkinTestRelDO[] save(SrvSkinTestRelDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务_过敏分类和皮试项目对照关系数据更新
	*/
	public abstract SrvSkinTestRelDO[] update(SrvSkinTestRelDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务_过敏分类和皮试项目对照关系数据逻辑删除
	*/
	public abstract void logicDelete(SrvSkinTestRelDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SrvSkinTestRelDO[] enableWithoutFilter(SrvSkinTestRelDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SrvSkinTestRelDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SrvSkinTestRelDO[] disableVOWithoutFilter(SrvSkinTestRelDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SrvSkinTestRelDO[] dos) throws BizException ;
}
