package iih.en.pv.s;

import iih.en.comm.ep.EntStateEP;
import iih.en.pv.dto.d.EnEntBankaccDTO;
import iih.en.pv.dto.d.EntHisDiDTO;
import iih.en.pv.dto.d.EntInfoDTO;
import iih.en.pv.dto.d.EntQryModDTO;
import iih.en.pv.dto.d.OutpatientQryDTO;
import iih.en.pv.enclin.d.EntStateDO;
import iih.en.pv.enfee.d.EntAccActDO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.i.IEnPvQryService;
import iih.en.pv.s.bp.CheckIsHpPatBP;
import iih.en.pv.s.bp.EntInfoQryBP;
import iih.en.pv.s.bp.GetAccAdjListBP;
import iih.en.pv.s.bp.GetEnDiListBP;
import iih.en.pv.s.bp.GetEnEntBlankaccBp;
import iih.en.pv.s.bp.GetEntAccActListBP;
import iih.en.pv.s.bp.GetEntDepListBP;
import iih.en.pv.s.bp.GetEntDiListBP;
import iih.en.pv.s.bp.GetEntEmpListBP;
import iih.en.pv.s.bp.GetHisEntDiListBP;
import iih.en.pv.s.bp.ip.GetBalanceBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 就诊查询服务
 * 
 * @author yank
 *
 */
@Service(serviceInterfaces = { IEnPvQryService.class }, binding = Binding.JSONRPC)
public class EnPvQryServiceImpl implements IEnPvQryService {
	/**
	 * 获取就诊诊断列表
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EntDiDO[] getEnDiList(String entId) throws BizException {
		GetEnDiListBP getBP = new GetEnDiListBP();
		return getBP.exec(entId);
	}

	/**
	 * 获取就诊信息
	 * 
	 * @param entId 就诊id
	 * @return
	 */
	public EntInfoDTO getEntInfo(String entId) throws BizException {
		EntInfoQryBP bp = new EntInfoQryBP();
		return bp.getEntInfo(entId);
	}

	/**
	 * 查询门诊就诊信息
	 * 
	 * @param qryModDTO 查询模型
	 * @return 就诊DO集合
	 * @throws BizException
	 */
	public OutpatientQryDTO[] getPvList(EntQryModDTO qryModDTO) throws BizException {
		EntInfoQryBP queryBP = new EntInfoQryBP();
		return queryBP.getPvDOList(qryModDTO);
	}

	/**
	 * 加载价格信息，包括医保计划、价格分类
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	public OutpatientQryDTO loadPriInfo(String entId) throws BizException {
		EntInfoQryBP queryBP = new EntInfoQryBP();
		return queryBP.loadPriInfo(entId);
	}

	/**
	 * 获取就诊诊断记录
	 * 
	 * @param entId 就诊id
	 * @return 就诊记录集合
	 * @throws BizException
	 */
	public EntDiDO[] getEntDiList(String entId) throws BizException {
		GetEntDiListBP getBP = new GetEntDiListBP();
		return getBP.exec(entId);
	}

	/**
	 * 获取就诊科室
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	public EnDepDO[] getEntDepList(String entId) throws BizException {
		GetEntDepListBP getBP = new GetEntDepListBP();
		return getBP.exec(entId);
	}

	/**
	 * 获取患者的历史就诊诊断记录
	 * 
	 * @param patCode 患者编码
	 * @param withDetail 是否包含明细
	 * @return
	 * @throws BizException
	 */
	public EntHisDiDTO[] getHisEntDiList(String patCode, FBoolean withDetail) throws BizException {
		GetHisEntDiListBP getHisDiBP = new GetHisEntDiListBP();
		return getHisDiBP.exec(patCode, FBoolean.TRUE, withDetail, null);
	}

	/**
	 * 获取就诊医护人员
	 * 
	 * @param entId 就诊id
	 * @param roleTp 角色类型，如果为空，则是查询全部
	 * @return
	 * @throws BizException
	 */
	public EnPsnDO[] getEntEmpList(String entId, String roleTp) throws BizException {
		GetEntEmpListBP getBP = new GetEntEmpListBP();
		return getBP.exec(entId, roleTp);
	}

	/**
	 * 是否是医保患者
	 * 
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean isHpPat(String patId) throws BizException {
		CheckIsHpPatBP checkBP = new CheckIsHpPatBP();
		return checkBP.isHpPat(patId);
	}

	/**
	 * 获取就诊账户信息 信用额度=患者信用分类的信用额度+就诊账户的信用额度
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public BalanceDTO getBalance(String entId) throws BizException {
		GetBalanceBP getBlBP = new GetBalanceBP();
		return getBlBP.exec(entId);
	}

	/**
	 * 获取就在账户操作明细集合
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 * @author zcm
	 */
	public PagingRtnData<EntAccActDO> getEntAccActList(String entId, PaginationInfo pg)
			throws BizException {
		GetEntAccActListBP getAccActBP = new GetEntAccActListBP();
		return getAccActBP.exec(pg, entId);
	}
	/**
	 * 信用度调整记录查询
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<EntAccActDO> getAccAdjList(QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException {
		GetAccAdjListBP adjBp = new GetAccAdjListBP();
		return adjBp.exec(qryRootNodeDTO, orderStr, pg);
	}
	/**
	 * 获取就诊状况
	 * 
	 * @param entId
	 * @param patId
	 * @param codeEntp
	 * @return
	 * @throws BizException
	 */
	@Override
	public EntStateDO[] getEntstates(String entId, String patId, String codeEntp)
			throws BizException {
		EntStateEP ep = new EntStateEP();
		return ep.getEntstates(entId, patId, codeEntp);
	}

	/**
	 * 获取患者银行账户历史记录
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnEntBankaccDTO[] getEnEntBankaccHis(String idPat) throws BizException {
		GetEnEntBlankaccBp bp = new GetEnEntBlankaccBp();
		return bp.getEnEntBankaccHis(idPat);
	}
}
