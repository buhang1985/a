package iih.ci.ord.content.d;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public abstract class BaseCiOrContentFactory implements CiOrContentObjFactory {
	/**
	 * 已完成数据映射后的OrdSrvDO数据
	 */
	private OrdSrvDO[] ordsrvs;
	/**
	 * 
	 */
	protected DecimalFormat df = new DecimalFormat("#.00");
	/**
	 * 计算价格
	 * 
	 * @return
	 */
	public String calPrice() {
		FDouble totalPri = new FDouble(0);
		if (ordsrvs != null && ordsrvs.length > 0) {
			for(OrdSrvDO ordsrv : ordsrvs){
				//临床项目费用
				if(DOStatus.DELETED!=ordsrv.getStatus()&&FBoolean.TRUE.equals(ordsrv.getFg_bl())&&(OrSrvSourceFromEnum.PHYSIAN.equals(ordsrv.getEu_sourcemd())||OrSrvSourceFromEnum.AGENTFROMPRIMD.equals(ordsrv.getEu_sourcemd())
						||OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD.equals(ordsrv.getEu_sourcemd()))){
					if(ordsrv.getPri()!=null){
						totalPri = totalPri.add(ordsrv.getQuan_medu().multiply(ordsrv.getPri()));
					}
				}
			}
		}
		BigDecimal a=new BigDecimal(totalPri.setScale(-2, BigDecimal.ROUND_HALF_UP).toString());
		return a.stripTrailingZeros().toPlainString();
	}
	

	/**
	 * 计算价格
	 * 
	 * @return
	 */
	public String calPrice_new() {
		FDouble totalPri = new FDouble(0);
		if (this.getOrdsrvs() != null && getOrdsrvs().length > 0) {
			for(OrdSrvDO ordsrv : getOrdsrvs()){
				//临床项目费用
				if(DOStatus.DELETED!=ordsrv.getStatus()&&FBoolean.TRUE.equals(ordsrv.getFg_bl())&&(OrSrvSourceFromEnum.PHYSIAN.equals(ordsrv.getEu_sourcemd())||OrSrvSourceFromEnum.AGENTFROMPRIMD.equals(ordsrv.getEu_sourcemd())
						||OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD.equals(ordsrv.getEu_sourcemd()))){
					if(ordsrv.getPri()!=null){
						if(ordsrv.getSd_srvtp()!=null&&ordsrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
							totalPri = totalPri.add((ordsrv.getQuan_total_medu()==null?new FDouble(0):ordsrv.getQuan_total_medu()).multiply(ordsrv.getPri()));
						}else {
							totalPri = totalPri.add((ordsrv.getQuan_medu()==null?new FDouble(0):ordsrv.getQuan_medu()).multiply(ordsrv.getPri()));
						}
						
					}
				}
			}
		}
		BigDecimal a=new BigDecimal(totalPri.setScale(-2, BigDecimal.ROUND_HALF_UP).toString());
		return a.stripTrailingZeros().toPlainString();
	}
	/**
	 * 判断字符串是否为数字
	 * @param message
	 * @return
	 */
	protected boolean IsNumberic(String message)
    {
		 Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	     return pattern.matcher(message).matches();  
    }
	public OrdSrvDO[] getOrdsrvs() {
		return ordsrvs;
	}

	public void setOrdsrvs(OrdSrvDO[] ordsrvs) {
		this.ordsrvs = ordsrvs;
	}
	protected String getPrettyNumber(FDouble number) {  
		return number.setScale(-2, BigDecimal.ROUND_HALF_UP).toString();
	}
	/**
	 * quan/factor求分子分母的算法
	 * 
	 * @param quan
	 *            医疗用量
	 * @param factor
	 *            mb
	 * @return
	 */
	public static int[] getNumDen(FDouble quan, FDouble factor) {
		int[] rtns = new int[] { 0, 0 };
		int[] iquans=getNumBen(quan);
		int[] ifactors=getNumBen(factor);
		//int iquan = (int)Math.ceil(quan.doubleValue()); // 这个假设有可能不正确 需将传入的两个数据变为整型
		//int ifactor = factor.intValue();
		int inum=iquans[0]*ifactors[1];
		int iben=ifactors[0]*iquans[1];
		int imaxdiv = getMaxComDivisor(inum, iben);
		if(imaxdiv== 0){
			rtns[0] = 0  ;
			rtns[1] = 0;
		}else{
			rtns[0] = inum / imaxdiv;
			rtns[1] = iben / imaxdiv;
		}
		
		return rtns;
	}
	/**
	 * 获得对应的分数格式数据
	 * @param input
	 * @return
	 */
	private static int[] getNumBen(FDouble input){
		if(input==null)return new int[]{0,1};
		String sinput=input.toString();
		String[] sTs=sinput.split("\\.");
		if(sTs.length==1)return new int[]{input.intValue(),1};
		sTs[1]=numBenHandle(sTs[1]);
		return new int[]{Integer.valueOf(sTs[0]+sTs[1]),getNumV(sTs[1])};
		
	}
	private static String numBenHandle(String input){
		if(StringUtils.isEmpty(input))return "";
		int iL=input.length();
		String rtnstr="";
		char[] szInput = input.toCharArray();
		for(int i=iL-1;i>=0;i--){
			if (szInput[i] != '0')
			{
				rtnstr = input.substring(0, i+1);
				break;
			}
		}
		return rtnstr;
	}
	/**
	 * 
	 * @param s
	 * @return
	 */
	private static int getNumV(String s){
		if(s==null || s.equals(""))return 1;
		String rtn="1";
		for(int i=0;i<s.length();i++){
			rtn+="0";
		}
		return Integer.valueOf(rtn);
	}

	/**
	 * 获得最大公约数
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int getMaxComDivisor(int m, int n) {
		int k, y;
		if (m < n) {
			k = m;
			m = n;
			n = k;
		}
		if(n==0) return 0;
		while (m % n != 0) {
			y = m % n;
			m = n;
			n = y;
		}
		return n;
	}
	/**
	 * 判断两个数能不能除尽
	 * @param amount
	 * @param count
	 * @return
	 */
	public static boolean DivideUp(int amount,int count){
		if(amount%count==0){
			return true;// 能被除尽
		}
		else{
			int m=count;
			while(m%2==0){
				m=m/2;// 当模2不=0时，去尝试对5取模
			}
			while(m%5==0){
				m=m/5;// 当模5不=0时，则将m让除数取模
			}
			if(amount%m!=0){
				return false;// 不能除尽，如果取模不为0，则表示有2和5以外的因子，数学原理也是别人告诉我的：除数能被分解成N个2或N个5或者N2N5组合，则表示可以除尽
			}
		}
		return true;
	}
	/**
	 * 获得空医嘱内容
	 * 
	 * @param ems
	 */
	protected CiOrContentDO getNullContent(CiEmsDTO ems) {
		NullOrContentFactory nullfact = new NullOrContentFactory();
		return nullfact.create(ems);
	}

	protected String getSrvtpl(String sd_srvtp) {
		String srvtpl = "0101";
		/*
		 * 0101普药： 010101 普通药品 010102 外用药 010199 其它 010201 中成药 010202 蒙成药
		 */
		if (sd_srvtp.equals("010101") || sd_srvtp.equals("010102") || sd_srvtp.equals("010199")
				|| sd_srvtp.equals("010201") || sd_srvtp.equals("010202")) {
			return ICiOrContentConst.ORContent_TYPE_DRUGDEFAULT;
		}

		/*
		 * 0102注射： 010103 注射类药品 010104 溶媒 010105 皮试液
		 */

		if (sd_srvtp.equals("010103") || sd_srvtp.equals("010104") || sd_srvtp.equals("010105")) {
			return ICiOrContentConst.ORContent_TYPE_DRUGDEFAULT2;
		}
		return srvtpl = "0101";
	}

	/**
	 * 
	 * @param Name_unit_med
	 * @return
	 */
	protected String getName_unit_med(String Name_unit_med) {
		if (Name_unit_med != null && Name_unit_med != "") {
			Pattern pattern = Pattern.compile("^(\\d+)(.*)");
			Matcher matcher = pattern.matcher(Name_unit_med);
			if (matcher.matches()) {
				return "*" + Name_unit_med;
			} else {
				return Name_unit_med;
			}

		}
		return "";
	}
	protected StringBuffer assemble(StringBuffer sb,String str){
		if(StringUtils.isEmpty(str)){
			return sb;
		}
		sb.append(sb.length()==0?str:"，"+str);
		return sb;
	}
	/**
	 * 组装剂量和剂量单位，将剂量单位换算为基本单位
	 * @param item
	 * @param arrList
	 */
	protected void assembleQuanMedu(CiEmsSrvDTO item,ArrayList<String> arrList){
			if(item.getQuan_med() != null){
				arrList.add(item.getQuan_med().toString());
			}else{
				arrList.add("0");
			}
			arrList.add(getName_unit_med(item.getName_unit_med()));
	}
	/**
	 * 组装剂量和剂量单位，将剂量单位换算为基本单位
	 * @param item
	 * @param arrList
	 */
	protected void assembleQuanMedu2(CiEmsSrvDTO item,ArrayList<String> arrList){
			if(item.getQuan_medu_cur()!= null){
				arrList.add(item.getQuan_medu_cur().toString());
			}else{
				arrList.add("0");
			}
			arrList.add(getName_unit_med(item.getName_unit_medu_cur()));
	}
}
