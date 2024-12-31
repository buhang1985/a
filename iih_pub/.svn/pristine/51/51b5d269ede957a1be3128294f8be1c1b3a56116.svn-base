package iih.nmr.pkuf.nmrcoll.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.nmrcoll.d.NmrCollDO;
import iih.nmr.pkuf.nmrcoll.d.NmrcollAggDO;

/**
* 文书采集记录数据维护服务
*/
public interface INmrcollCudService {
	/**
	*  文书采集记录数据真删除
	*/
    public abstract void delete(NmrcollAggDO[] aggdos) throws BizException;
    
    /**
	*  文书采集记录数据插入保存
	*/
	public abstract NmrcollAggDO[] insert(NmrcollAggDO[] aggdos) throws BizException;
	
    /**
	*  文书采集记录数据保存
	*/
	public abstract NmrcollAggDO[] save(NmrcollAggDO[] aggdos) throws BizException;
	
    /**
	*  文书采集记录数据更新
	*/
	public abstract NmrcollAggDO[] update(NmrcollAggDO[] aggdos) throws BizException;
	
	/**
	*  文书采集记录数据逻辑删除
	*/
	public abstract void logicDelete(NmrcollAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对文书采集记录数据真删除
	 */
	public abstract void deleteByParentDO(NmrCollDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对文书采集记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmrCollDO[] mainDos) throws BizException;
}
