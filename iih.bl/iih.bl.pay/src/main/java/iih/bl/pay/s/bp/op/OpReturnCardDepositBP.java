package iih.bl.pay.s.bp.op;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.comm.IBlConst;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.blpayspcl.d.BlPayItmSpclDO;
import iih.bl.pay.blpayspcl.d.BlPaySpclDO;
import iih.bl.pay.blpayspcl.d.BlpayspclAggDO;
import iih.bl.pay.blspclpat.d.BlSpclPatDO;
import iih.bl.pay.blspclpat.d.BlspclpatAggDO;
import iih.bl.pay.dto.blprepaydto.d.BlPrepayDTO;
import iih.bl.pay.s.ep.PatSpclEP;
import iih.bl.pay.s.ep.PatSpclPayEP;
import iih.pi.acc.account.i.IPatAccServiceExt;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 患者卡退押金
 * @author ly 2018/05/20
 *
 */
public class OpReturnCardDepositBP {

	/**
	 * 患者卡退押金
	 * 
	 * @param patId 患者id
	 * @param patCardId 患者卡信息id
	 * @throws BizException
	 */
	public void exec(BlPrepayDTO dto) throws BizException {
		
		this.validate(dto);
		
		// 1.查询原专用款数据
		PatSpclEP patSpclEp = new PatSpclEP();
		BlspclpatAggDO spclPatAggDO =  patSpclEp.findBySrcId(dto.getId_patcard());
		this.validateSplcPat(spclPatAggDO);
		
		// 2.组装保存专用款收付款数据
		BlpayspclAggDO paySpclAggDO = this.savePaySpcl(dto);
		
		// 3.更新专用款数据
		this.updateSpclPat(spclPatAggDO, paySpclAggDO);
		
		FBoolean transferToPrepay = BlParams.BLPREPAY0006();
		if(FBoolean.TRUE.equals(transferToPrepay)){
			// 3.1转移退卡费到预交金中，生成预交金充值记录
			this.transferToPrepay(dto);
		}
		
		// 4.更新患者账户
		IPatAccServiceExt accService = ServiceFinder.find(IPatAccServiceExt.class);
		// 锁定额度
		accService.PatiAccPreAuthor(dto.getId_pat(), dto.getCard_amt().multiply(IBlConst.NEGATIVE_ONE_DBL));
		if(!FBoolean.TRUE.equals(transferToPrepay)){
			// 预交金
			accService.updatePatPrepay(dto.getId_pat(), dto.getCard_amt().multiply(IBlConst.NEGATIVE_ONE_DBL));
		}
	}
	
	/**
	 * 入参校验
	 * @param dto
	 * @throws BizException
	 */
	private void validate(BlPrepayDTO dto) throws BizException {

		if(dto == null){
			throw new ArgumentNullException("患者卡退押金","患者预交金dto");
		}
	}

	/**
	 * 校验原专用款数据
	 * @param spclPatAggDO
	 * @throws BizException
	 */
	private void validateSplcPat(BlspclpatAggDO spclPatAggDO) throws BizException {
		
		if(spclPatAggDO == null){
			throw new BizException("未查询到专用款数据");
		}
		
		BlSpclPatDO spclPat = spclPatAggDO.getParentDO();
		if(FBoolean.TRUE.equals(spclPat.getFg_close())){
			throw new BizException("专用款已经关闭，不能进行退费操作");
		}
	}

