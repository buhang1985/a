package iih.mm.itf.material.i;

import iih.mm.itf.basematerialdto.d.BaseMaterialDTO;
import iih.mm.itf.material.d.GetMaterialPriceDTO;
import iih.mm.itf.material.d.MaterialInfoDTO;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import iih.mm.itf.materialwithpkginfodto.d.MaterialWithPkgInfoDTO;
import iih.mm.itf.mminuseinfodto.d.MmInuseInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public interface IMaterialBaseInfoService {

	/**
	 * 根据物品主键获取物品基本信息。
	 * @param id_mms 物品主键
	 * @return 物品基本信息
	 * @throws BizException
	 */
	public MaterialInfoDTO[] getMaterialsByIds(String[] id_mms) throws BizException;
	
	/**
	 * 判断物品是否是基数库管理，便于确定物品执行科室。
	 * @param id_mm 物品主键
	 * @param id_dep 病人病区主键
	 * @return
	 * @throws BizException
	 */
	public BaseMaterialDTO[] isBaseMaterial(BaseMaterialDTO[] baseMMDTOS) throws BizException;
	
	/**
	 * 获取物品的销售价格。只限物品售价模式为[固定售价]的物品，对于物品售价模式为[加成率计算]的物品，
	 * 只能通过[物品结存及价格服务]相关的接口获取售价。
	 * @param id_mm 物品ID
	 * @param req_unit_id 请求单位
	 * @return 物品售价
	 * @throws BizException
	 */
	public FDouble getSalePrice(String id_mm, String req_unit_id) throws BizException;
	
	/**
	 * 按物品单位类型获取物品计量单位
	 * @param materialUnitDTO 物品包装单位类型信息
	 * @return
	 * @throws BizException
	 */
	public MaterialUnitDTO[] getMMunit(MaterialUnitDTO[] materialUnitDTO) throws BizException;
	
	/**
	 * 按就诊类型获取物品发药单位
	 * @param id_mm 物品主键
	 * @param entp_code 就诊类型
	 * @return
	 * @throws BizException
	 */
	public MaterialUnitDTO[] getMMunitByEntp(String[] id_mms, String entp_code) throws BizException;
	
	/**
	 * 物品价格查询（非收费出库类物品）
	 * @param id_mm 物品主键
	 * @param req_unit_id 请求单位
	 * @return
	 * @throws BizException
	 */
	public GetMaterialPriceDTO getMaterialPrice(String id_mm, String req_unit_id) throws BizException;
	
	/**
	 * 物品价格查询（医技补录医技关联药品价格获取用）
	 * @param id_mm 物品主键
	 * @param req_unit_id 请求单位
	 * @return
	 * @throws BizException
	 */
	public GetMaterialPriceDTO MaterialPriceForOt(String id_mm, String req_unit_id) throws BizException;
	
	/**
	 * 判定物品是否可用
	 * @param mmInuseDTOS 物品和科室信息
	 * @return
	 * @throws BizException
	 */
	public MmInuseInfoDTO[] getMmInuseInfo(MmInuseInfoDTO[] mmInuseDTOS) throws BizException;
	
	/**
	 * 根据通用服务获取物品包装单位信息
	 * @param id_srvs 医疗服务ID
	 * @param entp_code 就诊类型
	 * @return
	 * @throws BizException
	 */
	public MaterialWithPkgInfoDTO[] getMmWithPkgInfoBySrv(String[] id_srvs, String entp_code)throws BizException;
	
	/**
	 * 药品是否是指定分组药品
	 * @param id_mm 药品id
	 * @param sd_mmgrptp 物品分组档案编码
	 * @return
	 * @throws BizException
	 */
	public FBoolean isMmInGrop(String id_mm, String sd_mmgrptp)throws BizException;
}
