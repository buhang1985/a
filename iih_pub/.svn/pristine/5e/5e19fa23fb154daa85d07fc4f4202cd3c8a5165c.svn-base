package iih.bd.fc.i;

import iih.bd.fc.dto.qrymatch.d.QryMatchCondDTO;
import iih.bd.fc.dto.qrymatch.d.QryRefListDTO;
import iih.bd.fc.dto.qryorwf.d.QryOrWfCondDTO;
import iih.bd.fc.dto.qryorwf.d.QryOrWfResDTO;
import iih.bd.fc.dto.shortselect.d.CardCondDTO;
import iih.bd.fc.dto.shortselect.d.SelectedDTO;
import iih.bd.fc.orpltpconfig.d.OrpltpDTO;
import iih.bd.fc.orpltpconfig.d.OrpltpStaDTO;
import iih.bd.fc.orwf.d.EntpWfDTO;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.orwfovalchk.d.OrWfOvalChkOrDTO;
import iih.bd.fc.orwfovalchk.d.OrWfOvalChkRltDTO;
import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueRuleItmDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public interface IBdFcQryService {
	/**
	 * 获得医嘱开立模式医嘱的执行科室列表 （将废弃不用了）
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract OrWfExDeptDTO[] getOrExDept4OpenMode(OrWfExDeptParamDTO param) throws BizException;

	/**
	 * 根据部门Id计算出执行部门信息
	 * 
	 * @param id_dept
	 * @return
	 * @throws BizException
	 */
	public abstract OrWfExDeptDTO getExDeptInfo8DepId(String id_dept) throws BizException;

	/**
	 * 单个 获得医嘱流向执行科室算法逻辑（含物资流向科室算法） （最新的算法）
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract OrWfExDeptDTO[] getOrExDeptMainBP(OrWfExDeptParamDTO param) throws BizException;
	
	/**
	 * （新版逻辑）批量医嘱流向计算
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract OrWfExDeptParamDTO[] getBatchOrExDeptMainBP(OrWfExDeptParamDTO[] params) throws BizException;

	/**
	 * （旧版逻辑）批量 获得医嘱流向执行科室算法逻辑（含物资流向科室算法）
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract OrWfExDeptParamDTO[] getOrExDeptBatchBP(OrWfExDeptParamDTO[] params) throws BizException;

	/**
	 * 获取医嘱闭环信息
	 * 
	 * @param id_orpltp
	 * @return
	 * @throws BizException
	 */
	public abstract OrpltpDTO getOrpltpInfoById(String id_orpltp) throws BizException;

	/**
	 * 获取医嘱闭环状态信息
	 * 
	 * @param id_orpltpsta
	 * @return
	 * @throws BizException
	 */
	public abstract OrpltpStaDTO getOrpltpStaInfoById(String id_orpltpsta) throws BizException;
	/**
	 * 验证是否符合队列规则
	 * @param quebenTp
	 * @param ruleItm
	 * @param priDTO
	 * @return
	 */
	public boolean IsMatchRulesMatchRule(String quebenTp, QueRuleItmDO ruleItm, PriorityDTO priDTO);
	
	/**
	 * 获取医嘱流向整体校验结果
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract OrWfOvalChkRltDTO[] getOrWfOvalChkRlt(OrWfOvalChkOrDTO[] params) throws BizException;

	/**
	 * 获取快捷选择待选列表
	 * 
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<SelectedDTO> getShortSelectList(PaginationInfo pg, CardCondDTO cond) throws BizException;

	/**
	 * 查询医嘱流向
	 * 
	 * @param params
	 * @return
	 * @throws BizException	
	 */
	public abstract QryOrWfResDTO[] queryOrWf(QryOrWfCondDTO cond) throws BizException;

	/**
	 * 获取获取医嘱流向配置2.0树的数据源
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract EntpWfDTO[] getEntpWfDTO() throws BizException;
	
	/**
	 * 查询医嘱匹配
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public QryRefListDTO[] queryMatch(QryMatchCondDTO cond) throws BizException ;
}
