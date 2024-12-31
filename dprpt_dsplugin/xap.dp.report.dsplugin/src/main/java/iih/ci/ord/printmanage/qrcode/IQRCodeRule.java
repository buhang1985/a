package iih.ci.ord.printmanage.qrcode;

import iih.ci.ord.printmanage.dto.QRCodeParamDTO;

/**
 * 二维码规则接口（产品接口）
 * @code 
 * @author LiYue
 * @date 2019年4月18日,下午3:00:59
 */
public interface IQRCodeRule {

	 public String getCode (QRCodeParamDTO param );
}
