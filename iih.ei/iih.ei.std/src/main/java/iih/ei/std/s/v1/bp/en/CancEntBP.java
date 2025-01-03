package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bl.cg.i.IBlCgValidateService;
import iih.bl.comm.dto.d.BlCheckResultDTO;
import iih.bl.itf.dto.regincinfo.d.RegIncDTO;
import iih.bl.itf.std.inner.en.IBlOpChargeForEnInnerService;
import iih.bl.st.blstoep.d.EnReFundTpEnum;
import iih.ci.ord.i.external.provide.ICiOrdEnService;
import iih.ci.ord.i.external.provide.meta.en.Mode4CheckExistValidOrdersEnum;
import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.en.cancent.d.CancEntDTO;
import iih.ei.std.d.v1.en.cancent.d.CancEntParamDTO;
import iih.ei.std.d.v1.utils.EiAppUtils;
import iih.ei.std.d.v1.utils.EiValidator;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.EiContextUtils;
import iih.ei.std.s.v1.bp.common.EiParamUtils;
import iih.en.pv.i.IEnOutCmdService;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 门诊退号
 * @author fanlq
 * @date: 2019年12月23日 下午4:12:47
 */
public class CancEntBP extends IIHServiceBaseBP<CancEntParamDTO, NoParamDTO>{

	/***
	 * 必填项校验
	 */
	@Override
	protected void checkParam(CancEntParamDTO param) throws BizException {
		if(EiValidator.isEmpty(param.getId_ent())){
			if(EiValidator.isEmpty(param.getCode_pat()) || EiValidator.isEmpty(param.getTimes_op()))
				throw new BizException("就诊id和code_pat+times_op必须有一个不为空！");
		}
		if(EiValidator.isEmpty(param.getCode_chlty())){
			throw new BizException("渠道类型不能为空！");
		}
	}

	@Override
	protected NoParamDTO process(CancEntParamDTO param) throws BizException {
		Context.get().setAttribute("ReFundTp", EnReFundTpEnum.ENREFUND_CANCEL);//退号
		String sd_pttp = getSchChlPtTp(param);
		CancEntDTO cancEntInfo = this.getCancEntInfo(param);
		this.validator(cancEntInfo,sd_pttp);
		//2.更新就诊数据				
		this.cancEnt(cancEntInfo,sd_pttp);
		return null;
	}

