package iih.syn.common.i;

import iih.syn.common.init.d.InitAggDO;
import iih.syn.common.initca.d.InitCaDO;
import iih.syn.common.syninitapp.d.SyninitappAggDO;
import iih.syn.sbd.dto.datainit.d.InitLogDTO;
import xap.mw.core.data.BizException;

public interface ISynMaintanceService {

	/**
	 * 数据初始化保存
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract void dataInitSave(InitAggDO param) throws BizException;

	/**
	 * 数据初始化分类保存
	 * 
	 * @param param
	 * @throws BizException
	 */
	public abstract InitCaDO dataInitCaSave(InitCaDO param) throws BizException;
	
	/**
	 * 数据初始化申请
	 * @param list
	 */
	public abstract void dataInitAppSave(SyninitappAggDO[] apps) throws BizException;
	
	/**
	 * 初始化（下载）
	 * 
	 * @param id_init
	 * @param keys
	 * @throws BizException
	 */
	public abstract InitLogDTO dataInit(String id_init_app, String[] keys) throws BizException;
	
	/**
	 * 初始化（上传）
	 * @param id_init
	 * @param id_keys
	 * @throws BizException
	 */
	public abstract void dataInitUpLoad(String id_init, String[] id_keys) throws BizException;
}
