package iih.nm.net.examappqu.i;

import iih.nm.net.examlogin.d.ExamLoginDTO;
import iih.nm.net.examquescontral.d.ExamPPDTO;
import xap.mw.core.data.BizException;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2017年6月9日 上午11:29:31
 * 类说明：在线考试扩展服务
 * Company: Copyright 2017 by PKU healthcare IT Co.,Ltd.
 */
public interface IExamappquExtService {
	
	/**
	 * 查询考试试卷结构
	 * @param logindto  登陆DTO
	 * @return 考试试卷DTO
	 * @throws BizException
	 */
	public abstract ExamPPDTO findExamPPDTO(ExamLoginDTO logindto) throws BizException;
	
	/**
	 * 保存考试结果
	 * @param examPPDTO
	 * @throws BizException
	 */
	public abstract void saveExamPPDTO(ExamPPDTO examPPDTO) throws BizException;

}
