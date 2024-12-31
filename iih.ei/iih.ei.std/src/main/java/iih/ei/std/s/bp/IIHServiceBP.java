package iih.ei.std.s.bp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;

import com.alibaba.fastjson.JSON;

import iih.bd.utils.FileUtils;
import iih.bd.utils.XmlSerializeUtils;
import iih.ei.itf.eiitfdo.d.EiItfDO;
import iih.ei.itf.eiitfdo.d.SerializeTp;
import iih.ei.itf.eiitfdo.i.IEiitfdoRService;
import iih.ei.std.common.EiWsLogger;
import iih.ei.std.d.IIHServiceParamDTO;
import iih.ei.std.d.IIHServiceResultDTO;
import iih.ei.std.d.IIHWsResultCodeConst;
import iih.ei.std.exception.IIHWsException;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * IIHWebService处理逻辑
 * 
 * @author hao_wu 2019-8-30
 *
 */
public class IIHServiceBP {

	public String exec(String code, String paramStr) {

		long beginTime = System.currentTimeMillis();
		writeIIHServiceBeginLog(code, paramStr);

		String resultStr = null;
		String serializeTp = SerializeTp.XML;
		IIHServiceResultDTO resultObj = new IIHServiceResultDTO();
		resultObj.setCode(IIHWsResultCodeConst.Success);
		resultObj.setMsg(IIHWsResultCodeConst.getResultMsg(IIHWsResultCodeConst.Success));
		// 业务服务执行结果
		String businessResult = null;
		try {
			// 查询接口信息
			EiItfDO itfInfoDo = getItfInfoByCode(code);
			if (itfInfoDo == null) {
				throw IIHWsException.createExByCode(IIHWsResultCodeConst.Error_Itf_NotRegister);
			}

			if (FBoolean.FALSE.equals(itfInfoDo.getFg_active())) {
				throw IIHWsException.createExByCode(IIHWsResultCodeConst.Error_Itf_NotFactive);
			}

			IIHServiceParamUtils.setEiItfDo(itfInfoDo);

			if (itfInfoDo.getEu_serialize() != null) {
				// 设置序列化类型
				serializeTp = itfInfoDo.getEu_serialize();
			} else {
				itfInfoDo.setEu_serialize(serializeTp);
			}

			// 反序列化平台参数
			IIHServiceParamDTO param = this.deSerializeParam(paramStr, IIHServiceParamDTO.class, serializeTp);
			if (param == null) {
				throw IIHWsException.createExByCode(IIHWsResultCodeConst.Error_DeSerialize_ServiceParam);
			}

			// 外部编码
			String exCode = param.getCode_external();
			if (StringUtils.isBlank(exCode)) {
				throw IIHWsException.createExByCode(IIHWsResultCodeConst.Error_PARAM_EXCode);
			}
			IIHServiceParamUtils.setExternalCode(exCode);

			// 初始化上下文
			String userCode = param.getCode_user();
			String deptCode = param.getCode_dep();
			initContext(itfInfoDo.getCode(), userCode, deptCode);

			String busParamStr = getBusinessParamStr(paramStr);

			// 处理业务逻辑
			businessResult = execBusiness(itfInfoDo, busParamStr);
		} catch (IIHWsException e) {
			EiWsLogger.error("处理业务逻辑异常", e);
			resultObj.setCode(e.getErrorCode());
			resultObj.setMsg(e.getMessage());
		} catch (Exception e) {
			EiWsLogger.error("处理业务逻辑异常", e);
			resultObj.setCode(IIHWsResultCodeConst.Error_Other);
			resultObj.setMsg(ExceptionUtils.getFullStackTrace(e));
		}

		// 序列化平台结果
		resultStr = serializeResult(resultObj, serializeTp, "iihresult");

		if (StringUtils.isNotBlank(businessResult)) {
			try {
				resultStr = buildResultStr(resultStr, businessResult, serializeTp);
			} catch (IIHWsException e) {
				resultObj.setCode(e.getErrorCode());
				resultObj.setMsg(e.getMessage());
				// 序列化平台结果
				resultStr = serializeResult(resultObj, serializeTp, "iihresult");
			} catch (Exception e) {
				resultObj.setCode(IIHWsResultCodeConst.Error_Other);
				resultObj.setMsg(ExceptionUtils.getFullStackTrace(e));
				// 序列化平台结果
				resultStr = serializeResult(resultObj, serializeTp, "iihresult");
			}
		}

		long endTime = System.currentTimeMillis();
		writeIIHServiceEndLog(code, resultStr, endTime - beginTime);

		return resultStr;
	}

