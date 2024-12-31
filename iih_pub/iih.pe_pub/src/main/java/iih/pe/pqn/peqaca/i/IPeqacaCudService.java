package iih.pe.pqn.peqaca.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.peqaca.d.PeQaCaDO;
import iih.pe.pqn.peqaca.d.PeqacaAggDO;

/**
* 体检问卷组套数据维护服务
*/
public interface IPeqacaCudService {
	/**
	*  体检问卷组套数据真删除
	*/
    public abstract void delete(PeqacaAggDO[] aggdos) throws BizException;
    
    /**
	*  体检问卷组套数据插入保存
	*/
	public abstract PeqacaAggDO[] insert(PeqacaAggDO[] aggdos) throws BizException;
	
    /**
	*  体检问卷组套数据保存
	*/
	public abstract PeqacaAggDO[] save(PeqacaAggDO[] aggdos) throws BizException;
	
    /**
	*  体检问卷组套数据更新
	*/
	public abstract PeqacaAggDO[] update(PeqacaAggDO[] aggdos) throws BizException;
	
	/**
	*  体检问卷组套数据逻辑删除
	*/
	public abstract void logicDelete(PeqacaAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检问卷组套数据真删除
	 */
	public abstract void deleteByParentDO(PeQaCaDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检问卷组套数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeQaCaDO[] mainDos) throws BizException;
}
