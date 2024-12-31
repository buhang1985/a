/**
 * 
 */
package iih.bl.itf.std.bp.ipprepay;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.TransactionStatus;

import iih.bl.comm.BlCvtXmlToDTOSBp;
import iih.bl.comm.ErrorMsgBp;
import iih.bl.comm.IBlMsgConst;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.itf.std.bean.input.prepay.BlIpPrepayParamDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;

/**
 * @author dupeng
 *
 */
public class BlPrepayExternalBp {
	
	/**
	 * 保存住院预交金接口
	 * 
	 * @param xmlParam
	 * @return
	 */
	public String SaveIpPrepayInfo(String xmlParam) {
		final String xmlParamStr = xmlParam;
		final List<String> reList = new ArrayList<String>();
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
				@Override
				public String doInTransaction(TransactionStatus status) throws InvocationTargetException {
					try {
						BLThirdItfLogger.info("解析XML格式入参开始");
						String nodeName = "prepay";
						BaseDTO[] params = (BaseDTO[]) BlParamXmlToDTOS(xmlParamStr, BlIpPrepayParamDTO.class, nodeName);
						BLThirdItfLogger.info("解析XML格式入参完成");
						
						//设置人员上下文
						if(!ArrayUtil.isEmpty(params)){
							BlIpPrepayParamDTO paramDTO=(BlIpPrepayParamDTO)params[0];
							String patCode=paramDTO.getOperacode();
							IPsndocMDORService service= ServiceFinder.find(IPsndocMDORService.class);
							PsnDocDO[] psndocArr=service.findByAttrValString(PsnDocDO.CODE, patCode);
							if(ArrayUtil.isEmpty(psndocArr)){
								throw new BizException("未查询到人员信息");
							}
							Context.get().setStuffId(psndocArr[0].getId_psndoc());		
						}
						
						if (params.length > 0) {
							List<BlIpPrepayParamDTO> listParam = new ArrayList<BlIpPrepayParamDTO>();
							for (BaseDTO dto : params) {
								listParam.add((BlIpPrepayParamDTO) dto);
							}
							BLThirdItfLogger.info("保存住院预交金开始");
							SaveIpPrepayInfoBp bp = new SaveIpPrepayInfoBp();
							String rtn = bp.exec(listParam.toArray(new BlIpPrepayParamDTO[listParam.size()]));
							BLThirdItfLogger.info("保存住院预交金结束：返回值" + rtn);
							reList.add(rtn);
						}

					} catch (Exception e) {
						e.printStackTrace();
						reList.add(e.getMessage()); // 异常返回的
						throw new InvocationTargetException(e);
					}
					return reList.get(0); // 正常返回的
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			return ErrorMsgBp.getBaseReturnMsg(IBlMsgConst.FG_FAIL, e.getMessage());// 特殊情况（xml生成失败时的返回值）
		}
	}
	
	/**
	 * 解析Xml至DTO集合
	 * 
	 * @param xamParam
	 * @param classInfo
	 * @return
	 * @throws BizException
	 */
	private <T extends BaseDTO> BaseDTO[] BlParamXmlToDTOS(String xamParam, Class<T> classInfo, String nodeName) throws BizException {
		BlCvtXmlToDTOSBp bp = new BlCvtXmlToDTOSBp();
		return bp.exec(xamParam, classInfo, nodeName);
	}

}
