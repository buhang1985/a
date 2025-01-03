package iih.bl.pay.service.i;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpayspcl.d.BlpayspclAggDO;
import iih.bl.pay.blspclpat.d.BlspclpatAggDO;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import iih.bl.pay.dto.d.PrepayAccTransDTO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.patsrvpkg.dto.PiPatSrvPkgTotalDTO;
import iih.pi.patsrvpkg.patsrvpkg.d.PiPatSrvPkgDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public interface IBLPayMaintainService {
	/*
	 * 保存预交金
	 * */
	public abstract BlPrePayPatDO[] saveBlPayPatItem(BlPayPatItemDTO blPayPatItemDTO,BlPrePayPatDO blPayPatDO,String payType) throws BizException;
	
	/**
	 * 目前供门诊收费节点，退费节点，住院收付款节点使用：
	 * 收、退费方式为预交金，即在预交金中增加相关一条预交金操作记录，并修改预交金账户金额
	 * @param payment_prepay_amt 支付的预交金金额
	 * @param id_pat 患者ID
	 * @param operatorInfoDTO 操作员信息
	 * @param eu_direct 预交金收付款方向
	 * @param entType 就诊类型ID
	 * @param sd_paytp 收付款方式SD
	 * @param id_paytp 收付款方式iD
	 * @param note 备注
	 * @return
	 * @throws BizException
	 */
	public abstract  BlPrePayPatDO[] saveBlPayPatInfoByPay(FDouble payment_prepay_amt,String id_pat,OperatorInfoDTO operatorInfoDTO,Integer eu_direct,String entType,String sd_paytp,String id_paytp,String note) throws BizException;
	
	/**
	 * 门诊收费找零数据结存到预交金调用该函数
	 * @param blPayItmPatOepdo 找零金额首付款明细DO，只允许一种找零方式
	 * @param id_pat 患者主索引主键Id
	 * @param operatorInfoDTO 收费人员信息
	 * @param entType 患者就诊类型
	 * @param note 备注
	 * 
	 */
	public abstract BlPrePayPatDO[] TransferBalanceToPatacc(BlPayItmPatOepDO blPayItmPatOepdo,String id_pat,OperatorInfoDTO operatorInfoDTO,String entType,String note) throws BizException;
	
	/*
	 * 作废预交金
	 * */
	public abstract void abolishBlPayPat(BlPrePayPatDO blPayPatDO, BlPrePayPatDO abolishDO,String payType) throws BizException;
	 
	
	/**
	 * 更新患者门诊账户和就诊账户信息，向患者收付款明细中插入两条转入转出记录,当 【门诊账户转入住院账户时】  调用
	 * 这里的BlPrePayPatDO参数是为了接到从前台传的当前登录的用户、机构、部门、操作人员等字段信息保存到新插入的预交金数据中
	 * @param blpreppDO
	 * @param ppatDTO
	 * @param pipatdo
	 * @param eacdo
	 * @author li_pengying
	 * @throws BizException
	 */
	public  abstract String PrepayAcctransProcessingOepToIp(BlPrePayPatDO blpreppDO,PrepayAccTransDTO ppatDTO,PiPatAccDO pipatdo,EnAccountDO eacdo)throws BizException;
	
	/**
	 * 更新患者门诊账户和就诊账户信息，向患者收付款明细中插入两条转入转出记录,当 【住院就诊账户转入患者门诊账户时】  调用,这里的BlPrePayPatDO参数是为了接到从前台传的当前登录的用户、机构、部门、操作人员等字段信息保存到新插入的预交金数据中
	 * @param blprepaypatdo
	 * @param ppatDTO
	 * @param pipatdo
	 * @param eacdo
	 * @author li_pengying
	 * @throws BizException
	 */
	public abstract void PrepayAcctransProcessingIpToOep(BlPrePayPatDO blpreppDO,PrepayAccTransDTO ppatDTO,PiPatAccDO pipatdo,EnAccountDO eacdo)throws BizException;
	
	/**
	 *门诊 预交金退款   ，给刘羽提供接口用
	 * @param id_pat 患者id
	 * @param amt 退款金额
	 * @param id_pm 支付方式id
	 * @param id_bank 银行id
	 * @param bankno 银行卡号
	 * @param code_rep 票号
	 * */
	public abstract FBoolean doBlPrePayRefund(BlPrePayPatDO blpreppDO) throws BizException;


    /**
     * 保存优惠包销售数据，包括保存下来调入的数据和新增的数据，所以保存的均为数组形式的数据
     * @param ppSrvPkgDOArr     患者服务包数组,一个服务包对应一个AggDO
     * @param pppkgGrAggDOArr   患者服务包分组AggDO的数组，一个服务包对应一个AggDO
     * @param blpppDOArr        如果支付方式中包含有预交金支付方式，则需要写入预交金明细记录
     * @param blspclpatAggDOArr 患者专用款AggDO的数组,一个服务包对应一个AggDO
     * @param blpayspclAggDO    所有的服务包最终生成一个收付款专用款AggDO
     * @author li_pengying
     * @return
     */
	public abstract  FBoolean doSaveNewAndUpdateData(PiPatSrvPkgDO[] ppspDOArr, PiPatSrvPkgTotalDTO[] pkgs,BlPrePayPatDO[]  blpppDOArr,
	            BlspclpatAggDO[] blspclpatAggDOArr, BlpayspclAggDO blpayspclAggDO)throws BizException;

  
    /**
     * 门诊预交金退费
     * @param amt_refund  退费金额
     * @param id_pat 患者主键
     * @author weijia 
     * */
    public abstract BlPrePayPatDO doBlPayPatInfoRefund(BlPayPatItemDTO blPayPatItemDTO,String id_pat,String sd_pttp) throws BizException;
    
     
	 /**
     * 留观预交金退费
     * @param amt_refund  退费金额
     * @param id_pat 患者主键
     * @author weijia 
     * */
	public abstract BlPrePayPatDO doBlPayPatETInfoRefund(BlPayPatItemDTO blPayPatItemDTO, String id_pat,String sd_pttp) throws BizException;
    /**
     * 住院预交金退费
     * @param blPrePayPatDO  被退费记录
     * @param blPayPatItemDTO 
     * @author weijia 
     * */
    public abstract FBoolean doBlPayPatIpInfoRefund(BlPrePayPatDO blPrePayPatDO,BlPayPatItemDTO blPayPatItemDTO) throws BizException;
}
