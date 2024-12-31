/**
 * 
 */
package iih.ci.diag.cidiag.ref;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: RefCiDiagItemEmsDO
 * @Description: TODO 
 * @author GH  主用作bug：0116820: 中医诊断未显示症候名称  新需求  临床诊断参照列表 如果为中医诊断 则需要合并诊断和症候 例： 中医诊断（症候）
 * @createTime 2018年5月26日 11点56分
 * (c) 2011 Company: 北大医疗信息技术有限责任公司
 */
public class RefCiDiagItemEmsDO extends RefCiDiagItemDO {
	@Override
	public String getRefSql() {

		String wherePart = "";

		String id_ent = (String) this.getExtendAttributeValue("id_ent");
		String sql = "";
		if (StringUtils.isNotEmpty(id_ent)) {

			String id_dis = getIdDI(id_ent);
			if (!StringUtils.isEmpty(id_dis)) {
				wherePart = " id_di in (" + id_dis + ")";
				this.addWherePart(wherePart);
			} else {
				sql = defaultSql();
				wherePart = " bd_di_def.fg_active='Y' AND( ( bd_di_def.id_cdsystp  ='@@@@AA10000000076SML') or ( bd_di_def.id_cdsystp  ='@@@@AA10000000076SMM' AND bd_di_def.fg_ds ='N' ))";
				this.addWherePart(wherePart);//添加启用标识条件
				String whereStr = "";
				List<String> whereList = this.getWherePart();
				for (String part : whereList) {
					whereStr += " and " + part;
				}
				if (whereList.size() > 0)
					sql += " where " + whereStr.substring(4);
			}
		}

		if (StringUtils.isEmpty(sql)) {
			sql = super.getRefSql();
		}

		return sql;
	}
	
}
