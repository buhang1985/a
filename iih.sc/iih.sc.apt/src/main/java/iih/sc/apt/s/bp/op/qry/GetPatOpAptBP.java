package iih.sc.apt.s.bp.op.qry;

import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询门诊预约患者已预约信息BP
 * 
 * @author zhengcm
 * @modifier zhengcm 增加集团管控
 *
 */
public class GetPatOpAptBP {

	/**
	 * 查询门诊预约患者已预约信息
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public MtAppDTO[] exec(String patId) throws BizException {
		// 检查参数
		ScValidator.validateParam("patId", patId);

		// 查询数据
		List<MtAppDTO> appDTOList = this.queryDatas(patId);
		if (ListUtil.isEmpty(appDTOList)) {
			return null;
		}

		// 设置日期
		this.setDatePlan(appDTOList);

		return appDTOList.toArray(new MtAppDTO[0]);
	}

	/**
	 * 查询数据
	 *
	 * @param patId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private List<MtAppDTO> queryDatas(String patId) throws BizException {
		SqlParam params = new SqlParam();
		params.addParam(patId);
		params.addParam(ScAppUtils.getServerDateTime().getBeginDate());
		List<MtAppDTO> appDTOList = (List<MtAppDTO>) new DAFacade().execQuery(this.getSql().toString(), params,
				new BeanListHandler(MtAppDTO.class));
		return appDTOList;
	}

	/**
	 * 查询Sql
	 *
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private StringBuilder getSql() throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("apt.id_apt,");
		sb.append("pl.name as name_scpl,");
		sb.append("sch.d_sch,");
		sb.append("apt.queno ");
		sb.append("from ");
		sb.append("sc_apt_op op ");
		sb.append("inner join sc_apt apt on apt.id_apt = op.id_apt ");
		sb.append("inner join sc_sch sch on sch.id_sch = apt.id_sch ");
		sb.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		sb.append("where ");
		sb.append("apt.id_pat = ? ");
		sb.append("and apt.fg_canc = 'N' ");
		sb.append("and sch.d_sch >= ?");
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScAptDO(), "apt"));
		sb.append("order by sch.d_sch");
		return sb;
	}

	/**
	 * 设置日期（以便显示格式化）
	 *
	 * @param appDTOList
	 * @throws BizException
	 * @author zhengcm
	 */
	private void setDatePlan(List<MtAppDTO> appDTOList) throws BizException {
		if (ListUtil.isEmpty(appDTOList)) {
			return;
		}
		for (MtAppDTO appDTO : appDTOList) {
			appDTO.setDt_plan(new FDateTime(appDTO.getD_sch() + " 00:00:00"));
		}
	}
}
