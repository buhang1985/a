package iih.mi.inst.bizbase;

import iih.mi.bd.d.HpDTO;
import iih.mi.itf.bizgrpitf.constant.BdMhiParamCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class HpSettingBaseImpl extends InsureBaseImpl{

	public String GetHpFlowType()
	{
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品必须实现自己的业务流程定义（前置/常规流程）!");
	}
	
	/**
	 * 获取住院医保明细上传模式
	 * @return 模式
	 * @author ly 2019/01/17
	 */
	public String GetIpDetailUploadMode() throws BizException{
		
		HpDTO hpDTO= getHpDTO();
		String value = ParamsetQryUtil.getParaStringByInstance(hpDTO.getId_hp(), BdMhiParamCodeConst.BDMHI2009);
		return value;
	}
}
