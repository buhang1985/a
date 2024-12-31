package iih.en.itf.bp.opapt;

import iih.en.comm.validator.EnValidator;
import iih.en.itf.bean.input.opapt.WsEnParamMakeApt;
import iih.en.itf.bean.output.WsEnResult;
import iih.en.itf.bean.output.opapt.WsEnResultMakeApt;
import iih.en.pv.s.bp.op.ws.SetPsnDocContextBP;
import iih.sc.apt.dto.d.MakeAptDTO;
import iih.sc.apt.dto.d.RegResultDTO;
import iih.sc.apt.i.IScAptOutCmdService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 预约门诊号
 * 
 * @author liubin
 *
 */
public class WsEnMakeAptBP {
	/**
	 * 预约门诊号
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public WsEnResult<WsEnResultMakeApt> exec(WsEnParamMakeApt param) throws BizException {
		//1.参数校验
		this.validate(param);
		//2.设置上下文
		this.setContext(param);
		//3.预约
		RegResultDTO result = this.makeApt(this.assemly(param));
		//4.返回组装数据
		return this.wrap(result);
	}
	/**
	 * 参数校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void validate(WsEnParamMakeApt param) throws BizException {
		if(param == null)
			throw new BizException("入参为空或者xml转换失败!");
		if(EnValidator.isEmpty(param.getPatCode()))
			throw new BizException("患者编码不能为空！");
		if(EnValidator.isEmpty(param.getAptCode()))
			throw new BizException("预约码不能为空！");
		if(EnValidator.isEmpty(param.getChlType()))
			throw new BizException("渠道编码不能为空！");
		if(EnValidator.isEmpty(param.getId_sch()))
			throw new BizException("预约排班不能为空！");
	}
	/**
	 * 设置上下文
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void setContext(WsEnParamMakeApt param) throws BizException {
		if(!EnValidator.isEmpty(param.getOprCode())){
	    	new SetPsnDocContextBP().exec(param.getOprCode());
		}
	}
	/**
	 * 组装MakeAptDTO
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private MakeAptDTO assemly(WsEnParamMakeApt param) throws BizException {
		MakeAptDTO makeAptDTO = new MakeAptDTO();
		makeAptDTO.setPatCode(param.getPatCode());
		makeAptDTO.setAptCode(param.getAptCode());
		makeAptDTO.setChlType(param.getChlType());
		makeAptDTO.setAgentCode(param.getAgentPatCode());
		makeAptDTO.setSchId(param.getId_sch());
		makeAptDTO.setOprCode(param.getOprCode());
		makeAptDTO.setOrgName_apply(param.getOrgName_apply());
		makeAptDTO.setTransFlag(param.getTransFlag());
		makeAptDTO.setTickCode(param.getTickNo());
		makeAptDTO.setId_ticks(param.getId_ticks());
		return makeAptDTO;
	}
	/**
	 * 预约
	 * 
	 * @param makeAptDTO
	 * @return
	 * @throws BizException
	 */
	private RegResultDTO makeApt(MakeAptDTO makeAptDTO) throws BizException{
		IScAptOutCmdService serv = ServiceFinder.find(IScAptOutCmdService.class);
		return serv.aptForWechatNew(makeAptDTO);
	}
	/**
	 * 组装返回值
	 * 
	 * @param aptResult
	 * @return
	 */
	private WsEnResult<WsEnResultMakeApt> wrap(RegResultDTO aptResult){
		WsEnResultMakeApt data = new WsEnResultMakeApt();
		data.setId_apt(aptResult.getId_apt());
		data.setSequenceNumber(aptResult.getSequenceNumber());
		data.setTimes(aptResult.getTimes());
		data.setSugestExmint(aptResult.getSuggestExmint());
		data.setPlaceOfVisit(aptResult.getPlaceOfVisit());
		data.setEntDate(aptResult.getEntDate());
		data.setVisitingtime(aptResult.getVisitingTime());
		List<WsEnResultMakeApt> datas = new ArrayList<WsEnResultMakeApt>();
		datas.add(data);
		WsEnResult<WsEnResultMakeApt> result = new WsEnResult<WsEnResultMakeApt>();
		result.setDatas(datas);
		return result;
	}
}