	@SuppressWarnings("unchecked")
	private void initContext(String code, String userCode, String deptCode) throws BizException {
		String msg = String.format("%s标准接口\"%s\"开始初始化上下文。用户编码:%s，科室编码:%s.", FileUtils.NewLine, code, userCode,
				deptCode);
		EiWsLogger.info(msg);

		if (StringUtils.isBlank(userCode)) {
			throw IIHWsException.createExByCode(IIHWsResultCodeConst.Error_Param_UserCode);
		}

		initContextByUserCode(userCode);

		if (StringUtils.isNotBlank(deptCode)) {
			DAFacade daFacade = new DAFacade();
			List<DeptDO> deptDoList = (List<DeptDO>) daFacade.findByAttrValString(DeptDO.class, DeptDO.CODE, deptCode,
					new String[] { DeptDO.ID_DEP });
			if (CollectionUtils.isEmpty(deptDoList)) {
				msg = String.format("根据科室编码获取科室信息失败,科室编码:%s。", deptCode);
				EiWsLogger.error(msg);
				throw IIHWsException.createExByCode(IIHWsResultCodeConst.Error_Param_DepCode_NOTExist);
			}

			if (deptDoList.size() > 1) {
				msg = String.format("根据科室编码获取到多个科室信息,科室编码:%s。", deptCode);
				EiWsLogger.error(msg);
				throw IIHWsException.createExByCode(IIHWsResultCodeConst.Error_Param_DepCode_Repeat);
			}

			Context.get().setDeptId(deptDoList.get(0).getId_dep());
		}

		msg = String.format("%s标准接口\"%s\"初始化上下文完毕。用户编码:%s，科室编码:%s.", FileUtils.NewLine, code, userCode, deptCode);
		EiWsLogger.info(msg);
	}

	/**
	 * 写IIHService调用结束日志
	 * 
	 * @param code
	 * @param resultStr
	 */
	private void writeIIHServiceEndLog(String code, String resultStr, long runTime) {
		String msg = String.format("%s标准接口\"%s\"处理完成。%s耗时:%sms%s结果信息:%s%s", FileUtils.NewLine, code, FileUtils.NewLine,
				runTime, FileUtils.NewLine, FileUtils.NewLine, resultStr);
		EiWsLogger.info(msg);
	}

	/**
	 * 写IIHService调用开始日志
	 * 
	 * @param code
	 * @param paramStr
	 */
	private void writeIIHServiceBeginLog(String code, String paramStr) {
		String msg = String.format("%s标准接口\"%s\"开始处理。%s参数信息:%s%s", FileUtils.NewLine, code, FileUtils.NewLine,
				FileUtils.NewLine, paramStr);
		EiWsLogger.info(msg);
	}

	/**
	 * 获取业务参数
	 * 
	 * @param paramStr
	 * @return
	 * @throws Exception
	 */
	private String getBusinessParamStr(String paramStr) throws Exception {
		Document xmlDocument = XmlSerializeUtils.createXmlDocument(paramStr);
		Element dataEle = (Element) xmlDocument.selectSingleNode("/iihparam/Data");
		if (dataEle == null) {
			return null;
		}

		dataEle = (Element) dataEle.clone();

		Document busDocument = DocumentFactory.getInstance().createDocument();
		busDocument.setRootElement(dataEle);
		String busParamStr = XmlSerializeUtils.write(busDocument);
		return busParamStr;
	}

