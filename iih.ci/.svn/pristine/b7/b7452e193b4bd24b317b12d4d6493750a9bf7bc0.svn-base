package iih.ci.ord.s.external.blood.ruimei.s;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.TransactionStatus;

import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.external.blood.ruimei.d.DepCondition;
import iih.ci.ord.external.blood.ruimei.d.IEOpBtOrEnParamDTO;
import iih.ci.ord.external.blood.ruimei.d.IEOpBtUbCancelOrEnParamDTO;
import iih.ci.ord.external.blood.ruimei.d.IEOpUbOrEnParamDTO;
import iih.ci.ord.external.blood.ruimei.d.PatIpcodeParam;
import iih.ci.ord.external.blood.ruimei.d.PatcodeParam;
import iih.ci.ord.external.blood.ruimei.i.IRuiMeiBloodManageService;
import iih.ci.ord.external.blood.wqxk.d.ChargeItem;
import iih.ci.ord.external.blood.wqxk.d.WQUbOrEnParamDTO;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.external.blood.ruimei.s.bp.AddFeeBP;
import iih.ci.ord.s.external.blood.ruimei.s.bp.BloodManageUtils;
import iih.ci.ord.s.external.blood.ruimei.s.bp.ConvertXml2DTOsUtils;
import iih.ci.ord.s.external.blood.ruimei.s.bp.DeptInfoSql;
import iih.ci.ord.s.external.blood.ruimei.s.bp.ErrorMsgBp;
import iih.ci.ord.s.external.blood.ruimei.s.bp.GeneralBaseDataXml;
import iih.ci.ord.s.external.blood.ruimei.s.bp.GetIpInfoByDepBp;
import iih.ci.ord.s.external.blood.ruimei.s.bp.GetIpInfoByIpCodeBp;
import iih.ci.ord.s.external.blood.ruimei.s.bp.GetIpInfoByPatBp;
import iih.ci.ord.s.external.blood.ruimei.s.bp.UserInfoSql;
import iih.ci.ord.s.external.blood.ruimei.s.bp.WanQuanBloodUtils;
import iih.ci.ord.s.external.blood.ruimei.s.bp.WriteBackUBPBCancleDataBp;
import iih.ci.ord.s.external.blood.ruimei.s.bp.WriteBackUBTDataBp;
import iih.ci.ord.s.external.blood.ruimei.s.bp.WritebackPBTDataBp;
import iih.ci.ord.s.external.thirdws.utils.LogUtils;
import iih.ci.ord.s.external.thirdws.utils.RstMsgBP;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

public class RuiMeiBloodManageServiceImpl implements IRuiMeiBloodManageService {

	@Override
	public String getUserInfo(String param) throws BizException {
		try {
			UserInfoSql sql = new UserInfoSql();
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> datas = (List<Map<String, Object>>) new DAFacade().execQuery(sql.getQrySQLStr(),
					new MapListHandler());
			GeneralBaseDataXml bp = new GeneralBaseDataXml();
			return bp.exec(datas, "userinfo");
		} catch (Exception e) {
			OrdBizLogger.info(null, e.getMessage());
			return ErrorMsgBp.getBaseDataMsg("1", e.getMessage(), "userinfo");
		}
	}

	@Override
	public String getDeptInfo(String param) throws BizException {
		try {
			DeptInfoSql sql = new DeptInfoSql();
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> datas = (List<Map<String, Object>>) new DAFacade().execQuery(sql.getQrySQLStr(),
					new MapListHandler());
			GeneralBaseDataXml bp = new GeneralBaseDataXml();
			return bp.exec(datas, "deptinfo");
		} catch (Exception e) {
			OrdBizLogger.info(null, e.getMessage());
			return ErrorMsgBp.getBaseDataMsg("1", e.getMessage(), "deptinfo");
		}
	}

	@Override
	public String getIpInfoByDep(String xmlParam) throws BizException {
		GetIpInfoByDepBp bp = new GetIpInfoByDepBp();
		DepCondition param = (DepCondition) PraseXmlToDTO(xmlParam, DepCondition.class);
		return bp.exec(param);
	}

	@Override
	public String getIpInfoByPat(String xmlParam) throws BizException {
		GetIpInfoByPatBp bp = new GetIpInfoByPatBp();
		PatcodeParam param = (PatcodeParam) PraseXmlToDTO(xmlParam, PatcodeParam.class);
		return bp.exec(param);
	}

	@Override
	public String getIpInfoByIpCode(String xmlParam) throws BizException {
		GetIpInfoByIpCodeBp bp = new GetIpInfoByIpCodeBp();
		PatIpcodeParam param = (PatIpcodeParam) PraseXmlToDTO(xmlParam, PatIpcodeParam.class);
		return bp.exec(param);
	}

