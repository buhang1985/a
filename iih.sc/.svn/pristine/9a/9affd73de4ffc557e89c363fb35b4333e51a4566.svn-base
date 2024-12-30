package iih.sc.apt.s.bp.mt;

import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 检查申请单已经预约
 * 
 * @author zcm
 *
 */
public class CheckHasMtAptBP {
	/**
	 * 检查申请单已经预约
	 * 
	 * @param appNo 申请单号
	 * @return FBoolean
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public FBoolean exec(String appNo) throws BizException {
		// 检查参数
		ScValidator.validateParam("appNo", appNo);

		// 查询Sql
		StringBuilder sb = this.getSql();

		// 查询参数
		SqlParam params = new SqlParam();
		params.addParam(appNo);

		// 查询
		List<ScAptDO> datas = (List<ScAptDO>) new DAFacade().execQuery(sb.toString(), params, new BeanListHandler(
				ScAptDO.class));
		if (!ListUtil.isEmpty(datas)) {
			return FBoolean.TRUE;
		}

		return FBoolean.FALSE;
	}

	/**
	 * 查询sql
	 *
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private StringBuilder getSql() throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select * ");
		sb.append("from ");
		sb.append("sc_apt apt ");
		sb.append("inner join sc_apt_mt mt on mt.id_apt = apt.id_apt ");
		sb.append("inner join sc_apt_appl appl on appl.id_aptappl = mt.id_aptappl ");
		sb.append("where ");
		sb.append("apt.fg_canc = 'N' ");
		sb.append("and appl.applyno = ? ");
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScAptDO(), "apt"));
		return sb;
	}
}
