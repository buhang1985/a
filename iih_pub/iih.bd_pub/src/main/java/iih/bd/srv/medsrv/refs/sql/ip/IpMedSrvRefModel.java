package iih.bd.srv.medsrv.refs.sql.ip;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.refs.sql.OrMedSrvOrderNormal;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.DaoUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

public class IpMedSrvRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String queryStr;
	public String getQueryStr() {
		return queryStr;
	}

	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "Name_srv_desc", "des_pri","Name_unit_sale", "des" };
		}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] {"id_Srv", "Id_mm", "sd_srvtp","id_srvtp","fg_ctm","id_unit_med","quan_med","pycode","IdSrvIdMm","name","id_unit_sale" };
		}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "服务项目","发药单位","参考价", "描述" };
		}

	@Override
	public String getPkFieldCode() {
		return "IDSRVIDMM";
	}

	@Override
	public String getRefCodeField() {
		return MedSrvDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return "Name_srv_desc";//MedSrvDO.NAME;
	}

	@Override
	public String getTableName() {
		return "bd_srv_comp";//MedSrvDODesc.TABLE_NAME;
	}

	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		String[] fields = this.getBlurFields();
		if (fields == null) {
			fields = this.getShowFieldCode();
		}
		blurValue = blurValue.toLowerCase();
		blurValue = blurValue.replaceAll("[ ]+", "%");
		blurValue = blurValue == "%" ? "" : blurValue;
		queryStr = blurValue;
		StringBuffer sb = new StringBuffer();
		sb.append(" ( ");
		sb.append("lower(a0.Name) like ");
		sb.append("?");
		sb.append(" or ");
		sb.append("lower(a0.Pycode) like ");
		sb.append("?");
		sb.append(" or ");
		sb.append("lower(mm.name) like ");
		sb.append("?");
		sb.append(" or ");
		sb.append("lower(a0.Wbcode) like ");
		sb.append("?");
		sb.append(") ");
		this.getParam().addParam("%"+blurValue + "%");
		this.getParam().addParam("%"+blurValue + "%");
		this.getParam().addParam("%"+blurValue + "%");
		this.getParam().addParam("%"+blurValue + "%");

		this.addWherePart(sb.toString());
		try {
			if (pg == null)
				return this.getRefData();
			else
				return this.getRefData(pg);
		} finally {
			this.removeWherePart(sb.toString());
		}
	}

	@Override
	public void addWherePart(String wherePart) {

		getWherePart().add(wherePart);
	}

	@Override
	public String getRefSql() {
		String code_entp = (String) this.getExtendAttributeValue("code_entp");
		String id_hp = (String) this.getExtendAttributeValue("id_hp");
		String id_pripat = (String) this.getExtendAttributeValue("id_pripat");
		String sd_herbpreparationtp = (String) this.getExtendAttributeValue("sd_herbpreparationtp");
		IpMedSrvRefGetSql medsrvquery = new IpMedSrvRefGetSql();
		if(code_entp==null){
			return new OrMedSrvOrderNormal().getMySqlStr(code_entp, id_hp, this.getQueryStr(), id_pripat, this.getWherePart());
		}
		medsrvquery.setSd_herbpreparationtp(sd_herbpreparationtp);
		return medsrvquery.getMySqlStr(code_entp, id_hp, this.getQueryStr(), id_pripat, this.getWherePart());
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MedSrvDO.NAME, MedSrvDO.CODE, MedSrvDO.PYCODE, MedSrvDO.MNECODE, MedSrvDO.WBCODE };
	}

	@Override
	public RefResultSet filterRefPks(String[] filterPks) {
		String filterPksText = DaoUtil.joinQryArrays((String[]) filterPks);
		//String pkFieled = this.getPkFieldCode();
		StringBuilder buff = new StringBuilder();
		buff.append("a0.id_srv||a0.id_mm");
		if (filterPks.length == 1) {
			buff.append(" = ").append(filterPksText);
		} else {
			buff.append(" in (").append(filterPksText).append(")");
		}
		String wherePart = buff.toString();
		this.addWherePart(wherePart);
		try {
			RefResultSet refResultSet = this.getRefData();
			return refResultSet;
		} finally {
			this.removeWherePart(wherePart);
		}
	}
	
}
