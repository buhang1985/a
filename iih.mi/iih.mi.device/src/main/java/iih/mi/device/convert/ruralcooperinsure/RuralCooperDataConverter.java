package iih.mi.device.convert.ruralcooperinsure;

import xap.mw.core.data.BizException;
import iih.mi.device.data.ResultInfo;
import iih.mi.device.serializedata.ruralcooperinsure.AbstractTransactProc;

public class RuralCooperDataConverter {
    @SuppressWarnings("unchecked")
	public static <T> ResultInfo<T> mapperResultInfo(AbstractTransactProc transProc) {
//        if (transProc == null)
        //throw new BizException("无效参数bizMsg");
        ResultInfo<T> resultinfo = new ResultInfo<T>();
       
        //是否成功标志
        resultinfo.setIsSuccess(transProc.getIsSuccess());
        if (transProc.getOutputData() != null)
            resultinfo.setData((T)transProc.getOutputData());
        resultinfo.setErrorMsg(transProc.getErrMsg());
        //消息头
        resultinfo.setMsgHeaderDto(transProc.getMsgHeaderDto());
        return resultinfo;
    }
}
