package iih.bd.bc.udi.pub;

/**
 * 费用管理模块(IIH.BL)相关的基础数据常量定义。
 */
public interface IBlDictCodeConst {
	
    /*
     * 0505收退费方向
     * */
    public static final String SD_DIRECT_CHARGE = "1"; //收费
    public static final String SD_DIRECT_REFUND = "-1"; //退费
    
    /* 
    * 0520结算结果分类
    **/
    public static String SD_STRESULT_NORMAL = "0";//正常结算
    public static String SD_STRESULT_ARREARAGE = "1";//欠款结算
    public static String SD_STRESULT_DEPOSIT = "2";//存款结算
    
    public static String ID_STRESULT_NORMAL = "@@@@AA1000000003RF0I";//正常结算
    public static String ID_STRESULT_ARREARAGE = "@@@@AA1000000003RF0J";//欠款结算
    public static String ID_STRESULT_DEPOSIT = "@@@@AA1000000003RF0K";//存款结算
    
    /**
     * 0530患者收付款类型
     * */
    public static final String SD_PAYTP_ST = "01";//结算
    public static final String SD_PAYTP_MIDST = "02";//中途结算
    public static final String SD_PAYTP_STRED = "03";//结算冲账
    public static final String SD_PAYTP_ARREARSPAY = "04";//欠费补交
    public static final String SD_PAYTP_CANCELST = "05";//取消结算
    public static final String SD_PAYTP_OPPREPAY = "11";//患者预交金
    public static final String SD_PAYTP_IPPREPAY = "12";//住院流程预交金
    public static final String SD_PAYTP_PECMPYPREPAY="13";//团检流程预交金
    public static final String SD_PAYTP_IPPREPAYTRANSFER = "14";//住院流程预交金（转入）
    public static final String SD_PAYTP_IPPREPAYSTTRANSFER = "15";//住院流程预交金（结转）
    public static final String SD_PAYTP_PECMPYPREPAYSTTRANSFER = "16";//单位团检流程预交金（结转）
    public static final String SD_PAYTP_IPPREPAYTRANSFERFROMOP = "17";//患者预交金转住院预交金
    public static final String SD_PAYTP_IPCANCELTRADERESTORE = "18";//住院取消出纳退还押金
    public static final String SD_PAYTP_OPPREPAYTRANSFERFROMIP = "19";//住院预交金转患者预交金
    public static final String SD_PAYTP_OPPREPAYCONSUME = "21";//患者预交金消费
    public static final String SD_PAYTP_IPPREPAYCONSUME = "22";//住院流程预交金消费
    public static final String SD_PAYTP_PECMPYPREPAYCONSUME ="23"; //单位团检住院流程预交金消费
    public static final String SD_PAYTP_ETPREPAY = "24";//留观预交金
    public static final String SD_PAYTP_ETPREPAYCONSUME = "25";//留观预交金消费
    
    public static final String ID_PAYTP_ST = "@@@@AA1000000000PATY";//结算
    public static final String ID_PAYTP_MIDST = "@@@@AA1000000000PATX";//中途结算
    public static final String ID_PAYTP_STRED = "@@@@AA1000000000PATO";//结算冲账
    public static final String ID_PAYTP_ARREARSPAY = "@@@@AA1000000000PATP";//欠费补交
    public static final String ID_PAYTP_CANCELST = "@@@@AA1000000000PATI";//取消结算
    public static final String ID_PAYTP_OPPREPAY = "@@@@AA1000000000PATN";//患者预交金
    public static final String ID_PAYTP_IPPREPAY = "@@@@AA1000000000PATZ";//住院流程预交金
    public static final String ID_PAYTP_PECMPYPREPAY="@@@@AA100000000Q6EPP";//团检流程预交金
    public static final String ID_PAYTP_IPPREPAYTRANSFER = "@@@@AA100000000Q4S27";//住院流程预交金（转入）
    public static final String ID_PAYTP_IPPREPAYSTTRANSFER = "@@@@AA100000000Q98JZ";//住院流程预交金（结转）
    public static final String ID_PAYTP_PECMPYPREPAYSTTRANSFER = "@@@@AA100000000Q98K0";//单位团检流程预交金（结转）
    public static final String ID_PAYTP_IPPREPAYTRANSFERFROMOP = "@@@@AA100000000NJKDR";//患者预交金转住院预交金
    public static final String ID_PAYTP_IPCANCELTRADERESTORE = "@@@@Z81000000008B4FA";//住院取消出纳退还押金
    public static final String ID_PAYTP_OPPREPAYTRANSFERFROMIP = "@@@@Z81000000008BCDG";//住院预交金转患者预交金
    public static final String ID_PAYTP_OPPREPAYCONSUME = "@@@@AA10000000095DDO";//患者预交金消费
    public static final String ID_PAYTP_IPPREPAYCONSUME = "@@@@AA10000000095DDP";//住院流程预交金消费
    public static final String ID_PAYTP_PECMPYPREPAYCONSUME ="@@@@AA100000000Q6JCC";//单位团检住院流程预交金消费
    public static final String ID_PAYTP_ETPREPAY = "@@@@Z8100000003KCSRS";// 留观预交金
    public static final String ID_PAYTP_ETPREPAYCONSUME = "@@@@Z8100000003KCTK6";//留观预交金消费

