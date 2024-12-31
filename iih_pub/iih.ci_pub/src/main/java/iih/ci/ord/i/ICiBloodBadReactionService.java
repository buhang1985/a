package iih.ci.ord.i;

import iih.ci.ord.bloodbadreaction.d.CiBloodAdverseReactionDO;
import iih.ci.ord.cibloodadversereactioncount.d.CiBloodAdverseReactionCountDTO;
import iih.ci.ord.dto.bloodbadreaction.BloodFetchDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 输血不良反应回报服务接口
 * @author yzh
 *
 */
public interface ICiBloodBadReactionService {

	
	public abstract CiBloodAdverseReactionDO create(BloodFetchDTO bfdto) throws BizException ;
	
	/**
	 * 加载输血不良反应回报单数据
	 * @param cbardo
	 * @return
	 */
	public abstract CiBloodAdverseReactionDO[] load(CiBloodAdverseReactionDO cbardo) throws BizException ;
	
	/**
	 * 保存输血不良反应回报单数据
	 * @param cbardo
	 * @return
	 */
	public abstract CiBloodAdverseReactionDO[]  save(CiBloodAdverseReactionDO cbardo) throws BizException ;
	
	/**
	 * 查询输血不良反应统计数据
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiBloodAdverseReactionCountDTO>  qryCountData(QryRootNodeDTO qryRootNodeDTO,PaginationInfo pg) throws BizException;
	
	/**
	 * 根据就诊id获取该次就诊下所有输血不良反应
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	public abstract BloodFetchDTO[] getAllBFData8En(String id_en) throws BizException;
	
	
}
