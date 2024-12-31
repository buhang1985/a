package iih.ci.ord.dto.mergetube.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;
/**
 * 合管结果值状态
 * @author zhangwq
 *
 */
public interface MergeTubeRstEnum {
	@DmEnumDesc(name="正常",description="正常")
	public static final String SUCCESS="0"; //正常
	@DmEnumDesc(name="异常",description="异常")
	public static final String FAIL="1"; //异常
}