	/**
	 * 组装并保存专用款收付款数据
	 * @param patId
	 * @param amt
	 * @return
	 * @throws BizException
	 */
	private BlpayspclAggDO savePaySpcl(BlPrepayDTO dto) throws BizException {
		
		BlpayspclAggDO aggDO = new BlpayspclAggDO();
		BlPaySpclDO paySpcl = new BlPaySpclDO();
		paySpcl.setId_grp(Context.get().getGroupId());
		paySpcl.setId_org(Context.get().getOrgId());
		paySpcl.setId_pat(dto.getId_pat());
		paySpcl.setId_pttp(IBlDictCodeConst.ID_PTTP_WINDOW);
		paySpcl.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		paySpcl.setEu_direct(BookRtnDirectEnum.RETURNS);
		paySpcl.setAmt(dto.getCard_amt());
		paySpcl.setDt_pay(AppUtils.getServerDateTime());
		paySpcl.setId_org_pay(Context.get().getOrgId());
		paySpcl.setId_dep_pay(Context.get().getDeptId());
		paySpcl.setId_emp_pay(Context.get().getStuffId());
		paySpcl.setFg_cc(FBoolean.FALSE);
		paySpcl.setNote(IBlConst.NOTE_REFUNDCARDDEPOSIT);
		paySpcl.setStatus(DOStatus.NEW);
		
		BlPayItmSpclDO payItm = new BlPayItmSpclDO();
		payItm.setId_grp(Context.get().getGroupId());
		payItm.setId_org(Context.get().getOrgId());
		payItm.setEu_direct(BookRtnDirectEnum.RETURNS);
		payItm.setId_pm(dto.getId_paymod());
		payItm.setSd_pm(dto.getCode_paymod());
		payItm.setAmt(dto.getCard_amt());
		payItm.setId_bank(dto.getId_bank());
		payItm.setBankno(dto.getNum_bank());
		payItm.setPaymodenode(dto.getPaymodeno());
		payItm.setStatus(DOStatus.NEW);
		
		aggDO.setParentDO(paySpcl);
		aggDO.setBlPayItmSpclDO(new BlPayItmSpclDO[]{payItm});
		
		aggDO = new PatSpclPayEP().save(new BlpayspclAggDO[]{aggDO})[0];
		
		return aggDO;
	}

	/**
	 * 跟新患者专用款数据
	 * @param paySpclAggDO
	 * @throws BizException
	 */
	private void updateSpclPat(BlspclpatAggDO spclPatAggDO, BlpayspclAggDO paySpclAggDO) throws BizException {
		
		BlSpclPatDO spclPat = spclPatAggDO.getParentDO();
		spclPat.setId_payspcl_out(paySpclAggDO.getParentDO().getId_payspcl());
		spclPat.setFg_close(FBoolean.TRUE);
		spclPat.setDt_close(AppUtils.getServerDateTime());
		spclPat.setId_emp_close(Context.get().getStuffId());
		spclPat.setStatus(DOStatus.UPDATED);
		
		new PatSpclEP().save(new BlspclpatAggDO[]{spclPatAggDO});
	}

	/**
	 * 转存卡费到预交金
	 * @param dto
	 * @throws BizException
	 */
	private void transferToPrepay(BlPrepayDTO dto) throws BizException {
		
		// 票据过号
		//IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
		/*String invoice = incService.nextInvoiceNoPre(
				Context.get().getStuffId(), IBdPpCodeTypeConst.ID_OUTPATIENT_DEPOSIT);*/
				
		BlPrePayPatDO prepay = new BlPrePayPatDO();
		prepay.setId_grp(Context.get().getGroupId());
		prepay.setId_org(Context.get().getOrgId());
		prepay.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAYTRANSFERFROMOP);
		prepay.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAYTRANSFERFROMOP);
		prepay.setId_pat(dto.getId_pat());
		prepay.setEu_direct(BookRtnDirectEnum.CHARGE);
		prepay.setAmt(dto.getCard_amt());
		prepay.setId_pttp(IBlDictCodeConst.ID_PTTP_WINDOW);
		prepay.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		prepay.setId_pm(dto.getId_paymod());
		prepay.setSd_pm(dto.getCode_paymod());
		prepay.setDt_pay(AppUtils.getServerDateTime());
		prepay.setId_org_pay(Context.get().getOrgId());
		prepay.setId_dep_pay(Context.get().getDeptId());
		prepay.setId_emp_pay(Context.get().getStuffId());
		prepay.setId_incca(null);
		prepay.setCode_incca(null);
		prepay.setCode_rep(null);
		prepay.setFg_cc(FBoolean.FALSE);
		prepay.setFg_rep_return(FBoolean.FALSE);
		prepay.setFg_canc(FBoolean.FALSE);
		prepay.setStatus(DOStatus.NEW);
		prepay.setNote(IBlConst.NOTE_REFUNDCARDDEPOSIT_TRANSFER);
		prepay.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		prepay.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		
		IBlpaypatCudService cudService = ServiceFinder.find(IBlpaypatCudService.class);
		cudService.save(new BlPrePayPatDO[] { prepay });
	}
}
