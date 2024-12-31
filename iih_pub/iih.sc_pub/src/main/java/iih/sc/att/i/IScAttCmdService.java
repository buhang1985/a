package iih.sc.att.i;

import java.util.Map;

import iih.sc.att.dto.d.AttExecDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 考勤命令服务
 * 
 * @author yank
 * @author ccj
 * 
 */
public interface IScAttCmdService {
	/**
	 * 新增个人排班
	 * 
	 * @param id_pl
	 *            计划di
	 * @param id_emp
	 *            人员id
	 * @param id_peri
	 *            区间id
	 * @param id_taskexec
	 *            执行id
	 * @param beginDate
	 *            考试时间
	 * @param endDate
	 *            结束时间
	 */
	public void addExecByEmp(String id_pl, String id_emp, String id_peri, String id_taskexec, FDate beginDate, FDate endDate) throws BizException;

	/**
	 * 考勤排班
	 * 
	 * @param id_dep
	 *            部门id
	 * @param id_taskpl
	 *            计划id
	 * @param xdaysStrs
	 *            排班日期
	 * @param id_peri
	 *            区间id
	 * @param d_b
	 *            开始日期
	 * @param d_e
	 *            结束日期
	 * @param note
	 *            备注
	 * @return 返回已经发布了的考勤执行名称，不能删除
	 * @throws BizException
	 */
	public Map<String, Object> addSctaskexecemp(String id_dep, String id_taskpl, String[] xdaysStrs, String id_peri, String d_b, String d_e, String note, String code, String name, FBoolean fBoolean)
			throws BizException;

	/**
	 * 删除考勤计划
	 * 
	 * @param attPlId
	 *            考勤计划ID
	 * @throws BizException
	 */
	void deletePl(String attPlId) throws BizException;

	/**
	 * 生成考勤执行
	 * 
	 * @param attExecDTO
	 *            考勤执行DTO
	 * @return
	 * @throws BizException
	 */
	String generateAttExec(AttExecDTO attExecDTO) throws BizException;

	/**
	 * 生成个人考勤执行
	 * 
	 * @param attExecDTO
	 * @throws BizException
	 */
	void genPersonalAttExec(AttExecDTO attExecDTO) throws BizException;
}
