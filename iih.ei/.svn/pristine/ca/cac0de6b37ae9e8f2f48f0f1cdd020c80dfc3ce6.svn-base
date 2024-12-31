package iih.ei.std.s.v1.bp.en;

import java.util.List;

import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bl.itf.dto.regincinfo.d.RegIncDTO;
import iih.bl.itf.std.inner.en.IBlOpChargeForEnInnerService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.ei.std.d.v1.en.cancaptandrefund.d.CancAptAndRefundParamDTO;
import iih.ei.std.d.v1.en.cancaptandrefund.d.CancAptAndRefundResultDTO;
import iih.ei.std.d.v1.utils.EiValidator;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScaptMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 取消预约并退费
 * @author fanlq
 * @date: 2019年10月12日 上午11:12:37
 */
public class CancAptAndRefundBP extends IIHServiceBaseBP<CancAptAndRefundParamDTO, CancAptAndRefundResultDTO> {

	@Override
	protected void checkParam(CancAptAndRefundParamDTO param) throws BizException {
		if(StringUtils.isNullOrEmpty(param.getId_apt())) {
			throw new BizException("预约id不能为空！");
		}
	}

	@Override
	protected CancAptAndRefundResultDTO process(CancAptAndRefundParamDTO param) throws BizException {
		ScAptDO apt = this.getScApt(param.getId_apt());
		//1.校验预约状态
		this.volidateAptStatus(apt);
		//2.组装预约信息
		OpAptDTO aptDTO = new OpAptDTO();
		this.wrapOpApt(aptDTO, apt);
		//校验是否可以退费-已发发票不允许退费
		this.isCancEntRefund(aptDTO);
		//3.取消预约
		IScAptOutCmdService serv = ServiceFinder.find(IScAptOutCmdService.class);
		serv.cancOpApt(aptDTO);
		//4.设置结算信息
		CancAptAndRefundResultDTO result = this.setStInfo(param.getId_apt());
		return result;
	}
	/***
	 * @Description:校验是否可以退费
	 * @param aptDTO
	 * @return
	 * @throws BizException 
	 */
	private void isCancEntRefund(OpAptDTO aptDTO) throws BizException{
		if(!EiValidator.isEmpty(aptDTO.getId_ent())){
			IBlOpChargeForEnInnerService service = ServiceFinder.find(IBlOpChargeForEnInnerService.class);
			RegIncDTO incDTO = service.getRegIncInfo(aptDTO.getId_ent());
			if(!EiValidator.isEmpty(incDTO) && !EiValidator.isEmpty(incDTO.getIncno_paper())){
				throw new BizException("此号已经打印纸质发票，请到窗口退号！");
			}
		}
	}
	/**
	 * 获取预约记录
	 * 
	 * @param aptId 预约id
	 * @return
	 * @throws BizException 
	 * @throws Exception 
	 */
	private ScAptDO getScApt(String aptId) throws BizException{
		IScaptMDORService serv = ServiceFinder.find(IScaptMDORService.class);
		return serv.findById(aptId);
	}
	/***
	 * @Description:校验预约状态
	 * @param apt
	 * @throws BizException 
	 */
	private void volidateAptStatus(ScAptDO apt) throws BizException{
		if(apt == null) {
			throw new BizException("没找到对应预约记录!");
		}
		if(FBoolean.TRUE.equals(apt.getFg_canc())){
			throw new BizException("该预约已经取消, 不能再次取消预约!");
		}
		if(FBoolean.FALSE.equals(apt.getFg_payment())){
			throw new BizException("该预约未付费，不允许退费！");
		}
		if(isHpPay(apt.getId_apt())){
			throw new BizException("该预约是医保支付，请到窗口退号！");
		}
		if(IScDictCodeConst.SD_APTSTATUS_FINISH.equals(apt.getSd_status())){
			throw new BizException("预约已经完成, 不能取消预约!");
		}
	}
	/**
	 * 是否是医保支付
	 * 
	 * @param id_apt
	 * @return
	 * @throws DAException
	 */
	private boolean isHpPay(String id_apt) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT COUNT(1) ");
		sqlBuilder.append(" FROM EN_ENT EN ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sqlBuilder.append(" INNER JOIN EN_ENT_HP HP ON EN.ID_ENT = HP.ID_ENT ");
		sqlBuilder.append(" WHERE OP.ID_SCHAPT = ? ");
		SqlParam param = new SqlParam();
		param.addParam(id_apt);
		Integer count = (Integer) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnHandler());
		return count != null && count > 0;
	}
	/**
	 * 组装OpAptDTO
	 * 
	 * @param aptDTO
	 * @param apt
	 * @throws BizException 
	 */
	private void wrapOpApt(OpAptDTO aptDTO, ScAptDO apt) throws BizException{
		aptDTO.setId_apt(apt.getId_apt());
		if(FBoolean.TRUE.equals(apt.getFg_payment())){
			String entId = this.getEntId(apt.getId_apt());
			aptDTO.setId_ent(entId);
		}
	}
	/**
	 * 获取就诊Id
	 * 
	 * @param aptId
	 * @return
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	private String getEntId(String aptId) throws DAException{
		String sql = "select op.id_ent from en_ent_op op where op.id_schapt = ? ";
		SqlParam param  = new SqlParam();
		param.addParam(aptId);
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(!ListUtil.isEmpty(list))
			return list.get(0);
		return null;
	}
	/**
	 * 设置结算信息
	 * 
	 * @param resultDto
	 * @param aptId
	 * @throws BizException
	 */
	private CancAptAndRefundResultDTO setStInfo(String aptId) throws BizException{
		CancAptAndRefundResultDTO result = new CancAptAndRefundResultDTO();
		BlStOepDO st = new SetStInfoByAptId().queryCancStByAptId(aptId);
		if(st == null)
			return null;
		result.setId_stoep(st.getId_stoep());
		result.setCode_st(st.getCode_st());
		result.setDt_st(st.getDt_st()==null? null : st.getDt_st().toString());
		return result;
	}
}
