package iih.sc.sch.s.bp;

import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScSqlUtils;
import iih.sc.sch.s.ep.OralSchEP;
import iih.sc.sch.scsch.d.ScSchDO;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 删除排班时校验排班是否已被使用BP
 * 
 * @author zhengcm
 * @date 2017-09-08 16:10:55
 *
 */
public class DeleteSchValidateBP {

	/**
	 * 删除排班时校验排班是否已被使用
	 *
	 * @author zhengcm
	 * 
	 * @param schIds 排班ID列表
	 * @throws BizException
	 */
	public void validate(List<String> schIds) throws BizException {
		if (ListUtil.isEmpty(schIds)) {
			return;
		}
		String cond = ScSqlUtils.getInSqlByIds("id_sch", schIds);
		ScSchDO[] schDOs = new OralSchEP().getSchByCond(cond, null);
		if (ArrayUtil.isEmpty(schDOs)) {
			return;
		}
		for (ScSchDO schDO : schDOs) {
			if (schDO.getQuan_total_used() > 0) {
				throw new BizException(String.format(IScMsgConst.SC_SCH_IS_USED, this.getShowMsg(schDO.getId_sch())));
			}
		}
	}

	/**
	 * 获取提示消息
	 *
	 * @author zhengcm
	 * 
	 * @param schId 排班ID
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private String getShowMsg(String schId) throws BizException {
		if (StringUtil.isEmptyWithTrim(schId)) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("pl.name as name_scpl,");
		sb.append("sch.d_sch,");
		sb.append("lot.name as name_dayslot ");
		sb.append("from sc_sch sch ");
		sb.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		sb.append("inner join bd_dayslot lot on lot.id_dayslot = sch.id_dayslot ");
		sb.append("where ");
		sb.append("sch.id_sch = ? ");
		SqlParam params = new SqlParam();
		params.addParam(schId);
		Map<String, String> data = (Map<String, String>) new DAFacade().execQuery(sb.toString(), params,
				new MapHandler());
		if (null != data && !data.isEmpty()) {
			return data.get("name_scpl") + data.get("d_sch") + data.get("name_dayslot");
		}
		return null;
	}
}
