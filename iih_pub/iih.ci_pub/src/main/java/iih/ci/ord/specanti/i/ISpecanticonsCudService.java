package iih.ci.ord.specanti.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.specanti.d.SpecAntiConsDO;
import iih.ci.ord.specanti.d.SpecanticonsAggDO;

/**
* 特殊使用级抗菌药物会诊申请数据维护服务
*/
public interface ISpecanticonsCudService {
	/**
	*  特殊使用级抗菌药物会诊申请数据真删除
	*/
    public abstract void delete(SpecanticonsAggDO[] aggdos) throws BizException;
    
    /**
	*  特殊使用级抗菌药物会诊申请数据插入保存
	*/
	public abstract SpecanticonsAggDO[] insert(SpecanticonsAggDO[] aggdos) throws BizException;
	
    /**
	*  特殊使用级抗菌药物会诊申请数据保存
	*/
	public abstract SpecanticonsAggDO[] save(SpecanticonsAggDO[] aggdos) throws BizException;
	
    /**
	*  特殊使用级抗菌药物会诊申请数据更新
	*/
	public abstract SpecanticonsAggDO[] update(SpecanticonsAggDO[] aggdos) throws BizException;
	
	/**
	*  特殊使用级抗菌药物会诊申请数据逻辑删除
	*/
	public abstract void logicDelete(SpecanticonsAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对特殊使用级抗菌药物会诊申请数据真删除
	 */
	public abstract void deleteByParentDO(SpecAntiConsDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对特殊使用级抗菌药物会诊申请数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SpecAntiConsDO[] mainDos) throws BizException;
}
