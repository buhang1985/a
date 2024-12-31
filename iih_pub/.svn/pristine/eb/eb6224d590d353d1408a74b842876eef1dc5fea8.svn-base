package iih.pe.pitm.pechrodisedef.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pechrodisedef.d.PeChroDiseDefDO;
import iih.pe.pitm.pechrodisedef.d.PechrodisedefAggDO;

/**
* 体检慢性病定义数据维护服务
*/
public interface IPechrodisedefCudService {
	/**
	*  体检慢性病定义数据真删除
	*/
    public abstract void delete(PechrodisedefAggDO[] aggdos) throws BizException;
    
    /**
	*  体检慢性病定义数据插入保存
	*/
	public abstract PechrodisedefAggDO[] insert(PechrodisedefAggDO[] aggdos) throws BizException;
	
    /**
	*  体检慢性病定义数据保存
	*/
	public abstract PechrodisedefAggDO[] save(PechrodisedefAggDO[] aggdos) throws BizException;
	
    /**
	*  体检慢性病定义数据更新
	*/
	public abstract PechrodisedefAggDO[] update(PechrodisedefAggDO[] aggdos) throws BizException;
	
	/**
	*  体检慢性病定义数据逻辑删除
	*/
	public abstract void logicDelete(PechrodisedefAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检慢性病定义数据真删除
	 */
	public abstract void deleteByParentDO(PeChroDiseDefDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检慢性病定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeChroDiseDefDO[] mainDos) throws BizException;
}
