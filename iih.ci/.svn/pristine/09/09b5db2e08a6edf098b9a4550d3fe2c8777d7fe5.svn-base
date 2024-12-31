package iih.ci.sdk.ems.meta;

import iih.ci.sdk.utils.ObjectUtils;

/**
 * 医保适应症参数定义
 * @author wangqingzhu
 *
 */
public class HpIndicParamInfo {
	// 主服务id
	private String id_srv;
	// 选取物品id
	private String id_mm;

	public HpIndicParamInfo(String id_srv, String id_mm) {
		this.id_srv = id_srv;
		this.id_mm = id_mm;
	}

	public String getId_srv() {
		return id_srv;
	}

	public void setId_srv(String id_srv) {
		this.id_srv = id_srv;
	}

	public String getId_mm() {
		return id_mm;
	}

	public void setId_mm(String id_mm) {
		this.id_mm = id_mm;
	}

	public static String MedSrvHpParam_Key(String id_srv, String id_mm) {
		if (ObjectUtils.isEmpty(id_mm)) {
			return String.format("%s", id_srv);
		} else {
			return String.format("%s-%s", id_srv, id_mm);
		}
	}
}
