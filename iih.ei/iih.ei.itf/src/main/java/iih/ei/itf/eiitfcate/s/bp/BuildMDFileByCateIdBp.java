package iih.ei.itf.eiitfcate.s.bp;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.DoUtils;
import iih.ei.itf.eiitfcate.d.EiItfCateDO;
import iih.ei.itf.eiitfcate.i.IEiitfcateRService;
import iih.ei.itf.eiitfcateitm.d.ItfCateItmDO;
import iih.ei.itf.eiitfcateitm.i.IEiitfcateitmRService;
import iih.ei.itf.eiitfdo.d.EiItfDO;
import iih.ei.itf.eiitfdo.i.IEiitfdoRService;
import iih.ei.itf.itftest.s.bp.BuildItfParamTempXmlBp;
import xap.dp.dmengine.d.PropertyDO;
import xap.dp.dmengine.s.MdCachePoolProxy;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.UdidoclistDO;
import xap.sys.xbd.udi.d.desc.UdidocDODesc;

/**
 * 使用接口分类构建MD文件
 * 
 * @author hao_wu 2019-10-30
 *
 */
public class BuildMDFileByCateIdBp {

	public byte[] exec(String itfCateId) throws BizException {
		IEiitfcateRService eiitfcateRService = ServiceFinder.find(IEiitfcateRService.class);
		EiItfCateDO itfCateDo = eiitfcateRService.findById(itfCateId);

		EiItfDO[] itfDos = null;
		IEiitfcateitmRService iEiitfcateitmRService = ServiceFinder.find(IEiitfcateitmRService.class);
		ItfCateItmDO[] itms = iEiitfcateitmRService.findByAttrValString(ItfCateItmDO.ID_ITFCATE, itfCateId);
		if (ArrayUtils.isNotEmpty(itms)) {
			String[] itfIds = DoUtils.getAttrValArr(itms, ItfCateItmDO.ID_ITF, String.class);
			IEiitfdoRService itfRService = ServiceFinder.find(IEiitfdoRService.class);
			itfDos = itfRService.findByIds(itfIds, FBoolean.FALSE);
		}

		if (ArrayUtils.isEmpty(itfDos)) {
			String msg = String.format("分类%s(%s)下不存在接口，无法导出。", itfCateDo.getName(), itfCateDo.getCode());
			throw new BizException(msg);
		}

		Arrays.sort(itfDos, new Comparator<EiItfDO>() {

			@Override
			public int compare(EiItfDO paramT1, EiItfDO paramT2) {
				return paramT1.getCode().compareToIgnoreCase(paramT2.getCode());
			}
		});

		return build(itfCateDo, itfDos);
	}

	private byte[] build(EiItfCateDO itfCateDo, EiItfDO[] itfDos) throws BizException {
		MDFileBuilder builder = new MDFileBuilder();

		builder.appendH1(itfCateDo.getName());

		buildItfs(builder, itfDos);

		return builder.toBytes();
	}

	/**
	 * 构建接口文档
	 * 
	 * @param builder
	 * @param itfDos
	 * @throws BizException
	 */
	private void buildItfs(MDFileBuilder builder, EiItfDO[] itfDos) throws BizException {
		if (ArrayUtils.isEmpty(itfDos)) {
			return;
		}

		for (int i = 0; i < itfDos.length; i++) {
			EiItfDO itfDo = itfDos[i];
			try {
				buildItf(builder, itfDos[i], i + 1);
			} catch (Exception e) {
				String msg = String.format("构建接口文档错误,接口编码:%s.", itfDo.getCode());
				throw new BizException(msg, e);
			}

		}
	}

