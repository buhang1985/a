package iih.nm.nhr.nmnhrnurdefbed.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnhrnurdefbed.d.NmNhrNurDefbedDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理管理护理人员默认床位维护数据维护服务
*/
public interface INmnhrnurdefbedCudService {
	/**
	*  护理管理护理人员默认床位维护数据真删除
	*/
    public abstract void delete(NmNhrNurDefbedDO[] aggdos) throws BizException;
    
    /**
	*  护理管理护理人员默认床位维护数据插入保存
	*/
	public abstract NmNhrNurDefbedDO[] insert(NmNhrNurDefbedDO[] aggdos) throws BizException;
	
    /**
	*  护理管理护理人员默认床位维护数据保存
	*/
	public abstract NmNhrNurDefbedDO[] save(NmNhrNurDefbedDO[] aggdos) throws BizException;
	
    /**
	*  护理管理护理人员默认床位维护数据更新
	*/
	public abstract NmNhrNurDefbedDO[] update(NmNhrNurDefbedDO[] aggdos) throws BizException;
	
	/**
	*  护理管理护理人员默认床位维护数据逻辑删除
	*/
	public abstract void logicDelete(NmNhrNurDefbedDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNhrNurDefbedDO[] enableWithoutFilter(NmNhrNurDefbedDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNhrNurDefbedDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNhrNurDefbedDO[] disableVOWithoutFilter(NmNhrNurDefbedDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNhrNurDefbedDO[] dos) throws BizException ;
}
