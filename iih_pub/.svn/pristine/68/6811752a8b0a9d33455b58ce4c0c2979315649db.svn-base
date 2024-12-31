package iih.pi.common.idcheck;

import iih.pi.params.PiParams;

import java.text.SimpleDateFormat;
import java.util.Date;

import xap.mw.core.utils.StringUtil;

/**
 * 身份证校验类
 * 
 * @author ly 2016/09/29
 * @author hao_wu 2018-6-25
 *         因存在外籍医保卡的身份证卡号不符合省份逻辑，所以注释该逻辑，报错号码：999108201201300005
 *
 */
public class IDChecker {

	// private static String Address =
	// "11x22x35x44x53x12x23x36x45x54x13x31x37x46x61x14x32x41x50x62x15x33x42x51x63x21x34x43x52x64x65x71x81x82x91";
	private static String ExceptStr = "999999";

	/**
	 * 身份证验证
	 * 
	 * @param id
	 *            身份证号
	 * @return 校验结果
	 */
	public static boolean checkIDCard(String id) {

		if (StringUtil.isEmptyWithTrim(id))
			return false;

		switch (id.length()) {
		case 18: {
			return checkIdCard18(id);
		}
		case 15: {
			return checkIdCard15(id);
		}
		default:
			return false;
		}
	}

	/**
	 * 校验18位
	 * 
	 * @param id
	 * @return
	 */
	private static boolean checkIdCard18(String id) {

		if (id.startsWith(ExceptStr))
			return true;

		long n = 0;

		try {

			// 数字验证
			n = Long.parseLong(id.substring(0, id.length() - 1));
			if (n < Math.pow(10, 16))
				return false;

			String wholeId = id.replace("x", "0").replace("X", "0");
			Long.parseLong(wholeId);

			// 因存在外籍医保卡的身份证卡号不符合该校验逻辑，所以注释该逻辑，报错号码：999108201201300005
			// //省份验证
			// if(Address.indexOf(id.substring(0, 2)) == -1)
			// return false;

			String birth = id.substring(6, 10) + "-" + id.substring(10, 12) + "-" + id.substring(12, 14);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(birth);

			// 生日验证
			if (date.compareTo(new Date()) > 0)
				return false;

			String districtOut = new PiParams().PIPAT0023();
			
			if(!StringUtil.isEmpty(districtOut)){
				String district = id.substring(0, 6);
				if(districtOut.contains(district))
					return true;
			}
			
			String[] arrVarifyCode = "1,0,x,9,8,7,6,5,4,3,2".split(",");

			String[] Wi = "7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2".split(",");

			char[] Ai = id.substring(0, id.length() - 1).toCharArray();

			int sum = 0;

			for (int i = 0; i < 17; i++) {
				sum += Integer.parseInt(Wi[i]) * Integer.parseInt(String.valueOf(Ai[i]));
			}

			int y = -1;

			y = sum % 11;

			if (!arrVarifyCode[y].equals(id.substring(17, 18).toLowerCase())) {
				return false;// 校验码验证
			}

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * 校验15位
	 * 
	 * @param id
	 * @return
	 */
	private static boolean checkIdCard15(String id) {
		// TODO
		return false;
	}
}
