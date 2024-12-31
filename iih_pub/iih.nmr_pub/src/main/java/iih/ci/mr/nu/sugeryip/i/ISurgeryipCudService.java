package iih.ci.mr.nu.sugeryip.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.sugeryip.d.SurgeryPatInfoDO;
import iih.ci.mr.nu.sugeryip.d.SurgeryipAggDO;

/**
* 外科住院患者护理记录单数据维护服务
*/
public interface ISurgeryipCudService {
	/**
	*  外科住院患者护理记录单数据真删除
	*/
    public abstract void delete(SurgeryipAggDO[] aggdos) throws BizException;
    
    /**
	*  外科住院患者护理记录单数据插入保存
	*/
	public abstract SurgeryipAggDO[] insert(SurgeryipAggDO[] aggdos) throws BizException;
	
    /**
	*  外科住院患者护理记录单数据保存
	*/
	public abstract SurgeryipAggDO[] save(SurgeryipAggDO[] aggdos) throws BizException;
	
    /**
	*  外科住院患者护理记录单数据更新
	*/
	public abstract SurgeryipAggDO[] update(SurgeryipAggDO[] aggdos) throws BizException;
	
	/**
	*  外科住院患者护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(SurgeryipAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对外科住院患者护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(SurgeryPatInfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对外科住院患者护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SurgeryPatInfoDO[] mainDos) throws BizException;
}
