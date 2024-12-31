package iih.nm.net.i;

import iih.nm.net.examlogin.d.ExamLoginDTO;
import iih.nm.net.exammanagedto.d.ExamManageDTO;
import iih.nm.net.exampp.d.ExamppSecDO;
import iih.nm.net.examppmanagedto.d.ExamPPManageDTO;
import iih.nm.net.examppqurule.d.ExamppQuruleDO;
import iih.nm.net.examqu.d.ExamQuDO;
import iih.nm.net.examquca.d.ExamQuCaDO;
import iih.nm.net.examquerydto.d.ExamQueryDTO;
import iih.nm.net.examquescontral.d.ExamPPDTO;
import iih.nm.net.examquescontral.d.ExamQuDTO;
import iih.nm.net.gradequerydto.d.GradeQueryDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface INmNetQueryService {

	/**
	 * 获取试题结构
	 * 
	 * @param id_qu
	 * @return
	 * @throws BizException
	 */
	public abstract ExamQuDTO findExamQuDTOByQu(String id_qu) throws BizException;

	/**
	 * 获取试题分类集合
	 * 
	 * @param id_qu
	 * @return
	 * @throws BizException
	 */
	public abstract ExamQuCaDO[] FindCaDOByQu(String id_qu) throws BizException;

	/**
	 * 获取试卷信息
	 * 
	 * @param id_pp
	 * @return
	 * @throws BizException
	 */
	public abstract ExamPPManageDTO findExamPPManageDTOByPP(String id_pp) throws BizException;

	/**
	 * 自动抽题
	 * 
	 * @param ppsecDO
	 * @param id_qus
	 * @return
	 * @throws BizException
	 */
	public abstract ExamQuDO[] autoExtractQu(ExamppQuruleDO[] ruleDos, String[] id_qus) throws BizException;

	/**
	 * 获取试卷预览结构
	 * 
	 * @param id_pp
	 * @return
	 * @throws BizException
	 */
	public abstract ExamPPDTO findExamPPDTOByPP(String id_pp) throws BizException;

	/**
	 * 获取考试控件结构和数据
	 * 
	 * @param loginDTO
	 * @return
	 * @throws BizException
	 */
	public abstract ExamPPDTO findExamPPDTOByLogin(ExamLoginDTO loginDTO) throws BizException;

	/**
	 * 查询非考试人员及部门
	 * 
	 * @param examId
	 * @param fg_left
	 * @return
	 * @throws BizException
	 */
	public abstract ExamManageDTO[] findTreeData(String examId, FBoolean fg_left) throws BizException;

	/**
	 * 分页查询试题（含查询模板）
	 * 
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param id_qu_ca
	 * @param orderStr
	 * @param isLazy
	 * @return
	 */
	public abstract PagingRtnData<ExamQuDO> findExamQusByQCondAndPageInfo(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String id_qu_ca,String sd_Status, String orderStr, FBoolean isLazy) throws BizException;

	/**
	 * 查询考试
	 * 
	 * @param sqlwhere
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<ExamQueryDTO> findExamQuery(QryRootNodeDTO qryRootNodeDTO, PaginationInfo pg) throws BizException;
	
	/**
	 * 查询考试成绩
	 * 
	 * @param sqlwhere
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<GradeQueryDTO> findExamGrade(QryRootNodeDTO qryRootNodeDTO, PaginationInfo pg) throws BizException;

	/**
	 * （考试成绩）试卷预览
	 * 
	 * @param loginDTO
	 * @return
	 * @throws BizException
	 */
	public abstract ExamPPDTO findExamPPDTOByExamAndPsn(String id_exam, String id_psndoc) throws BizException;

}
