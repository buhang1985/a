package iih.mi.biz.hpsignin.refs;

import iih.mi.biz.hpsignin.d.MiHpSignInDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 医保签到模型
 * @author hanjq 下午5:15:48
 *
 */
public class HpSignRefModel extends RefGridModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2633719787887958264L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MiHpSignInDO.CODE_BUSINESS, MiHpSignInDO.DT_B, MiHpSignInDO.DT_E,MiHpSignInDO.PSN_NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MiHpSignInDO.ID_HP ,MiHpSignInDO.ID_HPSIGNIN};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "业务周期号", "签到时间", "签退时间" ,"操作人"};
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MiHpSignInDO.CODE_BUSINESS, MiHpSignInDO.DT_B, MiHpSignInDO.DT_E,MiHpSignInDO.PSN_NAME};
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return MiHpSignInDO.ID_HPSIGNIN;
	}

	@Override
	public String getRefCodeField() {
		return MiHpSignInDO.CODE_BUSINESS;
	}

	@Override
	public String getRefNameField() {
		return MiHpSignInDO.CODE_BUSINESS;
	}

	@Override
	public String getTableName() {
		return new MiHpSignInDO().getTableName();
	}

	/**
	 * 
	 */
	@Override
	public String getRefSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select distinct   MI_HP_SIGN_IN.Code_business, ");
		sqlBuilder.append("MI_HP_SIGN_IN.Dt_b, ");
		sqlBuilder.append("MI_HP_SIGN_IN.Dt_e, ");
		sqlBuilder.append("BD_PSNDOC.Name Psn_name, ");
		sqlBuilder.append("MI_HP_SIGN_IN.Id_hp ,MI_HP_SIGN_IN.Id_hpsignin ");

		sqlBuilder.append("from mi_hp_sign_in ");
		sqlBuilder.append("join bd_psndoc on MI_HP_SIGN_IN.ID_EMP = BD_PSNDOC.Id_psndoc ");
		// where
		sqlBuilder.append(" WHERE 1=1 ");


		// 增加排序功能
		sqlBuilder.append(" order by MI_HP_SIGN_IN.Dt_b desc");

		return sqlBuilder.toString();
	}
}
