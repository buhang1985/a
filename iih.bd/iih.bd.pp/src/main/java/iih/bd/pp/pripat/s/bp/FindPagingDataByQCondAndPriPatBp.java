package iih.bd.pp.pripat.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.medsrvrealpriceqry.i.IMedSrvRealPriceQryService;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.bd.pp.pripat.d.PriPatSrvOrCaDO;
import iih.bd.pp.pripat.d.desc.PriPatSrvOrCaDODesc;
import iih.bd.pp.pripat.i.IPriPatSrvOrCaDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 使用查询方案和患者价格分类查询患者价格分类服务项目分页信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingDataByQCondAndPriPatBp {

	public PagingRtnData<PriPatSrvOrCaDO> exec(QryRootNodeDTO qryRootNodeDTO, PriPatDO priPatDO, PaginationInfo pg)
			throws BizException {
		PagingRtnData<PriPatSrvOrCaDO> result = FindPagingDataByQCondAndPriPat(qryRootNodeDTO, priPatDO, pg);

		setSrvStdPri(result.getPageData());

		return result;
	}

	/**
	 * 设置医疗服务标准价格
	 * 
	 * @param pageData
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void setSrvStdPri(FArrayList pageData) throws BizException {
		if (pageData == null || pageData.size() <= 0) {
			return;
		}

		PriPatSrvOrCaDO[] items = (PriPatSrvOrCaDO[]) pageData.toArray(new PriPatSrvOrCaDO[0]);
		String[] srvIds = getSrvIds(items);

		IMedSrvRealPriceQryService priQryService = ServiceFinder.find(IMedSrvRealPriceQryService.class);
		FMap2 srvPriMap = priQryService.FindMedSrvRealPriMapByIds(srvIds);

		for (PriPatSrvOrCaDO priPatSrvOrCaDO : items) {
			String srvId = priPatSrvOrCaDO.getId_srv();
			if (srvPriMap.containsKey(srvId)) {
				priPatSrvOrCaDO.setPri_std((FDouble) srvPriMap.get(srvId));
			}
		}
	}

	/**
	 * 获取医疗服务主键集合
	 * 
	 * @param items
	 * @return
	 */
	private String[] getSrvIds(PriPatSrvOrCaDO[] items) {
		ArrayList<String> srvIdList = new ArrayList<String>();
		for (PriPatSrvOrCaDO priPatSrvOrCaDO : items) {
			srvIdList.add(priPatSrvOrCaDO.getId_srv());
		}
		return srvIdList.toArray(new String[0]);
	}

	/**
	 * 查询
	 * 
	 * @param qryRootNodeDTO
	 * @param priPatDO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<PriPatSrvOrCaDO> FindPagingDataByQCondAndPriPat(QryRootNodeDTO qryRootNodeDTO,
			PriPatDO priPatDO, PaginationInfo pg) throws BizException {
		String wherePart = GetWherePart(qryRootNodeDTO, priPatDO);
		PagingRtnData<PriPatSrvOrCaDO> result = GetPagingData(wherePart, pg);
		return result;
	}

	/**
	 * 使用查询方案和患者价格分类生成条件语句
	 * 
	 * @param qryRootNodeDTO
	 * @param priPatDO
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDTO, PriPatDO priPatDO) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		if (qryRootNodeDTO != null) {
			String wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO, PriPatSrvOrCaDODesc.CLASS_FULLNAME);
			if (!StringUtils.isEmpty(wherePart)) {
				wherePartBuilder.append(" AND (");
				wherePartBuilder.append(wherePart);
				wherePartBuilder.append(") ");
				String transit = wherePartBuilder.toString();
				transit = transit.replace("dt_e = 'Y'", "dt_e = '2099-12-31 23:59:59'");
				transit = transit.replace("dt_e = 'N'", "dt_e <> '2099-12-31 23:59:59'");
				wherePartBuilder = new StringBuilder(transit);
			}
		}

		if (priPatDO != null) {
			String wherePart = String.format("Id_pripat = '%s'", priPatDO.getId_pripat());
			wherePartBuilder.append(" AND (");
			wherePartBuilder.append(wherePart);
			wherePartBuilder.append(") ");
		}

		return wherePartBuilder.toString();
	}

	/**
	 * 使用查询方案生成条件语句
	 * 
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithDesc(qryRootNodeDTO,
				new PriPatSrvOrCaDO().getDODesc());
		return wherePart;
	}

	/**
	 * 查询分页数据
	 * 
	 * @param wherePart
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<PriPatSrvOrCaDO> GetPagingData(String wherePart, PaginationInfo pg) throws BizException {
		IPriPatSrvOrCaDORService priPatSrvOrCaDORService = ServiceFinder.find(IPriPatSrvOrCaDORService.class);
		PagingRtnData<PriPatSrvOrCaDO> result = priPatSrvOrCaDORService.findByPageInfo(pg, wherePart,
				"Createdtime desc");
		return result;
	}

}