	private void buildItf(MDFileBuilder builder, EiItfDO eiItfDO, int sortNo) throws BizException {
		EiItfDO itfDo = eiItfDO;

		String title = String.format("%s %s %s", sortNo, itfDo.getCode(), itfDo.getName());
		builder.appendH2(title);

		double chapterNum = sortNo;

		title = String.format("%.1f 接口信息", chapterNum += 0.1);
		builder.appendH3(title);

		if (FBoolean.FALSE.equals(eiItfDO.getFg_active())) {
			builder.appendText("★警告：接口已停用");
		}

		String[][] itfInfoTable = new String[2][2];
		itfInfoTable[0] = new String[] { "接口编码", "接口名称" };
		itfInfoTable[1] = new String[] { itfDo.getCode(), itfDo.getName() };
		builder.appendTable(itfInfoTable);

		title = String.format("%.1f 详细说明", chapterNum += 0.1);
		builder.appendH3(title);
		builder.appendText(itfDo.getDes());

		Method method = getMethod(itfDo);
		Class<?> inParamType = getInParamType(method);
		Class<?> outParamType = method.getReturnType();

		BuildItfParamTempXmlBp bp = new BuildItfParamTempXmlBp();
		String paramXml = bp.exec(inParamType, BuildItfParamTempXmlBp.PARAMTYPE_IN);
		if (StringUtils.isNotBlank(paramXml)) {
			title = String.format("%.1f 入参示例", chapterNum += 0.1);
			builder.appendH3(title);

			builder.appendCode(MDFileBuilder.CODE_TYPE_XML, paramXml);
		}

		paramXml = bp.exec(outParamType, BuildItfParamTempXmlBp.PARAMTYPE_OUT);
		if (StringUtils.isNotBlank(paramXml)) {
			title = String.format("%.1f 出参示例", chapterNum += 0.1);
			builder.appendH3(title);
			builder.appendCode(MDFileBuilder.CODE_TYPE_XML, paramXml);
		}

		if (inParamType != null && BaseDO.class.isAssignableFrom(inParamType)
				&& !Modifier.isAbstract(inParamType.getModifiers())) {

			Map<String, String[][]> paramDesMap = new LinkedHashMap<String, String[][]>();
			getTypeDes(paramDesMap, inParamType);

			if (paramDesMap.size() > 0) {
				title = String.format("%.1f 入参说明", chapterNum += 0.1);
				builder.appendH3(title);

				for (String type : paramDesMap.keySet()) {
					String[][] paramDes = paramDesMap.get(type);
					if (type.equals(inParamType.getSimpleName())) {
						type = "Data";
					}
					builder.appendH4(type);
					builder.appendTable(paramDes);
				}
			}
		}

		if (outParamType != null && BaseDO.class.isAssignableFrom(outParamType)
				&& !Modifier.isAbstract(outParamType.getModifiers())) {

			Map<String, String[][]> paramDesMap = new LinkedHashMap<String, String[][]>();
			getTypeDes(paramDesMap, outParamType);

			if (paramDesMap.size() > 0) {
				title = String.format("%.1f 出参说明", chapterNum += 0.1);
				builder.appendH3(title);

				for (String type : paramDesMap.keySet()) {
					String[][] paramDes = paramDesMap.get(type);
					if (type.equals(outParamType.getSimpleName())) {
						type = "Data";
					}
					builder.appendH4(type);
					builder.appendTable(paramDes);
				}
			}
		}
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

	/**
	 * 获取类型描述
	 * 
	 * @param paramDesMap
	 * @param dataType
	 * @throws BizException
	 */
	private void getTypeDes(Map<String, String[][]> paramDesMap, Class<?> dataType) throws BizException {
		if (dataType == null || !BaseDTO.class.isAssignableFrom(dataType)) {
			return;
		}

		PropertyDO[] propDos = MdCachePoolProxy.getInstance().getPropertyDOsByEntityName(dataType.getName());
		if (ArrayUtils.isEmpty(propDos)) {
			return;
		}
		propDos = this.sortPropDos(propDos);

		ArrayList<PropertyDO> propList = new ArrayList<PropertyDO>();
		for (PropertyDO propertyDO : propDos) {
			if (!FBoolean.TRUE.equals(propertyDO.getIsnotserialize())) {
				propList.add(propertyDO);
			}
		}

		String[][] paramDes = new String[propList.size() + 1][6];
		paramDes[0] = new String[] { "序号", "参数", "名称", "类型", "是否可空", "备注" };
		for (int i = 0, sortNo = 1; i < propList.size(); i++, sortNo++) {
			PropertyDO propDo = propList.get(i);
			String[] propDes = this.getPropDes(propDo, sortNo, dataType);
			paramDes[sortNo] = propDes;
		}
		paramDesMap.put(dataType.getSimpleName(), paramDes);

		getChildTypeDes(paramDesMap, dataType);

	}

	/**
	 * 获取子类型描述
	 * 
	 * @param paramDesMap
	 * @param dataType
	 * @throws BizException
	 */
	private void getChildTypeDes(Map<String, String[][]> paramDesMap, Class<?> dataType) throws BizException {
		PropertyDO[] propDos = MdCachePoolProxy.getInstance().getPropertyDOsByEntityName(dataType.getName());

		sortPropDos(propDos);

		for (PropertyDO propertyDO : propDos) {
			if (FBoolean.TRUE.equals(propertyDO.getIsnotserialize())) {
				continue;
			}

			String subFullClassName = MdCachePoolProxy.getInstance()
					.getSubFullClassNameByEntityProperty(dataType.getName(), propertyDO.getName());
			if (StringUtils.isBlank(subFullClassName)) {
				continue;
			}

			Class<?> subClass = null;
			try {
				subClass = Class.forName(subFullClassName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			if (subClass == null) {
				continue;
			}
			if (paramDesMap.containsKey(subClass.getSimpleName())) {
				continue;
			}

			if (subClass.isInterface()) {
				// 枚举
				String[][] enumDes = getEnumDes(subClass);
				if (enumDes != null) {
					paramDesMap.put(subClass.getSimpleName(), enumDes);
				}
				continue;
			}

			if (UdidocDO.class.isAssignableFrom(subClass)) {
				// 自定义档案
				String udidocListId = (propertyDO.getDatatype());
				Map<String, String[][]> udidocDes = getUdidocDes(udidocListId);
				if (udidocDes != null) {
					paramDesMap.putAll(udidocDes);
				}
				continue;
			}
			if (BaseDTO.class.isAssignableFrom(dataType)) {
				// 嵌套DTO
				getTypeDes(paramDesMap, subClass);
				continue;
			}
		}
	}

	/**
	 * 获取档案描述
	 * 
	 * @param udidocListId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, String[][]> getUdidocDes(String udidocListId) throws BizException {
		DAFacade daFacade = new DAFacade();
		UdidoclistDO udidoclistDO = (UdidoclistDO) daFacade.findByPK(UdidoclistDO.class, udidocListId);
		if (udidoclistDO == null) {
			return null;
		}

		String wherePart = "id_udidoclist = ? and ds = 0 and activestate = ?";
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(udidocListId);
		sqlParam.addParam(ActiveStateEnum.ACTIVE);
		List<UdidocDO> udidocList = (List<UdidocDO>) daFacade.findByCond(UdidocDO.class, wherePart, "code",
				new String[] { UdidocDO.CODE, UdidocDO.NAME }, sqlParam);

		UdidocDO[] udidocs = udidocList.toArray(new UdidocDO[0]);
		Arrays.sort(udidocs, new Comparator<UdidocDO>() {
			@Override
			public int compare(UdidocDO paramT1, UdidocDO paramT2) {
				return paramT1.getCode().compareToIgnoreCase(paramT2.getCode());
			}
		});

		String[][] udidocDes = new String[udidocs.length + 1][3];
		udidocDes[0] = new String[] { "编码", "名称", "描述" };

		for (int i = 0; i < udidocs.length; i++) {
			UdidocDO udidocDo = udidocs[i];
			udidocDes[i + 1][0] = udidocDo.getCode();
			udidocDes[i + 1][1] = udidocDo.getName();
		}

		String title = String.format("档案：%s", udidoclistDO.getCode());
		LinkedHashMap<String, String[][]> desMap = new LinkedHashMap<>();
		desMap.put(title, udidocDes);
		return desMap;
	}

	private String[][] getEnumDes(Class<?> dataType) {
		// 获取所有的字段
		Field[] fields = dataType.getDeclaredFields();
		if (ArrayUtils.isEmpty(fields)) {
			return null;
		}

		List<Field> enumFieldList = new ArrayList<>();
		for (Field field : fields) {
			// 判断字段注解是否存在
			boolean isEnum = field.isAnnotationPresent(DmEnumDesc.class);
			if (isEnum) {
				enumFieldList.add(field);
			}
		}

		if (enumFieldList.size() <= 0) {
			return null;
		}

		String[][] enumDes = new String[enumFieldList.size() + 1][4];
		enumDes[0] = new String[] { "编码", "名称", "值", "描述" };

		for (int i = 0; i < enumFieldList.size(); i++) {
			Field field = enumFieldList.get(i);
			DmEnumDesc enumDesc = field.getAnnotation(DmEnumDesc.class);
			// 获取注解值
			String name = enumDesc.name();
			String des = enumDesc.description();

			String code = field.getName();
			String value = null;

			try {
				Class<?> fieldType = field.getType();
				if (String.class.equals(fieldType)) {
					value = (String) field.get(null);
				} else if (Integer.class.equals(fieldType)) {
					value = ((Integer) field.get(null)).toString();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			enumDes[i + 1] = new String[] { code, name, value, des };
		}
		return enumDes;
	}

	/**
	 * 获取属性描述
	 * 
	 * @param propDo
	 * @param sortNo
	 * @param type
	 * @return
	 * @throws BizException
	 */
	private String[] getPropDes(PropertyDO propDo, int sortNo, Class<?> type) throws BizException {
		String[] propDes = new String[6];
		propDes[0] = String.valueOf(sortNo);
		String propName = propDo.getName();
		propDes[1] = String.format("%s%s", propName.substring(0, 1).toUpperCase(),
				propName.subSequence(1, propName.length()));
		propDes[2] = propDo.getDisplayname();
		propDes[3] = propDo.getDatatype();
		propDes[4] = propDo.getIsnullable().toString();
		propDes[5] = propDo.getDescription();

		String subFullClassName = MdCachePoolProxy.getInstance().getSubFullClassNameByEntityProperty(type.getName(),
				propDo.getName());
		if (StringUtils.isNotBlank(subFullClassName)) {
			if (FBoolean.class.getName().equals(subFullClassName)) {
				propDes[3] = "String";
				propDes[5] = StringUtils.isBlank(propDes[5]) ? "[Y,N]" : String.format("[Y,N] %s", propDes[5]);
			} else if (FDateTime.class.getName().equals(subFullClassName)) {
				propDes[3] = "String";
				propDes[5] = StringUtils.isBlank(propDes[5]) ? "格式:yyyy-MM-dd HH:mm:ss" : String.format("格式:yyyy-MM-dd HH:mm:ss %s", propDes[5]);
			}else if (FDate.class.getName().equals(subFullClassName)) {
				propDes[3] = "String";
				propDes[5] = StringUtils.isBlank(propDes[5]) ? "格式:yyyy-MM-dd" : String.format("格式:yyyy-MM-dd %s", propDes[5]);
			} else if (UdidocDODesc.CLASS_FULLNAME.equals(subFullClassName)) {

				propDes[3] = "String";
				DAFacade daFacade = new DAFacade();
				UdidoclistDO udidocDo = (UdidoclistDO) daFacade.findByPK(UdidoclistDO.class, propDo.getDatatype(),
						new String[] { UdidoclistDO.CODE });
				String des = String.format("档案：%s", udidocDo.getCode());
				propDes[5] = String.format("%s %s", des, StringUtils.isNotBlank(propDes[5]) ? propDes[5] : "");
			} else {
				String[] strs = subFullClassName.split("\\.");
				propDes[3] = strs[strs.length - 1];
			}
		}

		return propDes;
	}

	/**
	 * 按照属性序号排序
	 * 
	 * @param propertyDOs
	 * @return
	 */
	private PropertyDO[] sortPropDos(PropertyDO[] propertyDOs) {
		Arrays.sort(propertyDOs, new Comparator<PropertyDO>() {

			@Override
			public int compare(PropertyDO o1, PropertyDO o2) {
				if (o2.getSeqno() != null && o1.getSeqno() != null) {
					return o1.getSeqno() - o2.getSeqno();
				}
				return 0;
			}

		});
		return propertyDOs;
	}

	/**
	 * 获取接口方法
	 * 
	 * @param itfDo 接口信息
	 * @return
	 */
	private Method getMethod(EiItfDO itfDo) {
		String fullName = itfDo.getFullname();
		String methodName = itfDo.getMethodname();
		Class<?> itfClass;
		try {
			itfClass = Class.forName(fullName);
		} catch (ClassNotFoundException e) {
			return null;
		}
		Method[] methods = itfClass.getMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				return method;
			}
		}
		return null;
	}
}
