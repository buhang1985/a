package iih.bd.mm.meterial.s;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDOExtCudService;
import iih.bd.mm.meterial.i.IMeterialMDOExtRService;
import iih.bd.mm.meterial.s.bp.DisableMaterialBp;
import iih.bd.mm.meterial.s.bp.EnableMaterialBp;
import iih.bd.mm.meterial.s.bp.FindPagingByQCondAndMmCaBp;
import iih.bd.mm.meterial.s.bp.FindPagingDataByMmCaIdsBp;
import iih.bd.mm.meterial.s.bp.FindPagingDataByQCondAndMmCaIdsBp;
import iih.bd.mm.meterial.s.bp.FindPagingDataByQCondBp;
import iih.bd.mm.meterial.s.bp.GetRefPriceBp;
import iih.bd.mm.meterial.s.bp.GetRefSalePriceBp;
import iih.bd.mm.meterial.s.bp.MaterialCloseBp;
import iih.bd.mm.meterial.s.bp.MaterialOpenBp;
import iih.bd.mm.meterial.s.bp.MaterialOpenPlBp;
import iih.bd.mm.meterial.s.bp.MaterialOpenTrBp;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 物品基本信息主DO扩展查询服务
 * 
 * @author hao_wu
 *
 */
public class MeterialMDOExtCrudServiceImpl implements IMeterialMDOExtRService, IMeterialMDOExtCudService {

	@Override
	public PagingRtnData<MeterialDO> FindPagingDataByQCondAndMmCaIds(QryRootNodeDTO qryRootNodeDTO, String[] mmCaIds,
			String sd_Mmtp, PaginationInfo pg) throws BizException {
		FindPagingDataByQCondAndMmCaIdsBp bp = new FindPagingDataByQCondAndMmCaIdsBp();
		PagingRtnData<MeterialDO> result = bp.exec(qryRootNodeDTO, mmCaIds, sd_Mmtp, pg);
		return result;
	}

	@Override
	public PagingRtnData<MeterialDO> FindPagingDataByQCond(QryRootNodeDTO qryRootNodeDTO, String sd_Mmtp,
			PaginationInfo pg) throws BizException {
		FindPagingDataByQCondBp bp = new FindPagingDataByQCondBp();
		PagingRtnData<MeterialDO> result = bp.exec(qryRootNodeDTO, sd_Mmtp, pg);
		return result;
	}

	@Override
	public PagingRtnData<MeterialDO> FindPagingDataByMmCaIds(String[] mmCaIds, String sd_Mmtp, PaginationInfo pg)
			throws BizException {
		FindPagingDataByMmCaIdsBp bp = new FindPagingDataByMmCaIdsBp();
		PagingRtnData<MeterialDO> result = bp.exec(mmCaIds, sd_Mmtp, pg);
		return result;
	}

	@Override
	public MeterialDO[] Open(MeterialDO[] materials) throws BizException {
		MaterialOpenBp bp = new MaterialOpenBp();
		MeterialDO[] result = bp.exec(materials);
		return result;
	}

	@Override
	public MeterialDO[] Close(MeterialDO[] materials) throws BizException {
		MaterialCloseBp bp = new MaterialCloseBp();
		MeterialDO[] result = bp.exec(materials);
		return result;
	}

	@Override
	public MeterialDO[] Enable(MeterialDO[] materials) throws BizException {
		EnableMaterialBp bp = new EnableMaterialBp();
		return bp.exec(materials);
	}

	@Override
	public MeterialDO[] Disable(MeterialDO[] materials) throws BizException {
		DisableMaterialBp bp = new DisableMaterialBp();
		return bp.exec(materials);
	}

	@Override
	public PagingRtnData<MeterialDO> FindPagingByQCondAndMmCa(QryRootNodeDTO qryRootNodeDto, MMCategoryDO mmCategoryDo,
			String sdMmtp, String orderPart, PaginationInfo pg) throws BizException {
		FindPagingByQCondAndMmCaBp bp = new FindPagingByQCondAndMmCaBp();
		PagingRtnData<MeterialDO> result = bp.exec(qryRootNodeDto, mmCategoryDo, sdMmtp, orderPart, pg);
		return result;
	}

	@Override
	public FMap getRefPrice(String[] mmIds, String[] reqUnitIds) throws BizException {
		GetRefPriceBp bp = new GetRefPriceBp();
		FMap refPriceMap = bp.exec(mmIds, reqUnitIds);
		return refPriceMap;
	}

	@Override
	public FMap getRefSalePrice(String[] mmIds) throws BizException {
		GetRefSalePriceBp bp = new GetRefSalePriceBp();
		FMap refSalePriceMap = bp.exec(mmIds);
		return refSalePriceMap;
	}

	@Override
	public MeterialDO[] openPl(MeterialDO[] materials) throws BizException {
		MaterialOpenPlBp bp = new MaterialOpenPlBp();
		return bp.exec(materials, false);
	}

	@Override
	public MeterialDO[] closePl(MeterialDO[] materials) throws BizException {
		MaterialOpenPlBp bp = new MaterialOpenPlBp();
		return bp.exec(materials, true);
	}

	@Override
	public MeterialDO[] openTr(MeterialDO[] materials) throws BizException {
		MaterialOpenTrBp bp = new MaterialOpenTrBp();
		return bp.exec(materials, false);
	}

	@Override
	public MeterialDO[] closeTr(MeterialDO[] materials) throws BizException {
		MaterialOpenTrBp bp = new MaterialOpenTrBp();
		return bp.exec(materials, true);
	}
}
