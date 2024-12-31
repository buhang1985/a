package iih.mp.orm.sugnuremp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import iih.mp.orm.sugnuremp.d.SugNurEmpDTO;
import iih.mp.orm.sugnuremp.d.SugempDTO;
import iih.mp.orm.sugnuremp.qry.GetSugNurWorkWorkSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 手术护士工作量统计查询
 * 
 * @author tian.cjFounder
 * @version 2020-01-15 10:11:11
 */
public class QrySugNurWorkInfoBp {

	/**
	 * 主入口
	 * 
	 * @param id_dept_exec
	 *            执行科室
	 * @param dt_st_op
	 *            手术开始时间
	 * @param dt_ed_op
	 *            手术结束时间
	 * @return
	 * @throws BizException
	 */
	public List<SugNurEmpDTO> exec(String id_dept_exec, String dt_st_op, String dt_ed_op) throws BizException {

		// 1、校验
		validation(dt_st_op, dt_ed_op);

		// 2、查询护士工作记录数据
		List<SugempDTO> sugemps = qrySugEmp(id_dept_exec, dt_st_op, dt_ed_op);

		// 3、组装数据
		List<SugNurEmpDTO> listPage = packageRtns(sugemps);

		return listPage;
	}
	/**
	 * 校验
	 * 
	 * @param dt_st_op
	 * @param dt_ed_op
	 * @throws BizException
	 */
	private void validation(String dt_st_op, String dt_ed_op) throws BizException {
		if (dt_st_op.compareTo(dt_ed_op) > 0) {
			throw new BizException("开始时间不能大于结束时间！");
		}
	}

	/**
	 * 查询护士工作记录数据
	 * 
	 * @param id_dept_exec
	 * @param dt_st_op
	 * @param dt_ed_op
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<SugempDTO> qrySugEmp(String id_dept_exec, String dt_st_op, String dt_ed_op) throws BizException {
		if (!StringUtil.isEmptyWithTrim(dt_st_op)) {
			dt_st_op = dt_st_op + " 00:00:00";
		}
		if (!StringUtil.isEmptyWithTrim(dt_ed_op)) {
			dt_ed_op = dt_ed_op + " 23:59:59";
		}
		GetSugNurWorkWorkSql sql = new GetSugNurWorkWorkSql(id_dept_exec, dt_st_op, dt_ed_op);
		List<SugempDTO> list = (List<SugempDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(SugempDTO.class));
		return list;
	}

	/**
	 * 组装数据
	 * 
	 * @param sugemps
	 * @return
	 * @throws BizException
	 */
	private List<SugNurEmpDTO> packageRtns(List<SugempDTO> sugemps) throws BizException {
		List<SugNurEmpDTO> list = new ArrayList<SugNurEmpDTO>();
		Map<String, SugNurEmpDTO> map = new HashMap<String, SugNurEmpDTO>();
		if (sugemps != null && sugemps.size() > 0) {
			for (SugempDTO sugDO : sugemps) {
				String key = sugDO.getId_dept_exec() + sugDO.getId_emp();

				if (!map.containsKey(key)) {
					SugNurEmpDTO sugnurEmpDTO = new SugNurEmpDTO();
					sugnurEmpDTO.setSuglv(0);
					sugnurEmpDTO.setSuglv1(0);
					sugnurEmpDTO.setSuglv2(0);
					sugnurEmpDTO.setSuglv3(0);
					sugnurEmpDTO.setSuglv4(0);
					sugnurEmpDTO.setDep_name(sugDO.getId_dep_name());// 科室名称
					sugnurEmpDTO.setSug_nur_name(sugDO.getSug_nur_name());// 手术护士名称
					changeMapData(sugnurEmpDTO, sugDO);
					map.put(key, sugnurEmpDTO);
				} else {
					SugNurEmpDTO sugnurEmpDTO = map.get(key);
					changeMapData(sugnurEmpDTO, sugDO);
				}
			}
		}

		for (Entry<String, SugNurEmpDTO> entry : map.entrySet()) {
			list.add(entry.getValue());
		}

		return list;
	}

	/**
	 * 给手术级别赋值
	 * 
	 * @param sugnurEmpDTO
	 * @param sugDO
	 */
	private void changeMapData(SugNurEmpDTO sugnurEmpDTO, SugempDTO sugDO) {
		if ("@@@@AA1000000004IXQP".equals(sugDO.getId_lvlsug())) {
			sugnurEmpDTO.setSuglv1(sugDO.getSug_num()); // 一级手术
		}

		if ("@@@@AA1000000004IXQQ".equals(sugDO.getId_lvlsug())) {
			sugnurEmpDTO.setSuglv2(sugDO.getSug_num()); // 二级手术
		}

		if ("@@@@AA1000000004IXQR".equals(sugDO.getId_lvlsug())) {
			sugnurEmpDTO.setSuglv3(sugDO.getSug_num()); // 三级手术
		}

		if ("@@@@AA1000000004IXQS".equals(sugDO.getId_lvlsug())) {
			sugnurEmpDTO.setSuglv4(sugDO.getSug_num()); // 四级手术
		}

		if (StringUtil.isEmptyWithTrim(sugDO.getId_lvlsug())) {
			sugnurEmpDTO.setSuglv(sugDO.getSug_num()); // 其它手术
		}
	}

}