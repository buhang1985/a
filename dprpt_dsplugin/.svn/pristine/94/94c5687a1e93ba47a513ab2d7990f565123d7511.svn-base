package iih.ci.ord.printmanage.qrcode;
import org.apache.commons.lang3.StringUtils;
import iih.ci.ord.printmanage.dto.QRCodeParamDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import xap.mw.core.data.BizException;
/**
 * @code 二维码 （工厂实现）
 * @author LiYue
 * @date 2019年4月18日,下午2:40:35
 */
public class QRCodeFactory  implements IQRCodeFactory  {

	@Override
	public String creatQRCode(QRCodeParamDTO param) throws Exception {

		// 哪个项目的二维码？
		String type;
		type = getType();
        Object rstObj = CiorderPrintUtils.ReflectMethodInvoke(param,type,"getCode");
		return (String)rstObj;
	}
     
	//哪个项目的二维码？  轻量级配置参数 JX_CIOR0001 来配置！
	private String getType() throws Exception {
		String Type = "iih.ci.ord.printmanage.qrcode.rules.SDlanlingQRCodeRule";
		String sql = " SELECT DEFAULTVALUE as type FROM SYS_PARAMTMPLSET WHERE PARAMCODE = 'JX_CIOR0001' ";
		try {
			QRCodeParamDTO result = CiorderPrintUtils.GetQueryBeanResulte(QRCodeParamDTO.class, sql);
			if(!StringUtils.isEmpty(result.getType())) Type = result.getType();
		} catch (Exception e) {
			Type = "iih.ci.ord.printmanage.qrcode.rules.SDlanlingQRCodeRule";
			throw new  BizException("请管理员配置 轻量级JX_CIOR0001参数！");
		}
		
		return Type;
	}

}
