package iih.pis.ivx.train.i;

import javax.servlet.http.HttpServletRequest;

import iih.pis.ivx.pisivxcurriculum.dto.d.PisivxCurriculumDTO;
import iih.pis.ivx.pisivxratingchart.dto.d.PisivxRatingChartDTO;
import iih.pis.ivx.pisivxreginfo.dto.d.PisivxReginfoDTO;
import iih.pis.ivx.pisivxtrainsat.dto.d.PisivxTrainSatDTO;
import xap.mw.core.data.BizException;

public interface ITrainService {
	/*
	 * 课程列表
	 */
	public abstract PisivxCurriculumDTO[] trainCurriculum(String id_courseplan) throws BizException;
	/*
	 * 课程信息，包括个人签到
	 */
	public abstract PisivxCurriculumDTO[] trainCourseinfo(String id_net_trainmgr_crs, String id_pisivxaccount) throws BizException;
	
	/*
	 * 签到信息
	 */
	public abstract PisivxReginfoDTO trainRegInfo(String id_net_trainmgr_crs, String id_pisivxaccount) throws BizException;
	/*
	 * 满意度
	 */
	public abstract PisivxTrainSatDTO trainSurveyInfo(String id_net_trainmgr_crs, String id_pisivxaccount) throws BizException;
	/*
	 * 签到
	 */
	public abstract String trainReg(HttpServletRequest request) throws BizException;
	
	/*
	 * 签退
	 */
	public abstract String trainUnreg(HttpServletRequest request) throws BizException;
	
	/*
	 * 培训满意度填写
	 */
	public abstract String trainSurvey(HttpServletRequest request) throws BizException;
	
	/*
	 * 满意度提交
	 */
	public abstract String transRating(HttpServletRequest request) throws BizException;

	/*
	 * 满意度统计图
	 */
	public abstract PisivxRatingChartDTO[] transRatingChart(HttpServletRequest request) throws BizException;
}
