package iih.bd.srv.medsrv.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据服务分类和查询方案查询医疗服务分页信息业务逻辑
 * 
 * @author hao_wu 2019-2-19
 *
 */
public class FindPagingByTpsAndCaAndQCondBp {

	public PagingRtnData<MedSrvDO> exec(String[] srvTpCodes, SrvCateDO srvCateDo, QryRootNodeDTO qryRootNodeDto,
			String orderStr, PaginationInfo pg) throws BizException {

		String wherePart = getWherePart(srvTpCodes, srvCateDo, qryRootNodeDto);

		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		PagingRtnData<MedSrvDO> result = medsrvMDORService.findByPageInfo(pg, wherePart, orderStr);

		SetRealPri(result);

		return result;
	}

	/**
	 * 构建条件语句
	 * 
	 * @param srvCateDo
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String getWherePart(String[] srvTpCodes, SrvCateDO srvCateDo, QryRootNodeDTO qryRootNodeDto)
			throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		if (ArrayUtils.isNotEmpty(srvTpCodes)) {
			ArrayList<String> wherePartList = new ArrayList<String>();
			for (String srvtpCode : srvTpCodes) {
				String wherePart = String.format("sd_srvtp like '%s%%'", srvtpCode);
				wherePartList.add(wherePart);
			}
			String wherePart = String.format("(%s)", StringUtils.join(wherePartList, " or "));
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		if (srvCateDo != null) {
			String wherePart = String.format(
					"id_srvca in (select id_srvca from bd_srvca where innercode like '%s%%' and %s)",
					srvCateDo.getInnercode(), BdEnvContextUtil.processEnvContext(new SrvCateDO(), false));
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		if (qryRootNodeDto != null) {
			String wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto, MedSrvDODesc.CLASS_FULLNAME);
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

	/**
	 * 设置定价模式为本服务定价的服务价格
	 * 
	 * @param result
	 * @throws BizException
	 */
	private void SetRealPri(PagingRtnData<MedSrvDO> result) throws BizException {
		MedSrvDO[] medSrvArr = getMedSrvArr(result);
		SetRealPriBp bp = new SetRealPriBp();
		bp.exec(medSrvArr);
	}

	/**
	 * 获取分页数据数组
	 * 
	 * @param result
	 * @return
	 */
	private MedSrvDO[] getMedSrvArr(PagingRtnData<MedSrvDO> result) {
		FArrayList pagedataList = result.getPageData();
		@SuppressWarnings("unchecked")
		MedSrvDO[] medSrvArr = (MedSrvDO[]) pagedataList.toArray(new MedSrvDO[pagedataList.size()]);
		return medSrvArr;
	}
}
