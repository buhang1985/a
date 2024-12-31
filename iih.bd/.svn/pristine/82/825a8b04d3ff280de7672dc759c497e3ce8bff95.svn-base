package iih.bd.srv.mrtplseg.s;

import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import iih.bd.srv.mrtplseg.i.IMrTplSegExtRService;
import iih.bd.srv.mrtplseg.s.bp.FindPagingByQcondAndDataGrpBp;
import iih.bd.srv.mrtplseg.s.bp.FindPagingDataByQCondAndOwtpBp;
import iih.mkr.std.dedg.d.DeDataGrpDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 段落模板扩展读取服务
 * 
 * @author hao_wu
 *
 */
public class MrTplSegExtRServiceImpl implements IMrTplSegExtRService {

	@Override
	public PagingRtnData<MrTplSegmentDO> FindPagingDataByQCondAndOwtp(QryRootNodeDTO qryRootNodeDTO, String sd_Owtp,
			String orderStr, PaginationInfo pg) throws BizException {
		FindPagingDataByQCondAndOwtpBp bp = new FindPagingDataByQCondAndOwtpBp();
		PagingRtnData<MrTplSegmentDO> result = bp.exec(qryRootNodeDTO, sd_Owtp, orderStr, pg);
		return result;
	}

	@Override
	public PagingRtnData<MrTplSegmentDO> FindPagingByQcondAndDataGrp(String sdOwtp, DeDataGrpDO deDataGrpDo,
			QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException {
		FindPagingByQcondAndDataGrpBp bp = new FindPagingByQcondAndDataGrpBp();
		PagingRtnData<MrTplSegmentDO> result = bp.exec(sdOwtp, deDataGrpDo, qryRootNodeDto, pg);
		return result;
	}
}
