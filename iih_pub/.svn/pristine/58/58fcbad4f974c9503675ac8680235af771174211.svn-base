package iih.nm.net.i;

import iih.nm.net.dto.netmessagenotifiydto.d.NetMessageNotifiyDTO;
import iih.nm.net.exam.d.ExamDO;
import iih.nm.net.examppmanagedto.d.ExamPPManageDTO;
import iih.nm.net.examqu.d.ExamquAggDO;
import iih.nm.net.examquca.d.ExamQuCaDO;
import iih.nm.net.examquescontral.d.ExamPPDTO;
import iih.nm.net.examquescontral.d.ExamQuDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

public interface INmNetMaintainService {

	/**
	 * 保存试题信息
	 * 
	 * @param aggDO
	 * @param structDTO
	 * @return
	 * @throws BizException
	 */
	public ExamquAggDO saveExamQu(ExamquAggDO aggDO, ExamQuDTO structDTO) throws BizException;

	/**
	 * 保存试卷信息
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public abstract ExamPPManageDTO saveExamPP(ExamPPManageDTO dto) throws BizException;

	/**
	 * 人员考试信息保存
	 * 
	 * @param id_psndocs
	 * @param examDO
	 * @throws BizException
	 */
	public abstract ExamDO saveExam(String[] id_psndocs, ExamDO examDO) throws BizException;

	/**
	 * 删除人员考试信息
	 * 
	 * @param id_exam
	 * @throws BizException
	 */
	public abstract void deleteExamApp(String id_exam) throws BizException;

	/**
	 * 在线考试保存（包含暂存和交卷）
	 * 
	 * @param examPPDTO
	 * @throws BizException
	 */
	public abstract void saveExamApp(ExamPPDTO examPPDTO) throws BizException;
	
	/**
	 * 试题导入
	 * @param examQuCaDO
	 * @param fmap2
	 * @return
	 * @throws BizException
	 */
	public boolean saveImportExamQues(ExamQuCaDO examQuCaDO,FMap2 fmap2) throws BizException;
	/**
	 * 消息通知
	 * @param msgDto
	 * @throws BizException
	 */
	public void generateMsgNotifity(NetMessageNotifiyDTO msgDto) throws BizException;
}
