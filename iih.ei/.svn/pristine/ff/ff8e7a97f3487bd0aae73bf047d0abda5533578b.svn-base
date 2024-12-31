package iih.ei.std.s.v1.bp.en;

import com.mysql.jdbc.StringUtils;

import iih.ei.std.d.v1.en.makeapt.d.MakeAptParamDTO;
import iih.ei.std.d.v1.en.makeapt.d.MakeAptResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.sc.apt.dto.d.MakeAptDTO;
import iih.sc.apt.dto.d.RegResultDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.apt.scapt.d.AptExChlDO;
import iih.sc.apt.scapt.i.IAptexchlRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 预约门诊号
 * @author fanlq
 * @date: 2019年10月11日 上午11:58:30
 */
public class MakeAptBP extends IIHServiceBaseBP<MakeAptParamDTO, MakeAptResultDTO> {

	@Override
	protected void checkParam(MakeAptParamDTO param) throws BizException {
		//1.校验必填项
		this.voledateNotNullParam(param);
		//2.校验是否存在重复预约码
		this.volidateAptCode(param.getCode_exapt());
	}

	@Override
	protected MakeAptResultDTO process(MakeAptParamDTO param) throws BizException {
		IScAptOutCmdService serv = ServiceFinder.find(IScAptOutCmdService.class);
		RegResultDTO result =  serv.aptForWechatNew(this.assemly(param));
		return wrapResult(result);
	}

	/***
	 * @Description:校验必填项
	 * @param param
	 * @throws BizException 
	 */
	private void voledateNotNullParam(MakeAptParamDTO param) throws BizException{
		if(StringUtils.isNullOrEmpty(param.getCode_pat()))
			throw new BizException("患者编码不能为空！");
		if(StringUtils.isNullOrEmpty(param.getCode_exapt()))
			throw new BizException("外部预约码不能为空！");
		if(StringUtils.isNullOrEmpty(param.getCode_chltp()))
			throw new BizException("渠道编码不能为空！");
		if(StringUtils.isNullOrEmpty(param.getId_sch()))
			throw new BizException("预约排班不能为空！");
	}
	/**
	 * 验证是否存在重复预约码
	 * 
	 * @param aptCode
	 * @throws BizException 
	 */
	private void volidateAptCode(String aptCode) throws BizException{
		IAptexchlRService serv = ServiceFinder.find(IAptexchlRService.class);
		AptExChlDO[] aptExs = serv.findByAttrValString(AptExChlDO.CODE_APT, aptCode);
		if(aptExs != null && aptExs.length > 0)
			throw new BizException("已经存在该预约码！");
	}
	/**
	 * 组装MakeAptDTO
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private MakeAptDTO assemly(MakeAptParamDTO param) throws BizException {
		MakeAptDTO makeAptDTO = new MakeAptDTO();
		makeAptDTO.setPatCode(param.getCode_pat());
		makeAptDTO.setAptCode(param.getCode_exapt());
		makeAptDTO.setChlType(param.getCode_chltp());
		makeAptDTO.setAgentCode(param.getCode_agentpat());
		makeAptDTO.setSchId(param.getId_sch());
		makeAptDTO.setOprCode(param.getCode_orp());
		makeAptDTO.setTransFlag(param.getFg_trans());
		makeAptDTO.setTickCode(param.getCode_tick());
		return makeAptDTO;
	}
	/**
	 * 组装返回值
	 * 
	 * @param aptResult
	 * @return
	 */
	private MakeAptResultDTO wrapResult(RegResultDTO aptResult){
		MakeAptResultDTO data = new MakeAptResultDTO();
		data.setId_apt(aptResult.getId_apt());
		data.setCode_ticke(aptResult.getSequenceNumber());
		data.setTimes_op(aptResult.getTimes());
		data.setSugest_exmint(aptResult.getSuggestExmint().toString());
		data.setOp_place(aptResult.getPlaceOfVisit());
		data.setD_entry(aptResult.getEntDate());
		data.setTime_ent(aptResult.getVisitingTime());
		return data;
	}
}
