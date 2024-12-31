package iih.bd.mm.custcategoryitem.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.custcategoryitem.d.CustCategoryItemDO;
import iih.bd.mm.custcategoryitem.d.CustcategoryitemAggDO;

/**
* 医疗物品_自定义分类项目数据维护服务
*/
public interface ICustcategoryitemCudService {
	/**
	*  医疗物品_自定义分类项目数据真删除
	*/
    public abstract void delete(CustcategoryitemAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗物品_自定义分类项目数据插入保存
	*/
	public abstract CustcategoryitemAggDO[] insert(CustcategoryitemAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品_自定义分类项目数据保存
	*/
	public abstract CustcategoryitemAggDO[] save(CustcategoryitemAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品_自定义分类项目数据更新
	*/
	public abstract CustcategoryitemAggDO[] update(CustcategoryitemAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗物品_自定义分类项目数据逻辑删除
	*/
	public abstract void logicDelete(CustcategoryitemAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医疗物品_自定义分类项目数据真删除
	 */
	public abstract void deleteByParentDO(CustCategoryItemDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医疗物品_自定义分类项目数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CustCategoryItemDO[] mainDos) throws BizException;
}
