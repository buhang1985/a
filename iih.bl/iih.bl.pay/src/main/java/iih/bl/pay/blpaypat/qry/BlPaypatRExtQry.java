package iih.bl.pay.blpaypat.qry;

import iih.bl.pub.BlGroupControlUtils;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class BlPaypatRExtQry implements ITransQry {
	private String whereStr;
	private String orderStr;

	/**
	 * 获取患者预交金收退信息
	 * 
	 * @param ID_STOEPs
	 * @throws BizException
	 * @author liwenqiang 2018-01-30 11:16:09
	 */
	public BlPaypatRExtQry(String whereStr, String orderStr, FBoolean isLazy) throws BizException {
		this.whereStr = whereStr;
		this.orderStr = orderStr;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();

		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  ");
		sql.append(" a0.Amt, ");
		sql.append(" a0.Bankcardno, ");
		sql.append(" a0.Bankno, ");
		sql.append(" a0.Code_enttp, ");
		sql.append(" a0.Code_incca, ");
		sql.append(" a0.Code_rep, ");
		sql.append(" a0.Createdby, ");
		sql.append(" a0.Createdtime, ");
		sql.append(" a0.Ds, ");
		sql.append(" a0.Dt_canc, ");
		sql.append(" a0.Dt_pay, ");
		sql.append(" a0.Dt_return, ");
		sql.append(" a0.Eu_direct, ");
		sql.append(" a0.Fg_canc, ");
		sql.append(" a0.Fg_cc, ");
		sql.append(" a0.Fg_rep_return, ");
		sql.append(" a0.Id_bank, ");
		sql.append(" a0.Id_cc, ");
		sql.append(" a0.Id_dep_pay, ");
		sql.append(" a0.Id_emp_canc, ");
		sql.append(" a0.Id_emp_pay, ");
		sql.append(" a0.Id_emp_return, ");
		sql.append(" a0.Id_ent, ");
		sql.append(" a0.Id_enttp, ");
		sql.append(" a0.Id_grp, ");
		sql.append(" a0.Id_incca, ");
		sql.append(" a0.Id_org, ");
		sql.append(" a0.Id_org_pay, ");
		sql.append(" a0.Id_par, ");
		sql.append(" a0.Id_pat, ");
		sql.append(" a0.Id_paypat, ");
		sql.append(" a0.Id_paytp, ");
		sql.append(" a0.Id_pm, ");
		sql.append(" a0.Id_rep_lost, ");
		sql.append(" a0.Id_st_mid, ");
		sql.append(" a0.Modifiedby,  ");
		sql.append(" a0.Modifiedtime,  ");
		sql.append(" a0.Note, ");
		sql.append(" a0.Paymodenode, ");
		sql.append(" a0.Sd_paytp, ");
		sql.append(" a0.Sd_pm,  ");
		sql.append(" a0.Sd_pttp,  ");
		sql.append(" a0.Sd_rep_lost,  ");
		//添加交易号   退费金额  by zx
		sql.append(" a0.Tradeno,");
		sql.append(" a0.Amt_ret,");
		//添加账户名称 by zx 2019年12月9日
		sql.append(" a0.Acc_Name,");
		sql.append(" a0.Fg_refund_manual,");
		sql.append(" a0.Sv, ");
		sql.append(" udidoclist.CODE paytpcode, ");
		sql.append(" udidoclist.NAME paytpname, ");
		sql.append(" pat.code patcode, ");
		sql.append(" pat.name patname, ");
		sql.append(" entp.code enttpcode, ");
		sql.append(" entp.name enttpname, ");
		sql.append(" pm.code paymodecode, ");
		sql.append(" pm.name paymodename, ");
		sql.append(" bank.code bank_code, ");
		sql.append(" bank.name bank_name, ");
		sql.append(" dep.code Deptpaycode, ");
		sql.append(" dep.name Deptpayname, ");
		sql.append(" psndoc.code Emp_code, ");
		sql.append(" psndoc.name Emp_name, ");
		sql.append(" incca.code Inccacode, ");
		sql.append(" incca.name Inccaname, ");
		sql.append(" replost.code Rep_code, ");
		sql.append(" replost.name Rep_name, ");
		sql.append(" empreturn.code Empr_code, ");
		sql.append(" empreturn.name Empr_name, ");
		sql.append("(select MAX(print_times) FROM bl_prepay_pat_rcpt where a0.id_paypat=id_Paypat) reprint_times ");
		sql.append("FROM ");
		sql.append(" bl_prepay_pat a0  ");
		sql.append(" LEFT JOIN BD_UDIDOC udidoclist ON A0.ID_PAYTP=UDIDOCLIST.ID_UDIDOC ");
		sql.append(" LEFT JOIN PI_PAT pat ON a0.id_pat=pat.id_pat ");
		sql.append(" LEFT JOIN bd_entp entp ON a0.id_enttp=entp.id_entp ");
		sql.append(" LEFT JOIN bd_pri_pm pm ON a0.id_pm=pm.id_pm ");
		sql.append(" LEFT JOIN BD_UDIDOC bank ON a0.id_bank=bank.ID_UDIDOC ");
		sql.append(" LEFT JOIN bd_dep dep ON a0.id_dep_pay=dep.id_dep ");
		sql.append(" LEFT JOIN BD_PSNDOC psndoc ON a0.id_emp_pay=psndoc.id_psndoc ");
		sql.append(" LEFT JOIN bd_incca incca ON a0.id_incca=incca.id_incca ");
		sql.append(" LEFT JOIN BD_UDIDOC replost ON a0.id_rep_lost=replost.ID_UDIDOC ");
		sql.append(" LEFT JOIN bd_psndoc empreturn ON a0.id_emp_return=empreturn.id_psndoc ");
		sql.append("WHERE ");
		sql.append(" ( ");
		//by lim 2018-08-02 组织走工具类
		//sql.append(" a0.Id_org = '0001HY1000000000OH85' ");
		sql.append(BlGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "a0"));
		sql.append(")   ");
		sql.append("AND a0.ds = 0  ");
		if (!StringUtil.isEmpty(whereStr)) {
			sql.append("and ");
			sql.append(whereStr);
		}
		if (!StringUtil.isEmpty(orderStr)) {
			sql.append("ORDER BY  ");
			sql.append(orderStr);
		}
	
		return sql.toString();
	}

}
