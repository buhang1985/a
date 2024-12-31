package iih.bd.mm.meterial.s.bp;

import org.apache.commons.lang.NullArgumentException;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 使用查询方案和物品分类查询物品分页数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingDataByQCondAndMmCaIdsBp {

	public PagingRtnData<MeterialDO> exec(QryRootNodeDTO qryRootNodeDTO, String[] mmCaIds, String sd_Mmtp,
			PaginationInfo pg) throws BizException {
		if (pg == null) {
			throw new NullArgumentException("pg");
		}

		String wherePart = BuildWherePart(qryRootNodeDTO, mmCaIds, sd_Mmtp);
		PagingRtnData<MeterialDO> rtn = GetPagingData(wherePart, pg);

		return rtn;
	}

	/**
	 * 获取分页数据
	 * 
	 * @param wherePart
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<MeterialDO> GetPagingData(String wherePart, PaginationInfo pg) throws BizException {
		IMeterialMDORService meterialMDORService = ServiceFinder.find(IMeterialMDORService.class);
		String orderPart = "code";
		PagingRtnData<MeterialDO> rtn = meterialMDORService.findByPageInfo(pg, wherePart, orderPart);
		return rtn;
	}

	/**
	 * 构建条件语句
	 * 
	 * @param qryRootNodeDTO
	 * @param mmCa
	 * @return
	 * @throws BizException
	 */
	private String BuildWherePart(QryRootNodeDTO qryRootNodeDTO, String[] mmCaIds, String sd_Mmtp) throws BizException {
		String tempStr;
		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("1 = 1");

		if (sd_Mmtp != null && !sd_Mmtp.equals("")) {
			tempStr = String.format(" and id_mmca in (select id_mmca from bd_mmca where sd_mmtp like '%s%%')", sd_Mmtp);
			wherePartBuilder.append(tempStr);
		}

		String queryNodeWherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO, MeterialDO.class.getName());
		if (queryNodeWherePart != null && !queryNodeWherePart.equals("")) {
			tempStr = String.format(" and %s", queryNodeWherePart);
			wherePartBuilder.append(tempStr);
		}

		if (mmCaIds != null && mmCaIds.length > 0) {
			String whereInPart = SqlUtils.getInSqlByIds(MeterialDO.ID_MMCA, mmCaIds);
			if (whereInPart != null && !whereInPart.equals("")) {
				tempStr = String.format(" and %s", whereInPart);
				wherePartBuilder.append(tempStr);
			}
		}
		return wherePartBuilder.toString();
	}
}
