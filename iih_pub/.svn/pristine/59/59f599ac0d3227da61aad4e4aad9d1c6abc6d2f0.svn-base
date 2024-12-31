package iih.mkr.std.commonde.i;

import iih.mkr.std.commonde.d.DataElementDO;
import iih.mkr.std.de.d.DeDTO;
import iih.mkr.std.deca.d.DataElemCateDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 公共数据元扩展服务接口
 * 
 * @author hao_wu
 *
 */
public interface ICommondeExtRService {
	/**
	 * 使用查询方案、数据元分类类型、数据元分类查询分页数据
	 * 
	 * @param pg
	 * @param qryRootNodeDto
	 * @param udidocDo
	 * @param dataElemCateDo
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<DataElementDO> findByQCondAndDeCaTpAndDeCaAndPageInfo(PaginationInfo pg,
			QryRootNodeDTO qryRootNodeDto, UdidocDO udidocDo, DataElemCateDO dataElemCateDo) throws BizException;

	/**
	 * 使用查询方案、医疗记录类型和数据组查询公共数据元分页数据
	 * 
	 * @param pg
	 * @param qryRootNodeDto
	 * @param mrTpId
	 * @param dataGrpId
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<DataElementDO> FindPagingByQCondAndMrtpAndDg(PaginationInfo pg, QryRootNodeDTO qryRootNodeDto,
			String mrTpId, String dataGrpId) throws BizException;

	/**
	 * 根据数据集主键和查询方案查询数据元DTO分页数据
	 * 
	 * @param dataSetId      数据集主键
	 * @param qryRootNodeDTO 查询方案
	 * @param orderStr       排序语句
	 * @param pg             分页信息
	 * @return 分页数据
	 * @throws BizException
	 */
	public PagingRtnData<DeDTO> findPagingDtoBySetIdAndQryNode(String dataSetId, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException;

	/**
	 * 更新数据元信息到数据元DTO</br>
	 * 前台选择已有数据元后，更新数据元相关信息
	 * 
	 * @param deDtos
	 * @return
	 * @throws BizException
	 */
	public DeDTO[] updateDe2DeDto(DeDTO[] deDtos) throws BizException;
}
