package iih.bd.srv.urgentsrv.s;

import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.srv.urgentsrv.d.UrgentSrvDTO;
import iih.bd.srv.urgentsrv.i.IUrgentSrvExtCudService;
import iih.bd.srv.urgentsrv.i.IUrgentSrvExtRService;
import iih.bd.srv.urgentsrv.s.bp.SaveUrgentSrvBp;
import iih.bd.srv.urgentsrv.s.bp.DeleteUrgentSrvBp;
import iih.bd.srv.urgentsrv.s.bp.FindPagingUrgentSrvByEntpBp;
import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 加急服务项目服务
 * 
 * @author hao_wu 2020-1-7
 *
 */
public class UrgentSrvExtCrudServiceImpl implements IUrgentSrvExtCudService, IUrgentSrvExtRService {

	@Override
	public PagingRtnData<UrgentSrvDTO> findPagingUrgentSrvByEntp(PaginationInfo pageInfo, EnTypeDO enTypeDo,
			QryRootNodeDTO qryRootNodeDTO, String whereStr, SqlParamDTO sqlParamDTO, String orderStr)
			throws BizException {
		FindPagingUrgentSrvByEntpBp bp = new FindPagingUrgentSrvByEntpBp();
		PagingRtnData<UrgentSrvDTO> rtnData = bp.exec(pageInfo, enTypeDo, qryRootNodeDTO, whereStr, sqlParamDTO,
				orderStr);
		return rtnData;
	}

	@Override
	public void deleteUrgentSrv(EnTypeDO enTypeDo, UrgentSrvDTO[] urgentSrvDtos) throws BizException {
		DeleteUrgentSrvBp bp = new DeleteUrgentSrvBp();
		bp.exec(enTypeDo, urgentSrvDtos);
	}

	@Override
	public void saveUrgentSrv(EnTypeDO enTypeDo, UrgentSrvDTO[] urgentSrvDtos) throws BizException {
		SaveUrgentSrvBp bp = new SaveUrgentSrvBp();
		bp.exec(enTypeDo, urgentSrvDtos);
	}

}
