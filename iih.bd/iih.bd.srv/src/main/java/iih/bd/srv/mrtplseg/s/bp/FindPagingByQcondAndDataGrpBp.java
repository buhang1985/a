package iih.bd.srv.mrtplseg.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import iih.bd.srv.mrtplseg.d.desc.MrTplSegmentDODesc;
import iih.bd.srv.mrtplseg.i.IMrtplsegRService;
import iih.mkr.std.dedg.d.DeDataGrpDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据查询方案和数据组分页查询数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingByQcondAndDataGrpBp {

	public PagingRtnData<MrTplSegmentDO> exec(String sdOwtp, DeDataGrpDO deDataGrpDo, QryRootNodeDTO qryRootNodeDto,
			PaginationInfo pg) throws BizException {
		if (StringUtils.isEmpty(sdOwtp)) {
			throw new BizException("所属类型不允许为空。");
		}

		PagingRtnData<MrTplSegmentDO> result = FindPagingByQcondAndDataGrp(sdOwtp, deDataGrpDo, qryRootNodeDto, pg);
		return result;
	}

	/**
	 * 根据查询方案和数据组查询分页数据
	 * 
	 * @param sdOwtp
	 * @param deDataGrpDo
	 * @param qryRootNodeDto
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<MrTplSegmentDO> FindPagingByQcondAndDataGrp(String sdOwtp, DeDataGrpDO deDataGrpDo,
			QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException {
		String wherePart = BuildWherePart(sdOwtp, deDataGrpDo, qryRootNodeDto);
		String orderStr = "code";
		PagingRtnData<MrTplSegmentDO> result = FindPageData(pg, wherePart, orderStr);
		return result;
	}

	/**
	 * 查询分页数据
	 * 
	 * @param pg
	 * @param wherePart
	 * @param orderStr
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<MrTplSegmentDO> FindPageData(PaginationInfo pg, String wherePart, String orderStr)
			throws BizException {
		IMrtplsegRService mrtplsegRService = ServiceFinder.find(IMrtplsegRService.class);
		PagingRtnData<MrTplSegmentDO> result = mrtplsegRService.findByPageInfo(pg, wherePart, orderStr);
		return result;
	}

	/**
	 * 构建条件语句
	 * 
	 * @param sdOwtp
	 * @param deDataGrpDo
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String BuildWherePart(String sdOwtp, DeDataGrpDO deDataGrpDo, QryRootNodeDTO qryRootNodeDto)
			throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = String.format(" and sd_owtp = '%s'", sdOwtp);
		wherePartBuilder.append(wherePart);

		if (deDataGrpDo != null) {
			wherePart = String.format(" and Id_dg = '%s'", deDataGrpDo.getId_dg());
			wherePartBuilder.append(wherePart);
		}

		wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto, MrTplSegmentDODesc.CLASS_FULLNAME);
		if (StringUtils.isNotEmpty(wherePart)) {
			String tmplStr = String.format(" and (%s) ", wherePart);
			wherePartBuilder.append(tmplStr);
		}

		if (sdOwtp.equals(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT)) {
			wherePart = String.format(" and Id_dep = '%s'", Context.get().getDeptId());
			wherePartBuilder.append(wherePart);
		} else if (sdOwtp.equals(IBdSrvDictCodeConst.SD_OWTP_PERSONAL)) {
			wherePart = String.format(" and Id_emp = '%s'", Context.get().getUserId());
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}
}
