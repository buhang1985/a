package iih.nm.nhr.nmnurac.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnurac.d.NmNurAcDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理管理_人员学术会议数据维护服务
*/
public interface INmnuracCudService {
	/**
	*  护理管理_人员学术会议数据真删除
	*/
    public abstract void delete(NmNurAcDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_人员学术会议数据插入保存
	*/
	public abstract NmNurAcDO[] insert(NmNurAcDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_人员学术会议数据保存
	*/
	public abstract NmNurAcDO[] save(NmNurAcDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_人员学术会议数据更新
	*/
	public abstract NmNurAcDO[] update(NmNurAcDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_人员学术会议数据逻辑删除
	*/
	public abstract void logicDelete(NmNurAcDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurAcDO[] enableWithoutFilter(NmNurAcDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurAcDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurAcDO[] disableVOWithoutFilter(NmNurAcDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurAcDO[] dos) throws BizException ;
}
