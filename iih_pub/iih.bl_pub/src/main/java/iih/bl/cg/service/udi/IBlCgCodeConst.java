package iih.bl.cg.service.udi;
/**
 * 接口常量定义
 * @author 唐婵懿
 *
 */
public interface IBlCgCodeConst {
	//fSupportTriage_CiOrderFee接口的字符串定义	
	public static final String CODE_CI_PRICING = "0";  //医嘱已记账(住院：记入记账表；门诊：已收费）
    public static final String CODE_CI_NO_PRICING_PAYPAMET = "1"; //未计费，可用额度充足
    public static final String CODE_CI_NO_PRICING_NO_PAYPAMET = "2";  //未计费，可用额度不足

    //费用产生功能点定义 TODO 需重构,后续改为枚举或者功能点code 2017-07-10 by yankan
    public static final String IpMedDispend="ipmeddispend";//住院摆药
    public static final String IpMedReturn="ipmedreturn";//住院退药
    public static final String EexcConfirm="execconfirm";//通用医技执行确认
    public static final String EexcCancel="execcancel";//通用医技执行取消
    public static final String OpMedPrepay="opmedprepay";//门诊发药预交金
    public static final String LisOrPacs = "LisOrPacs";//第三方检查检验
    public static final String BS024 = "BS024服务计费";//集成平台BS024服务计费
  
    public static final String NurWorkStation="nurworkstation";//来源于护士工作站
    public static final String TransfusionBlood="transfusionblood";//血袋计费
    public static final String Transfusion="transfusion";//输血计费
    public static final String SampleCollection="samplecollection";//床旁标本采集
    public static final String NurWorkStationRefound="nurworkstationrefound";//护士工作站医嘱执行取消
    
    
    
    public static final String OepRtnCompensteFee="oeprtncompensatefee";//来源于门诊费用补录
    
    public static final String IpRtnCompensteFee="iprtncompensatefee";//来源于住院退补费
    public static final String OpFeeCollect="opfeecollect";//来源于门诊收费
    public static final String OpFeeRtn="opfeertn";//来源于门诊退费    
    public static final String RegisterFee="registerfee";//来源于挂号费    
    public static final String RegisterFeeFromRoom="registerfeefromRoom";//来源于诊间接诊产生的挂号费    
    public static final String RegisterFeeRtn="registerfeeRtn";//来源于挂号退号   
    public static final String PricingCg="pricingcg";//来源于后台划价记账
    public static final String RefundInpBlcgById_cgip="RefundInpBlcgById_cgip";//来源于医技退费
    
    public static final String RefundOepBlcgById_or="RefundOepBlcgById_or";//来源于医技补录项目退费（门诊）
    public static final String AppendOepBlcgByItms="AppendOepBlcgByItms";//来源于医技补录项目(门诊)
    
    public static final String RefundIpBlcgById_or="RefundIpBlcgById_or";//来源于医技补录项目退费（住院）
    public static final String AppendIpBlcgByItms="AppendIpBlcgByItms";//来源于医技补录项目(住院)
    public static final String IpDocStationCharge= "IpDocStationCharge";//住院医生站记费
    
    public static final String IpRegister = "IpRegister";//入院登记
    
    public static final String PeRtnCompensteFee="pertncompensteFee";//体检系统计费
}
