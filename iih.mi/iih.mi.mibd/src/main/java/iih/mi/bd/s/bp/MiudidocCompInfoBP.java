package iih.mi.bd.s.bp;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mhi.hpdoc.d.HpDocDO;
import iih.mi.bd.d.MiUdidocCompDTO;
import iih.mi.bd.miudidoccomp.d.MiUdidocCompDO;
import iih.mi.bd.util.HpIdRecursionUtil;
import iih.mi.mibd.base.exception.ArgumentNullException;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 获取医保档案对照信息
 * 
 * @author wq.li
 *
 */
public class MiudidocCompInfoBP {
	/**
	 * 获取医保档案对照信息
	 * 
	 * @param hpId
	 * @param doclistCode
	 * @param docCodes
	 * @return
	 * @throws BizException
	 */
	public MiUdidocCompDTO[] exec(String hpId, String doclistCode, String[] docCodes) throws BizException {

		if (StringUtil.isEmpty(hpId)) {
			throw new ArgumentNullException("医保档案查询", "医保产品id");
		}

		if (StringUtil.isEmpty(doclistCode)) {
			throw new ArgumentNullException("医保档案查询", "档案类型编码");
		}

		// 递归获取复用医保计划id
		String hpIdNew = HpIdRecursionUtil.getHpIdRecursion(hpId);

		StringBuilder sql = new StringBuilder();
		sql.append("  select comp.id_hp, ");
		sql.append(" comp.id_miudidoc, ");
		sql.append(" comp.code_his, ");
		sql.append(" comp.name_his, ");
		sql.append(" comp.code_hp, ");
		sql.append(" comp.name_hp ");
		sql.append(" from mi_udidoc_comp comp	");
		sql.append(" inner join mi_udidoclist list on list.id_miudidoclist=comp.id_miudidoclist ");
		sql.append(" where comp.id_hp=? ");
		sql.append(" and list.code=? ");
		
		if(!ArrayUtil.isEmpty(docCodes))
		{
			sql.append(" and " + SqlUtils.getInSqlByIds("comp.code_his", docCodes) + " ");
		}
		String orgSql = EnvContextUtil.processEnvContext("", new MiUdidocCompDO(), "comp");
		if(!StringUtil.isEmpty(orgSql)){
			sql.append(" and " + orgSql);
		}

		SqlParam param = new SqlParam();
		param.addParam(hpIdNew);
		param.addParam(doclistCode);

		List<MiUdidocCompDTO> list = (List<MiUdidocCompDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(MiUdidocCompDTO.class));

		return list.toArray(new MiUdidocCompDTO[0]);

	}
}