	/**
	 * 构建结果文本，将业务xml节点嵌入框架xml
	 * 
	 * @param resultStr
	 * @param businessResult
	 * @param serializeTp
	 * @return
	 * @throws Exception
	 */
	private String buildResultStr(String resultStr, String businessResult, String serializeTp) throws Exception {
		if (SerializeTp.XML.equals(serializeTp)) {
			Document dataDocument = XmlSerializeUtils.createXmlDocument(businessResult);
			Element dataEle = dataDocument.getRootElement();
			dataEle = (Element) dataEle.clone();

			Document document = XmlSerializeUtils.createXmlDocument(resultStr);
			Element iihResultEle = (Element) document.selectSingleNode("/iihresult");
			iihResultEle.add(dataEle);

			resultStr = XmlSerializeUtils.write(document);
			return resultStr;
		}
		return null;
	}

	/**
	 * 处理业务逻辑
	 * 
	 * @param itfInfoDo
	 * @param businessParam
	 * @return
	 * @throws Exception
	 */
	private String execBusiness(EiItfDO itfInfoDo, String businessParam) throws Exception {
		// 获取接口类
		Class<?> itfClass = null;
		try {
			itfClass = Class.forName(itfInfoDo.getFullname());
		} catch (ClassNotFoundException e) {
			throw IIHWsException.createExByCode(IIHWsResultCodeConst.Error_Business_NotFound_ItfClass);
		}

		Method methodInfo = null;
		Method[] methods = itfClass.getMethods();
		for (Method method : methods) {
			if (method.getName().equals(itfInfoDo.getMethodname())) {
				methodInfo = method;
				break;
			}
		}
		if (methodInfo == null) {
			throw IIHWsException.createExByCode(IIHWsResultCodeConst.Error_Business_NotFound_Method);
		}

		// 查找服务
		Object itfImpl = ServiceFinder.find(itfClass);
		if (itfImpl == null) {
			throw IIHWsException.createExByCode(IIHWsResultCodeConst.Error_Business_NotFound_ImplService);
		}

		String busResult = null;
		if (FBoolean.TRUE.equals(itfInfoDo.getFg_serialize())) {

			String serializeTp = itfInfoDo.getEu_serialize();

			// 需要平台处理序列化和反序列化
			Class<?>[] paramTypes = methodInfo.getParameterTypes();

			Object paramObj = null;
			if (ArrayUtils.isNotEmpty(paramTypes)) {
				if (!BaseDO.class.isAssignableFrom(paramTypes[0])) {
					throw IIHWsException.createExByCode(IIHWsResultCodeConst.Error_Business_Param_Type);
				}
				// 反序列化参数
				paramObj = deSerializeParam(businessParam, paramTypes[0], serializeTp);
				if (paramObj == null) {
					throw IIHWsException.createExByCode(IIHWsResultCodeConst.Error_DeSerialize_BusinessParam);
				}
			}

			Object resultObj = null;
			try {
				// 调用目标方法
				if (ArrayUtils.isNotEmpty(paramTypes)) {
					resultObj = methodInfo.invoke(itfImpl, paramObj);
				} else {
					resultObj = methodInfo.invoke(itfImpl);
				}

			} catch (InvocationTargetException e) {
				BizException bizException = findBizException(e);
				if (bizException != null) {
					EiWsLogger.error(bizException.getMessage(), bizException);
					throw new IIHWsException(IIHWsResultCodeConst.Error_Business, bizException.getMessage());
				} else {
					throw new IIHWsException(IIHWsResultCodeConst.Error_Business_Other, e.getCause());
				}
			} catch (Exception e) {
				throw new IIHWsException(IIHWsResultCodeConst.Error_Other, e);
			}

			// 序列化结果参数
			busResult = serializeResult(resultObj, serializeTp, "Data");
		} else {
			Class<?>[] paramTypes = methodInfo.getParameterTypes();
			if (ArrayUtils.isNotEmpty(paramTypes)) {
				busResult = (String) methodInfo.invoke(itfImpl, businessParam);
			} else {
				busResult = (String) methodInfo.invoke(itfImpl);
			}
		}
		return busResult;
	}

