package iih.bd.srv.urgentsrv.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.srv.medsrv.d.MedSrvAttrMaping;
import iih.bd.srv.urgentsrv.d.UrgentSrvDTO;
import iih.bd.srv.urgentsrv.s.bp.qry.FindUrgentSrvQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据就诊类型查询分页加急服务项目
 * 
 * @author hao_wu 2020-1-7
 *
 */
public class FindPagingUrgentSrvByEntpBp {

	public PagingRtnData<UrgentSrvDTO> exec(PaginationInfo pageInfo, EnTypeDO enTypeDo, QryRootNodeDTO qryRootNodeDTO,
			String whereStr, SqlParamDTO sqlParamDTO, String orderStr) throws BizException {

		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		if (StringUtils.isNotBlank(whereStr)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(whereStr);
		}

		if (qryRootNodeDTO != null) {
			IQrySQLGeneratorService sqlGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
			FArrayList list = sqlGeneratorService.getQueryFieldValue(qryRootNodeDTO, "bd_srv.fg_urgent_def");
			if (list != null && list.size() > 0) {
				FBoolean fg_urgent_def = (FBoolean) list.get(0);
				String defUrgentAttrName = MedSrvAttrMaping.getDefUrgentAttrName(enTypeDo.getCode());
				String wherePart = String.format(" and %s = '%s'", defUrgentAttrName, fg_urgent_def);
				wherePartBuilder.append(wherePart);
			}
		}

		String wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO);
		if (StringUtils.isNotBlank(wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		FindUrgentSrvQry qry = new FindUrgentSrvQry(enTypeDo, wherePartBuilder.toString(), sqlParamDTO, orderStr);

		PagingServiceImpl<UrgentSrvDTO> pagingServiceImpl = new PagingServiceImpl<>();
		PagingRtnData<UrgentSrvDTO> rtnData = pagingServiceImpl.findByPageInfo(new UrgentSrvDTO(), pageInfo,
				qry.getQrySQLStr(), null, qry.getQryParameter(null));
		return rtnData;
	}
}
