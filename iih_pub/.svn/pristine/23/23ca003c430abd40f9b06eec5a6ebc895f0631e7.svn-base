package iih.bd.mm.meterial.refs;

import java.util.ArrayList;
import java.util.List;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 
 * @Description:医疗器械基本信息参照
 * @author: xu_xing@founder.com.cn
 * @version：2019年9月17日 下午3:20:03 创建
 */
public class MeterialApparatusRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MeterialDO.CODE, MeterialDO.NAME, MeterialDO.SPEC, MeterialDO.NAME_UNIT_PKGBASE, MeterialDO.SUP_NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MeterialDO.ID_UNIT_PKGBASE, MeterialDO.ID_MM, MeterialDO.ID_GRP, MeterialDO.ID_ORG };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MeterialDO.CODE, MeterialDO.NAME, MeterialDO.PYCODE, MeterialDO.WBCODE, MeterialDO.MNECODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "物品编码", "物品名称", "物品规格", "包装单位", "供应商" };
	}

	@Override
	public String getPkFieldCode() {
		return MeterialDO.ID_MM;
	}

	@Override
	public String getRefCodeField() {
		return MeterialDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MeterialDO.NAME;
	}

	@Override
	public String getTableName() {
		return new MeterialDO().getTableName();
	}

	@Override
	public List<String> getOrderPart() {
		List<String> orderPart = new ArrayList<String>();
		orderPart.add(MeterialDO.CODE);
		return orderPart;
	}

	@Override
	public String getRefSql() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                       ");
		sqlStr.append(" bd_mm.code,                                  ");
		sqlStr.append(" bd_mm.name,                                  ");
		sqlStr.append(" bd_mm.spec,                                  ");
		sqlStr.append(" doc.name as name_unit_pkgbase,               ");
		sqlStr.append(" bd_mm.sup_name,                              ");
		sqlStr.append(" bd_mm.id_unit_pkgbase,                       ");
		sqlStr.append(" bd_mm.id_mm,                                 ");
		sqlStr.append(" bd_mm.id_grp,                                ");
		sqlStr.append(" bd_mm.id_org,                                ");
		sqlStr.append(" bd_mm.fg_active,                             ");
		sqlStr.append(" bd_mm.fg_price,                              ");
		sqlStr.append(" bd_mm.fg_batch,                              ");
		sqlStr.append(" bd_mm.fg_skin,                               ");
		sqlStr.append(" bd_mm.id_mmtp,                               ");
		sqlStr.append(" bd_mm.id_sup,                                ");
		sqlStr.append(" bd_mm.price,                                 ");
		sqlStr.append(" bd_mm.price_in,                              ");
		sqlStr.append(" bd_mm.name_unit_pkgsp,                       ");
		sqlStr.append(" bd_mm.id_unit_pkgsp,                         ");
		sqlStr.append(" bd_mm.factor_sb,                             ");
		sqlStr.append(" bd_mm.id_mmca,                               ");
		sqlStr.append(" bd_mm.sd_primode,                            ");
		sqlStr.append(" bd_mm.rate_pap                               ");
		sqlStr.append(" from bd_mm                                   ");
		sqlStr.append(" left join bd_measdoc doc on doc.id_measdoc = bd_mm.id_unit_pkgbase        ");
		sqlStr.append(" where bd_mm.fg_active = 'Y'                  ");
		sqlStr.append(" and substr(bd_mm.sd_mmtp,0,1) = '4'          ");
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				where = where.replace("Id_mm", "BD_MM.Id_mm").replace("BD_MM.BD_MM", "BD_MM");
				sqlStr.append(" and (").append(where).append(") ");
			}
		}
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MeterialDO(), "BD_MM");
		sqlStr.append(String.format(" and %s ", BdModeWherePart));
		sqlStr.append(" order by BD_MM.Code");
		return sqlStr.toString();
	}
}
