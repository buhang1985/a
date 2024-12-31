package iih.nm.nom.nmbedwardrecord.i;

import xap.mw.core.data.BizException;
import iih.nm.nom.nmbedwardrecord.d.NomBedwardRecordDO;
import iih.nm.nom.nmbedwardrecord.d.NmbedwardrecordAggDO;

/**
* 病房患者统计数据维护服务
*/
public interface INmbedwardrecordCudService {
	/**
	*  病房患者统计数据真删除
	*/
    public abstract void delete(NmbedwardrecordAggDO[] aggdos) throws BizException;
    
    /**
	*  病房患者统计数据插入保存
	*/
	public abstract NmbedwardrecordAggDO[] insert(NmbedwardrecordAggDO[] aggdos) throws BizException;
	
    /**
	*  病房患者统计数据保存
	*/
	public abstract NmbedwardrecordAggDO[] save(NmbedwardrecordAggDO[] aggdos) throws BizException;
	
    /**
	*  病房患者统计数据更新
	*/
	public abstract NmbedwardrecordAggDO[] update(NmbedwardrecordAggDO[] aggdos) throws BizException;
	
	/**
	*  病房患者统计数据逻辑删除
	*/
	public abstract void logicDelete(NmbedwardrecordAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对病房患者统计数据真删除
	 */
	public abstract void deleteByParentDO(NomBedwardRecordDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对病房患者统计数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NomBedwardRecordDO[] mainDos) throws BizException;
}
