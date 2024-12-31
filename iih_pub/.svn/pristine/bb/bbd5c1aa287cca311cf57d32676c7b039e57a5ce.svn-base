package iih.mi.biz.dto.d;

import java.util.HashSet;
import java.util.Set;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BeanHelper;

public class DTOParmPrintUtil {
	public static void main(String[] args) {
		InpPayInParamDTO d = new InpPayInParamDTO();
		String[]aa=getAttributeAryNoMetaData(d);
		for (String a : aa) {
			System.out.println("public static final String "+a.toUpperCase()+"= \""+(a.substring(0,1).toUpperCase()+a.substring(1))+"\";");
		}
	}
	
	public static String[] getAttributeAryNoMetaData(BaseDO do1) {
		String[] arys = null;
					Set<String> set = new HashSet<String>();
					String[] strAry = BeanHelper.getInstance().getPropArr(do1);
					String pkFieldName = do1.getPKFieldName()==null?null:do1.getPKFieldName().toLowerCase();
					if (pkFieldName != null) {
						set.add(pkFieldName);
					}

					for (String str : strAry) {
						if (!(str.equals("status") || str.equals("dirty")
								|| str.equals("pkval") || str.equals(pkFieldName))) {
							set.add(str);
						}
					}
					arys = set.toArray(new String[set.size()]);
		return arys;
	}
}
