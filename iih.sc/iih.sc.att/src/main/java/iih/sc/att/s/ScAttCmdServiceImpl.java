package iih.sc.att.s;

import java.util.Map;

import iih.sc.att.dto.d.AttExecDTO;
import iih.sc.att.i.IScAttCmdService;
import iih.sc.att.s.bp.AddExecByEmpBp;
import iih.sc.att.s.bp.AddSctaskexeceBp;
import iih.sc.att.s.bp.DeleteAttPlBP;
import iih.sc.att.s.bp.GenPersonalAttExecBP;
import iih.sc.att.s.bp.GenerateAttExecBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 考勤命令服务实现
 * 
 * @author ccj
 * 
 */
@Service(serviceInterfaces = { IScAttCmdService.class }, binding = Binding.JSONRPC)
public class ScAttCmdServiceImpl implements IScAttCmdService {
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
	@Override
	public void addExecByEmp(String id_pl, String id_emp, String id_peri, String id_taskexec, FDate beginDate, FDate endDate) throws BizException {
		AddExecByEmpBp addExecByEmpBp = new AddExecByEmpBp();
		addExecByEmpBp.exec(id_pl, id_emp, id_peri, id_taskexec, beginDate, endDate);
	}

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
	@Override
	public Map<String, Object> addSctaskexecemp(String id_dep, String id_taskpl, String[] xdaysStrs, String id_peri, String d_b, String d_e, String note, String code, String name, FBoolean fBoolean)
			throws BizException {

		AddSctaskexeceBp addSctaskexeceBp = new AddSctaskexeceBp();
		Map<String, Object> map = addSctaskexeceBp.exec(id_dep, id_taskpl, xdaysStrs, id_peri, d_b, d_e, note, code, name, fBoolean);
		return map;
	}

	/**
	 * 删除考勤计划
	 * 
	 * @param attPlId
	 *            考勤计划ID
	 * @throws BizException
	 */
	@Override
	public void deletePl(String attPlId) throws BizException {
		DeleteAttPlBP deleteBP = new DeleteAttPlBP();
		deleteBP.exec(attPlId);
	}

	/**
	 * 生成考勤执行
	 * 
	 * @param attExecDTO
	 *            考勤执行DTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public String generateAttExec(AttExecDTO attExecDTO) throws BizException {
		GenerateAttExecBP generateBP = new GenerateAttExecBP();
		return generateBP.exec(attExecDTO);
	}

	/**
	 * 生成个人考勤执行
	 * 
	 * @param attExecDTO
	 * @throws BizException
	 */
	@Override
	public void genPersonalAttExec(AttExecDTO attExecDTO) throws BizException {
		GenPersonalAttExecBP gegBP = new GenPersonalAttExecBP();
		gegBP.exec(attExecDTO);
	}
}
