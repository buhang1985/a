package iih.bd.mm.meterial.i;

import iih.bd.mm.meterial.d.MeterialDO;
import xap.mw.core.data.BizException;

/**
 * 物品基本信息主DO扩展CUD服务接口
 * 
 * @author hao_wu
 *
 */
public interface IMeterialMDOExtCudService {

	/**
	 * 开放物品
	 * 
	 * @param materials
	 * @return
	 * @throws BizException
	 */
	public abstract MeterialDO[] Open(MeterialDO[] materials) throws BizException;

	/**
	 * 停开物品
	 * 
	 * @param materials
	 * @return
	 * @throws BizException
	 */
	public abstract MeterialDO[] Close(MeterialDO[] materials) throws BizException;

	/**
	 * 启用物品
	 * 
	 * @param materials
	 * @return
	 * @throws BizException
	 */
	public abstract MeterialDO[] Enable(MeterialDO[] materials) throws BizException;

	/**
	 * 停用物品
	 * 
	 * @param materials
	 * @return
	 * @throws BizException
	 */
	public abstract MeterialDO[] Disable(MeterialDO[] materials) throws BizException;
	
	/**
	 * 启采购
	 * 
	 * @param materials
	 * @return
	 * @throws BizException
	 */
	public abstract MeterialDO[] openPl(MeterialDO[] materials) throws BizException;

	/**
	 * 停采购
	 * 
	 * @param materials
	 * @return
	 * @throws BizException
	 */
	public abstract MeterialDO[] closePl(MeterialDO[] materials) throws BizException;
	
	/**
	 * 启调拨
	 * 
	 * @param materials
	 * @return
	 * @throws BizException
	 */
	public abstract MeterialDO[] openTr(MeterialDO[] materials) throws BizException;

	/**
	 * 停调拨
	 * 
	 * @param materials
	 * @return
	 * @throws BizException
	 */
	public abstract MeterialDO[] closeTr(MeterialDO[] materials) throws BizException;
}