	/**
	 * 回写备血医嘱信息
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public String writebackpbt(String param) throws BizException {
		final String xmlParam = param;
		LogUtils.Logger("备血调用入参：:"+param);
		final List<String> reList = new ArrayList<String>();
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
				@Override
				public String doInTransaction(TransactionStatus status) {
					try {
						IEOpBtOrEnParamDTO param = (IEOpBtOrEnParamDTO) PraseXmlToDTO(xmlParam,
								IEOpBtOrEnParamDTO.class);
						WritebackPBTDataBp bp = new WritebackPBTDataBp();
						String rtn = bp.exec(param);
						reList.add(rtn);
					} catch (Exception e) {
						BloodManageUtils.LogInfo(e);
						throw new RuntimeException(e.getMessage());
					}
					return reList.get(0);
				}
			});
		} catch (Exception e) {
			return ErrorMsgBp.getComfirmFeeMsg("1", e.getMessage());// 特殊情况（xml生成失败时的返回值）
		}
	}

	/**
	 * 解析Xml至DTO
	 * 
	 * @param xamParam
	 * @param classInfo
	 * @return
	 * @throws BizException
	 */
	private <T extends BaseDTO> BaseDTO PraseXmlToDTO(String xamParam, Class<T> classInfo) throws BizException {
		ConvertXml2DTOsUtils bp = new ConvertXml2DTOsUtils();
		return bp.exec(xamParam, classInfo);
	}

	@Override
	public String writebackubt(String param) throws BizException {
		// TODO Auto-generated method stub
		final String xmlParam = param;
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
				@Override
				public String doInTransaction(TransactionStatus status) {
					try {
						IEOpUbOrEnParamDTO param = (IEOpUbOrEnParamDTO) PraseXmlToDTO(xmlParam, IEOpUbOrEnParamDTO.class);
						WriteBackUBTDataBp bp = new WriteBackUBTDataBp();
						return bp.exec(param);
					} catch (BizException e) {
						BloodManageUtils.LogInfo(e);
						throw new RuntimeException(e.getMessage());
					}
				}
			});
		} catch (Exception e) {
			return ErrorMsgBp.getComfirmFeeMsg("1", e.getMessage());// 特殊情况（xml生成失败时的返回值）
		}
	}

	@Override
	public String writebackcanclebubt(String param) throws BizException {
		final String xmlParam = param;
		final List<String> reList = new ArrayList<String>();
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {

				@Override
				public String doInTransaction(TransactionStatus arg0) {
					try {
						IEOpBtUbCancelOrEnParamDTO param = (IEOpBtUbCancelOrEnParamDTO) PraseXmlToDTO(xmlParam,
								IEOpBtUbCancelOrEnParamDTO.class);
						WriteBackUBPBCancleDataBp bp = new WriteBackUBPBCancleDataBp();
						String rnt = bp.exec(param);
						reList.add(rnt);
					} catch (Exception e) {
						BloodManageUtils.LogInfo(e);
						throw new RuntimeException(e.getMessage());
					}
					return reList.get(0);
				}

			});
		} catch (Exception e) {
			return ErrorMsgBp.getComfirmFeeMsg("1", e.getMessage());// 特殊情况（xml生成失败时的返回值）
		}

	}
/**
 * 万全血库用血
 * 回写用血医嘱并补费
 */
	@Override
	public String writebackubtAddFee(String param) throws BizException {
		// TODO Auto-generated method stub
		final String xmlParam = param;
		final List<String> reList = new ArrayList<String>();
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {

				@Override
				public String doInTransaction(TransactionStatus arg0) {
					try {
						WQUbOrEnParamDTO param=(WQUbOrEnParamDTO) new ConvertXml2DTOsUtils().exec(xmlParam, WQUbOrEnParamDTO.class,ChargeItem.class);
						AddFeeBP feebp=new AddFeeBP();
						if("1".equals(param.getDirectflag())) {
						IEOpUbOrEnParamDTO ubparam =WanQuanBloodUtils.getUbParam(param);
						WriteBackUBTDataBp bp = new WriteBackUBTDataBp();
						String rst=bp.exec(ubparam);
						CiOrderDO ord=WanQuanBloodUtils.validateUbwriteBk(ubparam, rst);					
						//todo 计费						
						BlCgAccountRltDTO rnt=feebp.keepAcount4IP(param, ord);
						if(rnt!=null&&rnt.getFg_success().booleanValue()) {
							feebp.updateOrdStatus(ord);
							reList.add(rst);
						}else {
							if(rnt!=null) {
								throw new BizException(rnt.getErr_msg());
							}else {
								throw new BizException("记账失败！");
							}
						}
						
						}else if("-1".equals(param.getDirectflag())) {
							//退费
							CiOrderDO ord=feebp.getCiOrd(param);
							BlCgAccountRltDTO rnt=feebp.refundfee(param,ord);
							if(rnt.getFg_success().booleanValue()) {
								feebp.updateOrdRefundStatus(ord);
								String msg=RstMsgBP.getRstMsgCodeMsg("0", "用血医嘱退费成功");
								reList.add(msg);
							}else {
								throw new BizException(rnt.getErr_msg());
							}
						}
					} catch (Exception e) {
						BloodManageUtils.LogInfo(e);
						throw new RuntimeException(e.getMessage());
					}
					return reList.get(0);
				}

			});
		} catch (Exception e) {
			return ErrorMsgBp.getComfirmFeeMsg("1", e.getMessage());// 特殊情况（xml生成失败时的返回值）
		}
	}
}
