package iih.mm.itf.material.i;

import java.util.List;
import java.util.Map;

import iih.mm.itf.material.d.DeliverResultDTO;
import iih.mm.itf.material.d.DirectDeliverReqDTO;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.d.ReserveDeliverReqDTO;
import iih.mm.itf.material.d.ReserveReqDTO;
import iih.mm.itf.material.d.ReserveResultDTO;
import iih.mm.itf.material.d.ReturnItemDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 本类定义了物品管理模块中用于外部模块调用的与库存相关的服务接口。
 * 主要的接口有：
 * 1.物品预留接口
 * 2.物品退预留接口
 * 3.预留发药接口
 * 4.直接发药接口
 * 5.退药接口
 * 6.物品结存查询接口
 * 
 * @author wu.junhui
 *
 */
public interface IMaterialStockService {
	//预留
	public static final String TYPE_RESERVE = "1";
	//退预留
	public static final String TYPE_RETURN = "2";
	
	//获取结存信息模式
	//可用量最大
	public static final String TYPE_MAX_NUM = "1";
	//价格最大
	public static final String TYPE_HIGH_PRICE = "2";

	/**
	 * 物品预留及退预留接口。
	 * 门诊收费后，按请求，提供物品预留，锁定请求数量。
	 * 门诊取消收费后，按请求，取消预留。
	 * @param type 预留类型(1:预留  2：退预留) 
	 * @param reserveInputs 预留请求列表
	 * @return 预留详细结果列表
	 * @throws BizException
	 */
	public ReserveResultDTO[] reserveMaterials(String type, ReserveReqDTO[] reserveInputs) throws BizException;
	public Map<String, FBoolean> getOrsrvReserveFlag(String[] id_orsrvs) throws BizException;
	public ReserveResultDTO[] getPreReserveMaterialsPrice(ReserveReqDTO[] reserveInputs) throws BizException;
	
	/**
	 * 获取物品结存及售价信息(全院最高价)
	 * @param getReqInputs
	 * @return
	 * @throws BizException
	 */
	public MaterialStockDTO[] getMaterialHighPri(GetStockReqDTO[] getReqInputs) throws BizException;
	
	/**
	 * 获取物品结存及售价信息
	 * @param getReqInputs
	 * @return
	 * @throws BizException
	 */
	public MaterialStockDTO[] getMaterialStocks(GetStockReqDTO[] getReqInputs) throws BizException;
	public Map<String, List<MaterialStockDTO>> getMaterialStockMap(List<GetStockReqDTO> getReqInputs) throws BizException;
	
	/**
	 * 预留发药。
	 * @param exeDepId 执行科室主键
	 * @param orderDepId 开单科室主键
	 * @param deliverReqInputs
	 * @return DeliverResultDTO 出库单信息
	 * @throws BizException
	 */
	public DeliverResultDTO reserveDeliver(String exeDepId, String orderDepId, ReserveDeliverReqDTO[] deliverReqInputs) throws BizException;
	
	/**
	 * 直接发药。
	 * @param exeDepId 执行科室主键
	 * @param orderDepId 开单科室主键
	 * @param deliverReqInputs
	 * @return DeliverResultDTO 出库单信息
	 * @throws BizException
	 */
	public DeliverResultDTO directDeliver(String exeDepId, String orderDepId, DirectDeliverReqDTO[] deliverReqInputs) throws BizException;
	
	/**
	 * 退药。
	 * @param orderNo
	 * @param returnItems
	 * @return DeliverResultDTO 出库单信息
	 * @throws BizException
	 */
	public DeliverResultDTO returnMaterial(String orderNo, ReturnItemDTO[] returnItems) throws BizException;
	
	/**
	 * 取消退药(只支持门急诊)。
	 * @param returnItems
	 * @return DeliverResultDTO 出库单信息
	 * @throws BizException
	 */
	public DeliverResultDTO cancelReturnMaterial(ReturnItemDTO[] returnItems) throws BizException;
}
