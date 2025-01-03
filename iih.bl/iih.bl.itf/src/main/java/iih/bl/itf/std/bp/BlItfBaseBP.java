package iih.bl.itf.std.bp;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IPripmRService;
import iih.bd.utils.WsXmlUtils;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.itf.bltranscall.d.BlTransCalledRcdDO;
import iih.bl.itf.bltranscall.i.IBltranscallCudService;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.output.WsResult;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.pi.dic.patientcategory.d.PiPatCaDO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * 标准接口处理基类
 * @author ly 2018/07/20
 *
 * @param <T> xml映射入参泛型
 * @param <V> xml映射出参泛型
 * 
 * @version ly 2018/07/17 添加出参泛型及处理
 */
public abstract class BlItfBaseBP<T extends Serializable,V extends Serializable> {

	private final String INPUT_PARAM_FORMAT = "%s开始，入参:%s";
	private final String OUT_PARAM_FORMAT = "%s结束，出参:%s";
	private final String ERROR_FORMAT = "%s异常:%s";
	
	/**
	 * 在createTransRcd里创建
	 * 在dowork里进行数据回写
	 * 查询类接口不需要保存该数据
	 */
	protected BlTransCalledRcdDO transRcdDO = null;
	private IBltranscallCudService transService = ServiceFinder.find(IBltranscallCudService.class);
	
	/**
	 * 处理(不起新事务)
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public final String exec(String param) throws BizException{
		
		BLThirdItfLogger.info(String.format(INPUT_PARAM_FORMAT, this.getBusiness(), param));
		T tData = WsXmlUtils.deSerializeBaseDO(param, this.getTClass());
		
		String rlt = null;
		try {
			this.check(tData);
			this.saveTransRcd(param, tData);
			V v = doWork(tData);
			rlt = WsXmlUtils.serialize(v);
			this.updateTransRcd();
		} catch (Exception e) {
			BLThirdItfLogger.error(String.format(ERROR_FORMAT, this.getBusiness(),e.getMessage()));
			this.updateTransRcdExcep(e.getMessage());
			return this.rtnWhenCheckError(e.getMessage());
		}
		BLThirdItfLogger.info(String.format(OUT_PARAM_FORMAT, this.getBusiness(), rlt));
		return rlt;
	}
	
	/**
	 * 处理(起新事务)
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public final String execTrans(String param) throws BizException{
		
		BLThirdItfLogger.info(String.format(INPUT_PARAM_FORMAT, this.getBusiness(), param));
		final T tData = WsXmlUtils.deSerializeBaseDO(param, this.getTClass());
		try {
			this.check(tData);
		} catch (BizException e) {
			BLThirdItfLogger.error(String.format(ERROR_FORMAT, this.getBusiness(),e.getMessage()));
			return this.rtnWhenCheckError(e.getMessage());
		}
		
		String rlt = null;
		try {
			this.saveTransRcd(param, tData);
			rlt = TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
			@Override
			public String doInTransaction(TransactionStatus status){
				try {					
					V v = doWork(tData);
					return WsXmlUtils.serialize(v);
				} catch (Exception e) {
					BLThirdItfLogger.error(String.format(ERROR_FORMAT, getBusiness(), e.getMessage()), e);
					throw new RuntimeException(e.getMessage());
				}
			}			
			});
			this.updateTransRcd();
		} catch (Exception e) {
			this.updateTransRcdExcep(e.getMessage());
			return this.rtnWhenCheckError(e.getMessage());
		}
		
		BLThirdItfLogger.info(String.format(OUT_PARAM_FORMAT, this.getBusiness(), rlt));
		return rlt;
	}

	/**
	 * 处理(不起新事务)结构化出入参
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public final V execTV(T param) throws BizException{
		
		V rlt = null;
		try {
			this.check(param);
			this.saveTransRcd(WsXmlUtils.serialize(param), param);
			rlt = this.doWork(param);
			this.updateTransRcd();
		} catch (Exception e) {
			BLThirdItfLogger.error(String.format(ERROR_FORMAT, this.getBusiness(),e.getMessage()));
			this.updateTransRcdExcep(e.getMessage());
			//return this.rtnWhenCheckError(e.getMessage());
			throw new BizException(e);
		}
		BLThirdItfLogger.info(String.format(OUT_PARAM_FORMAT, this.getBusiness(), rlt));
		return rlt;
		
	}
	
	/**
	 * 处理(起新事务)结构化出入参
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public final V execTransTV(T param) throws BizException{
		
		try {
			this.check(param);
		} catch (BizException e) {
			BLThirdItfLogger.error(String.format(ERROR_FORMAT, this.getBusiness(),e.getMessage()));
			throw new BizException(e);
		}
		
		V rlt = null;
		try {
			this.saveTransRcd(WsXmlUtils.serialize(param), param);
			final T paramF = param;
			rlt = TransactionExecutor.executeNewTransaction(new TransactionalOperation<V>() {
			@Override
			public V doInTransaction(TransactionStatus status){
				try {					
					return doWork(paramF);
				} catch (Exception e) {
					BLThirdItfLogger.error(String.format(ERROR_FORMAT, getBusiness(), e.getMessage()), e);
					throw new RuntimeException(e.getMessage());
				}
			}			
			});
			this.updateTransRcd();
		} catch (Exception e) {
			this.updateTransRcdExcep(e.getMessage());
			//return this.rtnWhenCheckError(e.getMessage());
			throw new BizException(e);
		}
		
		BLThirdItfLogger.info(String.format(OUT_PARAM_FORMAT, this.getBusiness(), rlt));
		return rlt;
	}
	
	/**
	 * 业务处理定义
	 * @return
	 * @throws BizException
	 */
	protected abstract String getBusiness();
	
