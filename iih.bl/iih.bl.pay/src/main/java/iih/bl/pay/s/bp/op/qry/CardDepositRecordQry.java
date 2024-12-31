package iih.bl.pay.s.bp.op.qry;

import iih.pi.dic.cardtype.d.CardCgMdEnum;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 缴费卡押金记录查询
 * @author ly 2018/05/21
 *
 */
public class CardDepositRecordQry implements ITransQry{

	private String patId;
	private String patCardId;
	
	public CardDepositRecordQry(String patId, String patCardId){
		this.patId = patId;
		this.patCardId = patCardId;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {
		
		SqlParam param = new SqlParam();
		param.addParam(CardCgMdEnum.DEPOSIT);
		
		sqlSb.append("where spclpat.id_pat = ? ");
		sqlSb.append("and spclpat.id_src = ? ");
		
		param.addParam(patId);
		param.addParam(patCardId);
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ");
		sqlSb.append("spclpat.id_pat,");
		sqlSb.append("spclpat.amt card_amt,");
		sqlSb.append("spclpat.id_src id_patcard,");
		sqlSb.append("payitm.id_pm id_paymod,");
		sqlSb.append("pripm.code code_paymod,");
		sqlSb.append("pripm.name name_paymod,");
		sqlSb.append("payitm.id_bank,");
		sqlSb.append("bank.name name_bank,");
		sqlSb.append("payitm.bankno num_bank,");
		sqlSb.append("payitm.paymodenode paymodeno,");
		sqlSb.append("? eu_cardcgmd ");
		
		sqlSb.append("from ");
		sqlSb.append("bl_spcl_pat spclpat ");
		sqlSb.append("inner join bl_pay_spcl payspcl ");
		sqlSb.append("on spclpat.id_payspcl_in = payspcl.id_payspcl ");
		sqlSb.append("inner join bl_pay_itm_spcl payitm ");
		sqlSb.append("on payspcl.id_payspcl = payitm.id_payspcl ");
		sqlSb.append("left join bd_pri_pm pripm ");
		sqlSb.append("on payitm.id_pm = pripm.id_pm ");
		sqlSb.append("left join bd_udidoc bank ");
		sqlSb.append("on payitm.id_bank = bank.id_udidoc ");
		
		return sqlSb.toString();
	}
}
