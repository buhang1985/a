package iih.nmr.ha.tcho.tchoillpatientcare.i;

import xap.mw.core.data.BizException;
import iih.nmr.ha.tcho.tchoillpatientcare.d.TchoIllPatientDO;
import iih.nmr.ha.tcho.tchoillpatientcare.d.TchoillpatientcareAggDO;

/**
* 病危(病重)患者护理记录单数据维护服务
*/
public interface ITchoillpatientcareCudService {
	/**
	*  病危(病重)患者护理记录单数据真删除
	*/
    public abstract void delete(TchoillpatientcareAggDO[] aggdos) throws BizException;
    
    /**
	*  病危(病重)患者护理记录单数据插入保存
	*/
	public abstract TchoillpatientcareAggDO[] insert(TchoillpatientcareAggDO[] aggdos) throws BizException;
	
    /**
	*  病危(病重)患者护理记录单数据保存
	*/
	public abstract TchoillpatientcareAggDO[] save(TchoillpatientcareAggDO[] aggdos) throws BizException;
	
    /**
	*  病危(病重)患者护理记录单数据更新
	*/
	public abstract TchoillpatientcareAggDO[] update(TchoillpatientcareAggDO[] aggdos) throws BizException;
	
	/**
	*  病危(病重)患者护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(TchoillpatientcareAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对病危(病重)患者护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(TchoIllPatientDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对病危(病重)患者护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(TchoIllPatientDO[] mainDos) throws BizException;
}
