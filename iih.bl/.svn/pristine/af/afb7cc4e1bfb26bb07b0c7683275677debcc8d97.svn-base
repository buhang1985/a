package iih.bl.itf.trasnsferandqry.bp;

import iih.bl.itf.accountinformation.d.AccountInfomationDTO;
import iih.bl.itf.tasktransfered.d.TaskTransferedDTO;
import iih.bl.itf.transferdetails.d.TransferDetailsDTO;
import iih.bl.itf.transferqry.d.TransferInfoDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class TransferProAndQueryBP {
	
	/**
	 * 获取转账详细信息
	 * @param id_pat
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws BizException
	 * @author dongjiye
	 */
	public TransferDetailsDTO[] transferDetailsBP(String code) throws BizException{
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		StringBuffer sql = new StringBuffer();
		sql.append("select pat.code   Pat_code,");
		sql.append("       pat.name   Pat_name,");
		sql.append("       pm.name    Pay_org_ment,");
		sql.append("       pre.amt    Amt,");
		sql.append("       doc.name   Bank,");
		sql.append("       pre.bankno Bank_card_id,");
		sql.append("       pre.dt_pay Pay_tme");
		sql.append("  from bl_prepay_pat pre");
		sql.append(" inner join pi_pat pat");
		sql.append("    on pat.id_pat = pre.id_pat");
		sql.append(" inner join (select ip.code_amr_ip, ip.dt_disc, ip.id_dep_phyadm, en.id_ent");
		sql.append("               from en_ent_ip ip");
		sql.append("              inner join en_ent en");
		sql.append("                 on en.id_ent = ip.id_ent) ent");
		sql.append("    on ent.id_ent = pre.id_ent");
		sql.append(" inner join bd_pri_pm pm");
		sql.append("    on pre.id_pm = pm.id_pm");
		sql.append(" left join bd_udidoc doc");
		sql.append("    on pre.id_bank = doc.id_udidoc");
		sql.append(" where pre.eu_direct = '-1'");
		sql.append("   and pre.sd_pm = '02'");
		sql.append("   and pre.fg_refund_manual = 'Y'");
		sql.append("   and pre.sd_paytp = '12'");
		sql.append("   and pat.code = ").append("'").append(code).append("'");
		sql.append("union all").append(" ");
		sql.append("select pat.code   Pat_code,");
		sql.append("       pat.name   Pat_name,");
		sql.append("       pm.name    Pay_org_ment,");
		sql.append("       itm.amt    Amt,");
		sql.append("       doc.name   Bank,");
		sql.append("       itm.bankno Bank_card_id,");
		sql.append("       pay.dt_pay Pay_tme");
		sql.append("  from bl_pay_pat_ip pay");
		sql.append(" inner join (select ip.code_amr_ip, ip.dt_disc, ip.id_dep_phyadm, en.id_ent");
		sql.append("               from en_ent_ip ip");
		sql.append("              inner join en_ent en");
		sql.append("                 on en.id_ent = ip.id_ent) ent");
		sql.append("    on ent.id_ent = pay.id_ent");
		sql.append(" inner join pi_pat pat");
		sql.append("    on pat.id_pat = pay.id_pat");
		sql.append(" inner join bl_pay_itm_pat_ip itm");
		sql.append("    on pay.id_paypatip = itm.id_paypatip");
		sql.append(" inner join bl_st_ip st");
		sql.append("    on pay.id_stip = st.id_stip");
		sql.append(" inner join bd_pri_pm pm");
		sql.append("    on itm.id_pm = pm.id_pm");
		sql.append("  left join bd_udidoc doc");
		sql.append("    on itm.id_bank = doc.id_udidoc");
		sql.append(" where st.fg_canc <> 'Y'");
		sql.append("   and itm.id_paypat is not null");
		sql.append("   and itm.sd_pm = '02'");
		sql.append("   and itm.fg_realpay = 'Y'");
		sql.append("   and itm.fg_refund_manual = 'Y'");
		sql.append("   and pat.code = ").append("'").append(code).append("'");
		List<TransferDetailsDTO> list = (List<TransferDetailsDTO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(TransferDetailsDTO.class));
		if(ListUtil.isEmpty(list)){
			return null;
		}
		return list.toArray(new TransferDetailsDTO []{});
		
	}

	
	
	/**
	 * 转账查询节点转账详细信息查询
	 * 以bl_transBlankAcc_info表为主
	 * @param qryNode
	 * @return
	 * @throws BizException
	 * @author dong.jy
	 */
	@SuppressWarnings("unchecked")
	public TransferInfoDTO[] transferInfoQryBP(QryRootNodeDTO qryNode) throws BizException{
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
	    String whereStr = qrySQLGeneratorService.getQueryStringWithoutDesc(qryNode);
		StringBuffer sql = new StringBuffer();
		sql.append("select pat.code Pat_code,");
		sql.append("       pat.name Pat_name,");
		sql.append("       pm.name  Pay_org_ment,");
		sql.append("       info.amt Amt,");
		sql.append("       info.bank_name Bank,");
		sql.append("       info.bank_id_code Bank_no,");
		sql.append("       pre.dt_pay Pay_time,");
		sql.append("       info.id_emp_transacc Id_emp_transacc,");
		sql.append("       info.dt_tansacc Transfer_time");
		sql.append("  from bl_transBlankAcc_info info");
		sql.append(" inner join pi_pat pat");
		sql.append("    on pat.id_pat = info.id_pat");
		sql.append(" inner join bl_prepay_pat pre");
		sql.append("    on pre.id_pat = info.id_pat");
		sql.append(" inner join (select ip.code_amr_ip, ip.dt_disc, ip.id_dep_phyadm, en.id_ent");
		sql.append("               from en_ent_ip ip");
		sql.append("              inner join en_ent en");
		sql.append("                 on en.id_ent = ip.id_ent) ent");
		sql.append("    on ent.id_ent = pre.id_ent");
		sql.append(" inner join bd_pri_pm pm");
		sql.append("    on pre.id_pm = pm.id_pm");
		sql.append(" where pre.eu_direct = '-1'");
		sql.append("   and pre.sd_pm = '02'");
		sql.append("   and pre.fg_refund_manual = 'Y'");
		sql.append("   and pre.sd_paytp = '12'");
		if(whereStr != null){
			sql.append("and").append(whereStr).append("");
		}
		sql.append("   union all ");
		sql.append("select pat.code Pat_code,");
		sql.append("       pat.name Pat_name,");
		sql.append("       pm.name Pay_org_ment,");
		sql.append("       info.amt Amt,");
		sql.append("       info.bank_name Bank,");
		sql.append("       info.bank_id_code Bank_no,");
		sql.append("       pay.dt_pay Pay_time,");
		sql.append("       info.id_emp_transacc Id_emp_transacc,");
		sql.append("       info.dt_tansacc Transfer_time");
		sql.append("  from bl_transBlankAcc_info info");
		sql.append(" inner join pi_pat pat");
		sql.append("    on pat.id_pat = info.id_pat");
		sql.append(" inner join bl_pay_pat_ip pay");
		sql.append("    on pay.id_pat = info.id_pat");
		sql.append(" inner join bl_pay_itm_pat_ip itm");
		sql.append("    on pay.id_paypatip = itm.id_paypatip");
		sql.append(" inner join bl_st_ip st");
		sql.append("    on pay.id_stip = st.id_stip");
		sql.append(" inner join (select ip.code_amr_ip, ip.dt_disc, ip.id_dep_phyadm, en.id_ent");
		sql.append("               from en_ent_ip ip");
		sql.append("              inner join en_ent en");
		sql.append("                 on en.id_ent = ip.id_ent) ent");
		sql.append("    on ent.id_ent = pay.id_ent");
		sql.append(" inner join bd_pri_pm pm");
		sql.append("    on itm.id_pm = pm.id_pm");
		sql.append(" where st.fg_canc <> 'Y'");
		sql.append("   and itm.id_paypat is not null");
		sql.append("   and itm.sd_pm = '02'");
		sql.append("   and itm.fg_realpay = 'Y'");
		sql.append("   and itm.fg_refund_manual='Y'");
		if(whereStr != null){
			sql.append("and").append(whereStr).append("");
		}
		List<TransferInfoDTO> list = (List<TransferInfoDTO>) new DAFacade().execQuery(sql.toString(), 
				new BeanListHandler(TransferInfoDTO.class));
		if(ListUtil.isEmpty(list)){
			return null;
		}
		return list.toArray(new TransferInfoDTO []{});
		
		
	}


	/**
	 * 转账处理节点    查询待转账任务的数据
	 * @param id_pat
	 * @param begin_date
	 * @param end_date
	 * @return
	 * @throws BizException
	 * @author dongjiye
	 */
	public TaskTransferedDTO[] taskTransferedQryBP(QryRootNodeDTO qryNode) throws BizException{
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
	    String whereStr = qrySQLGeneratorService.getQueryStringWithoutDesc(qryNode);
		StringBuffer sql = new StringBuffer();
		sql.append("select Pat_name,Code_amr_ip,sum(Pre_amt) Pre_amt,Id_pat from (");
		sql.append(" select pat.name Pat_name, ent.code_amr_ip Code_amr_ip, pre.amt Pre_amt,pat.id_pat Id_pat");
		sql.append("  from bl_prepay_pat pre");
		sql.append(" inner join pi_pat pat");
		sql.append("    on pat.id_pat = pre.id_pat");
		sql.append(" inner join (select ip.code_amr_ip, ip.dt_disc, ip.id_dep_phyadm, en.id_ent");
		sql.append("               from en_ent_ip ip");
		sql.append("              inner join en_ent en");
		sql.append("                 on en.id_ent = ip.id_ent) ent");
		sql.append("    on ent.id_ent = pre.id_ent");
		sql.append(" where pre.eu_direct = '-1'");
		sql.append("   and pre.sd_pm = '02'");
		sql.append("   and pre.sd_paytp = '12'");
		sql.append("   and pre.fg_refund_manual = 'Y'");	
		if(whereStr != null){
			sql.append("and").append(whereStr).append("");
		}
		sql.append("union all");
		sql.append(" select pat.name Pat_name, ent.code_amr_ip Code_amr_ip, pay.amt Pre_amt,pat.id_pat Id_pat");
		sql.append("  from bl_pay_pat_ip pay");
		sql.append(" inner join (select ip.code_amr_ip, ip.dt_disc, ip.id_dep_phyadm, en.id_ent");
		sql.append("               from en_ent_ip ip");
		sql.append("              inner join en_ent en");
		sql.append("                 on en.id_ent = ip.id_ent) ent");
		sql.append("    on ent.id_ent = pay.id_ent");
		sql.append(" inner join pi_pat pat");
		sql.append("    on pat.id_pat = pay.id_pat");
		sql.append(" inner join bl_pay_itm_pat_ip itm");
		sql.append("    on pay.id_paypatip = itm.id_paypatip");
		sql.append(" inner join bl_st_ip st");
		sql.append("    on pay.id_stip = st.id_stip");
		sql.append(" where st.fg_canc <> 'Y'");
		sql.append("   and itm.id_paypat is not null");
		sql.append("    and itm.sd_pm = '02'");
		sql.append("   and itm.fg_realpay = 'Y'");
		sql.append("   and itm.fg_refund_manual='Y'");
		if(whereStr != null){
			sql.append("and").append(whereStr).append("");
		}
		sql.append(") group by  Pat_name,Code_amr_ip,Id_pat");
		List<TaskTransferedDTO> list = (List<TaskTransferedDTO>) new DAFacade().execQuery(sql.toString(), 
				new BeanListHandler(TaskTransferedDTO.class));
		if(ListUtil.isEmpty(list)){
			return null;
		}
		return list.toArray(new TaskTransferedDTO []{});		
		
	}
	
	
	/**
	 * 转账处理节点 账户信息查询
	 * @param qryNode
	 * @return
	 * @throws BizException
	 * @author dong.jy
	 */
	@SuppressWarnings("unchecked")
	public AccountInfomationDTO[] getAccountInfoBP(String id_pat) throws BizException{
		//获得查询方案的String查询条件
	    IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct Bank_id_code,Create_time, Account,Account_name,Account_apen_agenc,Pat_code,Pat_name from  (");
		sql.append(" select bank.createdtime Create_time,");
		sql.append("       bank.no_acc Account,");
		sql.append("       bank.name_acc Account_name,");
		sql.append("       bank.bank_name Account_apen_agenc,");
		sql.append("       bank.bank_id_code Bank_id_code,");
		sql.append("       pat.code Pat_code,");
		sql.append("       pat.name Pat_name");
		sql.append("  from bl_prepay_pat pre");
		sql.append(" inner join pi_pat pat");
		sql.append("    on pat.id_pat = pre.id_pat");
		sql.append(" inner join (select ip.code_amr_ip, ip.dt_disc, ip.id_dep_phyadm, en.id_ent");
		sql.append("               from en_ent_ip ip");
		sql.append("              inner join en_ent en");
		sql.append("                 on en.id_ent = ip.id_ent) ent");
		sql.append("    on ent.id_ent = pre.id_ent");
		sql.append(" inner join en_ent_bankacc bank");
		sql.append("    on pre.id_pat = bank.id_pat");
		sql.append(" where pre.eu_direct = '-1'");
		sql.append("   and pre.sd_pm = '02'");
		sql.append("   and pre.sd_paytp = '12'");
		sql.append("   and pre.fg_refund_manual = 'Y'");
		sql.append("   and pat.id_pat = ").append("'").append(id_pat).append("'");
		sql.append("   union all");
		sql.append(" select bank.createdtime Create_time,");
		sql.append("       bank.no_acc Account,");
		sql.append("       bank.name_acc Account_name,");
		sql.append("       bank.bank_name Account_apen_agenc,");
		sql.append("       bank.bank_id_code Bank_id_code,");
		sql.append("       pat.code Pat_code,");
		sql.append("       pat.name Pat_name");
		sql.append("  from bl_pay_pat_ip pay");
		sql.append(" inner join (select ip.code_amr_ip, ip.dt_disc, ip.id_dep_phyadm, en.id_ent");
		sql.append("               from en_ent_ip ip");
		sql.append("              inner join en_ent en");
		sql.append("                 on en.id_ent = ip.id_ent) ent");
		sql.append("    on ent.id_ent = pay.id_ent");
		sql.append(" inner join pi_pat pat");
		sql.append("    on pat.id_pat = pay.id_pat");
		sql.append(" inner join bl_pay_itm_pat_ip itm");
		sql.append("    on pay.id_paypatip = itm.id_paypatip");
		sql.append(" inner join bl_st_ip st");
		sql.append("    on pay.id_stip = st.id_stip");
		sql.append(" inner join en_ent_bankacc bank");
		sql.append("    on pay.id_pat = bank.id_pat");
		sql.append(" where st.fg_canc <> 'Y'");
		sql.append("   and itm.id_paypat is not null");
		sql.append("   and itm.sd_pm = '02'");
		sql.append("   and itm.fg_realpay = 'Y'");
		sql.append("   and itm.fg_refund_manual='Y'");
		sql.append("   and pat.id_pat = ").append("'").append(id_pat).append("'");
		sql.append(")");
		List<AccountInfomationDTO> list = (List<AccountInfomationDTO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(AccountInfomationDTO.class));
		if(ListUtil.isEmpty(list)){
			return null;
		}
		return list.toArray(new AccountInfomationDTO []{});		
	}
	
	public AccountInfomationDTO[] getAccountInfoqryBP(QryRootNodeDTO qryNode) throws BizException{
		
		//获得查询方案的String查询条件
	    IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
	    String whereStr = qrySQLGeneratorService.getQueryStringWithoutDesc(qryNode);
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct Bank_id_code,Create_time, Account,Account_name,Account_apen_agenc,Pat_code,Pat_name from  (");
		sql.append(" select bank.createdtime Create_time,");
		sql.append("       bank.no_acc Account,");
		sql.append("       bank.name_acc Account_name,");
		sql.append("       bank.bank_name Account_apen_agenc,");
		sql.append("       bank.bank_id_code Bank_id_code,");
		sql.append("       pat.code Pat_code,");
		sql.append("       pat.name Pat_name");
		sql.append("  from bl_prepay_pat pre");
		sql.append(" inner join pi_pat pat");
		sql.append("    on pat.id_pat = pre.id_pat");
		sql.append(" inner join (select ip.code_amr_ip, ip.dt_disc, ip.id_dep_phyadm, en.id_ent");
		sql.append("               from en_ent_ip ip");
		sql.append("              inner join en_ent en");
		sql.append("                 on en.id_ent = ip.id_ent) ent");
		sql.append("    on ent.id_ent = pre.id_ent");
		sql.append(" inner join en_ent_bankacc bank");
		sql.append("    on pre.id_pat = bank.id_pat");
		sql.append(" where pre.eu_direct = '-1'");
		sql.append("   and pre.sd_pm = '02'");
		sql.append("   and pre.sd_paytp = '12'");
		sql.append("   and pre.fg_refund_manual = 'Y'");
		if(whereStr != null){
			sql.append("and").append(whereStr).append(" ");
		}
		sql.append("   union all");
		sql.append(" select bank.createdtime Create_time,");
		sql.append("       bank.no_acc Account,");
		sql.append("       bank.name_acc Account_name,");
		sql.append("       bank.bank_name Account_apen_agenc,");
		sql.append("       bank.bank_id_code Bank_id_code,");
		sql.append("       pat.code Pat_code,");
		sql.append("       pat.name Pat_name");
		sql.append("  from bl_pay_pat_ip pay");
		sql.append(" inner join (select ip.code_amr_ip, ip.dt_disc, ip.id_dep_phyadm, en.id_ent");
		sql.append("               from en_ent_ip ip");
		sql.append("              inner join en_ent en");
		sql.append("                 on en.id_ent = ip.id_ent) ent");
		sql.append("    on ent.id_ent = pay.id_ent");
		sql.append(" inner join pi_pat pat");
		sql.append("    on pat.id_pat = pay.id_pat");
		sql.append(" inner join bl_pay_itm_pat_ip itm");
		sql.append("    on pay.id_paypatip = itm.id_paypatip");
		sql.append(" inner join bl_st_ip st");
		sql.append("    on pay.id_stip = st.id_stip");
		sql.append(" inner join en_ent_bankacc bank");
		sql.append("    on pay.id_pat = bank.id_pat");
		sql.append(" where st.fg_canc <> 'Y'");
		sql.append("   and itm.id_paypat is not null");
		sql.append("   and itm.sd_pm = '02'");
		sql.append("   and itm.fg_realpay = 'Y'");
		sql.append("   and itm.fg_refund_manual='Y'");
		if(whereStr != null){
			sql.append("and").append(whereStr).append(" ");
		}
		sql.append(")");
		List<AccountInfomationDTO> list = (List<AccountInfomationDTO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(AccountInfomationDTO.class));
		if(ListUtil.isEmpty(list)){
			return null;
		}
		return list.toArray(new AccountInfomationDTO []{});		
		
	}

}
