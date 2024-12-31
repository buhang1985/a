package iih.mr.nu.common.bp;

import iih.mr.nu.common.GetResultbysql;
import iih.mr.nu.common.javabean.UdidocJavaBean;
import iih.mr.nu.common.javabean.UdidocJsonDTO;
import iih.mr.nu.common.javabean.UdidoclistIdDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
/**
 * 查询自定义档案拼成Json字符串返回
 * @author Hcst
 *
 */
public class GetUdiJsonBp {

	/**
	 * 主入口
	 * @param fullclassname
	 * @return
	 * @throws Exception
	 */
	public UdidocJsonDTO[] exec(String fullclassname) throws Exception {

		// 1.参数校验
		if (StringUtil.isEmptyWithTrim(fullclassname)) {
			throw new BizException("DO全路径为空");
		}

		// 2.查询出id_udidoclist 的集合
		List<UdidoclistIdDTO> id_udidoclist = getUdidocList(fullclassname);

		// 3.id_udidoclist字符串拼接
		String udiString = getUdiListString(id_udidoclist);

		// 4.根据拼接的档案id字符串查询档案集合
		List<UdidocJavaBean> list = getJavaBeans(udiString);

		// 5.按照档案ID把集合分组
		Map<String, List<UdidocJavaBean>> map = getMap(list);

		// 6.获取档案拼接成Json的集合
		List<String> udiNames = new ArrayList<String>();//档案拼接名称的集合
		String[] strJsonList = udiJson(map, id_udidoclist,udiNames);

		// 7.把json的值赋给JAVABEAN的字段上
		UdidocJsonDTO udidocJsonDTO = getJsonDTO(strJsonList,udiNames);

		return new UdidocJsonDTO[] { udidocJsonDTO };
	}

	/**
	 * 查询实体中所有的档案列表ID
	 * 
	 * @param fullclassname
	 * @return
	 * @throws Exception
	 */
	private List<UdidoclistIdDTO> getUdidocList(String fullclassname) throws Exception {

		StringBuffer strBuffer = new StringBuffer();

		strBuffer.append(" select property.datatype ");
		strBuffer.append(" from dm_property property");
		strBuffer.append(" left join dm_class dmclass on dmclass.id = property.classid");
		strBuffer.append(" inner join dm_class udidmclass on udidmclass.id=property.datatype");
		strBuffer.append(" where dmclass.fullclassname = '" + fullclassname + "'");
		strBuffer.append(" and udidmclass.fullclassname ='xap.sys.xbd.udi.d.UdidocDO'");

		strBuffer.append(" order by seqno");

		GetResultbysql sqlutil = new GetResultbysql();

		@SuppressWarnings("unchecked")
		List<UdidoclistIdDTO> idudiList = (List<UdidoclistIdDTO>) sqlutil.getResultListBySql(strBuffer.toString(), UdidoclistIdDTO.class);

		return idudiList;
	}

	/**
	 * id_udidoclist字符串拼接
	 * 
	 * @param id_udidoclist
	 * @return
	 */
	private String getUdiListString(List<UdidoclistIdDTO> id_udidoclist) {

		if (id_udidoclist != null && id_udidoclist.size() > 0) {
			String udiListString = "";
			for (UdidoclistIdDTO idDTO : id_udidoclist) {

				udiListString += udiListString.length() == 0 ? "'" + idDTO.getDatatype() + "'" : (",'" + idDTO.getDatatype() + "'");
			}
			return udiListString;
		}

		return null;
	}

	/**
	 * 查询档案
	 * 
	 * @param udilistcode
	 * @return
	 * @throws Exception
	 */
	private List<UdidocJavaBean> getJavaBeans(String udilist) throws Exception {

		StringBuffer strSql = new StringBuffer();

		strSql.append(" select udidoc.id_udidoclist,");
		strSql.append(" udidoc.code,");
		strSql.append(" udidoc.name");
		strSql.append(" from bd_udidoc udidoc");
		strSql.append(" left join bd_udidoclist udidoclist on udidoclist.id_udidoclist = udidoc.id_udidoclist");
		strSql.append(" where udidoc.ds=0 and udidoclist.id_udidoclist in (" + udilist + ")");
		strSql.append(" order by udidoc.code ");
		@SuppressWarnings("unchecked")
		List<UdidocJavaBean> list = (List<UdidocJavaBean>) new GetResultbysql().getResultListBySql(strSql.toString(), UdidocJavaBean.class);

		return list;
	}

