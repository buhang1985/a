package iih.nm.nhr.nmnuracadexp.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnuracadexp.d.NmNurAcadExpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理人员_学术团体任职数据维护服务
*/
public interface INmnuracadexpCudService {
	/**
	*  护理人员_学术团体任职数据真删除
	*/
    public abstract void delete(NmNurAcadExpDO[] aggdos) throws BizException;
    
    /**
	*  护理人员_学术团体任职数据插入保存
	*/
	public abstract NmNurAcadExpDO[] insert(NmNurAcadExpDO[] aggdos) throws BizException;
	
    /**
	*  护理人员_学术团体任职数据保存
	*/
	public abstract NmNurAcadExpDO[] save(NmNurAcadExpDO[] aggdos) throws BizException;
	
    /**
	*  护理人员_学术团体任职数据更新
	*/
	public abstract NmNurAcadExpDO[] update(NmNurAcadExpDO[] aggdos) throws BizException;
	
	/**
	*  护理人员_学术团体任职数据逻辑删除
	*/
	public abstract void logicDelete(NmNurAcadExpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurAcadExpDO[] enableWithoutFilter(NmNurAcadExpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurAcadExpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurAcadExpDO[] disableVOWithoutFilter(NmNurAcadExpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurAcadExpDO[] dos) throws BizException ;
}
