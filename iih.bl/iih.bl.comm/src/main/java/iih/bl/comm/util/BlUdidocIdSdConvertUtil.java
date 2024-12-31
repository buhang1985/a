package iih.bl.comm.util;

import iih.bd.bc.udi.pub.IBlDictCodeConst;

/**
 * 费用自定档案主键编码转换工具类
 * @author ly 2018/08/09
 *
 */
public class BlUdidocIdSdConvertUtil {

	/**
	 * 终端类型sd-->id
	 * @param sd
	 * @return
	 */
	public static String pttpSdTOId(String sd){
		
		switch (sd) {
		case IBlDictCodeConst.SD_PTTP_WINDOW:
			return IBlDictCodeConst.ID_PTTP_WINDOW;
		case IBlDictCodeConst.SD_PTTP_SELF_TERMINAL:
			return IBlDictCodeConst.ID_PTTP_SELF_TERMINAL;
		case IBlDictCodeConst.SD_PTTP_WEIXIN:
			return IBlDictCodeConst.ID_PTTP_WEIXIN;
		case IBlDictCodeConst.SD_PTTP_PHONE_APP:
			return IBlDictCodeConst.ID_PTTP_PHONE_APP;
		case IBlDictCodeConst.SD_PTTP_SYSTEM:
			return IBlDictCodeConst.ID_PTTP_SYSTEM;
		case IBlDictCodeConst.SD_PTTP_H5:
			return IBlDictCodeConst.ID_PTTP_H5;
		case IBlDictCodeConst.SD_PTTP_ROOM:
			return IBlDictCodeConst.ID_PTTP_ROOM;
		default:
			return null;
		}
	}
	
}
