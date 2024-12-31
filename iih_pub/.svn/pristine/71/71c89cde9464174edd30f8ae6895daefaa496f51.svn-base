package iih.nmr.ha.tcho.sugeryip.i;

import xap.mw.core.data.BizException;
import iih.nmr.ha.tcho.sugeryip.d.TchoSurgeryPatInfoDO;
import iih.nmr.ha.tcho.sugeryip.d.Surgeryip1AggDO;

/**
* 外科住院患者护理记录单数据维护服务
*/
public interface ISurgeryip1CudService {
	/**
	*  外科住院患者护理记录单数据真删除
	*/
    public abstract void delete(Surgeryip1AggDO[] aggdos) throws BizException;
    
    /**
	*  外科住院患者护理记录单数据插入保存
	*/
	public abstract Surgeryip1AggDO[] insert(Surgeryip1AggDO[] aggdos) throws BizException;
	
    /**
	*  外科住院患者护理记录单数据保存
	*/
	public abstract Surgeryip1AggDO[] save(Surgeryip1AggDO[] aggdos) throws BizException;
	
    /**
	*  外科住院患者护理记录单数据更新
	*/
	public abstract Surgeryip1AggDO[] update(Surgeryip1AggDO[] aggdos) throws BizException;
	
	/**
	*  外科住院患者护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(Surgeryip1AggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对外科住院患者护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(TchoSurgeryPatInfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对外科住院患者护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(TchoSurgeryPatInfoDO[] mainDos) throws BizException;
}
