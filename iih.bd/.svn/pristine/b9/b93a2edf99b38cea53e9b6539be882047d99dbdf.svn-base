package iih.bd.srv.mrtplseg.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import iih.bd.srv.mrtplseg.i.IMrtplsegRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据查询方案和所属类型编码分页查询段落模板业务逻辑
 * 
 * @author Administrator
 *
 */
public class FindPagingDataByQCondAndOwtpBp {

	public PagingRtnData<MrTplSegmentDO> exec(QryRootNodeDTO qryRootNodeDTO, String sd_Owtp, String orderStr,
			PaginationInfo pg) throws BizException {

		String wherePart = BuildWherePart(qryRootNodeDTO, sd_Owtp);
		IMrtplsegRService mrtplsegRService = ServiceFinder.find(IMrtplsegRService.class);
		PagingRtnData<MrTplSegmentDO> result = mrtplsegRService.findByPageInfo(pg, wherePart, orderStr);

		return result;
	}

	/**
	 * 构建条件语句
	 * 
	 * @param qryRootNodeDTO
	 * @param sd_Owtp
	 * @return
	 * @throws BizException
	 */
	private String BuildWherePart(QryRootNodeDTO qryRootNodeDTO, String sd_Owtp) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		wherePartBuilder.append(" and Fg_active = 'Y' ");

		String wherePart = GetQueryNodeWherePart(qryRootNodeDTO);
		if (wherePart != null) {
			String tmplStr = String.format(" and (%s) ", wherePart);
			wherePartBuilder.append(tmplStr);
		}
		if (sd_Owtp.equals(IBdSrvDictCodeConst.SD_OWTP_HOSPIAL)) {
			wherePart = String.format(" and sd_owtp = '%s' and id_org = '%s'", sd_Owtp, Context.get().getOrgId());
			wherePartBuilder.append(wherePart);
		} else if (sd_Owtp.equals(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT)) {
			wherePart = String.format(" and ((sd_owtp = '%s' and id_org = '%s') or (sd_owtp = '%s' and Id_dep = '%s'))",
					IBdSrvDictCodeConst.SD_OWTP_HOSPIAL, Context.get().getOrgId(), sd_Owtp, Context.get().getDeptId());
			wherePartBuilder.append(wherePart);
		} else if (sd_Owtp.equals(IBdSrvDictCodeConst.SD_OWTP_PERSONAL)) {
			wherePart = String.format(
					" and ((sd_owtp = '%s' and id_org = '%s') or (sd_owtp = '%s' and Id_dep = '%s') or (sd_owtp = '%s' and Id_emp = '%s'))",
					IBdSrvDictCodeConst.SD_OWTP_HOSPIAL, Context.get().getOrgId(),
					IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT, Context.get().getDeptId(), sd_Owtp,
					Context.get().getUserId());
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}

	/**
	 * 使用QueryNode生成条件语句
	 * 
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String GetQueryNodeWherePart(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithDOName(qryRootNodeDTO,
				MrTplSegmentDO.class.getName());
		return wherePart;
	}

}
