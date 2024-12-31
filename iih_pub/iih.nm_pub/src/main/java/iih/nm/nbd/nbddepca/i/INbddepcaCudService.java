package iih.nm.nbd.nbddepca.i;

import xap.mw.core.data.BizException;
import iih.nm.nbd.nbddepca.d.NbdDepCaDO;
import iih.nm.nbd.nbddepca.d.NbddepcaAggDO;

/**
* 护理单元数据维护服务
*/
public interface INbddepcaCudService {
	/**
	*  护理单元数据真删除
	*/
    public abstract void delete(NbddepcaAggDO[] aggdos) throws BizException;
    
    /**
	*  护理单元数据插入保存
	*/
	public abstract NbddepcaAggDO[] insert(NbddepcaAggDO[] aggdos) throws BizException;
	
    /**
	*  护理单元数据保存
	*/
	public abstract NbddepcaAggDO[] save(NbddepcaAggDO[] aggdos) throws BizException;
	
    /**
	*  护理单元数据更新
	*/
	public abstract NbddepcaAggDO[] update(NbddepcaAggDO[] aggdos) throws BizException;
	
	/**
	*  护理单元数据逻辑删除
	*/
	public abstract void logicDelete(NbddepcaAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理单元数据真删除
	 */
	public abstract void deleteByParentDO(NbdDepCaDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理单元数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NbdDepCaDO[] mainDos) throws BizException;
}
