package iih.syn.common.syninitapp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumApp {

    @DmEnumDesc(name="新建",description="新建")
	public static final Integer NEW=0; //新建
    @DmEnumDesc(name="提交",description="提交")
	public static final Integer SUBMIT=1; //提交
    @DmEnumDesc(name="审批通过",description="审批通过")
	public static final Integer ACCESS=2; //审批通过
    @DmEnumDesc(name="驳回",description="驳回")
	public static final Integer REJECT=3; //驳回
    @DmEnumDesc(name="下载完成",description="下载完成")
	public static final Integer DOWNLOAD=4; //下载完成
}	
