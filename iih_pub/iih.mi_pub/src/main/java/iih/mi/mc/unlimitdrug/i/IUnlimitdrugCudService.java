package iih.mi.mc.unlimitdrug.i;

import xap.mw.core.data.BizException;
import iih.mi.mc.unlimitdrug.d.MiMcUnlimitDrugDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 不限量药品数据维护服务
*/
public interface IUnlimitdrugCudService {
	/**
	*  不限量药品数据真删除
	*/
    public abstract void delete(MiMcUnlimitDrugDO[] aggdos) throws BizException;
    
    /**
	*  不限量药品数据插入保存
	*/
	public abstract MiMcUnlimitDrugDO[] insert(MiMcUnlimitDrugDO[] aggdos) throws BizException;
	
    /**
	*  不限量药品数据保存
	*/
	public abstract MiMcUnlimitDrugDO[] save(MiMcUnlimitDrugDO[] aggdos) throws BizException;
	
    /**
	*  不限量药品数据更新
	*/
	public abstract MiMcUnlimitDrugDO[] update(MiMcUnlimitDrugDO[] aggdos) throws BizException;
	
	/**
	*  不限量药品数据逻辑删除
	*/
	public abstract void logicDelete(MiMcUnlimitDrugDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiMcUnlimitDrugDO[] enableWithoutFilter(MiMcUnlimitDrugDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiMcUnlimitDrugDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiMcUnlimitDrugDO[] disableVOWithoutFilter(MiMcUnlimitDrugDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiMcUnlimitDrugDO[] dos) throws BizException ;
}
