package iih.bd.srv.diagdef.refs;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.d.desc.DiagDefDODesc;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;
import xap.sys.permfw.role.d.RoleDO;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 临床路径诊断,根据诊断体系过滤诊断参照
 * @author HUMS
 *
 */
public class HPDiagDefRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	private String queryStr = "";
	private String sd_inputmethod = "";

	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "标准", "体系" };
	}

	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { DiagDefDO.CODE, RoleDO.NAME, "Cd_name", DiagDefDO.SYS_NAME };
	}

	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {

		return new String[] { DiagDefDO.ID_DIDEF, DiagDefDO.PYCODE, DiagDefDO.WBCODE, DiagDefDO.MNECODE,
				DiagDefDO.ID_CDSYS, DiagDefDO.ID_DISTDCA, DiagDefDO.ID_CDSYSTP, "standard_code", DiagDefDO.FG_UR,
				DiagDefDO.FG_CHRONIC, DiagDefDO.FG_SPECIAL, DiagDefDO.SYS_CODE, DiagDefDO.ID_INFECTIONTP,
				DiagDefDO.SD_INFECTIONTP };

	}

	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
//		return new String[] { DiagDefDO.CODE, DiagDefDO.NAME, DiagDefDO.PYCODE, DiagDefDO.WBCODE, DiagDefDO.MNECODE,
//				DiagDefDO.ID_CDSYS, DiagDefDO.ID_CDSYSTP };
		return new String[] { DiagDefDO.CODE, DiagDefDO.NAME, DiagDefDO.PYCODE, DiagDefDO.WBCODE, DiagDefDO.MNECODE };
	}

	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return DiagDefDODesc.TABLE_NAME;
	}

	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return DiagDefDO.ID_DIDEF;
	}

	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return DiagDefDO.CODE;
	}

	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return DiagDefDO.NAME;
	}

	@Override
	public void addWherePart(String wherePart) {

		getWherePart().add(wherePart);
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
		this.queryStr = blurValue;

		this.sd_inputmethod = (String) this.getExtendAttributeValue("inputmethod");// 01:拼音码,10:五笔码,11:五笔码和拼音码
		if (StringUtils.isNullOrEmpty(sd_inputmethod)) {
			sd_inputmethod = "01";
		}

		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append(" (");

		String wherePart = String.format("lower(%s.Name) like '%%%s%%'", this.getTableName(), blurValue);
		wherePartBuilder.append(wherePart);

		wherePart = String.format(" or lower(%s.Code) like '%%%s%%'", this.getTableName(), blurValue);
		wherePartBuilder.append(wherePart);

		wherePart = String.format(" or lower(%s.Mnecode) like '%%%s%%'", this.getTableName(), blurValue);
		wherePartBuilder.append(wherePart);

		if ("1".equals(sd_inputmethod.substring(1))) {
			wherePart = String.format(" or lower(%s.Pycode) like '%%%s%%'", this.getTableName(), blurValue);
			wherePartBuilder.append(wherePart);
		}

		if (sd_inputmethod.startsWith("1")) {
			wherePart = String.format(" or lower(%s.Wbcode) like '%%%s%%'", this.getTableName(), blurValue);
			wherePartBuilder.append(wherePart);
		}

		wherePart = String.format(
				" or id_didef in (select distinct id_didef from bd_di_als where (lower(pycode) like '%s%%' or lower(wbcode) like '%s%%' or lower(mnecode) like '%%%s%%' or lower(alias) like '%%%s%%'))",
				blurValue, blurValue, blurValue, blurValue);
		wherePartBuilder.append(wherePart);

		wherePartBuilder.append(") ");

		this.addWherePart(wherePartBuilder.toString());
		try {
			if (pg == null)
				return this.getRefData();
			else
				return this.getRefData(pg);
		} finally {
			this.removeWherePart(wherePartBuilder.toString());
		}
	}

	@Override
	public String getRefSql() {
		
		Context ctx=Context.get();
		String clinicalDiagSysCfgParam = null;
		try {
			// 获取诊断体系编码
			clinicalDiagSysCfgParam = ParamsetQryUtil.getParaString(ctx.getDeptId(),"CIOR0025");
		} catch (BizException e) {			
			clinicalDiagSysCfgParam = "11";
		}
		
		String[] paramArr = clinicalDiagSysCfgParam.split(",");
		StringBuffer diagSysCfgBuffer = new StringBuffer(); 
		for(String paramStr : paramArr){
			diagSysCfgBuffer.append(",'"+paramStr+"'");
		}
		
		StringBuffer str = new StringBuffer();

		str.append("select bd_di_def.Code,");
		str.append("bd_di_def.Name,");
		str.append("bd_cdsys.name as Cd_name,");
		str.append("bd_udidoc.name as Sys_name, ");
		str.append("bd_di_def.Id_didef,");
		str.append("bd_di_def.Pycode,");
		str.append("bd_di_def.Wbcode,");
		str.append("bd_di_def.Mnecode,");
		str.append("bd_di_def.Id_cdsys,");
		str.append("bd_di_def.Id_distdca,");
		str.append("bd_di_def.Id_cdsystp,");
		str.append("bd_cdsys.code as standard_code,");
		str.append("bd_di_def.fg_ur as Fg_ur, ");
		str.append("bd_di_def.fg_chronic as fg_chronic, ");
		str.append("bd_di_def.fg_special as fg_special, ");
		str.append("bd_udidoc.code as Sys_code,");
		str.append("bd_di_def.Id_infectiontp, ");
		str.append("bd_di_def.Sd_infectiontp");

		if (this.queryStr.length() > 0) {
			if (sd_inputmethod.length() > 0) {
				if ("1".equals(sd_inputmethod.substring(1))) {
					str.append(",length(bd_di_def.pycode)-length('" + this.queryStr + "') as cnt_py");
				}
				if (sd_inputmethod.startsWith("1")) {
					str.append(",length(bd_di_def.wbcode)-length('" + this.queryStr + "') as cnt_wb");
				}
			}
			str.append(",length(bd_di_def.name)-length('" + this.queryStr + "') as cnt_name");
		}

		str.append(" from bd_di_def bd_di_def ");
		str.append("inner join bd_cdsys bd_cdsys on bd_cdsys.id_cdsys = bd_di_def.id_cdsys and bd_cdsys.sd_cdsystp in ("+diagSysCfgBuffer.substring(1)+")");
		str.append("left join bd_udidoc bd_udidoc on bd_udidoc.id_udidoc = bd_di_def.id_cdsystp ");
		str.append("left join bd_srvoth_wordfreq bsw ");
		str.append("on bd_di_def.id_didef = bsw.id_biz and bsw.biz_classtype = 'diagdef' ");
		str.append("and bsw.id_emp ='");
		str.append(Context.get().getUserId());
		str.append("'");

		str.append(" where bd_di_def.ds = '0' and bd_di_def.fg_active ='Y'  ");
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {

			for (String where : this.getWherePart()) {
				str.append(" and (").append(where).append(") ");
			}
		}

		// 管控条件
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new DiagDefDO(), "bd_di_def");
		str.append(String.format(" and %s ", BdModeWherePart));

		str.append(" order by ");

		if (this.queryStr.length() > 0) {
			str.append(" cnt_name asc,");
			if (sd_inputmethod.length() > 0) {
				if ("1".equals(sd_inputmethod.substring(1))) {
					str.append(" cnt_py asc,");
				}
				if (sd_inputmethod.startsWith("1")) {
					str.append(" cnt_wb asc,");
				}
			}
		}

		str.append("nvl(bsw.cnt,0),length(bd_di_def.Name),bd_di_def.Name desc ");

		return str.toString();
	}
}