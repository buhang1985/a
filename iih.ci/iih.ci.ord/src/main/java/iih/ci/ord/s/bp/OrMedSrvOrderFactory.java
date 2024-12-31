package iih.ci.ord.s.bp;
/**
 * @code 单例工厂
 */
import org.apache.commons.lang3.StringUtils;
import iih.ci.ord.pub.CiOrdUtils;

public class OrMedSrvOrderFactory {
	private String paramCode="WW_CIOR0004";
	private static OrMedSrvOrderFactory  orMedSrvOrderFactory;
	private GetAbsMedSrvScBindMMBP bp;
	private OrMedSrvOrderFactory(){
	}
	public static OrMedSrvOrderFactory getInstance(){
		if(orMedSrvOrderFactory==null){
			orMedSrvOrderFactory = new OrMedSrvOrderFactory();
		}
		return orMedSrvOrderFactory;
	}
	public GetAbsMedSrvScBindMMBP getOrMedSrvQuery() {
		if(bp!=null){
			return bp;
		}
		// 获得临床住院参照默认值设置插件
		String pluginStr = null;
		try {
			pluginStr = CiOrdUtils.getOrgParamStr(paramCode);
		} catch (Exception e1) {
			bp = new GetMedSrvScBindMMBP();
		}
		// 空判断
		if (StringUtils.isEmpty(pluginStr))
			 bp = new GetMedSrvScBindMMBP();
		try {
			Class<?> c = Class.forName(pluginStr);
			bp =  (GetAbsMedSrvScBindMMBP) c.newInstance();
		} catch (Exception e) {
			bp = new GetMedSrvScBindMMBP();
		}
		return bp;
	}
}

