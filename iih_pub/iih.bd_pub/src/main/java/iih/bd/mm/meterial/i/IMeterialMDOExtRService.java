package iih.bd.mm.meterial.i;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 物品基本信息主DO扩展查询服务接口
 * 
 * @author hao_wu
 *
 */
public interface IMeterialMDOExtRService {

	/**
	 * 使用查询方案和物品分类查询物品分页数据
	 * 
	 * @param qryRootNodeDTO 查询方案
	 * @param mmCa           物品分类
	 * @param orderStr       排序语句
	 * @param pg             分页信息
	 * @return 分页数据
	 * @throws BizException
	 */
	public abstract PagingRtnData<MeterialDO> FindPagingDataByQCondAndMmCaIds(QryRootNodeDTO qryRootNodeDTO,
			String[] mmCaIds, String sd_Mmtp, PaginationInfo pg) throws BizException;

	/**
	 * 使用查询方案查询物品分页数据
	 * 
	 * @param qryRootNodeDTO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<MeterialDO> FindPagingDataByQCond(QryRootNodeDTO qryRootNodeDTO, String sd_Mmtp,
			PaginationInfo pg) throws BizException;

	/**
	 * 使用物品分类Id查询物品分页数据
	 * 
	 * @param mmCaIds
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<MeterialDO> FindPagingDataByMmCaIds(String[] mmCaIds, String sd_Mmtp,
			PaginationInfo pg) throws BizException;

	/**
	 * 根据查询方案和物品分类查询物品分页信息
	 * 
	 * @param qryRootNodeDto 查询方案
	 * @param mmCategoryDo   物品分类
	 * @param sdMmtp         物品类型编码
	 * @param orderPart      排序语句
	 * @param pg             分页信息
	 * @return
	 */
	public abstract PagingRtnData<MeterialDO> FindPagingByQCondAndMmCa(QryRootNodeDTO qryRootNodeDto,
			MMCategoryDO mmCategoryDo, String sdMmtp, String orderPart, PaginationInfo pg) throws BizException;

	/**
	 * 获取药品指定单位的参考价格
	 * 
	 * @param mmId      物品主键
	 * @param reqUnitId 请求单位主键
	 * @return 参考价格字典[物品主键_请求单位主键,参考价格]
	 * @throws BizException
	 */
	public FMap getRefPrice(String[] mmIds, String[] reqUnitIds) throws BizException;

	/**
	 * 获取药品指定单位的参考零售价格
	 * 
	 * @param mmId 物品主键
	 * @return 参考零售价格[物品主键,参考零售价格]
	 * @throws BizException
	 */
	public FMap getRefSalePrice(String[] mmIds) throws BizException;
}
