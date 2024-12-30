package iih.sc.scbd.log.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.SortEntityDos;
import iih.sc.scbd.log.d.ScLogRecDO;
import iih.sc.scbd.log.d.ScLogSettingDO;
import iih.sc.scbd.log.d.desc.ScLogSettingDODesc;
import iih.sc.scbd.log.i.ISclogrecCudService;
import iih.sc.scbd.log.i.ISclogsettingRService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 创建日志BP
 * 
 * @author yank
 *
 */
public class CreateLogBP {	
	private static final String NAME_FIELD = "Name";// 名称字段

	/**
	 * 创建日志
	 * 
	 * @param entityDOs DO对象
	 * @param originDOs 原来对象集合
	 * @param operTp 操作类型,参考枚举：EuOperTp
	 * @throws BizException
	 */
	public <T extends BaseDO> void exec(T[] entityDOs, T[] originDOs, String operTp, String empId) throws BizException {
		if ((ArrayUtil.isEmpty(entityDOs) && ArrayUtil.isEmpty(originDOs))
				|| StringUtil.isEmpty(operTp)) {
			return;
		}

		// 1、获取日志设置
		String tableName = ArrayUtil.isEmpty(entityDOs) ? originDOs[0].getTableName() : entityDOs[0].getTableName();
		ScLogSettingDO logSettingDO = this.getLogSetting(tableName);
		if (logSettingDO == null) {
			return;
		}

		// 2、判定是否需要记录日志，根据设置中操作类型判定
		if (StringUtil.isEmpty(logSettingDO.getOperate_tps()) 
			|| !logSettingDO.getOperate_tps().contains(operTp)) {
			return;
		}

		// 3、保存日志
		List<ScLogRecDO> logRecList = new ArrayList<ScLogRecDO>();		
		int length = ArrayUtil.isEmpty(entityDOs) ? originDOs.length : entityDOs.length;
		if (!ArrayUtil.isEmpty(originDOs)) 
			Arrays.sort(originDOs,new SortEntityDos<BaseDO>());
		if (!ArrayUtil.isEmpty(entityDOs)) 
			Arrays.sort(entityDOs,new SortEntityDos<BaseDO>());
		for (int i = 0; i < length; i++) {
			T entityDO = ArrayUtil.isEmpty(entityDOs) ? null : entityDOs[i];
			T originDO = ArrayUtil.isEmpty(originDOs) ? null : originDOs[i];
			// 根据模板生成日志记录
			ScLogRecDO logRecDO = this.generateLogRec(logSettingDO, entityDO, originDO, operTp, empId);
			if(logRecDO!=null){
				logRecList.add(logRecDO);
			}
		}
		
		ISclogrecCudService logCudService = ServiceFinder.find(ISclogrecCudService.class);
		logCudService.save(logRecList.toArray(new ScLogRecDO[0]));
	}
	
	/**
	 * 创建自定义日志
	 * @param logSettingDO 日志设置
	 * @param entityDO 新DO对象
	 * @param originDO 原来DO对象
	 * @param operTp 操作类型
	 * @return
	 * @throws BizException
	 */
	private <T extends BaseDO> ScLogRecDO generateLogRec(ScLogSettingDO logSettingDO,T entityDO, T originDO, String operTp, String empId) throws BizException{
		this.validateUpdateIsSame(entityDO, originDO);	
		// 根据模板生成日志内容
		LogParser parser = new LogParser();
		String logContent = parser.generate(logSettingDO.getTemp_content(), logSettingDO.getFields(), entityDO,
				originDO);
		if (StringUtil.isEmpty(logContent)) {
			return null;
		}
		T doObj = entityDO == null ? originDO : entityDO;
		ScLogRecDO logRecDO = new ScLogRecDO();
		logRecDO.setId_grp(Context.get().getGroupId());
		logRecDO.setId_org(Context.get().getOrgId());
		logRecDO.setName_table(logSettingDO.getName_table());// 表名
		logRecDO.setId_data(doObj.getPkVal());// id值
		if (!StringUtil.isEmpty(logSettingDO.getField_parent_id())) {
			String parentId = (String) doObj.getAttrVal(logSettingDO.getField_parent_id());
			logRecDO.setId_parent_data(parentId);// 外键的值
		}
		logRecDO.setDt_log(ScAppUtils.getServerDateTime());// 日志时间
		logRecDO.setId_emp(empId);// 修改人
		logRecDO.setEu_operate(operTp);// 操作类型
		Object recName = doObj.getAttrVal(NAME_FIELD);
		logRecDO.setName_rec(recName == null ? "" : recName.toString());// 记录的名称
		logRecDO.setContent(logContent);// 日志内容
		logRecDO.setStatus(DOStatus.NEW);
		return logRecDO;
	}
	/**
	 * 验证更新的对象是否相同
	 * @param entityData
	 * @param origData
	 * @throws BizException
	 */
	private void validateUpdateIsSame(BaseDO entityData,BaseDO origData) throws BizException{
		if(entityData==null || origData==null) 
			return;
		if(!entityData.getPkVal().equals(origData.getPkVal())){
			throw new BizException("所更新对象与原始对象不是同一个。");
		}
	}
	/**
	 * 获取日志设置
	 * 
	 * @param tableName 表名
	 * @return
	 * @throws BizException
	 */
	private ScLogSettingDO getLogSetting(String tableName) throws BizException {
		ISclogsettingRService logSettingRService = ServiceFinder.find(ISclogsettingRService.class);
		String whereStr = String.format("%s.name_table='%s'", ScLogSettingDODesc.TABLE_ALIAS_NAME, tableName);
		ScLogSettingDO[] logSettingDOs = logSettingRService.find(whereStr, null, FBoolean.TRUE);
		if (ArrayUtil.isEmpty(logSettingDOs)) {
			Logger.info(tableName + "未定义日志记录设置");
			return null;
		}
		return logSettingDOs[0];
	}
}
