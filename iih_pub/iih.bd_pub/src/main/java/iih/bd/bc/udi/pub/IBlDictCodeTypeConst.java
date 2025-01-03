package iih.bd.bc.udi.pub;

/**
 * 费用管理模块(IIH.BL)相关的基础数据常量定义。
 */
public interface IBlDictCodeTypeConst {

    public static final String SD_DIRECT = "@@@@ZZ2000000000004H";  //0505	收退费方向
    public static final String SD_ST = "";  //0515	结算类型
    public static final String SD_STRESULT = "";  //0520	结算结果分类
    public static final String SD_PAYTP = "@@@@ZZ2000000000004K";  //0530	患者收付款类型
    public static final String SD_CCTP = "@@@@ZZ2000000000004L";  //0540	结账类型
    public static final String SD_REP_LOST = "";  //0545	未回收原收据原因
//    public static final String BD_PRI_PM = "0001ZZ2000000000004Q";  //0550	收付款方式
    public static final String SD_REASON_CANC = "";  //0555	发票作废原因
    public static final String SD_REASON_CANC_SETTLEMENT = "@@@@ZZ2000000000008E";  //0560	结算作废原因
    
    //医疗类别
	public static final String SD_HPSTTP_HP="01";//普通医保
	public static final String SD_HPSTTP_SPECIAL="02";//特殊病
	public static final String SD_HPSTTP_DRGS="03";//单病种
	public static final String SD_HPSTTP_CHRONIC="04";//慢性病
	
	public static final String ID_HPSTTP_HP="@@@@Z8100000000PPECR";//普通医保
	public static final String ID_HPSTTP_SPECIAL="@@@@Z8100000000PPECU";//特殊病
	public static final String ID_HPSTTP_DRGS="@@@@Z8100000000PPECX";//单病种
	public static final String ID_HPSTTP_CHRONIC="@@@@Z8100000000PPECZ";//慢性病
	
	public static final String SD_PTTP = "BL.BL.0565";//收付款终端类型
}
