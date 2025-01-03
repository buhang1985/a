package iih.bl.pay.blpaypat.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.comm.IBlMsgConst;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.params.BlParams;
import iih.bl.pay.bp.qry.GetEnAccountDOBp;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IAccountMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;
/**
 * 查询获得票据编号、账户余额等信息。供门诊、住院收退预交金界面、住院预交金录入界面初始化加载界面时显示用，
 * @author li_pengying
 *
 */
public class GetPrepayPatItemDTOByQur {

	
	/**
	 *  获取票据编号、账户余额等信息， 查询获得票据编号、账户余额等信息。供门诊、住院收退预交金界面、住院预交金录入界面初始化加载界面时显示用，
	 * @param queryStr ，当门诊时 其为某个id_pat的值， 当住院时其值为某个id_ent的值
	 * @param id_user   当前操作员
	 * @param payType   患者收付款类型
	 * @return
	 * @throws BizException
	 */
	public BlPayPatItemDTO getBlPayPatItemDTOByQur(String queryStr,String id_user,String payType)
			throws BizException{
		//主要业务：  1.查询出当前操作员可用票据号   2.查出账户余额  消费额等金额信息 ，赋给BlPayPatItemDTO的相应字段      3.为交易方式等字段赋初值  4.将组装好的用于前台显示的数据BlPayPatItemDTO返回
		BlPayPatItemDTO blPayPatItemDTO = new BlPayPatItemDTO();
		// 1查出票据号  ，获取票据编码
		/*GetInvoiceInfoBP incBp =new GetInvoiceInfoBP();
		String  code_rep= incBp.getInvoiceInfo(id_user, payType);*/
		
		String inccaId = null;
		FBoolean autoCode = null;
		if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType)){
			inccaId = IBdInccaCodeConst.ID_INHOS_DEPOSIT;
			autoCode = BlParams.BLINC0018();
		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType)){
			inccaId = IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT;
			autoCode = BlParams.BLINC0017();
		}
		else if (IBdFcDictCodeConst.ID_CODE_ENTP_ET_OBS.equals(payType)){
			inccaId = IBdInccaCodeConst.ID_ET_INVOICE;
			autoCode = BlParams.BLINC0017(); // 需要新增参数，暂时使用门诊
		}
		
		if(FBoolean.FALSE.equals(autoCode)){
			IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
			String code_rep = incService.getCurInvoiceNo(id_user, Context.get().getClientHost(), inccaId);
			if(code_rep == null || code_rep.isEmpty()){
				throw new BizException(IBlMsgConst.ERROR_INVOICE_ALERT);
			}
			blPayPatItemDTO.setCode_rep(code_rep);
		}
		
		//判断业务类型（门诊/住院）
		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType) || IBdFcDictCodeConst.ID_CODE_ENTP_ET_OBS.equals(payType))
		{
			//2.查出账户余额  消费额等金额信息 ，赋给BlPayPatItemDTO的相应字段
			PiPatAccDO[] accountArr = this.getPipatAccountByIdpat(queryStr.toString()) ;
			if(accountArr == null || accountArr.length == 0)
			{
				throw new BizException(IBlMsgConst.ERROR_PATACC_NOT_EXIST);
			}
          	this.setValues(payType, blPayPatItemDTO,accountArr[0],null );
		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType)){
			//2.查出账户余额  消费额等金额信息 ，赋给BlPayPatItemDTO的相应字段
			IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
			PatiVisitDO patiVisitDO = enService.getEnInfo(queryStr.toString());
			if(patiVisitDO == null){
				throw new BizException(IBlMsgConst.ERROR_ENT_NOT_EXIST);
			}
			blPayPatItemDTO.setCode_ent(patiVisitDO.getCode());
			//得到就诊账户
			GetEnAccountDOBp entAccBp = new GetEnAccountDOBp();
			EnAccountDO enAccountDO = entAccBp.execQryEnAccountDOByIdentidpat(queryStr.toString(), patiVisitDO.getId_pat());
			if(enAccountDO == null)
			{
				throw new BizException(IBlMsgConst.ERROR_ENTACC_NOT_EXIST);
			}
			this.setValues(payType, blPayPatItemDTO, null, enAccountDO);
		}
		
		//  3.为交易方式等字段赋初值      ：默认选中现金
		IUdidocRService udService = (IUdidocRService)ServiceFinder.find(IUdidocRService.class);
		UdidocDO udidocDO = udService.findById(IBdPripmCodeConst.ID_PRI_PM_CASH);
		blPayPatItemDTO.setId_paymod(IBdPripmCodeConst.ID_PRI_PM_CASH);
		blPayPatItemDTO.setPaymod_code(IBdPripmCodeConst.CODE_PRI_PM_CASH);
		blPayPatItemDTO.setPaymod_name(udidocDO.getName());
		return blPayPatItemDTO;
	}
	
	/**
	 *  获取账户余额等信息， 查询账户余额等信息。
	 * @param queryStr ，当门诊时 其为某个id_pat的值， 当住院时其值为某个id_ent的值
	 * @param payType   患者就诊类型ID
	 * @return
	 * @throws BizException
	 */
	public BlPayPatItemDTO getBlPayPatItemByQur(String queryStr, String payType) throws BizException {
		BlPayPatItemDTO blPayPatItemDTO = new BlPayPatItemDTO();

		// 判断业务类型（门诊/住院）
		if (IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType)
				|| IBdFcDictCodeConst.ID_CODE_ENTP_ET_OBS.equals(payType)) {
			// 2.查出账户余额 消费额等金额信息 ，赋给BlPayPatItemDTO的相应字段
			PiPatAccDO[] accountArr = this.getPipatAccountByIdpat(queryStr.toString());
			if (accountArr == null || accountArr.length == 0) {
				throw new BizException(IBlMsgConst.ERROR_PATACC_NOT_EXIST);
			}
			this.setValues(payType, blPayPatItemDTO, accountArr[0], null);
		} else if (IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType)) {
			// 2.查出账户余额 消费额等金额信息 ，赋给BlPayPatItemDTO的相应字段
			IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
			PatiVisitDO patiVisitDO = enService.getEnInfo(queryStr.toString());
			if (patiVisitDO == null) {
				throw new BizException(IBlMsgConst.ERROR_ENT_NOT_EXIST);
			}
			blPayPatItemDTO.setCode_ent(patiVisitDO.getCode());
			// 得到就诊账户
			GetEnAccountDOBp entAccBp = new GetEnAccountDOBp();
			EnAccountDO enAccountDO = entAccBp.execQryEnAccountDOByIdentidpat(queryStr.toString(),
					patiVisitDO.getId_pat());
			if (enAccountDO == null) {
				throw new BizException(IBlMsgConst.ERROR_ENTACC_NOT_EXIST);
			}
			this.setValues(payType, blPayPatItemDTO, null, enAccountDO);
		}

		return blPayPatItemDTO;
	}
	
	private  BlPayPatItemDTO  setValues(String  payType, BlPayPatItemDTO blPayPatItemDTO,PiPatAccDO ppaccDO ,EnAccountDO enaccDO) throws BizException{
		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType))
		{
			blPayPatItemDTO.setPrepay(ppaccDO.getPrepay());
			blPayPatItemDTO.setAmt_cred(ppaccDO.getAcc_lock());
			blPayPatItemDTO.setAmt_balance(ppaccDO.getPrepay().sub(ppaccDO.getAcc_lock()));
		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType))
		       {
			     blPayPatItemDTO.setPrepay(enaccDO.getAmt_prepay());
			     blPayPatItemDTO.setAmt_cred(enaccDO.getAmt_uncg());
			     blPayPatItemDTO.setAmt_balance(enaccDO.getAmt_prepay().sub(enaccDO.getAmt_uncg()));
		       }
		else if(IBdFcDictCodeConst.ID_CODE_ENTP_ET_OBS.equals(payType))
		{
			if (ppaccDO.getPrepay_emgstay() != null)
				blPayPatItemDTO.setPrepay(ppaccDO.getPrepay_emgstay());
			else
				blPayPatItemDTO.setPrepay(new FDouble(0.00));
			if (ppaccDO.getAcc_lock_emgstay() != null)
				blPayPatItemDTO.setAmt_cred(ppaccDO.getAcc_lock_emgstay());
			else
				blPayPatItemDTO.setAmt_cred(new FDouble(0.00));
			blPayPatItemDTO.setAmt_balance(
					(ppaccDO.getPrepay_emgstay() == null ? new FDouble(0.00) : ppaccDO.getPrepay_emgstay())
							.sub((ppaccDO.getAcc_lock_emgstay() == null ? new FDouble(0.00)
									: ppaccDO.getAcc_lock_emgstay())));

		}
		if(new FDouble(0.00).compareTo(blPayPatItemDTO.getAmt_balance()) > 0)
			blPayPatItemDTO.setAmt_needpay(new FDouble(0.00).sub(blPayPatItemDTO.getAmt_balance()));
		else  
			blPayPatItemDTO.setAmt_needpay(new FDouble(0.00));

		
		return  blPayPatItemDTO ;
	}
	
	/**
	 * 由患者主键ID查询获得 患者账户
	 * @param id_pat 患者主键id
	 * @return
	 * @throws BizException
	 */
	private PiPatAccDO[] getPipatAccountByIdpat(String id_pat) throws BizException
	{
		IAccountMDORService accRService = (IAccountMDORService)ServiceFinder.find(IAccountMDORService.class);
		PiPatAccDO[] accountArr = accRService.find(" a0.id_pat = '" + id_pat + "'","id_patacc desc",FBoolean.FALSE);
	    return accountArr;
	}
}
