package iih.bd.srv.emrtpl.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.d.desc.EmrTplDODesc;
import iih.bd.srv.emrtpl.i.IEmrtplMDORService;
import iih.bd.srv.mrctmca.d.MrCaCtmItmDO;
import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据查询方案和医疗模板分类查询医疗记录模板分页信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingByQcondAndMrCtmCaBp {

	public PagingRtnData<EmrTplDO> exec(String sdOwtp, MrCtmCaDO mrCtmCaDo, MrCaCtmItmDO mrCaCtmItmDo,
			QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException {
		if (StringUtils.isEmpty(sdOwtp)) {
			throw new BizException("所属类型编码不允许为空。");
		}
		PagingRtnData<EmrTplDO> result = FindPagingByQcondAndMrCtmCa(sdOwtp, mrCtmCaDo, mrCaCtmItmDo, qryRootNodeDto,
				pg);
		return result;
	}

	/**
	 * 根据查询方案和医疗模板分类查询医疗记录模板分页信息
	 * 
	 * @param sdOwtp
	 * @param mrCtmCaDo
	 * @param mrCaCtmItmDo
	 * @param qryRootNodeDto
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<EmrTplDO> FindPagingByQcondAndMrCtmCa(String sdOwtp, MrCtmCaDO mrCtmCaDo,
			MrCaCtmItmDO mrCaCtmItmDo, QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException {
		String wherePart = GetWherePart(sdOwtp, mrCtmCaDo, mrCaCtmItmDo, qryRootNodeDto);
		String orderPart = "orderid";
		PagingRtnData<EmrTplDO> result = FindPagingData(wherePart, orderPart, pg);
		return result;
	}

	/**
	 * 查询分页数据
	 * 
	 * @param wherePart
	 * @param orderPart
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<EmrTplDO> FindPagingData(String wherePart, String orderPart, PaginationInfo pg)
			throws BizException {
		IEmrtplMDORService emrtplMDORService = ServiceFinder.find(IEmrtplMDORService.class);
		PagingRtnData<EmrTplDO> result = emrtplMDORService.findByPageInfo(pg, wherePart, orderPart);
		return result;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param sdOwtp
	 * @param mrCtmCaDo
	 * @param mrCaCtmItmDo
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(String sdOwtp, MrCtmCaDO mrCtmCaDo, MrCaCtmItmDO mrCaCtmItmDo,
			QryRootNodeDTO qryRootNodeDto) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder();

		String wherePart = String.format("sd_owtp = '%s'", sdOwtp);
		wherePartBuilder.append(wherePart);

		if (mrCtmCaDo != null) {
			wherePart = String.format(" and id_mrtp in (select id_mrtp from bd_mrca_ctm_itm where id_mrcactm = '%s')",
					mrCtmCaDo.getId_mrcactm());
			wherePartBuilder.append(wherePart);
		}

		if (mrCaCtmItmDo != null) {
			wherePart = String.format(" and id_mrtp = '%s'", mrCaCtmItmDo.getId_mrtp());
			wherePartBuilder.append(wherePart);
		}

		wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto, EmrTplDODesc.CLASS_FULLNAME);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		if (sdOwtp.equals(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT)) {
			wherePart = String.format(" and Id_dept = '%s'", Context.get().getDeptId());
			wherePartBuilder.append(wherePart);
		} else if (sdOwtp.equals(IBdSrvDictCodeConst.SD_OWTP_PERSONAL)) {
			wherePart = String.format(" and Id_emp = '%s'", Context.get().getUserId());
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}

}