	/**
	 * 得到档案类型ID和档案的映射
	 * 
	 * @param list
	 * @return
	 */
	private Map<String, List<UdidocJavaBean>> getMap(List<UdidocJavaBean> list) {

		Map<String, List<UdidocJavaBean>> map = new HashMap<String, List<UdidocJavaBean>>();

		for (UdidocJavaBean udidocJavaBean : list) {

			if (map.containsKey(udidocJavaBean.getId_udidoclist())) {
				map.get(udidocJavaBean.getId_udidoclist()).add(udidocJavaBean);
			} else {
				List<UdidocJavaBean> list2 = new ArrayList<UdidocJavaBean>();
				list2.add(udidocJavaBean);
				map.put(udidocJavaBean.getId_udidoclist(), list2);
			}

		}

		return map;
	}

	/**
	 * 返回档案JSON集合
	 * @param map
	 * @param id_udidoclist
	 * @param udiNameStrings 用来装档案拼接name 的集合
	 * @return
	 */
	private String[] udiJson(Map<String, List<UdidocJavaBean>> map, List<UdidoclistIdDTO> id_udidoclist,List<String> udiNameStrings) {
		List<String> strJsonList = new ArrayList<String>();

		for (UdidoclistIdDTO idDTO : id_udidoclist) {
			List<UdidocJavaBean> udidocJavaBeans = map.get(idDTO.getDatatype());

			String json = getJson(udidocJavaBeans);//自定义档案拼接Json
			
			String udiName = getUdiName(udidocJavaBeans);//自定义档案的Name拼接
			
			udiNameStrings.add(udiName);
			
			strJsonList.add(json);
		}
		return strJsonList.toArray(new String[strJsonList.size()]);
	}

	/**
	 * 转为json
	 * 
	 * @param udidocDOs
	 * @return
	 */
	private String getJson(List<UdidocJavaBean> udidocDOs) {

		StringBuilder jsonString = new StringBuilder();
		jsonString.append("{text:'',children:[");

		String s = "";
		for (UdidocJavaBean udidocDO : udidocDOs) {

			String jsconString = "{value:'" + udidocDO.getCode() + "',text:'" + udidocDO.getName() + "'}";
			s += (s.length() == 0 ? jsconString : ("," + jsconString));
		}
		jsonString.append(s);
		jsonString.append("]}");
		return jsonString.toString();
	}


	/**
	 * 档案名称拼接
	 * @param udidocJavaBeans
	 * @return
	 */
	private String getUdiName(List<UdidocJavaBean> udidocJavaBeans) {
	
		String udiName = "";
		for (UdidocJavaBean udidocDO : udidocJavaBeans) {

			udiName += udiName.length()==0?udidocDO.getName():" "+udidocDO.getName();
		
		}
		
		return udiName;
	}

	
	/**
	 * 把json的值赋给JAVABEAN的字段上
	 * 
	 * @param strJsonList
	 * @param udiNames 
	 * @return
	 */
	private UdidocJsonDTO getJsonDTO(String[] strJsonList, List<String> udiNames) {

		String[] udiNameStrings = udiNames.toArray(new String[udiNames.size()]);
		
		UdidocJsonDTO jsonDTO = new UdidocJsonDTO();
		Map<Integer, String> jsonMap = jsonDTO.getJsonMap();
		Map<Integer, String> textMap = jsonDTO.getTextMap();
		for (int i = 0; i < strJsonList.length; i++) {
			jsonMap.put(i + 1, strJsonList[i]);
			textMap.put(i+1, udiNameStrings[i]);
		}

		return jsonDTO;
	}
}
