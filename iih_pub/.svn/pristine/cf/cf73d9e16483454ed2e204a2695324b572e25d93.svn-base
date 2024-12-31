package iih.bd.mm.custwarepropertymm.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.custwarepropertymm.d.CustWareProperRelationDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 仓库与医疗物品自定义分类关系数据维护服务
*/
public interface ICustwarepropertymmCudService {
	/**
	*  仓库与医疗物品自定义分类关系数据真删除
	*/
    public abstract void delete(CustWareProperRelationDO[] aggdos) throws BizException;
    
    /**
	*  仓库与医疗物品自定义分类关系数据插入保存
	*/
	public abstract CustWareProperRelationDO[] insert(CustWareProperRelationDO[] aggdos) throws BizException;
	
    /**
	*  仓库与医疗物品自定义分类关系数据保存
	*/
	public abstract CustWareProperRelationDO[] save(CustWareProperRelationDO[] aggdos) throws BizException;
	
    /**
	*  仓库与医疗物品自定义分类关系数据更新
	*/
	public abstract CustWareProperRelationDO[] update(CustWareProperRelationDO[] aggdos) throws BizException;
	
	/**
	*  仓库与医疗物品自定义分类关系数据逻辑删除
	*/
	public abstract void logicDelete(CustWareProperRelationDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CustWareProperRelationDO[] enableWithoutFilter(CustWareProperRelationDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CustWareProperRelationDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CustWareProperRelationDO[] disableVOWithoutFilter(CustWareProperRelationDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CustWareProperRelationDO[] dos) throws BizException ;
}
