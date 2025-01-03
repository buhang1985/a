package iih.bd.pp.pripm.i;

public class IBdPripmCodeConst {
	/**
	 * 付款方式编码
	 * */
	public static final String CODE_PRI_PM_CASH = "01"; //现金
    public static final String CODE_PRI_PM_CREDIT = "02"; //信用卡
    public static final String CODE_PRI_PM_CHECK = "03"; //支票
    public static final String CODE_PRI_PM_DEAFT = "04"; //汇票
    public static final String CODE_PRI_PM_PAY = "05";//预交金
    public static final String CODE_PRI_PM_COUPON="06"; //优惠券
    
    public static final String CODE_PRI_PM_SPECIALFUNDS = "07"; //专用款
    public static final String CODE_PRI_PM_MISPOS = "08"; //MISPOS
    public static final String CODE_PRI_PM_COMPANY = "09"; //合同单位
    public static final String CODE_PRI_PM_ACCOUNT = "10"; //关联账户
    public static final String CODE_PRI_PM_ALIPAY = "11";//支付宝
    public static final String CODE_PRI_PM_WECHAT="12"; //微信
    public static final String CODE_PRI_PM_INSURPERSONALACCOUNT="13"; //医保个人账户
    public static final String CODE_PRI_PM_INSUR="14"; //医保基金
    public static final String CODE_PRI_PM_MONEYDEDUCTION="15"; //金额减免
    public static final String CODE_PRI_PM_SRVDEDUCTION="16"; //项目减免
    public static final String CODE_PRI_PM_TRANSFE="51";  //内部转账（合作单位）
    public static final String CODE_PRI_PM_BUSINESS="17";  //商保
    public static final String CODE_PRI_PM_INSUR_DIFF="18";  //医保差额
    public static final String CODE_PRI_PM_HPPROFITLOSS = "20"; //医保盈亏
    public static final String CODE_PRI_PM_BANK_DIFF="52";  //民生银行
    public static final String CODE_PRI_PM_SERIOUSILL="60";//大病
    public static final String CODE_PRI_PM_BIGCIVILSERVICE="61";//大额
    public static final String CODE_PRI_PM_SALVAGE="62";//救助金支付金额
    public static final String CODE_PRI_PM_CIVILSERVICE="63";//公务员补助金额
    public static final String CODE_PRI_PM_POLYMERIZE="21";//聚合支付
    
    public static final String CODE_HP_SELF_FREE="24";//医保自付减免
    public static final String CODE_PRI_PM_PAY_ONE_YARD = "25"; //对接电子健康卡之后，新增一码付支付方式
    /**
     * 付款方式ID
     * */
    public static final String ID_PRI_PM_CASH = "@@@@AA1000000001JPEI"; //现金
    public static final String ID_PRI_PM_CREDIT = "@@@@AA1000000001JPEJ"; //信用卡
    public static final String ID_PRI_PM_CHECK = "@@@@AA1000000001JPEK"; //支票
    public static final String ID_PRI_PM_DEAFT = "@@@@AA1000000001JPEL"; //汇票
    public static final String ID_PRI_PM_PAY = "@@@@AA1000000001JPEM";//预交金
    public static final String ID_PRI_PM_COUPON="@@@@AA1000000008VGOY"; //优惠券
    
    public static final String ID_PRI_PM_SPECIALFUNDS = "@@@@Z7100000000FL1B8"; //专用款
    public static final String ID_PRI_PM_MISPOS = "@@@@Z7100000000FL1B9"; //MISPOS
    public static final String ID_PRI_PM_COMPANY = "@@@@Z7100000000FL1BA"; //合同单位
    public static final String ID_PRI_PM_ACCOUNT = "@@@@Z7100000000FL1BB"; //关联账户
    public static final String ID_PRI_PM_ALIPAY = "@@@@Z7100000000FL1BC";//支付宝
    public static final String ID_PRI_PM_WECHAT="@@@@Z7100000000FL1BD"; //微信
    public static final String ID_PRI_PM_INSURPERSONALACCOUNT="@@@@Z7100000000EXC53"; //医保个人账户
    public static final String ID_PRI_PM_INSUR="@@@@Z7100000000H1L91"; //医保基金
    public static final String ID_PRI_PM_MONEYDEDUCTION="@@@@Z7100000000N0GLD"; //金额减免
    public static final String ID_PRI_PM_SRVDEDUCTION="@@@@Z7100000000NOC4C"; //项目减免
    public static final String ID_PRI_PM_TRANSFE = "@@@@Z7100000000N0GLI"; //内部转账（合作单位）
    public static final String ID_PRI_PM_BUSINESS="@@@@Z71000000011Y9Y6";  //商保支付
    public static final String ID_PRI_PM_INSUR_DIFF="@@@@Z71000000001ZJSK";  //医保差额
    public static final String ID_PRI_PM_HPPROFITLOSS = "@@@@Z81000000006YU4F"; //医保盈亏
    public static final String ID_PRI_PM_BANK_DIFF="@@@@Z81000000001ECMN";//民生银行
    public static final String ID_PRI_PM_POLYMERIZE="@@@@Z8100000002NXXU5";//聚合支付
    public static final String ID_HP_SELF_FREE="@@@@Z81000000037QHL8";//医保自付减免
    public static final String ID_PRI_PM_PAY_ONE_YARD= "@@@@Z81000000039O601";//一码付
    /**
     * 付款方式类型ID
     */
    public static final String ID_PRI_PM_TP_CASH="@@@@AA1000000000MNS7";//现金
    public static final String ID_PRI_PM_TP_CHECK="@@@@AA1000000000MNS8";//支票
    public static final String ID_PRI_PM_TP_DEAFT="@@@@AA1000000000MNS9";//汇款存款
    public static final String ID_PRI_PM_TP_TRANSFE="@@@@AA1000000000T6Y9";//内部转账
    public static final String ID_PRI_PM_TP_COMPANY="@@@@AA1000000000T6YA";//单位记账
    public static final String ID_PRI_PM_TP_INSURPERSONALACCOUNT="@@@@AA1000000000T6YB";//账户金
    public static final String ID_PRI_PM_TP_INSUR="@@@@AA1000000000T6YC";//统筹金
    public static final String ID_PRI_PM_TP_CREDIT ="@@@@AA1000000000T6YD";//银行卡
    public static final String ID_PRI_PM_TP_OTHER="@@@@AA1000000000T6YE";//其他
    
    /**
     * 付款方式类型编码
     */
    public static final String SD_PRI_PM_TP_CASH="00";//现金
    public static final String SD_PRI_PM_TP_CHECK="01";//支票
    public static final String SD_PRI_PM_TP_DEAFT="02";//汇款存款
    public static final String SD_PRI_PM_TP_TRANSFE="03";//内部转账
    public static final String SD_PRI_PM_TP_COMPANY="04";//单位记账
    public static final String SD_PRI_PM_TP_INSURPERSONALACCOUNT="05";//账户金
    public static final String SD_PRI_PM_TP_INSUR="06";//统筹金
    public static final String SD_PRI_PM_TP_CREDIT ="07";//银行卡
    public static final String SD_PRI_PM_TP_OTHER="08";//其他
}
