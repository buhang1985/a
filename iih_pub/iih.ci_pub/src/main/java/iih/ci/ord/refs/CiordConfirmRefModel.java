package iih.ci.ord.refs;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;

import java.util.List;

import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

public class CiordConfirmRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { "name_bed", "entcode", "name_pat", "sexname",
				"dt_birth_pat", "name" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { "Id_bed","Id_ent", "Id_dep_phy" };
	}

	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[] { "床号", "住院号", "姓名", "性别", "出生日期", "科室" };
	}

	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return "Id_ent";
	}

	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return "Entcode";
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return "Name_bed";
	}

	@Override
	public String getRefSql() {
		// TODO Auto-generated method stub
		String iddepnur = (String) this.getExtendAttributeValue("iddepnur");

		String refSql = "SELECT EN_ENT_IP.name_bed,EN_ENT_IP.code_amr_ip entcode,EN_ENT.name_pat,udi.name sexname,EN_ENT.dt_birth_pat,DEP.Name,"
				+ "EN_ENT_IP.id_bed,EN_ENT.id_ent,EN_ENT.id_dep_phy "
				+ "FROM EN_ENT INNER JOIN EN_ENT_IP ON EN_ENT_IP.id_ent=EN_ENT.id_ent "
                + "LEFT outer JOIN bd_udidoc udi ON udi.id_udidoc=EN_ENT.Id_Sex_Pat "
				+ "LEFT JOIN BD_DEP DEP ON EN_ENT.id_dep_phy=DEP.id_dep "
                + "where EN_ENT.id_dep_nur='"+iddepnur+"' and EN_ENT.fg_ip='Y' And EN_ENT.code_entp in ('"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"','"+IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS+"','"+iih.bd.bc.udi.pub.IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE+"') ";
		StringBuilder sb = new StringBuilder(refSql);
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}

		sb.append(" order by EN_ENT_IP.name_bed");
		return sb.toString();
	}

	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		String[] fields = this.getBlurFields();
		if (fields == null)
			// lizhiyu 2015-08-29 当搜索字段没有定义时，默认使用显示字段来过滤
			fields = this.getShowFieldCode();

		StringBuilder buf = new StringBuilder();
		buf.append("(");
		buf.append(" lower(EN_ENT_IP.code_amr_ip) like ");
		buf.append(" ? ");
		this.getParam().addParam("%"+blurValue.toLowerCase()+"%");
		buf.append(" or ");
		buf.append(" lower(EN_ENT.name_pat) like ");
		buf.append(" ? ");
		this.getParam().addParam("%"+blurValue.toLowerCase()+"%");
		buf.append(" or ");
		buf.append(" lower(EN_ENT_IP.name_bed) like ");
		buf.append(" ? ");
		this.getParam().addParam("%"+blurValue.toLowerCase()+"%");
		buf.append(")");
		String str = buf.toString();
		this.addWherePart(str);
		try {
			if (pg == null)
				return this.getRefData();
			else
				return this.getRefData(pg);
		} finally {
			this.removeWherePart(str);
		}
	}

	@Override
	public String[] getBlurFields() {
		// TODO Auto-generated method stub
		return new String[] { "code", "name_pat","name_bed" };
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "EN_ENT_IP";
	}

}
