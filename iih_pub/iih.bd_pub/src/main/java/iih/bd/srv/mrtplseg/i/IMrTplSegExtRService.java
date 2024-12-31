package iih.bd.srv.mrtplseg.i;

import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import iih.mkr.std.dedg.d.DeDataGrpDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 段落模板扩展读取服务接口
 * 
 * @author hao_wu
 *
 */
public interface IMrTplSegExtRService {

	/**
	 * 根据查询方案和所属类型编码分页查询数据
	 * 
	 * @param qryRootNodeDTO
	 *            查询方案
	 * @param sd_Owtp
	 *            所属类型编码
	 * @param orderStr
	 *            排序语句
	 * @param pg
	 *            分页信息
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<MrTplSegmentDO> FindPagingDataByQCondAndOwtp(QryRootNodeDTO qryRootNodeDTO, String sd_Owtp,
			String orderStr, PaginationInfo pg) throws BizException;

	/**
	 * 根据查询方案和数据组分页查询数据
	 * 
	 * @param sdOwtp
	 *            所属类型编码
	 * @param deDataGrpDo
	 *            数据组
	 * @param qryRootNodeDto
	 *            查询方案
	 * @param pg
	 *            分页信息
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<MrTplSegmentDO> FindPagingByQcondAndDataGrp(String sdOwtp, DeDataGrpDO deDataGrpDo,
			QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException;
}
