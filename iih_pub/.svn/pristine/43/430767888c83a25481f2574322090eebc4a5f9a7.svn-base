package iih.en.pv.i;

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
import xap.mw.core.data.BizException;
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
public interface IEnPvQryService {
	/**
	 * 获取就诊信息
	 * 
	 * @param entId 就诊id
	 * @return
	 */
	EntInfoDTO getEntInfo(String entId) throws BizException;

	/**
	 * 查询就诊信息
	 * 
	 * @param qryModDTO 查询模型
	 * @return 就诊DO集合
	 * @throws BizException
	 */
	OutpatientQryDTO[] getPvList(EntQryModDTO qryModDTO) throws BizException;

	/**
	 * 加载价格信息，包括医保计划、价格分类
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	OutpatientQryDTO loadPriInfo(String entId) throws BizException;

	/**
	 * 获取就诊诊断列表
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	EntDiDO[] getEnDiList(String entId) throws BizException;

	/**
	 * 获取患者的历史就诊诊断记录
	 * 
	 * @param patCode 患者编码
	 * @param withDetail 是否包含明细
	 * @return
	 * @throws BizException
	 */
	EntHisDiDTO[] getHisEntDiList(String patCode, FBoolean withDetail) throws BizException;

	/**
	 * 获取就诊科室
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	EnDepDO[] getEntDepList(String entId) throws BizException;

	/**
	 * 获取就诊医护人员
	 * 
	 * @param entId 就诊id
	 * @param roleTp 角色类型，如果为空，则是查询全部
	 * @return
	 * @throws BizException
	 */
	EnPsnDO[] getEntEmpList(String entId, String roleTp) throws BizException;

	/**
	 * 是否是医保患者
	 * 
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	FBoolean isHpPat(String patId) throws BizException;

	/**
	 * 获取就诊账户信息 信用额度=患者信用分类的信用额度+就诊账户的信用额度
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 * @author yank
	 */
	BalanceDTO getBalance(String entId) throws BizException;

	/**
	 * 获取就在账户操作明细集合
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 * @author zcm
	 */
	PagingRtnData<EntAccActDO> getEntAccActList(String entId, PaginationInfo pg)
			throws BizException;
	/**
	 * 信用度调整记录查询
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<EntAccActDO> getAccAdjList(QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException ;
	/**
	 * 获取就诊状况
	 * 
	 * @param entId
	 * @param patId
	 * @param codeEntp
	 * @return
	 * @throws BizException
	 */
	EntStateDO[] getEntstates(String entId, String patId, String codeEntp) throws BizException;
	
	/**
	 * 获取患者银行账户历史记录
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	EnEntBankaccDTO[] getEnEntBankaccHis(String idPat) throws BizException;
}
