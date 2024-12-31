package iih.ei.itf.itftest.s.bp;

import java.lang.reflect.Method;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Node;

import iih.bd.utils.XmlSerializeUtils;
import iih.ei.itf.eiitfdo.d.EiItfDO;
import iih.ei.itf.eiitfdo.i.IEiitfdoRService;
import iih.ei.itf.itftest.d.EiItfTransferInfoDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

public class GetItfTransferInfoBp {

	public EiItfTransferInfoDTO exec(String itfId) throws BizException {

		IEiitfdoRService itfRService = ServiceFinder.find(IEiitfdoRService.class);
		EiItfDO itfDo = itfRService.findById(itfId);

		EiItfTransferInfoDTO transInfoDto = new EiItfTransferInfoDTO();
		transInfoDto.setId_itf(itfDo.getId_itf());
		transInfoDto.setCode(itfDo.getCode());
		transInfoDto.setName(itfDo.getName());
		transInfoDto.setFullname(itfDo.getFullname());
		transInfoDto.setMethodname(itfDo.getMethodname());

		Class<?> paramType = getInParamType(transInfoDto.getFullname(), transInfoDto.getMethodname());

		BuildItfParamTempXmlBp bp = new BuildItfParamTempXmlBp();
		String request = bp.exec(paramType, BuildItfParamTempXmlBp.PARAMTYPE_IN);

		Document xmlDocument = null;
		if (StringUtils.isNotBlank(request)) {
			try {
				xmlDocument = XmlSerializeUtils.createXmlDocument(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (xmlDocument != null) {
			Node userCodeNode = xmlDocument.selectSingleNode("iihparam/Code_user");
			if (userCodeNode != null) {
				String userId = Context.get().getUserId();
				IUserRService userRService = ServiceFinder.find(IUserRService.class);
				UserDO userDo = userRService.findById(userId);
				if (userDo != null) {
					userCodeNode.setText(userDo.getCode());
				}
			}

			Node depCodeNode = xmlDocument.selectSingleNode("iihparam/Code_dep");
			if (depCodeNode != null) {
				String depId = Context.get().getDeptId();
				IDeptRService depRService = ServiceFinder.find(IDeptRService.class);
				DeptDO depDo = depRService.findById(depId);
				if (depDo != null) {
					depCodeNode.setText(depDo.getCode());
				}
			}

			Node exCodeNode = xmlDocument.selectSingleNode("iihparam/Code_external");
			if (exCodeNode != null) {
				exCodeNode.setText("IIH");
			}

			try {
				request = XmlSerializeUtils.write(xmlDocument);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		transInfoDto.setRequest(request);

		return transInfoDto;
	}

	private Class<?> getInParamType(String fullName, String methodName) throws BizException {
		Class<?> itfClass = null;
		try {
			itfClass = Class.forName(fullName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (itfClass == null) {
			String msg = String.format("获取接口失败，全类名:%s.", fullName);
			throw new BizException(msg);
		}

		Method[] metdods = itfClass.getMethods();
		if (ArrayUtils.isEmpty(metdods)) {
			String msg = String.format("获取接口中方法失败，全类名:%s,方法名:%s.", fullName, methodName);
			throw new BizException(msg);
		}

		Method itfMethod = null;
		for (Method method : metdods) {
			if (method.getName().equals(methodName)) {
				itfMethod = method;
				break;
			}
		}
		if (itfMethod == null) {
			String msg = String.format("获取接口中方法失败，全类名:%s,方法名:%s.", fullName, methodName);
			throw new BizException(msg);
		}
		Class<?> paramType = getInParamType(itfMethod);

		return paramType;
	}

	/**
	 * 获取入参类型
	 * 
	 * @param method
	 * @return
	 */
	private Class<?> getInParamType(Method method) {
		Class<?>[] paramTypes = method.getParameterTypes();

		if (ArrayUtils.isEmpty(paramTypes) || !BaseDO.class.isAssignableFrom(paramTypes[0])) {
			return null;
		}

		return paramTypes[0];
	}
}
