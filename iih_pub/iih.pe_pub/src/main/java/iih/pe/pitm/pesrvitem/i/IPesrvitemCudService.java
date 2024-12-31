package iih.pe.pitm.pesrvitem.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pesrvitem.d.PeSrvItemDO;
import iih.pe.pitm.pesrvitem.d.PesrvitemAggDO;

/**
* 体检检查项目结果数据维护服务
*/
public interface IPesrvitemCudService {
	/**
	*  体检检查项目结果数据真删除
	*/
    public abstract void delete(PesrvitemAggDO[] aggdos) throws BizException;
    
    /**
	*  体检检查项目结果数据插入保存
	*/
	public abstract PesrvitemAggDO[] insert(PesrvitemAggDO[] aggdos) throws BizException;
	
    /**
	*  体检检查项目结果数据保存
	*/
	public abstract PesrvitemAggDO[] save(PesrvitemAggDO[] aggdos) throws BizException;
	
    /**
	*  体检检查项目结果数据更新
	*/
	public abstract PesrvitemAggDO[] update(PesrvitemAggDO[] aggdos) throws BizException;
	
	/**
	*  体检检查项目结果数据逻辑删除
	*/
	public abstract void logicDelete(PesrvitemAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检检查项目结果数据真删除
	 */
	public abstract void deleteByParentDO(PeSrvItemDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检检查项目结果数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeSrvItemDO[] mainDos) throws BizException;
}
