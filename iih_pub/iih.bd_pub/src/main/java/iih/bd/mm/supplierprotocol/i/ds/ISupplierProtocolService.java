package iih.bd.mm.supplierprotocol.i.ds;

import iih.bd.mm.supplierprotocol.d.SupplierprotocolAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;

/**
 * 提供物品与供应商协议相关的自定义服务
 * @author wu.junhui
 *
 */
public interface ISupplierProtocolService {
	
	/**
	*  供应商物品协议删除
	*/	
	public void delete(String[] ids) throws BizException;
	
	/**
	*  供应商物品协议删除前验证
	*/	
	public FBoolean deleteCheck(String[] ids) throws BizException;
	
	/**
	*  供应商物品协议启用
	*/	
	public SupplierprotocolAggDO[] enable(String[] ids) throws BizException;
	
	/**
	*  供应商物品协议停用
	*/	
	public SupplierprotocolAggDO[] disable(String[] ids) throws BizException;

	/**
	*  获取物品的协议价
	*/	
	public FDouble getMmSupproPrice(String id_sup, String id_mm, FDate date_reqr) throws BizException;
}
