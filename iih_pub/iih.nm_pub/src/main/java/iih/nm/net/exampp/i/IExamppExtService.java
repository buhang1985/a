package iih.nm.net.exampp.i;

import xap.mw.core.data.BizException;
import iih.nm.net.exampp.d.ExamppSecDO;
import iih.nm.net.examppmanagedto.d.ExamPPManageDTO;
import iih.nm.net.examqu.d.ExamQuDO;
import iih.nm.net.examquescontral.d.ExamPPDTO;

public interface IExamppExtService {

	/**
	 * 根据试卷ID查询试卷DTO
	 * 
	 * @param id_pp
	 * @return
	 * @throws BizException
	 */
	public abstract ExamPPManageDTO findById(String id_pp) throws BizException;

	/**
	 * 根据试卷DTO保存试卷相应DO
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public abstract ExamPPManageDTO save(ExamPPManageDTO dto) throws BizException;

	/**
	 * 根据试卷查询试卷预览数据
	 * 
	 * @param id_pp
	 *            试卷id
	 * @return
	 * @throws BizException
	 */
	public abstract ExamPPDTO getExamPPDTO(String id_pp) throws BizException;

	/**
	 * 自动抽题
	 * 
	 * @param id_ppsec
	 *            段落id
	 * @param id_qus
	 *            试题id集合
	 * @return
	 * @throws BizException
	 */
	public abstract ExamQuDO[] AutoExtract(ExamppSecDO ppsecDO, String[] id_qus) throws BizException;
}
