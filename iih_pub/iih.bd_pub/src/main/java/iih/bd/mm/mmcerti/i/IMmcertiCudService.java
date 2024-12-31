package iih.bd.mm.mmcerti.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import iih.bd.mm.mmcerti.d.MaterialCertiDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗物品_物品资质证书数据维护服务
*/
public interface IMmcertiCudService {
	/**
	*  医疗物品_物品资质证书数据真删除
	*/
    public abstract void delete(MaterialCertiDO[] aggdos) throws BizException;
    
    /**
	*  医疗物品_物品资质证书数据插入保存
	*/
	public abstract MaterialCertiDO[] insert(MaterialCertiDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品_物品资质证书数据保存
	*/
	public abstract MaterialCertiDO[] save(MaterialCertiDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品_物品资质证书数据更新
	*/
	public abstract MaterialCertiDO[] update(MaterialCertiDO[] aggdos) throws BizException;
	
	/**
	*  医疗物品_物品资质证书数据逻辑删除
	*/
	public abstract void logicDelete(MaterialCertiDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MaterialCertiDO[] enableWithoutFilter(MaterialCertiDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MaterialCertiDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MaterialCertiDO[] disableVOWithoutFilter(MaterialCertiDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MaterialCertiDO[] dos) throws BizException ;
	/**
	 * 更新到耗材基本信息中apprno字段
	 * @param id_mm
	 * @param cfno
	 * @throws BizException
	 */
	public FBoolean updateAPPRNOForMM(String id_mm,String cfno) throws BizException;
}