	/**
	 * 入参校验(子类)
	 * @param param
	 * @return
	 * @throws BizException
	 */
	protected abstract void checkParam(T param) throws BizException;
	
	/**
	 * 核心处理
	 * @param param
	 * @return
	 * @throws BizException
	 */
	protected abstract V doWork(T param) throws BizException;
	
	/**
	 * 查询人员信息
	 * @param code
	 * @return
	 * @throws BizException
	 */
	protected PsnDocDO getPsnInfo(String code) throws BizException{
		IPsndocMDORService rService = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] dos = rService.findByAttrValString(PsnDocDO.CODE, code);
		if(ArrayUtil.isEmpty(dos))
			return null;
		
		return dos[0];
	}
	
	/**
	 * 查询付款方式
	 * @param code
	 * @return
	 * @throws BizException
	 */
	protected PriPmDO getPmByCode(String code) throws BizException{
		IPripmRService pmService = ServiceFinder.find(IPripmRService.class);
		PriPmDO[] dos = pmService.findByAttrValString(PriPmDO.CODE, code);
		if(ArrayUtil.isEmpty(dos))
			return null;
		
		return dos[0];
	}
	
	/**
	 * 创建交易记录
	 * 在dowork前调用，可将部分数据初始化挪至该处理
	 * @param xml
	 * @param tData
	 * @return
	 * @throws BizException
	 */
	protected BlTransCalledRcdDO createTransRcd(String xml, T tData) throws BizException{
		return null;
	}
	
	/**
	 * 查询医保产品
	 * @param codeHp
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	protected HPDO queryHpDO(String codeHp) throws BizException{
		//查询医保相关数据
		DAFacade daf = new DAFacade();
		List<HPDO> hpList = (List<HPDO>)daf.findByAttrValString(HPDO.class, HPDO.CODE, codeHp, new String[]{HPDO.ID_HP});
		
		if(ListUtil.isEmpty(hpList)){
			throw new BizException("根据医保编码未查询到医保产品信息，医保编码:" + codeHp);
		}
		
		return hpList.get(0);
	}
	
	/**
	 * 查询患者分类数据
	 * @param hpId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	protected PiPatCaDO[] queryPatCa(String hpId) throws BizException{
		
		String sql = "select id_hp,id_patca from pi_pat_ca_hp where id_hp = ? ";
		
		SqlParam param = new SqlParam();
		param.addParam(hpId);
		
		List<PiPatCaDO> patCaList = (List<PiPatCaDO>)new DAFacade().execQuery(sql, param, new BeanListHandler(PiPatCaDO.class));
		if(ListUtil.isEmpty(patCaList)){
			throw new BizException("未查询到医保产品id对应的患者分类，医保产品id" + hpId);
		}
		
		return patCaList.toArray(new PiPatCaDO[0]);
	}
	
	/**
	 * 入参校验
	 * @param t
	 * @throws BizException
	 */
 	private void check(T param) throws BizException{
		
		if(param == null){
			throw new BizException("入参为空或者xml转换失败");
		}
		this.checkParam(param);
	}
	
	/**
	 * 保存交易记录
	 * @param xml
	 * @param t
	 * @throws BizException
	 */
	private void saveTransRcd(String xml, T tData) throws BizException{
		
		this.transRcdDO = createTransRcd(xml, tData);
		if (this.transRcdDO == null)
			return;

		this.transRcdDO = this.transService.insert(new BlTransCalledRcdDO[] { this.transRcdDO })[0];
	}
	
	/**
	 * 更新交易记录
	 * @throws BizException
	 */
	private void updateTransRcd() throws BizException{
		
		if (this.transRcdDO == null)
			return;
		
		this.transService.update(new BlTransCalledRcdDO[] { this.transRcdDO });
	}
	
	/**
	 * 更新异常交易记录
	 * @param exception
	 * @throws BizException
	 */
	private void updateTransRcdExcep(String exception) throws BizException{
		
		if (this.transRcdDO == null)
			return;
		
		this.transRcdDO.setFg_success(FBoolean.FALSE);
		this.transRcdDO.setError_msg(exception);
		this.transService.update(new BlTransCalledRcdDO[] { this.transRcdDO });
	}
	
	/**
	 * 校验错误后默认返回值
	 * @param msg
	 * @return
	 */
	private String rtnWhenCheckError(String msg){
		WsResult rlt = new WsResult();
		WsResultMsg rltMsg = new WsResultMsg();
		rltMsg.setCode(IBlWsConst.RLT_FAIL);
		rltMsg.setMessage(msg);
		
		rlt.setRltMsg(rltMsg);
		return rlt.serialize();
	}

	/**
	 * 获取T class类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getTClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