    /*
     * 0540结账类型
     * */
    public static final String SD_CCTP_MZLC = "00"; //门诊流程结账编码
    public static final String SD_CCTP_ID_MZLC = "@@@@AA1000000001K2IR"; //门诊流程结账Id
    public static final String SD_CCTP_MZGH = "01"; //门诊挂号结账编码
    public static final String SD_CCTP_ID_MZGH = "@@@@AA1000000001K2IS"; //门诊挂号结账Id
    public static final String SD_CCTP_MZSF = "02"; //门诊收费结账编码
    public static final String SD_CCTP_ID_MZSF = "@@@@AA1000000001K2IT"; //门诊收费结账Id
    public static final String SD_CCTP_MZYJJ = "03"; //门诊预交金结账编码
    public static final String SD_CCTP_ID_MZYJJ = "@@@@Z7100000000GH0VA"; //门诊预交金结账Id
    public static final String SD_CCTP_ZYLC = "10"; //住院流程结账编码
    public static final String SD_CCTP_ID_ZYLC = "@@@@AA1000000001K2IU"; //住院流程结账Id
    public static final String SD_CCTP_ZYYJJ = "11"; //住院预交金结账编码
    public static final String SD_CCTP_ID_ZYYJJ = "@@@@Z8100000000EK8DR"; //住院预交金结账Id
    public static final String SD_CCTP_ZYSF = "12"; //住院收费结账编码
    public static final String SD_CCTP_ID_ZYSF = "@@@@Z8100000000EK8DS"; //住院收费结账Id
    /**
     * 0560结算作废原因
     */
    public static final String BD_REFUND_SETTLE_CANCELLED_ID = "@@@@AA1000000004UUR9"; //退费
    public static final String BD_REFUND_SETTLE_CANCELLED = "01"; //退费
    public static final String BD_REFUND_SETTLE_OTHER_ID = "@@@@AA1000000004UURA"; //其他
    public static final String BD_REFUND_SETTLE_OTHER = "09"; //其他
    
    /**
     *  固定收费包
     */
    public static final String BD_DCG_MODE_SD ="0";//继承科室
    public static final String BD_DCG_MODE_ID ="@@@@AA1000000001H2JC";//继承科室ID
    public static final String BD_DCG_MODE_SELF_SD ="1";//患者专有 
    public static final String BD_DCG_MODE_SELF_ID ="00";//患者专有ID
    
    
    /**
     * 收付款使用的终端的类型
     */
    public static final String SD_PTTP_WINDOW = "01"; //IIH收费窗口
    public static final String SD_PTTP_SELF_TERMINAL = "02"; //自助机
    public static final String SD_PTTP_WEIXIN = "03"; //微信平台
    public static final String SD_PTTP_PHONE_APP = "04"; //手机APP
    public static final String SD_PTTP_SYSTEM = "05"; //IIH后台
    public static final String SD_PTTP_H5= "06";//h5支付
    public static final String SD_PTTP_ROOM= "07";//诊间结算
    public static final String SD_PTTP_BEDSIDE= "08";//床旁结算
    
