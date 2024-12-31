package iih.pe.pitm.pesrvsetdef.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pesrvsetdef.d.PeSrvSetDefDO;
import iih.pe.pitm.pesrvsetdef.d.PesrvsetdefAggDO;

/**
* 体检套餐定义（项目组合）数据维护服务
*/
public interface IPesrvsetdefCudService {
	/**
	*  体检套餐定义（项目组合）数据真删除
	*/
    public abstract void delete(PesrvsetdefAggDO[] aggdos) throws BizException;
    
    /**
	*  体检套餐定义（项目组合）数据插入保存
	*/
	public abstract PesrvsetdefAggDO[] insert(PesrvsetdefAggDO[] aggdos) throws BizException;
	
    /**
	*  体检套餐定义（项目组合）数据保存
	*/
	public abstract PesrvsetdefAggDO[] save(PesrvsetdefAggDO[] aggdos) throws BizException;
	
    /**
	*  体检套餐定义（项目组合）数据更新
	*/
	public abstract PesrvsetdefAggDO[] update(PesrvsetdefAggDO[] aggdos) throws BizException;
	
	/**
	*  体检套餐定义（项目组合）数据逻辑删除
	*/
	public abstract void logicDelete(PesrvsetdefAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检套餐定义（项目组合）数据真删除
	 */
	public abstract void deleteByParentDO(PeSrvSetDefDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检套餐定义（项目组合）数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeSrvSetDefDO[] mainDos) throws BizException;
}