	/**
	 * 获取业务异常
	 * 
	 * @param e
	 * @return
	 */
	private BizException findBizException(Throwable e) {
		if (e instanceof BizException) {
			return (BizException) e;
		}
		if (e.getCause() != null) {
			return findBizException(e.getCause());
		}
		return null;
	}

	/**
	 * 序列化结果对象
	 * 
	 * @param resultObj
	 * @param serializeTp
	 * @return
	 */
	private String serializeResult(Object resultObj, String serializeTp, String rootName) {
		String resultStr = null;
		if (SerializeTp.XML.equals(serializeTp)) {
			resultStr = XmlSerializeUtils.serialize(resultObj, rootName);
		} else if (SerializeTp.JSON.equals(serializeTp)) {
			resultStr = JSON.toJSONString(resultObj);
		}
		return resultStr;
	}

	/**
	 * 反序列化参数
	 * 
	 * @param paramStr
	 * @param paramClass
	 * @param serializeTp
	 * @return
	 */
	private <T> T deSerializeParam(String paramStr, Class<T> paramClass, String serializeTp) {
		T paramObj = null;
		if (SerializeTp.XML.equals(serializeTp)) {
			paramObj = XmlSerializeUtils.deSerialize(paramStr, paramClass);
			return paramObj;
		} else if (SerializeTp.JSON.equals(serializeTp)) {
			paramObj = JSON.parseObject(paramStr, paramClass);
		}

		return paramObj;
	}

	/**
	 * 根据接口编码获取接口信息
	 * 
	 * @param itfCode
	 * @return
	 * @throws BizException
	 */
	private EiItfDO getItfInfoByCode(String itfCode) throws BizException {
		IEiitfdoRService eiitfdoRService = ServiceFinder.find(IEiitfdoRService.class);
		EiItfDO[] result = eiitfdoRService.findByAttrValString(EiItfDO.CODE, itfCode);
		if (ArrayUtils.isEmpty(result)) {
			return null;
		}

		if (result.length != 1) {
			String msg = String.format("接口编码重复，根据接口编码\"%s\"查询到%s条注册信息。", itfCode, result.length);
			throw new BizException(msg);
		}
		return result[0];
	}

	/**
	 * 使用用户编码初始化上下文
	 * 
	 * @param userCode 用户编码
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void initContextByUserCode(String userCode) throws BizException {

		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT psndoc.id_psndoc,");
		sqlBuilder.append("sysuser.id_user,");
		sqlBuilder.append("psndoc.id_group as id_grp,");
		sqlBuilder.append("psndoc.id_org ");
		sqlBuilder.append("FROM bd_psndoc psndoc ");
		sqlBuilder.append("inner JOIN sys_user sysuser ");
		sqlBuilder.append("ON sysuser.id_psn = psndoc.id_psndoc ");
		sqlBuilder.append("WHERE sysuser.code = ?");

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(userCode);

		DAFacade daFacade = new DAFacade();
		ArrayList<HashMap<String, Object>> table = (ArrayList<HashMap<String, Object>>) daFacade
				.execQuery(sqlBuilder.toString(), sqlParam, new MapListHandler());

		if (CollectionUtils.isEmpty(table)) {
			String msg = String.format("根据用户编码获取用户信息失败,用户编码:%s。", userCode);
			EiWsLogger.error(msg);
			throw IIHWsException.createExByCode(IIHWsResultCodeConst.Error_Param_UserCode_NOTExist);
		}

		if (table.size() > 1) {
			String msg = String.format("根据用户编码获取到多条用户信息,用户编码:%s,条数:%s。", userCode, table.size());
			EiWsLogger.error(msg);
			throw IIHWsException.createExByCode(IIHWsResultCodeConst.Error_Param_UserCode_Repeat);
		}

		HashMap<String, Object> firstRow = table.get(0);
		Context.get().setStuffId((String) firstRow.get("id_psndoc"));

		Context.get().setGroupId((String) firstRow.get("id_grp"));
		Context.get().setOrgId((String) firstRow.get("id_org"));

		if (firstRow.containsKey("id_user")) {
			Context.get().setUserId((String) firstRow.get("id_user"));
		}
	}
}
