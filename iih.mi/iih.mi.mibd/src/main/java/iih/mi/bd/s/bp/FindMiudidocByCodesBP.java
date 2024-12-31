package iih.mi.bd.s.bp;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mhi.hpdoc.d.HpDocDO;
import iih.mi.bd.d.MiudidocDTO;
import iih.mi.bd.miudidoc.d.MiUdidocDO;
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
 * 根据编码查询医保档案数据 (档案编码为空时，返回该档案类型下全部档案数据)
 * 
 * @author wq.li
 *
 */
public class FindMiudidocByCodesBP {
	/**
	 * 根据编码查询医保档案数据 (档案编码为空时，返回该档案类型下全部档案数据)
	 * @param hpId
	 * @param doclistCode
	 * @param docCodes
	 * @return
	 * @throws BizException
	 */
	public MiudidocDTO[] exec(String hpId, String doclistCode, String[] docCodes) throws BizException {
		if (StringUtil.isEmpty(hpId)) {
			throw new ArgumentNullException("医保档案查询", "医保产品id");
		}

		if (StringUtil.isEmpty(doclistCode)) {
			throw new ArgumentNullException("医保档案查询", "档案类型编码");
		}

		// 递归获取复用医保计划id
		String hpIdNew = HpIdRecursionUtil.getHpIdRecursion(hpId);
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select id_miudidoc,");
		sqlSb.append("code,");
		sqlSb.append("name,");
		sqlSb.append("ctrl1,");
		sqlSb.append("ctrl2,");
		sqlSb.append("ctrl3,");
		sqlSb.append("ctrl4,");
		sqlSb.append("ctrl5 ");

		sqlSb.append("from mi_udidoc ");

		sqlSb.append(" where id_hp=? ");
		sqlSb.append(" and id_miudidoclist=? ");
		String orgSql = EnvContextUtil.processEnvContext("", new MiUdidocDO(), false);
		if(!StringUtil.isEmpty(orgSql)){
			sqlSb.append("and " + orgSql + " ");
		}
		if (!ArrayUtil.isEmpty(docCodes)) {
			sqlSb.append("and " + SqlUtils.getInSqlByIds("code", docCodes) + " ");
		}

		SqlParam param = new SqlParam();
		param.addParam(hpIdNew);
		param.addParam(doclistCode);

		List<MiudidocDTO> list=(List<MiudidocDTO>) new DAFacade().execQuery(sqlSb.toString(),param, new BeanListHandler(MiudidocDTO.class));
		
		return list.toArray(new MiudidocDTO[0]);
	}
}
