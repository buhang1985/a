package iih.bl.comm;

import java.util.List;

import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.desc.BlCgItmOepDODesc;
import iih.bl.cg.blcgoep.d.desc.BlCgOepDODesc;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.d.desc.BlCgIpDODesc;
import iih.bl.params.BlParams;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.d.desc.BlStIpDODesc;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.desc.BlStOepDODesc;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 根据客户定义生成结算号和窗口号
 * 
 * @author tcy
 *
 */
public class GetCodeByCustomization {

	/**
	 * 计算上张票号的号码 例如：当前票号S0109，下张票号是S0110
	 * 
	 * @param maxInvoiceno
	 *            当前号
	 * @return 下张票号
	 */
	public String computePreviousInvoiceNo(String maxInvoiceno) {
		// 票据号中提取可累加的整数
		String nextInvoiceno = "";
		String nextInvoiceno_replace = "";
		String nextInvoiceno_num = "";
		char[] chars = maxInvoiceno.toCharArray();
		char[] replace_char = new char[chars.length];
		int i_char = 0;
		// 字符串转换作用，提取出数字：将字符串S001010变成^::1::9
		for (char char1 : chars) {
			if (!(((int) char1) >= 48 && ((int) char1) <= 57)) // 判断ASC码
			{
				replace_char[i_char] = '^';
			} else if (((int) char1) == 48) {
				replace_char[i_char] = ':';
			} else if (((int) char1) == 58) {
				replace_char[i_char] = '^';
			} else {
				replace_char[i_char] = char1;
			}
			i_char++;
		}
		// 减少1：将^::1:10变成^::1::9
		String replace_str = "";
		replace_str = String.valueOf(replace_char);
		String replace_str_right = "";
		int pos_index = 0;
		if (replace_str.indexOf("^") < 0) {
			if (replace_str.indexOf(":") < 0) {
				if ((Long.parseLong(maxInvoiceno) - 1) < 0) {
					return maxInvoiceno; // 当前号为票据包起始号
				}
				nextInvoiceno = String
						.valueOf(Long.parseLong(maxInvoiceno) - 1);
				return nextInvoiceno;
			} else {
				for (char char1 : replace_char) {
					if (((int) char1) > 48 && ((int) char1) <= 57) // 判断ASC码:1---9
					{
						break;
					}
					pos_index++;
				}
				String temp_no = replace_str.substring(pos_index);
				temp_no = temp_no.replace(':', '0');
				if ((Long.parseLong(maxInvoiceno) - 1) < 0) {
					return maxInvoiceno; // 当前号为票据包起始号
				}
				nextInvoiceno_num = String.valueOf(Long.parseLong(temp_no) - 1);
				// ^::1::9变成^::1:10
				nextInvoiceno_replace = replace_str.substring(0,
						replace_str.length() - nextInvoiceno_num.length())
						+ nextInvoiceno_num;

			}

		} else {
			// 将^::1:10变成^::1::9
			replace_str_right = replace_str.substring(replace_str.indexOf("^"));
			char[] new_chars = replace_str_right.toCharArray();

			for (char char1 : new_chars) {
				if (((int) char1) > 48 && ((int) char1) <= 57) // 判断ASC码:1---9
				{
					break;
				}
				pos_index++;
			}
			String temp_no = replace_str.substring(pos_index);
			temp_no = temp_no.replace(':', '0');
			if ((Long.parseLong(temp_no) - 1) < 0) {
				return maxInvoiceno; // 当前号为票据包起始号
			}
			nextInvoiceno_num = String.valueOf(Long.parseLong(temp_no) - 1);
			// ^::1:10变成^::1::9
			nextInvoiceno_replace = replace_str.substring(0,
					replace_str.length() - nextInvoiceno_num.length())
					+ nextInvoiceno_num;
		}
		// 还原：根据字符串S001010格式和^::1::9变成新字符串S001009
		replace_char = nextInvoiceno_replace.toCharArray();
		int index_new = 0;
		for (char char1 : replace_char) {
			if (((int) char1) == 58)// 零
			{
				replace_char[index_new] = '0';
			} else if (!(((int) char1) >= 48 && ((int) char1) <= 57)) // 判断ASC码,非零、非数值
			{
				replace_char[index_new] = chars[index_new];
			}

			index_new++;
		}
		nextInvoiceno = String.valueOf(replace_char);
		return nextInvoiceno;
	}

