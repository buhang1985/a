package iih.en.itf.bp.opapt;

import iih.bl.st.blstoep.d.BlStOepDO;
import iih.en.comm.validator.EnValidator;
import iih.en.itf.bean.input.opapt.WsEnParamCfmPaidApt;
import iih.en.itf.bean.output.WsEnResult;
import iih.en.itf.bean.output.opapt.WsEnResultCfmPaidApt;
import iih.en.pv.appoint.s.bp.GetStOepInfoBP;
import iih.en.pv.s.bp.op.ws.SetPsnDocContextBP;
import iih.sc.apt.i.IScAptOutCmdService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 已收费预约取号
 * 
 * @author liubin
 *
 */
public class WsEnCfmPaidApt {
	/**
	 * 已收费预约取号
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public WsEnResult<WsEnResultCfmPaidApt> exec(WsEnParamCfmPaidApt param) throws BizException {
		//1.参数校验
		this.validate(param);
		//2.设置上下文
		this.setContext(param);
		//3.取号
		this.cfmPaidApt(param);
		//4.组装返回值
		return this.wrap(param);
	}
	/**
	 * 参数校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void validate(WsEnParamCfmPaidApt param) throws BizException {
		if(param == null)
			throw new BizException("入参为空或者xml转换失败!");
		if(EnValidator.isEmpty(param.getId_apt()))
			throw new BizException("预约Id不能为空！");
		if(EnValidator.isEmpty(param.getOprCode()))
			throw new BizException("操作员编码不能为空！");
	}
	/**
	 * 设置上下文
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void setContext(WsEnParamCfmPaidApt param) throws BizException {
		new SetPsnDocContextBP().exec(param.getOprCode());
	}
	/**
	 * 取号
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void cfmPaidApt(WsEnParamCfmPaidApt param) throws BizException {
		IScAptOutCmdService serv = ServiceFinder.find(IScAptOutCmdService.class);
		serv.takeApptNoForAptNew(param.getId_apt(), param.getOprCode());
	}
	/**
	 * 组装返回值数据
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private WsEnResult<WsEnResultCfmPaidApt> wrap(WsEnParamCfmPaidApt param) throws BizException {
		GetStOepInfoBP bp = new GetStOepInfoBP();
		BlStOepDO st = bp.queryByAptId(param.getId_apt());
		WsEnResultCfmPaidApt data = new WsEnResultCfmPaidApt();
		if(st != null){
			data.setId_stoep(st.getId_stoep());
			data.setCode_st(st.getCode_st());
			data.setDt_st(st.getDt_st()==null? null : st.getDt_st().toString());
		}
		List<WsEnResultCfmPaidApt> datas = new ArrayList<WsEnResultCfmPaidApt>();
		datas.add(data);
		WsEnResult<WsEnResultCfmPaidApt> result = new WsEnResult<WsEnResultCfmPaidApt>();
		result.setDatas(datas);
		return result;
	}
}
