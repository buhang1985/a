package iih.bl.st.s.bp;

import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blauditip.i.IBlauditipMDORService;

import java.util.List;

import org.apache.commons.dbutils.handlers.ColumnListHandler;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院获取就诊账户状态和费用审核信息
 * 
 * @author liwq
 *
 */
public class GetFrozenAndAuditBP {

	@SuppressWarnings("unchecked")
	public FArrayList2 exec(String id_ent) throws BizException {

		if (StringUtil.isEmptyWithTrim(id_ent)) {
			throw new BizException("患者就诊id不能为空！");
		}
		FArrayList2 arr = new FArrayList2();
		// 1. 获取就诊账户状态（是否冻结）
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT FG_FREEZE FROM EN_ENT_ACC WHERE ID_ENT = ? ");
		SqlParam param = new SqlParam();
		param.addParam(id_ent);

		List<String> list = (List<String>) new DAFacade().execQuery(sql.toString(), param, new ColumnListHandler());
		if (ListUtil.isEmpty(list)) {
			throw new BizException("未查询到患者对应的就诊账户信息！");
		}
		FBoolean tmpBoolean = new FBoolean(list.get(0));
		arr.add(tmpBoolean);

		// 2. 获取费用审核信息（是否存在有效审核记录）
		// 2.1 通过标准服务查询bl_audit_ip表中对应的审核数据
		IBlauditipMDORService auditService = ServiceFinder
				.find(IBlauditipMDORService.class);
		String whereCond = "fg_active = 'Y' and id_ent = '" + id_ent + "'";
		BlAuditIp[] blAuditIpArr = auditService.find(whereCond,	"dt_audit_clinic", FBoolean.TRUE);

		// 2.2 返回查询结果集 若查询结果集为null 则默认未通过
		if (ArrayUtil.isEmptyNoNull(blAuditIpArr)) {
			BlAuditIp itmDo = new BlAuditIp();
			itmDo.setFg_pass_clinic(FBoolean.FALSE);
			itmDo.setFg_pass_hp(FBoolean.FALSE);
			arr.add(itmDo);
		} else {
			arr.add(blAuditIpArr[0]);
		}
		return arr;
	}
}
