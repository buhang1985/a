package iih.mi.device.serializedata.ruralcooperinsure;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
/**
 * 退结算
 * @author LIM
 *
 */
public class BackPayProc extends AbstractTransactProc {
    //参合地区编码
    private String chAreaCode;
    //住院结算流水号
    private String InpNo;
    //操作人员信息
    private String OperatorName;
    public BackPayProc(String chAreaCode, String InpNo, String OperatorName){
        this.chAreaCode = chAreaCode;
        this.InpNo = InpNo;
        this.OperatorName = OperatorName;
        this.methodName = "backPay";
        this.paramCount =7;
    }    
	@Override
	public List<Object> convertTOInputDataParam() throws BizException {
        List<Object> param=new ArrayList<Object>();
        param.add(this.serviceContext.getUserName());
        param.add(this.serviceContext.getPassword());
        param.add((new FDateTime()).toString());
        param.add(this.serviceContext.getHospCode());
        param.add(this.chAreaCode);
        param.add(this.InpNo);
        param.add(this.OperatorName);
        return param;
	}

	@Override
	public Object convertToOutputDataParam(String strOutput)
			throws BizException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
