package iih.pe.pitm.pesrvitemrange.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pesrvitemrange.d.PeSrvItemRangeDO;
import iih.pe.pitm.pesrvitemrange.d.PesrvitemrangeAggDO;

/**
* 体检结果范围定义数据维护服务
*/
public interface IPesrvitemrangeCudService {
	/**
	*  体检结果范围定义数据真删除
	*/
    public abstract void delete(PesrvitemrangeAggDO[] aggdos) throws BizException;
    
    /**
	*  体检结果范围定义数据插入保存
	*/
	public abstract PesrvitemrangeAggDO[] insert(PesrvitemrangeAggDO[] aggdos) throws BizException;
	
    /**
	*  体检结果范围定义数据保存
	*/
	public abstract PesrvitemrangeAggDO[] save(PesrvitemrangeAggDO[] aggdos) throws BizException;
	
    /**
	*  体检结果范围定义数据更新
	*/
	public abstract PesrvitemrangeAggDO[] update(PesrvitemrangeAggDO[] aggdos) throws BizException;
	
	/**
	*  体检结果范围定义数据逻辑删除
	*/
	public abstract void logicDelete(PesrvitemrangeAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检结果范围定义数据真删除
	 */
	public abstract void deleteByParentDO(PeSrvItemRangeDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检结果范围定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeSrvItemRangeDO[] mainDos) throws BizException;
}
