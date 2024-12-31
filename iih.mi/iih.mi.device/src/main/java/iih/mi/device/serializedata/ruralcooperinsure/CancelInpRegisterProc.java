package iih.mi.device.serializedata.ruralcooperinsure;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpUnRegisterRequestDTO;
/**
 * 取消住院登记
 * @author LIM
 *
 */
public class CancelInpRegisterProc extends AbstractTransactProc {
    private InpUnRegisterRequestDTO inpUnRegisterRequestDto;

    public CancelInpRegisterProc(InpUnRegisterRequestDTO inpUnRegisterRequestDto){
        //参数个数
        this.paramCount =7;
        this.methodName = "cancelInpRegister";
        this.inpUnRegisterRequestDto = inpUnRegisterRequestDto;
    }

	@Override
	public List<Object> convertTOInputDataParam() throws BizException {
        List<Object> lst=new ArrayList<Object>();
        
        //用户名
        lst.add(this.serviceContext.getUserName());
        //密码
        lst.add(this.serviceContext.getPassword());
        //invokeDate
        lst.add(new FDateTime());
        //hospCode 医院编码
        lst.add(this.serviceContext.getHospCode());
        lst.add(inpUnRegisterRequestDto.getAreacode());
        lst.add(inpUnRegisterRequestDto.getInpno());
        lst.add(inpUnRegisterRequestDto.getOperator());
        return lst;
	}

	@Override
	public Object convertToOutputDataParam(String strOutput)
			throws BizException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		return null;
	}
}
