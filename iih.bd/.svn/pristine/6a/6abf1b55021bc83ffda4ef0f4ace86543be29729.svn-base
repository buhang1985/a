package iih.bd.mm.meterial.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据查询方案和物品分类查询物品分页信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingByQCondAndMmCaBp {

	public PagingRtnData<MeterialDO> exec(QryRootNodeDTO qryRootNodeDto, MMCategoryDO mmCategoryDo, String sdMmtp,
			String orderPart, PaginationInfo pg) throws BizException {
		String wherePart = GetWherePart(qryRootNodeDto, mmCategoryDo, sdMmtp);
		PagingRtnData<MeterialDO> result = FindPagingByWherePart(wherePart, orderPart, pg);
		return result;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param qryRootNodeDto
	 * @param mmCategoryDo
	 * @param sdMmtp
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDto, MMCategoryDO mmCategoryDo, String sdMmtp)
			throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto, MeterialDODesc.CLASS_FULLNAME);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		if (mmCategoryDo != null) {
			wherePart = String.format(
					" and Id_mmca in (select Id_mmca from bd_mmca where %s and innercode like '%s%%')",
					BdEnvContextUtil.processEnvContext(new MMCategoryDO(), "bd_mmca"), mmCategoryDo.getInnercode());
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotEmpty(sdMmtp)) {
			wherePart = String.format(" and sd_mmtp like '%s%%'", sdMmtp);
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

	/**
	 * 根据条件语句查询物品分页数据
	 * 
	 * @param wherePart
	 * @param orderPart
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<MeterialDO> FindPagingByWherePart(String wherePart, String orderPart, PaginationInfo pg)
			throws BizException {
		IMeterialMDORService meterialMDORService = ServiceFinder.find(IMeterialMDORService.class);
		PagingRtnData<MeterialDO> result = meterialMDORService.findByPageInfo(pg, wherePart, orderPart);
		return result;
	}
}
