package iih.bl.cg.bp.self;

import iih.bl.cg.api.d.OpPayInfo;
import iih.bl.cg.bp.self.qry.GetItmOepInfoQry;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetItmOepInfoBp {
	/**
	 * 获取检查检验处方信息
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	public OpPayInfo[] exec(String patCode, String applyCode,String timesOp) throws BizException{	
		if(StringUtil.isEmpty(patCode))
		{
			throw new BizException("患者编码不能为空！");
		}
		if(StringUtil.isEmpty(applyCode))
		{
			throw new BizException("申请单号不能为空！");
		}
		if(StringUtil.isEmpty(timesOp))
		{
			throw new BizException("就诊次数不能为空！");
		}		
		GetItmOepInfoQry qry=new GetItmOepInfoQry(patCode,applyCode, timesOp);
		List<OpPayInfo> itmOepInfoList = (List<OpPayInfo>) new DAFacade().execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(OpPayInfo.class));
		
		if(itmOepInfoList.size()>0){
//			return  itmOepInfoList.get(0);
			return itmOepInfoList.toArray(new OpPayInfo[]{});
		}else{
			return  new OpPayInfo[]{};
		}
	}
}
