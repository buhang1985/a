package iih.bd.srv.medsrv.d;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;

/**
 * 医疗服务属性映射<br/>
 * 支持按照就诊类型编码获取属性名称
 * 
 * @author hao_wu 2020-1-8
 *
 */
public class MedSrvAttrMaping {

	/**
	 * 根据就诊类型编码获取可用属性名称
	 * 
	 * @param entpCode 就诊类型编码
	 * @return
	 */
	public static String getUseAttrName(String entpCode) {
		String attrName = null;
		switch (entpCode) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
			attrName = MedSrvDO.FG_USE_OP;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:
			attrName = MedSrvDO.FG_USE_ER;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:
			attrName = MedSrvDO.FG_USE_ER1;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:
			attrName = MedSrvDO.FG_USE_ER2;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
			attrName = MedSrvDO.FG_USE_IP;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
			attrName = MedSrvDO.FG_USE_PE;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
			attrName = MedSrvDO.FG_USE_FM;
			break;
		default:
			break;
		}
		return attrName;
	}

	/**
	 * 根据就诊类型编码获取加急属性名称
	 * 
	 * @param entpCode 就诊类型编码
	 * @return
	 */
	public static String getUrgentAttrName(String entpCode) {
		String attrName = null;
		switch (entpCode) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
			attrName = MedSrvDO.FG_URGENT_OP;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:
			attrName = MedSrvDO.FG_URGENT_ER;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:
			attrName = MedSrvDO.FG_URGENT_ER1;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:
			attrName = MedSrvDO.FG_URGENT_ER2;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
			attrName = MedSrvDO.FG_URGENT_IP;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
			attrName = MedSrvDO.FG_URGENT_PE;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
			attrName = MedSrvDO.FG_URGENT_FM;
			break;
		default:
			break;
		}
		return attrName;
	}

	/**
	 * 根据就诊类型编码获取默认加急属性名称
	 * 
	 * @param entpCode 就诊类型编码
	 * @return
	 */
	public static String getDefUrgentAttrName(String entpCode) {
		String attrName = null;
		switch (entpCode) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
			attrName = MedSrvDO.FG_URGENT_DEF_OP;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:
			attrName = MedSrvDO.FG_URGENT_DEF_ER;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:
			attrName = MedSrvDO.FG_URGENT_DEF_ER1;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:
			attrName = MedSrvDO.FG_URGENT_DEF_ER2;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
			attrName = MedSrvDO.FG_URGENT_DEF_IP;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
			attrName = MedSrvDO.FG_URGENT_DEF_PE;
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
			attrName = MedSrvDO.FG_URGENT_DEF_FM;
			break;
		default:
			break;
		}
		return attrName;
	}
}
