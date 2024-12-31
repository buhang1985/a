package iih.ci.ord.s.ems.op.bloodbadreaction;

import iih.ci.ord.bloodbadreaction.d.CiBloodAdverseReactionDO;
import iih.ci.ord.cibloodadversereactioncount.d.CiBloodAdverseReactionCountDTO;
import iih.ci.ord.dto.bloodbadreaction.BloodFetchDTO;
import iih.ci.ord.s.ems.op.bloodbadreaction.bp.BloodBadReactionCountBP;
import iih.ci.ord.s.ems.op.bloodbadreaction.bp.BloodBadReactionCreatBP;
import iih.ci.ord.s.ems.op.bloodbadreaction.bp.BloodFetchCreateBP;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 输血不良反应回报单
 * @author yzh
 *
 */
public class BloodBadReactionAction {
	/**
	 * 创建输血不良反应回报单数据
	 * @param bfdto
	 * @return
	 */
	public CiBloodAdverseReactionDO create(BloodFetchDTO bfdto) throws BizException{
		BloodBadReactionCreatBP bp = new BloodBadReactionCreatBP();
		return bp.exec(bfdto);
	}
	
	/**
	 * 加载输血不良反应回报单数据
	 * @param cbardo
	 * @return
	 */
	public CiBloodAdverseReactionDO[] load(CiBloodAdverseReactionDO cbardo) throws BizException{
		return null;
	}
	/**
	 * 加载输血不良反应回报单数据
	 * @param cbardo
	 * @return
	 */
	public CiBloodAdverseReactionDO[] loadById(String id_ar) throws BizException{
		return null;
	}
	/**
	 * 保存输血不良反应回报单数据
	 * @param cbardo
	 * @return
	 */
	public CiBloodAdverseReactionDO[]  save(CiBloodAdverseReactionDO cbardo) throws BizException{
		return null;
	}
	/**
	 * 查询输血不良反应统计数据
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<CiBloodAdverseReactionCountDTO> qryCountData(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg)
			throws BizException {
		BloodBadReactionCountBP bp = new BloodBadReactionCountBP();
		//orderStr = " order by blood.report_time desc";
		return bp.qryCountData(qryRootNodeDTO, orderStr, pg);
	}

	/**
	 * 根据就诊id获取该次就诊所有输血不良反应
	 * @param id_en
	 * @return
	 * @throws BizException 
	 */
	public BloodFetchDTO[] getAllBFData8En(String id_en) throws BizException {
		BloodFetchCreateBP bp = new BloodFetchCreateBP();
		return bp.exec(id_en);
	}

}
