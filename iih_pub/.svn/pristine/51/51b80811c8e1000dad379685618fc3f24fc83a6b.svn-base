package iih.pe.pitm.pesrvprog.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pesrvprog.d.PeSrvProgDO;
import iih.pe.pitm.pesrvprog.d.PesrvprogAggDO;

/**
* 体检方案定义数据维护服务
*/
public interface IPesrvprogCudService {
	/**
	*  体检方案定义数据真删除
	*/
    public abstract void delete(PesrvprogAggDO[] aggdos) throws BizException;
    
    /**
	*  体检方案定义数据插入保存
	*/
	public abstract PesrvprogAggDO[] insert(PesrvprogAggDO[] aggdos) throws BizException;
	
    /**
	*  体检方案定义数据保存
	*/
	public abstract PesrvprogAggDO[] save(PesrvprogAggDO[] aggdos) throws BizException;
	
    /**
	*  体检方案定义数据更新
	*/
	public abstract PesrvprogAggDO[] update(PesrvprogAggDO[] aggdos) throws BizException;
	
	/**
	*  体检方案定义数据逻辑删除
	*/
	public abstract void logicDelete(PesrvprogAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检方案定义数据真删除
	 */
	public abstract void deleteByParentDO(PeSrvProgDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检方案定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeSrvProgDO[] mainDos) throws BizException;
}