    public static final String ID_PTTP_WINDOW = "@@@@Z8100000001232JH"; //IIH收费窗口
    public static final String ID_PTTP_SELF_TERMINAL = "@@@@Z810000000123BSS"; //自助机
    public static final String ID_PTTP_WEIXIN = "@@@@Z810000000123BST"; //微信平台
    public static final String ID_PTTP_PHONE_APP = "@@@@Z810000000123BSU"; //手机APP
    public static final String ID_PTTP_SYSTEM = "@@@@Z8100000000UF4GI";//IIH后台
    public static final String ID_PTTP_H5= "@@@@Z8100000000A3WCY";//h5支付
    public static final String ID_PTTP_ROOM= "@@@@Z8100000000J9XHP";//诊间结算
    public static final String ID_PTTP_BEDSIDE= "@@@@Z8100000003KJC4L";//床旁结算
    /**
     * 预交金重打原因
     */
    public static final String SD_RES_REPRINT_NOTNORMAL = "01";//未正常打印
    public static final String SD_RES_REPRINT_BAD = "02";//打印污损
    public static final String SD_RES_REPRINT_LOST = "03";//原收据丢失
    
    /**
     * 票据重打原因
     */
    public static final String SD_RES_INCCANC_PRINTERROR = "02";//打印故障

    public static final String ID_RES_INCCANC_PRINTERROR = "@@@@AA1000000000EL12";//打印故障

    
    /**
     * 医院预交金收费流程模式
     */
    public static final String PARAM_VALUE_ACCOUNT = "1"; //结算记账
    public static final String PARAM_VALUE_OPENACCOUNT = "2"; //开立记账
    public static final String PARAM_VALUE_DURINGACCOUNT = "3"; //诊间划价
    public static final String PARAM_VALUE_EXECACCOUNT = "4"; //执行记账
    /**
     * 第三方交易场景
     */ 
    public static final String ID_BIZSCENE_OEP_PRE = "@@@@LL1000000005WKZ8";//门诊预交金
    public static final String ID_BIZSCENE_OEP_CHARGE = "@@@@LL1000000005WKZ9";//门诊收费
    public static final String ID_BIZSCENE_OEP_REFUND = "@@@@Z8100000000VCTD3";//门诊退费
    public static final String ID_BIZSCENE_IP_REFUND = "@@@@Z8100000000VCTD4";//住院预交金
    public static final String ID_BIZSCENE_IP_CHARGE = "@@@@Z8100000000VCTD5";//住院收费
    public static final String ID_BIZSCENE_OEP_ENT = "@@@@Z8100000000VO7UE";//门诊挂号收费
    public static final String ID_BIZSCENE_OEP_REENT = "@@@@Z8100000000VO7UF";//门诊挂号退费
    public static final String ID_BIZSCENE_PE_CHARGE = "@@@@Z8100000000A3WCZ";//体检收费
    public static final String ID_BIZSCENE_PE_REFUND = "@@@@Z8100000000A3WD0";//体检退费
    public static final String ID_BIZSCENE_PECUST_CHARGE = "@@@@Z8100000000A3WD1";//团检收费
    public static final String ID_BIZSCENE_IP_REGISTER = "@@@@Z8100000000FVTSQ";//入院登记(注册)
    public static final String ID_BIZSCENE_PIPREPAY = "@@@@Z8100000000GB7XK";//患者注册收取预交金
    public static final String ID_BIZSCENE_OEP_SINGLEPRE = "@@@@Z8100000000HXWBH";//门诊便民工作站

    public static final String SD_BIZSCENE_OEP_PRE = "01";//门诊预交金
    public static final String SD_BIZSCENE_OEP_CHARGE = "02";//门诊收费
    public static final String SD_BIZSCENE_OEP_REFUND = "03";//门诊退费
    public static final String SD_BIZSCENE_IP_REFUND = "04";//住院预交金
    public static final String SD_BIZSCENE_IP_CHARGE = "05";//住院收费
    public static final String SD_BIZSCENE_OEP_ENT = "06";//门诊挂号收费
    public static final String SD_BIZSCENE_OEP_REENT = "07";//门诊挂号退费
    public static final String SD_BIZSCENE_PE_CHARGE = "08";//体检收费
    public static final String SD_BIZSCENE_PE_REFUND = "09";//体检退费
    public static final String SD_BIZSCENE_PECUST_CHARGE = "10";//团检收费
    public static final String SD_BIZSCENE_IP_REGISTER = "11";//入院登记(注册)
    public static final String SD_BIZSCENE_PIPREPAY = "12";//患者注册收取预交金
    public static final String SD_BIZSCENE_OEP_SINGLEPRE = "13";//门诊便民工作站
}
