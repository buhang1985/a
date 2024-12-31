package iih.mi.mc.mimcspec.i;

import xap.mw.core.data.BizException;
import iih.mi.mc.mimcspec.d.MiMcSpecDO;
import iih.mi.mc.mimcspec.d.MimcspecAggDO;

/**
* 医保特殊病数据维护服务
*/
public interface IMimcspecCudService {
	/**
	*  医保特殊病数据真删除
	*/
    public abstract void delete(MimcspecAggDO[] aggdos) throws BizException;
    
    /**
	*  医保特殊病数据插入保存
	*/
	public abstract MimcspecAggDO[] insert(MimcspecAggDO[] aggdos) throws BizException;
	
    /**
	*  医保特殊病数据保存
	*/
	public abstract MimcspecAggDO[] save(MimcspecAggDO[] aggdos) throws BizException;
	
    /**
	*  医保特殊病数据更新
	*/
	public abstract MimcspecAggDO[] update(MimcspecAggDO[] aggdos) throws BizException;
	
	/**
	*  医保特殊病数据逻辑删除
	*/
	public abstract void logicDelete(MimcspecAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医保特殊病数据真删除
	 */
	public abstract void deleteByParentDO(MiMcSpecDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医保特殊病数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MiMcSpecDO[] mainDos) throws BizException;
}
