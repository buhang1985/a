package iih.mi.mibd.drugorginal.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.drugorginal.d.MiDrugOrginalDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* (新)医保药品原始目录数据维护服务
*/
public interface IDrugorginalCudService {
	/**
	*  (新)医保药品原始目录数据真删除
	*/
    public abstract void delete(MiDrugOrginalDO[] aggdos) throws BizException;
    
    /**
	*  (新)医保药品原始目录数据插入保存
	*/
	public abstract MiDrugOrginalDO[] insert(MiDrugOrginalDO[] aggdos) throws BizException;
	
    /**
	*  (新)医保药品原始目录数据保存
	*/
	public abstract MiDrugOrginalDO[] save(MiDrugOrginalDO[] aggdos) throws BizException;
	
    /**
	*  (新)医保药品原始目录数据更新
	*/
	public abstract MiDrugOrginalDO[] update(MiDrugOrginalDO[] aggdos) throws BizException;
	
	/**
	*  (新)医保药品原始目录数据逻辑删除
	*/
	public abstract void logicDelete(MiDrugOrginalDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiDrugOrginalDO[] enableWithoutFilter(MiDrugOrginalDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiDrugOrginalDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiDrugOrginalDO[] disableVOWithoutFilter(MiDrugOrginalDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiDrugOrginalDO[] dos) throws BizException ;
}
