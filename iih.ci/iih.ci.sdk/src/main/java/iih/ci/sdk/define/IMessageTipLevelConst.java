package iih.ci.sdk.define;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

/**
 * 信息提示等级定义
 * @author wangqingzhu
 *
 */
public interface IMessageTipLevelConst {
	@DmEnumDesc(name="确认信息提示",description="只有确认按钮的信息提示")
    public static final String IMTL_Information_Yes="Yes"; 
	@DmEnumDesc(name="确认取消信息提示",description="确认按钮的信息提示")
    public static final String IMTL_Information_YesNo="YesNo"; // 医疗单
	@DmEnumDesc(name="状态栏信息提示",description="确认按钮的信息提示")
    public static final String IMTL_Information_Tip="Tip"; 
	@DmEnumDesc(name="自定义信息提示",description="确认按钮的信息提示")
    public static final String IMTL_Information_Ctm="Ctm"; 
}