	/**
	 * 计算下张票号的号码 例如：当前票号S0109，下张票号是S0110
	 * 
	 * @param maxInvoiceno
	 *            当前号
	 * @return 下张票号
	 */
	public String computeNextInvoiceNo(String maxInvoiceno) {
		// 票据号中提取可累加的整数
		String nextInvoiceno = "";
		String nextInvoiceno_replace = "";
		String nextInvoiceno_num = "";
		char[] chars = maxInvoiceno.toCharArray();
		char[] replace_char = new char[chars.length];
		int i_char = 0;
		// 字符串转换作用，提取出数字：将字符串S001009变成^::1::9
		for (char char1 : chars) {
			if (!(((int) char1) >= 48 && ((int) char1) <= 57)) // 判断ASC码
			{
				replace_char[i_char] = '^';
			} else if (((int) char1) == 48) {
				replace_char[i_char] = ':';
			} else if (((int) char1) == 58) {
				replace_char[i_char] = '^';
			} else {
				replace_char[i_char] = char1;
			}
			i_char++;
		}
		// 增加1：将^::1::9变成^::1:10
		String replace_str = String.valueOf(replace_char);
		String replace_str_right = "";
		int pos_index = 0;
		if (replace_str.indexOf("^") < 0) {
			if (replace_str.indexOf(":") < 0) {
				nextInvoiceno = String
						.valueOf(Long.parseLong(maxInvoiceno) + 1);
				return nextInvoiceno;
			} else {
				for (char char1 : replace_char) {
					if (((int) char1) > 48 && ((int) char1) <= 57) // 判断ASC码:1---9
					{
						break;
					}
					pos_index++;
				}
				String temp_no = replace_str.substring(pos_index);
				temp_no = temp_no.replace(':', '0');
				nextInvoiceno_num = String.valueOf(Long.parseLong(temp_no) + 1);
				// ^::1::9变成^::1:10
				nextInvoiceno_replace = replace_str.substring(0,
						replace_str.length() - nextInvoiceno_num.length())
						+ nextInvoiceno_num;

			}
		} else {
			// 将^::1::9变成^::1::9
			replace_str_right = replace_str.substring(replace_str.indexOf("^"));
			char[] new_chars = replace_str_right.toCharArray();

			for (char char1 : new_chars) {
				if (((int) char1) > 48 && ((int) char1) <= 57) // 判断ASC码:1---9
				{
					break;
				}
				pos_index++;
			}
			String temp_no = replace_str.substring(pos_index);
			temp_no = temp_no.replace(':', '0');
			nextInvoiceno_num = String.valueOf(Long.parseLong(temp_no) + 1);
			// ^::1::9变成^::1:10
			nextInvoiceno_replace = replace_str.substring(0,
					replace_str.length() - nextInvoiceno_num.length())
					+ nextInvoiceno_num;
		}
		// 还原：根据字符串S001009格式和^::1:10变成新字符串S001010
		replace_char = nextInvoiceno_replace.toCharArray();
		int index_new = 0;
		for (char char1 : replace_char) {
			if (((int) char1) == 58) {
				replace_char[index_new] = '0';
			} else if (!(((int) char1) >= 48 && ((int) char1) <= 57)) // 判断ASC码
			{
				replace_char[index_new] = chars[index_new];
			}

			index_new++;
		}
		nextInvoiceno = String.valueOf(replace_char);
		return nextInvoiceno;
	}

	/**
	 * 获得门诊结算码 :窗口号+编码.substring(窗口号.length())
	 * 
	 * @return
	 * @throws BizException
	 */
	public String GetCodeStOep() throws BizException {
		String code_st = "", window_no = "";
		window_no = getWindowNo_Oep();
		if (window_no == null) {
			window_no = "";
		}
		IBillcodeManage codeS1 = ServiceFinder.find(IBillcodeManage.class);
		code_st = codeS1.getBillCode_RequiresNew(BlStOepDODesc.CLASS_FULLNAME,
				new BlStOepDO());
		code_st = window_no + code_st.substring(window_no.length());
		return code_st;
	}

	/**
	 * 获得住院结算码 :窗口号+编码.substring(窗口号.length())
	 * 
	 * @return
	 * @throws BizException
	 */
	public String GetCodeStIp() throws BizException {
		String code_st = "", window_no = "";
		window_no = getWindowNo_Ip();
		if (window_no == null) {
			window_no = "";
		}
		IBillcodeManage codeS1 = ServiceFinder.find(IBillcodeManage.class);
		code_st = codeS1.getBillCode_RequiresNew(BlStIpDODesc.CLASS_FULLNAME,
				new BlStIpDO());
		code_st = window_no + code_st.substring(window_no.length());
		return code_st;
	}

	/**
	 * 获取记账编码
	 * 
	 * @return 记账编码
	 * @throws BizException
	 */
	public String getIpCgCode() throws BizException {
		IBillcodeManage billManage = ServiceFinder.find(IBillcodeManage.class);
		String strCgCode = billManage.getBillCode_RequiresNew(
				BlCgIpDODesc.CLASS_FULLNAME, new BlCgIpDO());
		return strCgCode;
	}

	private String getWindowNo_Oep() throws BizException {
		String window_no = BlParams.BLSTOEP0005();
		if(StringUtil.isEmpty(window_no)){
			window_no = IBlConst.DEFAULT_WINDOWNO;
		}

		return window_no;
	}

	private String getWindowNo_Ip() throws BizException {
		String window_no = BlParams.BLSTIP0003();
		if(StringUtil.isEmpty(window_no)){
			window_no = IBlConst.DEFAULT_WINDOWNO;
		}

		return window_no;
	}

	/**
	 * 获得记账码
	 * 
	 * @return
	 * @throws BizException
	 */
	public String GetCodeBlCgOep() throws BizException {
		String code_cg = "";
		IBillcodeManage codeS1 = ServiceFinder.find(IBillcodeManage.class);
		code_cg = codeS1.getBillCode_RequiresNew(BlCgOepDODesc.CLASS_FULLNAME,
				new BlCgOepDO());
		return code_cg;
	}
	
	/**
	 * 获取门诊记账明细号
	 * @param num
	 * @return
	 * @throws BizException
	 */
	public String[] GetCgItmOepCodes(int num) throws BizException{
		IBillcodeManage codeS1 = ServiceFinder.find(IBillcodeManage.class);
		return codeS1.getBatchBillCodes_RequiresNew(BlCgItmOepDODesc.CLASS_FULLNAME,
				new BlCgItmOepDO(),num);
	}
	// /**
	// * 获取参数
	// * @param dataId
	// * @param paramCode
	// * @return
	// */
	// private static String getParamValue(String dataId,String paramCode){
	// //框架提供的方法
	// String val="";
	// try {
	// val = ParamsetQryUtil.getParaString(dataId,paramCode);
	// } catch (BizException e) {
	// e.printStackTrace();
	// }
	// return val;
	// }
}
