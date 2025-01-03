package iih.bd.fc.s;

import iih.bd.fc.dto.qrymatch.d.QryMatchCondDTO;
import iih.bd.fc.dto.qrymatch.d.QryRefListDTO;
import iih.bd.fc.dto.qryorwf.d.QryOrWfCondDTO;
import iih.bd.fc.dto.qryorwf.d.QryOrWfResDTO;
import iih.bd.fc.dto.shortselect.d.CardCondDTO;
import iih.bd.fc.dto.shortselect.d.SelectedDTO;
import iih.bd.fc.i.IBdFcQryService;
import iih.bd.fc.orpltpconfig.d.OrpltpDTO;
import iih.bd.fc.orpltpconfig.d.OrpltpStaDTO;
import iih.bd.fc.orwf.d.EntpWfDTO;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.orwf.s.bp.GetEntpWfBp;
import iih.bd.fc.orwfovalchk.d.OrWfOvalChkOrDTO;
import iih.bd.fc.orwfovalchk.d.OrWfOvalChkRltDTO;
import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueRuleItmDO;
import iih.bd.fc.querule.s.bp.RuleMatchBP;
import iih.bd.fc.s.bp.GetExDeptInfo8DepIdBP;
import iih.bd.fc.s.bp.GetOrExDept4OpenModeBP;
import iih.bd.fc.s.bp.batwfexdept.GetOrExDeptBatchBP;
import iih.bd.fc.s.bp.orpltpconfig.GetOrpltpInfoByIdBp;
import iih.bd.fc.s.bp.orpltpconfig.GetOrpltpStaInfoByIdBp;
import iih.bd.fc.s.bp.orwfcfg.match.OrWfCfgFlowEntryBp;
import iih.bd.fc.s.bp.orwfcfg.query.OrWfCfgQueryBp;
import iih.bd.fc.s.bp.orwfovalchk.GetOrWfOvalChkRltBp;
import iih.bd.fc.s.bp.qrymatch.OrptpMatchQueryBp;
import iih.bd.fc.s.bp.shortselect.GetShortSelectListBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

@Service(serviceInterfaces = { IBdFcQryService.class }, binding = Binding.JSONRPC)
public class BdFcQryServiceImpl implements IBdFcQryService {

	/**
	 * 获得医嘱开立模式医嘱的执行科室列表
	 */
	@Override
	public OrWfExDeptDTO[] getOrExDept4OpenMode(OrWfExDeptParamDTO param) throws BizException {
		GetOrExDept4OpenModeBP bp = new GetOrExDept4OpenModeBP();
		return bp.exec(param);
	}

	/**
	 * 根据部门Id计算出执行部门信息
	 */
	@Override
	public OrWfExDeptDTO getExDeptInfo8DepId(String id_dept) throws BizException {
		GetExDeptInfo8DepIdBP bp = new GetExDeptInfo8DepIdBP();
		return bp.exec(id_dept);
	}

	/**
	 * （新版逻辑）单个医嘱流向计算
	 */
	@Override
	public OrWfExDeptDTO[] getOrExDeptMainBP(OrWfExDeptParamDTO param) throws BizException {
		OrWfCfgFlowEntryBp bp = new OrWfCfgFlowEntryBp();
		return bp.singleMatch(param);
	}

	/**
	 * （新版逻辑）批量医嘱流向计算
	 */
	@Override
	public OrWfExDeptParamDTO[] getBatchOrExDeptMainBP(OrWfExDeptParamDTO[] params) throws BizException {
		OrWfCfgFlowEntryBp bp = new OrWfCfgFlowEntryBp();
		return bp.batchMatch(params);
	}

	/**
	 * 批量 获得医嘱执行、物资流向科室
	 */
	@Override
	public OrWfExDeptParamDTO[] getOrExDeptBatchBP(OrWfExDeptParamDTO[] params) throws BizException {
		GetOrExDeptBatchBP bp = new GetOrExDeptBatchBP();
		return bp.exec(params);
	}

	/**
	 * 获取医嘱闭环信息
	 */
	@Override
	public OrpltpDTO getOrpltpInfoById(String id_orpltp) throws BizException {
		GetOrpltpInfoByIdBp bp = new GetOrpltpInfoByIdBp();
		return bp.exec(id_orpltp);
	}

	/**
	 * 获取医嘱闭环状态信息
	 */
	@Override
	public OrpltpStaDTO getOrpltpStaInfoById(String id_orpltpsta) throws BizException {
		GetOrpltpStaInfoByIdBp bp = new GetOrpltpStaInfoByIdBp();
		return bp.exec(id_orpltpsta);
	}

	/**
	 * 验证是否符合队列规则
	 * 
	 * @param quebenTp
	 * @param ruleItm
	 * @param priDTO
	 * @return
	 */
	public boolean IsMatchRulesMatchRule(String quebenTp, QueRuleItmDO ruleItm, PriorityDTO priDTO) {
		RuleMatchBP bp = new RuleMatchBP();
		return bp.isMatchRule(quebenTp, ruleItm, priDTO);
	}

	/**
	 * 获取医嘱流向整体校验结果
	 */
	@Override
	public OrWfOvalChkRltDTO[] getOrWfOvalChkRlt(OrWfOvalChkOrDTO[] params) throws BizException {
		GetOrWfOvalChkRltBp bp = new GetOrWfOvalChkRltBp();
		return bp.exec(params);
	}

	/**
	 * 获取快捷选择待选列表
	 */
	@Override
	public PagingRtnData<SelectedDTO> getShortSelectList(PaginationInfo pg, CardCondDTO cond) throws BizException {
		GetShortSelectListBp bp = new GetShortSelectListBp();
		return bp.exec(pg, cond);
	}

	/**
	 * 查询医嘱流向
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@Override
	public QryOrWfResDTO[] queryOrWf(QryOrWfCondDTO cond) throws BizException {
		OrWfCfgQueryBp bp = new OrWfCfgQueryBp();
		return bp.exec(cond);
	}

	/**
	 * 获取获取医嘱流向配置2.0树的数据源
	 */
	@Override
	public EntpWfDTO[] getEntpWfDTO() throws BizException {
		GetEntpWfBp bp = new GetEntpWfBp();
		return bp.exec();
	}
	
	/**
	 * 查询医嘱闭环匹配
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@Override
	public QryRefListDTO[] queryMatch(QryMatchCondDTO cond) throws BizException {
		OrptpMatchQueryBp bp = new OrptpMatchQueryBp();
		return bp.exec(cond);
	}
}
