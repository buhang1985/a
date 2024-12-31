package iih.bd.mhi.hpregion.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hpregion.d.HpRegionDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保产品_地区目录数据维护服务
*/
public interface IHpregionCudService {
	/**
	*  医保产品_地区目录数据真删除
	*/
    public abstract void delete(HpRegionDO[] aggdos) throws BizException;
    
    /**
	*  医保产品_地区目录数据插入保存
	*/
	public abstract HpRegionDO[] insert(HpRegionDO[] aggdos) throws BizException;
	
    /**
	*  医保产品_地区目录数据保存
	*/
	public abstract HpRegionDO[] save(HpRegionDO[] aggdos) throws BizException;
	
    /**
	*  医保产品_地区目录数据更新
	*/
	public abstract HpRegionDO[] update(HpRegionDO[] aggdos) throws BizException;
	
	/**
	*  医保产品_地区目录数据逻辑删除
	*/
	public abstract void logicDelete(HpRegionDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpRegionDO[] enableWithoutFilter(HpRegionDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpRegionDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpRegionDO[] disableVOWithoutFilter(HpRegionDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpRegionDO[] dos) throws BizException ;
}
