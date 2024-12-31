package iih.ci.ord.s.ems.cache;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.ems.d.EmsDO;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;

/**
 * 医疗单匹配缓存
 * @author wangqingzhu
 *
 */
public class BDMatchEmsInfoCache {
	public static String BDMatchEmsInfoCache_Key = "BDMatchEmsInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	
	private BDMatchEmsInfoCache() {
	}

	public static String PutCache(SrvMatchEmsParamDTO paramDTO,String euofreftp_flag,EmsDO emsDO){
		if (emsDO != null) {
			String key = paramDTO.getId_org() + "|" + paramDTO.getId_grp() + "|" + paramDTO.getCode_entp() + "|" + emsDO.getSd_srvorrt() + "|";
			switch (emsDO.getSd_srvorrt()) {
			case IBdSrvDictCodeConst.SD_OWTP_PERSONAL:
				key += paramDTO.getId_emp();
				break;
			case IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT:
				key += paramDTO.getId_dept();
				break;
			case IBdSrvDictCodeConst.SD_OWTP_HOSPIAL:
				key += "~";
				break;
			}

			if ("0".equals(euofreftp_flag)) {
				key += "|" + paramDTO.getSd_srvtp() + "|~";
			} else if ("1".equals(euofreftp_flag)) {
				key += "|~|" + paramDTO.getId_srv();
			}

			ContextCache.Put(BDMatchEmsInfoCache.class.getSimpleName(), paramDTO.getId_grp(), paramDTO.getId_org(), BDMatchEmsInfoCache_Key, key, emsDO);
			
			return "";
		}
		return euofreftp_flag;
	}


	public static EmsDO GetCache(SrvMatchEmsParamDTO paramDTO){
		List<String> lstKeys = new ArrayList<String>();
		String key = paramDTO.getId_org() + "|" + paramDTO.getId_grp() + "|" + paramDTO.getCode_entp() + "|%s|%s|";
		String[] keys = new String[] { String.format(key, IBdSrvDictCodeConst.SD_OWTP_PERSONAL, paramDTO.getId_emp()),
				String.format(key, IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT, paramDTO.getId_dept()),
				String.format(key, IBdSrvDictCodeConst.SD_OWTP_HOSPIAL, "~") };

		for (int i = 0; i < keys.length; i++) {
			lstKeys.add(keys[i] + "~|" + paramDTO.getId_srv());
			lstKeys.add(keys[i] + paramDTO.getSd_srvtp() + "|~");
		}
		
		for (int i = 0; i < lstKeys.size(); i++) {
			EmsDO emsDO = ContextCache.Get(BDMatchEmsInfoCache.class.getSimpleName(),paramDTO.getId_grp(), paramDTO.getId_org(), BDMatchEmsInfoCache_Key, lstKeys.get(i)) ;//getCache(L2SessionKeyWith(EmsReg_Cache_key), lstKeys.get(i));
			if (emsDO != null) {
				return emsDO;
			}
		}
		
		return null;
	}
	
	public void Clear(){
		ContextCache.Clear(BDMatchEmsInfoCache.class.getSimpleName());
	}
}
