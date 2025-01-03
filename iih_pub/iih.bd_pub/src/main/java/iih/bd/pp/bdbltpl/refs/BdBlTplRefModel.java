package iih.bd.pp.bdbltpl.refs;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.refs.BdRefGridModel;
import iih.bd.pp.bdbltpl.d.BdBlTplDO;
import iih.bd.pp.bdbltpl.i.IBdBltplExtRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.i.IBaseDO;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.refinfo.RefResultSet;

/**
 * 自定义模板参照模型
 * 
 * @author tcy 2017-2-21
 * @author hao_wu 2018-6-15 修正查询数据与显示顺序不符的问题
 * @author hao_wu 2019-12-11 增加价格字段，迭代代码逻辑
 *
 */
public class BdBlTplRefModel extends BdRefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { BdBlTplDO.NAME, "price", "dep_name", "name_owntp", "name_bltpltp", BdBlTplDO.CODE,
				BdBlTplDO.DES };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BdBlTplDO.ID_BLTPL, BdBlTplDO.ID_BLTPLTP, BdBlTplDO.ID_OWTP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "模板名称", "价格", "所属科室/组织", "所属类型", "模板类型", "模板编码", "模板描述" };
	}

	@Override
	protected String getBaseRefSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT bd_bltpl.name,");
		sqlBuilder.append("null as price,");
		sqlBuilder.append("bd_dep.name dep_name,");
		sqlBuilder.append("owtp.name name_owntp,");
		sqlBuilder.append("bltpltp.name name_bltpltp,");
		sqlBuilder.append("bd_bltpl.code,");
		sqlBuilder.append("bd_bltpl.des,");
		sqlBuilder.append("bd_bltpl.id_bltpl,");
		sqlBuilder.append("bd_bltpl.id_bltpltp,");
		sqlBuilder.append("bd_bltpl.id_owtp ");
		sqlBuilder.append("FROM bd_bltpl ");
		sqlBuilder.append("LEFT JOIN bd_dep ");
		sqlBuilder.append("ON bd_bltpl.id_dep = bd_dep.id_dep ");
		sqlBuilder.append("LEFT JOIN bd_udidoc owtp ");
		sqlBuilder.append("ON bd_bltpl.sd_owtp=owtp.code ");
		sqlBuilder.append("INNER JOIN bd_udidoclist owtptp ");
		sqlBuilder.append("ON owtptp.code ='BD.SRV.1545' ");
		sqlBuilder.append("AND owtp.id_udidoclist=owtptp.id_udidoclist ");
		sqlBuilder.append("LEFT JOIN bd_udidoc bltpltp ");
		sqlBuilder.append("ON bd_bltpl.sd_bltpltp=bltpltp.code ");
		sqlBuilder.append("INNER JOIN bd_udidoclist bltpltptp ");
		sqlBuilder.append("ON bltpltptp.code ='BD.BL.2505' ");
		sqlBuilder.append("AND bltpltp.id_udidoclist =bltpltptp.id_udidoclist ");
		return sqlBuilder.toString();
	}

	@Override
	protected IBaseDO getDo() {
		return new BdBlTplDO();
	}

	@Override
	public void afterQueryRefData(RefResultSet refResultSet) {
		String[] tplIds = getFieldValues(refResultSet, BdBlTplDO.ID_BLTPL, String.class);
		if (ArrayUtils.isEmpty(tplIds)) {
			return;
		}
		IBdBltplExtRService bdBltplExtRService = ServiceFinder.find(IBdBltplExtRService.class);
		Map<String, FDouble> tplPriceMap;
		try {
			// 获取价格
			tplPriceMap = bdBltplExtRService.getTplPriceMap(tplIds);
		} catch (BizException e) {
			e.printStackTrace();
			return;
		}

		HashMap<String, String> tplPriceStrMap = new HashMap<>();
		for (String blTplId : tplPriceMap.keySet()) {
			FDouble price = tplPriceMap.get(blTplId);
			String priceStr = String.valueOf(price.setScale(4, FDouble.ROUND_HALF_UP));
			tplPriceStrMap.put(blTplId, priceStr);
		}

		setFieldValues(refResultSet, tplPriceStrMap, BdBlTplDO.ID_BLTPL, "price");
	}
}