	/***
	 * @Description:获取终端类型
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private String getSchChlPtTp(CancEntParamDTO param) throws BizException{
		ISchedulechlMDORService service = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO[] schedulechlDOs = service.findByAttrValString(SchedulechlDO.SD_SCCHLTP, param.getCode_chlty());
		if(EiValidator.isEmpty(schedulechlDOs) || EiValidator.isEmpty(schedulechlDOs[0])){
			throw new BizException("未查询到该渠道类型对应的渠道信息，请在IIH客户端渠道定义节点维护数据！渠道类型编码为："+param.getCode_chlty());
		}
		if(EiValidator.isEmpty(schedulechlDOs[0].getSd_pttp())){
			throw new BizException("未查询到该渠道类型对应的终端类型，请在IIH客户端渠道定义节点维护数据！渠道类型编码为："+param.getCode_chlty());
		}
		return schedulechlDOs[0].getSd_pttp();
	}
	/***
	 * @Description:获取退号校验数
	 * 据
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private CancEntDTO getCancEntInfo(CancEntParamDTO param) throws BizException{
		StringBuffer sql = new StringBuffer();
		SqlParam sqlparam = new SqlParam();
		sql.append("SELECT ENT.ID_ENT,ENT.FG_CANC,OP.ID_CG,OP.ID_SCH,OP.ID_SCHAPT AS ID_APT,OP.SD_STATUS,ENT.DT_ENTRY ");
		sql.append("FROM EN_ENT ENT " );
		sql.append("INNER JOIN EN_ENT_OP OP ON OP.ID_ENT = ENT.ID_ENT " );
		sql.append("INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT " );
		sql.append("WHERE 1=1 ");
		sql.append("AND (ENT.ID_ENT = ? OR (PAT.CODE = ? AND OP.TIMES_OP = ? ))");
		sqlparam.addParam(param.getId_ent());
		sqlparam.addParam(param.getCode_pat());
		sqlparam.addParam(param.getTimes_op());
		@SuppressWarnings("unchecked")
		List<CancEntDTO> entList = (List<CancEntDTO>) new DAFacade().execQuery(sql.toString(), sqlparam, new BeanListHandler(
						CancEntDTO.class));
		if(EiValidator.isEmpty(entList))
				throw new BizException("患者就诊信息不存在！");
		return entList.get(0);
	}
	/**
	 * 取消就诊 
	 * 1、就诊信息取消 
	 * 2、就诊队列取消
	 * 
	 * @param entId 就诊id
	 * @throws BizException
	 */
	public void cancEnt(CancEntDTO cancEntInfo,String sd_pttp) throws BizException {
		OpAptDTO aptDTO = new OpAptDTO();
		aptDTO.setId_ent(cancEntInfo.getId_ent());
		aptDTO.setId_apt(cancEntInfo.getId_apt());
		aptDTO.setSd_pttp(sd_pttp);
		IEnOutCmdService service = ServiceFinder.find(IEnOutCmdService.class);
		service.cancEnt(aptDTO);
	}
	/**
	 * 退号校验
	 * 
	 * @param entId
	 * @throws BizException
	 */
	public void validator(CancEntDTO cancEntInfo,String sd_pttp) throws BizException {
		//1.校验挂号是否已经取消
		this.validatorPv(cancEntInfo);
		//2.校验是否存在已付费医嘱
		this.validatorBl(cancEntInfo);
		//3.调用费用接口，就诊在指定终端能否退号
		this.validatorPttp(cancEntInfo,sd_pttp);
		//4.退号权限
		this.validatorAuth(cancEntInfo);
		//5.已打印发票不能退
		this.isCancEntRefund(cancEntInfo.getId_ent());
	}
	/**
	 * 校验挂号是否已经取消
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private void validatorPv(CancEntDTO cancEntInfo) throws BizException{
		if(FBoolean.TRUE.equals(cancEntInfo.getFg_canc())){
			throw new BizException("此号已经退了，不能重复退号！");
		}
	}
	/**
	 * 校验是否存在已付费医嘱
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private void validatorBl(CancEntDTO cancEntInfo) throws BizException {
		ICiOrdEnService serv = ServiceFinder.find(ICiOrdEnService.class);
		FBoolean result = serv.isExistValidOrders(cancEntInfo.getId_ent(), Mode4CheckExistValidOrdersEnum.ORDERSTATUS2);
		if (FBoolean.TRUE.equals(result)) {
			throw new BizException("患者当前存在已付费医嘱，不可以退号！");
		}
		
	}

	/***
	 * @Description:调用费用接口，就诊在指定终端能否退号
	 * @param cancEntInfo
	 * @param sd_pttp
	 * @throws BizException
	 */
	private void validatorPttp(CancEntDTO cancEntInfo,String sd_pttp) throws BizException{
		IBlCgValidateService blservice = ServiceFinder.find(IBlCgValidateService.class);
		BlCheckResultDTO resultDTO = blservice.canOpUnregister(cancEntInfo.getId_ent(),sd_pttp);
		if( EiValidator.isEmpty(resultDTO) && FBoolean.FALSE.equals(resultDTO.getResult()) && !EiValidator.isEmpty(resultDTO.getMsg())){
			throw new BizException("门诊退号校验终端类型失败，原因："+resultDTO.getMsg());
		}
	}
	/***
	 * @Description:校验强制退号权限
	 * @param cancEntInfo
	 * @throws BizException
	 */
	private void validatorAuth(CancEntDTO cancEntInfo) throws BizException{
		String id_psndoc = EiContextUtils.getPsnId();
		boolean fg_CancEnt = false;
		boolean _isDrawbackAuth = EiParamUtils.isDrawbackExprired(id_psndoc);
		if(!_isDrawbackAuth){
			int _returnNumberDay = EiParamUtils.getRtuenNumberDay(id_psndoc);
			FDate serviceDate = EiAppUtils.getServerDate();
			FDate curdate = serviceDate.getDateBefore(_returnNumberDay);
			if(curdate.isSameDate(cancEntInfo.getDt_entry().getDate()) || cancEntInfo.getDt_entry().getDate().after(curdate) || cancEntInfo.getDt_entry().getDate().after(serviceDate)){
				fg_CancEnt = true;
			}
			//非预约或挂号状态，不能退号
			if(fg_CancEnt){
				if(!cancEntInfo.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_OP_ORDER)&& !cancEntInfo.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER)){
					throw new BizException("此号已经就诊，不能退号！");
				}
			}else{
				throw new BizException("您没有强制退号权限，不能退已经过期的号！挂号日期为："+cancEntInfo.getDt_entry().getDate());
			}
		}
	}
	/***
	 * @Description:校验是否可以退费
	 * @param id_ent
	 * @return
	 * @throws BizException 
	 */
	private void isCancEntRefund(String id_ent) throws BizException{
		if(!EiValidator.isEmpty(id_ent)){
			IBlOpChargeForEnInnerService service = ServiceFinder.find(IBlOpChargeForEnInnerService.class);
			RegIncDTO incDTO = service.getRegIncInfo(id_ent);
			if(!EiValidator.isEmpty(incDTO) && !EiValidator.isEmpty(incDTO.getIncno_paper())){
				throw new BizException("此号已经打印纸质发票，请到窗口退号！");
			}
		}
	}
}
