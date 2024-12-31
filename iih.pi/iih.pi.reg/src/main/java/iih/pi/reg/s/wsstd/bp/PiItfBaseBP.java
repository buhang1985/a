package iih.pi.reg.s.wsstd.bp;

import java.lang.reflect.ParameterizedType;

import org.springframework.transaction.TransactionStatus;

import iih.bd.utils.WsXmlUtils;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.output.WsResult;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.pi.reg.i.IPiPatLogService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;

/**
 * 标准接口处理基类
 * 
 * @author shaokx 2019/01/28
 *
 * @param <T>
 *            xml映射入参泛型
 */
public abstract class PiItfBaseBP<T> {

	private final String INPUT_PARAM_FORMAT = "%s开始，入参:%s";
	private final String OUT_PARAM_FORMAT = "%s结束，出参:%s";
	private final String ERROR_FORMAT = "%s异常:%s";

	private IPiPatLogService piPatLog = ServiceFinder.find(IPiPatLogService.class);
	// /**
	// * 在createTransRcd里创建
	// * 在dowork里进行数据回写
	// * 查询类接口不需要保存该数据
	// */
	// protected BlTransCalledRcdDO transRcdDO = null;
	// private IBltranscallCudService transService =
	// ServiceFinder.find(IBltranscallCudService.class);

	/**
	 * 处理(不起新事务)
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public final String exec(String param) throws BizException {

		piPatLog.log(String.format(INPUT_PARAM_FORMAT, this.getBusiness(), param), Level.INFO);
		// BLThirdItfLogger.info(String.format(INPUT_PARAM_FORMAT,
		// this.getBusiness(), param));

		T tData = WsXmlUtils.deSerializeBaseDO(param, this.getTClass());

		String rlt = null;
		try {
			this.check(tData);
			// this.saveTransRcd(param, tData);
			rlt = this.doWork(tData);
			// this.updateTransRcd();
		} catch (BizException e) {
			e.printStackTrace();
			piPatLog.log(String.format(ERROR_FORMAT, this.getBusiness(), e.getMessage()), Level.ERROR);
			// BLThirdItfLogger.error(String.format(ERROR_FORMAT,
			// this.getBusiness(), e.getMessage()));
			// this.updateTransRcdExcep(e.getMessage());
			return this.rtnWhenCheckError(e.getMessage());
		}
		piPatLog.log(String.format(OUT_PARAM_FORMAT, this.getBusiness(), rlt), Level.INFO);
		// BLThirdItfLogger.info(String.format(OUT_PARAM_FORMAT,
		// this.getBusiness(), rlt));
		return rlt;
	}

	/**
	 * 处理(起新事务)
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public final String execTrans(String param) throws BizException {
		piPatLog.log(String.format(INPUT_PARAM_FORMAT, this.getBusiness(), param), Level.INFO);
		// BLThirdItfLogger.info(String.format(INPUT_PARAM_FORMAT,
		// this.getBusiness(), param));
		final T tData = WsXmlUtils.deSerializeBaseDO(param, this.getTClass());
		try {
			this.check(tData);
		} catch (BizException e) {
			piPatLog.log(String.format(ERROR_FORMAT, this.getBusiness(), e.getMessage()), Level.ERROR);
			// BLThirdItfLogger.error(String.format(ERROR_FORMAT,
			// this.getBusiness(), e.getMessage()));
			return this.rtnWhenCheckError(e.getMessage());
		}

		String rlt = null;
		try {
			// this.saveTransRcd(param, tData);
			rlt = TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
				@Override
				public String doInTransaction(TransactionStatus status) {
					try {
						return doWork(tData);
					} catch (BizException e) {
						piPatLog.log(String.format(ERROR_FORMAT, getBusiness(), e.getMessage()), Level.ERROR);
						// BLThirdItfLogger.error(String.format(ERROR_FORMAT,
						// getBusiness(), e.getMessage()), e);
						throw new RuntimeException(e.getMessage());
					}
				}
			});
			// this.updateTransRcd();7
		} catch (Exception e) {
			// this.updateTransRcdExcep(e.getMessage());
			return this.rtnWhenCheckError(e.getMessage());
		}
		piPatLog.log(String.format(OUT_PARAM_FORMAT, this.getBusiness(), rlt), Level.INFO);
		// BLThirdItfLogger.info(String.format(OUT_PARAM_FORMAT,
		// this.getBusiness(), rlt));
		return rlt;
	}

	/**
	 * 业务处理定义
	 * 
	 * @return
	 * @throws BizException
	 */
	protected abstract String getBusiness();

	/**
	 * 入参校验(子类)
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	protected abstract void checkParam(T param) throws BizException;

	/**
	 * 核心处理
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	protected abstract String doWork(T param) throws BizException;

	/**
	 * 查询人员信息
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	protected PsnDocDO getPsnInfo(String code) throws BizException {
		IPsndocMDORService rService = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] dos = rService.findByAttrValString(PsnDocDO.CODE, code);
		if (ArrayUtil.isEmpty(dos))
			return null;

		return dos[0];
	}

	// /**
	// * 创建交易记录
	// * 在dowork前调用，可将部分数据初始化挪至该处理
	// * @param xml
	// * @param tData
	// * @return
	// * @throws BizException
	// */
	// protected BlTransCalledRcdDO createTransRcd(String xml, T tData) throws
	// BizException{
	// return null;
	// }

	/**
	 * 入参校验
	 * 
	 * @param t
	 * @throws BizException
	 */
	private void check(T param) throws BizException {

		if (param == null) {
			throw new BizException("入参为空或者xml转换失败");
		}
		this.checkParam(param);
	}

	// /**
	// * 保存交易记录
	// * @param xml
	// * @param t
	// * @throws BizException
	// */
	// private void saveTransRcd(String xml, T tData) throws BizException{
	//
	// this.transRcdDO = createTransRcd(xml, tData);
	// if (this.transRcdDO == null)
	// return;
	//
	// this.transRcdDO = this.transService.insert(new BlTransCalledRcdDO[] {
	// this.transRcdDO })[0];
	// }

	// /**
	// * 更新交易记录
	// * @throws BizException
	// */
	// private void updateTransRcd() throws BizException{
	//
	// if (this.transRcdDO == null)
	// return;
	//
	// this.transService.update(new BlTransCalledRcdDO[] { this.transRcdDO });
	// }

	// /**
	// * 更新异常交易记录
	// * @param exception
	// * @throws BizException
	// */
	// private void updateTransRcdExcep(String exception) throws BizException{
	//
	// if (this.transRcdDO == null)
	// return;
	//
	// this.transRcdDO.setFg_success(FBoolean.FALSE);
	// this.transRcdDO.setError_msg(exception);
	// this.transService.update(new BlTransCalledRcdDO[] { this.transRcdDO });
	// }

	/**
	 * 校验错误后默认返回值
	 * 
	 * @param msg
	 * @return
	 */
	private String rtnWhenCheckError(String msg) {
		WsResult rlt = new WsResult();
		WsResultMsg rltMsg = new WsResultMsg();
		rltMsg.setCode(IBlWsConst.RLT_FAIL);
		rltMsg.setMessage(msg);

		rlt.setRltMsg(rltMsg);
		return rlt.serialize();
	}

	/**
	 * 获取T class类型
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getTClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
